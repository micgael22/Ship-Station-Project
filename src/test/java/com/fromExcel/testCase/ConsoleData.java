package com.fromExcel.testCase;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ConsoleData {
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    File file;

    @BeforeClass
    public void setup01() throws IOException {

        //add file path
        //file instance & obtaining
        file = new File("src/main/resources/excelFiles/EmployeesData.xlsx");
        fis = new FileInputStream(file);

        //workbook instance
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);

    }
    @Test
    public void xlsxData() {

        //iterate through excel
        Iterator <Row> itr = sheet.iterator();
        while (itr.hasNext()){
            Row row = itr.next();

            Iterator <Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();

                switch (cell.getCellType())
                {
                    case STRING: System.out.print(cell.getStringCellValue() +"\t\t\t");
                        break;
                    case NUMERIC: System.out.print(cell.getNumericCellValue() +"\t\t\t");
                        break;
                    case BOOLEAN: System.out.println(cell.getBooleanCellValue() +"\t\t\t");
                        break;
                }
            }
            System.out.println("");
        }
    }

    @AfterTest
    public void afterTest01() {
        System.out.println(">>>>>>>>SHEET DATA PRINTED<<<<<<<<");
    }
}
