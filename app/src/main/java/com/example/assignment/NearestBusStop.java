package com.example.assignment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NearestBusStop#newInstance} factory method to
 * create an instance of this fragment.
 */

public class NearestBusStop extends Fragment {

    private RecyclerView recyclerView;
    private List<Item> itemList;
    private ItemAdapter itemAdapter;
    private SearchView searchView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NearestBusStop() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NearestBusStop.
     */
    // TODO: Rename and change types and number of parameters
    public static NearestBusStop newInstance(String param1, String param2) {
        NearestBusStop fragment = new NearestBusStop();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_nearest_bus_stop);

        SearchView searchView = (SearchView) recyclerView.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

           @Override
           public boolean onQueryTextChange(String newText) {
                return true;
            }
       });

        RecyclerView recyclerView = (RecyclerView) searchView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
  //     recyclerView.setLayoutManager(new LinearLayoutManager());
        itemList = new ArrayList<>();

//        //add item list
//
//        itemList.add(new Item("Academy of Islamic Studies (API)", R.drawable.messageme));
//        itemList.add(new Item("Academy of Malay Studies", R.drawable.messageme));
//        itemList.add(new Item("Angkasapuri", R.drawable.messageme));
//        itemList.add(new Item("API (Luar)", R.drawable.messageme));
//        itemList.add(new Item("Bangsar South", R.drawable.messageme));
//        itemList.add(new Item("Dayasari Residential College (KK5)", R.drawable.messageme));
//        itemList.add(new Item("Dewan Tuanku Canselor", R.drawable.messageme));
//        itemList.add(new Item("Faculty of Engineering", R.drawable.messageme));
//        itemList.add(new Item("Faculty of Business and Accounting", R.drawable.messageme));
//        itemList.add(new Item("International House", R.drawable.messageme));
//        itemList.add(new Item("Kinabalu(KK8)/Tun Ahmad Zaidi (KK10) & FSKTM", R.drawable.messageme));
//        itemList.add(new Item("Kurshiah(KK3)/Bestari(KK4)/Za'ba(KK7)", R.drawable.messageme));
//        itemList.add(new Item("LRT Universiti", R.drawable.messageme));
//        itemList.add(new Item("MRT Phileo Damansara", R.drawable.messageme));
//        itemList.add(new Item("Pantai Permai", R.drawable.messageme));
//        itemList.add(new Item("PASUM", R.drawable.messageme));
//        itemList.add(new Item("PJ 219 Happy Mansion Apartment", R.drawable.messageme));
//        itemList.add(new Item("PJ 220 Happy Apartment Gate A", R.drawable.messageme));
//        itemList.add(new Item("Pj 223 Shell 17/22", R.drawable.messageme));
//        itemList.add(new Item("Raja Dr Nazrin Shah (KK12)", R.drawable.messageme));
//        itemList.add(new Item("S.K. Sri Damai", R.drawable.messageme));
//        itemList.add(new Item("Stadium Hockey", R.drawable.messageme));
//        itemList.add(new Item("Tuanku Abdul Rahman (KK1)", R.drawable.messageme));
//        itemList.add(new Item("Tun Syed Zahiruddin (KK9)", R.drawable.messageme));
//        itemList.add(new Item("UIA PJ (Barat)", R.drawable.messageme));
//        itemList.add(new Item("UM Central", R.drawable.messageme));
//        itemList.add(new Item("Ungku Aziz (KK11)", R.drawable.messageme));
//
//
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

//    private void filterList(String text){
//        List<Item> filteredList = new ArrayList<>();
//        for (Item item : itemList){
//            if (item.getItemName().toLowerCase().contains(text.toLowerCase())){
//                filteredList.add(item);
//            }
//        }
//
//        if (filteredList.isEmpty()){
//            Toast.makeText(this,"No data found", Toast.LENGTH_SHORT).show();
//        } else {
//            itemAdapter.setFilteredList(filteredList);
//        }
//    }

    private void setContentView(int fragment_nearest_bus_stop) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nearest_bus_stop, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

    }
}