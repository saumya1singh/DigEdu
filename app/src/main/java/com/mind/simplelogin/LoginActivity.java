package com.mind.simplelogin;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btRegister;
    private ImageView circle1;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btRegister  = findViewById(R.id.btRegister);
        tvLogin     = findViewById(R.id.tvLogin);
        circle1     = findViewById(R.id.circle1);

        btRegister.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (v==btRegister){
            Intent a = new Intent(LoginActivity.this, RegisterActivity.class);
            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View,String> (tvLogin,"login");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
            startActivity(a,activityOptions.toBundle());
            Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent1);
        }
    }
}
