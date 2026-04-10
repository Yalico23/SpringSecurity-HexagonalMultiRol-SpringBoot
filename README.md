# SpringSecurity Hexagonal - Multi Rol (Spring Boot)

Este proyecto es una plantilla/ejemplo de una aplicación Spring Boot con arquitectura hexagonal y manejo de roles múltiples.

Puntos importantes:

- Relación Many-to-Many: la implementación actual usa una relación many-to-many directa entre entidades (es decir, sin crear una clase-entidad intermedia explícita en el dominio). Esto se consigue normalmente con las anotaciones JPA (@ManyToMany y @JoinTable) en las entidades. Si prefieres mayor control sobre la relación (por ejemplo, para añadir atributos a la relación, auditarla o manejarla con más precisión), es recomendable crear una entidad intermedia o gestionar la tabla de unión mediante comandos SQL/migraciones (por ejemplo, usando Flyway o scripts DDL). En muchas situaciones de producción, usar una tabla de unión explícita o migraciones SQL ofrece más claridad y control.

- Base de datos por defecto: PostgreSQL. La configuración del proyecto está pensada para usarse con PostgreSQL como base de datos relacional por defecto.

- Modelo no reactivo: este proyecto está construido sobre el modelo tradicional (bloqueante) de Spring Boot — no utiliza programación reactiva (Spring WebFlux/Reactor).

Notas adicionales:
- Si decides migrar a una implementación con entidad intermedia, revisa los mappers y adaptadores para mantener la separación de capas en la arquitectura hexagonal.
- Considera añadir scripts de migración (por ejemplo Flyway o Liquibase) para gestionar el esquema de la base de datos de forma reproducible.

