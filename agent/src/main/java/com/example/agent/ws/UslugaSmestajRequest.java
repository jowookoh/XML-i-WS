
package com.example.agent.ws;

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
 *         &lt;element name="uslugaBekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="smestajBekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "uslugaBekendId",
    "smestajBekendId"
})
@XmlRootElement(name = "uslugaSmestajRequest", namespace = "http://xml/ws/uslugaSmestaj")
public class UslugaSmestajRequest {

    @XmlElement(namespace = "http://xml/ws/uslugaSmestaj")
    protected long uslugaBekendId;
    @XmlElement(namespace = "http://xml/ws/uslugaSmestaj")
    protected long smestajBekendId;

    /**
     * Gets the value of the uslugaBekendId property.
     * 
     */
    public long getUslugaBekendId() {
        return uslugaBekendId;
    }

    /**
     * Sets the value of the uslugaBekendId property.
     * 
     */
    public void setUslugaBekendId(long value) {
        this.uslugaBekendId = value;
    }

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

}
