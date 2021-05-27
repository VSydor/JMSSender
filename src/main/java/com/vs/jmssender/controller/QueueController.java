package com.vs.jmssender.controller;

import com.vs.jmssender.configuration.JmsQueuesConfiguration;
import com.vs.jmssender.model.QueueConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.vs.jmssender.constant.API.QUEUE_PATH;

@Slf4j
@Controller
@RequestMapping(path = QUEUE_PATH)
public class QueueController {

    @Autowired
    private JmsQueuesConfiguration jmsQueuesConfiguration;

    @GetMapping
    public ResponseEntity<Map<String, List<String>>> getAvailableQueues() {
        List<QueueConfiguration> queueConfigurations = jmsQueuesConfiguration.getQueueConfigurations();
        List<String> queueAliases = Collections.emptyList();

        if (!CollectionUtils.isEmpty(queueConfigurations)) {
            queueAliases = jmsQueuesConfiguration.getQueueConfigurations().stream()
                    .map(QueueConfiguration::getAlias)
                    .collect(Collectors.toList());
        }

        return new ResponseEntity(queueAliases, HttpStatus.OK);
    }

}

