package com.tapz.weightr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class DBContract {

    // prevents someone from accidentally instantiating the contract class
    private DBContract(){}

    /* --- User Table --- */
    private static final class UserTable implements BaseColumns {
        private static final String TABLE_NAME = "users";
        private static final String COLUMN_NAME_EMAIL = "email";
        private static final String COLUMN_NAME_PASSWORD = "password";
        private static final String COLUMN_NAME_FNAME = "f_name";
        private static final String COLUMN_NAME_LNAME = "l_name";
        private static final String COLUMN_NAME_DATE = "date";
    }

    private static final String CREATE_USER_TABLE =
            "CREATE TABLE " + UserTable.TABLE_NAME + " (" +
                    UserTable._ID + " INTEGER PRIMARY KEY," +
                    UserTable.COLUMN_NAME_EMAIL + " TEXT," +
                    UserTable.COLUMN_NAME_PASSWORD + " TEXT," +
                    UserTable.COLUMN_NAME_FNAME + " TEXT," +
                    UserTable.COLUMN_NAME_LNAME + " TEXT," +
                    UserTable.COLUMN_NAME_DATE + " TEXT)";


    /* --- Weight Entry Table --- */
    private static final class WeightEntryTable implements BaseColumns {
        private static final String TABLE_NAME = "weight_entry";
        private static final String COLUMN_NAME_WEIGHT = "weight";
        private static final String COLUMN_NAME_DATE = "date";
    }

    private static final String CREATE_WEIGHT_ENTRY_TABLE =
            "CREATE TABLE " + WeightEntryTable.TABLE_NAME + " (" +
                    WeightEntryTable._ID + " INTEGER PRIMARY KEY," +
                    WeightEntryTable.COLUMN_NAME_WEIGHT + " TEXT," +
                    WeightEntryTable.COLUMN_NAME_DATE + " TEXT)";


    /* --- Weight Goal Table --- */
    private static final class WeightGoalTable implements BaseColumns {
        private static final String TABLE_NAME = "weight_goal";
        private static final String COLUMN_NAME_WEIGHT_GOAL = "weight_goal";
    }

    private static final String CREATE_WEIGHT_GOAL_TABLE =
            "CREATE TABLE " + WeightGoalTable.TABLE_NAME + " (" +
                    WeightGoalTable._ID + " INTEGER PRIMARY KEY," +
                    WeightGoalTable.COLUMN_NAME_WEIGHT_GOAL + " TEXT)";



    private static final String DELETE_USER_TABLE =
            "DROP TABLE IF EXISTS " + UserTable.TABLE_NAME;

    private static final String DELETE_WEIGHT_ENTRY_TABLE =
            "DROP TABLE IF EXISTS " + WeightEntryTable.TABLE_NAME;

    private static final String DELETE_WEIGHT_GOAL_TABLE =
            "DROP TABLE IF EXISTS " + WeightGoalTable.TABLE_NAME;

    /* ----- DB Helper Subclass ----- */
    public static class DBHelper extends SQLiteOpenHelper {
        /* subclass that overrides onCreate() & onUpgrade() callback methods */

        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Weightr_App.db";

        public DBHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(CREATE_USER_TABLE);
            db.execSQL(CREATE_WEIGHT_ENTRY_TABLE);
            db.execSQL(CREATE_WEIGHT_GOAL_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(DELETE_USER_TABLE);
            onCreate(db);
        }

        public Boolean insertLoginData(String email, String password){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("email", email);
            contentValues.put("password", password);
            long result = db.insert("users", null, contentValues);
            if(result == -1){
                return false;
            }else{
                return true;
            }
        }

        public Boolean checkEmail(String email){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = ?", new String[]{email});
            if(cursor.getCount() > 0){
                return true;
            }else{
                return false;
            }
        }

        public Boolean checkEmailPassword(String email, String password){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email = ? AND password = ?",
                    new String[] {email, password});
            if(cursor.getCount() > 0){
                return true;
            }else{
                return false;
            }
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
            onUpgrade(db, oldVersion, newVersion);
        }
    }

}