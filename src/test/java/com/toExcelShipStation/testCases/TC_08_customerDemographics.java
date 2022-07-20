package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class TC_08_customerDemographics extends BaseClass{

    @Test
    public void custDemoGrTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM customer_demographics");

        //create sheet
        sheet = workbook.createSheet("Customer Demographics Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Customer_Type_ID");
        row.createCell(1).setCellValue("Customer_Desc");

        int r = 1;

        while (rs.next()) {
            int custTypeID = rs.getInt("Customer_Type_ID");
            String custDesc = rs.getString("Customer_Desc");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(custTypeID);
            row.createCell(1).setCellValue(custDesc);

            fos = new FileOutputStream("src/main/resources/shipStationData/customerDemographicsData.xlsx");
        }
        System.out.println(">>>TestCase 08 SUCCESSFUL<<<");
    }
}
