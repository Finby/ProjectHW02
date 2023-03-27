package vit.homework.model.statistic;

import vit.homework.enums.StudyProfile;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(propOrder = { "profile", "profileAverageScores"})
public class Statistic {
    @XmlElement(name = "universityProfile")
    private StudyProfile profile;
    @XmlElement(name = "avgScore")
    private Double profileAverageScores;
    private int profileStudentsNumber;
    private int profileUniversityNumber;
    private List<String> profileUniversityList;

    public Statistic(StudyProfile profile, Double profileAverageScores, int profileStudentsNumber,
                     int profileUniversityNumber, List<String> profileUniversityList) {
        this.profile = profile;
        this.profileAverageScores = profileAverageScores;
        this.profileStudentsNumber = profileStudentsNumber;
        this.profileUniversityNumber = profileUniversityNumber;
        this.profileUniversityList = profileUniversityList;
    }

    public Statistic() {
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
