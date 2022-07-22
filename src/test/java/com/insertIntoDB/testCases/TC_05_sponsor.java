package com.insertIntoDB.testCases;

import org.testng.annotations.Test;

public class TC_05_sponsor extends BaseClass04{

    @Test
    public void sponsor05() {
        sponsor_ID = 24;
        sponsor_Name = "85South";
        amount = 110000;
        sponsor_Level = "LEVEL 1";
        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";
    }
}
