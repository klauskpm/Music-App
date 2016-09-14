package br.com.klauskpm.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Musician> mArrayMusicians = new ArrayList<Musician>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create musicians, albums, musics; to list them
        createData();

        ArrayAdapter adapter = new MusicianAdapter(this, this.mArrayMusicians);

        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Musician musician = (Musician) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, musician.getmName(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(parent.getContext(), MusicianActivity.class);
//
//                intent.putExtra("musician", musician);
//                startActivity(intent);
            }
        });
    }

    private void createData() {
        Musician pharrellWilliams = new Musician("Pharrell Williams", getDrawable(R.drawable.pharrell_williams));
        pharrellWilliams.createAlbum("GIRL", getDrawable(R.drawable.pharrell_williams_album_girl));

        Musician willIAm = new Musician("Will.I.Am", getDrawable(R.drawable.will_i_am));

        this.mArrayMusicians.add(pharrellWilliams);
        this.mArrayMusicians.add(willIAm);
    }
}
