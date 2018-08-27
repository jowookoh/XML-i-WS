
package soap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Rezervacija }
     * 
     */
    public Rezervacija createRezervacija() {
        return new Rezervacija();
    }

    /**
     * Create an instance of {@link Slika }
     * 
     */
    public Slika createSlika() {
        return new Slika();
    }

    /**
     * Create an instance of {@link Smestaj }
     * 
     */
    public Smestaj createSmestaj() {
        return new Smestaj();
    }

    /**
     * Create an instance of {@link Lokacija }
     * 
     */
    public Lokacija createLokacija() {
        return new Lokacija();
    }

    /**
     * Create an instance of {@link Poruka }
     * 
     */
    public Poruka createPoruka() {
        return new Poruka();
    }

    /**
     * Create an instance of {@link TipSmestaja }
     * 
     */
    public TipSmestaja createTipSmestaja() {
        return new TipSmestaja();
    }

    /**
     * Create an instance of {@link Cena }
     * 
     */
    public Cena createCena() {
        return new Cena();
    }

    /**
     * Create an instance of {@link Usluga }
     * 
     */
    public Usluga createUsluga() {
        return new Usluga();
    }

}
