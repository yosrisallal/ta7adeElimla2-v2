package com.sh.alta7addeela3zamfil2imla2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class homeActivity extends AppCompatActivity {
    ImageView offline_online;
    TextView year12,year13,year14,year15,year16,year17,year18,year19,youtube,website,facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        offline_online=findViewById(R.id.online_or_offline);
        year12=findViewById(R.id.year12);
        year13=findViewById(R.id.year13);
        year14=findViewById(R.id.year14);
        year15=findViewById(R.id.year15);
        year16=findViewById(R.id.year16);
        year17=findViewById(R.id.year17);
        year18=findViewById(R.id.year18);
        year19=findViewById(R.id.year19);
        youtube=findViewById(R.id.youtube);
        facebook=findViewById(R.id.facebook);
        website=findViewById(R.id.website);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCI6iERAueVFkEhrOKStFDNA"));
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/nhwdotcom"));
                startActivity(intent);
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.alnahw.com/"));
                startActivity(intent);
            }
        });
        year12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",12);
                startActivity(intent);
            }
        });
        year13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",13);
                startActivity(intent);
            }
        });
        year14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",14);
                startActivity(intent);
            }
        });

        year15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",15);
                startActivity(intent);
            }
        });
        year16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",16);
                startActivity(intent);
            }
        });
        year17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",17);
                startActivity(intent);
            }
        });
        year18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",18);
                startActivity(intent);
            }
        });
        year19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homeActivity.this,QuizInfoActivity.class);
                intent.putExtra("year",19);
                startActivity(intent);
            }
        });


        switch ((getIntent().getStringExtra("internet connection"))){
                case "no":
                offline_online.setImageResource(R.drawable.offline);
                    break;
                case "yes":
                offline_online.setImageResource(R.drawable.online);
                    break;
            }
    }
}






