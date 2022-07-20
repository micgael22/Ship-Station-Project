package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.SQLException;

public class TC_04_suppliers extends BaseClass{

    @Test
    public void suppliersTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM suppliers");

        //create sheet
        sheet = workbook.createSheet("Suppliers Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Suppliers_ID");
        row.createCell(1).setCellValue("Company_Name");
        row.createCell(2).setCellValue("Contact_Name");
        row.createCell(3).setCellValue("Contact_Title");
        row.createCell(4).setCellValue("Address");
        row.createCell(5).setCellValue("City");
        row.createCell(6).setCellValue("Region");
        row.createCell(7).setCellValue("Postal_Code");
        row.createCell(8).setCellValue("Country");
        row.createCell(9).setCellValue("Phone_Number");
        row.createCell(10).setCellValue("Email");

        int r = 1;

        while (rs.next()) {
            int supplID = rs.getInt("Supplier_ID");
            String compName = rs.getString("Company_Name");
            String contName = rs.getString("Contact_Name");
            String contTitle = rs.getString("Contact_Title");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String region = rs.getString("Region");
            String postCode = rs.getString("Postal_Code");
            String country = rs.getString("Country");
            String phoneNmr = rs.getString("Phone_Number");
            String email = rs.getString("Email");

            row = sheet.createRow(r++);

            //create rows and cells
            row.createCell(0).setCellValue(supplID);
            row.createCell(1).setCellValue(compName);
            row.createCell(2).setCellValue(contName);
            row.createCell(3).setCellValue(contTitle);
            row.createCell(4).setCellValue(address);
            row.createCell(5).setCellValue(city);
            row.createCell(6).setCellValue(region);
            row.createCell(7).setCellValue(postCode);
            row.createCell(8).setCellValue(country);
            row.createCell(9).setCellValue(phoneNmr);
            row.createCell(10).setCellValue(email);

            fos = new FileOutputStream("src/main/resources/shipStationData/SuppliersData.xlsx");
        }
        System.out.println(">>>TestCase 04 SUCCESSFUL<<<");
    }

}
