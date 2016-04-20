package ltdd.it.tdt.edu.vn.toeic.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.database.BundleConstant;

public class Part1 extends AppCompatActivity {
    android.app.Fragment frgMedia = null;
//    Button[] btnAnswer = new Button[Question.NUM_ANSWER];
    ImageView imageView = null;
    Button[] btnAction = new Button[2];
    ListView listView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);
       /* try {
            Bundle bundle = new Bundle();
            List<Question> objQuestionList = (List<Question>) bundle.getSerializable(BundleConstant.PART_1);
            if(objQuestionList == null)
                return;
            btnAnswer[Question.ANSWER_A] = (Button) findViewById(R.id.btnA1);
            btnAnswer[Question.ANSWER_B] = (Button) findViewById(R.id.btnB1);
            btnAnswer[Question.ANSWER_C] = (Button) findViewById(R.id.btnC1);
            btnAnswer[Question.ANSWER_D] = (Button) findViewById(R.id.btnD1);
            frgMedia = getFragmentManager().findFragmentById(R.id.frgMediaPart1);
            imageView = (ImageView) findViewById(R.id.imgPart1);
            btnAction[0] = (Button) findViewById(R.id.btnBackPart1);
            btnAction[1] = (Button) findViewById(R.id.btnFowardPart1);
            listView = (ListView) findViewById(R.id.lstAnswerKeyPart1);
            String[] answers = {objQuestionList.get(0).getAnswerA(),
                    objQuestionList.get(0).getAnswerB(),
                    objQuestionList.get(0).getAnswerC(),
                    objQuestionList.get(0).getAnswerD()
            };
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,answers);
            listView.setAdapter(adapter);
            Toast.makeText(this,objQuestionList.get(0).getCorrectAnswer(),Toast.LENGTH_LONG).show();
        }catch (Exception e){

        }*/

    }
}
