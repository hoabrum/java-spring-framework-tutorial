# Student Management App

A JavaFX desktop application for managing student registrations, built with **Spring IoC/DI**, **DAO pattern**, and **Microsoft SQL Server**.

---

## Table of Contents

- [Tech Stack](#tech-stack)
- [Architecture Overview](#architecture-overview)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Database Setup](#database-setup)
- [Configuration](#configuration)
- [Build & Run](#build--run)
- [Class Diagram](#class-diagram)

---

## Tech Stack

| Technology              | Version      | Purpose                          |
|-------------------------|--------------|----------------------------------|
| Java                    | 21           | Core language                    |
| JavaFX                  | 17.0.6       | Desktop UI framework             |
| Spring Context          | 6.1.6        | IoC container & Dependency Injection |
| Microsoft SQL Server    | —            | Relational database              |
| mssql-jdbc              | 13.2.1.jre11 | SQL Server JDBC driver           |
| FontAwesomeFX           | 4.7.0-9.1.2  | UI icons                         |
| Maven                   | 3.x          | Build & dependency management    |
| JUnit Jupiter           | 5.9.2        | Unit testing                     |

---

## Architecture Overview

The application follows a layered architecture with clear separation of concerns:

```
┌─────────────────────────────────────┐
│         JavaFX UI  (FXML)           │
├─────────────────────────────────────┤
│     Controller Layer                │  RegistrationController
│     (Spring @Component)             │  ← @Autowired StudentService
├─────────────────────────────────────┤
│     Service Layer                   │  StudentService (interface)
│     (Spring @Service)               │  StudentServiceImpl
├─────────────────────────────────────┤
│     DAO Layer                       │  StudentDao (interface)
│     (Spring @Repository)            │  StudentDaoImpl
├─────────────────────────────────────┤
│     Database Utility                │  DbUtil → java.sql.Connection @Bean
├─────────────────────────────────────┤
│     Microsoft SQL Server            │
└─────────────────────────────────────┘
```

- **Spring IoC** bootstrapped via `AnnotationConfigApplicationContext` in `Main.java`
- **Spring DI** via constructor injection (`@Autowired`) throughout all layers
- **DAO pattern** isolates all SQL operations from business logic

---

## Project Structure

```
student-management-app/
├── dbscript/
│   └── db_schema.sql               # SQL to create database, table, and seed data
├── diagrams/
│   ├── class-diagram.puml          # PlantUML source for class diagram
│   └── Student_Management_App_Class_Diagram.png
├── src/
│   └── main/
│       ├── java/
│       │   ├── module-info.java
│       │   └── com/code4future/javafxdemo/
│       │       ├── Main.java                        # Application entry point
│       │       ├── config/
│       │       │   └── AppConfig.java               # Spring @Configuration
│       │       ├── controller/
│       │       │   └── RegistrationController.java  # JavaFX controller
│       │       ├── dao/
│       │       │   ├── StudentDao.java              # DAO interface
│       │       │   └── impl/
│       │       │       └── StudentDaoImpl.java      # SQL implementation
│       │       ├── entity/
│       │       │   └── Student.java                 # JavaFX data model
│       │       ├── service/
│       │       │   ├── StudentService.java          # Service interface
│       │       │   └── impl/
│       │       │       └── StudentServiceImpl.java  # Business logic
│       │       └── utils/
│       │           └── DbUtil.java                  # DB connection helper
│       └── resources/
│           ├── config.properties                    # DB credentials (edit this)
│           └── com/code4future/javafxdemo/
│               ├── registration.fxml                # UI layout
│               └── Styles/
│                   └── styles.css
├── pom.xml
├── mvnw          # Maven wrapper (Linux / macOS)
└── mvnw.cmd      # Maven wrapper (Windows)
```

---

## Prerequisites

Ensure the following are installed before proceeding:

| Requirement              | Minimum Version | Notes                                      |
|--------------------------|-----------------|--------------------------------------------|
| JDK                      | 21              | [Download](https://adoptium.net/)          |
| Apache Maven             | 3.8+            | Or use the included `mvnw` / `mvnw.cmd`    |
| Microsoft SQL Server     | 2017+           | SQL Server Express is sufficient           |
| SQL Server Management Studio (SSMS) | any  | Optional — for verifying data              |

> **Tip:** Confirm your Java version with `java -version`. The output must show `21` or higher.

---

## Database Setup

### Step 1 — Start SQL Server

Make sure your SQL Server instance is running and accessible on `localhost:1433`.
Enable **SQL Server Authentication** and ensure the `sa` account (or your chosen account) is active.

### Step 2 — Run the schema script

Open **SSMS** (or any SQL client) and execute the script located at:

```
dbscript/db_schema.sql
```

This script will:
1. Create the `javafx_demo` database
2. Create the `registration` table with columns: `id`, `name`, `phone`, `course`
3. Insert 20 sample student records
4. Run a `SELECT *` to verify the data

```sql
-- Key table structure created by the script:
CREATE TABLE registration (
    id     INT PRIMARY KEY IDENTITY(1,1),
    name   NVARCHAR(100) NOT NULL,
    phone  VARCHAR(20),
    course NVARCHAR(100)
);
```

---

## Configuration

Edit the database connection settings in:

```
src/main/resources/config.properties
```

```properties
db.url=jdbc:sqlserver://localhost:1433;databaseName=javafx_demo;encrypt=true;trustServerCertificate=true
db.username=sa
db.password=123456789
```

| Property      | Description                                           |
|---------------|-------------------------------------------------------|
| `db.url`      | JDBC connection URL — change host/port if needed      |
| `db.username` | SQL Server login username                             |
| `db.password` | SQL Server login password — **change this**           |

> ⚠️ **Security note:** Never commit real credentials to version control.
> Add `config.properties` to `.gitignore` for production projects.

---

## Build & Run

### Option A — Maven Wrapper (recommended, no Maven installation needed)

**Windows:**
```cmd
mvnw.cmd clean javafx:run
```

**Linux / macOS:**
```bash
./mvnw clean javafx:run
```

### Option B — System Maven

```bash
mvn clean javafx:run
```

### Option C — Run from IntelliJ IDEA

1. Open the project: **File → Open** → select the `student-management-app` folder
2. Let IntelliJ import the Maven project (auto-detected via `pom.xml`)
3. Wait for all dependencies to download
4. Open `src/main/java/com/code4future/javafxdemo/Main.java`
5. Click the **▶ Run** button next to `public static void main`

> **Note:** If you see a JavaFX runtime error in IntelliJ, add the following VM option in **Run → Edit Configurations**:
> ```
> --module-path <path-to-javafx-sdk>/lib --add-modules javafx.controls,javafx.fxml
> ```
> The Maven plugin (`javafx-maven-plugin`) handles this automatically when using `mvn javafx:run`.

---

## Using the Application

Once launched, the **Student Registration** window will open:

| Action     | How to use                                                    |
|------------|---------------------------------------------------------------|
| **View**   | All students are loaded into the table automatically          |
| **Add**    | Fill in Name, Phone, Course fields → click **Add**            |
| **Update** | Click a row in the table to select it → edit fields → click **Update** |
| **Delete** | Click a row in the table to select it → click **Delete**      |

---

## Class Diagram

The full system class diagram (PlantUML) is located at:

```
diagrams/class-diagram.puml
diagrams/Student_Management_App_Class_Diagram.png
```

To regenerate the diagram from the `.puml` source:
- **IntelliJ IDEA**: Install the [PlantUML Integration](https://plugins.jetbrains.com/plugin/7177-plantuml-integration) plugin, then open the `.puml` file.
- **Online**: Paste the `.puml` content at [plantuml.com](https://www.plantuml.com/plantuml/uml/).

---

## Troubleshooting

| Problem | Likely Cause | Fix |
|---|---|---|
| `ClassNotFoundException: SQLServerDriver` | JDBC JAR missing | Run `mvn clean install` to re-download dependencies |
| `Connection refused` on port 1433 | SQL Server not running | Start the SQL Server service; check Windows Services or `services.msc` |
| `Login failed for user 'sa'` | Wrong credentials or SA account disabled | Enable SA login in SSMS → Security → Logins → sa → Status: Enabled |
| JavaFX window doesn't appear | JDK 21 not set as project SDK | In IntelliJ: **File → Project Structure → SDK → Java 21** |
| `Module not found` errors | module-info.java conflict | Ensure `module-info.java` opens all required packages (already configured) |
