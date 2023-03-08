package vit.homework.model;

import vit.homework.enums.StudyProfile;

import java.util.List;

public class Statistics {
    private final StudyProfile profile;
    private final Double profileAverageScores;
    private final int profileStudentsNumber;
    private final int profileUniversityNumber;
    private final List<String> profileUniversityList;

    public Statistics(StudyProfile profile) {
        this.profile = profile;
    }
}
