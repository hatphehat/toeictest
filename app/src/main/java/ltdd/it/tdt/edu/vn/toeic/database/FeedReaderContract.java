package ltdd.it.tdt.edu.vn.toeic.database;

import android.provider.BaseColumns;

/**
 * Created by hph on 4/12/2016.
 */
public final class FeedReaderContract {
    public FeedReaderContract() {    }

    public static abstract class FeedQuestion implements BaseColumns {
        public static final String TABLE_NAME = "tdtquestion";
        public static final String COL_ID = "question_id";
        public static final String COL_TYPE = "question_type";
        public static final String COL_CONTEXT = "question_context";
        public static final String COL_ANSWER = "question_answer";
    }
    public static abstract class FeedAnswer implements BaseColumns {
        public static final String TABLE_NAME = "tdtquestion";
        public static final String COL_ID = "question_id";
        public static final String COL_TYPE = "question_type";
        public static final String COL_CONTEXT = "question_context";
        public static final String COL_ANSWER = "question_answer";
    }
    public static abstract class FeedMCQ implements BaseColumns {
        public static final String TABLE_NAME = "TDT_MCQ";
        public static final String COL_NAME = "";
    }
}