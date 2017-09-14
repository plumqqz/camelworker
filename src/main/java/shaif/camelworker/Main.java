/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shaif.camelworker;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author if
 */
class Main {
    private JdbcTemplate jt;
    private Main self;
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    public void run() throws InterruptedException, Exception{
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public void setSelf(Main self) {
        this.self = self;
    }

    public void setLog(Logger log) {
        this.log = log;
    }
}
