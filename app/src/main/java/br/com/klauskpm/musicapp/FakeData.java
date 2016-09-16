package br.com.klauskpm.musicapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klaus.machado on 15/09/2016.
 */
public class FakeData {
    private List<Musician> mMusicians = new ArrayList<Musician>();

    public FakeData(Context context) {
        createPharrell(context);
        createWillIAm(context);

        for (int i = 0; i < 10; i++) {
            // Creating a musician
            this.mMusicians.add(
                    new Musician("outro", context.getDrawable(R.drawable.will_i_am))
            );
        }

    }

    private void createWillIAm(Context context) {
        // Creating a musician
        Musician willIAm = new Musician("Will.I.Am", context.getDrawable(R.drawable.will_i_am));

        this.mMusicians.add(willIAm);
    }

    private void createPharrell(Context context) {
        // Creating a musician
        Musician pharrellWilliams = new Musician("Pharrell Williams", context.getDrawable(R.drawable.pharrell_williams));

        // Creating musician albums
        pharrellWilliams.createAlbum("GIRL", context.getDrawable(R.drawable.pharrell_williams_album_girl));

        this.mMusicians.add(pharrellWilliams);
    }

    public List<Musician> getMusicians() {
        return mMusicians;
    }

    public List<Album> getAlbums(String musicianName) {
        for (int i = 0; i < mMusicians.size(); i++) {
            if (mMusicians.get(i).getmName().equalsIgnoreCase(musicianName)) {
                return mMusicians.get(i).getmArrayAlbums();
            }
        }

        return null;
    }
}
