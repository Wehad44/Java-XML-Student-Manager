package com.mycompany.xmlproject;

public class XMLProject {
    public static void main(String[] args) throws Exception {

        StudentXMLManager manager = new StudentXMLManager();

        manager.resetXML();
        manager.addStudent("101", "Fahad", "CS", "3.8");
        manager.addStudent("102", "Faisal", "IT", "3.9");

        System.out.println("---- All Students ----");
        manager.readAllStudents();

        System.out.println("\n---- XPath IDs ----");
        manager.xpathGetAllIDs();

        System.out.println("\n---- XPath Names ----");
        manager.xpathGetAllNames();
    }
}
