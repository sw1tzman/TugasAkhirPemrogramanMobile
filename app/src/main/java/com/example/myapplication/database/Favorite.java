package com.example.myapplication.database;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Favorite implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "statusFav")
    private int statusFav;

    public int getId(){
        return  id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle() {  return title; }
    public void setTitle(String title) { this.title = title; }
    public int getStatusFav(){ return statusFav; }
    public void setStatusFav(int statusFav) { this.statusFav = statusFav; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeInt(statusFav);
    }

    @Ignore
    public Favorite(){
    }

    public Favorite(int id, String title, int isFav, String video){
        this.id = id;
        this.title = title;
        this.statusFav = isFav;
    }

    protected Favorite(Parcel in) {
        id = in.readInt();
        title = in.readString();
        statusFav = in.readInt();
    }

    public static final Creator<Favorite> CREATOR = new Creator<Favorite>() {
        @Override
        public Favorite createFromParcel(Parcel in) {
            return new Favorite(in);
        }

        @Override
        public Favorite[] newArray(int size) {
            return new Favorite[size];
        }
    };
}
