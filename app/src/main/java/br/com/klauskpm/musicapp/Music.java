package br.com.klauskpm.musicapp;

import android.media.MediaPlayer;

/**
 * Created by klaus.machado on 16/09/2016.
 */
public class Music {
    private String mTitle;
    private MediaPlayer mMediaPlayer;
    private Album mAlbum;

    /**
     * Music class
     *
     * @param mTitle of the music
     * @param mAlbum of the music
     */
    public Music(String mTitle, Album mAlbum) {
        this.mTitle = mTitle;
        this.mAlbum = mAlbum;
    }

    /**
     * Music class
     *
     * @param mTitle of the music
     * @param mMediaPlayer of the music
     * @param mAlbum of the music
     */
    public Music(String mTitle, MediaPlayer mMediaPlayer, Album mAlbum) {
        this.mTitle = mTitle;
        this.mMediaPlayer = mMediaPlayer;
        this.mAlbum = mAlbum;
    }

    /**
     *
     * @return music's title
     */
    public String getmTitle() {
        return mTitle;
    }

    /**
     * Set music title
     *
     * @param mTitle of the music
     */
    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    /**
     *
     * @return music's media player
     */
    public MediaPlayer getmMediaPlayer() {
        return mMediaPlayer;
    }

    /**
     * Set music media player
     *
     * @param mMediaPlayer of the music
     */
    public void setmMediaPlayer(MediaPlayer mMediaPlayer) {
        this.mMediaPlayer = mMediaPlayer;
    }

    /**
     * Plays the media player
     *
     * @return if the action was done
     */
    public boolean play() {
        if (mMediaPlayer == null)
            return false;

        if (!mMediaPlayer.isPlaying())
            mMediaPlayer.start();

        return true;
    }

    /**
     * Pauses the media player
     *
     * @return if the action was done
     */
    public boolean pause() {
        if (mMediaPlayer == null)
            return false;

        if (mMediaPlayer.isPlaying())
            mMediaPlayer.pause();

        return true;
    }

    /**
     * Verifies if there is an audio file
     *
     * @return true if there is an audio file
     */
    public boolean hasAudioFile() {
        return mMediaPlayer != null;
    }

    /**
     *
     * @return the music's album
     */
    public Album getmAlbum() {
        return mAlbum;
    }

    /**
     * Set music's album
     *
     * @param mAlbum of the music
     */
    public void setmAlbum(Album mAlbum) {
        this.mAlbum = mAlbum;
    }
}
