package com.example.ipsemana4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PantallaHost extends AppCompatActivity {

    private TextView IPHost;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_host);

        IPHost = findViewById(R.id.IPHost);
        btnBack = findViewById(R.id.btnBack);

        String IP1 = getIntent().getExtras().getString("IP1");
        String IP2 = getIntent().getExtras().getString("IP2");
        String IP3 = getIntent().getExtras().getString("IP3");
        String IP4 = getIntent().getExtras().getString("IP4");
        String IPAll = IP1+"."+IP2+"."+"."+IP3+"."+IP4;



        try {
            InetAddress i = InetAddress.getByName(IPAll);
            String divice = i.getHostAddress();

            Boolean D = i.isReachable(800);

            Log.d("VAMOOOOSSSS", " "+D);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





        btnBack.setOnClickListener(
                (v) -> {
                    Intent i = new Intent();

                    finish();
                }
        );
    }
}