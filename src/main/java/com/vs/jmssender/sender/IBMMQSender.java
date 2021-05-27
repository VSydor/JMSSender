package com.vs.jmssender.sender;

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import com.vs.jmssender.model.ConnectionProperties;
import org.springframework.stereotype.Component;

import javax.jms.Connection;
import javax.jms.JMSException;

@Component
public class IBMMQSender extends JMSSender {

    @Override
    protected Connection createConnection(ConnectionProperties connectionProperties) throws JMSException {
        JmsFactoryFactory jmsFactoryFactory = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
        JmsConnectionFactory connectionFactory = jmsFactoryFactory.createConnectionFactory();

        connectionFactory.setStringProperty(WMQConstants.WMQ_HOST_NAME, connectionProperties.getHost());
        connectionFactory.setIntProperty(WMQConstants.WMQ_PORT, connectionProperties.getPort());
        connectionFactory.setStringProperty(WMQConstants.WMQ_CHANNEL, connectionProperties.getChannel());
        connectionFactory.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
        connectionFactory.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, connectionProperties.getQueueManager());

        String username = connectionProperties.getUsername();
        String password = connectionProperties.getPassword();

        return connectionFactory.createConnection(username, password);
    }

}
