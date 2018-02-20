# Cache Integration

La integración de cache en el proyecto se realiza mediante [caffeine](https://github.com/ben-manes/caffeine). Para ello
se debe incluir la librería como dependencia en el pom.

Las siguientes anotaciones se usan para gestionar el funcionamiento de la cache:

* `#!java @Cacheable("cache-name")` : cachea el resultado de un método
* `#!java @CachePut(value = "cache-name", key = "#SpEL")`: modifica el objeto almacenado en cache si la key se modifica
* `#!java @CacheEvict(value = "reports")`: elimina el objeto de cache
