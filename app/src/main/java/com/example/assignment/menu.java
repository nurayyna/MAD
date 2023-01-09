package com.example.assignment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment menu.
     */
    // TODO: Rename and change types and number of parameters
    public static menu newInstance(String param1, String param2) {
        menu fragment = new menu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){

        ImageButton BtnAboutUs = view.findViewById(R.id.AboutUsBtn);
        View.OnClickListener AboutUs = v -> Navigation.findNavController(view).navigate(R.id.action_menu_to_aboutUsFragment);
        BtnAboutUs.setOnClickListener(AboutUs);

        ImageButton BtnContactUs = view.findViewById(R.id.ContactUsBtn);
        View.OnClickListener ContactUs = v -> Navigation.findNavController(view).navigate(R.id.action_menu_to_contactus2);
        BtnContactUs.setOnClickListener(ContactUs);

        ImageButton BtnBusBooking = view.findViewById(R.id.BusBookingBtn);
        View.OnClickListener BusBooking = v -> Navigation.findNavController(view).navigate(R.id.action_menu_to_busbooking2);
        BtnBusBooking.setOnClickListener(BusBooking);

        ImageButton BtnNearestBusStop = view.findViewById(R.id.NearestBusStopBtn);
        View.OnClickListener BusStop = v -> Navigation.findNavController(view).navigate(R.id.action_menu_to_listBusStop);
        BtnNearestBusStop.setOnClickListener(BusStop);

        ImageButton BtnNotification = view.findViewById(R.id.NotificationBtn);
        View.OnClickListener Notification = v -> Navigation.findNavController(view).navigate(R.id.action_menu_to_notification);
        BtnNotification.setOnClickListener(Notification);
    }
}