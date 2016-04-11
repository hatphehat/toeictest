package ltdd.it.tdt.edu.vn.toeic.object;

/**
 * Created by hph on 4/9/2016.
 */
public class ObjQuestion {
    public final int ANSWER_A = 0;
    public final int ANSWER_B = 1;
    public final int ANSWER_C = 2;
    public final int ANSWER_D = 3;
    String content;
    String[] answer;

    private boolean initAnswer(String[] answer) {
        if (answer.length == 0)
            return false;
        int length = answer.length;
        this.answer = new String[length];
        for (int i = 0; i < length; i++) {
            this.answer[i] = answer[i];
        }
        return true;
    }

    public ObjQuestion(String content, String[] answer) {
        this.content = content;
        this.initAnswer(answer);

    }
}
