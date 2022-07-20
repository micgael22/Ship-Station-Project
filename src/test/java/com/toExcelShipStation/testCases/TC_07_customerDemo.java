package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class TC_07_customerDemo extends BaseClass{

    @Test
    public void custDemoTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM customer_demo");

        //create sheet
        sheet = workbook.createSheet("Customer Demo Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Customer_ID");
        row.createCell(1).setCellValue("Customer_Type_ID");

        int r = 1;

        while (rs.next()) {
            int custID = rs.getInt("Customer_ID");
            int custTypeID = rs.getInt("Customer_Type_ID");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(custID);
            row.createCell(1).setCellValue(custTypeID);

            fos = new FileOutputStream("src/main/resources/shipStationData/CustomerDemoData.xlsx");
        }
        System.out.println(">>>TestCase 07 SUCCESSFUL<<<");
    }
}
