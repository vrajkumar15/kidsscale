package com.example.rajkumar_vijayan.kidsbpscale;

import android.database.sqlite.SQLiteOpenHelper;
import java.util.*;


        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
        import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public ArrayList<String[]> getQuotes(String Age) {
        ArrayList<String[]> listOLists = new ArrayList<String[]>();
        Log.d("DEBUG","Start");
        //String [][] arrayOArrays = new String [4][];
        Cursor cursor = database.rawQuery("SELECT * FROM BoyDiaCentiles where Age = ?",new String[]{Age});
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
//            ArrayList<String> rows = new ArrayList<String>();
//            rows.add(cursor.getString(cursor.getColumnIndex("BPCentile")));
//            rows.add(cursor.getString(cursor.getColumnIndex("Ht5th")));
//            rows.add(cursor.getString(cursor.getColumnIndex("Ht10th")));
//            rows.add(cursor.getString(cursor.getColumnIndex("Ht25th")));
//            rows.add(cursor.getString(cursor.getColumnIndex("Ht50th")));
//            rows.add(cursor.getString(cursor.getColumnIndex("Ht75th")));
//            rows.add(cursor.getString(cursor.getColumnIndex("Ht90th")));
//            rows.add(cursor.getString(cursor.getColumnIndex("Ht95th")));
            listOLists.add(new String[] {cursor.getString(cursor.getColumnIndex("BPCentile")),cursor.getString(cursor.getColumnIndex("Ht5th")),cursor.getString(cursor.getColumnIndex("Ht10th")),cursor.getString(cursor.getColumnIndex("Ht25th")),cursor.getString(cursor.getColumnIndex("Ht50th")),cursor.getString(cursor.getColumnIndex("Ht75th")),cursor.getString(cursor.getColumnIndex("Ht90th")),cursor.getString(cursor.getColumnIndex("Ht95th"))});
//            rows.add(cursor.getString(0));
//            Log.d("DEBUG", cursor.getString(0));
//            Log.d("DEBUG", cursor.getString(1));
//            Log.d("DEBUG", cursor.getString(2));
//            Log.d("DEBUG", cursor.getString(3));
//            Log.d("DEBUG", cursor.getString(4));
//            Log.d("DEBUG", cursor.getString(5));
//            Log.d("DEBUG", cursor.getString(6));
//            Log.d("DEBUG", cursor.getString(7));
            //cursor.getColumnCount();
            //percArray.add("test");

            //list.add(cursor.getString(0));
            //listOLists.add(rows);
            cursor.moveToNext();
        }
        cursor.close();
        Log.d("DEBUG", listOLists.toString());
        return listOLists;
    }
}