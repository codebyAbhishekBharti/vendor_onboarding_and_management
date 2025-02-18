# Vendor, Driver, and Vehicle Onboarding & Management System

## 🚀 Overview
This project is a **backend system** built using **Spring Boot** and **MongoDB** for managing vendors, drivers, vehicles, and document uploads. It provides RESTful APIs for onboarding and managing these entities efficiently, supporting multi-level hierarchy and role-based access control (RBAC).

---

## ✨ Features

### 🏢 Multi-level Hierarchy Support  
- Vendors can create and manage sub-vendors with inherited permissions.  
- Ensures structured vendor relationships and delegation of responsibilities.  

### 🔐 Role-based Access Control (RBAC)  
- API requests pass through middleware to validate user permissions.  
- Fine-grained access control ensures security and proper authorization.  

### 🚀 Vendor Onboarding & Management  
- Register, update, and remove vendor accounts seamlessly.  
- Assign and manage permissions for vendors and sub-vendors.  

### 🚖 Driver Onboarding & Management  
- Add, update, and manage driver profiles with assigned vendors.  
- Track driver activity and ensure compliance with vendor policies.  

### 🚚 Vehicle Onboarding & Management  
- Register and manage vehicles, linking them with assigned drivers.  
- Maintain vehicle status, availability, and operational history.  

### ✅ Document Upload  
- Upload and retrieve important documents for vendors and drivers.  
- Store documents securely in a local directory or cloud storage (e.g., AWS S3).  



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

## 📧 Contact
For any queries, reach out at **bhartiabhishek310@gmail.com**.


