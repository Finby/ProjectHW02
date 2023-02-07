package vit.homework;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Student {
    private final String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }
}

