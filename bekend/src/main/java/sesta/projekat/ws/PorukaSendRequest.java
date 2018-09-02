
package sesta.projekat.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rezervacijaId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="poRedu" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "kime",
    "rezervacijaId",
    "tekst",
    "poRedu"
})
@XmlRootElement(name = "porukaSendRequest", namespace = "http://xml/ws/porukaSend")
public class PorukaSendRequest {

    @XmlElement(namespace = "http://xml/ws/porukaSend", required = true)
    protected String kime;
    @XmlElement(namespace = "http://xml/ws/porukaSend")
    protected long rezervacijaId;
    @XmlElement(namespace = "http://xml/ws/porukaSend", required = true)
    protected String tekst;
    @XmlElement(namespace = "http://xml/ws/porukaSend")
    protected int poRedu;

    /**
     * Gets the value of the kime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKime() {
        return kime;
    }

    /**
     * Sets the value of the kime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKime(String value) {
        this.kime = value;
    }

    /**
     * Gets the value of the rezervacijaId property.
     * 
     */
    public long getRezervacijaId() {
        return rezervacijaId;
    }

    /**
     * Sets the value of the rezervacijaId property.
     * 
     */
    public void setRezervacijaId(long value) {
        this.rezervacijaId = value;
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

    /**
     * Gets the value of the poRedu property.
     * 
     */
    public int getPoRedu() {
        return poRedu;
    }

    /**
     * Sets the value of the poRedu property.
     * 
     */
    public void setPoRedu(int value) {
        this.poRedu = value;
    }

}
