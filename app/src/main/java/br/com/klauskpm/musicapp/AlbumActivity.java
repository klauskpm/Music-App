package br.com.klauskpm.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends AppCompatActivity {
    private String mAlbumName;
    private List<Music> mArrayMusics = new ArrayList<Music>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        // Get the data from intent
        initIntentDate();

        TextView albumTitleTextView = (TextView) findViewById(R.id.activity_title__text_view);
        albumTitleTextView.setText(mAlbumName);


    }

    /**
     * Get the intent data and sets the album name and a list of musics
     */
    private void initIntentDate() {
        Bundle intentData = (Bundle) getIntent().getExtras();

        String musicianName = intentData.getString("musician");
        mAlbumName = intentData.getString("album");

        FakeData data = new FakeData(this);
        mArrayMusics = data.getMusics(musicianName, mAlbumName);
    }
}