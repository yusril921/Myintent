package com.alvinmd.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnDialNumber, btnOpenGoogle, btnSendText, btnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnOpenGoogle = findViewById(R.id.btn_open_google);
        btnSendText = findViewById(R.id.btn_send_text);
        btnSendEmail = findViewById(R.id.btn_send_email);

        btnDialNumber.setOnClickListener(this);
        btnOpenGoogle.setOnClickListener(this);
        btnSendText.setOnClickListener(this);
        btnSendEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dial_number:
                String phone_number = "082385727248";
                Intent dialnumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone_number));
                startActivity(dialnumber);
                break;
            case R.id.btn_open_google:
                //
                String url = "https://www.google.com";
                Intent openGoogle = new Intent(Intent.ACTION_VIEW);
                openGoogle.setData(Uri.parse(url));
                startActivity(openGoogle);
                break;
            case R.id.btn_send_text:
                String message = "Ini Pesan Untuk Implicit";
                Intent sendTextIntent = new Intent(Intent.ACTION_SEND);
                sendTextIntent.setType("text/plain");
                sendTextIntent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(sendTextIntent);
                break;
            case R.id.btn_send_email:
                String firstEMail = "hidayatyusril92@gmail.com";
                String secondEMail = "hidayatyusril97@gmail.com";
                String subject = "Belajar Intent Explicit";
                String bodyMessage = "Lorem Ipsum";
                Intent sendEmailIntent = new Intent(Intent.ACTION_SEND);
                sendEmailIntent.setType("message/rfc822");
                sendEmailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{firstEMail, secondEMail});
                sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                sendEmailIntent.putExtra(Intent.EXTRA_TEXT, bodyMessage);
                startActivity(sendEmailIntent);
                break;
        }
    }
}