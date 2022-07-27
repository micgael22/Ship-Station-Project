package com.insertingData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.*;

import java.io.*;

public class LoginDetails {

    XSSFWorkbook wb;
    Sheet sheet;
    String filepath;
    FileOutputStream fos;

    @BeforeTest
    public void setup02() {
        wb = new XSSFWorkbook();
        sheet = wb.createSheet("Login Details");

    }
    @Test
    public void insertTest() {
        Object employee [][] = {{"EmpID", "User name", "Password", "Email", "UserID"},
                                {100,"Emily","masujev","emilyVK@gmail.com","mngr423957"},
                                {101,"Jason","AtuzemY","coopjs@gmail.com","mngr423958"},
                                {102,"Sheldon","ymyhyru","banners@gmail.com","mngr423959"},
                                {103,"Bernadette","AtapEzA","riverb@gmail.com","mngr423960"},
                                {104,"Kaleb","hegYzAr","Kaleb49@gmail.com", "mngr423961"},
                                {105, "Jennifer", "numUpeh", "jenny20@gmail.com", "mngr423962"},
                                {106,"Ayabonga","hArApAq","ayaku90@gmail.com","mngr423963"},
                                {107,"Jenny","gyqEdAb","mandyjj@gmail.com", "mngr423964"},
                                {108,"Riaad","esehesU","riaadson@gmail.com","mngr423965"},
                                {109,"Mac","ebUbupU","mackle@gmail.com", "mngr423966"},
                                {110,"Malcom","utytuga","ply349@gmail.com","mngr423967"},
                                {111,"Shannon","dupYtUd","shannon400@gmail.com","mngr423968"},
                                {112,"Gabrielle","UbazuqY","gabbyboss@gmail.com","mngr423969"},
                                {113,"Mindy","Amepapu","minnie382@gmail.com","mngr423970"},
                                {114,"Nkosi","ApamAjE","nkoisnok@gmail.com","mngr423971"},
                                {115,"Precious","ebebUtA","press99@gmail.com","mngr423972"},
                                {116,"Amy","tegajAg","amyVS@gmail.com","mngr423973"},
                                {117,"Louis","hequmEz","alterL500@gmail.com","mngr423974"},
                                {118,"Mandel","pErUrUz","field21@gmail.com","mngr423975"},
                                {119,"Howard","qAmUjYv","howard133@gmail.com","mngr423976"},
                                {120,"Miles","enusytU","milly80@gmail.com", "mngr423977"},
                                {121,"Fatima","UbemutU","moerat211@gmail.com", "mngr423978"}
        };

        int rows = employee.length;
        int cols = employee[0].length;
        System.out.println(rows);
        System.out.println(cols);

        int rowCount = 0;
        for (Object emp [] : employee) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            for (Object value : emp) {
                Cell cell = row.createCell(columnCount++);

                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }
    }

    @AfterTest
    public void afterTest() throws IOException {
        filepath = "src/main/resources/empPrivateData/PrivateData.xlsx";
        fos = new FileOutputStream(filepath);
        wb.write(fos);
        fos.close();

        System.out.println(">>>>>>>>file written successfully!!<<<<<<<<<<");
    }
}