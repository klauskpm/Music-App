package br.com.klauskpm.musicapp;

import android.graphics.drawable.Drawable;

/**
 * Created by klaus.machado on 14/09/2016.
 */
public class Musician {
    private String mName;
    private Drawable mImg;
    private int mAlbums;

    public Musician() {}

    public Musician(String mName, Drawable img) {
        this.mName = mName;
        this.mImg = img;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Drawable getmImg() {
        return mImg;
    }

    public void setmImg(Drawable mImg) {
        this.mImg = mImg;
    }

    public int getmAlbums() {
        return mAlbums;
    }

    public void setmAlbums(int mAlbums) {
        this.mAlbums = mAlbums;
    }

}
