//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.11 at 03:15:38 PM CET 
//


package com.unalsoft.elitefle.entity.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "element"
})
@XmlRootElement(name = "referent")
public class Referent {

    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "sous-type")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String sousType;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String idn;
    protected List<Element> element;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the sousType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSousType() {
        return sousType;
    }

    /**
     * Sets the value of the sousType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSousType(String value) {
        this.sousType = value;
    }

    /**
     * Gets the value of the idn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdn() {
        return idn;
    }

    /**
     * Sets the value of the idn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdn(String value) {
        this.idn = value;
    }

    /**
     * Gets the value of the element property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the element property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<Element> getElement() {
        if (element == null) {
            element = new ArrayList<Element>();
        }
        return this.element;
    }

}
