
package sesta.projekat.ws;

import sesta.projekat.model.Usluga;

import javax.xml.bind.annotation.XmlRegistry;


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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sesta.projekat.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    public KategorijaSmestajaResponse createKategorijaSmestajaResponse() {
        return new KategorijaSmestajaResponse();
    }

    public PorukaResponse createPorukaResponse() {
        return new PorukaResponse();
    }

    public RezervacijaResponse createRezervacijaResponse() {
        return new RezervacijaResponse();
    }

    public TipSmestajaResponse createTipSmestajaResponse() {
        return new TipSmestajaResponse();
    }

    public UslugaResponse createUslugaResponse() {
        return new UslugaResponse();
    }

    /**
     * Create an instance of {@link LoginRequest }
     * 
     */
    public LoginRequest createLoginRequest() {
        return new LoginRequest();
    }
    
    public KategorijaSmestajaRequest createKategorijaSmestajaRequest() {
        return new KategorijaSmestajaRequest();
    }
    
    public PorukaRequest createPorukaRequest() {
        return new PorukaRequest();
    }
    
    public RezervacijaRequest createRezervacijaRequest() {
        return new RezervacijaRequest();
    }
    
    public TipSmestajaRequest createTipSmestajaRequest() {
        return new TipSmestajaRequest();
    }
    
    public UslugaRequest createUslugaRequest() {
        return new UslugaRequest();
    }

}
