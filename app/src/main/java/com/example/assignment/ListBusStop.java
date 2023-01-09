package com.example.assignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ListBusStop extends Fragment {

//    RecyclerView recyclerView;
//    LinearLayoutManager layoutManager;
//    List<ModelClass>busStopList;
//    Adapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_bus_stop, container, false);

    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        ImageButton BtnBack = view.findViewById(R.id.backButton51);
        View.OnClickListener AboutUs = v -> Navigation.findNavController(view).navigate(R.id.menu);
        BtnBack.setOnClickListener(AboutUs);

    }
}


//    private void setContentView(int activity_main) {
//    }
//
//    private void initData() {
//
//        busStopList = new ArrayList<>();
//
//        busStopList.add(new ModelClass(R.drawable.icons, "Academy of Islamic Studies (API)"));
//        busStopList.add(new ModelClass(R.drawable.icons, "Academy of Malay Studies"));
//        busStopList.add(new ModelClass(R.drawable.icons, "Angkasapuri"));
//        busStopList.add(new ModelClass(R.drawable.icons, "API (Luar)"));
//        busStopList.add(new ModelClass(R.drawable.icons, "Bangsar South"));
//        busStopList.add(new ModelClass(R.drawable.icons, "Dayasari Residential College (KK5)"));
//        busStopList.add(new ModelClass(R.drawable.icons, "Dewan Tuanku Canselor"));
//        busStopList.add(new ModelClass(R.drawable.icons, "Faculty of Business and Accounting"));
//        busStopList.add(new ModelClass(R.drawable.icons, "Academy of Malay Studies"));
//
//    }
//
//    private void initRecyclerView() {
//
//        RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerView);
//        layoutManager = new LinearLayoutManager(getActivity());
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
//        adapter = new Adapter(busStopList);
//        recyclerView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
//    }
//
//    private List<Item> itemList = new ArrayList<>();
//    private RecyclerView mRecyclerView;
//    private RecyclerView.LayoutManager mLayoutManager;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_list_bus_stop, container, false);
//
//        mRecyclerView = rootView.findViewById(R.id.recycler_view);
//        mRecyclerView.setHasFixedSize(true);
//
//        // use a linear layout manager
//        mLayoutManager = new LinearLayoutManager(getActivity());
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//
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
//        // specify an adapter (see next step)
//        MyAdapter mAdapter = new MyAdapter(itemList);
//        mRecyclerView.setAdapter(mAdapter);
//
//        return rootView;
//    }


