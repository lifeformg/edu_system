package com.system.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormer {
    static public String getDateFormed(Date date){
        SimpleDateFormat former = new SimpleDateFormat("MM/dd/yyyy");
        return former.format(date);
    }
}
