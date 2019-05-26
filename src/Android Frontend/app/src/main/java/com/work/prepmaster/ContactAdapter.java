package com.work.prepmaster;


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<ListviewModel> {

    public ContactAdapter(Context context, int resource,List<ListviewModel> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.listview_identify,parent,false);
        }
        TextView userName = convertView.findViewById(R.id.user_name);
        TextView score = convertView.findViewById(R.id.score);

        ListviewModel lvModel = getItem(position);
        userName.setText(lvModel.getUserName());
        score.setText(lvModel.getScore());

        return convertView;
    }
}
