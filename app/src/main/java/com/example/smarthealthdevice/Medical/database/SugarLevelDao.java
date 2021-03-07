package com.example.smarthealthdevice.Medical.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.Date;
import java.util.List;
@Dao
public interface SugarLevelDao {
    @Query( "Select * from SugarLevelModal ORDER BY date DESC LIMIT 7" )
    List<SugarLevelModel> getSugarLevelLastWeekRecords();
    @Query( "Select * from SugarLevelModal where date==(:selectedDate)" )
    List<SugarLevelModel> getSugarLevelRecord(Date selectedDate);
    @Insert
    void insertSugarRecord(SugarLevelModel sugarLevelModel);
    @Update
    void updateSugarRecord(SugarLevelModel sugarLevelModel);
    @Delete
    void deleteSugarRecord(SugarLevelModel sugarLevelModel);
}
