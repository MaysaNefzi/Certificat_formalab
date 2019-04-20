package com.example.zaefdfyjhlk.certifprojet;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class    UpdateMessage extends AppCompatActivity {
    EditText up_msg,up_sender, up_time;
    Button modif, pick;
    DBMessage db;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_message);
        up_msg=findViewById(R.id.msg);
        up_sender=findViewById(R.id.sndr);
        up_time=findViewById(R.id.tmp);
        modif=findViewById(R.id.submit);
        pick=findViewById(R.id.pic);
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UpdateMessage.this,TimePick.class);
                startActivity(intent);
            }
        });
        Intent intent= getIntent();
        id =intent.getIntExtra("id",0);
        db= new DBMessage(this);
        Message msg =db.getMsgById(id);
        up_msg.setText(msg.getContenu());
        up_sender.setText(msg.getSender());
        up_time.setText(msg.getTime());
        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contenu_up=up_msg.getText().toString();
                String sender_up=up_sender.getText().toString();
                String time_up=up_time.getText().toString();
                Message msg=new Message(id,contenu_up,sender_up,time_up);
                DBMessage db=new DBMessage(UpdateMessage.this);
                db.Update(msg);
                Toast.makeText(UpdateMessage.this, "Updated!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateMessage.this,ListMessage.class);
                startActivity(intent);


            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delete, menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete)
        {
            showPopUp();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showPopUp()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("Delete").setMessage("Are you sure deleting this message?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                db.Delete(id);
                Intent intent = new Intent(UpdateMessage.this,ListMessage.class);
                startActivity(intent);
                Toast.makeText(UpdateMessage.this, "Message deletd", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(UpdateMessage.this,ListMessage.class);
                startActivity(intent);
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
