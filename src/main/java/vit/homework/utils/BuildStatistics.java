package vit.homework.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vit.homework.enums.StudyProfile;
import vit.homework.model.statistic.Statistic;
import vit.homework.model.student.Student;
import vit.homework.model.university.University;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BuildStatistics {
// TODO
//    use more Stream() functionality where it's possible

    static {
        System.setProperty("log4j.configurationFile", "src/main/java/vit/homework/resources/log4j2.xml");
    }
    private static final Logger log = LogManager.getLogger(BuildStatistics.class);
    public static List<Statistic> createStatistic(List<Student> students, List<University> universities) {
        log.log(Level.INFO, "BuildStatistics.createStatistic() started.");
        List<Statistic> statisticList = new ArrayList<>();
        for (University univer: universities) {
            if (!profileIsProcessed(univer.getMainProfile(), statisticList)) {
                statisticList.add(createStatisticRow(univer.getMainProfile(), students, universities));
            }
        }
        log.log(Level.INFO, "BuildStatistics.createStatistic() finished. Created " + statisticList.size() + " rows.");
        return statisticList;
    }

    private static Statistic createStatisticRow(StudyProfile mainProfile, List<Student> students, List<University> universities) {
        Double profileAverageScores = calculateProfileAverageScores(mainProfile, students, universities);
        int profileStudentsNumber = calculateProfileStudentsNumber(mainProfile, students, universities);
        int profileUniversityNumber = calculateProfileUniversityNumber(mainProfile, universities);
        List<String> profileUniversityList = createListOfProfileUniversitets(mainProfile, universities);

        return new Statistic(mainProfile, profileAverageScores, profileStudentsNumber,
                profileUniversityNumber, profileUniversityList);
    }

    private static List<String> createListOfProfileUniversitets(StudyProfile mainProfile, List<University> universities) {
        return universities.stream().filter(x -> x.getMainProfile().equals(mainProfile))
                .map(University::getShortName).collect(Collectors.toList());
    }

    private static int calculateProfileUniversityNumber(StudyProfile mainProfile, List<University> universities) {
//        int univerNumber = 0;
//
//        for (University univer : universities) {
//            if (univer.getMainProfile().equals(mainProfile))
//                univerNumber++;
//        }

        return (int) universities.stream()
                .filter(
                        university -> university.getMainProfile().equals(mainProfile)
                ).count();
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

    private static boolean profileIsProcessed(StudyProfile mainProfile, List<Statistic> statisticList) {
        for (Statistic stat: statisticList) {
            if (stat.getProfile().equals(mainProfile))
                return true;
        }
        return false;
    }
}
