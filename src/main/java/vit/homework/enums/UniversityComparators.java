package vit.homework.enums;

public enum UniversityComparators {
    UNIVERSITYCOMPARATORBYFULLNAME("UniversityComparator by FullName"),
    UNIVERSITYCOMPARATORBYID("UniversityComparator by Id"),
    UNIVERSITYCOMPARATORBYMAINPROFILE("UniversityComparator by MainProfile"),
    UNIVERSITYCOMPARATORBYSHORTNAME("UniversityComparator by ShortName"),
    UNIVERSITYCOMPARATORBYYEAROFFOUNDATION("UniversityComparator by YearOfFoundation");

    private final String comparatorName;
    private static final StudyProfile[] UNIVERSITY_COMPARATORS = StudyProfile.values();

    UniversityComparators(String comparatorName) {
        this.comparatorName = comparatorName;
    }

    public String getComparatorName() {
        return comparatorName;
    }
}
