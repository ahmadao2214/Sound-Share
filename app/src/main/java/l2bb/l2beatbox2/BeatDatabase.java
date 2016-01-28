package l2bb.l2beatbox2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by OZ on 1/2/2016.
 */

public class BeatDatabase extends SQLiteOpenHelper {

    private static BeatDatabase instance = null;

    public static final String DATABASE_NAME = "Beats.db";
    public static final String TABLE_NAME = "Beat_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "PATH";

    private BeatDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static BeatDatabase getInstance(Context context)
    {
        if (instance == null)
            instance = new BeatDatabase(context);
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PATH TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String path){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, path);

        long result = db.insert(TABLE_NAME, null, contentValues);

        return (result != -1);//
    }

    public int getCount()
    {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();

        return cnt;
    }

    public Beat getBeat(int id) {
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BeatDatabase.COL_1,
                BeatDatabase.COL_2,
                BeatDatabase.COL_3
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder = BeatDatabase.COL_1 + " ASC";

        String whereClause = BeatDatabase.COL_1 + "=?";
        String[] whereArgs = {String.valueOf(id)};


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(
                BeatDatabase.TABLE_NAME,                  // The table to query
                projection,                               // The columns to return
                whereClause,                              // The columns for the WHERE clause
                whereArgs,                                // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        c.moveToFirst();
        return new Beat(c.getString(1), c.getString(2));
    }
}
