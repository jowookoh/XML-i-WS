package com.example.agent.client;

import com.example.agent.ws.SmestajRequest;
import com.example.agent.ws.SmestajResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SmestajClient extends WebServiceGatewaySupport {
	
	public SmestajResponse getSmestaji() {
		/*SmestajResponse response = (SmestajResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/smestaj", new SmestajRequest());
		
		return response;*/
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.example.agent.ws");
		marshaller.setClassesToBeBound(SmestajRequest.class, SmestajResponse.class);
		
		getWebServiceTemplate().setMarshaller(marshaller);
		getWebServiceTemplate().setUnmarshaller(marshaller);
		getWebServiceTemplate().setDefaultUri("http://localhost:8080/ws/smestljaj");
		Object o = getWebServiceTemplate().marshalSendAndReceive(new SmestajRequest());
		SmestajResponse response = (SmestajResponse) o;
		
		return response;
	}
}
