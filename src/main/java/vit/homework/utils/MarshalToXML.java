package vit.homework.utils;

import vit.homework.io.XMLWriter;
import vit.homework.model.statistic.Statistic;
import vit.homework.model.student.Student;
import vit.homework.model.university.University;
import vit.homework.model.xml.StatisticXML;
import vit.homework.model.xml.StudentXML;
import vit.homework.model.xml.UniversitiesXML;
import vit.homework.model.xml.XMLAgregated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;
import java.util.List;

public class MarshalToXML {
    private static final String UNIVERSITY_XML = "./src/main/java/vit/homework/resources/universities.xml";

    public static void writeData(List<University> universitiesList,
                                 List<Student> studentList,
                                 List<Statistic> statisticList) throws JAXBException {
        UniversitiesXML universitiesXML = new UniversitiesXML((ArrayList<University>) universitiesList);
        StudentXML studentXML = new StudentXML((ArrayList<Student>) studentList);
        StatisticXML statisticXML = new StatisticXML((ArrayList<Statistic>) statisticList);
        XMLAgregated xmlAgregated = new XMLAgregated(universitiesXML, studentXML, statisticXML);

//        JAXBContext context = JAXBContext.newInstance(UniversitiesXML.class);
        JAXBContext context = JAXBContext.newInstance(XMLAgregated.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.marshal(universitiesXML, System.out);

        XMLWriter.writeToFile(marshaller, xmlAgregated, UNIVERSITY_XML);
    }
}
