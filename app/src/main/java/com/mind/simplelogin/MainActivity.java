package com.mind.simplelogin;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView student,teacher,parents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        student=findViewById(R.id.student);
        student.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, subjectsscreen.class);
                startActivity(intent);

            }
        });

        teacher=findViewById(R.id.teacher);
        teacher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, teacherlayout.class);
                startActivity(intent);

            }
        });


        parents=findViewById(R.id.parents);
        parents.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, parentslayout.class);
                startActivity(intent);

            }
        });


    }
}
