package com.pereira.fatima.flicker;

        import android.support.design.widget.FloatingActionButton;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by Human Booster on 24/11/2016.
 */

public class FlickerAdapter extends BaseAdapter {

    List<ClassPhoto> classPhoto = new ArrayList<>();

    public FlickerAdapter() {
    }

    @Override
    public int getCount() {
        // La taille de la liste
        return classPhoto.size();
    }

    @Override
    // Ne pas oublier de changer Object en String ou ClassPhoto
    public ClassPhoto getItem(int position) {
        return classPhoto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convert view, view recyclée
        //Si la view est nulle, on la crée
        if (convertView == null) {
            convertView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.row_list_flicker, parent, false);
        }
        // Pour éviter de mettre des gets par la suite
        ClassPhoto photo = getItem(position);

        TextView titleFlick = (TextView)convertView.findViewById(R.id.titre_flick);
        titleFlick.setText(photo.getTitle());

        TextView urlFlick = (TextView)convertView.findViewById(R.id.url_flick);
        urlFlick.setText(photo.getUrl());

        ImageView imageFlick = (ImageView) convertView.findViewById(R.id.image_flick);
        Picasso.with(parent.getContext()).load(photo.getUrl()).resize(250, 250).into(imageFlick);

        Button btnResetFlick = (Button) convertView.findViewById(R.id.btn_reset);
//
        // Pour mettre 2 boutons cliquables l'un sous l'autre
//        btnResetFlick.setFocusable(false);
//        btnResetFlick.setFocusableInTouchMode(false);


        return  convertView;
    }
}
