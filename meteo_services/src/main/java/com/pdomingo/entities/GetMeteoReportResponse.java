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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meteo_report" type="{http://pdomingo.com/ws}report"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "meteoReport"
})
@XmlRootElement(name = "getMeteoReportResponse")
public class GetMeteoReportResponse {

    @XmlElement(name = "meteo_report", required = true)
    protected Report meteoReport;

    /**
     * Obtiene el valor de la propiedad meteoReport.
     * 
     * @return
     *     possible object is
     *     {@link Report }
     *     
     */
    public Report getMeteoReport() {
        return meteoReport;
    }

    /**
     * Define el valor de la propiedad meteoReport.
     * 
     * @param value
     *     allowed object is
     *     {@link Report }
     *     
     */
    public void setMeteoReport(Report value) {
        this.meteoReport = value;
    }

}