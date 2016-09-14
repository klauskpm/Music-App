package br.com.klauskpm.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Musician> mArrayMusicians = new ArrayList<Musician>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Musician pharrellWilliams = new Musician("Pharrell Williams", getDrawable(R.drawable.pharrell_williams));
        Musician willIAm = new Musician("Will.I.Am", getDrawable(R.drawable.will_i_am));

        this.mArrayMusicians.add(pharrellWilliams);
        this.mArrayMusicians.add(willIAm);

        ArrayAdapter adapter = new MusicianAdapter(this, this.mArrayMusicians);

        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);
    }
}
