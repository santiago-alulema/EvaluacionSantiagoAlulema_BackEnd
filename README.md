# EvaluacionSantiagoAlulema

Proyecto Spring Boot para evaluación técnica.
---

## 1) Levantar Base de Datos (PostgreSQL con Docker)

Ejecutar este comando en una terminal:

```bash
docker run -d --name postgres-evaluacion -e POSTGRES_USER=root -e POSTGRES_PASSWORD=santiagoalulema -e POSTGRES_DB=evaluacion_db -p 5432:5432 postgres:15
```

## 2) Run Project

Incluye:
- Ejercicios 1, 2 y 3 ejecutándose al iniciar la aplicación (CommandLineRunner)
- Implementación 1:
    - consumir `/api/posts/refesh`, sincroniza la base de datos, borra toda la data y inserta la data nueva.
    - consumir `/api/posts/titles?userId=<userId>`, consultar titles por userId
- Implementación 2: consumir `/users` y exponer endpoint `/api/external/users`
- Unit Tests

---

## Requisitos
- Java 17
- Docker Desktop (para PostgreSQL)
- (Opcional) JMeter para pruebas de carga
