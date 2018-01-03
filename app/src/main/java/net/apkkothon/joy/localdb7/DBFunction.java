package net.apkkothon.joy.localdb7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by joy on 12/31/17.
 */

public class DBFunction  extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="mydb";
    private static final String TABLE_NAME="mytable";

    private static final String TAB_ID="_id";
    private static final String TAB_NAME="name";
    private static final String TAB_PROFESSION="profession";


    public DBFunction(Context context) {
        super(context,DATABASE_NAME ,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String q="CREATE TABLE "+TABLE_NAME+" ( "+TAB_ID+" INTEGER PRIMARY KEY, "+TAB_NAME+" TEXT, "+TAB_PROFESSION+" TEXT )";

        sqLiteDatabase.execSQL(q);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }


    public void addDataToTable(Model model){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put(TAB_NAME,model.getName());
        cv.put(TAB_PROFESSION,model.getProfession());

        sqLiteDatabase.insert(TABLE_NAME,null,cv);

        sqLiteDatabase.close();

    }

    public Cursor my_data(){

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        String q="SELECT * FROM "+TABLE_NAME;

        Cursor cursor=sqLiteDatabase.rawQuery(q,null);

        if (cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int delete(int position){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        return sqLiteDatabase.delete(TABLE_NAME,TAB_ID+" = ?",new String[]{position+""});

    }

    public String fetch_name(int pos){

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        String q="SELECT "+TAB_NAME+" FROM "+TABLE_NAME+" WHERE "+TAB_ID+" = "+pos;

        Cursor cursor=sqLiteDatabase.rawQuery(q,null);

        String name="";

        cursor.moveToFirst();
        if (cursor.moveToFirst()){

            name=cursor.getString(cursor.getColumnIndex(TAB_NAME));

        }
        return name;
    }

    public int name_update(String name,int pos){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put(TAB_NAME,name);

        return sqLiteDatabase.update(TABLE_NAME,cv,TAB_ID+" = ? ",new String[]{pos+""});

    }










}
