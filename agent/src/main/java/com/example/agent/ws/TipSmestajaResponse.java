
package com.example.agent.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for tipSmestajaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipSmestajaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoviSmestaja" type="{http://xml/ws/tipSmestaja}tipSmestajaJedan" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipSmestajaResponse", namespace = "http://xml/ws/tipSmestaja", propOrder = {
    "tipoviSmestaja"
})
@XmlRootElement(name = "tipSmestajaRequest", namespace = "http://xml/ws/tipSmestaja")
public class TipSmestajaResponse {

    @XmlElement(namespace = "http://xml/ws/tipSmestaja", required = true)
    protected List<TipSmestajaJedan> tipoviSmestaja;

    /**
     * Gets the value of the tipoviSmestaja property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tipoviSmestaja property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTipoviSmestaja().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipSmestajaJedan }
     * 
     * 
     */
    public List<TipSmestajaJedan> getTipoviSmestaja() {
        if (tipoviSmestaja == null) {
            tipoviSmestaja = new ArrayList<TipSmestajaJedan>();
        }
        return this.tipoviSmestaja;
    }

}
