
package com.example.agent.ws;

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
 *         &lt;element name="od" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="paOndaDo" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "od",
    "paOndaDo"
})
@XmlRootElement(name = "rezervacijaFejkRequest", namespace = "http://xml/ws/rezervacijaFejk")
public class RezervacijaFejkRequest {

    @XmlElement(namespace = "http://xml/ws/rezervacijaFejk")
    protected long smestajId;
    @XmlElement(namespace = "http://xml/ws/rezervacijaFejk", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar od;
    @XmlElement(namespace = "http://xml/ws/rezervacijaFejk", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar paOndaDo;

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
     * Gets the value of the od property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOd() {
        return od;
    }

    /**
     * Sets the value of the od property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOd(XMLGregorianCalendar value) {
        this.od = value;
    }

    /**
     * Gets the value of the paOndaDo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPaOndaDo() {
        return paOndaDo;
    }

    /**
     * Sets the value of the paOndaDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPaOndaDo(XMLGregorianCalendar value) {
        this.paOndaDo = value;
    }

}
