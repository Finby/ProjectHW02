package vit.homework.model.student;

public class StudentComparatorByCurrentCourseNumber implements StudentComparatorInterface {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());
    }
}
