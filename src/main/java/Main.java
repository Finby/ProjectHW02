import vit.homework.enums.StudentComparators;
import vit.homework.enums.UniversityComparators;
import vit.homework.model.student.Student;
import vit.homework.enums.StudyProfile;
import vit.homework.model.student.StudentComparatorInterface;
import vit.homework.model.university.University;
import vit.homework.model.university.UniversityComparatorIntarface;
import vit.homework.utils.JsonUtil;
import vit.homework.utils.SelectComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static vit.homework.io.StudsAndUnivOps.*;

public class Main {

    static List<Student> studentList = new ArrayList<>();
    static List<University> universityList = new ArrayList<>();
    static String xlsFilePath = "src/main/java/resources/universityInfo.xlsx";

    public static void main(String[] args) {
        load_from_xml();
//        mainXLSX;
        mainJSON();
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

        for (UniversityComparators univComparatorEnum: UniversityComparators.values()) {
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

    private static void load_from_xml() {
        universityList = readXlsUniversities(xlsFilePath);
        studentList = readXlsStudents(xlsFilePath);
    }




    public static void manual_version() {
        Student st1 = Student.builder()
                .fullName("Ivan Ivanov Ivanovich")
                .universityId("BSU")
                .currentCourseNumber(1)
                .avgExamScore(4.25f)
                .build();

        System.out.println(st1);

        System.out.println("----------------------------------");

        University unv1 = new University.UniversityBuilder("Belarusian State University")
                .setId("1")
                .setYearOfFoundation(1921)
                .setMainProfile(StudyProfile.MATH_SCIENTIST)
                .setShortName("BSU")
                .build();

        System.out.println(unv1);
    }
}