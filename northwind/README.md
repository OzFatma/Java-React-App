#####1-Spring Initializr 
spring-boot-devtools,
 
lombok,
 
spring-boot-starter-web,
 
spring-boot-starter-data-jpa, 

postgresql

#####2-File/import/maven/existing project
#####3-Katmanların oluşturulması
core, entities, data access, business, api
#####4-entities
c-Product
#####5-data/abstracts
i-ProductDao 

extends JpaRepository<>
#####6-data/concretes
#####7-business/abstracts
i-ProductService

List<> getAll()
#####8-business/concretes
c-ProductManager

implements ProductService

Service, Autowired annotation
#####9-api
c-ProductsController

Annotation: RestController, RequestMapping, GetMapping, Autowired

#####Swagger Entegrasyonu
google : enable swagger in spring boot

https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api

#####NorthwindApplication.java 
swager configure edildi. 

application propertiesde port ayarı ve springfox bug düzeltme işlemi yapıldı.

#####core/utilities/result
c-Result


