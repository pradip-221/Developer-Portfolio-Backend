# Developer Portfolio – Backend

A RESTful backend application for a personal developer portfolio, built using **Java, Spring Boot, Spring Security, JWT, and MySQL**. It provides APIs to manage profile information, skills, projects, learning activities, contact messages, authentication, and AI-powered chat.

## 🚀 Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- JWT Authentication
- Maven
- REST APIs
- Groq API Integration

## ✨ Features

- Admin registration and login
- JWT-based authentication
- Secure password handling using BCrypt
- Profile management
- Skills management
- Projects management
- Learning journey management
- Contact message management
- AI chatbot integration using Groq API
- MySQL database integration
- RESTful API architecture

## 📂 Project Modules

| Module | Description |
|---|---|
| Profile | Personal information and social links |
| Skills | Technical skills and proficiency |
| Projects | Portfolio project details |
| Learning | Learning progress and topics |
| Contact | Visitor contact messages |
| Admin | Registration and login |
| AI Chat | AI-powered portfolio assistant |

## 🔗 API Endpoints

Base URL: `http://localhost:6767`

| Module | Endpoint |
|---|---|
| Profile | `/profiles` |
| Skills | `/skills` |
| Projects | `/projects` |
| Learning | `/learning` |
| Contact | `/contacts` |
| Admin Register | `/api/admin/register` |
| Admin Login | `/api/admin/login` |
| AI Chat | `/api/ai/chat` |

## ⚙️ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE portfolio;
```

Configure your database connection in `application.properties`:

```properties
server.port=6767

spring.datasource.url=jdbc:mysql://localhost:3306/portfolio
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Configure JWT and Groq API credentials using environment variables. Never commit API keys, JWT secrets, or database passwords to GitHub.

## ▶️ Run Locally

1. Clone the repository:

```bash
git clone YOUR_BACKEND_REPOSITORY_URL
```

2. Open the project in Eclipse or IntelliJ IDEA.

3. Configure MySQL and required environment variables.

4. Build the project:

```bash
mvn clean install
```

5. Run the Spring Boot application:

```bash
mvn spring-boot:run
```

Backend runs at:

```text
http://localhost:6767
```

## 🧪 API Testing

APIs can be tested using **Postman**.

- Test registration and login.
- Test CRUD operations for portfolio modules.
- Verify database records.
- Test AI chat endpoint.

## 👨‍💻 Developer

**Pradip Kannor**

Java Full Stack Developer

- GitHub: https://github.com/pradip-221
- LinkedIn: https://www.linkedin.com/in/pradip-kannor-6b9aba364/

---

⭐ If you find this project useful, feel free to explore the repository.
