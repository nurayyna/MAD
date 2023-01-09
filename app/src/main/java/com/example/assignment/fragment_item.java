package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class fragment_item extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] route = {"UM Central - Pantai Dalam", "UM Central - Rumah Antarabangsa", "UM Central - Kolej Kediaman (KK9)",
                "UM Central - Akademik Pengajian\n" +
                        "Islam - KK12 - UM Central", "UM Central - Akademik Pengajian\n" + "Islam - KK3/4/7 - UM Central",
                "Shuttle Khas LRT Universiti", "Shuttle Khas MRT Phileo Damansara"};
        int[] icon = {R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.ab, R.drawable.ba, R.drawable.k1, R.drawable.k2};

        ListView listview = (ListView) view.findViewById(R.id.lst);
        // ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, route);
        MyAdapter1 myAdapter = new MyAdapter1(getContext(), route, icon);
        listview.setAdapter(myAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //listview.setOnItemClickListener(this);


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Toast.makeText(getActivity(), "UM Central - Pantai Dalam", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(getActivity(), C_activity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Toast.makeText(getActivity(), "UM Central - Rumah Antarabangsa", Toast.LENGTH_SHORT).show();

                }
                if (position == 2) {
                    Toast.makeText(getActivity(), "UM Central - Kolej Kediaman (KK9)", Toast.LENGTH_SHORT).show();

                }
                if (position == 3) {
                    Toast.makeText(getActivity(), "UM Central - Akademik Pengajian\n" +
                            "Islam - KK12 - UM Central", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    Toast.makeText(getActivity(), "UM Central - Akademik Pengajian\n" + "Islam - KK3/4/7 - UM Central", Toast.LENGTH_SHORT).show();
                }
                if (position == 5) {
                    Toast.makeText(getActivity(), "Shuttle Khas LRT Universiti", Toast.LENGTH_SHORT).show();
                }
                if (position == 6) {
                    Toast.makeText(getActivity(), "Shuttle Khas MRT Phileo Damansara", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}


