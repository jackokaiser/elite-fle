//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.27 at 03:56:12 PM CET 
//


package com.unalsoft.elitefle.entity.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "element")
public class Element extends ElementXML {

    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "cat")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cat;
    @XmlAttribute(name = "mode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mode;
    @XmlAttribute(name = "temps")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String temps;
    @XmlAttribute(name = "pers")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String pers;
    @XmlAttribute(name = "genre")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String genre;
    @XmlAttribute(name = "nombre")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nombre;
    @XmlValue
    protected String value;

    public Element() {
        this.tag = "element";
        this.elem = true;
    }

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
     * Gets the value of the cat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCat() {
        return cat;
    }

    /**
     * Sets the value of the cat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCat(String value) {
        this.cat = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMode(String value) {
        this.mode = value;
    }

    /**
     * Gets the value of the temps property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemps() {
        return temps;
    }

    /**
     * Sets the value of the temps property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemps(String value) {
        this.temps = value;
    }

    /**
     * Gets the value of the pers property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPers() {
        return pers;
    }

    /**
     * Sets the value of the pers property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPers(String value) {
        this.pers = value;
    }

    /**
     * Gets the value of the genre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenre(String value) {
        this.genre = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getvalue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setvalue(String value) {
        this.value = value;
    }

}
