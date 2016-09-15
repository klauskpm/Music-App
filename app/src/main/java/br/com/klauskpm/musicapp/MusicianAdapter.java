package br.com.klauskpm.musicapp;

/**
 * Examples taken
 *
 * http://www.tutorialspoint.com/android/android_list_view.htm
 * http://www.vogella.com/tutorials/AndroidListView/article.html#listview_defaultadapter
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by klaus.machado on 14/09/2016.
 */
public class MusicianAdapter extends ArrayAdapter {
    private final Context mContext;
    private final List<Musician> mMusicians;

    public MusicianAdapter(Context context, List<Musician> musicians) {
        super(context, -1, musicians);

        this.mContext = context;
        this.mMusicians = musicians;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflating the musician item layout
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View musicianView = inflater.inflate(R.layout.basic_item, parent, false);

        // Searching and setting all resource views
        ImageView musicianImage = (ImageView) musicianView.findViewById(R.id.list_item_image__image_view);
        TextView musicianName = (TextView) musicianView.findViewById(R.id.list_item_title__text_view);
        TextView musicianAlbumsCount = (TextView) musicianView.findViewById(R.id.list_item_subtitle__text_view);

        // Getting the data for the current musician
        Musician currentMusician = this.mMusicians.get(position);

        // Setting the musician image
        musicianImage.setBackground(currentMusician.getmImg());

        // Setting the musician name
        musicianName.setText(currentMusician.getmName());

        // Setting the amount of albums, with resource string,
        // made by the musician
        int albumsCount = currentMusician.getmArrayAlbums().size();
        String stringAlbumsCount = getContext().getString(R.string.musician_albums_count, albumsCount);
        musicianAlbumsCount.setText(stringAlbumsCount);

        return musicianView;
    }
}
