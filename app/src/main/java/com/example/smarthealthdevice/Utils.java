package com.example.smarthealthdevice;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by arvind on 5/3/21
 */
public class Utils {
    public static String formattedDate(int day, int month, int year) {
        Calendar myCalendar = new GregorianCalendar(year, month, day);
        Date myDate = myCalendar.getTime();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/YYYY");
        Log.e("TAG", "DateFor" + myDate + "Ssss " + year);
        return DateFor.format(myDate);
    }

    public static String formattedDate() {
        Calendar myCalendar = new GregorianCalendar();
        Date myDate = myCalendar.getTime();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/YYYY");
        return DateFor.format(myDate);
    }
}
