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

    public Album(String mName, Drawable mCoverImg) {
        this.mName = mName;
        this.mCoverImg = mCoverImg;
    }

    public Album(String mName, Drawable mCoverImg, Musician mMusician) {
        this.mName = mName;
        this.mCoverImg = mCoverImg;
        this.mMusician = mMusician;
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

    public List<Music> getmArrayMusics() {
        return mArrayMusics;
    }

    public void setmArrayMusics(List<Music> mArrayMusics) {
        this.mArrayMusics = mArrayMusics;
    }

    public Music getMusic(int position) {
        if (mArrayMusics == null)
            return null;

        return mArrayMusics.get(position);
    }

    public Music createMusic(String musicTitle, MediaPlayer musicAudio) {
        Music music = new Music(musicTitle, musicAudio);

        mArrayMusics.add(music);

        return music;
    }
}
