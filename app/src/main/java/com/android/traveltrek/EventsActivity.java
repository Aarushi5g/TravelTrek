package com.android.traveltrek;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity implements EventsAdapter.ItemClickListener {

    EventsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        // data to populate the RecyclerView with
        ArrayList<String> eventNames = new ArrayList<>();
        eventNames.add("Event Name1");
        eventNames.add("Event Name2");
        eventNames.add("Event Name3");
        eventNames.add("Event Name4");
        eventNames.add("Event Name5");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.events);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EventsAdapter(this, eventNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}