package com.mahakeemmk.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
    }
    
    public void resetCount(View view) {
        count = 0;
        display(count);
    }
}
