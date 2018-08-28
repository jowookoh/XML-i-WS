package com.example.agent.endpoint;

import org.springframework.context.annotation.Scope;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@Scope
public class HelloWorldEndpoint {

    private static final String NAMESPACE_URI = "http://xml/ws/agent";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "hello")
    @ResponsePayload
    public String hello(@RequestPayload String usluga) {

        return "helljo";

    }
}
