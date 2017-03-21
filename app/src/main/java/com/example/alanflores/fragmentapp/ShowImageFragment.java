package com.example.alanflores.fragmentapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by alan.flores on 1/3/17.
 */

public class ShowImageFragment extends Fragment {

    ImageView imageView;

    public static ShowImageFragment newInstance(int index) {
        ShowImageFragment f = new ShowImageFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_show_image_fragment, container,false);

        imageView = (ImageView)rootView.findViewById(R.id.image);
        Log.v("ListaPersonalizay","Elemento presionado " + getArguments().getInt("img"));
        imageView.setImageResource(getArguments().getInt("img"));

        return rootView;
    }
}
