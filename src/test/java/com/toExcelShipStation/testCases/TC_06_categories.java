package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class TC_06_categories extends BaseClass{

    @Test
    public void categoriesTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM categories");

        //create sheet
        sheet = workbook.createSheet("Categories Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Category_ID");
        row.createCell(1).setCellValue("Category_Name");

        int r = 1;

        while (rs.next()) {
            int cateID = rs.getInt("Category_ID");
            String cateName = rs.getString("Category_Name");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(cateID);
            row.createCell(1).setCellValue(cateName);

            fos = new FileOutputStream("src/main/resources/shipStationData/CategoriesData.xlsx");
        }
        System.out.println(">>>TestCase 06 SUCCESSFUL<<<");
    }
}
