
package sesta.projekat.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for porukaJedan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="porukaJedan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="posiljalacBekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="rezervacijaBekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "porukaJedan", namespace = "http://xml/ws/poruka", propOrder = {
    "bekendId",
    "posiljalacBekendId",
    "rezervacijaBekendId",
    "tekst",
    "poRedu"
})
public class PorukaJedan {

    @XmlElement(namespace = "http://xml/ws/poruka")
    protected long bekendId;
    @XmlElement(namespace = "http://xml/ws/poruka")
    protected long posiljalacBekendId;
    @XmlElement(namespace = "http://xml/ws/poruka")
    protected long rezervacijaBekendId;
    @XmlElement(namespace = "http://xml/ws/poruka", required = true)
    protected String tekst;
    @XmlElement(namespace = "http://xml/ws/poruka")
    protected int poRedu;

    /**
     * Gets the value of the bekendId property.
     * 
     */
    public long getBekendId() {
        return bekendId;
    }

    /**
     * Sets the value of the bekendId property.
     * 
     */
    public void setBekendId(long value) {
        this.bekendId = value;
    }

    /**
     * Gets the value of the posiljalacBekendId property.
     * 
     */
    public long getPosiljalacBekendId() {
        return posiljalacBekendId;
    }

    /**
     * Sets the value of the posiljalacBekendId property.
     * 
     */
    public void setPosiljalacBekendId(long value) {
        this.posiljalacBekendId = value;
    }

    /**
     * Gets the value of the rezervacijaBekendId property.
     * 
     */
    public long getRezervacijaBekendId() {
        return rezervacijaBekendId;
    }

    /**
     * Sets the value of the rezervacijaBekendId property.
     * 
     */
    public void setRezervacijaBekendId(long value) {
        this.rezervacijaBekendId = value;
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
