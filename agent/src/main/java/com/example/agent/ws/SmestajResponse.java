
package com.example.agent.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for smestajResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="smestajResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="smestaji" type="{http://xml/ws/smestaj}smestajJedan" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smestajResponse", namespace = "http://xml/ws/smestaj", propOrder = {
    "smestaji"
})
public class SmestajResponse {

    @XmlElement(namespace = "http://xml/ws/smestaj", required = true)
    protected List<SmestajJedan> smestaji;

    /**
     * Gets the value of the smestaji property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smestaji property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSmestaji().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SmestajJedan }
     * 
     * 
     */
    public List<SmestajJedan> getSmestaji() {
        if (smestaji == null) {
            smestaji = new ArrayList<SmestajJedan>();
        }
        return this.smestaji;
    }

}
