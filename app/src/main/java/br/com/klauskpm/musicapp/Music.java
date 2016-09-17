package br.com.klauskpm.musicapp;

import android.media.MediaPlayer;

/**
 * Created by klaus.machado on 16/09/2016.
 */
public class Music {
    private String mTitle;
    private MediaPlayer mMediaPlayer;
    private Album mAlbum;

    public Music(String mTitle, Album mAlbum) {
        this.mTitle = mTitle;
        this.mAlbum = mAlbum;
    }

    public Music(String mTitle, MediaPlayer mMediaPlayer, Album mAlbum) {
        this.mTitle = mTitle;
        this.mMediaPlayer = mMediaPlayer;
        this.mAlbum = mAlbum;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public MediaPlayer getmMediaPlayer() {
        return mMediaPlayer;
    }

    public void setmMediaPlayer(MediaPlayer mMediaPlayer) {
        this.mMediaPlayer = mMediaPlayer;
    }

    public boolean play() {
        if (mMediaPlayer == null)
            return false;

        if (!mMediaPlayer.isPlaying())
            mMediaPlayer.start();

        return true;
    }

    public boolean pause() {
        if (mMediaPlayer == null)
            return false;

        if (mMediaPlayer.isPlaying())
            mMediaPlayer.pause();

        return true;
    }

    public boolean hasAudioFile() {
        return mMediaPlayer != null;
    }

    public Album getmAlbum() {
        return mAlbum;
    }

    public void setmAlbum(Album mAlbum) {
        this.mAlbum = mAlbum;
    }
}
