package com.mahakeemmk.counter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Vibrator;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Vibrator vibe;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void display(Integer number) {
        TextView value = (TextView)findViewById(R.id.value);
        value.setText(number.toString());
    }

    public void count(View view) {
        count++;
        display(count);
        if (count != 0 && count % 33 == 0) {
            vibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            vibe.vibrate(300);
        }
    }
    
    public void resetCount(View view) {
        count = 0;
        display(count);
    }
}
