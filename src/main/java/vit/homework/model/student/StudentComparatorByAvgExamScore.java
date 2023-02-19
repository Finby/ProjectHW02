package vit.homework.model.student;

public class StudentComparatorByAvgExamScore implements StudentComparatorInterface {
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o1.getAvgExamScore(), o2.getAvgExamScore());
    }
}
