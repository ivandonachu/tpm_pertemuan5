package com.example.pertemuan5.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DataDiriDAO {
    @Insert
    Long insertData(Datadiri dataDiri);

    @Query("Select*from datadiri_db ")
    Datadiri[] getData();

    @Update
    int updateData(Datadiri item);

    @Delete
    void deleteData(Datadiri item);


}
