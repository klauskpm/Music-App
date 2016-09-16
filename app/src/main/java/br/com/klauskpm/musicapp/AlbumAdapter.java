package br.com.klauskpm.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by klaus.machado on 15/09/2016.
 */
public class AlbumAdapter extends ArrayAdapter {
    private final Context mContext;
    private final List<Album> mAlbums;

    public AlbumAdapter(Context context, List<Album> albums) {
        super(context, -1, albums);

        mContext = context;
        mAlbums = albums;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View albumView = inflater.inflate(R.layout.basic_item, parent, false);

        // Searching and setting all resource views
        ImageView albumCoverImage = (ImageView) albumView.findViewById(R.id.list_item_image__image_view);
        TextView albumTitle = (TextView) albumView.findViewById(R.id.list_item_title__text_view);

        // Getting the data for the current album
        Album currentAlbum = mAlbums.get(position);

        // Setting the album cover image
        albumCoverImage.setBackground(currentAlbum.getmCoverImg());
        albumCoverImage.setContentDescription(
                mContext.getString(
                        R.string.album_description,
                        currentAlbum.getmName(),
                        currentAlbum.getmMusician().getmName()
                )
        );

        // Setting the album title
        albumTitle.setText(currentAlbum.getmName());

        return albumView;
    }
}
