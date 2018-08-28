package sesta.projekat.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sesta.projekat.service.UslugaService;
import soap.Usluga;

@Endpoint
@Scope
public class HelloWorldEndpoint {
    private static final String NAMESPACE_URI = "http://xml/ws/beckend";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "hello")
    @ResponsePayload
    public String hello(@RequestPayload String tekst) {
        return "end world";

    }
}
