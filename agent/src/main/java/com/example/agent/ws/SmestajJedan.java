
package com.example.agent.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for smestajJedan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="smestajJedan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tipSmestaja" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="kategorijaSmestaja" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="agent" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lokacija" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "smestajJedan", namespace = "http://xml/ws/smestaj", propOrder = {
    "bekendId",
    "tipSmestaja",
    "kategorijaSmestaja",
    "agent",
    "lokacija",
    "opis",
    "brojOsoba"
})
public class SmestajJedan {

    @XmlElement(namespace = "http://xml/ws/smestaj")
    protected long bekendId;
    @XmlElement(namespace = "http://xml/ws/smestaj")
    protected long tipSmestaja;
    @XmlElement(namespace = "http://xml/ws/smestaj")
    protected long kategorijaSmestaja;
    @XmlElement(namespace = "http://xml/ws/smestaj")
    protected long agent;
    @XmlElement(namespace = "http://xml/ws/smestaj")
    protected long lokacija;
    @XmlElement(namespace = "http://xml/ws/smestaj", required = true)
    protected String opis;
    @XmlElement(namespace = "http://xml/ws/smestaj")
    protected int brojOsoba;

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
     * Gets the value of the tipSmestaja property.
     * 
     */
    public long getTipSmestaja() {
        return tipSmestaja;
    }

    /**
     * Sets the value of the tipSmestaja property.
     * 
     */
    public void setTipSmestaja(long value) {
        this.tipSmestaja = value;
    }

    /**
     * Gets the value of the kategorijaSmestaja property.
     * 
     */
    public long getKategorijaSmestaja() {
        return kategorijaSmestaja;
    }

    /**
     * Sets the value of the kategorijaSmestaja property.
     * 
     */
    public void setKategorijaSmestaja(long value) {
        this.kategorijaSmestaja = value;
    }

    /**
     * Gets the value of the agent property.
     * 
     */
    public long getAgent() {
        return agent;
    }

    /**
     * Sets the value of the agent property.
     * 
     */
    public void setAgent(long value) {
        this.agent = value;
    }

    /**
     * Gets the value of the lokacija property.
     * 
     */
    public long getLokacija() {
        return lokacija;
    }

    /**
     * Sets the value of the lokacija property.
     * 
     */
    public void setLokacija(long value) {
        this.lokacija = value;
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
