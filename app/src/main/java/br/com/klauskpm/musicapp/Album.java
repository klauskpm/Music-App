package br.com.klauskpm.musicapp;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaus.machado on 14/09/2016.
 */
public class Album {
    private String mName;
    private Drawable mCoverImg;
    private Musician mMusician;
    private List<Music> mArrayMusics = new ArrayList<Music>();

    public Album() {}

    /**
     * Album class
     *
     * @param mName of the album
     * @param mCoverImg of the album
     */
    public Album(String mName, Drawable mCoverImg) {
        this.mName = mName;
        this.mCoverImg = mCoverImg;
    }

    /**
     * Album class
     *
     * @param mName of the album
     * @param mCoverImg of the album
     * @param mMusician who made the album
     */
    public Album(String mName, Drawable mCoverImg, Musician mMusician) {
        this.mName = mName;
        this.mCoverImg = mCoverImg;
        this.mMusician = mMusician;
    }

    /**
     *
     * @return album's name
     */
    public String getmName() {
        return mName;
    }

    /**
     * Set album's name
     *
     * @param mName of the album
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     *
     * @return album's cover image
     */
    public Drawable getmCoverImg() {
        return mCoverImg;
    }

    /**
     * Set album's cover image
     *
     * @param mCoverImg of the album
     */
    public void setmCoverImg(Drawable mCoverImg) {
        this.mCoverImg = mCoverImg;
    }

    /**
     *
     * @return album's musician
     */
    public Musician getmMusician() {
        return mMusician;
    }

    /**
     * Set the album's musician
     * @param mMusician who made the album
     */
    public void setmMusician(Musician mMusician) {
        this.mMusician = mMusician;
    }

    /**
     *
     * @return a list of musics from this album
     */
    public List<Music> getmArrayMusics() {
        return mArrayMusics;
    }

    /**
     * Set a list of musics
     * @param mArrayMusics of the album
     */
    public void setmArrayMusics(List<Music> mArrayMusics) {
        this.mArrayMusics = mArrayMusics;
    }

    /**
     *
     * @param position of the desired music
     * @return a music from a list of musics
     */
    public Music getMusic(int position) {
        if (mArrayMusics == null)
            return null;

        return mArrayMusics.get(position);
    }

    /**
     * Create and add a new music to the list of musics
     *
     * @param title of the music
     * @return the created music
     */
    public Music createMusic(String title) {
        Music music = new Music(title, this);

        mArrayMusics.add(music);

        return music;
    }

    /**
     * Create and add a new music to the list of musics
     *
     * @param title of the music
     * @param audio file of the music
     * @return the created music
     */
    public Music createMusic(String title, MediaPlayer audio) {
        Music music = new Music(title, audio, this);

        mArrayMusics.add(music);

        return music;
    }
}
