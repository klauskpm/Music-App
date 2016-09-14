package br.com.klauskpm.musicapp;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaus.machado on 14/09/2016.
 */
public class Musician {
    private String mName;
    private Drawable mImg;
    private List<Album> mArrayAlbums = new ArrayList<Album>();

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

    public List<Album> getmArrayAlbums() {
        return mArrayAlbums;
    }

    public Album getmAlbum(int position) {
        return mArrayAlbums.get(position);
    }

    public void createAlbum(String albumName, Drawable albumCoverImg) {
        Album album = new Album(albumName, albumCoverImg);
        album.setmMusician(this);

        mArrayAlbums.add(album);
    }

    public void setmArrayAlbums(List<Album> mArrayAlbums) {
        this.mArrayAlbums = mArrayAlbums;
    }
}
