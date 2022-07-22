package com.insertIntoDB.testCases;

import org.testng.annotations.Test;

public class TC_03_sponsor extends BaseClass04{

    @Test
    public void sponsor03() {
        sponsor_ID = 22;
        sponsor_Name = "Big Bang";
        amount = 26000;
        sponsor_Level = "LEVEL 2";
        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";
    }
}
