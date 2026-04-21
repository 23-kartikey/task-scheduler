# 🚀 Task Scheduler System

A backend system to schedule, manage, and execute tasks efficiently using **Spring Boot**, **PostgreSQL**, and **Redis caching**.

---

## 📌 Overview

The Task Scheduler System is designed to handle task creation, scheduling, and execution in a scalable and efficient manner. It provides REST APIs to manage tasks while leveraging Redis for caching to improve performance and reduce database load.

---

## ⚙️ Tech Stack

- **Backend:** Java, Spring Boot
- **Database:** PostgreSQL
- **Caching:** Redis
- **Build Tool:** Maven
- **Tools:** Docker, Postman

---

## ✨ Features

- Create, update, delete, and retrieve scheduled tasks
- Efficient task scheduling and execution handling
- RESTful API design with clean architecture
- Redis caching for faster data access and reduced DB queries
- Persistent storage using PostgreSQL
- Scalable backend structure following best practices

---

## 🧠 Architecture

- **Controller Layer** → Handles API requests  
- **Service Layer** → Business logic and scheduling  
- **Repository Layer** → Database interactions (PostgreSQL)  
- **Cache Layer** → Redis for performance optimization  

---

## 🔥 Key Highlights

- Integrated **Redis caching** to reduce database hits and improve API response time  
- Designed **efficient data models** for task persistence using PostgreSQL  
- Built with **layered architecture** for maintainability and scalability  
- Optimized backend logic for handling scheduled operations  

---

## 📡 API Endpoints

| Method | Endpoint            | Description              |
|--------|--------------------|--------------------------|
| POST   | /tasks             | Create a new task        |
| GET    | /tasks             | Get all tasks            |
| GET    | /tasks/{id}        | Get task by ID           |
| PUT    | /tasks/{id}        | Update a task            |
| DELETE | /tasks/{id}        | Delete a task            |

---

## 🛠️ Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/23-kartikey/task-scheduler.git
cd task-scheduler
