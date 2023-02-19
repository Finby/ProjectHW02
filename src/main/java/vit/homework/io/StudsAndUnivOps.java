package vit.homework.io;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vit.homework.enums.StudyProfile;
import vit.homework.model.Student;
import vit.homework.model.University;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudsAndUnivOps {

    public static List<University> readXlsUniversities(String filePath) {
        List<University> universityList = new ArrayList<>();
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheet("Университеты");

        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()) {
            Row currentRow = rows.next();

            University university = new University.UniversityBuilder(currentRow.getCell(1).getStringCellValue())
                    .setId(currentRow.getCell(0).getStringCellValue())
                    .setYearOfFoundation((int)currentRow.getCell(3).getNumericCellValue())
                    .setMainProfile(StudyProfile.valueOf(
                            StudyProfile.class,
                            currentRow.getCell(4).getStringCellValue()))
                    .setShortName(currentRow.getCell(2).getStringCellValue())
                    .build();

            universityList.add(university);

        }

        return universityList;
    }

    public static List<Student> readXlsStudents(String filePath) {
        List<Student> studentList = new ArrayList<>();
        XSSFWorkbook workbook;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        XSSFSheet sheet = workbook.getSheet("Студенты");

        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Student student = Student.builder()
                    .fullName(currentRow.getCell(1).getStringCellValue())
                    .universityId(currentRow.getCell(0).getStringCellValue())
                    .currentCourseNumber((int)currentRow.getCell(2).getNumericCellValue())
                    .avgExamScore((float)currentRow.getCell(3).getNumericCellValue())
                    .build();
            studentList.add(student);
        }

        return studentList;
    }


}
