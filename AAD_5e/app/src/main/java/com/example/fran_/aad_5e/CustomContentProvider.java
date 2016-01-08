package com.example.fran_.aad_5e;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

/**
 * Created by fran_ on 08/01/2016.
 */
public class CustomContentProvider extends ContentProvider {
    // Campos del content provider
    static final String PROVIDER_NAME = "com.example.fran_.aad_5e";
    static final String URL = "content://" + PROVIDER_NAME + "/alumnos";
    static final Uri CONTENT_URI = Uri.parse(URL);

    MyDbHelper dbHelper;

    // Constantes usados para el content URI
    static final int ALUMNOS = 1;
    static final int ALUMNOS_ID = 2;

    // Mapeo de patrones de content URI a los valores definidos arriba
    static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME,"alumnos",ALUMNOS);
        uriMatcher.addURI(PROVIDER_NAME,"alumnos/#",ALUMNOS_ID);
    }

    // database declarations
    SQLiteDatabase colegio_database;
    // Definiciones y constantes
    static final String DATABASE_NAME = "colegio4.db";
    static final String DATABASE_TABLE_ALUMNOS = "alumnos";
    static final String DATABASE_TABLE_PROFESORES = "profesores";
    static final int DATABASE_VERSION = 1;

    static final String _ID = "_id";
    static final String NOMBRE_ALUMNO ="nombre";
    static final String EDAD_ALUMNO = "edad";
    static final String CICLO_ALUMNO = "ciclo";
    static final String CURSO_ALUMNO = "curso";

    static final String NOMBRE_PROFESOR ="nombre";
    static final String EDAD_PROFESOR = "edad";
    static final String CICLO_PROFESOR = "ciclo";
    static final String CURSO_PROFESOR = "curso";
    static final String DESPACHO = "despacho";


    static final String DATABASE_CREATE_ALUMNOS =
            "CREATE TABLE "+DATABASE_TABLE_ALUMNOS+" " +
                    "(_id integer primary key autoincrement, " +
                    "nombre text, " +
                    "edad text, " +
                    "ciclo text, " +
                    "curso text);";

    static final String DATABASE_CREATE_PROFESORES =
            "CREATE TABLE "+DATABASE_TABLE_PROFESORES+" " +
                    "(_id integer primary key autoincrement, " +
                    "nombre text, " +
                    "edad text, " +
                    "ciclo text, " +
                    "curso text, " +
                    "despacho text);";
    static final String DATABASE_DROP_ALUMNOS = "DROP TABLE IF EXISTS "+DATABASE_TABLE_ALUMNOS+";";
    static final String DATABASE_DROP_PROFESORES = "DROP TABLE IF EXISTS "+DATABASE_TABLE_PROFESORES+";";


    public String getType(Uri uri){
        switch (uriMatcher.match(uri)){
            //Todos los discos
            case ALUMNOS:
                return "vnd.android.cursor.dir/vnd.com.example.fran_.aad_5e";
            //Un disco particular
            case ALUMNOS_ID:
                return "vnd.android.cursor.item/vnd.com.example.fran_.aad_5e";
            default:
                throw new IllegalArgumentException("Unsupported URI "+uri);
        }
    }

    public boolean onCreate(){

        dbHelper = new MyDbHelper(getContext());

        colegio_database = dbHelper.getWritableDatabase();

        if(colegio_database == null)
            return false;
        else
            return true;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder){
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

        //La tabla sobre la que hacemos la consulta
        queryBuilder.setTables(DATABASE_TABLE_ALUMNOS);

        switch (uriMatcher.match(uri)){
            //Todos los registros
            case ALUMNOS:
                break;
            //El registro que contiene el _id
            case ALUMNOS_ID:
                queryBuilder.appendWhere(_ID + " = " + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unknown URI "+uri);
        }

        return queryBuilder.query(colegio_database, null, null, null, null,null,null);

    }

    public Uri insert(Uri uri, ContentValues values){
        /* to implement */
        Uri _uri = uri;
        return _uri;
    }

    public int update (Uri uri, ContentValues values, String selection, String[] selectionArgs){
        /* to implement */
        return 1;
    }

    public int delete (Uri uri, String selection, String[] selectionArgs){
        /* to implement */
        return 1;
    }

    // Clase que crea y gestiona la BBDD del provider
    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE_ALUMNOS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(MyDbHelper.class.getName(),
                    "Upgrading database from version " + oldVersion +
                            " to " + newVersion +
                            ". Old data will be destroyed");
            db.execSQL(DATABASE_DROP_ALUMNOS);
            onCreate(db);
        }
    }
}