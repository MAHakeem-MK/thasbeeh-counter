package com.mahakeemmk.counter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Vibrator;
import android.widget.Toast;

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
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Do you really want to reset?");
        alertDialogBuilder.setPositiveButton("Reset",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        confirmReset();
                        Toast.makeText(MainActivity.this,"Count reset", Toast.LENGTH_SHORT).show();
                    }
                });
        alertDialogBuilder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Cancelled",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void confirmReset() {
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

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Do you really want to exit?");
        alertDialogBuilder.setPositiveButton("Exit",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                });
        alertDialogBuilder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Cancelled",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
