package com.example.zaefdfyjhlk.certifprojet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListMessage extends AppCompatActivity {
    ListView lst;
    Button dash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_message);
        lst= findViewById(R.id.liste);
        DBMessage db = new DBMessage(this);
        ArrayList<Message> Msgarraylist = db.getAllMsg();
        AdapterClass adapter = new AdapterClass(this,Msgarraylist);
        lst.setAdapter(adapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Message msg = (Message) parent.getItemAtPosition(position);
                int id=msg.getId();
                Intent intent = new Intent(ListMessage.this,UpdateMessage.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        dash=findViewById(R.id.dash);
        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ListMessage.this,Accueil.class);
                startActivity(intent);
            }
        });
    }
}
