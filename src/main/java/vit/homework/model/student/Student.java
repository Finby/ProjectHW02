package vit.homework.model.student;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {
    @SerializedName("FIO")
    private final String fullName;
    @SerializedName("University ID")
    private String universityId;
    @SerializedName("Course")
    private int currentCourseNumber;
    @SerializedName("Average Scores")
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

