package com.sh.alta7addeela3zamfil2imla2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuizInfoActivity extends AppCompatActivity {
    int year;
    TextView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_info);

          year=getIntent().getIntExtra("year",0);
          play=findViewById(R.id.play);
          play.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent=new Intent(QuizInfoActivity.this,quiz_rules.class);
                  intent.putExtra("year",year);
                  intent.putExtra("tolevel","one");
                  startActivity(intent);
                  finish();
              }
          });
    }

}

