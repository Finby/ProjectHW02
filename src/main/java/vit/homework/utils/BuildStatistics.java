package vit.homework.utils;

import vit.homework.enums.StudyProfile;
import vit.homework.model.Statistics;
import vit.homework.model.student.Student;
import vit.homework.model.university.University;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BuildStatistics {

    public static List<Statistics> createStatistic(List<Student> students, List<University> universities) {

        List<Statistics> statisticsList = new ArrayList<>();
        for (University univer: universities) {
            if (!profileIsProcessed(univer.getMainProfile(), statisticsList)) {
                statisticsList.add(createStatisticRow(univer.getMainProfile(), students, universities));
            }
        }
        return statisticsList;
    }

    private static Statistics createStatisticRow(StudyProfile mainProfile, List<Student> students, List<University> universities) {
        StudyProfile profile = mainProfile;
        Double profileAverageScores = calculateProfileAverageScores(mainProfile, students, universities);
        int profileStudentsNumber = calculateProfileStudentsNumber(mainProfile, students, universities);
        int profileUniversityNumber = calculateProfileUniversityNumber(mainProfile, universities);
        List<String> profileUniversityList = createListOfProfileUniversitets(mainProfile, universities);

        return new Statistics(profile, profileAverageScores, profileStudentsNumber,
                profileUniversityNumber, profileUniversityList);
    }

    private static List<String> createListOfProfileUniversitets(StudyProfile mainProfile, List<University> universities) {
        return universities.stream().filter(x -> x.getMainProfile().equals(mainProfile))
                .map(University::getShortName).collect(Collectors.toList());
    }

    private static int calculateProfileUniversityNumber(StudyProfile mainProfile, List<University> universities) {
        int univerNumber = 0;
        for (University univer : universities) {
            if (univer.getMainProfile().equals(mainProfile))
                univerNumber++;
        }

        return univerNumber;
    }

    private static int calculateProfileStudentsNumber(StudyProfile mainProfile, List<Student> students,
                                                      List<University> universities) {
        int studNumber = 0;
        for (University univer : universities) {
            if (univer.getMainProfile().equals(mainProfile))
                for (Student stud : students) {
                    if (stud.getUniversityId().equals(univer.getId()))
                        studNumber++;
                }
        }

        return studNumber;
    }

    private static Double calculateProfileAverageScores(StudyProfile mainProfile, List<Student> students,
                                                        List<University> universities) {
        int studNumber = 0;
        double studAvgScoresSum = 0;
        for (University univer : universities) {
            if (univer.getMainProfile().equals(mainProfile))
                for (Student stud : students) {
                    if (stud.getUniversityId().equals(univer.getId())) {
                        studNumber++;
                        studAvgScoresSum += stud.getAvgExamScore();
                    }
                }
        }

        return studAvgScoresSum / studNumber;
    }

    private static boolean profileIsProcessed(StudyProfile mainProfile, List<Statistics> statisticsList) {
        for (Statistics stat: statisticsList) {
            if (stat.getProfile().equals(mainProfile))
                return true;
        }
        return false;
    }
}
