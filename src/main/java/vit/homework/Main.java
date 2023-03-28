package vit.homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vit.homework.enums.StudentComparators;
import vit.homework.enums.UniversityComparators;
import vit.homework.io.JSONWriter;
import vit.homework.model.statistic.Statistic;
import vit.homework.model.student.Student;
import vit.homework.model.student.StudentComparatorByAvgExamScore;
import vit.homework.model.student.StudentComparatorByFullName;
import vit.homework.model.student.StudentComparatorInterface;
import vit.homework.model.university.University;
import vit.homework.model.university.UniversityComparatorByFullName;
import vit.homework.model.university.UniversityComparatorByYearOfFoundation;
import vit.homework.model.university.UniversityComparatorIntarface;
import vit.homework.model.xml.StatisticXML;
import vit.homework.model.xml.StudentXML;
import vit.homework.model.xml.UniversitiesXML;
import vit.homework.model.xml.XMLAgregated;
import vit.homework.utils.*;

import javax.xml.bind.JAXBException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static vit.homework.io.StudsAndUnivOps.readXlsStudents;
import static vit.homework.io.StudsAndUnivOps.readXlsUniversities;

public class Main {

    static List<Student> studentList = new ArrayList<>();
    static List<University> universityList = new ArrayList<>();
    static List<Statistic> statisticList;
    static String xlsFilePath = "src/main/java/vit/homework/resources/universityInfo.xlsx";
    static String xlsStatFilePath = "src/main/java/vit/homework/resources/statistic.xlsx";

    static {
        System.setProperty("log4j.configurationFile", "src/main/java/vit/homework/resources/log4j2.xml");
    }

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("We are starting !!!");

        log.info("Step 1. reading data from .xlsx");
        load_from_xlsx();
//        mainXLSX;
//        mainJSON();

        log.info("Step 2. Create statistics");
        statisticList = BuildStatistics.createStatistic(studentList, universityList);
//        XlsWriter.writeStatisticToFile(statisticsList, xlsStatFilePath);

        log.info("Step 3. Create statistics");
        universityList.sort(new UniversityComparatorByFullName());
        studentList.sort(new StudentComparatorByAvgExamScore());

        log.info("Step 4. Do XML Marshaling and write to file");
        XMLAgregated xmlAgregated = new XMLAgregated(
                new UniversitiesXML((ArrayList<University>) universityList),
                new StudentXML((ArrayList<Student>) studentList),
                new StatisticXML((ArrayList<Statistic>) statisticList));
        MarshalToXML.writeData(xmlAgregated);

        log.info("Step 5. Unmarshalling from XML to JSON-string and write to file");
        BufferedInputStream bfInputStr;
        XMLAgregated readFileData;
        try {
            // TODO: get today's file name automatically
            bfInputStr = new BufferedInputStream(new FileInputStream("src/main/java/vit/homework/resources/xmlReqs/req2023-03-28.xml"));

            // TODO: some problems with reading University structure from XML
            // "Foundation year" and "Course" - excessive fields
            readFileData = Converters.convertXmlToObject(bfInputStr);
            String json = Converters.convertObjectToJson(readFileData);
            JSONWriter.writeToFile(json, null);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }



        log.info("We are done. Goodbye");
    }






    public static void mainJSON() {
        // serialize
        String serializedStudent = JsonUtil.serializeStudent(studentList.get(0));
        System.out.println(serializedStudent);
        String serializedUniversity = JsonUtil.serializeUniversity(universityList.get(0));
        System.out.println(serializedUniversity);
        String serializedStudentList = JsonUtil.serializeStudentList(studentList);
        System.out.println(serializedStudentList);
        String serializedUniversityList = JsonUtil.serializeUniversityList(universityList);
        System.out.println(serializedUniversityList);


        // DeSerialize
        System.out.println(JsonUtil.deserializeStudent(serializedStudent));
        System.out.println(JsonUtil.deserializeUniversity(serializedUniversity));

        List<Student> deserializedStudentList = JsonUtil.deserializeStudentList(serializedStudentList);
        System.out.println("Same number of Students: " + (deserializedStudentList.size() == studentList.size()));

        List<University> deserializeUniversityList = JsonUtil.deserializeUniversityList(serializedUniversityList);
        System.out.println("Same number of Universities: " + (deserializeUniversityList.size() == universityList.size()));

        // Serialize via Stream and print
        System.out.println("--------------------------------");
        studentList.stream().limit(3).map(JsonUtil::serializeStudent).forEach(System.out::println);

        // Serialize and Deserialize via Stream and print
        System.out.println("--------------------------------");
        studentList.stream().map(JsonUtil::serializeStudent).map(JsonUtil::deserializeStudent).forEach(System.out::println);


    }

    public static void mainXLSX() {
//        manual_version();

        StudentComparatorInterface stByScore = SelectComparator.SelectStudentComparator(
                StudentComparators.StudentComparatorByAvgExamScore);
        System.out.println("Students sorted by Average Score - using custom comparator");
        studentList.sort(stByScore);
        studentList.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Students sorted using Comparator.comparing + getters");
        System.out.println("Students sorted by Average Score - reversed");
        Comparator<Student> byFullName = Comparator.comparing(Student::getAvgExamScore, Comparator.reverseOrder());
        studentList.sort(byFullName);
        studentList.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("University sorted by Foundation Year - reversed, using Comparator.comparing");
        Comparator<University> univByYearOfFoundationReversed = Comparator.comparing(
                University::getYearOfFoundation,
                Comparator.reverseOrder());
        universityList.sort(univByYearOfFoundationReversed);
        universityList.forEach(System.out::println);

        System.out.println("--------------------------");
        System.out.println("--------------------------");

        System.out.println("All University comparators in loop");

        for (UniversityComparators univComparatorEnum : UniversityComparators.values()) {
            System.out.println("----------------------------------------------------");
            System.out.println("sorter using " + univComparatorEnum.getComparatorName());
            UniversityComparatorIntarface univComparator = SelectComparator.SelectUniversityComparator(univComparatorEnum);
            universityList.sort(univComparator);
            universityList.forEach(System.out::println);
        }

//        print_data();

    }

    private static void print_data() {
        studentList.forEach(System.out::println);
        universityList.forEach(System.out::println);
    }

    private static void load_from_xlsx() {
        universityList = readXlsUniversities(xlsFilePath);
        studentList = readXlsStudents(xlsFilePath);
    }



}