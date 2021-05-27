package com.vs.jmssender;

import com.vs.jmssender.configuration.JmsQueuesConfiguration;
import com.vs.jmssender.sender.ActiveMQSender;
import com.vs.jmssender.sender.IBMMQSender;
import com.vs.jmssender.sender.JMSSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import static com.vs.jmssender.constant.Environments.LOCAL;

@SpringBootApplication
@EnableConfigurationProperties(JmsQueuesConfiguration.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    public static void main(String[] args) {
//
//        //failover://tcp://localhost:61616
//
//        try {
//            String queueName = HIT_QUEUE_NAME;
//            String environment = DEV;
//
//            getSender(environment).send("payload here", queueName, environment);
//
//        } catch (Exception e) {
//            System.out.println("Failed to send JMS message!");
//            e.printStackTrace();
//        }
//    }

    // TODO: find a better way of doing this
    private static JMSSender getSender(String environment) {
        return LOCAL == environment ? new ActiveMQSender() : new IBMMQSender();
    }

}
