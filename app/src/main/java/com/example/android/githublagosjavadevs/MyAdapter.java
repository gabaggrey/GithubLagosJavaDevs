package com.example.android.githublagosjavadevs;

/**
 * Created by Gabriel Aggrey on 9/16/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<com.example.android.githublagosjavadevs.Users> usersList;

    public MyAdapter(Context context, List<com.example.android.githublagosjavadevs.Users> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(com.example.android.githublagosjavadevs.R.layout.developers_list, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView github_proflile_image;
        private TextView github_username;
        private TextView mUrl;

        public ViewHolder (View v){
            super(v);
            github_proflile_image = (CircleImageView)  itemView.findViewById(com.example.android.githublagosjavadevs.R.id.github_progile_image);
            github_username = (TextView) itemView.findViewById(com.example.android.githublagosjavadevs.R.id.github_username);
            mUrl = (TextView) itemView.findViewById(com.example.android.githublagosjavadevs.R.id.url_link);
        }
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final com.example.android.githublagosjavadevs.Users eachUser = usersList.get(position);

        holder.github_username.setText(eachUser.login);
        Picasso.with(context).load(eachUser.avatar_url).fit().placeholder(com.example.android.githublagosjavadevs.R.drawable.person_dummy).into(holder.github_proflile_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PersonalDetails.class);
                String username = usersList.get(holder.getAdapterPosition()).login;
                String avatar = usersList.get(holder.getAdapterPosition()).avatar_url;
                String url = usersList.get(holder.getAdapterPosition()).html_url;

                intent.putExtra("username", username);
                intent.putExtra("avatar", avatar);
                intent.putExtra("url", url);
                context.startActivity(intent);
            }
        });
    }
}