package com.vs.jmssender.constant;

public class API {

    public static final String QUEUE = "queue";
    public static final String QUEUE_ALIAS = "queueAlias";
    public static final String ENVIRONMENT = "environment";
    public static final String MESSAGE = "message";

    public static final String API_PATH = "/api";
    public static final String QUEUE_PATH = API_PATH + "/" + QUEUE;
    public static final String MESSAGE_PATH = QUEUE_PATH + "/{" + QUEUE_ALIAS + "}/{" + ENVIRONMENT + "}/" + MESSAGE;

}
