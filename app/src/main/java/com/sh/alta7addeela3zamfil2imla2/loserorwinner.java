package com.sh.alta7addeela3zamfil2imla2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
public class loserorwinner extends AppCompatActivity {

String checking;
int age ;
TextView title_status,message;
LottieAnimationView lottie_status;
Button return_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loserorwinner);
   checking=getIntent().getStringExtra("check");
   age=getIntent().getIntExtra("year",0);
    title_status=findViewById(R.id.title_status);
    message=findViewById(R.id.tv_status_message);
    return_home=findViewById(R.id.try_Again);
    lottie_status=findViewById(R.id.lottie_status);

    switch(checking){
        case "checked":
            title_status.setText("أنتَ عبقريٌّ في الإملاء ");
            lottie_status.setAnimation(R.raw.success);
            message.setText("المسابقة انتهت .. لكنَّ التَّحدِّي مستمرٌّ");
            break;
        case"unchecked":
            title_status.setVisibility(View.GONE);
            lottie_status.setVisibility(View.GONE);
            message.setVisibility(View.GONE);
            ConstraintLayout mainconstraint=findViewById(R.id.principal);
            mainconstraint.setBackgroundResource(R.drawable.loserconstraint);

            break;

        case "timeout":
            title_status.setText("للأسف .. انتهى الوقت!! ");
            lottie_status.setAnimation(R.raw.timeout);
            message.setText("اهزم الوقت .. ولا تدع الوقت يهزمك في المرَّة القادمة");
            break;


    }
        return_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(loserorwinner.this,QuizInfoActivity.class);
                intent.putExtra("year",age);
                startActivity(intent);
                finish();
            }
        });

    }
}




