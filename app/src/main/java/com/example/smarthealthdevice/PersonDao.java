package com.example.smarthealthdevice;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface PersonDao {
    @Query( "Select * from person" )
    List<ProfileModel> getPersonalList();
    @Insert
    void insertPerson(ProfileModel profileModel);

    @Update
    void updatePerson(ProfileModel profileModel);
    @Delete
    void deletePerson(ProfileModel profileModel);
}
