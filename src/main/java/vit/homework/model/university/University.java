package vit.homework.model.university;

import com.google.gson.annotations.SerializedName;
import vit.homework.enums.StudyProfile;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "fullName", "mainProfile" })
public class University {
    @SerializedName("ID")
    @XmlElement(name = "universityId")
    private String id;
    @SerializedName("Full name")
    @XmlElement(name = "universityName")
    private String fullName;
    @SerializedName("Short name")
    private String shortName;
    @SerializedName("Foundation year")
    private int yearOfFoundation;
    @SerializedName("Profile")
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile=null;


    public University(UniversityBuilder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.shortName = builder.shortName;
        this.yearOfFoundation = builder.yearOfFoundation;
        this.mainProfile = builder.mainProfile;
    }

    public University() {
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
