package com.example.smarthealthdevice.Medical.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface SugarLevelDao {
    @Query( "Select * from SugarLevelModal" )
    List<SugarLevelModel> getSugarLevelRecords();
    @Query( "Select * from SugarLevelModal where date==(:selectedDate)" )
    List<SugarLevelModel> getSugarLevelRecord(String selectedDate);
    @Insert
    void insertSugarRecord(SugarLevelModel sugarLevelModel);
    @Update
    void updateSugarRecord(SugarLevelModel sugarLevelModel);
    @Delete
    void deleteSugarRecord(SugarLevelModel sugarLevelModel);
}
