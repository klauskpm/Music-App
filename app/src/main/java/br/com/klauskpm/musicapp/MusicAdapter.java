package br.com.klauskpm.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kazlauskas on 17/09/2016.
 */
public class MusicAdapter extends ArrayAdapter {
    private final Context mContext;
    private final List<Music> mMusics;
    public Music currentMusicPlaying;

    public MusicAdapter(Context context, List<Music> musics) {
        super(context, -1, musics);

        mContext = context;
        mMusics = musics;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflating the music item layout
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View musicView = inflater.inflate(R.layout.music_item, parent, false);

        TextView musicTitle = (TextView) musicView.findViewById(R.id.list_item_title__text_view);
        TextView musicContent = (TextView) musicView.findViewById(R.id.list_item_subtitle__text_view);
        ImageView musicAction = (ImageView) musicView.findViewById(R.id.music_item_action__image_button);

        final Music currentMusic = this.mMusics.get(position);

        musicTitle.setText(currentMusic.getmTitle());

        String musicContentString;
        String musicAuthor = currentMusic.getmAlbum().getmMusician().getmName();

        String musicContentAuthor = mContext.getString(
                R.string.music_content_author,
                musicAuthor
        );

        musicContentString = musicContentAuthor;

        if (currentMusic.hasAudioFile()) {
            // Reference from http://stackoverflow.com/questions/625433/how-to-convert-milliseconds-to-x-mins-x-seconds-in-java
            int musicDuration = currentMusic.getmMediaPlayer().getDuration();
            String musicDurationString = mContext.getString(R.string.music_duration,
                    TimeUnit.MILLISECONDS.toMinutes(musicDuration),
                    TimeUnit.MILLISECONDS.toSeconds(musicDuration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(musicDuration))
            );
            String musicContentDuration = mContext.getString(
                    R.string.music_content_duration,
                    musicDurationString
            );

            musicContentString += " " + musicContentDuration;

            musicAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // If it's the first music to be played, it will play and set the
                    // currentMusicPlaying, finishing the action
                    if (currentMusicPlaying == null) {
                        currentMusicPlaying = currentMusic;
                        currentMusic.play();
                        return;
                    }

                    // If the action button of a previous playing music is hit a second time
                    // it will make the music to pause
                    if (currentMusicPlaying.getmTitle().equals(currentMusic.getmTitle())) {
                        if (currentMusic.getmMediaPlayer().isPlaying()) {
                            currentMusic.pause();
                        } else {
                            currentMusic.play();
                        }
                    }
                    // If the action button of a different music is hit, it shall pause the previous
                    // and start this, changing the currentMusicPlaying
                    else {
                        currentMusicPlaying.pause();
                        currentMusic.play();
                        currentMusicPlaying = currentMusic;
                    }
                }
            });
        } else {
            // Disable the action button if there is no source file
            musicAction.setEnabled(false);
        }

        // Set the musician name and the duration of the music, if there is one
        musicContent.setText(musicContentString);

        return musicView;
    }
}
