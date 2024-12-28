# Library Management System

## Overview
This project is a **Library Management System** developed in Java, featuring a graphical user interface (GUI) built with JavaFX. It implements fundamental principles of Object-Oriented Programming (OOP), follows the SOLID principles, and incorporates design patterns to ensure a robust and scalable application.

## Features
1. **Add Book**: Users can add books by entering the title, author, and category.
2. **Show Books**: Users can view all the added books in a table format within the application.

## Requirements
To run this project, ensure you have the following installed:
1. **Java Development Kit (JDK)** (version 11 or higher recommended).
2. **JavaFX SDK** (download and extract the SDK; ensure the path is configured in your project).
3. A text editor or IDE like **Visual Studio Code**, **IntelliJ IDEA**, or **Eclipse**.

## Installation and Setup
1. **Download JavaFX SDK**:
   - Download from [JavaFX Downloads](https://gluonhq.com/products/javafx/).
   - Extract the files and place the folder in the same directory as the project or configure the path.

2. **Compile and Run the Application**:
   - Open a terminal in the project folder.
   - Use the following commands to compile and run the application:
     ```bash
     javac --module-path ./javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml LibraryApp.java
     java --module-path ./javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml LibraryApp
     ```

3. **Run with Executable File**:
   - Double-click the `runLibraryApp.bat` file to execute the application. This file also ensures the terminal window closes after launch.

## Object-Oriented Principles
### OOP Principles Used
1. **Encapsulation**: The `Book` class uses private fields with getter and setter methods to manage access.
2. **Abstraction**: The application separates concerns:
   - `Book`: Represents the data structure of a book.
   - `BookManager`: Manages book-related operations.
   - `LibraryApp`: Handles the GUI and user interaction.
3. **Polymorphism**: The project can be extended to include new types of operations or GUI components.
4. **Inheritance**: Not directly implemented but easily extendable.

## SOLID Principles
1. **Single Responsibility Principle (SRP)**:
   - `Book`: Represents book data.
   - `BookManager`: Manages book operations.
   - `LibraryApp`: Manages GUI and user interactions.
2. **Open/Closed Principle (OCP)**:
   - The system is open for extension (e.g., adding new features like book search) but closed for modification.
3. **Liskov Substitution Principle (LSP)**:
   - Maintains compatibility and correctness when extending functionality.
4. **Interface Segregation Principle (ISP)**:
   - The project is modular; each component has a specific responsibility.
5. **Dependency Inversion Principle (DIP)**:
   - Separates high-level GUI logic from low-level book management operations.

## Design Patterns
- **Singleton Pattern**: Applied to the `BookManager` class to ensure only one instance manages book data.
- Future extensions can include:
  - **Observer Pattern**: For notifications or updates.
  - **Factory Pattern**: For creating various types of book objects.

## Files and Directories
1. **Main Files**:
   - `LibraryApp.java`: The entry point of the application.
   - `Book.java`: Represents the book entity.
   - `BookManager.java`: Handles book operations.
2. **Batch File**:
   - `runLibraryApp.bat`: Script to run the application without manual terminal commands.
3. **JavaFX SDK**:
   - Place the JavaFX SDK folder (`javafx-sdk-23.0.1`) in the project directory.

## How to Use
1. Launch the application using `runLibraryApp.bat` or `LSM.exe`.
2. Enter the book details (title, author, category) and click **Add Book**.
3. Click **Show Books** to view the added books in the application.

---
This project showcases the integration of OOP, SOLID principles, and design patterns with a modern GUI application. Feel free to extend or enhance the system based on your requirements.

---