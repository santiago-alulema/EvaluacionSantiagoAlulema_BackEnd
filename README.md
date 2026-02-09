# EvaluacionSantiagoAlulema

Proyecto Spring Boot para evaluación técnica.
---

## Requisitos
- Java 17
- Docker Desktop (para PostgreSQL)
- (Opcional) JMeter para pruebas de carga
---

## 1) Levantar Base de Datos (PostgreSQL con Docker)

Ejecutar este comando en una terminal:

```bash
docker run -d --name postgres-evaluacion -e POSTGRES_USER=root -e POSTGRES_PASSWORD=santiagoalulema -e POSTGRES_DB=evaluacion_db -p 5432:5432 postgres:15
```

## 2) Run Project
 Url Base: http://localhost:8092
  
Incluye:

 Ver salidas en consola (Ejercicios 1, 2 y 3)

- Ejercicio 1  
  <img width="381" height="354" alt="image" src="https://github.com/user-attachments/assets/5061eec2-1d78-4857-9b62-208fc2eb8fc3" />

- Ejercicio 2  
  <img width="390" height="55" alt="image" src="https://github.com/user-attachments/assets/b4f9b78b-3a46-40b2-bbbe-46b869061a01" />

- Ejercicio 3  
  <img width="410" height="47" alt="image" src="https://github.com/user-attachments/assets/4b4607f1-9d7e-412b-99e7-37168fb8e320" />



- Implementación 1:
    - consumir `/api/posts/refesh`, sincroniza la base de datos, borra toda la data y inserta la data nueva.
    - consumir `/api/posts/titles?userId=<userId>`, consultar titles por userId
- Implementación 2: consumir `/users` y exponer endpoint `/api/external/users`
- Unit Tests
  - Los test se ejecuta desde EvaluacionSantiagoAlulemaApplicationTests, se realizo dos test.
  <img width="614" height="216" alt="image" src="https://github.com/user-attachments/assets/b762958e-d1f5-41ae-9d8b-1f6ea277c78f" />


---
