package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class TC_13_products extends BaseClass{

    @Test
    public void prodTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM products");

        //create sheet
        sheet = workbook.createSheet("Products Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Product_ID");
        row.createCell(1).setCellValue("Product_Name");
        row.createCell(2).setCellValue("Supplier_ID");
        row.createCell(3).setCellValue("Category_ID");
        row.createCell(4).setCellValue("Quantity_Per_Unit");
        row.createCell(5).setCellValue("Unit_Price");
        row.createCell(6).setCellValue("Units_in_Stock");
        row.createCell(7).setCellValue("Units_in_Order");
        row.createCell(8).setCellValue("Reorder_Level");
        row.createCell(9).setCellValue("Discount");
        row.createCell(10).setCellValue("Discontinued");

        int r = 1;

        while (rs.next()) {
            int productID = rs.getInt("Product_ID");
            String productName = rs.getString("Product_Name");
            int supplierID = rs.getInt("Supplier_ID");
            int cateID = rs.getInt("Category_ID");
            String quanPerUnt = rs.getString("Quantity_Per_Unit");
            int unitPrice = rs.getInt("Unit_Price");
            int unitInStock = rs.getInt("Units_in_Stock");
            int unitInOrder = rs.getInt("Units_in_Order");
            int reorderLevel = rs.getInt("Reorder_Level");
            String discount = rs.getString("Discount");
            String discontinued = rs.getString("Discontinued");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(productID);
            row.createCell(1).setCellValue(productName);
            row.createCell(2).setCellValue(supplierID);
            row.createCell(3).setCellValue(cateID);
            row.createCell(4).setCellValue(quanPerUnt);
            row.createCell(5).setCellValue(unitPrice);
            row.createCell(6).setCellValue(unitInStock);
            row.createCell(7).setCellValue(unitInOrder);
            row.createCell(8).setCellValue(reorderLevel);
            row.createCell(9).setCellValue(discount);
            row.createCell(10).setCellValue(discontinued);

            fos = new FileOutputStream("src/main/resources/shipStationData/ProductsData.xlsx");
        }
        System.out.println(">>>TestCase 13 SUCCESSFUL<<<");
    }
}