package vit.homework.model.student;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

//@Builder
//@Data
@XmlType(propOrder = { "fullName", "universityId", "avgExamScore" })
public class Student {
    @SerializedName("FIO")
    @XmlElement(name = "studentName")
    private String fullName;

    @SerializedName("University ID")
    @XmlElement(name = "universityId")
    private String universityId;

    @SerializedName("Course")
    private int currentCourseNumber;

    @SerializedName("Average Scores")
    @XmlElement(name = "avgScore")
    private float avgExamScore;

    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }
//    public Student(StudentBuilder builder) {
//        this.fullName = builder.fullName;
//        this.universityId = builder.universityId;
//        this.currentCourseNumber = builder.currentCourseNumber;
//        this.avgExamScore = builder.avgExamScore;
//    }

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

