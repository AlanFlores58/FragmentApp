package com.example.alanflores.fragmentapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alanflores.fragmentapp.R;

/**
 * Created by alan.flores on 1/3/17.
 */

public class OSAdapter extends ArrayAdapter<String> {
    Context context;
    String[] names;
    String[] descriptions;
    int[] idImages;

    public OSAdapter(Context context, int resource, int textViewResourceId, String[] strings){
        super(context,resource,textViewResourceId,strings);
        this.context = context;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String[] getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String[] descriptions) {
        this.descriptions = descriptions;
    }

    public int[] getIdImages() {
        return idImages;
    }

    public void setIdImages(int[] idImages) {
        this.idImages = idImages;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_list_os,parent,false);

        TextView soName = (TextView)view.findViewById(R.id.soName);
        TextView soDescription = (TextView)view.findViewById(R.id.soDescription);
        ImageView SOImage = (ImageView)view.findViewById(R.id.SOImage);

        soName.setText(names[position]);
        soDescription.setText(descriptions[position]);
        SOImage.setImageResource(idImages[position]);

        return view;
    }
}
