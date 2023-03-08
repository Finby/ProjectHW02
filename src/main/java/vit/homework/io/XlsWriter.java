package vit.homework.io;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import vit.homework.model.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class XlsWriter {

    public static void writeStatisticToFile(List<Statistics> statisticList, String filePath) {
        /* TODO
        В странице заполнить заголовок с текстовыми наименованиями
        (то есть подписать колонки таблицы).
        Заголовки должны иметь настроенный стиль — как минимум,
        сделать всё жирным шрифтом и с указанным размером шрифта.

         itterate statistic and  save
         */
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Statistic");
        Row row;
        Cell cell;
        int rowCount = 0;

        String[] titles = {"Profile", "Avg Scores",
                "Students Number", "University Number", "University List"};
        row = sheet.createRow(rowCount++);
        int columnCount = 1;
        for (String str: titles) {
            cell = row.createCell(columnCount);
            cell.setCellValue(titles[columnCount-1]);
            columnCount++;
        }


         for (Statistics stat : statisticList) {
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
    }
}
