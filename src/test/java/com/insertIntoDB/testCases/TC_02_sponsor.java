package com.insertIntoDB.testCases;

import org.testng.annotations.Test;

public class TC_02_sponsor extends BaseC_02 {
    @Test
    public void sponsor02() {
        sponsor_ID = 21;
        sponsor_Name = "Extremes";
        amount = 10000;
        sponsor_Level = "LEVEL 1";
        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";
    }
}
