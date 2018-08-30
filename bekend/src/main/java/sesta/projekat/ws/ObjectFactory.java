
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

    private final static QName _SmestajResponse_QNAME = new QName("http://xml/ws/smestaj", "smestajResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sesta.projekat.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SmestajResponse }
     * 
     */
    public SmestajResponse createSmestajResponse() {
        return new SmestajResponse();
    }

    /**
     * Create an instance of {@link SmestajRequest }
     * 
     */
    public SmestajRequest createSmestajRequest() {
        return new SmestajRequest();
    }

    /**
     * Create an instance of {@link SmestajJedan }
     * 
     */
    public SmestajJedan createSmestajJedan() {
        return new SmestajJedan();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SmestajResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml/ws/smestaj", name = "smestajResponse")
    public JAXBElement<SmestajResponse> createSmestajResponse(SmestajResponse value) {
        return new JAXBElement<SmestajResponse>(_SmestajResponse_QNAME, SmestajResponse.class, null, value);
    }

}
