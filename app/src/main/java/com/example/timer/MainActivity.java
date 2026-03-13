package com.example.timer;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int ileSekund;
    private boolean czyIdzie = false;
    private Button start, stop, reset;
    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView);
        start = findViewById(R.id.button);
        stop = findViewById(R.id.button2);
        reset = findViewById(R.id.button3);
        Handler handler = new Handler();
        start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyIdzie = true;
                    }
                }
        );
        stop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        czyIdzie = false;
                    }
                }
        );
        handler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        if(czyIdzie){
                            ileSekund++;

                            textView1.setText(zwrocLadnyczas(ileSekund));
                        }
                        handler.postDelayed(this, 1000);
                    }
                }
        );


    }
    private String zwrocLadnyczas(int ileSekund){
        int sekundy = ileSekund%60;
        int minuty = (ileSekund/60)%60;
        int godziny = ileSekund/3600;
        return  String.format("%02d:%02d:%02d", godziny, minuty, sekundy);
    }
}