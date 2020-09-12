package com.example.ipsemana4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private EditText IP1;
    private EditText IP2;
    private EditText IP3;
    private EditText IP4;
    private Button btnPing;
    private Button btnHost;
    private String myIP1;
    private String myIP2;
    private String myIP3;
    private String myIP4;
    private String IPAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IP1 = findViewById(R.id.IP1);
        IP2 = findViewById(R.id.IP2);
        IP3 = findViewById(R.id.IP3);
        IP4 = findViewById(R.id.IP4);
        btnPing = findViewById(R.id.btnPing);
        btnHost = findViewById(R.id.btnHost);




        btnPing.setOnClickListener(
                (v) -> {

                    myIP1 = IP1.getText().toString();
                    myIP2 = IP2.getText().toString();
                    myIP3 = IP3.getText().toString();
                    myIP4 = IP4.getText().toString();
                    IPAll = myIP1+"."+myIP2+"."+myIP3+"."+myIP4;


                    Intent i = new Intent(this, PantallaPing.class);

                    i.putExtra("IPAll", IPAll);




                    startActivity(i);
                }
        );

        btnHost.setOnClickListener(
                (v) -> {

                    Intent i = new Intent(this, PantallaHost.class);

                    startActivity(i);
                }
        );

    }
}