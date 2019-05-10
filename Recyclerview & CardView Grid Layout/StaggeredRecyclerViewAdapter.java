package com.example.recyclerview_cardview;

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
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class StaggeredRecyclerViewAdapter extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "StaggeredRecyclerViewAd";

    private ArrayList<String> imageName = new ArrayList<>();
    private ArrayList<String> imageUrl = new ArrayList<>();
    private Context context;

    public StaggeredRecyclerViewAdapter(Context context, ArrayList<String> imageName, ArrayList<String> imageUrl) {
        this.imageName = imageName;
        this.imageUrl = imageUrl;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called.");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(context)
                .load(imageUrl.get(i))
                .apply(requestOptions)
                .into(viewHolder.image);

        viewHolder.imageName.setText(imageName.get(i));

        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on " + imageName.get(i));
                Toast.makeText(context, imageName.get(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageUrl.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView imageName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageName = itemView.findViewById(R.id.card_name);
            image = itemView.findViewById(R.id.card_image);
        }

/*        public ViewHolder(@NonNull View itemView, ImageView imageUrl, TextView imageName) {
            super(itemView);
            this.imageUrl = imageUrl;
            this.imageName = imageName;
        }*/

    }
}
