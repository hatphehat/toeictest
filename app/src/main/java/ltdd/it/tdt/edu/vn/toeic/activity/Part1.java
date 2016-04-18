package ltdd.it.tdt.edu.vn.toeic.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.database.BundleConstant;
import ltdd.it.tdt.edu.vn.toeic.object.ObjQuestion;

public class Part1 extends AppCompatActivity {
    android.app.Fragment frgMedia = null;
    Button[] btnAnswer = new Button[ObjQuestion.NUM_ANSWER];
    ImageView imageView = null;
    Button[] btnAction = new Button[2];
    ListView listView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part1);
        try {
            List<ObjQuestion> objQuestionList = (List<ObjQuestion>) getIntent().getExtras().getSerializable(BundleConstant.PART_1);
            if(objQuestionList == null)
                return;
            btnAnswer[ObjQuestion.ANSWER_A] = (Button) findViewById(R.id.btnA1);
            btnAnswer[ObjQuestion.ANSWER_B] = (Button) findViewById(R.id.btnB1);
            btnAnswer[ObjQuestion.ANSWER_C] = (Button) findViewById(R.id.btnC1);
            btnAnswer[ObjQuestion.ANSWER_D] = (Button) findViewById(R.id.btnD1);
            frgMedia = getFragmentManager().findFragmentById(R.id.frgMediaPart1);
            imageView = (ImageView) findViewById(R.id.imgPart1);
            btnAction[0] = (Button) findViewById(R.id.btnBackPart1);
            btnAction[1] = (Button) findViewById(R.id.btnFowardPart1);
            listView = (ListView) findViewById(R.id.lstAnswerKeyPart1);
            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,objQuestionList.get(0).getAnswer());
            listView.setAdapter(adapter);
        }catch (Exception e){

        }

    }
}
