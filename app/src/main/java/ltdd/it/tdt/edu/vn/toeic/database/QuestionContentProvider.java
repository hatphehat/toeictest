package ltdd.it.tdt.edu.vn.toeic.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.HashMap;

/**
 * Created by hph on 4/12/2016.
 */
public class QuestionContentProvider extends ContentProvider {
    private static HashMap<String, String> STUDENTS_PROJECTION_MAP;
    SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
        return (db == null) ? false : true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(FeedReaderContract.FeedQuestion.TABLE_NAME);

        switch (FeedReaderContract.FeedQuestion.uriMatcher.match(uri)) {
            case FeedReaderContract.FeedQuestion.QUESTIONS:
                qb.setProjectionMap(STUDENTS_PROJECTION_MAP);
                break;
            case FeedReaderContract.FeedQuestion.QUESTION_ID:
                qb.appendWhere(FeedReaderContract.FeedQuestion.COL_ID + "=" + uri.getPathSegments().get(1) );
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (FeedReaderContract.FeedQuestion.uriMatcher.match(uri)) {
            case FeedReaderContract.FeedQuestion.QUESTIONS:
                return "vnd.android.cursor.dir/vn.edu.tdt.it.toeic.questions";
            case FeedReaderContract.FeedQuestion.QUESTION_ID:
                return "vnd.android.cursor.item/vn.edu.tdt.it.toeic.questions";
            default:
                throw new IllegalArgumentException("Unsupport URIL " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowID = db.insert(FeedReaderContract.FeedQuestion.TABLE_NAME, "", values);
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(FeedReaderContract.FeedQuestion.CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        throw new SQLException("Failed to add a record into " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;

        switch (FeedReaderContract.FeedQuestion.uriMatcher.match(uri)) {
            case FeedReaderContract.FeedQuestion.QUESTIONS:
                count = db.delete(FeedReaderContract.FeedQuestion.TABLE_NAME, selection, selectionArgs);
                break;
            case FeedReaderContract.FeedQuestion.QUESTION_ID:
                count = db.delete(FeedReaderContract.FeedQuestion.TABLE_NAME, FeedReaderContract.FeedQuestion.COL_ID + "=" + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" +
                                selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count = 0;

        switch (FeedReaderContract.FeedQuestion.uriMatcher.match(uri)) {
            case FeedReaderContract.FeedQuestion.QUESTIONS:
                count = db.update(FeedReaderContract.FeedQuestion.TABLE_NAME, values, selection, selectionArgs);
                break;
            case FeedReaderContract.FeedQuestion.QUESTION_ID:
                count = db.update(FeedReaderContract.FeedQuestion.TABLE_NAME, values, FeedReaderContract.FeedQuestion.COL_ID + "=" + uri.getPathSegments().get(1) +
                        (!TextUtils.isEmpty(selection) ? " AND (" +
                                selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    private class DatabaseHelper extends SQLiteOpenHelper {
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

        DatabaseHelper(Context context) {
            super(context, FeedReaderContract.DATABASE_NAME, null, FeedReaderContract.DATABASE_VERSION);
        }

        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                              int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion == newVersion) return;
            db.execSQL(SQL_DETELE);
            onCreate(db);

        }
    }
}