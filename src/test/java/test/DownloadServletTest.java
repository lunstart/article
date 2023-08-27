package test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;
import java.util.Iterator;

import static org.junit.Assert.*;

public class DownloadServletTest {

    @Test
    public void doPost() throws IOException {

        String filePath = "D:\\gogleUpDown\\2.xlsx";
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        System.out.println(inputStream);
        // 使用WorkbookFactory创建Workbook对象

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        // 获取第一个Sheet

        // 迭代行
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // 迭代单元格
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // 输出单元格的值
                System.out.print(cell.toString() + "\t");
            }

            System.out.println();
        }

        // 关闭Workbook和输入流
        workbook.close();
        inputStream.close();
    }
}