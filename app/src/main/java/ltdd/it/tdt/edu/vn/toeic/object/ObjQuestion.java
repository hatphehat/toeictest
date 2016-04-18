package ltdd.it.tdt.edu.vn.toeic.object;

import android.support.annotation.NonNull;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by hph on 4/17/2016.
 */
public class ObjQuestion implements Serializable {
    private static final String ARC_ID_FIELD_NAME = "arc_id";
    public static int NUM_ANSWER = 4;
    public static int ANSWER_A = 0;
    public static int ANSWER_B = 1;
    public static int ANSWER_C= 2;
    public static int ANSWER_D= 3;
    @DatabaseField(id = true)
    private int id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true,columnName = ARC_ID_FIELD_NAME)
    private ARC arc;
    @DatabaseField
    private String question;
    @DatabaseField
    private String answerA;
    @DatabaseField
    private String answerB;
    @DatabaseField
    private String answerC;
    @DatabaseField
    private String answerD;
    @DatabaseField
    private int type;
    @DatabaseField
    private int correctAnswer;


    public ObjQuestion(ARC arc, String question, String answerA, String answerB, String answerC, String answerD, int type, int correctAnswer) {
        this.arc = arc;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.type = type;
        this.correctAnswer = correctAnswer;
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

    public ARC getArc() {
        return arc;
    }

    public void setArc(ARC arc) {
        this.arc = arc;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
