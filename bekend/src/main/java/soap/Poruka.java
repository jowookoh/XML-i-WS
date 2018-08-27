
package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for poruka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="poruka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="posiljalac" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="rezervacija" type="{}rezervacija"/>
 *         &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "poruka", propOrder = {
    "id",
    "posiljalac",
    "rezervacija",
    "tekst"
})
public class Poruka {

    protected long id;
    protected long posiljalac;
    @XmlElement(required = true)
    protected Rezervacija rezervacija;
    @XmlElement(required = true)
    protected String tekst;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the posiljalac property.
     * 
     */
    public long getPosiljalac() {
        return posiljalac;
    }

    /**
     * Sets the value of the posiljalac property.
     * 
     */
    public void setPosiljalac(long value) {
        this.posiljalac = value;
    }

    /**
     * Gets the value of the rezervacija property.
     * 
     * @return
     *     possible object is
     *     {@link Rezervacija }
     *     
     */
    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    /**
     * Sets the value of the rezervacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rezervacija }
     *     
     */
    public void setRezervacija(Rezervacija value) {
        this.rezervacija = value;
    }

    /**
     * Gets the value of the tekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTekst() {
        return tekst;
    }

    /**
     * Sets the value of the tekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTekst(String value) {
        this.tekst = value;
    }

}
