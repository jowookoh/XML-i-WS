package com.example.agent.client;

import com.example.agent.ws.LoginRequest;
import com.example.agent.ws.LoginResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class LoginClient extends WebServiceGatewaySupport {
	
	public LoginResponse login(String kime, String lozinka) {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.example.agent.ws");
		marshaller.setClassesToBeBound(LoginRequest.class, LoginResponse.class);
		
		getWebServiceTemplate().setMarshaller(marshaller);
		getWebServiceTemplate().setUnmarshaller(marshaller);
		getWebServiceTemplate().setDefaultUri("http://localhost:8080/ws/login");
		LoginRequest request = new LoginRequest();
		request.setKime(kime);
		request.setLozinka(lozinka);
		Object o = getWebServiceTemplate().marshalSendAndReceive(request);
		LoginResponse response = (LoginResponse) o;
		
		return response;
	}
}
