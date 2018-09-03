
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
 *         &lt;element name="agentKime" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "agentKime"
})
@XmlRootElement(name = "rezervacijaRequest", namespace = "http://xml/ws/rezervacija")
public class RezervacijaRequest {

    @XmlElement(namespace = "http://xml/ws/rezervacija", required = true)
    protected String agentKime;

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

}
