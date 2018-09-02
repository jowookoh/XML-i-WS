
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
 *         &lt;element name="bekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "bekendId"
})
@XmlRootElement(name = "rezervacijaRealizovanaResponse", namespace = "http://xml/ws/rezervacijaRealizovana")
public class RezervacijaRealizovanaResponse {

    @XmlElement(namespace = "http://xml/ws/rezervacijaRealizovana")
    protected long bekendId;

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

}
