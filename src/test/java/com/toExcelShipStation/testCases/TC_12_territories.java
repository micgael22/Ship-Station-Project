package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class TC_12_territories extends BaseClass{

    @Test
    public void terTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM territories");

        //create sheet
        sheet = workbook.createSheet("Territories Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Territory_ID");
        row.createCell(1).setCellValue("Last_Name");
        row.createCell(2).setCellValue("Region_ID");

        int r = 1;

        while (rs.next()) {

            String terID = rs.getString("Territory_ID");
            String lastName = rs.getString("Last_Name");
            int regionID = rs.getInt("Region_ID");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue("Territory_ID");
            row.createCell(1).setCellValue("Last_Name");
            row.createCell(2).setCellValue("Region_ID");

            fos = new FileOutputStream("src/main/resources/shipStationData/TerritoriesData.xlsx");
        }
        System.out.println(">>>TestCase 12 SUCCESSFUL<<<");
    }
}
