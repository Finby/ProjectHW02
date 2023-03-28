package vit.homework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vit.homework.Main;
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
    static {
        System.setProperty("log4j.configurationFile", "src/main/java/vit/homework/resources/log4j2.xml");
    }
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void writeData(XMLAgregated xmlAgregated) {
        //        JAXBContext context = JAXBContext.newInstance(UniversitiesXML.class);
        JAXBContext context = null;
        Marshaller marshaller = null;
        try {
            context = JAXBContext.newInstance(XMLAgregated.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
//        marshaller.marshal(universitiesXML, System.out);
        XMLWriter.writeToFile(marshaller, xmlAgregated, null);
        log.info("MarshalToXML.writeData() - End.");
    }

    public static void writeData(List<University> universitiesList,
                                 List<Student> studentList,
                                 List<Statistic> statisticList){
        log.info("MarshalToXML.writeData() - Start.");
        UniversitiesXML universitiesXML = new UniversitiesXML((ArrayList<University>) universitiesList);
        StudentXML studentXML = new StudentXML((ArrayList<Student>) studentList);
        StatisticXML statisticXML = new StatisticXML((ArrayList<Statistic>) statisticList);
        XMLAgregated xmlAgregated = new XMLAgregated(universitiesXML, studentXML, statisticXML);

        writeData(xmlAgregated);

    }
}
