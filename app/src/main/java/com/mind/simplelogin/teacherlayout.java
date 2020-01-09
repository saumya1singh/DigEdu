package com.mind.simplelogin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class teacherlayout extends AppCompatActivity {
    CardView cardFeedback, cardchat, cardAttendance;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherlayout);
        cardFeedback=findViewById(R.id.cardFeedback);
        cardchat=findViewById(R.id.cardChat);
        cardAttendance=findViewById(R.id.cardAttendance);

        cardFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://forms.gle/aydLSXAHgKNDSW5e6";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        cardchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ChatSelection.class);
                startActivity(intent);

            }
        });
        cardAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getBaseContext(), AttendanceByTeacher.class);
                startActivity(intent);
            }
        });

    }
}
