# Prueba Tecnica Inditex

* Realizada entre los dias 20/09/2024 y 21/09/2024
* Este repositorio contiene la solución a la prueba técnica propuesta por Inditex.
* El objetivo es crear un servicio REST para consultar precios de productos basado en una base de datos H2 en memoria.

### Swagger de Prices Api Rest

* [URL de Api rates en OpenApi](http://localhost:8080/swagger-ui/swagger-ui/index.html)

## Tecnologías Utilizadas

* Java 17
* Spring Boot 3.3.4
* H2 Database
* Maven
* JUnit y Mockito 
* Lombok
* GitHub

### Arquitectura

El proyecto fue desarrollado con una arquitectura en capas, donde cada capa tiene una responsabilidad bien definida:

* Controller: Gestiona las solicitudes HTTP y devuelve las respuestas adecuadas. Se utilizo Spring MVC para la creación de endpoints.
* Service: Contiene la lógica de negocio y se encarga de interactuar con la capa de datos.
* Repository: Se encarga de la persistencia y acceso a la base de datos. Utiliza Spring Data JPA.

20/10/2024: El proyecto fue refactorizado a una arquitectura Hexagonal definiendo la siguiente estructura:

* Domain: Esta capa contiene las entidades del dominio y los puertos que permiten a la lógica de negocio interactuar con el exterior.
* Aplication: Contiene la lógica de los casos de uso que utilizan los puertos del dominio.
* Infrastructure: Recibe los datos de entrada y salida mediante el controlador que interactua con la aplicacion y la persistencia que conecta con la base de datos para realizar las operaciones necesarias. 

## Patrones de Diseño

* DTO (Data Transfer Object): Para transferir datos entre la capa de servicio y la capa de controlador sin exponer directamente las entidades de la base de datos.
* Mapper: Se utiliza un Mapper para transformar entidades en DTOs y viceversa.
* Inyección de dependencias: Se hace uso de de anotaciones tales como `@RequiredArgsConstructor` para gestionar las dependencias entre componentes.

## Requisitos
 * Java 17+
 * Maven
 * Tener disponible el puerto 8080.

## Ejecución del Proyecto (Git Bash)
1. Clonar el repositorio.
2. Navegar hasta el directorio del proyecto.
3. Compilar el proyecto.
4. Ejecutar la aplicacion.
5. La API estara disponible en http://localhost:8080

## Endpoints

* GET /v1/api/prices?applicationDate={fecha}&productId={producto}&brandId={marca}

* Parámetros:
  - applicationDate: Fecha y hora en el formato yyyy-MM-dd HH:mm:ss.
  - productId: ID del producto.
  - brandId: ID de la marca.