package com.example.myapplication.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FavoriteDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Favorite favorite);

    @Update()
    void update(Favorite favorite);

    @Delete
    void delete(Favorite favorite);

    @Query("SELECT * FROM Favorite ORDER BY id ASC")
    LiveData<List<Favorite>> getAllFav();
}
