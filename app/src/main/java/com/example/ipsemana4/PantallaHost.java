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
    private int last = 1;
    private String ultimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_host);

        IPHost = findViewById(R.id.IPHost);
        btnBack = findViewById(R.id.btnBack);

        new Thread(
            () -> {
                while (last < 255) {

                    try {

                        ultimo = "192.168.1."+last;
                        InetAddress i = InetAddress.getByName(ultimo);

                        Boolean P = i.isReachable(500);

                        runOnUiThread(
                                () -> {
                                    if (P == true) {
                                        IPHost.append(""+ultimo+"\n");
                                    }
                                }
                        );
                        last++;
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        ).start();




        btnBack.setOnClickListener(
                (v) -> {
                    Intent i = new Intent();

                    finish();
                }
        );
    }
}