package com.example.zaefdfyjhlk.certifprojet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimePick extends AppCompatActivity {

    TimePicker picker;
    Button btn_valid, btn_cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_pick);
        picker=findViewById(R.id.tmpick);
        btn_cancel=findViewById(R.id.cancel);
        btn_valid=findViewById(R.id.valid);


        btn_valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = picker.getCurrentHour();
                int min = picker.getCurrentMinute();
                Toast.makeText(TimePick.this, hour + " : " + min, Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(TimePick.this,SendMessage.class);
                intent.putExtra("Hour",hour);
                intent.putExtra("Min",min);
                startActivity(intent);

            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TimePick.this,SendMessage.class);
                startActivity(intent);
            }
        });

    }
}
