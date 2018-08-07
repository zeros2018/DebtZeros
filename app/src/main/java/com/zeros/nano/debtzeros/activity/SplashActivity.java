package com.zeros.nano.debtzeros.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zeros.nano.debtzeros.R;

public class SplashActivity extends BaseAppCompatNoDrawerActivity {


    Runnable splashTask = new Runnable() {
        @Override
        public void run() {
            navigate();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getData();
    }

    // Revisa e iniciliza los datos, luego lanza
    private void getData(){
        new Handler().postAtTime( splashTask,5000);
    }


    private void navigate() {
         startActivity(new Intent(SplashActivity.this, LoginActivity.class));
         finish();
    }
}
