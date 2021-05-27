package com.vs.jmssender.sender;

import com.vs.jmssender.model.ConnectionProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import static org.apache.activemq.ActiveMQConnection.DEFAULT_BROKER_URL;

@Slf4j
@Component
public class ActiveMQSender extends JMSSender {

    @Override
    protected Connection createConnection(ConnectionProperties connectionProperties) throws JMSException {
        //ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username, password, host + ":" + port);
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);
        return connectionFactory.createConnection();
    }

}
