package com.android.traveltrek;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BlogRecyclerAdapter extends RecyclerView.Adapter<BlogPost> {

    private Context context;
    private List<MyBlog> blog_list;

    public BlogRecyclerAdapter(Context context, List<MyBlog> blog_list) {
        this.context = context;
        this.blog_list = blog_list;
    }

    @NonNull
    @Override
    public BlogPost onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BlogPost(LayoutInflater.from(context).inflate(R.layout.blog_post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BlogPost holder, int position) {
       holder.title.setText(blog_list.get(position).getTitle());
       holder.location.setText(blog_list.get(position).getLocation());
       holder.description.setText(blog_list.get(position).getDesc());
       Picasso.get().load(blog_list.get(position).getImageURL()).into(holder.imageURL);

       holder.whatsapp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               try {
                   Intent whatsappShare = new Intent(Intent.ACTION_SEND);
                   whatsappShare.setType("text/plane");
                   whatsappShare.setPackage("com.whatsapp");
                   whatsappShare.putExtra(Intent.EXTRA_TEXT,"This new post has uploaded on TravelTrek with title: "+blog_list.get(position).getTitle()+", location: "+blog_list.get(position).getLocation()+", Caption: "+blog_list.get(position).getDesc());
                   context.startActivity(whatsappShare);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       });
    }

    @Override
    public int getItemCount() {
        return blog_list.size();
    }
}
