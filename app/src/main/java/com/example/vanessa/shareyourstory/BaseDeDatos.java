package com.example.vanessa.shareyourstory;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Escolar on 23/05/2017.
 */

public class BaseDeDatos extends SQLiteOpenHelper {

    // Version de la base de datos
    private static final int DATABASE_VERSION = 2;

    // Nombre de la base de datos
    private static final String DATABASE_NAME = "shareyourstory";

    // Nombre de las tablas
    private static final String TABLE_NOTAS= "Notas";
    private static final String TABLE_USUARIO= "Usuario";

    // Nombre de las columnas de la tabla Notes
    private static final String NOTE_ID = "Id_nota";
    private static final String NOTE_Text = "Text";
    private static final String USUARIO = "Usuario";
    private static final String CONTRASEÑA = "Contraseña";

    public BaseDeDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creamos las tablas
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NOTAS + "("
                + NOTE_ID + " TEXT PRIMARY KEY," + NOTE_Text + " TEXT" + ")";
        db.execSQL(CREATE_NOTES_TABLE);
        String CREATE_USUARIO = "CREATE TABLE " + TABLE_USUARIO + "("
                + USUARIO + " TEXT " + CONTRASEÑA + " TEXT" + ")";
        db.execSQL(CREATE_USUARIO);

    }
    //ACtualizacion de la abase de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTAS);
        // Create tables again
        onCreate(db);
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);
        // Create tables again
        onCreate(db);
    }
    //CRUD

    //NUeva nota
    public void  addNota(String ID, String Text,View v) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NOTE_ID, ID);
        values.put(NOTE_Text, Text);

        // Insertar
        try{
            //db.insert(TABLE_NOTAS, null, values);
            String query = ("INSERT INTO "+TABLE_NOTAS+" ("+NOTE_ID+","+NOTE_Text+") VALUES('"+ID+"','"+Text+"','0');");
            db.execSQL(query);
        }catch (SQLException ex){

            //Snackbar.make(v, "Error al insertar Titulo ya utilizado", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show();
            System.out.println(ex);
        }
        db.close();
    }
    public void  addUsuario( String Text,String passwd) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USUARIO, Text);
        values.put(CONTRASEÑA, passwd);

        // Insertar
        try{
            //db.insert(TABLE_NOTAS, null, values);
            String query = ("INSERT INTO "+TABLE_NOTAS+" ("+USUARIO+","+CONTRASEÑA+") VALUES('"+Text+"','"+Text+"','0');");
            db.execSQL(query);
        }catch (SQLException ex){

            //Snackbar.make(v, "Error al insertar Titulo ya utilizado", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show();
            System.out.println(ex);
        }
        db.close();
    }

    public ArrayList getAllNotes() {
        ArrayList NoteList = new ArrayList();

        String selectQuery = "SELECT  * FROM " + TABLE_NOTAS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {

                NoteList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        db.close();
        return NoteList;
    }

    // getNote
    public String getNote(String id) {
        String selectQuery = "SELECT "+NOTE_Text+" FROM " + TABLE_NOTAS +" WHERE "+NOTE_ID+" = '"+id+"';";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        String note="";
        if (cursor.moveToFirst()) {
            do {

                note = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        db.close();

        return note;
    }

    public void  updateNOte(String ID, String Text,View v) {
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            //db.insert(TABLE_NOTAS, null, values);
            String query = ("UPDATE "+TABLE_NOTAS+ " SET "+NOTE_Text+" = '"+Text+"' WHERE "+NOTE_ID+" = '"+ID+"';" );
            db.execSQL(query);
        }catch (SQLException ex){

            Toast.makeText(v.getContext(),"Error en actualizar la nota",Toast.LENGTH_SHORT).show();
            System.out.println(ex);
        }
        db.close();
    }

    public void  updateIDs(String ID,String nID) {
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            //db.insert(TABLE_NOTAS, null, values);
            String query = ("UPDATE "+TABLE_NOTAS+ " SET "+NOTE_ID+" = '"+nID+"' WHERE "+NOTE_ID+" = '"+ID+"';" );
            db.execSQL(query);
        }catch (SQLException ex){

            System.out.println("Error"+ex);

        }
        db.close();
    }

    public void  DeleteNote(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            String query = ("DELETE FROM "+TABLE_NOTAS+ " WHERE "+NOTE_ID+" = '"+ID+"';" );
            db.execSQL(query);
        }catch (SQLException ex){



        }
        db.close();
    }
}
