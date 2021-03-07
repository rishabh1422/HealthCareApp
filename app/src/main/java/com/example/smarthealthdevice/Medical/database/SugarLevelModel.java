package com.example.smarthealthdevice.Medical.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "SugarLevelModal")
public class SugarLevelModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "date")
    private Date date;
    @ColumnInfo(name = "upper_reading")
    private float upperReading;
    @ColumnInfo(name = "lower_reading")
    private float lowerReading;

    public SugarLevelModel() {

    }

    public SugarLevelModel( Date date, float upperReading, float lowerReading) {
        this.date = date;
        this.upperReading = upperReading;
        this.lowerReading = lowerReading;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getUpperReading() {
        return upperReading;
    }

    public void setUpperReading(float upperReading) {
        this.upperReading = upperReading;
    }

    public float getLowerReading() {
        return lowerReading;
    }

    public void setLowerReading(float lowerReading) {
        this.lowerReading = lowerReading;
    }
}

