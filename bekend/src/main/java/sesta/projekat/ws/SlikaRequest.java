
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
 *         &lt;element name="smestajBekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="adresa" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "smestajBekendId",
    "adresa"
})
@XmlRootElement(name = "slikaRequest", namespace = "http://xml/ws/slika")
public class SlikaRequest {

    @XmlElement(namespace = "http://xml/ws/slika")
    protected long smestajBekendId;
    @XmlElement(namespace = "http://xml/ws/slika", required = true)
    protected String adresa;

    /**
     * Gets the value of the smestajBekendId property.
     * 
     */
    public long getSmestajBekendId() {
        return smestajBekendId;
    }

    /**
     * Sets the value of the smestajBekendId property.
     * 
     */
    public void setSmestajBekendId(long value) {
        this.smestajBekendId = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresa(String value) {
        this.adresa = value;
    }

}
