package vit.homework.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import vit.homework.model.student.Student;
import vit.homework.model.university.University;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    public static String serializeStudent(Student student) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(student);
    }


    public static Student deserializeStudent(String studentString) {
        return new Gson().fromJson(studentString, Student.class);
    }


    public static String serializeUniversity(University university) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(university);
    }


    public static University deserializeUniversity(String universityString) {
        return new Gson().fromJson(universityString, University.class);
    }


    public static String serializeStudentList(List<Student> studentList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(studentList);
    }

    public static List<Student> deserializeStudentList(String studentListString) {
        return new Gson().fromJson(studentListString, List.class);
    }

    public static String serializeUniversityList(List<University> universityList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(universityList);
    }

    public static List<University> deserializeUniversityList(String universityListString) {
        return new Gson().fromJson(universityListString, List.class);
    }
}
