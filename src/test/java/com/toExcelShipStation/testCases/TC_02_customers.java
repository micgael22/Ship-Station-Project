package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
public class TC_02_customers extends BaseClass {

    @Test
    public void custTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM customers");

        //create sheet
        sheet = workbook.createSheet("Customer Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Customer_ID");
        row.createCell(1).setCellValue("Company_Name");
        row.createCell(2).setCellValue("Contact_Name");
        row.createCell(3).setCellValue("Contact_Title");
        row.createCell(4).setCellValue("Address");
        row.createCell(5).setCellValue("City");
        row.createCell(6).setCellValue("Region");
        row.createCell(7).setCellValue("Postal_Code");
        row.createCell(8).setCellValue("Country");
        row.createCell(9).setCellValue("Phone_number");
        row.createCell(10).setCellValue("Email");

        int r = 1;

        while (rs.next()) {
            int custID = rs.getInt("Customer_ID");
            String compName = rs.getString("Company_Name");
            String contName = rs.getString("Contact_Name");
            String contTitle = rs.getString("Contact_Title");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String region = rs.getString("Region");
            int postalCode = rs.getInt("Postal_Code");
            String country = rs.getString("Country");
            String phoneNumber = rs.getString("Phone_number");
            String email = rs.getString("Email");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(custID);
            row.createCell(1).setCellValue(compName);
            row.createCell(2).setCellValue(contName);
            row.createCell(3).setCellValue(contTitle);
            row.createCell(4).setCellValue(address);
            row.createCell(5).setCellValue(city);
            row.createCell(6).setCellValue(region);
            row.createCell(7).setCellValue(postalCode);
            row.createCell(8).setCellValue(country);
            row.createCell(9).setCellValue(phoneNumber);
            row.createCell(10).setCellValue(email);

            fos = new FileOutputStream("src/main/resources/shipStationData/CustomersData.xlsx");
        }
        System.out.println(">>>TestCase 02 SUCCESSFUL<<<");
    }
}
