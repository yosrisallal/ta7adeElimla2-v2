package com.sh.alta7addeela3zamfil2imla2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class level1_Activity extends AppCompatActivity {
    CardView time_clock_card,exit;
    Animation time_anim,reponse1_animation,reponse2_animation,reponse3_animation,reponse4_animation;
    TextView reponse1,reponse2,reponse3,reponse4,CLOCK,Question_number_tv,MARK_tv,Question_tv;
    int MARKS,age,qnum,onbackpressed;
    ArrayList<questionform>Questions;
    LinearLayout replace_question;
//test
    ArrayList<String>strings;
    private CountDownTimer countDownTimer;
    private static final long START_TIME_IN_MILLIS=300000;
    private long TIME_LEFT_IN_MILLIS=START_TIME_IN_MILLIS;
    Mydatabase mydatabase;

    //get question variables
    int HIGH,high,low,LOW,random_integer,random_integer1;
    questionform q1;
    ArrayList<String> ANSWERS;
    LottieAnimationView lamp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        age=getIntent().getIntExtra("year",0);
        //initializing
        time_clock_card=findViewById(R.id.time_clock_card);
        reponse1=findViewById(R.id.reponse1);
        reponse2=findViewById(R.id.reponse2);
        reponse3=findViewById(R.id.reponse3);
        reponse4=findViewById(R.id.reponse4);
        CLOCK=findViewById(R.id.clock);
        Questions=new ArrayList<>();
        mydatabase=new Mydatabase(this);
        lamp=findViewById(R.id.lamp);
        MARK_tv=findViewById(R.id.MARK);
        Question_number_tv=findViewById(R.id.qnum);
        Question_tv=findViewById(R.id.question);
        replace_question=findViewById(R.id.raplace_question);
        exit=findViewById(R.id.exit);
        strings=new ArrayList<>();

        //reponse1 animation
        reponse1_animation=AnimationUtils.loadAnimation(this,R.anim.reponse1_animation);
        reponse1_animation.setDuration(2000);
        reponse1.setAnimation(reponse1_animation);

        //reponse2 Animation
        reponse2_animation=AnimationUtils.loadAnimation(this,R.anim.reponse2_animation);
        reponse2_animation.setDuration(2000);
        reponse2.setAnimation(reponse2_animation);

        //reponse3 Animation
        reponse3_animation=AnimationUtils.loadAnimation(this,R.anim.reponse3_animation);
        reponse3_animation.setDuration(2000);
        reponse3.setAnimation(reponse3_animation);

        //reponse4 Animation
        reponse4_animation=AnimationUtils.loadAnimation(this,R.anim.reponse3_animation);
        reponse4_animation.setDuration(2000);
        reponse4.setAnimation(reponse4_animation);
        //clock Animation
        time_anim= AnimationUtils.loadAnimation(this,R.anim.time);
        time_anim.setDuration(2000);
        time_clock_card.setAnimation(time_anim);

        //set Questions to Arraylist needed for the age
        if(age>0){
        Questions= mydatabase.getquestionwhereageequalto(age);
        switch (age) {
            case 13:
                Questions.addAll(mydatabase.getquestionwhereageequalto(12));
                break;
            case 14:
                Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                break;
            case 15:
                Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                Questions.addAll(mydatabase.getquestionwhereageequalto(14));
                break;
            case 16:
                Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                Questions.addAll(mydatabase.getquestionwhereageequalto(14));
                Questions.addAll(mydatabase.getquestionwhereageequalto(15));
                break;
            case 17:
                Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                Questions.addAll(mydatabase.getquestionwhereageequalto(14));
                Questions.addAll(mydatabase.getquestionwhereageequalto(15));
                Questions.addAll(mydatabase.getquestionwhereageequalto(16));
                break;
            case 18:
                Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                Questions.addAll(mydatabase.getquestionwhereageequalto(14));
                Questions.addAll(mydatabase.getquestionwhereageequalto(15));
                Questions.addAll(mydatabase.getquestionwhereageequalto(16));
                Questions.addAll(mydatabase.getquestionwhereageequalto(17));
                break;
            case 19:
                Questions.addAll(mydatabase.getquestionwhereageequalto(13));
                Questions.addAll(mydatabase.getquestionwhereageequalto(14));
                Questions.addAll(mydatabase.getquestionwhereageequalto(15));
                Questions.addAll(mydatabase.getquestionwhereageequalto(16));
                Questions.addAll(mydatabase.getquestionwhereageequalto(17));
                Questions.addAll(mydatabase.getquestionwhereageequalto(18));
                break;
        }
        }


//make the clock
Thread clock_thread=new Thread(new Runnable() {
    @Override
    public void run() {

        countDownTimer=new CountDownTimer(TIME_LEFT_IN_MILLIS,1000) {
            @Override
            public void onTick(long l) {
                TIME_LEFT_IN_MILLIS=l;
                int minutes=(int)(TIME_LEFT_IN_MILLIS/1000)/60;
                int secondes=(int)(TIME_LEFT_IN_MILLIS/1000)%60;
                String time_left=String.format(Locale.getDefault(),"%02d:%02d",minutes,secondes);
                CLOCK.setText(time_left);
            }

            @Override
            public void onFinish() {
               Intent intent =new Intent(level1_Activity.this,loserorwinner.class);
                intent.putExtra("check","timeout");
                intent.putExtra("year",age);
                startActivity(intent);
                finish();
            }
        }.start();
    }
});
// run the clock
clock_thread.run();




//run the level
if((Questions.size())>0){
    getquestion();
}



        reponse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((reponse1.getText().toString()).equals(q1.getRight())){
                    MARKS++;
                    MARK_tv.setText(MARKS+"");
                    Toast.makeText(level1_Activity.this, "الجواب صحيح", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(level1_Activity.this, "الجواب خاطئ", Toast.LENGTH_SHORT).show();
                }
              Dialog  dialog=new Dialog(level1_Activity.this);
                dialog.setContentView(R.layout.customdialog);
                Button close_dialog=dialog.findViewById(R.id.canceldialog);
                close_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //get the next question
                        if(qnum<10){
                            getquestion();
                            dialog.dismiss();
                        }
                        //case completing questions and winning this level
                        else if (MARKS>=8){
                            Intent intent=new Intent(level1_Activity.this, quiz_rules.class);
                            intent.putExtra("year",age);
                            intent.putExtra("MARKS",MARKS);
                            intent.putExtra("tolevel","two");
                            intent.putStringArrayListExtra("strings",strings);
                            countDownTimer.cancel();
                            dialog.dismiss();
                            startActivity(intent);
                            finish();
                        }

                       //case losing the challenge
                        else{ Intent intent=new Intent(level1_Activity.this, loserorwinner.class);
                            intent.putExtra("check","unchecked");
                            intent.putExtra("year",age);
                            dialog.dismiss();
                            countDownTimer.cancel();
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                TextView dialog_title=dialog.findViewById(R.id.titled);
                TextView dialog_description=dialog.findViewById(R.id.description);
                dialog_title.setText("الدّرس المستفاد ");
                dialog_description.setText(q1.getLeson());
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
                dialog.show();

            }
        });
        reponse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((reponse2.getText().toString()).equals(q1.getRight())){
                    MARKS++;
                    MARK_tv.setText(MARKS+"");
                    Toast.makeText(level1_Activity.this, "الجواب صحيح", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(level1_Activity.this, "الجواب خاطئ", Toast.LENGTH_SHORT).show();
                }
                Dialog  dialog=new Dialog(level1_Activity.this);
                dialog.setContentView(R.layout.customdialog);
                Button close_dialog=dialog.findViewById(R.id.canceldialog);
                close_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //get the next question
                        if(qnum<10){
                            getquestion();
                            dialog.dismiss();
                        }
                        //case completing questions and winning this level
                        else if (MARKS>=8){
                            Intent intent=new Intent(level1_Activity.this, quiz_rules.class);
                            intent.putExtra("year",age);
                            intent.putExtra("MARKS",MARKS);
                            intent.putExtra("tolevel","two");
                            intent.putStringArrayListExtra("strings",strings);
                            countDownTimer.cancel();
                            dialog.dismiss();
                            startActivity(intent);
                            finish();
                        }

                        //case losing the challenge
                        else{ Intent intent=new Intent(level1_Activity.this, loserorwinner.class);
                            intent.putExtra("check","unchecked");
                            intent.putExtra("year",age);
                            dialog.dismiss();
                            countDownTimer.cancel();
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                TextView dialog_title=dialog.findViewById(R.id.titled);
                TextView dialog_description=dialog.findViewById(R.id.description);
                dialog_title.setText("الدّرس المستفاد ");
                dialog_description.setText(q1.getLeson());
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
                dialog.show();

            }
        });
        reponse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((reponse3.getText().toString()).equals(q1.getRight())){
                    MARKS++;
                    MARK_tv.setText(MARKS+"");
                    Toast.makeText(level1_Activity.this, "الجواب صحيح", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(level1_Activity.this, "الجواب خاطئ", Toast.LENGTH_SHORT).show();
                }
                Dialog  dialog=new Dialog(level1_Activity.this);
                dialog.setContentView(R.layout.customdialog);
                Button close_dialog=dialog.findViewById(R.id.canceldialog);
                close_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //get the next question
                        if(qnum<10){
                            getquestion();
                            dialog.dismiss();
                        }
                        //case completing questions and winning this level
                        else if (MARKS>=8){
                            Intent intent=new Intent(level1_Activity.this, quiz_rules.class);
                            intent.putExtra("year",age);
                            intent.putExtra("MARKS",MARKS);
                            intent.putExtra("tolevel","two");
                            intent.putStringArrayListExtra("strings",strings);
                            countDownTimer.cancel();
                            dialog.dismiss();
                            startActivity(intent);
                            finish();
                        }

                        //case losing the challenge
                        else{ Intent intent=new Intent(level1_Activity.this, loserorwinner.class);
                            intent.putExtra("check","unchecked");
                            intent.putExtra("year",age);
                            dialog.dismiss();
                            countDownTimer.cancel();
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                TextView dialog_title=dialog.findViewById(R.id.titled);
                TextView dialog_description=dialog.findViewById(R.id.description);
                dialog_title.setText("الدّرس المستفاد ");
                dialog_description.setText(q1.getLeson());
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
                dialog.show();

            }
        });
        reponse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((reponse4.getText().toString()).equals(q1.getRight())){
                    MARKS++;
                    MARK_tv.setText(MARKS+"");
                    Toast.makeText(level1_Activity.this, "الجواب صحيح", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(level1_Activity.this, "الجواب خاطئ", Toast.LENGTH_SHORT).show();
                }
                Dialog  dialog=new Dialog(level1_Activity.this);
                dialog.setContentView(R.layout.customdialog);
                Button close_dialog=dialog.findViewById(R.id.canceldialog);
                close_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //get the next question
                        if(qnum<10){
                            getquestion();
                            dialog.dismiss();
                        }
                        //case completing questions and winning this level
                        else if (MARKS>=8){
                            Intent intent=new Intent(level1_Activity.this, quiz_rules.class);
                            intent.putExtra("year",age);
                            intent.putExtra("MARKS",MARKS);
                            intent.putExtra("tolevel","two");
                            intent.putStringArrayListExtra("strings",strings);
                            countDownTimer.cancel();
                            dialog.dismiss();
                            startActivity(intent);
                            finish();
                        }

                        //case losing the challenge
                        else{ Intent intent=new Intent(level1_Activity.this, loserorwinner.class);
                            intent.putExtra("check","unchecked");
                            intent.putExtra("year",age);
                            dialog.dismiss();
                            countDownTimer.cancel();
                            startActivity(intent);
                            finish();
                        }
                    }
                });
                TextView dialog_title=dialog.findViewById(R.id.titled);
                TextView dialog_description=dialog.findViewById(R.id.description);
                dialog_title.setText("الدّرس المستفاد ");
                dialog_description.setText(q1.getLeson());
                dialog.setCancelable(false);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
                dialog.show();

            }
        });
        lamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Dialog dialog =new Dialog (level1_Activity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.lamp_dialog);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
        TextView lamp_txt=dialog.findViewById(R.id.lamp_txt);
        Button cancel_dialog=dialog.findViewById(R.id.cancellamp);
        lamp_txt.setText(q1.getLamp());
        cancel_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
             dialog.show();
            } });
        replace_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qnum--;
                getquestion();
                MARKS--;
                replace_question.setVisibility(View.INVISIBLE);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(level1_Activity.this,QuizInfoActivity.class);
                intent.putExtra("year",age);
                Toast.makeText(level1_Activity.this, "لقد خرجت من التّحدّي ", Toast.LENGTH_SHORT).show();
                countDownTimer.cancel();
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
      /*  if(onbackpressed==1){
        Intent intent=new Intent(level1_Activity.this,QuizInfoActivity.class);
        intent.putExtra("year",age);
        countDownTimer.cancel();
        startActivity(intent);
        finish();
        }else{onbackpressed++;}*/
    }


    //get question
    public void getquestion(){




     //initialize variable
     low=0;
     LOW=0;
     HIGH=Questions.size();
     Random rand = new Random();
     random_integer=rand.nextInt(HIGH-LOW)+LOW;
     q1= Questions.get(random_integer);
        Log.d("tag",q1.getRight());
     Questions.remove(q1);
     Question_tv.setText(q1.getQuestion());
     ANSWERS=new ArrayList<>();
     strings.add(q1.getRight());
     switch(q1.getNumber()){

         case 2:
             ANSWERS.add(q1.getRight());
             ANSWERS.add(q1.getFalse1());
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse1.setText(ANSWERS.get(random_integer1));
             ANSWERS.remove(random_integer1);
             reponse2.setText(ANSWERS.get(0));
             ANSWERS.remove(0);
             reponse1.setVisibility(View.VISIBLE);
             reponse2.setVisibility(View.VISIBLE);
             reponse3.setVisibility(View.INVISIBLE);
             reponse4.setVisibility(View.INVISIBLE);
             lamp.setVisibility(View.INVISIBLE);
         break;

         case 22:
             ANSWERS.add(q1.getRight());
             ANSWERS.add(q1.getFalse1());
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse1.setText(ANSWERS.get(random_integer1));
             reponse2.setText(ANSWERS.get(0));
             reponse1.setVisibility(View.VISIBLE);
             reponse2.setVisibility(View.VISIBLE);
             reponse3.setVisibility(View.INVISIBLE);
             reponse4.setVisibility(View.INVISIBLE);
             lamp.setVisibility(View.VISIBLE);
         break;

         case 3:
             ANSWERS.add(q1.getRight());
             ANSWERS.add(q1.getFalse1());
             ANSWERS.add(q1.getFalse2());
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse1.setText(ANSWERS.get(random_integer1));
             ANSWERS.remove(random_integer1);
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse2.setText(ANSWERS.get(random_integer1));
             ANSWERS.remove(random_integer1);
             reponse3.setText(ANSWERS.get(0));
             reponse1.setVisibility(View.VISIBLE);
             reponse2.setVisibility(View.VISIBLE);
             reponse3.setVisibility(View.VISIBLE);
             reponse4.setVisibility(View.INVISIBLE);
             lamp.setVisibility(View.INVISIBLE);
         break;

         case 32:
             ANSWERS.add(q1.getRight());
             ANSWERS.add(q1.getFalse1());
             ANSWERS.add(q1.getFalse2());
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse1.setText(ANSWERS.get(random_integer1));
             ANSWERS.remove(random_integer1);
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse2.setText(ANSWERS.get(random_integer1));
             ANSWERS.remove(random_integer1);
             reponse3.setText(ANSWERS.get(0));
             reponse1.setVisibility(View.VISIBLE);
             reponse2.setVisibility(View.VISIBLE);
             reponse3.setVisibility(View.VISIBLE);
             reponse4.setVisibility(View.INVISIBLE);
             lamp.setVisibility(View.VISIBLE);
         break;

         case 4:
             ANSWERS.add(q1.getRight());
             ANSWERS.add(q1.getFalse1());
             ANSWERS.add(q1.getFalse2());
             ANSWERS.add(q1.getFalse3());
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse1.setText(ANSWERS.get(random_integer1));
             ANSWERS.remove(random_integer1);
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse2.setText(ANSWERS.get(random_integer1));
             ANSWERS.remove(random_integer1);
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse3.setText(ANSWERS.get(random_integer1));
             reponse4.setText(ANSWERS.get(0));
             reponse1.setVisibility(View.VISIBLE);
             reponse2.setVisibility(View.VISIBLE);
             reponse3.setVisibility(View.VISIBLE);
             reponse4.setVisibility(View.VISIBLE);
             lamp.setVisibility(View.INVISIBLE);
         break;

         case 42:
             ANSWERS.add(q1.getRight());
             ANSWERS.add(q1.getFalse1());
             ANSWERS.add(q1.getFalse2());
             ANSWERS.add(q1.getFalse3());
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse1.setText(ANSWERS.get(random_integer1));
             ANSWERS.remove(random_integer1);
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse2.setText(ANSWERS.get(random_integer1));
             ANSWERS.remove(random_integer1);
             high=ANSWERS.size();
             random_integer1= rand.nextInt((high-low)+low);
             reponse3.setText(ANSWERS.get(random_integer1));
             reponse4.setText(ANSWERS.get(0));
             reponse1.setVisibility(View.VISIBLE);
             reponse2.setVisibility(View.VISIBLE);
             reponse3.setVisibility(View.VISIBLE);
             reponse4.setVisibility(View.VISIBLE);
             lamp.setVisibility(View.VISIBLE);
         break;


     }
     qnum++;
     Question_number_tv.setText(qnum+"/10");

    }
}


