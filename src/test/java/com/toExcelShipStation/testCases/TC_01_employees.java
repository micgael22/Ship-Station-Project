package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
public class TC_01_employees extends BaseClass {

    @Test
    public void empTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM employees");

        //create sheet
        sheet = workbook.createSheet("Employee Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Emp_ID");
        row.createCell(1).setCellValue("Last_name");
        row.createCell(2).setCellValue("First_name");
        row.createCell(3).setCellValue("Title");
        row.createCell(4).setCellValue("Sex");
        row.createCell(5).setCellValue("Date_of_birth");
        row.createCell(6).setCellValue("Hire_date");
        row.createCell(7).setCellValue("Address");
        row.createCell(8).setCellValue("City");
        row.createCell(9).setCellValue("Region");
        row.createCell(10).setCellValue("Postal_code");
        row.createCell(11).setCellValue("Country");
        row.createCell(12).setCellValue("Phone_number");
        row.createCell(13).setCellValue("Email");
        row.createCell(14).setCellValue("Reports_to");
        row.createCell(15).setCellValue("Salary_Rand");

        int r = 1;

        while (rs.next()) {
            int empID = rs.getInt("Emp_ID");
            String lastName = rs.getString("Last_name");
            String firstName = rs.getString("First_name");
            String title = rs.getString("Title");
            String sex = rs.getString("Sex");
            Date dateOfBirth = rs.getDate("Date_of_birth");
            Date hireDate = rs.getDate("Hire_date");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String region = rs.getString("Region");
            int postalCode = rs.getInt("Postal_code");
            String country = rs.getString("Country");
            String phoneNumber = rs.getString("Phone_number");
            String email = rs.getString("Email");
            int reportsTo = rs.getInt("Reports_to");
            Float salary = rs.getFloat("Salary_Rand");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(empID);
            row.createCell(1).setCellValue(lastName);
            row.createCell(2).setCellValue(firstName);
            row.createCell(3).setCellValue(title);
            row.createCell(4).setCellValue(sex);
            row.createCell(5).setCellValue(dateOfBirth);
            row.createCell(6).setCellValue(hireDate);
            row.createCell(7).setCellValue(address);
            row.createCell(8).setCellValue(city);
            row.createCell(9).setCellValue(region);
            row.createCell(10).setCellValue(postalCode);
            row.createCell(11).setCellValue(country);
            row.createCell(12).setCellValue(phoneNumber);
            row.createCell(13).setCellValue(email);
            row.createCell(14).setCellValue(reportsTo);
            row.createCell(15).setCellValue(salary);

            fos = new FileOutputStream("src/main/resources/shipStationData/EmployeesData.xlsx");

        }
        System.out.println(">>>TestCase 01 SUCCESSFUL<<<");
    }
}
