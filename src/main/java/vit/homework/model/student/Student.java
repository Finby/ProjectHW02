package vit.homework.model.student;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Builder
//@Data
@XmlType(propOrder = { "fullName", "universityId", "avgExamScore" })
public class Student {
    @SerializedName("FIO")
    @XmlElement(name = "studentName")
    private final String fullName;

    @SerializedName("University ID")
    @XmlElement(name = "universityId")
    private String universityId;

    @SerializedName("Course")
    private int currentCourseNumber;

    @SerializedName("Average Scores")
    @XmlElement(name = "avgScore")
    private float avgExamScore;


    public String getUniversityId() {
        return universityId;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

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

