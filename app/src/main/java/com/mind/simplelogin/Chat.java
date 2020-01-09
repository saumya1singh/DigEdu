package com.mind.simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Chat extends AppCompatActivity {
    EditText etMssg;
    TextView tvTop;
    Button btnSend;
    String mssg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        etMssg=findViewById(R.id.etMssg);
        tvTop=findViewById(R.id.tvTop);
        btnSend=findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mssg=etMssg.getText().toString();
                if(check())
                {
                    Toast.makeText(getBaseContext(),"Message Sent",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean check() {
        Boolean check =true;
        if(TextUtils.isEmpty(mssg))
        {
            etMssg.setError("Required");
            check=false;
        }

        return check;
    }
}
