package com.example.agent.client;

import com.example.agent.ws.*;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class GenerickiClient extends WebServiceGatewaySupport {
	private Class requestType, responseType;
	
	public GenerickiClient(Class requestType, Class responseType) {
		this.requestType = requestType;
		this.responseType = responseType;
	}
	
	public <TRequest, TResponse> TResponse send(TRequest request, String uri) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.example.agent.ws");
		marshaller.setClassesToBeBound(requestType, responseType);
		
		getWebServiceTemplate().setMarshaller(marshaller);
		getWebServiceTemplate().setUnmarshaller(marshaller);
		getWebServiceTemplate().setDefaultUri("http://localhost:8080/ws/"+uri);
		Object o = getWebServiceTemplate().marshalSendAndReceive(request);
		
		return (TResponse) o;
	}
}
