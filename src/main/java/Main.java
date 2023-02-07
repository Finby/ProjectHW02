import vit.homework.Student;
import vit.homework.StudyProfile;
import vit.homework.University;

public class Main {
    public static void main(String[] args) {
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