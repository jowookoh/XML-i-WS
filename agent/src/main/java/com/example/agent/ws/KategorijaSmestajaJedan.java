
package com.example.agent.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for kategorijaSmestajaJedan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="kategorijaSmestajaJedan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kategorijaSmestajaJedan", namespace = "http://xml/ws/kategorijaSmestaja", propOrder = {
    "bekendId",
    "opis"
})
public class KategorijaSmestajaJedan {

    @XmlElement(namespace = "http://xml/ws/kategorijaSmestaja")
    protected long bekendId;
    @XmlElement(namespace = "http://xml/ws/kategorijaSmestaja", required = true)
    protected String opis;

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

}
