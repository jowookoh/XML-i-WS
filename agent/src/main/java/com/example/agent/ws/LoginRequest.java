
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
 *         &lt;element name="kime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lozinka" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "lozinka"
})
@XmlRootElement(name = "loginRequest", namespace = "http://xml/ws/login")
public class LoginRequest {

    @XmlElement(namespace = "http://xml/ws/login", required = true)
    protected String kime;
    @XmlElement(namespace = "http://xml/ws/login", required = true)
    protected String lozinka;

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
     * Gets the value of the lozinka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * Sets the value of the lozinka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLozinka(String value) {
        this.lozinka = value;
    }

}
