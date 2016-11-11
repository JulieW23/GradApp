package com.team_05.kiddo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomMessageList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;

    public CustomMessageList(Activity context, String[] web, Integer[] imageId) {
        super(context, R.layout.layout_message, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.layout_message, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.messageTextView);

        return rowView;
    }
}
