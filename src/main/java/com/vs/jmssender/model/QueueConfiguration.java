package com.vs.jmssender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueueConfiguration {

    private String alias;
    private String name;
    private Map<String, Object> messagePropertiesMap;
    private Map<String, ConnectionProperties> environmentConnectionProperties;

    public ConnectionProperties getConnectionProperties(String environment) {
        if (Objects.isNull(environmentConnectionProperties) || !environmentConnectionProperties.containsKey(environment)) {
            // unknown environment
            return null;
        }
        return environmentConnectionProperties.get(environment);
    }

}
