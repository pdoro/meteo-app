//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2017.12.20 a las 08:16:55 PM CET 
//


package com.pdomingo.entities.soap_xml;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="meteo_report" type="{http://127.0.0.1/ws}report"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
