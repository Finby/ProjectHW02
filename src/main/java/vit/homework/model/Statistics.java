package vit.homework.model;

import vit.homework.enums.StudyProfile;

import java.util.List;

public class Statistics {
    public final StudyProfile profile;
    public final Double profileAverageScores;
    public final int profileStudentsNumber;
    public final int profileUniversityNumber;
    public final List<String> profileUniversityList;

    public Statistics(StudyProfile profile, Double profileAverageScores, int profileStudentsNumber,
                      int profileUniversityNumber, List<String> profileUniversityList) {
        this.profile = profile;
        this.profileAverageScores = profileAverageScores;
        this.profileStudentsNumber = profileStudentsNumber;
        this.profileUniversityNumber = profileUniversityNumber;
        this.profileUniversityList = profileUniversityList;
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public Double getProfileAverageScores() {
        return profileAverageScores;
    }

    public int getProfileStudentsNumber() {
        return profileStudentsNumber;
    }

    public int getProfileUniversityNumber() {
        return profileUniversityNumber;
    }

    public List<String> getProfileUniversityList() {
        return profileUniversityList;
    }
}
