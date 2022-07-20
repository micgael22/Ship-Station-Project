package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class TC_10_region extends BaseClass{

    @Test
    public void regionTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM region");

        //create sheet
        sheet = workbook.createSheet("Region Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Region_ID");
        row.createCell(1).setCellValue("Region Description");

        int r = 1;

        while (rs.next()) {
            int regionID = rs.getInt("Region_ID");
            String regionDesc = rs.getString("Region_Description");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(regionID);
            row.createCell(1).setCellValue(regionDesc);

            fos = new FileOutputStream("src/main/resources/shipStationData/RegionData.xlsx");
        }
        System.out.println(">>>TestCase 10 SUCCESSFUL<<<");
    }
}
