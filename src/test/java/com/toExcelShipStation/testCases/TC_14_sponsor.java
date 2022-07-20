package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class TC_14_sponsor extends BaseClass {

    @Test
    public void sponsorTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM sponsors");

        //create sheet
        sheet = workbook.createSheet("Sponsors Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("sponsor_ID");
        row.createCell(1).setCellValue("sponsor_Name");
        row.createCell(2).setCellValue("amount");
        row.createCell(3).setCellValue("sponsor_Level");

        int r = 1;

        while (rs.next()) {
            int sponsor_ID = rs.getInt("sponsor_ID");
            String sponsor_Name = rs.getString("sponsor_Name");
            int amount = rs.getInt("amount");
            String sponsor_Level = rs.getString("sponsor_Level");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(sponsor_ID);
            row.createCell(1).setCellValue(sponsor_Name);
            row.createCell(2).setCellValue(amount);
            row.createCell(3).setCellValue(sponsor_Level);

            fos = new FileOutputStream("src/main/resources/shipStationData/SponsorsData.xlsx");
        }
        System.out.println(">>>TestCase 14 SUCCESSFUL<<<");
    }
}
