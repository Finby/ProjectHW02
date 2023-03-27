package vit.homework.io;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vit.homework.model.statistic.Statistic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    static {
        System.setProperty("log4j.configurationFile", "src/main/java/vit/homework/resources/log4j2.xml");
    }
    private static final Logger log = LogManager.getLogger(XlsWriter.class);
    public static void writeToFile(List<Statistic> statisticList, String filePath) {
        log.log(Level.INFO, "XlsWriter.writeStatisticToFile() - Starting.");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Statistic");
        Row row;
        Cell cell;
        int rowCount = 0;

        // bold style
        CellStyle styleBold = workbook.createCellStyle();//Create style
        Font font = workbook.createFont();//Create font
        font.setBold(true);//Make font bold
        styleBold.setFont(font);//set it to bold

        String[] titles = {"Profile", "Avg Scores",
                "Students Number", "University Number", "University List"};
        row = sheet.createRow(rowCount++);
        int columnCount = 1;
        for (String str: titles) {
            cell = row.createCell(columnCount);
            cell.setCellValue(titles[columnCount-1]);
            cell.setCellStyle(styleBold);
            columnCount++;
        }


         for (Statistic stat : statisticList) {
             row = sheet.createRow(rowCount++);

             cell = row.createCell(1);
             cell.setCellValue((String) stat.getProfile().getProfileName());

             cell = row.createCell(2);
             cell.setCellValue((String) stat.getProfileAverageScores().toString());

             cell = row.createCell(3);
             cell.setCellValue((Integer) stat.getProfileStudentsNumber());

             cell = row.createCell(4);
             cell.setCellValue((Integer) stat.getProfileUniversityNumber());

             cell = row.createCell(5);
             cell.setCellValue((String) String.join(", ", stat.getProfileUniversityList()));

        }



        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.log(Level.INFO, "XlsWriter.writeStatisticToFile() - Successfully ended.");
    }
}
