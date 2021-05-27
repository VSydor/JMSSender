package com.vs.jmssender.configuration;

import com.vs.jmssender.model.QueueConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@ConfigurationProperties(prefix = "jms-queues")
public class JmsQueuesConfiguration {

    private List<QueueConfiguration> queueConfigurations;
    private Map<String, QueueConfiguration> queueConfigurationMap;

    public JmsQueuesConfiguration(List<QueueConfiguration> queueConfigurations) {
        this.queueConfigurations = queueConfigurations;
        mapConfigurations(queueConfigurations);
    }

    public void setQueueConfigurations(List<QueueConfiguration> queueConfigurations) {
        this.queueConfigurations = queueConfigurations;
        mapConfigurations(queueConfigurations);
    }

    public QueueConfiguration getQueueConfiguration(String queueAlias) {
        if (Objects.isNull(queueConfigurationMap)
                || !queueConfigurationMap.containsKey(queueAlias)) {
            // unknown queue
            return null;
        }
        return queueConfigurationMap.get(queueAlias);
    }

    private void mapConfigurations(List<QueueConfiguration> queueConfigurations) {
        if (!CollectionUtils.isEmpty(queueConfigurations)) {
            queueConfigurationMap = queueConfigurations.stream()
                    .collect(Collectors.toMap(
                            QueueConfiguration::getAlias, qc -> qc));
        }
    }

}
