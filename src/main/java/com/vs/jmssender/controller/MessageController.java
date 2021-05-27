package com.vs.jmssender.controller;

import com.vs.jmssender.sender.ActiveMQSender;
import com.vs.jmssender.sender.IBMMQSender;
import com.vs.jmssender.sender.JMSSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.vs.jmssender.constant.API.*;
import static com.vs.jmssender.constant.Environments.LOCAL;

@Slf4j
@Controller
@RequestMapping(path = MESSAGE_PATH)
public class MessageController {

    @Autowired
    private ActiveMQSender activeMQSender;

    @Autowired
    private IBMMQSender ibmmqSender;

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @PathVariable(QUEUE_ALIAS) String queueAlias,
            @PathVariable(ENVIRONMENT) String environment,
            @RequestBody String payload) {
        try {
            getSender(environment).send(queueAlias, environment, payload);
            return successResponse("Message sent!");
        } catch (Exception e) {
            log.error("Exception: ", e);
            return successResponse(e.getMessage());
        }
    }

    private JMSSender getSender(String environment) {
        return LOCAL.equalsIgnoreCase(environment) ? activeMQSender : ibmmqSender;
    }

    private ResponseEntity<String> successResponse(String message) {
        return new ResponseEntity(message, HttpStatus.OK);
    }

}
