
package soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for smestaj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="smestaj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lokacija" type="{}lokacija"/>
 *         &lt;element name="tipSmestaja" type="{}tipSmestaja"/>
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="slika" type="{}slika"/>
 *         &lt;/sequence>
 *         &lt;element name="brojOsoba" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="usluga" type="{}usluga"/>
 *         &lt;/sequence>
 *         &lt;sequence maxOccurs="unbounded">
 *           &lt;element name="planCena" type="{}cena"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smestaj", propOrder = {
    "id",
    "lokacija",
    "tipSmestaja",
    "opis",
    "slika",
    "brojOsoba",
    "usluga",
    "planCena"
})
public class Smestaj {

    protected long id;
    @XmlElement(required = true)
    protected Lokacija lokacija;
    @XmlElement(required = true)
    protected TipSmestaja tipSmestaja;
    @XmlElement(required = true)
    protected String opis;
    protected List<Slika> slika;
    protected int brojOsoba;
    protected List<Usluga> usluga;
    @XmlElement(required = true)
    protected List<Cena> planCena;

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
     * Gets the value of the lokacija property.
     * 
     * @return
     *     possible object is
     *     {@link Lokacija }
     *     
     */
    public Lokacija getLokacija() {
        return lokacija;
    }

    /**
     * Sets the value of the lokacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lokacija }
     *     
     */
    public void setLokacija(Lokacija value) {
        this.lokacija = value;
    }

    /**
     * Gets the value of the tipSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link TipSmestaja }
     *     
     */
    public TipSmestaja getTipSmestaja() {
        return tipSmestaja;
    }

    /**
     * Sets the value of the tipSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipSmestaja }
     *     
     */
    public void setTipSmestaja(TipSmestaja value) {
        this.tipSmestaja = value;
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
     * Gets the value of the slika property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slika property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlika().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Slika }
     * 
     * 
     */
    public List<Slika> getSlika() {
        if (slika == null) {
            slika = new ArrayList<Slika>();
        }
        return this.slika;
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

    /**
     * Gets the value of the usluga property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usluga property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsluga().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Usluga }
     * 
     * 
     */
    public List<Usluga> getUsluga() {
        if (usluga == null) {
            usluga = new ArrayList<Usluga>();
        }
        return this.usluga;
    }

    /**
     * Gets the value of the planCena property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planCena property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanCena().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cena }
     * 
     * 
     */
    public List<Cena> getPlanCena() {
        if (planCena == null) {
            planCena = new ArrayList<Cena>();
        }
        return this.planCena;
    }

}
