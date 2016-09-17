package br.com.klauskpm.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MusicianActivity extends AppCompatActivity {
    List<Album> mArrayAlbums = new ArrayList<Album>();
    String mMusicianName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician);

        // Get the data from intent
        initIntentData();

        TextView musicianNameTextView = (TextView) findViewById(R.id.activity_title__text_view);
        musicianNameTextView.setText(mMusicianName);

        // Initiating the Musician Adapter for a list with custom data
        AlbumAdapter adapter = new AlbumAdapter(this, mArrayAlbums);

        // Searching for the target list and setting the adapter
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);

        // Finishes the activity
        musicianNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Add a behavior to the item click
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Finds the album
                final Album album = (Album) parent.getItemAtPosition(position);
                // Creates an intent
                Intent intent = new Intent(parent.getContext(), AlbumActivity.class);

                // Send the album and musician name,
                //  to find the music, and start the activity
                intent.putExtra("musician", album.getmMusician().getmName());
                intent.putExtra("album", album.getmName());
                startActivity(intent);
            }
        });
    }

    /**
     * Get the intent data and sets the musician name and a list of albums
     */
    private void initIntentData() {
        Bundle intentData = getIntent().getExtras();
        mMusicianName = intentData.getString("musician");

        // Create musicians, albums, musics; to list them
        FakeData data = new FakeData(this);
        // Gets the musician's albums
        mArrayAlbums = data.getAlbums(mMusicianName);
    }
}
