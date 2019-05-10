package com.example.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Gallery extends AppCompatActivity {
    private static final String TAG = "Gallery";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_item);
        Log.d(TAG, "onCreate: started.");
        getInitIntent();
    }
    
    private void getInitIntent() {
        Log.d(TAG, "getInitIntent: found item");
        if (getIntent().hasExtra("imageUrl") && getIntent().hasExtra("imageName")) {
            String image = getIntent().getStringExtra("imageUrl");
            String name = getIntent().getStringExtra("imageName");

            setItem(image, name);
        }
    }

    private void setItem(String imageUrl, String imageName) {
        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);

        ImageView image = findViewById(R.id.image_url);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
