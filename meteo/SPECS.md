# Especificaciones básicas del proyecto

La necesidad primordial es aprender el funcionamiento de las siguientes tecnologías
del ecosistema java-spring

Prioridad 1
* Spring Boot
* Spring MVC
* Spring Security
* Spring Cache
* Jackson
* Java 8

Prioridad 2
* LDAP
* Spring Data
* Spring DevTools
* Spring Actuator
* Log4j2
* WebServices

Prioridad 3
* Liquidbase
* ActimeMQ

---------------

Sería muy interesante proveer datos desde una base de datos y accediendo como proxy
a otro servicio web. Para incluir varias tecnologías de manera sencilla, articular el
proyecto como múltiples contenedores de docker mediante docker-compose

* Servicio principal
* Base de datos (Postgres)
* Otra aplicación spring que ofrezca servicios SOAP y REST

---------------

La lógica de negocio de la aplicación debería ser sencilla, sin interfaz web dedicada,
sólo un servicio REST.

Aplicacion REST de consulta meteorológica

Permitirá consultar por ciudad y optionalmente fecha los datos meterológicos de la
localización. Datos a presentar:

* Ciudad
* Altitud
* Temperatura 
    * Mínima
    * Máxima
* Lluvia
    * Humedad
    * Probabilidad de lluvia
    * Probabilidad de nieve
* Viento
    * Direccion
    * Velocidad
* Factor ultravioleta
* Advertencias

------------------

Especificaciones para la base de datos




------------------

--- Articulos utiles ---
https://blog.codecentric.de/en/2017/08/parsing-of-localdate-query-parameters-in-spring-boot/
https://stackoverflow.com/questions/23894010/spring-boot-security-disable-security
http://www.baeldung.com/spring-requestmapping







