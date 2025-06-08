# AI Chatbot Web Application

This is a simple AI chatbot web application built with HTML, CSS, JavaScript, and Java Spring Boot.

## Features

- Modern and responsive chat interface
- Real-time message handling
- Simple AI response system
- RESTful API backend

## Prerequisites

- Java 11 or higher
- Maven
- Web browser

## Setup and Running

1. Clone the repository:
```bash
git clone <your-repository-url>
cd ai-chatbot
```

2. Build the Java backend:
```bash
mvn clean install
```

3. Run the Spring Boot application:
```bash
mvn spring-boot:run
```

4. Open the `index.html` file in your web browser or serve it using a local web server.

## Project Structure

- `index.html` - Main HTML file
- `styles.css` - CSS styles
- `script.js` - Frontend JavaScript
- `src/main/java/com/aichatbot/` - Java backend code
  - `ChatbotApplication.java` - Main application class
  - `controller/ChatController.java` - REST API controller
  - `model/AIModel.java` - AI logic implementation

## Customization

You can customize the AI responses by modifying the `initializeResponses()` method in `AIModel.java`. Add more response patterns and their corresponding replies to make the chatbot more intelligent.

## Deployment

To deploy this application:

1. Build the Java backend:
```bash
mvn clean package
```

2. Deploy the generated JAR file to your server
3. Host the frontend files (HTML, CSS, JS) on a web server
4. Update the API endpoint in `script.js` to point to your server's URL

## Contributing

Feel free to submit issues and enhancement requests! 