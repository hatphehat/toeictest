package ltdd.it.tdt.edu.vn.toeic.object;

import java.io.Serializable;

/**
 * Created by hph on 4/9/2016.
 */
public class DeThi implements Serializable {
    public static int PART_1 = 0;
    public static int PART_2 = 1;
    public static int PART_3 = 2;
    public static int PART_4 = 3;
    public static int PART_5 = 4;
    public static int PART_6 = 5;
    private String text;
    private int imgResource;
    private ObjQuestion[] questions;

    public ObjQuestion[] getQuestions() {
        return questions;
    }

    public DeThi(ObjQuestion[] questions) {
        this.questions = questions;
    }

    public String getText() {
        return text;
    }

    public int getImgResource() {
        return imgResource;
    }

    public DeThi(String text, int imgResource) {
        this.text = text;
        this.imgResource = imgResource;
    }
}
