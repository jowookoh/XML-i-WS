
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
 *         &lt;element name="tipBekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="kategorijaBekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="agentKime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lokacijaBekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="brojOsoba" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "tipBekendId",
    "kategorijaBekendId",
    "agentKime",
    "lokacijaBekendId",
    "opis",
    "brojOsoba"
})
@XmlRootElement(name = "smestajRequest", namespace = "http://xml/ws/smestaj")
public class SmestajRequest {

    @XmlElement(namespace = "http://xml/ws/smestaj")
    protected long tipBekendId;
    @XmlElement(namespace = "http://xml/ws/smestaj")
    protected long kategorijaBekendId;
    @XmlElement(namespace = "http://xml/ws/smestaj", required = true)
    protected String agentKime;
    @XmlElement(namespace = "http://xml/ws/smestaj")
    protected long lokacijaBekendId;
    @XmlElement(namespace = "http://xml/ws/smestaj", required = true)
    protected String opis;
    @XmlElement(namespace = "http://xml/ws/smestaj")
    protected int brojOsoba;

    /**
     * Gets the value of the tipBekendId property.
     * 
     */
    public long getTipBekendId() {
        return tipBekendId;
    }

    /**
     * Sets the value of the tipBekendId property.
     * 
     */
    public void setTipBekendId(long value) {
        this.tipBekendId = value;
    }

    /**
     * Gets the value of the kategorijaBekendId property.
     * 
     */
    public long getKategorijaBekendId() {
        return kategorijaBekendId;
    }

    /**
     * Sets the value of the kategorijaBekendId property.
     * 
     */
    public void setKategorijaBekendId(long value) {
        this.kategorijaBekendId = value;
    }

    /**
     * Gets the value of the agentKime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentKime() {
        return agentKime;
    }

    /**
     * Sets the value of the agentKime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentKime(String value) {
        this.agentKime = value;
    }

    /**
     * Gets the value of the lokacijaBekendId property.
     * 
     */
    public long getLokacijaBekendId() {
        return lokacijaBekendId;
    }

    /**
     * Sets the value of the lokacijaBekendId property.
     * 
     */
    public void setLokacijaBekendId(long value) {
        this.lokacijaBekendId = value;
    }

    /**
     * Gets the value of the opis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Sets the value of the opis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpis(String value) {
        this.opis = value;
    }

    /**
     * Gets the value of the brojOsoba property.
     * 
     */
    public int getBrojOsoba() {
        return brojOsoba;
    }

    /**
     * Sets the value of the brojOsoba property.
     * 
     */
    public void setBrojOsoba(int value) {
        this.brojOsoba = value;
    }

}
