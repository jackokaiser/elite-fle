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
import javax.xml.bind.annotation.XmlElement;
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
    "entete",
    "contenu"
})
@XmlRootElement(name = "DOCUMENTTEXTE")
public class DocumentTexte {

    @XmlAttribute(name = "id_doc", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String idDoc;
    @XmlElement(name = "ENTETE", required = true)
    protected Entete entete;
    @XmlElement(name = "CONTENU", required = true)
    protected Contenu contenu;

    /**
     * Gets the value of the idDoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDoc() {
        return idDoc;
    }

    /**
     * Sets the value of the idDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDoc(String value) {
        this.idDoc = value;
    }

    /**
     * Gets the value of the entete property.
     * 
     * @return
     *     possible object is
     *     {@link Entete }
     *     
     */
    public Entete getEntete() {
        return entete;
    }

    /**
     * Sets the value of the entete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Entete }
     *     
     */
    public void setEntete(Entete value) {
        this.entete = value;
    }

    /**
     * Gets the value of the contenu property.
     * 
     * @return
     *     possible object is
     *     {@link Contenu }
     *     
     */
    public Contenu getContenu() {
        return contenu;
    }

    /**
     * Sets the value of the contenu property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contenu }
     *     
     */
    public void setContenu(Contenu value) {
        this.contenu = value;
    }

}
