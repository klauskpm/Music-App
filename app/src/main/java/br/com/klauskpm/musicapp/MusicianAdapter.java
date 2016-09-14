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
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View musicianView = inflater.inflate(R.layout.musician_item, parent, false);

        ImageView musicianImage = (ImageView) musicianView.findViewById(R.id.musician_image__image_view);
        TextView musicianName = (TextView) musicianView.findViewById(R.id.musician_name__text_view);
        TextView musicianAlbumsCount = (TextView) musicianView.findViewById(R.id.musician_albuns_count__text_view);

        Musician currentMusician = this.mMusicians.get(position);

        musicianImage.setBackground(currentMusician.getmImg());
        musicianName.setText(currentMusician.getmName());


        String stringAlbumsCount = getContext().getString(R.string.musician_albums_count, currentMusician.getmAlbums());
        musicianAlbumsCount.setText(stringAlbumsCount);

        return musicianView;
    }
}
