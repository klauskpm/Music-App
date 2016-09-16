package br.com.klauskpm.musicapp;

import android.media.MediaPlayer;

/**
 * Created by klaus.machado on 16/09/2016.
 */
public class Music {
    private String mTitle;
    private MediaPlayer mMediaPlayer;

    public Music(String mTitle, MediaPlayer mMediaPlayer) {
        this.mTitle = mTitle;
        this.mMediaPlayer = mMediaPlayer;
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

    public boolean stop() {
        if (mMediaPlayer == null)
            return false;

        if (mMediaPlayer.isPlaying())
            mMediaPlayer.stop();

        return true;
    }
}
