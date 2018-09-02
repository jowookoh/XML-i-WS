
package sesta.projekat.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="smestajId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="mesec" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="vrednost" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "smestajId",
    "mesec",
    "vrednost"
})
@XmlRootElement(name = "cenaRequest", namespace = "http://xml/ws/cena")
public class CenaRequest {

    @XmlElement(namespace = "http://xml/ws/cena")
    protected long smestajId;
    @XmlElement(namespace = "http://xml/ws/cena", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar mesec;
    @XmlElement(namespace = "http://xml/ws/cena")
    protected int vrednost;

    /**
     * Gets the value of the smestajId property.
     * 
     */
    public long getSmestajId() {
        return smestajId;
    }

    /**
     * Sets the value of the smestajId property.
     * 
     */
    public void setSmestajId(long value) {
        this.smestajId = value;
    }

    /**
     * Gets the value of the mesec property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMesec() {
        return mesec;
    }

    /**
     * Sets the value of the mesec property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMesec(XMLGregorianCalendar value) {
        this.mesec = value;
    }

    /**
     * Gets the value of the vrednost property.
     * 
     */
    public int getVrednost() {
        return vrednost;
    }

    /**
     * Sets the value of the vrednost property.
     * 
     */
    public void setVrednost(int value) {
        this.vrednost = value;
    }

}
