package vit.homework.model;

import vit.homework.enums.StudyProfile;

public class University {
    private final String id;
    private final String fullName;
    private final String shortName;
    private final int yearOfFoundation;
    private final StudyProfile mainProfile;

//    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
//        this.id = id;
//        this.fullName = fullName;
//        this.shortName = shortName;
//        this.yearOfFoundation = yearOfFoundation;
//        this.mainProfile = mainProfile;
//    }
    public University(UniversityBuilder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.shortName = builder.shortName;
        this.yearOfFoundation = builder.yearOfFoundation;
        this.mainProfile = builder.mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }


    public static class UniversityBuilder {
        private String id;
        private final String fullName;
        private String shortName;
        private int yearOfFoundation;
        private StudyProfile mainProfile;

        public UniversityBuilder(String fullName) {
            this.fullName = fullName;
        }

        public UniversityBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public UniversityBuilder setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public UniversityBuilder setYearOfFoundation(int yearOfFoundation) {
            this.yearOfFoundation = yearOfFoundation;
            return this;
        }

        public UniversityBuilder setMainProfile(StudyProfile mainProfile) {
            this.mainProfile = mainProfile;
            return this;
        }

        public University build() {
            return new University(this);
        }
    }
}
