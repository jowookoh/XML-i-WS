
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

    private final static QName _RezervacijaResponse_QNAME = new QName("http://xml/ws/rezervacija", "rezervacijaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sesta.projekat.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RezervacijaResponse }
     * 
     */
    public RezervacijaResponse createRezervacijaResponse() {
        return new RezervacijaResponse();
    }

    /**
     * Create an instance of {@link RezervacijaRequest }
     * 
     */
    public RezervacijaRequest createRezervacijaRequest() {
        return new RezervacijaRequest();
    }

    /**
     * Create an instance of {@link RezervacijaJedan }
     * 
     */
    public RezervacijaJedan createRezervacijaJedan() {
        return new RezervacijaJedan();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RezervacijaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml/ws/rezervacija", name = "rezervacijaResponse")
    public JAXBElement<RezervacijaResponse> createRezervacijaResponse(RezervacijaResponse value) {
        return new JAXBElement<RezervacijaResponse>(_RezervacijaResponse_QNAME, RezervacijaResponse.class, null, value);
    }

}
