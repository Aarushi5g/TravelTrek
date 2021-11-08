package com.android.traveltrek;

import android.text.style.IconMarginSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BlogPost extends RecyclerView.ViewHolder {
    public TextView title, description, category;
    public ImageView whatsapp;

    public BlogPost(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.username);
        category = itemView.findViewById(R.id.category);
        description = itemView.findViewById(R.id.desc);
        whatsapp = itemView.findViewById(R.id.whatsapp);
    }
}
