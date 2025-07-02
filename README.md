# JP Morgan Chase – Midas Core Virtual Internship (Forage)

This repository contains my implementation of the **JP Morgan Chase Software Engineering Virtual Internship** hosted by [Forage](https://www.theforage.com/).  
The project simulates working on **Midas Core**, a microservice designed to process financial transactions securely and efficiently.

Throughout this internship, I worked on real-world inspired engineering tasks involving:
- Kafka event stream processing
- Spring Boot backend development
- JPA & H2 Database integration
- REST API development
- Incentive-based microservice communication

---

## 📁 Project Structure

The project is organized into multiple tasks (Task 1–5), each building upon the previous to construct a full backend financial system.

---

## ✅ Task Breakdown

### 🧩 Task 1: Setup & Dependency Integration

**Objective:**  
Initialize the Midas Core Spring Boot project by:
- Setting up Java 17 and Maven
- Adding the following dependencies:

  | Dependency                | Version  |
  |--------------------------|----------|
  | spring-boot-starter-data-jpa | 3.2.5 |
  | spring-boot-starter-web     | 3.2.5 |
  | spring-kafka                | 3.1.4 |
  | h2                          | 2.2.224 |
  | spring-boot-starter-test    | 3.2.5 |
  | spring-kafka-test           | 3.1.4 |
  | testcontainers-kafka        | 1.19.1 |

**What I did:**
- Forked & cloned the starter repo
- Set up Maven and added all required dependencies in `pom.xml`
- Ensured all initial tests ran successfully

✅ *Passed `TaskOneTests`*

---

### 📦 Task 2: Kafka Integration

**Objective:**  
Implement a Kafka listener that:
- Reads incoming transaction messages
- Uses topic name from `application.yml`
- Deserializes JSON messages to the `Transaction` class

**What I did:**
- Configured a Kafka consumer with Spring Boot
- Implemented listener method using `@KafkaListener`
- Successfully received messages using an embedded Kafka broker for testing

✅ *Passed `TaskTwoTests`*  
🧾 Recorded first 4 transaction amounts using debugger

---

### 🧾 Task 3: H2 Database Integration & Transaction Validation

**Objective:**  
Store valid transactions in a database using the following rules:
- Sender and recipient must exist
- Sender must have sufficient balance
- Valid transactions are saved; others are discarded

**What I did:**
- Created a `TransactionRecord` entity for persistence
- Used JPA to relate transactions to sender/recipient users
- Wrote logic to validate and update balances accordingly

✅ *Passed `TaskThreeTests`*  
💰 Final balance for user `waldorf`: **(rounded integer submitted)**

---

### 🤝 Task 4: Incentive API Integration

**Objective:**  
Enhance transaction processing by:
- Sending each valid transaction to an Incentive API
- Receiving incentive amount as a response
- Adding the incentive to the recipient's balance

**What I did:**
- Used Spring’s `RestTemplate` to POST to `http://localhost:8080/incentive`
- Parsed response into `Incentive` object
- Updated balance logic to account for incentives

✅ *Passed `TaskFourTests`*  
💰 Final balance for user `wilbur`: **(rounded integer submitted)**

---

### 🌐 Task 5: Expose Balance Query API

**Objective:**  
Create a REST API endpoint `/balance` that:
- Accepts `userId` as request parameter
- Returns user’s current balance as JSON
- Returns balance = 0 if user doesn't exist

**What I did:**
- Created a Spring REST controller on port `33400`
- Used JPA to fetch user data
- Returned result in specified `Balance` class format

✅ *Passed `TaskFiveTests`*  
📦 Ensured Incentive API was running during execution

---

## 🛠️ Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot
- **Messaging:** Apache Kafka (embedded for testing)
- **Database:** H2 (in-memory)
- **Tools:** Maven, JPA, Testcontainers, IntelliJ
- **API Integration:** Spring RestTemplate

---

## 💡 Key Learnings

- Implemented end-to-end Spring Boot microservice with Kafka
- Gained hands-on experience in event-driven programming
- Integrated real-time financial incentive processing
- Learned to test applications using embedded Kafka and H2
- Designed and built production-like REST APIs

---

## 📜 Certificate

🧾 [View My JP Morgan Virtual Internship Certificate](# JP Morgan Chase – Midas Core Virtual Internship (Forage)

This repository contains my implementation of the **JP Morgan Chase Software Engineering Virtual Internship** hosted by [Forage]([https://www.theforage.com/](https://www.linkedin.com/in/vaishnavi-kshirsagar-77687728b/details/certifications/)).  
The project simulates working on **Midas Core**, a microservice designed to process financial transactions securely and efficiently.

Throughout this internship, I worked on real-world inspired engineering tasks involving:
- Kafka event stream processing
- Spring Boot backend development
- JPA & H2 Database integration
- REST API development
- Incentive-based microservice communication

---


