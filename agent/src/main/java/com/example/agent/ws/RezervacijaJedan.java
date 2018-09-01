
package com.example.agent.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for rezervacijaJedan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rezervacijaJedan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="smestajBekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="korisnikBekendId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="kime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lozinka" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="od" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="paOndaDo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ocena" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="komentar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odobrenKomentar" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="realizovana" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="fejk" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rezervacijaJedan", namespace = "http://xml/ws/rezervacija", propOrder = {
    "bekendId",
    "smestajBekendId",
    "korisnikBekendId",
    "kime",
    "lozinka",
    "od",
    "paOndaDo",
    "ocena",
    "komentar",
    "odobrenKomentar",
    "realizovana",
    "fejk"
})
public class RezervacijaJedan {

    @XmlElement(namespace = "http://xml/ws/rezervacija")
    protected long bekendId;
    @XmlElement(namespace = "http://xml/ws/rezervacija")
    protected long smestajBekendId;
    @XmlElement(namespace = "http://xml/ws/rezervacija")
    protected long korisnikBekendId;
    @XmlElement(namespace = "http://xml/ws/rezervacija", required = true)
    protected String kime;
    @XmlElement(namespace = "http://xml/ws/rezervacija", required = true)
    protected String lozinka;
    @XmlElement(namespace = "http://xml/ws/rezervacija", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar od;
    @XmlElement(namespace = "http://xml/ws/rezervacija", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar paOndaDo;
    @XmlElement(namespace = "http://xml/ws/rezervacija")
    protected int ocena;
    @XmlElement(namespace = "http://xml/ws/rezervacija", required = true)
    protected String komentar;
    @XmlElement(namespace = "http://xml/ws/rezervacija")
    protected boolean odobrenKomentar;
    @XmlElement(namespace = "http://xml/ws/rezervacija")
    protected boolean realizovana;
    @XmlElement(namespace = "http://xml/ws/rezervacija")
    protected boolean fejk;

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
     * Gets the value of the korisnikBekendId property.
     * 
     */
    public long getKorisnikBekendId() {
        return korisnikBekendId;
    }

    /**
     * Sets the value of the korisnikBekendId property.
     * 
     */
    public void setKorisnikBekendId(long value) {
        this.korisnikBekendId = value;
    }

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

    /**
     * Gets the value of the ocena property.
     * 
     */
    public int getOcena() {
        return ocena;
    }

    /**
     * Sets the value of the ocena property.
     * 
     */
    public void setOcena(int value) {
        this.ocena = value;
    }

    /**
     * Gets the value of the komentar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKomentar() {
        return komentar;
    }

    /**
     * Sets the value of the komentar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKomentar(String value) {
        this.komentar = value;
    }

    /**
     * Gets the value of the odobrenKomentar property.
     * 
     */
    public boolean isOdobrenKomentar() {
        return odobrenKomentar;
    }

    /**
     * Sets the value of the odobrenKomentar property.
     * 
     */
    public void setOdobrenKomentar(boolean value) {
        this.odobrenKomentar = value;
    }

    /**
     * Gets the value of the realizovana property.
     * 
     */
    public boolean isRealizovana() {
        return realizovana;
    }

    /**
     * Sets the value of the realizovana property.
     * 
     */
    public void setRealizovana(boolean value) {
        this.realizovana = value;
    }

    /**
     * Gets the value of the fejk property.
     * 
     */
    public boolean isFejk() {
        return fejk;
    }

    /**
     * Sets the value of the fejk property.
     * 
     */
    public void setFejk(boolean value) {
        this.fejk = value;
    }

}
