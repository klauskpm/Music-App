package br.com.klauskpm.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create musicians, albums, musics; to list them
        FakeData data = new FakeData(this);

        // Initiating the Musician Adapter for a list with custom data
        MusicianAdapter adapter = new MusicianAdapter(this, data.getMusicians());

        // Searching for the target list and setting the adapter
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);

        // Add a behavior to the item click
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Finds the musician
                final Musician musician = (Musician) parent.getItemAtPosition(position);
                // Creates an intent
                Intent intent = new Intent(parent.getContext(), MusicianActivity.class);

                // Send the musician name, to find the albums,
                // and start the activity
                intent.putExtra("musician", musician.getmName());
                startActivity(intent);
            }
        });
    }
}
