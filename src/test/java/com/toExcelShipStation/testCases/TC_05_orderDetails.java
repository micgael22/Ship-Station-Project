package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class TC_05_orderDetails extends BaseClass{

    @Test
    public void orderDTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM order_details");

        //create sheet
        sheet = workbook.createSheet("Order Details Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Order_ID");
        row.createCell(1).setCellValue("Product_ID");
        row.createCell(2).setCellValue("Unit_Price");
        row.createCell(3).setCellValue("Quantity");
        row.createCell(4).setCellValue("Discount");

        int r = 1;

        while (rs.next()) {
            int supplierID = rs.getInt("Order_ID");
            int productID = rs.getInt("Product_ID");
            int unitPrice = rs.getInt("Unit_Price");
            int quantity = rs.getInt("Quantity");
            String discount = rs.getString("Discount");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(supplierID);
            row.createCell(1).setCellValue(productID);
            row.createCell(2).setCellValue(unitPrice);
            row.createCell(3).setCellValue(quantity);
            row.createCell(4).setCellValue(discount);

            fos = new FileOutputStream("src/main/resources/shipStationData/OrderDetailsData.xlsx");
        }
        System.out.println(">>>TestCase 05 SUCCESSFUL<<<");
    }
}
