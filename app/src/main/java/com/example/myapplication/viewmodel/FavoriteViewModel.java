package com.example.myapplication.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.example.myapplication.database.Favorite;
import com.example.myapplication.repository.FavoriteRepository;
import java.util.List;

public class FavoriteViewModel extends ViewModel {
    private final FavoriteRepository favoriteRepository;

    public FavoriteViewModel(Application application){
        favoriteRepository = new FavoriteRepository(application);
    }

    public void insert(Favorite favorite){
        favoriteRepository.insert(favorite);
    }

    public void update(Favorite favorite) {
        favoriteRepository.update(favorite);
    }

    public void delete(Favorite favorite){
        favoriteRepository.delete(favorite);
    }

    public LiveData<List<Favorite>> getAllFav(){
        return favoriteRepository.getAllFav();
    }
}
