package com.mind.simplelogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class attendance extends AppCompatActivity {
    EditText date,name,roll,standard,p_a;
    String DATE,NAME,ROLL,STANDARD,P_A;

    public FirebaseDatabase firebaseDatabase;
    public DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        date=(EditText)findViewById(R.id.date);
        name=(EditText)findViewById(R.id.name);
        roll=(EditText)findViewById(R.id.roll);
        standard=(EditText)findViewById(R.id.standard);
        p_a=(EditText)findViewById(R.id.present);

        // firebaseDatabase=FirebaseDatabase.getInstance();
        // databaseReference=firebaseDatabase.getReference().child("date").child(DATE);
    }

    public void add_attendance(View view) {

        // code to add attendance

        DATE=date.getText().toString();
        NAME =name.getText().toString();
        ROLL=roll.getText().toString();
        STANDARD=standard.getText().toString();
        P_A=p_a.getText().toString();

        // Product p = new Product(DATE,NAME,ROLL,STANDARD,P_A);
        //   databaseReference.setValue(p);

//[FirebaseDatabase mydb =][2] FirebaseDatabase.getInstance();
        //  DatabaseReference mDatabase = mydb.getReference().child("Date").child(DATE);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("date").child(DATE);
        Map<String, String> userData = new HashMap<String, String>();

        userData.put("Name", NAME);
        userData.put("ROLL", ROLL);
        userData.put("STANDARD",STANDARD);
        userData.put("P_A",P_A);
        databaseReference.push().setValue(userData);

        Toast.makeText(getApplicationContext(),"inserted",Toast.LENGTH_LONG).show();
    }
}
