package sesta.projekat.endpoints;

import org.springframework.context.annotation.Scope;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sesta.projekat.ws.SmestajJedan;
import sesta.projekat.ws.SmestajRequest;
import sesta.projekat.ws.SmestajResponse;

@Endpoint
@Scope
public class HelloWorldEndpoint {
    private static final String NAMESPACE_URI = "http://xml/ws/smestaj";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "smestajRequest")
    @ResponsePayload
    public SmestajResponse smesssssstaj(@RequestPayload SmestajRequest request)
	{
		SmestajJedan sj = new SmestajJedan();
		sj.setOpis("dobarr");
		SmestajJedan sd = new SmestajJedan();
		sd.setOpis("dobarr dva");
		SmestajResponse sr = new SmestajResponse();
		sr.getSmestaji().add(sj);
		sr.getSmestaji().add(sd);
    	return sr;
    }
}
