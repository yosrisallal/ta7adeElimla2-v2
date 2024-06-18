package com.sh.alta7addeela3zamfil2imla2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class quiz_rules extends AppCompatActivity {
    int year;
    ImageView background;
    Button next;
    ArrayList<String> strings,strings2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_rules);

        year=getIntent().getIntExtra("year",0);
        background=findViewById(R.id.background);
        next=findViewById(R.id.next);

        strings=new ArrayList<>();
        strings =getIntent().getStringArrayListExtra("strings");

        int MARKS=getIntent().getIntExtra("MARKS",0);

        switch (getIntent().getStringExtra("tolevel")){
            case "one":
                background.setImageResource(R.drawable.editedlevel1);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(quiz_rules.this,level1_Activity.class);
                        intent.putExtra("year",year);
                        intent.putStringArrayListExtra("strings",strings);
                        startActivity(intent);
                        finish();
                    }
                });
                break;

            case "two":
                background.setImageResource(R.drawable.editedlevel2);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(quiz_rules.this,level2_Activity.class);
                        intent.putExtra("MARKS",MARKS);
                        intent.putExtra("year",year);
                        intent.putStringArrayListExtra("strings",strings);
                        startActivity(intent);
                       finish();
                    }
                });

                break;

            case "three":
                background.setImageResource(R.drawable.editedlevel3);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        strings2=new ArrayList<>();
                        strings2 =getIntent().getStringArrayListExtra("strings2");
                        Intent intent=new Intent(quiz_rules.this,level3_Activity.class);
                        intent.putExtra("year",year);
                        intent.putExtra("MARKS",MARKS);
                        intent.putStringArrayListExtra("strings",strings);
                        intent.putStringArrayListExtra("strings2",strings2);
                        startActivity(intent);
                        finish();
                    }
                });

                break;




        }
    }
}