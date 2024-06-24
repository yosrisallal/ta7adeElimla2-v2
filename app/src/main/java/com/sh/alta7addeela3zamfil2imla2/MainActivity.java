package com.sh.alta7addeela3zamfil2imla2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
public class MainActivity extends AppCompatActivity {
    ImageView i1;
    FirebaseFirestore db;
    StorageReference storageReference;
    Mydatabase sqldb;
    BufferedReader reader;
    InputStreamReader inputStreamReader;
    FileInputStream fileInputStream;
    int firebasenumber;
    int value=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i1=findViewById(R.id.logo);
        Animation a1= AnimationUtils.loadAnimation(this, R.anim.logo_mainactivity);
        a1.setDuration(2000);
        i1.setAnimation(a1);
        sqldb=new Mydatabase(MainActivity.this);
        db=FirebaseFirestore.getInstance();
        isConnectingToInternet(MainActivity.this);
    }

    public void eventchangelistennerAGE12(){

        storageReference= FirebaseStorage.getInstance().getReference("files/12.txt");
        try {
            File txt12=File.createTempFile("txt12",".txt");
            storageReference.getFile(txt12).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(@NonNull FileDownloadTask.TaskSnapshot taskSnapshot) {
                    try {
                        fileInputStream=new FileInputStream(txt12);
                        inputStreamReader=new InputStreamReader(fileInputStream);
                        reader=new BufferedReader(inputStreamReader);
                        setdata(12);
                    }  catch (Exception e) {
                        Toast.makeText(MainActivity.this, "check your internet connection", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                }
            });


        } catch (IOException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
    public void eventchangelistennerAGE13(){

        storageReference= FirebaseStorage.getInstance().getReference("files/13.txt");
        try {
            File txt13=File.createTempFile("txt13",".txt");
            storageReference.getFile(txt13).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(@NonNull FileDownloadTask.TaskSnapshot taskSnapshot) {
                    try {
                        fileInputStream=new FileInputStream(txt13);
                        inputStreamReader=new InputStreamReader(fileInputStream);
                        reader=new BufferedReader(inputStreamReader);
                        setdata(13);
                    }  catch (Exception e) {
                        Toast.makeText(MainActivity.this, "check your internet connection", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                }
            });


        } catch (IOException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
    public void eventchangelistennerAGE14(){

        storageReference= FirebaseStorage.getInstance().getReference("files/14.txt");
        try {
            File txt14=File.createTempFile("txt14",".txt");
            storageReference.getFile(txt14).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(@NonNull FileDownloadTask.TaskSnapshot taskSnapshot) {
                    try {
                        fileInputStream=new FileInputStream(txt14);
                        inputStreamReader=new InputStreamReader(fileInputStream);
                        reader=new BufferedReader(inputStreamReader);
                        setdata(14);

                    }  catch (Exception e) {
                        Toast.makeText(MainActivity.this, "check your internet connection", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                }
            });


        } catch (IOException e) {

        }


    }
    public void eventchangelistennerAGE15(){

        storageReference= FirebaseStorage.getInstance().getReference("files/15.txt");
        try {
            File txt15=File.createTempFile("txt15",".txt");
            storageReference.getFile(txt15).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(@NonNull FileDownloadTask.TaskSnapshot taskSnapshot) {
                    try {
                        fileInputStream=new FileInputStream(txt15);
                        inputStreamReader=new InputStreamReader(fileInputStream);
                        reader=new BufferedReader(inputStreamReader);
                        setdata(15);

                    }  catch (Exception e) {
                        Toast.makeText(MainActivity.this, "check your internet connection", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                }
            });


        } catch (IOException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
    public void eventchangelistennerAGE16(){

        storageReference= FirebaseStorage.getInstance().getReference("files/16.txt");
        try {
            File txt16=File.createTempFile("txt16",".txt");
            storageReference.getFile(txt16).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(@NonNull FileDownloadTask.TaskSnapshot taskSnapshot) {
                    try {
                        fileInputStream=new FileInputStream(txt16);
                        inputStreamReader=new InputStreamReader(fileInputStream);
                        reader=new BufferedReader(inputStreamReader);
                        setdata(16);

                    }  catch (Exception e) {
                        Toast.makeText(MainActivity.this, "check your internet connection", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                }
            });


        } catch (IOException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
    public void eventchangelistennerAGE17(){

        storageReference= FirebaseStorage.getInstance().getReference("files/17.txt");
        try {
            File txt17=File.createTempFile("txt17",".txt");
            storageReference.getFile(txt17).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(@NonNull FileDownloadTask.TaskSnapshot taskSnapshot) {
                    try {
                        fileInputStream=new FileInputStream(txt17);
                        inputStreamReader=new InputStreamReader(fileInputStream);
                        reader=new BufferedReader(inputStreamReader);
                        setdata(17);

                    }  catch (Exception e) {
                        Toast.makeText(MainActivity.this, "check your internet connection", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                }
            });


        } catch (IOException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }
    public void eventchangelistennerAGE18(){

        storageReference= FirebaseStorage.getInstance().getReference("files/18.txt");
        try {
            File txt18=File.createTempFile("txt18",".txt");
            storageReference.getFile(txt18).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(@NonNull FileDownloadTask.TaskSnapshot taskSnapshot) {
                    try {
                        fileInputStream=new FileInputStream(txt18);
                        inputStreamReader=new InputStreamReader(fileInputStream);
                        reader=new BufferedReader(inputStreamReader);
                        setdata(18);

                    }  catch (Exception e) {
                        Toast.makeText(MainActivity.this, "check your internet connection", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                }
            });


        } catch (IOException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }
    public void eventchangelistennerAGE19(){

        storageReference= FirebaseStorage.getInstance().getReference("files/19.txt");
        try {
            File txt19=File.createTempFile("txt19",".txt");
            storageReference.getFile(txt19).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(@NonNull FileDownloadTask.TaskSnapshot taskSnapshot) {
                    try {
                        fileInputStream=new FileInputStream(txt19);
                        inputStreamReader=new InputStreamReader(fileInputStream);
                        reader=new BufferedReader(inputStreamReader);
                        setdata(19);

                    }  catch (Exception e) {
                        Toast.makeText(MainActivity.this, "check your internet connection", Toast.LENGTH_SHORT).show();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                }
            });


        } catch (IOException e) {

        }


    }
    public void setdata( int agerequired){
        String numbers;
        int number;
        String question,leson,right,false1,lamp,false2,false3;
        try {
            if((  numbers= reader.readLine())!=null){


                do {
                    number =Integer.parseInt(numbers);
                    question=reader.readLine();
                    leson=reader.readLine();
                    right = reader.readLine();
                    false1=null;
                    false2=null;
                    false3=null;
                    lamp=null;
                    if(number==2){

                        false1= reader.readLine();
                        false2=null;
                        false3=null;
                        lamp=null;
                    }
                    if(number==22){
                         false1= reader.readLine();
                        false2=null;
                        false3=null;
                         lamp= reader.readLine();

                    }
                    if(number==3){
                        false1= reader.readLine();
                        false2= reader.readLine();
                        false3=null;
                        lamp=null;
                    }
                    if(number==32){
                       false1= reader.readLine();
                       false2= reader.readLine();
                       false3=null;
                       lamp= reader.readLine();

                    }
                    if(number==4){
                        false1= reader.readLine();
                        false2= reader.readLine();
                        false3= reader.readLine();
                        lamp=null;
                    }
                    if(number==42){
                         false1= reader.readLine();
                         false2= reader.readLine();
                         false3= reader.readLine();
                         lamp= reader.readLine();
                    }
                    String space= reader.readLine();


sqldb.insertquestionform(new questionform(false1,false2,false3,lamp,leson,question,right,agerequired,number));
                }while( (numbers= reader.readLine()) != null);


if (agerequired==19){
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent =new Intent (MainActivity.this,homeActivity.class);
            intent.putExtra("internet connection","yes");
            startActivity(intent);
            finish();
        }
    },15000);

}

            }
        }catch (Exception e){


                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

        }


    }

    private void isConnectingToInternet(Context applicationContext) {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if (ni == null) {

            if(sqldb.getquestionscount()>0){
                // There are no active networks.

                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent =new Intent (MainActivity.this,homeActivity.class);
                        intent.putExtra("internet connection","no");
                        startActivity(intent);
                        finish();
                    }
                },15000);}
            else{
                Toast.makeText(MainActivity.this, "exit the app and access network for on time to get data from server", Toast.LENGTH_LONG).show();
            }

        } else {

            value=0;
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("number");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    value = dataSnapshot.getValue(Integer.class);
                    Log.d("TAG", "Value is: " + value);

                    if(value>0){
                        sqldb.deleteallquestions();
                        eventchangelistennerAGE12();

                        eventchangelistennerAGE13();

                        eventchangelistennerAGE14();

                        eventchangelistennerAGE15();

                        eventchangelistennerAGE16();

                        eventchangelistennerAGE17();

                        eventchangelistennerAGE18();

                        eventchangelistennerAGE19();

                    }else{
                        if((sqldb.getquestionscount())>0){
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent =new Intent (MainActivity.this,homeActivity.class);
                                    intent.putExtra("internet connection","yes");
                                    startActivity(intent);
                                    finish();
                                }
                            },10000);
                        }
                    }

                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("TAG", "Failed to read value.", error.toException());
                }
            });

            if((sqldb.getquestionscount())==0) {
                sqldb.deleteallquestions();
                eventchangelistennerAGE12();

                eventchangelistennerAGE13();

                eventchangelistennerAGE14();

                eventchangelistennerAGE15();

                eventchangelistennerAGE16();

                eventchangelistennerAGE17();

                eventchangelistennerAGE18();

                eventchangelistennerAGE19();

            }
//put number in firebase for update the questions



        }
    }

}