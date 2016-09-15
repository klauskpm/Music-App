package br.com.klauskpm.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MusicianActivity extends AppCompatActivity {
    private List<Album> mArrayAlbums = new ArrayList<Album>();
    private String mMusicianName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician);

        Bundle intentData = getIntent().getExtras();
        mMusicianName = intentData.getString("musician");

        TextView musicianNameTextView = (TextView) findViewById(R.id.musician_name__text_view);
        musicianNameTextView.setText(mMusicianName);

        // Create musicians, albums, musics; to list them
        FakeData data = new FakeData(this);
        // Gets the musician's albums
        mArrayAlbums = data.getAlbums(mMusicianName);

        // Initiating the Musician Adapter for a list with custom data
        AlbumAdapter adapter = new AlbumAdapter(this, mArrayAlbums);

        // Searching for the target list and setting the adapter
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);

        musicianNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
