//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.12.17 a las 11:40:09 AM CET 
//


package com.pdomingo.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para temperature complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="temperature">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="max" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="min" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "temperature", propOrder = {
    "max",
    "min"
})
public class Temperature {

    protected int max;
    protected int min;

    /**
     * Obtiene el valor de la propiedad max.
     * 
     */
    public int getMax() {
        return max;
    }

    /**
     * Define el valor de la propiedad max.
     * 
     */
    public void setMax(int value) {
        this.max = value;
    }

    /**
     * Obtiene el valor de la propiedad min.
     * 
     */
    public int getMin() {
        return min;
    }

    /**
     * Define el valor de la propiedad min.
     * 
     */
    public void setMin(int value) {
        this.min = value;
    }

}
