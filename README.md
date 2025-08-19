# 📝 Foro API - Spring Boot + JWT

Este proyecto es una **API REST de Foros** desarrollada con **Spring Boot**, que incluye autenticación mediante **JWT (JSON Web Token)**.  
Los usuarios pueden registrarse, iniciar sesión y crear publicaciones en foros.

---

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
  - Spring Web
  - Spring Data JPA
  - Spring Security + JWT
- **H2 Database** (modo desarrollo)
- **Maven**
- **Postman** (para pruebas de la API)

---

## ⚙️ Instalación y ejecución

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tuusuario/foro-api.git
🔑 Endpoints principales
🔐 Autenticación

POST /auth/register → Registrar un nuevo usuario

{
  "username": "fernando",
  "password": "123456"
}

POST /auth/login → Iniciar sesión (retorna un JWT)

{
  "username": "fernando",
  "password": "123456"
}

📌 Foros

(Se requiere token JWT en Authorization: Bearer <token>)

POST /foros → Crear un foro

{
  "titulo": "Primer foro",
  "contenido": "Este es mi primer foro en la app"
}


GET /foros → Listar todos los foros

GET /foros/{id} → Obtener un foro por ID


📂 Estructura del proyecto
src/main/java/com/tuusuario/foro
│── controller     # Controladores REST
│── entity         # Entidades (User, Foro)
│── repository     # Repositorios JPA
│── security       # Configuración JWT y filtros
│── service        # Lógica de negocio

🛡️ Seguridad con JWT

El usuario se registra o inicia sesión.

Se genera un token JWT.

Para acceder a los endpoints de foros, se debe enviar el token en el header Authorization:

Authorization: Bearer <tu_token_jwt>

👨‍💻 Autor

Desarrollado por Fernando Ibarra
