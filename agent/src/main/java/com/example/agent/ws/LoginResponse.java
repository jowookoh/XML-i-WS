
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
 *         &lt;element name="postoji" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "postoji"
})
@XmlRootElement(name = "loginResponse", namespace = "http://xml/ws/login")
public class LoginResponse {

    @XmlElement(namespace = "http://xml/ws/login")
    protected boolean postoji;

    /**
     * Gets the value of the postoji property.
     * 
     */
    public boolean isPostoji() {
        return postoji;
    }

    /**
     * Sets the value of the postoji property.
     * 
     */
    public void setPostoji(boolean value) {
        this.postoji = value;
    }

}
