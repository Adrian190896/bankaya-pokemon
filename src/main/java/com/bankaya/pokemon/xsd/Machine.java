//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.05.05 at 12:59:38 PM CST 
//


package com.bankaya.pokemon.xsd;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for machine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="machine"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="item" type="{http://spring.io/guides/gs-producing-web-service}common"/&gt;
 *         &lt;element name="move" type="{http://spring.io/guides/gs-producing-web-service}common"/&gt;
 *         &lt;element name="versionGroup" type="{http://spring.io/guides/gs-producing-web-service}common"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "machine", propOrder = {
    "id",
    "item",
    "move",
    "versionGroup"
})
public class Machine {

    protected int id;
    @XmlElement(required = true)
    protected Common item;
    @XmlElement(required = true)
    protected Common move;
    @XmlElement(required = true)
    protected Common versionGroup;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * @return
     *     possible object is
     *     {@link Common }
     *     
     */
    public Common getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     * 
     * @param value
     *     allowed object is
     *     {@link Common }
     *     
     */
    public void setItem(Common value) {
        this.item = value;
    }

    /**
     * Gets the value of the move property.
     * 
     * @return
     *     possible object is
     *     {@link Common }
     *     
     */
    public Common getMove() {
        return move;
    }

    /**
     * Sets the value of the move property.
     * 
     * @param value
     *     allowed object is
     *     {@link Common }
     *     
     */
    public void setMove(Common value) {
        this.move = value;
    }

    /**
     * Gets the value of the versionGroup property.
     * 
     * @return
     *     possible object is
     *     {@link Common }
     *     
     */
    public Common getVersionGroup() {
        return versionGroup;
    }

    /**
     * Sets the value of the versionGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link Common }
     *     
     */
    public void setVersionGroup(Common value) {
        this.versionGroup = value;
    }

}
