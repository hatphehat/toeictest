package ltdd.it.tdt.edu.vn.toeic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hph on 4/12/2016.
 */
public class QuestionSQL extends SQLiteOpenHelper {
    SQLiteDatabase database = getReadableDatabase();
    private static final String TEXT_TYPE = "TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE =
            "CREATE TABLE " + FeedReaderContract.FeedQuestion.TABLE_NAME + " (" +
                    FeedReaderContract.FeedQuestion.COL_ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.FeedQuestion.COL_TYPE + TEXT_TYPE + COMMA_SEP +
                    FeedReaderContract.FeedQuestion.COL_CONTEXT + TEXT_TYPE + COMMA_SEP +
                    FeedReaderContract.FeedQuestion.COL_ANSWER + TEXT_TYPE + COMMA_SEP +
                    ")";
    private static final String SQL_DETELE = "DROP TABLE IF EXISTS " + FeedReaderContract.FeedQuestion.TABLE_NAME;


    public QuestionSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        FeedReaderContract.FeedQuestion.TABLE_NAME
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
