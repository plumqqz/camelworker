/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shaif.camelworker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author if
 */
public class Runner {
    private static String[] args;
    public static void main(String[] args) throws IOException, InterruptedException, Exception{
        Logger log = LoggerFactory.getLogger(Runner.class);
        Runner.args = args;
        log.debug("args are {}", String.join(" ", args));

        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        log.debug("Application context is created");
        CommandLineBean clb = ctx.getBean("args", CommandLineBean.class);
/*        org.apache.camel.spring.Main main = new org.apache.camel.spring.Main();
        main.setApplicationContext((AbstractApplicationContext) ctx);
        main.
        main.run();
*/
    }

    public static String[] getArgs() {
        return args;
    }
}
