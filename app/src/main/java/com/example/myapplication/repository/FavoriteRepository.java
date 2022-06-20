package com.example.myapplication.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myapplication.database.Favorite;
import com.example.myapplication.database.FavoriteDAO;
import com.example.myapplication.database.FavoriteDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FavoriteRepository {
    private final FavoriteDAO favoriteDAO;
    private final ExecutorService executorService;

    public FavoriteRepository(Application application){
        executorService = Executors.newSingleThreadExecutor();
        FavoriteDatabase favoriteDatabase = FavoriteDatabase.getDatabase(application);
        favoriteDAO = favoriteDatabase.favoriteDAO();
    }

    public LiveData<List<Favorite>> getAllFav(){
        return favoriteDAO.getAllFav();
    }

    public void insert(final Favorite favorite){
        executorService.execute(() -> favoriteDAO.insert(favorite));
    }

    public void update(final Favorite favorite){
        executorService.execute(() -> favoriteDAO.update(favorite));
    }

    public void delete(final Favorite favorite){
        executorService.execute(() -> favoriteDAO.delete(favorite));
    }
}
