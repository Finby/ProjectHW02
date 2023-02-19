import vit.homework.model.Student;
import vit.homework.enums.StudyProfile;
import vit.homework.model.University;

import java.util.ArrayList;
import java.util.List;

import static vit.homework.io.StudsAndUnivOps.*;

public class Main {

    static List<Student> studentList = new ArrayList<>();
    static List<University> universityList = new ArrayList<>();
    static String xlsFilePath = "src/main/java/resources/universityInfo.xlsx";
    public static void main(String[] args) {
//        manual_version();
        load_from_xml();
        print_data();
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