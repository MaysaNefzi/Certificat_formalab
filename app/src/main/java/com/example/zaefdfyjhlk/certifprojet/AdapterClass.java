package com.example.zaefdfyjhlk.certifprojet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterClass extends ArrayAdapter<Message> {
    Context ctx;

    public AdapterClass(Context context, List<Message> objects) {
        super(context, R.layout.model, objects);
        this.ctx = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(ctx).inflate(R.layout.model, parent, false);
        TextView time = convertView.findViewById(R.id.time);
        TextView sender = convertView.findViewById(R.id.sender);
        TextView contenu = convertView.findViewById(R.id.msg);
        Message msg = getItem(position);
        time.setText(msg.getTime());
        sender.setText(msg.getSender());
        contenu.setText(msg.getContenu());
        return convertView;

    }
}
