package com.mind.simplelogin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class studentlayout extends AppCompatActivity {
    CardView cardStudy, cardFeedback,cardVedio,cal2, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlayout);
        cardStudy=findViewById(R.id.cardStudyMaterial);
        cardFeedback=findViewById(R.id.cardFeedback);
         cardVedio=findViewById(R.id.cardVedio);
        cal2=findViewById(R.id.cal2);
profile=findViewById(R.id.profile);

profile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getBaseContext(), Profile.class);
        startActivity(intent);
    }
});
        cal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CalendarActivity.class);
                startActivity(intent);
            }
        });

        cardStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getBaseContext(), StudyMaterial.class);
                startActivity(intent);
            }
        });
        cardFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://forms.gle/aydLSXAHgKNDSW5e6";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        cardVedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getBaseContext(), subjectsscreen.class);
                startActivity(intent);
            }
        });
    }
}
