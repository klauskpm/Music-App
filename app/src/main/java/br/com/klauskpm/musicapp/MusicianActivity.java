package br.com.klauskpm.musicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MusicianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician);

        Musician musician = (Musician) getIntent().getSerializableExtra("musician");
        Log.d("MUSICIAN ACTIVITY", musician.getmName());
    }
}
