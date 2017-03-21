package com.example.alanflores.fragmentapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alanflores.fragmentapp.R;
import com.example.alanflores.fragmentapp.adapter.OSAdapter;

/**
 * Created by alan.flores on 1/3/17.
 */

public class MainFragmentActivity extends Fragment {

    ListView listView;
    boolean dualPanel;
    int checkPosition = 0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View detalleFrame = getActivity().findViewById(R.id.fDetalle);
        dualPanel = detalleFrame != null && detalleFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            checkPosition = savedInstanceState.getInt("choice", 0);
        }

        if (dualPanel) {
            //getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetail(checkPosition);
        } //else {
            //getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            //getListView().setItemChecked(checkPosition, true);
        //}
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("choice", checkPosition);
    }

    void showDetail(int index){
        checkPosition = index;

        if(dualPanel){
            //getListView().setItemChecked(index, true);
            ShowImageFragment detalle = (ShowImageFragment) getFragmentManager().findFragmentById(R.id.fDetalle);

            if (detalle == null || detalle.getShownIndex() != index) {
                detalle = ShowImageFragment.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fDetalle, detalle);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }else{
            Intent intent = new Intent();
            intent.setClass(getActivity(), ShowImageActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_main_fragment, container,false);
        String[] elementos_nombre = getResources().getStringArray(R.array.elementos_lista);
        String[] elementos_description = getResources().getStringArray(R.array.elementos_descropcion);
        int[] elementos_imagenes = {R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,};

        final OSAdapter osAdapter = new OSAdapter(getContext(), android.R.layout.simple_list_item_1, R.id.soName, elementos_nombre);

        osAdapter.setContext(getContext());
        osAdapter.setNames(elementos_nombre);
        osAdapter.setDescriptions(elementos_description);
        osAdapter.setIdImages(elementos_imagenes);

        listView = (ListView) rootView.findViewById(R.id.list_item);
        listView.setAdapter(osAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.v("ListaPersonalizay","Elemento presionado " + osAdapter.getIdImages()[position]);
                Intent intent = new Intent(getContext(),ShowImageActivity.class);
                intent.putExtra("img",osAdapter.getIdImages()[position]);
                startActivity(intent);

            }
        });

        return rootView;
    }
}
