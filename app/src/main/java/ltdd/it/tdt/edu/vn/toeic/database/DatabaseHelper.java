package ltdd.it.tdt.edu.vn.toeic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.object.MCQ;
import ltdd.it.tdt.edu.vn.toeic.object.Question;

/**
 * Created by hph on 4/17/2016.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "hph";
    private static final int DATABASE_VERSION = 3;
    private Dao<MCQ,Integer> arcDAO;
    private Dao<Question,Integer> questionDAO;
//    private Dao<ARCDetail,Integer> arcDetailIntegerDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION,R.raw.ormlite_config);
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,MCQ.class);
            TableUtils.createTable(connectionSource,Question.class);
//            TableUtils.createTable(connectionSource,ARCDetail.class);

            MCQ arc = new MCQ("Đề 1");
            getArcDAO().create(arc);

            Question objQuestion = new Question(
                    null,
                    "What your name",
                    "A","B","C","D",
                    Question.ANSWER_A,
                    MCQ.PART_1
            );
//            getQuestionDAO().create(objQuestion);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Unable to create datbases", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {

            // In case of change in database of next version of application, please increase the value of DATABASE_VERSION variable, then this method will be invoked
            //automatically. Developer needs to handle the upgrade logic here, i.e. create a new table or a new column to an existing table, take the backups of the
            // existing database etc.

            TableUtils.dropTable(connectionSource, MCQ.class, true);
            TableUtils.dropTable(connectionSource, Question.class, true);
//            TableUtils.dropTable(connectionSource, ARCDetail.class, true);
            onCreate(sqLiteDatabase, connectionSource);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + i + " to new "
                    + i1, e);
        }

    }

    public Dao<MCQ, Integer> getArcDAO() throws SQLException {
        if(arcDAO == null)
            arcDAO = getDao(MCQ.class);
        return arcDAO;
    }

   /* public Dao<ARCDetail, Integer> getArcDetailIntegerDao() throws SQLException {
        if(arcDetailIntegerDao == null)
            arcDetailIntegerDao = getDao(ARCDetail.class);
        return arcDetailIntegerDao;
    }*/

    public Dao<Question, Integer> getQuestionDAO() throws SQLException {
        if(questionDAO == null)
            questionDAO = getDao(Question.class);
        return questionDAO;
    }


}
