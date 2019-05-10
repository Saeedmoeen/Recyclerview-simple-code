package com.example.recyclerviewhorizontal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ArrayList<String> imageUrl = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        initItem();
    }

    private void initItem() {
        Log.d(TAG, "initItem: preparing bitmaps.");

        imageUrl.add("https://images.unsplash.com/photo-1422393462206-207b0fbd8d6b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        name.add("New York City");

        imageUrl.add("https://images.unsplash.com/photo-1438955138287-0c090d2290d5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        name.add("Paris");

        imageUrl.add("https://images.unsplash.com/photo-1538685634737-24b83e3fa2f8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        name.add("Berlin");

        imageUrl.add("https://images.unsplash.com/photo-1532347922424-c652d9b7208e?ixlib=rb-1.2.1&w=1000&q=80");
        name.add("Summer");

        imageUrl.add("https://images.unsplash.com/photo-1557090495-fc9312e77b28?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        name.add("Flower");
        initRecyClerView();
    }

    private void initRecyClerView() {
        Log.d(TAG, "initRecyClerView: init staggered recyclerView.");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapater recyclerViewAdapater = new RecyclerViewAdapater(this, imageUrl, name);
        recyclerView.setAdapter(recyclerViewAdapater);
        recyclerView.setHasFixedSize(true);
    }
}
