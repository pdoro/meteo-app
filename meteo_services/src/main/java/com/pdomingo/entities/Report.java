//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.12.17 a las 11:40:09 AM CET 
//


package com.pdomingo.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para report complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="report">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="elevation" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="temperature" type="{http://pdomingo.com/ws}temperature"/>
 *         &lt;element name="wind" type="{http://pdomingo.com/ws}wind"/>
 *         &lt;element name="ultraviolet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "report", propOrder = {
    "name",
    "elevation",
    "temperature",
    "wind",
    "ultraviolet"
})
public class Report {

    @XmlElement(required = true)
    protected String name;
    protected int elevation;
    @XmlElement(required = true)
    protected Temperature temperature;
    @XmlElement(required = true)
    protected Wind wind;
    protected int ultraviolet;

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad elevation.
     * 
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * Define el valor de la propiedad elevation.
     * 
     */
    public void setElevation(int value) {
        this.elevation = value;
    }

    /**
     * Obtiene el valor de la propiedad temperature.
     * 
     * @return
     *     possible object is
     *     {@link Temperature }
     *     
     */
    public Temperature getTemperature() {
        return temperature;
    }

    /**
     * Define el valor de la propiedad temperature.
     * 
     * @param value
     *     allowed object is
     *     {@link Temperature }
     *     
     */
    public void setTemperature(Temperature value) {
        this.temperature = value;
    }

    /**
     * Obtiene el valor de la propiedad wind.
     * 
     * @return
     *     possible object is
     *     {@link Wind }
     *     
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * Define el valor de la propiedad wind.
     * 
     * @param value
     *     allowed object is
     *     {@link Wind }
     *     
     */
    public void setWind(Wind value) {
        this.wind = value;
    }

    /**
     * Obtiene el valor de la propiedad ultraviolet.
     * 
     */
    public int getUltraviolet() {
        return ultraviolet;
    }

    /**
     * Define el valor de la propiedad ultraviolet.
     * 
     */
    public void setUltraviolet(int value) {
        this.ultraviolet = value;
    }

}
