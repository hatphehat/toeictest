package ltdd.it.tdt.edu.vn.toeic.object;

import android.support.annotation.NonNull;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by hph on 4/17/2016.
 */
public class ObjQuestion {
    public static int NUM_ANSWER = 4;
    public static int ANSWER_A = 0;
    public static int ANSWER_B = 1;
    public static int ANSWER_C= 2;
    public static int ANSWER_D= 3;
    @DatabaseField(id = true)
    protected String id;
    @DatabaseField
    protected String question;
    @DatabaseField
    protected String[] answer;
    @DatabaseField
    protected int type;
    @DatabaseField
    protected int correctAnswer;

    public ObjQuestion(@NonNull String question, @NonNull String[] answer, @NonNull int correctAnswer, @NonNull int type) {
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
        this.type = type;
    }

    public ObjQuestion(@NonNull String question, @NonNull String A, @NonNull String B, @NonNull String C, String D, @NonNull int correctAnswer, @NonNull int type) {
        if(type == ARC.PART_2) {
            answer = new String[NUM_ANSWER - 1];
            answer[ANSWER_A] = A; answer[ANSWER_B]=B;answer[ANSWER_C]=C;
        }else{
            answer = new String[NUM_ANSWER];
            answer[ANSWER_A] = A; answer[ANSWER_B]=B;answer[ANSWER_C]=C;answer[ANSWER_D]=D;
        }
        this.question=question;this.correctAnswer=correctAnswer;
        this.type = type;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }
}
