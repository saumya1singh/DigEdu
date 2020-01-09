package com.mind.simplelogin;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UPIPAY extends AppCompatActivity {

    EditText amount, note, name, upiid;
    Button pay;
    final int UPI_PAYMENT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upi);


        initializemethod();
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amounttxt = amount.getText().toString();
                String notetxt = note.getText().toString();
                String nametxt = name.getText().toString();
                String upitxt = upiid.getText().toString();
                payUsingupi(amounttxt, notetxt, nametxt, upitxt);
            }
        });
    }

    private void payUsingupi(String amounttxt, String notetxt, String nametxt, String upitxt) {
        Uri uri = Uri.parse("upi://pay").buildUpon().appendQueryParameter("pa", upitxt)
                .appendQueryParameter("pn", nametxt)
                .appendQueryParameter("tn", notetxt)
                .appendQueryParameter("am", amounttxt)
                .appendQueryParameter("cu", "INR").build();
        Intent upi_payment = new Intent(Intent.ACTION_VIEW);
        upi_payment.setData(uri);
        Intent chooser = Intent.createChooser(upi_payment, "pay with");
        if (null != chooser.resolveActivity(getPackageManager())) {
            startActivityForResult(chooser, UPI_PAYMENT);
        } else {
            Toast.makeText(getApplicationContext(), "no upi found", Toast.LENGTH_LONG).show();
        }
    }

    private void initializemethod() {
        pay = (Button) findViewById(R.id.button);
        name = (EditText) findViewById(R.id.name);
        amount = (EditText) findViewById(R.id.amount);
        note = (EditText) findViewById(R.id.note);
        upiid = (EditText) findViewById(R.id.upi_id);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case UPI_PAYMENT: {
                if ((RESULT_OK) == resultCode || (resultCode == 11)) {
                    if (data != null) {
                        String txt = data.getStringExtra("response");
                        Log.d("UPI", "onActivityResult" + txt);
                        ArrayList<String> datalst = new ArrayList<>();
                        datalst.add("Nothing");
                        upipaymentdataoperation(datalst);
                    } else {
                        Log.d("UPI", "onActivityResult:" + "Return data is null");
                        ArrayList<String> datalst = new ArrayList<>();
                        datalst.add("Nothing");
                        upipaymentdataoperation(datalst);
                    }
                } else {
                    Log.d("UPI", "onActivityResult:" + "Return data is null");
                    ArrayList<String> datalst = new ArrayList<>();
                    datalst.add("Nothing");
                    upipaymentdataoperation(datalst);
                }
                break;
            }
        }
        // super.onActivityResult(requestCode,resultCode,data);
    }

    private void upipaymentdataoperation(ArrayList<String> data) {
        if (isConnectionAVailble(UPIPAY.this))
        {
            String str=data.get(0);
            Log.d("UPIPAY", "upupaymentoperation:" + str);
            String paymentCancell = "";
            if (str == null) str = "discard";
            String status = "";
            String approvalref = "";
            String response[] = str.split("&");
            for (int i = 0; i < response.length; i++) {
                String equalstr[] = response[i].split("#");
                if (equalstr.length >= 2) {
                    if (equalstr[0].toLowerCase().equals("Staus".toLowerCase())) {
                        status = equalstr[i].toLowerCase();
                    } else if (equalstr[0].toLowerCase().equals("approval Ref".toLowerCase()) ||
                            equalstr[0].toLowerCase().equals("txnRef".toLowerCase())) {
                        approvalref = equalstr[i];
                    }
                } else {
                    paymentCancell = "payment cancelled by user";
                }
            }

            if (status.equals("sucess")) {
                Toast.makeText(getApplicationContext(), "transaction sucess", Toast.LENGTH_LONG).show();
                Log.d("UPI", "responsestr:" + approvalref);
            } else if ("payment cancell by user".equals(paymentCancell)) {
                Toast.makeText(getApplicationContext(), "payment cancell by user", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "transaction failed ", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "internet connection is not available", Toast.LENGTH_LONG).show();
        }
    }



    private boolean isConnectionAVailble(Context context) {
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager!=null){
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null&&networkInfo.isConnected()&& networkInfo.isConnectedOrConnecting()&&
                    networkInfo.isAvailable()){
                return  true;
            }

        }
        return  false;
    }
}





