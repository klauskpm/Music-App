package br.com.klauskpm.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MusicianActivity extends AppCompatActivity {
    private List<Album> mArrayAlbums = new ArrayList<Album>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician);

        Bundle intentData = getIntent().getExtras();

        String musicianName = intentData.getString("musician");
        Log.d("MUSICIAN ACTIVITY", musicianName);

        FakeData data = new FakeData(this);
        mArrayAlbums = data.getAlbums(musicianName);

        for (int i = 0; i < mArrayAlbums.size(); i++) {
            Log.d("MUSICIAN ACTIVITY", "onCreate: " + mArrayAlbums.get(i).getmName());
        }
    }
}
