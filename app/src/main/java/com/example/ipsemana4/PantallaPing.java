package com.example.ipsemana4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PantallaPing extends AppCompatActivity {

    private TextView status;
    private Button btnRegresar;
    private int todos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_ping);

        status = findViewById(R.id.status);
        btnRegresar = findViewById(R.id.btnRegresar);

        String IPAll = getIntent().getExtras().getString("IPAll");


        new Thread(
                () -> {
                    while (todos < 4) {

                        try {
                            todos ++;

                            InetAddress i = InetAddress.getByName(IPAll);
                          /*  InetAddress inet = InetAddress.getLocalHost();
                            String myIP = inet.getHostAddress();*/

                           // Log.d("SIIIIIIIIIIIII", ""+myIP);

                            Boolean D = i.isReachable(500);


                            runOnUiThread(
                                    () -> {
                                        if (D == true) {
                                            status.append("Recibido\n");

                                        } else {
                                            status.append("Perdido\n");
                                        }
                                    }
                            );
                            Thread.sleep(2000);

                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
        ).start();





        btnRegresar.setOnClickListener(
                (v) -> {
                    Intent i = new Intent();

                    finish();
                }
        );
    }
}