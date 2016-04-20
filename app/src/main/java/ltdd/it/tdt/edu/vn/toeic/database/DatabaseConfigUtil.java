package ltdd.it.tdt.edu.vn.toeic.database;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import ltdd.it.tdt.edu.vn.toeic.object.Question;
import ltdd.it.tdt.edu.vn.toeic.object.MCQ;

/**
 * Created by hph on 4/17/2016.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    private static final Class<?>[] classes = new Class[] {MCQ.class, Question.class};
    public static void main(String[] args) throws SQLException, IOException {

        // Provide the name of .txt file which you have already created and kept in res/raw directory
        String currDirectory = "user.dir";


               String configPath = "/app/src/main/res/raw/ormlite_config.txt";


               /**
         28          * Gets the project root directory
         29          */
               String projectRoot = System.getProperty(currDirectory);


               /**
         33          * Full configuration path includes the project root path, and the location
         34          * of the ormlite_config.txt file appended to it
         35          */
               String fullConfigPath = projectRoot + configPath;


                 File configFile = new File(fullConfigPath);
             if(configFile.exists()) {
                         configFile.delete();
                         configFile = new File(fullConfigPath);
                   }
             /**
         50          * writeConfigFile is a util method used to write the necessary configurations
         51          * to the ormlite_config.txt file.
         52          */
              writeConfigFile(configFile, classes);

    }

}
