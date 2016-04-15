package ltdd.it.tdt.edu.vn.toeic.database;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by hph on 4/12/2016.
 */
public final class FeedReaderContract {
    public FeedReaderContract() {    }
    public static String DATABASE_NAME = "toeic";
    public static int DATABASE_VERSION = 1;

    public static abstract class FeedQuestion implements BaseColumns {
        public static final String TABLE_NAME = "tdtquestion";
        public static final String COL_ID = "question_id";
        public static final String COL_TYPE = "question_type";
        public static final String COL_CONTEXT = "question_context";
        public static final String COL_ANSWER = "question_answer";


        public static final int QUESTIONS = 1;
        public static final int QUESTION_ID = 2;
        public static final String PROVIDER_NAME = "vn.edu.tdt.it.toeic";
        static final String URI = "content://" + PROVIDER_NAME + "/questions";
        static final Uri CONTENT_URI = Uri.parse(URI);
        public static final UriMatcher uriMatcher;
        static{
            uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
            uriMatcher.addURI(PROVIDER_NAME, "question", QUESTIONS);
            uriMatcher.addURI(PROVIDER_NAME, "question/#", QUESTION_ID);
        }
    }
    public static abstract class FeedAnswer implements BaseColumns {
        public static final String TABLE_NAME = "tdtquestion";
        public static final String COL_ID = "question_id";
        public static final String COL_TYPE = "question_type";
        public static final String COL_CONTEXT = "question_context";
        public static final String COL_ANSWER = "question_answer";
    }
    public static abstract class FeedMCQ implements BaseColumns {
        public static final String TABLE_NAME = "tdtmcq";
        public static final String COL_NAME = "";
    }
}