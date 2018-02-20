# Mongo Integration

La integración con Mongo se realiza mediante Spring Data. Para ello se crea un repositorio ReportMongoRepository que extiende
la interfaz proporcionada MongoRepository<T, S> siendo T la clase del dominio a almacenar y S su identificador (generalmente String)

```java
interface ReportMongoRepository extends MongoRepository<WeatherReport, String>
```

Al igual que el resto de repositorios de Spring Data se pueden definir metodos a partir del nombre del metodo

```java
Optional<WeatherReport> findByCityName(String cityName);
```

Para editar la configuración de mongo se puede hacer a través del fichero properties de spring boot.

```yaml
spring.data.mongodb:
    host: mongo
    port: 27017
```
