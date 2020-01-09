package com.mind.simplelogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

public class subjectsscreen extends AppCompatActivity {
    CardView cardPhysics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjectsscreen);
        cardPhysics=findViewById(R.id.cardPhysics);
        cardPhysics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), VedioActivity.class);
                startActivity(intent);
            }
        });
    }
}
