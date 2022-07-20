package com.toExcelShipStation.testCases;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;

public class TC_09_employeesTerritoryData extends BaseClass{

    @Test
    public void empTerritoryTest() throws SQLException, FileNotFoundException {

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM employees_territory");

        //create sheet
        sheet = workbook.createSheet("Employees Territory Data");

        //create rows
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Emp_ID");
        row.createCell(1).setCellValue("Territory_ID");

        int r = 1;

        while (rs.next()){
            int empID = rs.getInt("Emp_ID");
            String terrID = rs.getString("Territory_ID");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(empID);
            row.createCell(1).setCellValue(terrID);

            fos = new FileOutputStream("src/main/resources/shipStationData/EmployeesTerritoryData.xlsx");
        }
        System.out.println(">>>TestCase 09 SUCCESSFUL<<<");
    }
}
