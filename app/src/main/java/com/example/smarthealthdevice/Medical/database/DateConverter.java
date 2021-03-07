package com.example.smarthealthdevice.Medical.database;

import androidx.room.TypeConverter;

import java.util.Date;

/**
 * Created by arvind on 7/3/21
 */
public class DateConverter {

    @TypeConverter
    public static Date toDate(Long dateLong){
        return dateLong == null ? null: new Date(dateLong);
    }

    @TypeConverter
    public static Long fromDate(Date date){
        return date == null ? null : date.getTime();
    }
}
