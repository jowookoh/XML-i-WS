
package soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for rezervacija complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rezervacija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="smestaj" type="{}smestaj"/>
 *         &lt;element name="od" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="paOndaDo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ocena" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="komentar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="odobrenKomentar" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="realizovana" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rezervacija", propOrder = {
    "id",
    "smestaj",
    "od",
    "paOndaDo",
    "ocena",
    "komentar",
    "odobrenKomentar",
    "realizovana"
})
public class Rezervacija {

    protected long id;
    @XmlElement(required = true)
    protected Smestaj smestaj;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar od;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar paOndaDo;
    protected int ocena;
    @XmlElement(required = true)
    protected String komentar;
    protected boolean odobrenKomentar;
    protected boolean realizovana;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the smestaj property.
     * 
     * @return
     *     possible object is
     *     {@link Smestaj }
     *     
     */
    public Smestaj getSmestaj() {
        return smestaj;
    }

    /**
     * Sets the value of the smestaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Smestaj }
     *     
     */
    public void setSmestaj(Smestaj value) {
        this.smestaj = value;
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

}
