package com.mind.simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AttendanceByTeacher extends AppCompatActivity {
    EditText pass;
    String mpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_by_teacher);
        pass=(EditText)findViewById(R.id.password);

    }
    public  void  go(View view){
        mpass=pass.getText().toString();
        if(mpass.equals("123")){
            Intent intent=new Intent( getApplicationContext(),attendance.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"invalid password",Toast.LENGTH_LONG).show();
        }
    }
}
