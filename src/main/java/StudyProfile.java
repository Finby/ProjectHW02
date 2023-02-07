import java.time.DayOfWeek;

public enum StudyProfile {
    MATH_SCIENTIST("математик-ученый"),
    DENTIST("дантист"),
    PSYCHOLOGIST("психолог"),
    GOOD_PERSON("хороший человек"),
    TEACHER("учитель");
    public final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }
    private static final StudyProfile[] STUDY_PROFILES = StudyProfile.values();
}
