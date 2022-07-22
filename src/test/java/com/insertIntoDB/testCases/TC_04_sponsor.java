package com.insertIntoDB.testCases;

import org.testng.annotations.Test;

public class TC_04_sponsor extends BaseClass04{

    @Test
    public void sponsor04() {
        sponsor_ID = 23;
        sponsor_Name = "Palace";
        amount = 540000;
        sponsor_Level = "LEVEL 3";
        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";
    }
}
