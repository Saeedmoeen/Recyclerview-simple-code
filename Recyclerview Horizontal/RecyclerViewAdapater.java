package com.example.recyclerviewhorizontal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapater extends RecyclerView.Adapter<RecyclerViewAdapater.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapater";

    private ArrayList<String> imageUrl = new ArrayList<>();
    private ArrayList<String> imageName = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapater(Context context, ArrayList<String> imageUrl, ArrayList<String> imageName) {
        this.imageUrl = imageUrl;
        this.imageName = imageName;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onCreateViewHolder: called.");
        Glide.with(context)
                .asBitmap()
                .load(imageUrl.get(i))
                .into(viewHolder.image_url);
        viewHolder.image_name.setText(imageName.get(i));

        viewHolder.image_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on image " + imageName.get(i));
                Toast.makeText(context, imageName.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView image_name;
        ImageView image_url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_name = itemView.findViewById(R.id.image_name);
            image_url = itemView.findViewById(R.id.image_url);
        }
    }
}
