package com.android.traveltrek.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.traveltrek.MainEventsAdapter;
import com.android.traveltrek.R;

import java.util.ArrayList;
import java.util.List;


public class EventsFragment extends Fragment {

    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    MainEventsAdapter mainEventsAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_events, container, false);
        dataList = view.findViewById(R.id.datalist);

        titles = new ArrayList<>();
        images = new ArrayList<>();


        titles.add("Place1");
        titles.add("Place2");
        titles.add("Place3");
        titles.add("Place4");
        titles.add("Place5");
        titles.add("Place6");
        titles.add("Place7");
        titles.add("Place8");
        titles.add("Place9");
        titles.add("Place10");
        titles.add("Place11");
        titles.add("Place12");

        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);
        images.add(R.drawable.sample1);

        mainEventsAdapter = new MainEventsAdapter(getContext(),titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(mainEventsAdapter);

        return view;
    }

}