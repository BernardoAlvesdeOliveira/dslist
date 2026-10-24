# Game List System

## Project Description
This project is the backend of a system that manages and stores games in list format within an SQL database. It allows changing the position of a specific game, for example, moving it from first place to third place.

## License
This project is licensed under the **MIT** license. For more information, see the `LICENSE` file.

## Technologies and Frameworks
- **Java**
- **Spring Boot**
- **Dockerfile**
- **PostgreSQL**

## How to Install and Configure the Project

1. **Clone the project repository** to your machine:

    ```bash
    git clone <REPOSITORY_URL>
    ```

2. **Install Spring Boot dependencies** on your machine.

3. **Run the project** by following the steps below according to your operating system:

### For Windows:
- Open the terminal and navigate to the folder containing the `mvnw.cmd` file.
- Run the following command:

    ```bash
    mvnw.cmd spring-boot:run
    ```
- The system will run at: `http://localhost:8080`.

### For Linux/Mac:
- Open the terminal and navigate to the folder containing the `mvnw` file.
- Run the following command:

    ```bash
    ./mvnw spring-boot:run
    ```
- The system will run at: `http://localhost:8080`.

---

## How to Use the Project

Since this is only a backend application, you will need API development and testing software such as **Postman**.

### Available Commands:

#### **GET** (to query database information):
- List all games:
    ```
    http://localhost:8080/games
    ```
- Get a specific game by ID (ID from the `TB_GAME` table):
    ```
    http://localhost:8080/games/{id}
    ```
- List all lists:
    ```
    http://localhost:8080/lists
    ```
- List games within a specific list:
    ```
    http://localhost:8080/list/{id}/games
    ```

#### **POST** (to change a game's position in a list):
- Replace the position of a specific game:
    ```
    http://localhost:8080/lists/{id}/replacement
    ```

---

## Credits

### Instructor who taught how to build this project:
[Devsuperior](https://github.com/devsuperior)
