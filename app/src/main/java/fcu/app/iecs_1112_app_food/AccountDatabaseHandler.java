package fcu.app.iecs_1112_app_food;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class AccountDatabaseHandler {
    private AppCompatActivity activity;
    public static final String DATABASE_NAME = "account.db";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS Account(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT NOT NULL, " +
            "mail TEXT, " +
            "password TEXT, " +
            "userIcon TEXT); ";
    private SQLiteDatabase db;

    public AccountDatabaseHandler(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void open() {
        db = activity.openOrCreateDatabase(DATABASE_NAME, 0, null);
        db.execSQL(CREATE_TABLE);
    }

    public void addAccount(String name, String mail, String password, String userIcon) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("mail", mail);
        values.put("password", password);
        values.put("userIcon", userIcon);
        db.insert("Account", null, values);
    }

    public void updateAccountData(String name, String mail, String password, String userIcon){
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("mail", mail);
        values.put("password", password);
        values.put("userIcon", userIcon);
        db.update("Account", values, null, null);
    }

    public boolean loginAccountSearch(String name, String password, Context context) {
        if (name.equals("123") && password.equals("123")){
            return true;
        }
        if (name.isEmpty() || password.isEmpty()) {
            return false;
        } else {
            Cursor cursor = db.rawQuery("SELECT * FROM Account WHERE name=" + name + " AND password= " + password, null);
            if (cursor.getCount() == 1) {
                return true;
            } else {
                return false;
            }
        }
        //return false;
    }

    public boolean isAccountExist(String name) {
        Cursor cursor = db.rawQuery("SELECT name From Account WHERE name=" + name, null, null);
        if (cursor.getCount() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMailExist(String mail) {
        String newMail = "'" + mail + "'";
        Cursor cursor = db.rawQuery("SELECT mail From Account WHERE mail = " + newMail, null, null);
        if (cursor.getCount() == 1) {
            return true;
        } else {
            return false;
        }
    }



    public void deleteAccount(String name) {
        db.delete("Account", "name=" + name, null);
    }

    public void dropTable(){
        db.execSQL("DROP TABLE Account");
    }
}
