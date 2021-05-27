package com.vs.jmssender.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionProperties {

    private String host;
    private int port;
    private String url;
    private String channel;
    private String queueManager;

    private String username;
    private String password;

}
