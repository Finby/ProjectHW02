package vit.homework.enums;

public enum StudyProfile {
    MATH_SCIENTIST("математик-ученый"),
    DENTIST("дантист"),
    PSYCHOLOGIST("психолог"),
    GOOD_PERSON("хороший человек"),
    TEACHER("учитель"),
    PHYSICS("Физика"),
    COMPUTER_SCIENCE("Информатика"),
    MATHEMATICS("Математика"),
    JURISPRUDENCE("Юриспруденция"),
    MEDICINE("Медицина"),
    LINGUISTICS("Лингвистика");
    public final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    private static final StudyProfile[] STUDY_PROFILES = StudyProfile.values();
}
