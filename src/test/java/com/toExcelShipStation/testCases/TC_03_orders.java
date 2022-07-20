package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.SQLException;

public class TC_03_orders extends BaseClass{

    @Test
    public void ordersTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM orders");

        //create sheet
        sheet = workbook.createSheet("Orders Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Order_ID");
        row.createCell(1).setCellValue("Customer_ID");
        row.createCell(2).setCellValue("Emp_ID");
        row.createCell(3).setCellValue("Order_Date");
        row.createCell(4).setCellValue("Required_Date");
        row.createCell(5).setCellValue("Shipped_Date");
        row.createCell(6).setCellValue("Shipper_ID");
        row.createCell(7).setCellValue("Ship_Via");
        row.createCell(8).setCellValue("Freight");
        row.createCell(9).setCellValue("Ship_Name");
        row.createCell(10).setCellValue("Ship_Address");
        row.createCell(11).setCellValue("Ship_City");
        row.createCell(12).setCellValue("Ship_Region");
        row.createCell(13).setCellValue("Ship_PostalCode");
        row.createCell(14).setCellValue("Ship_Country");

        int r = 1;

        while (rs.next()) {
            int orderID = rs.getInt("Order_ID");
            int custID = rs.getInt("Customer_ID");
            int empID = rs.getInt("Emp_ID");
            Date orderDate = rs.getDate("Order_Date");
            Date reqDate = rs.getDate("Required_Date");
            Date shippedDate = rs.getDate("Shipped_Date");
            int shipperID = rs.getInt("Shipper_ID");
            int shipVia = rs.getInt("Ship_Via");
            double freight = rs.getDouble("Freight");
            String shipName = rs.getString("Ship_Name");
            String shipAdd = rs.getString("Ship_Address");
            String shipCity = rs.getString("Ship_City");
            String shipRegion = rs.getString("Ship_Region");
            String shipPostalCode = rs.getString("Ship_PostalCode");
            String shipCountry = rs.getString("Ship_Country");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(orderID);
            row.createCell(1).setCellValue(custID);
            row.createCell(2).setCellValue(empID);
            row.createCell(3).setCellValue(orderDate);
            row.createCell(4).setCellValue(reqDate);
            row.createCell(5).setCellValue(shippedDate);
            row.createCell(6).setCellValue(shipperID);
            row.createCell(7).setCellValue(shipVia);
            row.createCell(8).setCellValue(freight);
            row.createCell(9).setCellValue(shipName);
            row.createCell(10).setCellValue(shipAdd);
            row.createCell(11).setCellValue(shipCity);
            row.createCell(12).setCellValue(shipRegion);
            row.createCell(13).setCellValue(shipPostalCode);
            row.createCell(14).setCellValue(shipCountry);

            fos = new FileOutputStream("src/main/resources/shipStationData/OrdersData.xlsx");
        }
        System.out.println(">>>TestCase 03 SUCCESSFUL<<<");
    }
}
