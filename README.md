# Microservicio de Usuario

Este microservicio maneja operaciones relacionadas con usuarios, incluyendo la creación, actualización, eliminación y recuperación de información de usuarios. Utiliza Spring Boot y se comunica con una base de datos MySQL.

## Endpoints de la API

### 1. Listar Usuarios

**Endpoint:** `GET /`

Devuelve una lista de todos los usuarios almacenados en la base de datos.

### 2. Detalle de Usuario

**Endpoint:** `GET /{id}`

Devuelve los detalles de un usuario específico según su ID.

### 3. Crear Usuario

**Endpoint:** `POST /`

Crea un nuevo usuario y lo guarda en la base de datos.

### 4. Editar Usuario

**Endpoint:** `PUT /{id}`

Actualiza la información de un usuario existente según su ID.

### 5. Eliminar Usuario

**Endpoint:** `DELETE /{id}`

Elimina un usuario según su ID.

### 6. Obtener Usuarios por Curso

**Endpoint:** `GET /user-course?id={id1}&id={id2}&...`

Devuelve una lista de usuarios asociados a los IDs de curso proporcionados.

## Configuración

### 1. Configuración de la Aplicación

```properties
spring.application.name=microservice-user
server.port=8001
```

## Tecnologías Utilizadas

Este microservicio utiliza diversas tecnologías y frameworks para su implementación:

- **Spring Boot:** Framework de aplicación de Java para crear servicios basados en Spring.
- **Spring Cloud OpenFeign:** Cliente declarativo para realizar llamadas REST en servicios.
- **Spring Web:** Módulo de Spring para el desarrollo de aplicaciones web.
- **Spring Data JPA:** Parte del proyecto Spring Data, proporciona un modelo de programación basado en Spring y Hibernate.
- **Spring Boot DevTools:** Herramientas de desarrollo para mejorar la productividad durante el desarrollo de aplicaciones Spring Boot.

## Referencias Adicionales

Para obtener más información sobre el uso de estas tecnologías, consulta las siguientes secciones de documentación:

- [Documentación oficial de Apache Maven](https://maven.apache.org/guides/index.html): Guía para el sistema de gestión de proyectos Apache Maven.
- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/html/): Referencia del plugin Maven para Spring Boot.
- [Crear una imagen OCI](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-image): Guía para crear una imagen de contenedor OCI con Spring Boot.
- [OpenFeign](https://spring.io/projects/spring-cloud-openfeign): Documentación oficial para Spring Cloud OpenFeign.
- [Spring Web](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html): Documentación para el módulo Spring Web.
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference): Documentación para el módulo Spring Data JPA.
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.development-tools): Documentación sobre el uso de las herramientas de desarrollo de Spring Boot.
