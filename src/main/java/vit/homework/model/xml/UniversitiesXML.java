package vit.homework.model.xml;

import vit.homework.model.university.University;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;


public class UniversitiesXML {
    @XmlElement(name = "universityEntry")
    private ArrayList<University> UniversityList;

//    public void setUniversityList(ArrayList<University> universityList) {
//        UniversityList = universityList;
//    }

    public UniversitiesXML() {
    }

    public UniversitiesXML(ArrayList<University> universityList) {
        UniversityList = universityList;
    }
}
