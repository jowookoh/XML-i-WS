
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

    private final static QName _UslugaResponse_QNAME = new QName("http://xml/ws/usluga", "uslugaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sesta.projekat.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UslugaRequest }
     * 
     */
    public UslugaRequest createUslugaRequest() {
        return new UslugaRequest();
    }

    /**
     * Create an instance of {@link UslugaResponse }
     * 
     */
    public UslugaResponse createUslugaResponse() {
        return new UslugaResponse();
    }

    /**
     * Create an instance of {@link UslugaJedan }
     * 
     */
    public UslugaJedan createUslugaJedan() {
        return new UslugaJedan();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UslugaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml/ws/usluga", name = "uslugaResponse")
    public JAXBElement<UslugaResponse> createUslugaResponse(UslugaResponse value) {
        return new JAXBElement<UslugaResponse>(_UslugaResponse_QNAME, UslugaResponse.class, null, value);
    }

}
