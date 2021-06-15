package com.hellosolver.bankingapp.DATABASE;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hellosolver.bankingapp.DATABASE.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME= UserEntry.TABLE_NAME;

    private static final String DATABASE_NAME="User.db";

    private static final int DATABASE_VERSION = 1;


    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";


        db.execSQL(SQL_CREATE_USER_TABLE);
        db.execSQL("insert into " + TABLE_NAME + " values(20859,'Aman Savita', 'aman@gmail.com','BOI72658','7897428596', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(20823,'Vikas Singh', 'vikas@gmail.com','BOI72658','7897228542', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(20819,'Abhay Savita', 'abhay@gmail.com','BOI72658','9336428596', 2000)");
        db.execSQL("insert into " + TABLE_NAME + " values(20834,'Golu Verma', 'golu123@gmail.com','BOI72658','9956428496', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(0879,'Raman Verma', 'raman345@gmail.com','BOI72658','7499091845', 16000)");
        db.execSQL("insert into " + TABLE_NAME + " values(20459,'Vikas Savita', 'vikassavita345@gmail.com','BOI72658','7897458596', 20000)");
        db.execSQL("insert into " + TABLE_NAME + " values(20859,'Suresh Shukla','suresh23@gmail.com','BOI72658','7499635896', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(20459,'Neha Singh', 'neha1990@gmail.com','BOI72658','7897429647', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(20829,'Monika shukla', 'monika7890@gmail.com','BOI72658','9838817545', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(20831,'Isha pandey', 'isha2000@gmail.com','BOI72658','9260994875', 7000)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion!=newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }
    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}
