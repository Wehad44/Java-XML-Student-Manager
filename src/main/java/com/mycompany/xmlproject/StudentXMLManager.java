package com.mycompany.xmlproject;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.filter.Filters;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class StudentXMLManager {

    private static final String FILE_NAME = "students.xml";

   public void resetXML() throws Exception {
    Element root = new Element("students");
    Document doc = new Document(root);
    save(doc);
}


    public void addStudent(String id, String name, String major, String gpa) throws Exception {
    Document doc = new SAXBuilder().build(new File(FILE_NAME));
    Element root = doc.getRootElement();

    XPathFactory xf = XPathFactory.instance();
    XPathExpression<Attribute> expr = xf.compile("//student[@id='" + id + "']/@id", Filters.attribute());
    Attribute existing = expr.evaluateFirst(doc);

    if (existing != null) {
        System.out.println("Student with id=" + id + " already exists. Skipped.");
        return;
    }

    Element student = new Element("student");
    student.setAttribute("id", id);
    student.addContent(new Element("name").setText(name));
    student.addContent(new Element("major").setText(major));
    student.addContent(new Element("gpa").setText(gpa));

    root.addContent(student);
    save(doc);
}


    public void readAllStudents() throws Exception {
        Document doc = new SAXBuilder().build(new File(FILE_NAME));

        for (Element student : doc.getRootElement().getChildren("student")) {
            System.out.println("ID: " + student.getAttributeValue("id"));
            System.out.println("Name: " + student.getChildText("name"));
            System.out.println("Major: " + student.getChildText("major"));
            System.out.println("GPA: " + student.getChildText("gpa"));
            System.out.println("----------------");
        }
    }

    public void xpathGetAllIDs() throws Exception {
        Document doc = new SAXBuilder().build(new File(FILE_NAME));
        XPathFactory xf = XPathFactory.instance();

        XPathExpression<Attribute> expr = xf.compile("//student/@id", Filters.attribute());
        List<Attribute> ids = expr.evaluate(doc);

        for (Attribute a : ids) {
            System.out.println(a.getValue());
        }
    }

    public void xpathGetAllNames() throws Exception {
        Document doc = new SAXBuilder().build(new File(FILE_NAME));
        XPathFactory xf = XPathFactory.instance();

        XPathExpression<Element> expr = xf.compile("//student/name", Filters.element());
        List<Element> names = expr.evaluate(doc);

        for (Element e : names) {
            System.out.println(e.getText());
        }
    }

    private void save(Document doc) throws Exception {
        XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            out.output(doc, fw);
        }
    }
}
