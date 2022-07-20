package com.toExcelShipStation.testCases;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class BaseClass {
    public Connection con;
    public Statement stmt;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public ResultSet rs;
    public FileOutputStream fos;

    @BeforeTest
    public void setup() throws SQLException {

        //Connect to the database
        con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/ship_station","root","PASSWORD");

        //statement/query
        stmt = con.createStatement();

        //Excel
        workbook = new XSSFWorkbook();
    }

    @AfterTest
    public void afterTest() throws IOException, SQLException {
        //fos = new FileOutputStream("src/main/resources/excelFiles/ShipStationData.xlsx");
        workbook.write(fos);
        workbook.close();
        fos.close();
        con.close();

        System.out.println(">>>>>>>>Connected<<<<<<<<<");
    }
}
