package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class TC_11_shippers extends BaseClass{

    @Test
    public void shippersTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM shippers");

        //create sheet
        sheet = workbook.createSheet("Shippers Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Shipper_ID");
        row.createCell(1).setCellValue("Company_Name");
        row.createCell(2).setCellValue("Phone_Number");

        int r = 1;

        while (rs.next()) {
            int shipperID = rs.getInt("Shipper_ID");
            String compName = rs.getString("Company_Name");
            String phoneNum = rs.getString("Phone_Number");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(shipperID);
            row.createCell(1).setCellValue(compName);
            row.createCell(2).setCellValue(phoneNum);

            fos = new FileOutputStream("src/main/resources/excelFiles/ShippersData.xlsx");
        }
        System.out.println(">>>TestCase 11 SUCCESSFUL<<<");
    }
}
