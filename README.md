
# 🧩 Product Sorting Service

Servicio REST desarrollado para el caso práctico. Permite ordenar productos de una categoría de camisetas según criterios ponderados (ventas y ratio de stock), aplicando arquitectura hexagonal y principios de Domain-Driven Design (DDD).

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3.5.0
- MongoDB 8
- Arquitectura Hexagonal (Ports & Adapters)
- DDD Táctico
- REST API
- JUnit 5, Rest Assured
- Docker & Docker Compose

---

## 📐 Arquitectura Hexagonal

```
               [ REST Controller ]
                       │
               [ Use Case Layer ]
                       │
           [ Domain: Model + Service ]
                       │
            [ MongoDB Adapter Output ]
```

- **Dominio**: Contiene las entidades ricas (`Product`) y lógica de negocio (`ProductScoringService`).
- **Aplicación**: Contiene el caso de uso (`ProductUseCases`) sin dependencias externas.
- **Infraestructura**: Implementa los adaptadores de entrada (REST) y salida (MongoDB).
- **Tests**: Incluye pruebas unitarias, de integración y E2E con Rest Assured.

---

## 🗂️ Estructura del proyecto

```
src/
├── main/
│   ├── java/com.example.productsorting/
│   │   └── product
│   │       ├── domain/          → Entidades y lógica de negocio
│   │       ├── application/     → Casos de uso
│   │       ├── infrastructure/  → REST y persistencia Mongo
│   │       └── ProductSortingApplication.java
│   └── resources/
│       └── application.yml
└── test/
    └── java/com.example.productsorting/
        ├── unit/
        ├── integration/
        └── e2e/
```

---

## 📦 Levantar el proyecto localmente

### 1. Clonar o descomprimir el proyecto

```bash
git clone https://github.com/jprieto96/product-sorting-api.git
cd product-sorting-api
```

```bash
unzip product-sorting-api.zip
cd product-sorting-api
```

### 2. Levantar MongoDB con Docker

```bash
docker-compose up -d
```

Mongo se levantará en `localhost:27017`.

### 3. Ejecutar el servicio

Puedes ejecutar el proyecto desde tu IDE favorito o con Maven:

```bash
./mvnw spring-boot:run
```
Al ejecutar el servicio se ejecutará automáticamente una inserción en mongo con una colección para poder probar la ordenación posteriormente:

```
ID Name Sales_Units Stocks
1 V-NECK BASIC SHIRT 100 S:4 / M:9 / L:0
2 CONTRASTING FABRIC T-SHIRT 50 S:35 / M:9 / L:9
3 RAISED PRINT T-SHIRT 80 S:20 / M:2 / L:20
4 PLEATED T-SHIRT 3 S:25 / M:30 / L:10
5 CONTRASTING LACE T-SHIRT 650 S:0 / M:1 / L:0
6 SLOGAN T-SHIRT 20 S:9 / M:2 / L:5
```

---

## 🧪 Ejemplo de uso de la API

### Endpoint: `POST /products/sort`

```http
POST http://localhost:8080/products/sort
Content-Type: application/json

{
  "weightSales": 1,
  "weightStockRatio": 50
}
```

### Respuesta

```json
[
  {
    "id": "2",
    "name": "CONTRASTING FABRIC T-SHIRT"
  },
  {
    "id": "3",
    "name": "RAISED PRINT T-SHIRT"
  }
]
```

---

## ✅ Tests

```bash
# Ejecutar todos los tests
./mvnw test
```

- **unit/**: Test de la lógica de puntuación
- **integration/**: Test de persistencia con MongoDB
- **e2e/**: Test de API completa usando SpringBootTest + RestAssured

---

## 🧠 Mejora futura

- Añadir más criterios de puntuación (modularización ya preparada)
- Utilizar mockito para mockear las llamadas a mongo en los tests de integración
- Añadir documentación Swagger

---

## 👨‍💻 Autor

Desarrollado por Jose Prieto.

---
