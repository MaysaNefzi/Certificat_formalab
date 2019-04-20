package com.example.zaefdfyjhlk.certifprojet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBMessage extends SQLiteOpenHelper {
    private static final String TB_NAME="message";
    private static final String DB_NAME="DBmessage";
    private static final int version=2;

    public DBMessage(Context context ) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="CREATE TABLE "+ TB_NAME+" (id INTEGER PRIMARY KEY, contenu VARCHAR2(255) , sender VARCHAR2(50), time VARCHAR2(10)) ";
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete="DROP TABLE IF EXISTS "+ TB_NAME;
        db.execSQL(delete);
        onCreate(db);

    }
    public void Add(Message msg)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("contenu",msg.getContenu());
        values.put("sender",msg.getSender());
        values.put("time",msg.getTime());
        db.insert(TB_NAME,null,values);
    }
    public ArrayList<Message> getAllMsg()
    {
        SQLiteDatabase db= getReadableDatabase();
        String query="SELECT * FROM "+ TB_NAME;
        Cursor cursor=db.rawQuery(query,null);
        ArrayList<Message> array = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                int id=cursor.getInt(cursor.getColumnIndex("id"));
                String contenu=cursor.getString(cursor.getColumnIndex("contenu"));
                String sender=cursor.getString(cursor.getColumnIndex("sender"));
                String time=cursor.getString(cursor.getColumnIndex("time"));
                Message msg = new Message(id,contenu,sender,time);
                array.add(msg);
            }while(cursor.moveToNext());
        }
        return array;
    }
    public Message Update(Message msg)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("contenu",msg.getContenu());
        values.put("sender",msg.getSender());
        values.put("time",msg.getTime());
        db.update(TB_NAME,values,"id=?", new String[]{String.valueOf(msg.getId())});
        return msg;
    }
    public void Delete(int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TB_NAME,"id=?",new String[]{String.valueOf(id)});
    }
    public Message getMsgById(int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query="SELECT * FROM "+TB_NAME+" WHERE id="+id;
        Cursor cursor=db.rawQuery(query,null);
        Message msg=null;
        if (cursor.moveToFirst())
        {
            int ID = cursor.getInt(cursor.getColumnIndex("id"));
            String CONTENU = cursor.getString(cursor.getColumnIndex("contenu"));
            String SENDER = cursor.getString(cursor.getColumnIndex("sender"));
            String TIME = cursor.getString(cursor.getColumnIndex("time"));
            msg = new Message(ID, CONTENU, SENDER,TIME);
        }
        return msg;

    }
}
