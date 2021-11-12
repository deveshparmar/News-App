package com.codewithdevesh.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    String title,desc,content,imageURL,url;
    private TextView tv_title,tv_desc,tv_content;
    private ImageView img_news;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        desc = getIntent().getStringExtra("desc");
        imageURL = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");
        tv_title = findViewById(R.id.title_news_detail);
        tv_desc = findViewById(R.id.desc);
        bt = findViewById(R.id.bttn_read_news);
        tv_content = findViewById(R.id.content_news_detail);
        img_news = findViewById(R.id.img_news_detail);
        tv_title.setText(title);
        tv_content.setText(content);
        tv_desc.setText(desc);
        Picasso.get().load(imageURL).into(img_news);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}