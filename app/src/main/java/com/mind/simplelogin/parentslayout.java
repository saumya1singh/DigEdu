package com.mind.simplelogin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class parentslayout extends AppCompatActivity {

    CardView cardchat,cardfeedBack,cardPattendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parentslayout);
        cardchat=findViewById(R.id.cardChatpp);
        cardfeedBack=findViewById(R.id.cardFeedback);
        cardPattendance=findViewById(R.id.cardPattendance);

        cardchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getBaseContext(), Chat.class);
                startActivity(intent);

            }
        });
        cardfeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://forms.gle/aydLSXAHgKNDSW5e6";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        cardPattendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),ParentAttendance.class);
                startActivity(intent);

            }
        });
    }
}
