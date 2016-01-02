package l2bb.l2beatbox2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by OZ on 1/2/2016.
 */

public class BeatDatabase extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Beats.db";
    public static final String TABLE_NAME = "Beat_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "TYPE";

    public BeatDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
