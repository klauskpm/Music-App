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

    /**
     * Musician class
     *
     * @param mName of the musician
     * @param img for the musician thumbnail
     */
    public Musician(String mName, Drawable img) {
        this.mName = mName;
        this.mImg = img;
    }

    /**
     * @return the musician name
     */
    public String getmName() {
        return mName;
    }

    /**
     * Set the musician name
     * @param mName of the musician
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     * @return musician image/thumbnail
     */
    public Drawable getmImg() {
        return mImg;
    }

    /**
     * Set the musician image/thumbnail
     * @param mImg for the musician thumbnail
     */
    public void setmImg(Drawable mImg) {
        this.mImg = mImg;
    }

    /**
     * @return a musician's albums list
     */
    public List<Album> getmArrayAlbums() {
        return mArrayAlbums;
    }

    /**
     *
     * @param position of desired album of the list
     * @return an album from the album's list
     */
    public Album getmAlbum(int position) {
        return mArrayAlbums.get(position);
    }

    public Album createAlbum(String albumName, Drawable albumCoverImg) {
        Album album = new Album(albumName, albumCoverImg, this);

        mArrayAlbums.add(album);

        return album;
    }

    /**
     * Set an list of albums
     * @param mArrayAlbums from the musician
     */
    public void setmArrayAlbums(List<Album> mArrayAlbums) {
        this.mArrayAlbums = mArrayAlbums;
    }
}
