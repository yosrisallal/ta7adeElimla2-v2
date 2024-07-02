package com.sh.alta7addeela3zamfil2imla2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class homeActivity extends AppCompatActivity {
    TextView year13,year14,year15,year16,year17,year18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        year13=findViewById(R.id.year13);
        year14=findViewById(R.id.year14);
        year15=findViewById(R.id.year15);
        year16=findViewById(R.id.year16);
        year17=findViewById(R.id.year17);
        year18=findViewById(R.id.year18);

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
    }
}






