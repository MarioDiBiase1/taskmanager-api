# 🚀 TaskManager API

Backend REST API per la gestione di utenti, progetti e task con autenticazione JWT e controllo dei ruoli (**USER / ADMIN**).

Il progetto è sviluppato con **Spring Boot 3**, **Spring Security**, **PostgreSQL** e include documentazione API tramite **Swagger / OpenAPI**.

---

## 🛠️ Tecnologie utilizzate

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

Il sistema utilizza autenticazione stateless tramite JWT.

### 🔄 Flusso autenticazione
1. Login tramite `/auth/login`
2. Generazione token JWT
3. Utilizzo del token nelle richieste successive:

```http
Authorization: Bearer <token>
👥 Ruoli supportati
USER
ADMIN
📌 Funzionalità principali
👤 Utenti
Creazione utente
Recupero lista utenti (solo ADMIN)
Recupero utente per ID
📁 Progetti
Creazione progetto associato a un utente
Visualizzazione progetti
✅ Task
Creazione task associati a un progetto
Gestione stato task:
TODO
IN_PROGRESS
DONE
📖 Documentazione API (Swagger)

Il progetto include Swagger UI per testare e visualizzare le API.

Dopo aver avviato l’applicazione, accedi a:

http://localhost:8080/swagger-ui/index.html
http://localhost:8080/swagger-ui.html
🔑 Endpoint principali
Auth
POST /auth/login → Login e generazione JWT
Users
POST /users → Creazione utente
GET /users → Lista utenti (ADMIN)
GET /users/{id} → Dettaglio utente
Projects
POST /projects/user/{userId} → Crea progetto per utente
GET /projects → Lista progetti
Tasks
POST /tasks/project/{projectId} → Crea task
GET /tasks → Lista task
🧪 Esempio login
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
🏗️ Architettura

Il progetto segue una struttura a livelli:

Controller → gestione richieste HTTP
Service → logica di business
Repository → accesso al database
Security → gestione autenticazione JWT
Swagger/OpenAPI → documentazione API
