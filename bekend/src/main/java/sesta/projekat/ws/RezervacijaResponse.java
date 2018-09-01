
package sesta.projekat.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rezervacijaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rezervacijaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kategorijaoviSmestaja" type="{http://xml/ws/rezervacija}rezervacijaJedan" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rezervacijaResponse", namespace = "http://xml/ws/rezervacija", propOrder = {
    "kategorijaoviSmestaja"
})
public class RezervacijaResponse {

    @XmlElement(namespace = "http://xml/ws/rezervacija", required = true)
    protected List<RezervacijaJedan> kategorijaoviSmestaja;

    /**
     * Gets the value of the kategorijaoviSmestaja property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kategorijaoviSmestaja property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKategorijaoviSmestaja().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RezervacijaJedan }
     * 
     * 
     */
    public List<RezervacijaJedan> getKategorijaoviSmestaja() {
        if (kategorijaoviSmestaja == null) {
            kategorijaoviSmestaja = new ArrayList<RezervacijaJedan>();
        }
        return this.kategorijaoviSmestaja;
    }

}
