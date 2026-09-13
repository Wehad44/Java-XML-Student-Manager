# Student XML Manager

A small demo of reading and writing XML with JDOM2, plus querying it
with XPath. Manages a `students.xml` file: adds student records (id,
name, major, GPA), lists them, and runs a couple of XPath queries
(all IDs, all names).

## Requirements
- JDK 17+
- Maven (JDOM2 is fetched automatically, no manual jar download needed)

## Run it

```bash
mvn compile exec:java
```

This resets `students.xml`, adds two sample students, then prints all
students plus the results of two XPath queries. `students.xml` is
generated at runtime in the project root — it isn't committed to the
repo (see `.gitignore`).

## Project layout

```
src/main/java/com/mycompany/xmlproject/
  XMLProject.java          – entry point, demonstrates the manager's methods
  StudentXMLManager.java   – all XML read/write/XPath logic
```
