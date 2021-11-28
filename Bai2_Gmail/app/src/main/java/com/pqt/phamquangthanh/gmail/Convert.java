package com.pqt.phamquangthanh.gmail;

import java.util.Calendar;
import java.util.Date;

public class Convert {
    public static String getFormTime(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int hour_check = calendar.get(Calendar.HOUR_OF_DAY);
        if(hour_check >= 12) {
            return hour + ":" + minute + " PM";
        }else{
            return hour + ":" + minute + " AM";
        }
    }
}
