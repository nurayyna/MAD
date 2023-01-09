package com.example.assignment;

import android.app.Activity;
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
 * Use the {@link ListBusStop#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListBusStop<itemList> extends Fragment {

    private List<Item> itemList1;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_bus_stop, container, false);

        mRecyclerView = rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

       

        List<Item> itemList = new ArrayList<>();

        //add item list

        itemList.add(new Item("Academy of Islamic Studies (API)", R.drawable.messageme));
        itemList.add(new Item("Academy of Malay Studies", R.drawable.messageme));
        itemList.add(new Item("Angkasapuri", R.drawable.messageme));
        itemList.add(new Item("API (Luar)", R.drawable.messageme));
        itemList.add(new Item("Bangsar South", R.drawable.messageme));
        itemList.add(new Item("Dayasari Residential College (KK5)", R.drawable.messageme));
        itemList.add(new Item("Dewan Tuanku Canselor", R.drawable.messageme));
        itemList.add(new Item("Faculty of Engineering", R.drawable.messageme));
        itemList.add(new Item("Faculty of Business and Accounting", R.drawable.messageme));
        itemList.add(new Item("International House", R.drawable.messageme));
        itemList.add(new Item("Kinabalu(KK8)/Tun Ahmad Zaidi (KK10) & FSKTM", R.drawable.messageme));
        itemList.add(new Item("Kurshiah(KK3)/Bestari(KK4)/Za'ba(KK7)", R.drawable.messageme));
        itemList.add(new Item("LRT Universiti", R.drawable.messageme));
        itemList.add(new Item("MRT Phileo Damansara", R.drawable.messageme));
        itemList.add(new Item("Pantai Permai", R.drawable.messageme));
        itemList.add(new Item("PASUM", R.drawable.messageme));
        itemList.add(new Item("PJ 219 Happy Mansion Apartment", R.drawable.messageme));
        itemList.add(new Item("PJ 220 Happy Apartment Gate A", R.drawable.messageme));
        itemList.add(new Item("Pj 223 Shell 17/22", R.drawable.messageme));
        itemList.add(new Item("Raja Dr Nazrin Shah (KK12)", R.drawable.messageme));
        itemList.add(new Item("S.K. Sri Damai", R.drawable.messageme));
        itemList.add(new Item("Stadium Hockey", R.drawable.messageme));
        itemList.add(new Item("Tuanku Abdul Rahman (KK1)", R.drawable.messageme));
        itemList.add(new Item("Tun Syed Zahiruddin (KK9)", R.drawable.messageme));
        itemList.add(new Item("UIA PJ (Barat)", R.drawable.messageme));
        itemList.add(new Item("UM Central", R.drawable.messageme));
        itemList.add(new Item("Ungku Aziz (KK11)", R.drawable.messageme));
        
        // specify an adapter (see next step)
        MyAdapter mAdapter = new MyAdapter(itemList);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListBusStop() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListBusStop.
     */
    // TODO: Rename and change types and number of parameters
    public static ListBusStop newInstance(String param1, String param2) {
        ListBusStop fragment = new ListBusStop();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
}