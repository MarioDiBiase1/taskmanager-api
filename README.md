# TaskManager API 🚀

Backend REST API per la gestione di utenti, progetti e task con autenticazione JWT e controllo dei ruoli (USER / ADMIN).

Questo progetto è stato sviluppato con **Spring Boot 3**, **Spring Security** e **PostgreSQL** con architettura a livelli (Controller, Service, Repository).

---

## 🛠️ Tecnologie utilizzate

- Java 17
- Spring Boot 3
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Lombok

---

## 🔐 Autenticazione e Sicurezza

Il sistema utilizza autenticazione stateless tramite JWT.

### Flusso:
1. Login tramite `/auth/login`
2. Generazione token JWT
3. Utilizzo del token nelle richieste successive:

Authorization: Bearer <token>


### Ruoli supportati:
- `USER`
- `ADMIN`

---

## 📌 Funzionalità principali

### 👤 Utenti
- Creazione utente
- Recupero lista utenti (solo ADMIN)
- Recupero utente per ID

### 📁 Progetti
- Creazione progetto associato a un utente
- Visualizzazione progetti

### ✅ Task
- Creazione task associati a un progetto
- Gestione stato task:
- TODO
- IN_PROGRESS
- DONE

---

## 🔑 Endpoint principali

### Auth
- `POST /auth/login` → Login e generazione token JWT

### Users
- `POST /users` → Creazione utente
- `GET /users` → Lista utenti (ADMIN)
- `GET /users/{id}` → Dettaglio utente

### Projects
- `POST /projects/user/{userId}` → Crea progetto per utente
- `GET /projects` → Lista progetti

### Tasks
- `POST /tasks/project/{projectId}` → Crea task
- `GET /tasks` → Lista task

---

## 🧪 Esempio login

**Request**
```json
POST /auth/login
{
"username": "admin",
"password": "1234"
}

Response

{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
🔐 Autorizzazione

Per accedere agli endpoint protetti:

Authorization: Bearer <JWT_TOKEN>
🏗️ Architettura

Il progetto segue una struttura a livelli:

Controller → gestione richieste HTTP
Service → logica di business
Repository → accesso al database
Security → gestione autenticazione JWT
