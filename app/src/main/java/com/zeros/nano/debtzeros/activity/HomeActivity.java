package com.zeros.nano.debtzeros.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.zeros.nano.debtzeros.R;

public class HomeActivity extends AppCompatActivity {

    private TextView mStatus;
    private TextView mDetailStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        if (FirebaseAuth.getInstance()!= null && FirebaseAuth.getInstance().getCurrentUser()!= null){
            mStatus.setText(getString(R.string.status_fmt) + FirebaseAuth.getInstance().getCurrentUser().getEmail().toString());
            mDetailStatus.setText(getString(R.string.status_firebase_fmt) + FirebaseAuth.getInstance().getCurrentUser().getUid());
        }

        Button btn_log_out = findViewById(R.id.btn_sign_out);
        btn_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FirebaseAuth.getInstance()!= null && FirebaseAuth.getInstance().getCurrentUser()!= null)
                    FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void initView(){
        mStatus = findViewById(R.id.txv_status);
        mDetailStatus = findViewById(R.id.txv_status_detail);
    }
}
