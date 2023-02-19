package vit.homework.utils;

import vit.homework.enums.StudentComparators;
import vit.homework.enums.UniversityComparators;
import vit.homework.model.student.*;
import vit.homework.model.university.*;

public class SelectComparator {
    public static StudentComparatorInterface SelectStudentComparator(StudentComparators compEnum) {
        switch (compEnum) {
            case StudentComparatorByAvgExamScore:
                return new StudentComparatorByAvgExamScore();
            case StudentComparatorByCurrentCourseNumber:
                return new StudentComparatorByCurrentCourseNumber();
            case StudentComparatorByFullName:
                return new StudentComparatorByFullName();
            case StudentComparatorByUniversityId:
                return new StudentComparatorByUniversityId();
            default:
                return new StudentComparatorByFullName();
        }
    }

    public static UniversityComparatorIntarface SelectUniversityComparator(UniversityComparators compEnum) {
        switch (compEnum) {
            case UNIVERSITYCOMPARATORBYFULLNAME:
                return new UniversityComparatorByFullName();
            case UNIVERSITYCOMPARATORBYID:
                return new UniversityComparatorById();
            case UNIVERSITYCOMPARATORBYMAINPROFILE:
                return new UniversityComparatorByMainProfile();
            case UNIVERSITYCOMPARATORBYSHORTNAME:
                return new UniversityComparatorByShortName();
            case UNIVERSITYCOMPARATORBYYEAROFFOUNDATION:
                return new UniversityComparatorByYearOfFoundation();
            default:
                return new UniversityComparatorByFullName();
        }
    }
}
