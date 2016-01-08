package com.example.fran_.aad_5b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by fran_ on 23/12/2015.
 */
public class MyDBAdapter {



    // Definiciones y constantes
    private static final String DATABASE_NAME = "colegio4.db";
    private static final String DATABASE_TABLE_ALUMNOS = "alumnos";
    private static final String DATABASE_TABLE_PROFESORES = "profesores";
    private static final int DATABASE_VERSION = 1;

    private static final String NOMBRE_ALUMNO ="nombre";
    private static final String EDAD_ALUMNO = "edad";
    private static final String CICLO_ALUMNO = "ciclo";
    private static final String CURSO_ALUMNO = "curso";

    private static final String NOMBRE_PROFESOR ="nombre";
    private static final String EDAD_PROFESOR = "edad";
    private static final String CICLO_PROFESOR = "ciclo";
    private static final String CURSO_PROFESOR = "curso";
    private static final String DESPACHO = "despacho";


    private static final String DATABASE_CREATE_ALUMNOS =
            "CREATE TABLE "+DATABASE_TABLE_ALUMNOS+" " +
            "(_id integer primary key autoincrement, " +
            "nombre text, " +
            "edad text, " +
            "ciclo text, " +
            "curso text);";

    private static final String DATABASE_CREATE_PROFESORES =
            "CREATE TABLE "+DATABASE_TABLE_PROFESORES+" " +
            "(_id integer primary key autoincrement, " +
            "nombre text, " +
            "edad text, " +
            "ciclo text, " +
            "curso text, " +
            "despacho text);";
    private static final String DATABASE_DROP_ALUMNOS = "DROP TABLE IF EXISTS "+DATABASE_TABLE_ALUMNOS+";";
    private static final String DATABASE_DROP_PROFESORES = "DROP TABLE IF EXISTS "+DATABASE_TABLE_PROFESORES+";";

    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        //OJO open();
    }

    public void open(){
        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }
    }

    public void insertarAlumno(String n, String e,String ci, String cu){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE_ALUMNO,n);
        newValues.put(EDAD_ALUMNO,e);
        newValues.put(CICLO_ALUMNO,ci);
        newValues.put(CURSO_ALUMNO,cu);
        db.insert(DATABASE_TABLE_ALUMNOS, null, newValues);
    }

    public void insertarProfesor(String n, String e,String ci, String cu, String de){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE_PROFESOR,n);
        newValues.put(EDAD_PROFESOR, e);
        newValues.put(CICLO_PROFESOR, ci);
        newValues.put(CURSO_PROFESOR, cu);
        newValues.put(DESPACHO, de);
        db.insert(DATABASE_TABLE_PROFESORES, null, newValues);
    }

    public void eliminarRegistro(String id , String s){
        if (s.equals("alumno")){
            db.execSQL("delete from "+DATABASE_TABLE_ALUMNOS+" where _id = '" + id + "';");
        }
        else if (s.equals("profesor")){
            db.execSQL("delete from " + DATABASE_TABLE_PROFESORES + " where _id = '" + id + "';");
        }
    }

    public ArrayList<String> recuperarTodo(String seleccionado){
        ArrayList<String> lista = new ArrayList<String>();
        //Recuperamos en un cursor la consulta realizada
        if(seleccionado.equals("alumno")){
            Cursor cursor = db.query(DATABASE_TABLE_ALUMNOS,null,null,null,null,null,null);
            //Recorremos el cursor
            if (cursor != null && cursor.moveToFirst()){
                do{
                    lista.add(cursor.getString(0)+"     "+cursor.getString(1));
                }while (cursor.moveToNext());
            }
        }
        else if (seleccionado.equals("profesor")){
            Cursor cursor = db.query(DATABASE_TABLE_PROFESORES,null,null,null,null,null,null);
            //Recorremos el cursor
            if (cursor != null && cursor.moveToFirst()){
                do{
                    lista.add(cursor.getString(0)+"     "+cursor.getString(1));
                }while (cursor.moveToNext());
            }
        }
        else if (seleccionado.equals("todo")){
            Cursor cursor = db.query(DATABASE_TABLE_ALUMNOS,null,null,null,null,null,null);
            //Recorremos el cursor
            if (cursor != null && cursor.moveToFirst()){
                do{
                    lista.add(cursor.getString(0)+"     "+cursor.getString(1));
                }while (cursor.moveToNext());
            }
            cursor = db.query(DATABASE_TABLE_PROFESORES,null,null,null,null,null,null);
            //Recorremos el cursor
            if (cursor != null && cursor.moveToFirst()){
                do{
                    lista.add(cursor.getString(0)+"     "+cursor.getString(1));
                }while (cursor.moveToNext());
            }
        }
        return lista;
    }

    public ArrayList<String> recuperarConFiltro(String seleccionSuperior, String seleccionInferior, String busqueda){
        ArrayList<String> lista = new ArrayList<String>();
        if(seleccionInferior.equals("ciclo")){
            if(seleccionSuperior.equals("alumno")){
                //Recuperamos en un cursor la consulta realizada
                Cursor cursor = db.query(DATABASE_TABLE_ALUMNOS, null, null, null, null, null, null);
                //Recorremos el cursor
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        if (cursor.getString(3).equals(busqueda)) {
                            lista.add(cursor.getString(0) + "  " + cursor.getString(1)+ "  " + cursor.getString(3));
                        }
                    } while (cursor.moveToNext());
                }
            }
            else if (seleccionSuperior.equals("profesor")){
                //Recuperamos en un cursor la consulta realizada
                Cursor cursor = db.query(DATABASE_TABLE_PROFESORES, null, null, null, null, null, null);
                //Recorremos el cursor
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        if (cursor.getString(3).equals(busqueda)) {
                            lista.add(cursor.getString(0) + "  " + cursor.getString(1)+ "  " + cursor.getString(3));
                        }
                    } while (cursor.moveToNext());
                }
            }
            else {
                //Recuperamos en un cursor la consulta realizada
                Cursor cursor = db.query(DATABASE_TABLE_ALUMNOS, null, null, null, null, null, null);
                //Recorremos el cursor
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        if (cursor.getString(3).equals(busqueda)) {
                            lista.add(cursor.getString(0) + "  " + cursor.getString(1)+ "  " + cursor.getString(3));
                        }
                    } while (cursor.moveToNext());
                }
                //Recuperamos en un cursor la consulta realizada
                cursor = db.query(DATABASE_TABLE_PROFESORES, null, null, null, null, null, null);
                //Recorremos el cursor
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        if (cursor.getString(3).equals(busqueda)) {
                            lista.add(cursor.getString(0) + "  " + cursor.getString(1)+ "  " + cursor.getString(3));
                        }
                    } while (cursor.moveToNext());
                }
            }
        }
        else if(seleccionInferior.equals("curso")){
            if(seleccionSuperior.equals("alumno")){
                //Recuperamos en un cursor la consulta realizada
                Cursor cursor = db.query(DATABASE_TABLE_ALUMNOS, null, null, null, null, null, null);
                //Recorremos el cursor
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        if (cursor.getString(4).equals(busqueda)) {
                            lista.add(cursor.getString(0) + "  " + cursor.getString(1)+ "  " + cursor.getString(4));
                        }
                    } while (cursor.moveToNext());
                }
            }
            else if (seleccionSuperior.equals("profesor")){
                //Recuperamos en un cursor la consulta realizada
                Cursor cursor = db.query(DATABASE_TABLE_PROFESORES, null, null, null, null, null, null);
                //Recorremos el cursor
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        if (cursor.getString(4).equals(busqueda)) {
                            lista.add(cursor.getString(0) + "  " + cursor.getString(1)+ "  " + cursor.getString(4));
                        }
                    } while (cursor.moveToNext());
                }
            }
            else {
                //Recuperamos en un cursor la consulta realizada
                Cursor cursor = db.query(DATABASE_TABLE_ALUMNOS, null, null, null, null, null, null);
                //Recorremos el cursor
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        if (cursor.getString(4).equals(busqueda)) {
                            lista.add(cursor.getString(0) + "  " + cursor.getString(1)+ "  " + cursor.getString(4));
                        }
                    } while (cursor.moveToNext());
                }
                //Recuperamos en un cursor la consulta realizada
                cursor = db.query(DATABASE_TABLE_PROFESORES, null, null, null, null, null, null);
                //Recorremos el cursor
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        if (cursor.getString(4).equals(busqueda)) {
                            lista.add(cursor.getString(0) + "  " + cursor.getString(1)+ "  " + cursor.getString(4));
                        }
                    } while (cursor.moveToNext());
                }
            }
        }
        return lista;
    }

    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_ALUMNOS);
            db.execSQL(DATABASE_CREATE_PROFESORES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP_ALUMNOS);
            db.execSQL(DATABASE_DROP_PROFESORES);
            onCreate(db);
        }
    }
}
