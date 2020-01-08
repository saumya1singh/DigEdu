package com.mind.simplelogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class subjectsscreen extends AppCompatActivity {
    ImageView physics, chemistry, maths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjectsscreen);
        physics=findViewById(R.id.physics);
        chemistry=findViewById(R.id.chemistry);
        maths=findViewById(R.id.maths);

        physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subjectsscreen.this, studentlayout.class);
                startActivity(intent);
            }
        });

        chemistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subjectsscreen.this, studentlayout.class);
                startActivity(intent);

            }
        });
        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(subjectsscreen.this, studentlayout.class);
                startActivity(intent);

            }
        });

    }
}
