package com.example.zaefdfyjhlk.certifprojet;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SendMessage extends AppCompatActivity {
    EditText edit_msg,edit_sender, edit_time;
    Button send, pick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        edit_msg=findViewById(R.id.msg);
        edit_sender=findViewById(R.id.sndr);
        edit_time=findViewById(R.id.tmp);
        //edit_time.setPaintFlags(edit_time.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        Intent intent =getIntent();
        int hour =intent.getIntExtra("Hour",0);
        int min =intent.getIntExtra("Min",0);
        edit_time.setText(hour+" : "+min);
        send=findViewById(R.id.submit);
        pick=findViewById(R.id.pic);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contenu= edit_msg.getText().toString();
                String sender= edit_sender.getText().toString();
                String time= edit_time.getText().toString();
                Message msg=new Message(contenu,sender,time);
                DBMessage db=new DBMessage(SendMessage.this);
                db.Add(msg);
                Toast.makeText(SendMessage.this, "Sent!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SendMessage.this,ListMessage.class);
                startActivity(intent);


            }
        });
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SendMessage.this,TimePick.class);
                startActivity(intent);
            }
        });

    }
}
