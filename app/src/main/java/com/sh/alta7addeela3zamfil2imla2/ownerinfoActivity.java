package com.sh.alta7addeela3zamfil2imla2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.sh.alta7addeela3zamfil2imla2.databinding.ActivityOwnerinfoBinding;


public class ownerinfoActivity extends AppCompatActivity {
    ActivityOwnerinfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOwnerinfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        binding.goInside.setOnClickListener(clicked->{startActivity(new Intent(ownerinfoActivity.this,homeActivity.class));finish();});
        if(getResources().getString(R.string.facebook).isEmpty()){
            binding.ownerFacebook.setVisibility(View.GONE);
        }else{
            binding.ownerFacebook.setOnClickListener(clicked->{
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getResources().getString(R.string.facebook)));
                startActivity(intent);
            });
        }
        if(getResources().getString(R.string.youtube).isEmpty()){
            binding.ownerYoutube.setVisibility(View.GONE);
        }else{
            binding.ownerYoutube.setOnClickListener(clicked->{
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getResources().getString(R.string.youtube)));
                startActivity(intent);
            });
        }
        if(getResources().getString(R.string.privacyPolicy).isEmpty()){
            binding.ownerPrivacyPolicy.setVisibility(View.GONE);
        }else{
            binding.ownerPrivacyPolicy.setOnClickListener(clicked->{
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getResources().getString(R.string.privacyPolicy)));
                startActivity(intent);
            });
        }
        if(getResources().getString(R.string.ownerPhone).isEmpty()){
            binding.ownerPhone.setVisibility(View.GONE);
        }
        if(getResources().getString(R.string.ownerTitle).isEmpty()){
            binding.ownerTitle.setVisibility(View.GONE);
        }
        if(getResources().getString(R.string.ownerLocation).isEmpty()){
            binding.ownerLocation.setVisibility(View.GONE);
        }
    }
}