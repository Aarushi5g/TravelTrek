package com.android.traveltrek.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.traveltrek.R;
import com.android.traveltrek.databinding.FragmentEventsBinding;

import java.util.ArrayList;
import java.util.List;


public class EventsFragment extends Fragment {

    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    Adapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_events, container, false);
        dataList = view.findViewById(R.id.datalist);

        titles = new ArrayList<>();
        images = new ArrayList<>();


        titles.add("Event 1");
        titles.add("Event 2");
        titles.add("Event 3");
        titles.add("Event 4");
        titles.add("Event 5");
        titles.add("Event 6");
        titles.add("Event 7");
        titles.add("Event 8");
        titles.add("Event 9");
        titles.add("Event 10");
        titles.add("Event 11");
        titles.add("Event 12");

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

        adapter = new Adapter(getContext(),titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);

        return view;
    }

}