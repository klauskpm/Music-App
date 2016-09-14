package br.com.klauskpm.musicapp;

import android.graphics.drawable.Drawable;

/**
 * Created by klaus.machado on 14/09/2016.
 */
public class Album {
    private String mName;
    private Drawable mCoverImg;
    private Musician mMusician;

    public Album() {}

    public Album(String mName, Drawable mCoverImg) {
        this.mName = mName;
        this.mCoverImg = mCoverImg;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Drawable getmCoverImg() {
        return mCoverImg;
    }

    public void setmCoverImg(Drawable mCoverImg) {
        this.mCoverImg = mCoverImg;
    }

    public Musician getmMusician() {
        return mMusician;
    }

    public void setmMusician(Musician mMusician) {
        this.mMusician = mMusician;
    }
}
