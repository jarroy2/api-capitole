# API Pricing - Capitole

Este proyecto es una implementación de una API REST en **Java** con **Spring Boot** utilizando principios de **arquitectura hexagonal**.  
El propósito es consultar precios aplicables de productos de una cadena comercial en una fecha específica.

---

## Arquitectura

La arquitectura hexagonal (Ports & Adapters) está estructurada en:

- **Domain**: Entidades del negocio y lógica interna (pure Java).
- **Application**: Lógica de negocio (casos de uso y servicios).
- **Infrastructure**: Adaptadores de entrada (REST Controller) y salida (Base de datos, mappers, DTOs).

Esta separación garantiza que el núcleo de negocio sea independiente de frameworks, bases de datos o herramientas externas.

---


### Capas principales:
- application.service: Contiene los servicios de aplicación (puertos primarios).

- domain.model: Modelos de dominio puros sin dependencia de frameworks.

- domain.repository: Puertos secundarios (interfaces de repositorios de dominio).

- infrastructure.database.h2:

- adapter: Implementaciones de los puertos secundarios usando H2 + JPA.

- entity: Entidades JPA.

- mapper: Conversores entre entidades y modelos de dominio.

- rest.controller: Controladores que exponen endpoints REST.

- rest.dto.response: Define DTOs hacia los end-point del API REST
- rest.dto.mapper: mappers que se usan para exponer datos al exterior (DTO).

### Flujo de ejecución

1. El cliente realiza una solicitud GET /api/price pasando productId, brandId, y application date.

2. El controller recibe la petición y llama al PriceService.

3. El PriceService consulta el PriceRepository (puerto del dominio).

4. El PriceRepositoryAdapter interactúa con la base de datos H2 para recuperar la información.

5. Se retorna un PriceDto mapeado al cliente si existe un precio aplicable.

### Endpoints disponibles

Método	URL	Descripción

GET	/api/price	Devuelve el precio aplicable para un producto y marca

Ejemplo de request

```bash
curl -X GET "http://localhost:8080/api/price?productId=35455&brandId=1&date=2020-06-14T10:00:00"
```

### Principios aplicados

- Arquitectura Hexagonal (Ports and Adapters).
- Separación de responsabilidades.
- Uso de DTOs para no exponer entidades directamente.
- Mappers para transformación de datos.
- Inversión de dependencias: la aplicación no depende de la infraestructura.
- OpenAPI para la autogeneración de la documentación de la API.
- Dockerfile para la generación de la imagen
- docker-compose para la validación y ejecución de la imagen

### Ejecución local

1. Clona el repositorio:

```bash
git clone https://github.com/jarroy2/api-capitole.git

cd api-capitole
```

2. Ejecuta el proyecto:

```bash
./mvnw spring-boot:run
```

3. Accede a Swagger:

```bash
http://localhost:8080/swagger-ui/index.html
```


### Ejecución para generar la imagen (pasos para un pipeline)

1. Empaquetar la app y correr tests
```bash
./mvnw clean package -DskipTests=false
```

2. Empaquetar la app y sin correr los test y generar la versión de prod (profile prod)
- NOTA: Para ejecutar esta opción se debe tener Maven instalado y configurado en la variable de entorno
```bash
mvn clean package -Dspring.profiles.active=prod -DskipTests
```

3. Empaquetar la app y sin correr los test y generar la versión de prod (profile prod)
```bash
cd environment && docker-compose up --build 
```

4. Una vez corra correctamente los container detener la ejecución 
```bash
docker-compose down && cd ../
```

### Notas
La base de datos H2 se levanta en memoria, por lo que los datos se reinician al reiniciar la aplicación.

Los registros de prueba se cargan automáticamente al inicio (si agregas un data.sql).

🙌 Autor
Jonathan Arroyo Reina

https://www.linkedin.com/in/jonathan-arroyo-reina/ | https://github.com/jarroy2/api-capitole