
package sesta.projekat.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sesta.projekat.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PorukaResponse_QNAME = new QName("http://xml/ws/poruka", "porukaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sesta.projekat.ws
     * 
     */
    public ObjectFactory() {
    }
	
	public UslugaSmestajResponse createUslugaSmestajResponse() {
		return new UslugaSmestajResponse();
	}
	public UslugaResponse createUslugaResponse() {
		return new UslugaResponse();
	}
	public TipSmestajaResponse createTipSmestajaResponse() {
		return new TipSmestajaResponse();
	}
	public SmestajResponse createSmestajResponse() {
		return new SmestajResponse();
	}
	public RezervacijaRealizovanaResponse createRezervacijaRealizovanaResponse() {
		return new RezervacijaRealizovanaResponse();
	}
	public RezervacijaFejkResponse createRezervacijaFejkResponse() {
		return new RezervacijaFejkResponse();
	}
	public RezervacijaResponse createRezervacijaResponse() {
		return new RezervacijaResponse();
	}
	public PorukaSendResponse createPorukaSendResponse() {
		return new PorukaSendResponse();
	}
	public PorukaResponse createPorukaResponse() {
		return new PorukaResponse();
	}
	public LokacijaResponse createLokacijaResponse() {
		return new LokacijaResponse();
	}
	public LoginResponse createLoginResponse() {
		return new LoginResponse();
	}
	public KategorijaSmestajaResponse createKategorijaSmestajaResponse() {
		return new KategorijaSmestajaResponse();
	}
	public CenaResponse createCenaResponse() {
		return new CenaResponse();
	}
	public SlikaResponse createSlikaResponse() {
		return new SlikaResponse();
	}
	
	
	public UslugaSmestajRequest createUslugaSmestajRequest() {
		return new UslugaSmestajRequest();
	}
	
	public UslugaRequest createUslugaRequest() {
		return new UslugaRequest();
	}
	
	public TipSmestajaRequest createTipSmestajaRequest() {
		return new TipSmestajaRequest();
	}
	
	public SmestajRequest createSmestajRequest() {
		return new SmestajRequest();
	}
	
	public RezervacijaRealizovanaRequest createRezervacijaRealizovanaRequest() {
		return new RezervacijaRealizovanaRequest();
	}
	
	public RezervacijaFejkRequest createRezervacijaFejkRequest() {
		return new RezervacijaFejkRequest();
	}
	
	public RezervacijaRequest createRezervacijaRequest() {
		return new RezervacijaRequest();
	}
	
	public PorukaSendRequest createPorukaSendRequest() {
		return new PorukaSendRequest();
	}
	
	public PorukaRequest createPorukaRequest() {
		return new PorukaRequest();
	}
	
	public LokacijaRequest createLokacijaRequest() {
		return new LokacijaRequest();
	}
	
	public LoginRequest createLoginRequest() {
		return new LoginRequest();
	}
	
	public KategorijaSmestajaRequest createKategorijaSmestajaRequest() {
		return new KategorijaSmestajaRequest();
	}
	
	public CenaRequest createCenaRequest() {
		return new CenaRequest();
	}
	
	public SlikaRequest createSlikaRequest() {
		return new SlikaRequest();
	}
}
