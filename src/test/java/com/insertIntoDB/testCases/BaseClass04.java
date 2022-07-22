package com.insertIntoDB.testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseClass04 {

    int sponsor_ID;
    String sponsor_Name;
    int amount;
    String sponsor_Level;
    String sql;
    Connection con;

    @BeforeTest
    public void setup04() throws SQLException {
        //Connect to the database
        con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/ship_station","root","thebigbangtheory05__");
    }

    @AfterTest
    public void afterTest04() throws SQLException {

        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/ship_station","root","PASSWORD");

            Statement st = con.createStatement();
            int m =st.executeUpdate(sql);
            if (m == 1)
                System.out.println("Insert data successfully : " + sql);
            else
                System.out.println("Insertion data failed");
        }
        catch (Exception e) {
            System.err.println(e);
        }
        finally {
            con.close();
        }
    }
}
