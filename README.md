# Vendor, Driver, and Vehicle Onboarding & Management System

## 🚀 Overview
This project is a **backend system** built using **Spring Boot** and **MongoDB** for managing vendors, drivers, vehicles, and document uploads. It provides RESTful APIs for onboarding and managing these entities efficiently.

---

## 📌 Features
### ✅ Vendor Management
- Add, update, delete, and retrieve vendors.

### ✅ Driver Management
- Register and manage drivers associated with vendors.
- Upload driver documents (License, Insurance, etc.).

### ✅ Vehicle Management
- Assign vehicles to drivers.
- Store and update vehicle details.

### ✅ Document Upload
- Upload and retrieve driver/vendor documents.
- Store documents in a local directory (or cloud storage like AWS S3).

---

## 🛠️ Tech Stack
- **Spring Boot 3.4.2** (Backend Framework)
- **MongoDB** (Database)
- **Spring Data MongoDB** (ORM)
- **Spring Security** (Authentication & Authorization)
- **Lombok** (Code Simplification)
- **Postman** (API Testing)

---

## ⚙️ Installation & Setup
### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/vendor-management.git
cd vendor-management
```

### 2️⃣ Configure MongoDB Connection
Update `application.properties` or `application.yml` with your **MongoDB connection URI**:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/vendor_management
```

### 3️⃣ Run the Application
```bash
mvn spring-boot:run
```
OR
```bash
java -jar target/vendor-management.jar
```

The server will start at **http://localhost:8080**.

---

## 📖 API Endpoints
### 🚚 Vehicle Management
- **Create Vehicle** → `POST /vehicles`
- **Get All Vehicles** → `GET /vehicles`
- **Get Vehicle by ID** → `GET /vehicles/{id}`
- **Update Vehicle** → `PUT /vehicles/{id}`
- **Delete Vehicle** → `DELETE /vehicles/{id}`

### 👨‍✈️ Driver Management
- **Create Driver** → `POST /drivers`
- **Get All Drivers** → `GET /drivers`
- **Get Driver by ID** → `GET /drivers/{id}`
- **Update Driver** → `PUT /drivers/{id}`
- **Delete Driver** → `DELETE /drivers/{id}`

### 📄 Document Upload
- **Upload Document** → `POST /documents/upload`
- **Get Documents by Owner** → `GET /documents/owner/{ownerId}/{ownerType}`
- **Get Document by ID** → `GET /documents/{id}`
- **Delete Document** → `DELETE /documents/{id}`

---

## 🛠 Sample Postman Requests
### **Upload a Document**
**Endpoint:** `POST /documents/upload`
**Headers:**
```
Content-Type: multipart/form-data
```
**Body (form-data):**
| Key           | Value                        | Type  |
|--------------|------------------------------|------|
| documentName | Driver License               | Text  |
| documentType | License                      | Text  |
| file         | (Select File) `license.pdf`  | File  |
| ownerId      | 65d4c1b98f45678abc123def     | Text  |
| ownerType    | Driver                       | Text  |

---

## 🔐 Authentication & Security
- **Spring Security** is integrated for authentication.
- JWT-based authentication can be added for securing API endpoints.


---

## 📝 License
This project is licensed under the **MIT License**.

---

## 📧 Contact
For any queries, reach out at **bhartiabhishek310@gmail.com**.


