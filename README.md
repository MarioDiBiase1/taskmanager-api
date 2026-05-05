# 🚀 TaskManager API

Backend REST API per la gestione di utenti, progetti e task con autenticazione JWT e controllo dei ruoli (**USER / ADMIN**).

Il progetto è sviluppato con **Spring Boot 3**, **Spring Security**, **PostgreSQL** e documentazione API tramite **Swagger / OpenAPI**.

---

## 🧱 Tecnologie utilizzate

- Java 17  
- Spring Boot 3  
- Spring Security  
- JWT (JSON Web Token)  
- Spring Data JPA / Hibernate  
- PostgreSQL  
- Swagger / OpenAPI (springdoc)  
- Maven  
- Lombok  

---

## 🔐 Autenticazione e Sicurezza

Il sistema utilizza autenticazione **stateless** basata su JWT.

### 🔄 Flusso di autenticazione
1. Login tramite endpoint `/auth/login`
2. Generazione token JWT
3. Invio del token nelle richieste protette


Authorization: Bearer <JWT_TOKEN>

👥 Ruoli disponibili

USER

ADMIN

📌 Funzionalità principali

👤 Gestione utenti

Registrazione utente

Recupero lista utenti (solo ADMIN)

Recupero utente per ID

📁 Gestione progetti

Creazione progetto associato a un utente

Visualizzazione progetti

✅ Gestione task

Creazione task associati a un progetto

Gestione stato task:

TODO

IN_PROGRESS

DONE

📖 Documentazione API (Swagger)

Il progetto include Swagger UI per testare e documentare le API.

Dopo l’avvio dell’applicazione:

👉 Swagger UI:

http://localhost:8080/swagger-ui/index.html

http://localhost:8080/swagger-ui.html

🔑 Endpoint principali

🔐 Auth

POST /auth/login → Login e generazione JWT

👤 Users

POST /users → Creazione utente

GET /users → Lista utenti (ADMIN)

GET /users/{id} → Dettaglio utente

📁 Projects

POST /projects/user/{userId} → Crea progetto per utente

GET /projects → Lista progetti

✅ Tasks

POST /tasks/project/{projectId} → Crea task

GET /tasks → Lista task

🧪 Esempio di utilizzo

Request

POST /auth/login
{
  "username": "admin",
  "password": "1234"
}

Response
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}

🏗️ Architettura del progetto

Il progetto segue un’architettura a livelli:

Controller → gestione delle richieste HTTP

Service → logica di business

Repository → accesso al database

Security → autenticazione e autorizzazione JWT

Swagger/OpenAPI → documentazione delle API

📌 Note

API protette tramite JWT

Accesso differenziato per ruolo (USER / ADMIN)

Documentazione interattiva tramite Swagger
