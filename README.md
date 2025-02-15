# Vendor Cab and Driver Onboarding System

## Overview
The **Vendor Cab and Driver Onboarding System** is a backend solution built using **Spring Boot** and **MongoDB**. It provides a structured multi-level vendor management system that enables **Super Vendors** and **Sub Vendors** to efficiently manage fleets, onboard drivers, and maintain compliance.

## Features
- **Multi-Level Vendor Hierarchy**
  - Super Vendor -> Regional Vendor -> City Vendor -> Local Vendor
  - Role-based access management for structured operations
- **Super Vendor Access & Delegation**
  - Assign and manage sub-vendors
  - Grant permissions to manage fleets and drivers
- **Fleet & Driver Management**
  - Onboard vehicles and assign drivers
  - Document verification for compliance
- **Authentication & Authorization**
  - Secure login with Spring Security
  - Role-based access control
- **Centralized Dashboard for Super Vendors**
  - View all sub-vendors, fleet status, and compliance reports

## Tech Stack
- **Backend:** Spring Boot
- **Database:** MongoDB
- **Security:** Spring Security with JWT Authentication
- **API Testing:** Postman

## Getting Started
### Prerequisites
- Java 17+
- MongoDB installed and running
- Postman for testing API requests

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/vendor-cab-management.git
   cd vendor-cab-management
   ```
2. Configure **MongoDB Connection** in `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/vendor-management
   ```
3. Run the project:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
### Authentication
- **Register a User:** `POST /users/register`
- **Login:** `POST /auth/login`

### Vendor Management
- **Create a Vendor:** `POST /vendors`
- **Get All Vendors:** `GET /vendors`
- **Get Vendor by ID:** `GET /vendors/{id}`
- **Assign Sub-Vendor:** `POST /vendors/{id}/assign`

### Fleet Management
- **Add a Vehicle:** `POST /vehicles`
- **Get All Vehicles:** `GET /vehicles`
- **Assign Driver to Vehicle:** `POST /vehicles/{id}/assign-driver`

## Authentication & Security
- Uses **Spring Security** with **JWT-based authentication**.
- Role-based access control to restrict unauthorized actions.
- Passwords are securely hashed using **BCryptPasswordEncoder**.

## Future Enhancements
- Add **Admin Panel** with a React/Angular frontend.

## Contact
For any queries, feel free to reach out:
- **GitHub:** [codebyAbhishekBharti](https://github.com/codebyAbhishekBharti)
- **Email:** bhartiabhishek310@gmail.com

