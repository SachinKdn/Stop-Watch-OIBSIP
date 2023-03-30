package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int milliseconds = 0;
    boolean isRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.stopWatch);
        startTimer();
    }
    public void startWatch(View view){
        isRunning = true;

    }
    public void pauseWatch(View view){
        isRunning = false;

    }
    public void resetWatch(View view){
        isRunning = false;
        milliseconds = 0;
    }
    public void startTimer(){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int ms = milliseconds%100;
                int secs = (milliseconds/60)%60;

                 int mins = milliseconds/3600;

                if (isRunning) {
                    milliseconds++;
                }
                String timeFormat = String.format(Locale.getDefault(),"%02d:%02d:%02d", mins, secs, ms);
                textView.setText(timeFormat);

                handler.postDelayed(this,10);
            }
        };
        handler.post(runnable);
    }
}