package com.insertIntoDB.testCases;

import org.testng.annotations.Test;

public class TC_01_sponsor extends BaseClass04{

    @Test
    public void sponsor01() {
        sponsor_ID = 20;
        sponsor_Name = "Rollers";
        amount = 50000;
        sponsor_Level = "LEVEL 3";
        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";
    }
}
