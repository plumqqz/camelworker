/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shaif.camelworker.beans;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import shaif.camelworker.exceptions.ApplicationException;
import shaif.camelworker.exceptions.FatalLocalApplicationException;
import shaif.camelworker.exceptions.PermanentApplicationException;
import shaif.camelworker.exceptions.PermanentLocalApplicationException;
import shaif.camelworker.exceptions.PermanentRemoteApplicationException;
import shaif.camelworker.exceptions.TransientApplicationException;
import shaif.camelworker.exceptions.TransientRemoteApplicationException;
import shaif.camelworker.exceptions.UnknownApplicationException;
import shaif.camelworker.exceptions.UnknownRemoteApplicationException;

/**
 *
 * @author if
 */
@Service
public class HandleMessage {
    private JdbcTemplate jt;
    private ProducerTemplate pt;
    private RestTemplate rt;
    
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    public void handle(String body){
        logger.error(body);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void modifyMessage(Message msg){
        String body = msg.getBody(String.class);
        StringBuilder sb = new StringBuilder(body);
        sb.append("<<<<");
        jt.update("insert into tt(val) values(?)", sb);
        pt.sendBody("jms:topic:notifyAll?transacted=true", sb);
        msg.setBody(sb);
    }
    
    @Transactional(propagation = Propagation.NESTED)
    public void notifyAll(Exchange exch){
        logger.warn("Get notify:{}", exch.getIn().getBody().toString());
        try{
            exch.getOut().setBody(doWork(exch.getIn().getBody(String.class)), String.class);
        }catch(ApplicationException ex){
            switch(ex.getErrorKind()){
                case Fatal:
                    throw new RuntimeException("Got fatal exception", ex);
                case Permanent:
                    pt.send("jms:broken?transacted=true", exch);            
                    break;
                case Transient:
                    pt.send("jms:delayed?transacted=true", exch);
                    break;
                case Unknown:
                    pt.send("jms:inDoubt?transacted=true", exch);
                    break;
            }
        }
    }
    
    private String doWork(String s) throws ApplicationException{
        try{            
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-type", "text/html");
            HttpEntity he = new HttpEntity<>(headers);
            ResponseEntity<String> responce = rt.exchange("https://www.mail.ru", HttpMethod.GET, he, String.class);
            return ">>>" + s + "<<<<<<"+responce.getBody();
        }catch(RestClientException ex){
            throw ApplicationException.handleRestClientException(ex);
        }
    }

    
    public JdbcTemplate getJt() {
        return jt;
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public ProducerTemplate getPt() {
        return pt;
    }

    public void setPt(ProducerTemplate pt) {
        this.pt = pt;
    }

    public RestTemplate getRt() {
        return rt;
    }

    public void setRt(RestTemplate rt) {
        this.rt = rt;
    }
}
