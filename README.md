# Java XML Student Manager

A Java-based XML management project using **JDOM2** and **XPath** to create, store, read, and query student records.

## Overview

This project demonstrates how to manage student information using an XML file in Java.

The application generates a `students.xml` file, adds student records containing an ID, name, major, and GPA, then reads and queries the data using XPath expressions.

## Features

- Create and reset the XML document.
- Add student records.
- Prevent duplicate student IDs.
- Read and display all students.
- Retrieve all student IDs using XPath.
- Retrieve all student names using XPath.
- Save XML data in a formatted structure.

## Technologies

- Java
- XML
- JDOM2
- XPath
- Maven
- Object-Oriented Programming

## Requirements

- JDK 17 or later
- Maven

JDOM2 dependencies are downloaded automatically through Maven.

## How to Run

Clone the repository:

```bash
git clone https://github.com/Wehad44/Java-XML-Student-Manager.git
```

Navigate to the project directory:

```bash
cd Java-XML-Student-Manager
```

Run the application:

```bash
mvn compile exec:java
```

The application resets the XML file, adds sample students, and displays the stored records and XPath query results.

## Project Structure

```text
src/
└── main/
    └── java/
        └── com/
            └── mycompany/
                └── xmlproject/
                    ├── XMLProject.java
                    └── StudentXMLManager.java

pom.xml
README.md
```

## Main Components

### XMLProject.java

The main entry point of the application. It demonstrates the available XML management operations.

### StudentXMLManager.java

Handles XML creation, reading, writing, student insertion, duplicate ID checking, and XPath queries.

## XPath Queries

The project uses XPath expressions to retrieve information from the XML document.

### Retrieve all student IDs

```xpath
//student/@id
```

### Retrieve all student names

```xpath
//student/name
```

### Check for an existing student ID

```xpath
//student[@id='101']/@id
```

## Sample XML Structure

```xml
<students>
    <student id="101">
        <name>Fahad</name>
        <major>CS</major>
        <gpa>3.8</gpa>
    </student>
    <student id="102">
        <name>Faisal</name>
        <major>IT</major>
        <gpa>3.9</gpa>
    </student>
</students>
```

## Learning Objectives

This project demonstrates:

- Reading and writing XML files in Java.
- Creating and manipulating XML documents.
- Using JDOM2 for XML processing.
- Querying XML data with XPath.
- Preventing duplicate records.
- Organizing XML operations using Java classes.

## Future Improvements

- Add update and delete operations.
- Search students by ID or name.
- Validate GPA values.
- Add XML Schema validation using XSD.
- Add a graphical user interface.
- Export student data to JSON or CSV.

## License

This project is intended for educational purposes.
