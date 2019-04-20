package com.example.zaefdfyjhlk.certifprojet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accueil extends AppCompatActivity {
    Button btn_add, btn_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        btn_add=findViewById(R.id.btn1);
        btn_list=findViewById(R.id.btn2);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Accueil.this,SendMessage.class);
                startActivity(intent);
            }
        });
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Accueil.this,ListMessage.class);
                startActivity(intent);
            }
        });
    }
}
