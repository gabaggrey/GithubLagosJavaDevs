package com.example.android.githublagosjavadevs;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Gabriel Aggrey on 9/16/2017.
 */

public class PersonalDetails extends AppCompatActivity implements View.OnClickListener{

    ImageView user_bak;
    CircleImageView user_image;
    TextView username, url_link;

    Button user_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.githublagosjavadevs.R.layout.personal_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user_bak = (ImageView) findViewById(com.example.android.githublagosjavadevs.R.id.user_bak);
        user_image = (CircleImageView) findViewById(com.example.android.githublagosjavadevs.R.id.user_image);
        username = (TextView) findViewById(com.example.android.githublagosjavadevs.R.id.username);
        url_link = (TextView) findViewById(com.example.android.githublagosjavadevs.R.id.url_link);
        user_share = (Button) findViewById(com.example.android.githublagosjavadevs.R.id.user_share);

        url_link.setOnClickListener(this);
        user_share.setOnClickListener(this);

        Intent intent = getIntent();
        String mUsername = intent.getStringExtra("username");
        String mUser_image = intent.getStringExtra("avatar");
        String user_url = intent.getStringExtra("url");

        username.setText(mUsername);
        Picasso.with(this).load(mUser_image).fit().placeholder(com.example.android.githublagosjavadevs.R.drawable.person_dummy).into(user_image);
        Picasso.with(this).load(mUser_image).fit().placeholder(com.example.android.githublagosjavadevs.R.drawable.person_dummy).into(user_bak);

        url_link.setText(user_url);
        url_link.setPaintFlags(url_link.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        String title = getIntent().getStringExtra("username");
        setTitle(title +"'s" + " Profile");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case com.example.android.githublagosjavadevs.R.id.url_link:
                String url = getIntent().getStringExtra("url");
                Intent toBrowser = new Intent(Intent.ACTION_VIEW);
                toBrowser.setData(Uri.parse(url));
                startActivity(toBrowser);
                break;

            case com.example.android.githublagosjavadevs.R.id.user_share:
                String share = getIntent().getStringExtra("username");
                String share_url = getIntent().getStringExtra("url");
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"Hey geek, meet this cool dude on Git Hub \n" + "Username: " + share + "\n" + "GitHub Link: " + share_url);
                startActivity(i);
                break;
        }
    }
}
