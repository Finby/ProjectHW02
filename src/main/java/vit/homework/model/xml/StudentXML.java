package vit.homework.model.xml;

import vit.homework.model.student.Student;
import javax.xml.bind.annotation.XmlElement;

import java.util.ArrayList;

public class StudentXML {

    @XmlElement(name = "studentEntry")
    private ArrayList<Student> StudentsList;

    public StudentXML() {
    }

    public StudentXML(ArrayList<Student> studentsList) {
        StudentsList = studentsList;
    }
}
