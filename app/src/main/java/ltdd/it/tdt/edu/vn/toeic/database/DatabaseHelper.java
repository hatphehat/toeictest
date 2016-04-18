package ltdd.it.tdt.edu.vn.toeic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.object.ARC;
import ltdd.it.tdt.edu.vn.toeic.object.ObjQuestion;

/**
 * Created by hph on 4/17/2016.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "toeic.db";
    private static final int DATABASE_VERSION = 2;
    private Dao<ARC,Integer> arcDAO;
    private Dao<ObjQuestion,Integer> questionDAO;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION,R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            arcDAO = DaoManager.createDao(connectionSource,ARC.class);
            questionDAO= DaoManager.createDao(connectionSource,ObjQuestion.class);
            TableUtils.createTable(connectionSource,ARC.class);
            TableUtils.createTable(connectionSource,ObjQuestion.class);

            ARC arc = new ARC();
            arc.setName("Đề 1");
            arcDAO.create(arc);

            ObjQuestion objQuestion = new ObjQuestion(
                    arc,
                    "What your name",
                    "A","B","C","D",
                    ObjQuestion.ANSWER_A,
                    ARC.PART_1
            );
            questionDAO.create(objQuestion);

            ARC current = arcDAO.queryForId(arc.getId());
            ForeignCollection<ObjQuestion> objQuestions = current.getLstPart1();
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

            TableUtils.dropTable(connectionSource, ARC.class, true);
            onCreate(sqLiteDatabase, connectionSource);

        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Unable to upgrade database from version " + i + " to new "
                    + i1, e);
        }

    }

    public Dao<ARC, Integer> getArcDAO() throws SQLException {
        if(arcDAO == null)
            arcDAO = getDao(ARC.class);
        return arcDAO;
    }
}
