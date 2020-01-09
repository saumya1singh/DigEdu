package com.mind.simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ChatSelection extends AppCompatActivity {
    Spinner spinCLass, spinSec;
    EditText etRollno;
    Button btnSubmit;
    String sclass, sec, rollno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_selection);
        spinCLass=findViewById(R.id.spinClass);
        spinSec=findViewById(R.id.spinSec);
        etRollno=findViewById(R.id.etRoll);
        btnSubmit=findViewById(R.id.btnsubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sclass=spinCLass.getSelectedItem().toString();
                sec=spinSec.getSelectedItem().toString();
                rollno=etRollno.getText().toString();
                if(check())
                {
                    Intent intent = new Intent(getBaseContext(),Chat.class);
                    startActivity(intent);

                }
            }
        });

    }

    private boolean check() {
        Boolean check =true;
        if(TextUtils.isEmpty(rollno))
        {
            etRollno.setError("Required");
            check=false;
        }

        return check;
    }
}
