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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author if
 */
@Service
public class HandleMessage {
    private JdbcTemplate jt;
    private ProducerTemplate pt;
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
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void notifyAll(Exchange exch){
        logger.warn("Get notify:{}", exch.getIn().getBody().toString());
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
}
