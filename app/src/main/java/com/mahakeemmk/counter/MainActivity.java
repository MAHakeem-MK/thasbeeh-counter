package com.mahakeemmk.counter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Vibrator;

public class MainActivity extends AppCompatActivity {
    private Vibrator vibe;
    private TextView value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value = (TextView)findViewById(R.id.value);
        vibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        if (savedInstanceState!=null) {
            display(savedInstanceState.getInt("count_value"));
        }
    }

    private void display(Integer number) {
        value.setText(number.toString());
    }

    public void count(View view) {
        int count = Integer.parseInt(value.getText().toString());
        count++;
        display(count);
        if (count != 0 && count % 33 == 0) {
            vibe.vibrate(300);
        }
    }
    
    public void resetCount(View view) {
        int count;
        count = 0;
        display(count);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int count = Integer.parseInt(value.getText().toString());
        if (count!=0) {
            outState.putInt("count_value",count);
        }
    }
}
