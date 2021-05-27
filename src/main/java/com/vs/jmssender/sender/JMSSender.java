package com.vs.jmssender.sender;

import com.vs.jmssender.configuration.JmsQueuesConfiguration;
import com.vs.jmssender.model.ConnectionProperties;
import com.vs.jmssender.model.QueueConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.jms.*;
import java.util.Map;
import java.util.Objects;

@Slf4j
public abstract class JMSSender {

    @Autowired
    protected JmsQueuesConfiguration jmsQueuesConfiguration;

    public void send(String queueAlias, String environment, String payload) throws JMSException {
        log.info("Sending message to {}:{}", queueAlias, environment);
        QueueConfiguration queueConfiguration = jmsQueuesConfiguration.getQueueConfiguration(queueAlias);
        if (Objects.isNull(queueConfiguration)) {
            throw new IllegalArgumentException("Could not find configuration for " +
                    "queue alias " + queueAlias + "!");
        }

        ConnectionProperties connectionProperties = queueConfiguration.getConnectionProperties(environment);
        if (Objects.isNull(connectionProperties)) {
            throw new IllegalArgumentException("Could not find connection properties for " +
                    "queueAlias " + queueAlias + " and environment " + environment + "!");
        }
        log.info("Got connection properties: {}", connectionProperties);

        Connection connection = null;
        Session session = null;

        try {
            connection = createConnection(connectionProperties);
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(queueConfiguration.getName());

            Message message = session.createTextMessage(payload);

            Map<String, Object> messageProperties = getMessageProperties(queueAlias);
            addMessageProperties(message, messageProperties);

            log.info("Sending message: " + message);

            MessageProducer producer = session.createProducer(queue);
            producer.send(message);

            log.info("Message sent!");

        } catch (JMSException e) {
            log.error("Failed to send JMS message! {}", e.getMessage());
            throw e;
        } finally {
            closeConnection(session, connection);
        }
    }

    protected abstract Connection createConnection(ConnectionProperties connectionProperties) throws JMSException;

    protected void closeConnection(Session session, Connection connection) {
        try {
            if (Objects.nonNull(session)) {
                session.close();
            }
            if (Objects.nonNull(connection)) {
                connection.close();
            }
        } catch (JMSException e) {
            System.err.println("Failed to close connection! " + e.getMessage());
        }
    }

    protected QueueConfiguration getQueueConfiguration(String queueAlias) {
        return jmsQueuesConfiguration.getQueueConfigurationMap().get(queueAlias);
    }

    //TODO: Should be more flexible (Get from input request?)
    protected Map<String, Object> getMessageProperties(String queueName) {
        return jmsQueuesConfiguration.getQueueConfigurationMap().get(queueName).getMessagePropertiesMap();
    }

    protected Message addMessageProperties(Message message, Map<String, Object> messageProperties) throws JMSException {
        if (CollectionUtils.isEmpty(messageProperties)) {
            return message;
        }
        for (String key : messageProperties.keySet()) {
            Object value = messageProperties.get(key);
            if (value instanceof Integer) {
                message.setIntProperty(key, (Integer) value);
            } else {
                message.setStringProperty(key, (String) value);
            }
        }
        return message;
    }

}
