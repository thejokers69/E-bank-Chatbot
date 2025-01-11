# E-Bank Chatbot

E-Bank Chatbot is a project aimed at developing a web application to facilitate interactions with a virtual bank via an intelligent chatbot. This project combines a Java backend with Spring Boot and a modern frontend using technologies like TypeScript and Vite.

## Project Structure

The project is organized into two main parts:
- **Backend**: Developed in Java with Spring Boot, it contains the main services, REST controllers, and necessary configurations.
- **Frontend**: Built with TypeScript, Vite, and React, it provides an interactive and responsive user interface.

## Main Content

### Backend
- AI services for managing chatbot interactions.
- Data management with JSON files and dynamic loading.
- REST API for communication with the frontend.


### Frontend
- Automatic generation of TypeScript files from backend endpoints.
- Views and components to manage the user interface.
- Integration with the backend via generated files.

## Important Files and Folders

- `compose.yaml`: Docker Compose configuration file.
- `pom.xml`: Maven configuration for the Java project.
- `package.json`: Frontend dependency management.
- `application.properties`: Spring Boot properties configuration.
- `prompts/`: Prompt templates for chatbot AI management.
- `store/`: Persistent data storage in JSON files.

## Commands Used

### Git Initialization
```bash
git init
git remote add origin https://github.com/thejokers69/E-Bank-Chatbot.git
git add .
git commit -m "Initial commit for E-Bank-Chatbot"
git push -f origin master
```

### Technologies Used
Backend
- Java
- Spring Boot
- Maven

Frontend
- TypeScript
- Vite
- React

Miscellaneous Tools
- Docker and Docker Compose
- IntelliJ IDEA for development

## How to Start the Project

1. Clone the repository:
```bash
git clone https://github.com/thejokers69/E-Bank-Chatbot.git
cd E-Bank-Chatbot
```

2. Build the backend:
```bash
cd backend
./mvnw clean install
./mvnw spring-boot:run
```

3. Start the frontend:
```bash
cd src/main/frontend
npm install
npm run dev
```

4. Launch via Docker Compose (optional):
```bash
docker-compose up
```

## Author: Mohamed Lakssir 2ACI Info
```