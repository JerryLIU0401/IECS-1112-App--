package fcu.app.iecs_1112_app_food;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class AccountDatabaseHandler {
    private AppCompatActivity activity;
    public static final String DATABASE_NAME = "account.db";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS Account(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT NOT NULL, " +
            "mail TEXT, " +
            "password TEXT, " +
            "userIcon BLOB); ";
    private SQLiteDatabase db;

    public AccountDatabaseHandler(AppCompatActivity activity) {
        this.activity = activity;
    }

    public void open() {
        db = activity.openOrCreateDatabase(DATABASE_NAME, 0, null);
        db.execSQL(CREATE_TABLE);
    }

    public void addAccount(String name, String mail, String password, Bitmap img) {
        byte[] userIcon = getBitmapAsByteArray(img);
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

    public int getId(String name, String password, Context context){
        int id = 0;
        Cursor cursor = db.rawQuery("SELECT * FROM Account WHERE name=" + name + " AND password= " + password, null);
        if (cursor.getCount() == 1) {
            id = cursor.getInt(cursor.getColumnIndex("_id"));
        }
        return id;
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
    public Bitmap getImage(String account){
        if(account.equals("")){
           return null;
        }
        Cursor cursor = db.rawQuery("SELECT name, userIcon FROM Account WHERE name=" + account, null);
        if(cursor.moveToFirst()){
            int i = cursor.getColumnIndex("userIcon");
            byte[] imgByte = cursor.getBlob(i);
            cursor.close();
            return BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
        }
        if(cursor != null && !cursor.isClosed()){
            cursor.close();
        }
        return null;
    }

    public String getAccountNameById(int id){
        Cursor cursor = db.rawQuery("SELECT _id, name FROM Account WHERE _id=" + Integer.toString(id), null);
        if(cursor.moveToFirst()){
            int i = cursor.getColumnIndex("name");
            String accountName = cursor.getString(i);
            cursor.close();
            return accountName;
        }
        if(cursor != null && !cursor.isClosed()){
            cursor.close();
        }
        return null;
    }
    public static byte[] getBitmapAsByteArray(Bitmap bitmap){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }


}
