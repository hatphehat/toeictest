package ltdd.it.tdt.edu.vn.toeic.object;

import java.io.Serializable;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by hph on 4/9/2016.
 */
public class ARC implements Serializable {
    public static final int NUM_PART = 6;
    public static final int PART_1 = 0;
    public static final int PART_2 = 1;
    public static final int PART_3 = 2;
    public static final int PART_4 = 3;
    public static final int PART_5 = 4;
    public static final int PART_6 = 5;
    public static final int PART_7 = 6;
    public static final int PART_8 = 7;
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private List<ObjQuestion> lstPart1;
    private List<ObjQuestion> lstPart2;
    private List<ObjQuestion> lstPart3;
    private List<ObjQuestion> lstPart4;
    private List<ObjQuestion> lstPart5;
    private List<ObjQuestion> lstPart6;
    private List<ObjQuestion> lstPart7;
    private List<ObjQuestion> lstPart8;
    @DatabaseField
    private String text;
    private int imgResource;

    public ARC() {
    }

    public void setLstPart1(List<ObjQuestion> lstPart1) {
        this.lstPart1 = lstPart1;
    }

    public List<ObjQuestion> getLstPart2() {
        return lstPart2;
    }

    public void setLstPart2(List<ObjQuestion> lstPart2) {
        this.lstPart2 = lstPart2;
    }

    public List<ObjQuestion> getLstPart3() {
        return lstPart3;
    }

    public void setLstPart3(List<ObjQuestion> lstPart3) {
        this.lstPart3 = lstPart3;
    }

    public List<ObjQuestion> getLstPart4() {
        return lstPart4;
    }

    public void setLstPart4(List<ObjQuestion> lstPart4) {
        this.lstPart4 = lstPart4;
    }

    public List<ObjQuestion> getLstPart5() {
        return lstPart5;
    }

    public void setLstPart5(List<ObjQuestion> lstPart5) {
        this.lstPart5 = lstPart5;
    }

    public List<ObjQuestion> getLstPart6() {
        return lstPart6;
    }

    public void setLstPart6(List<ObjQuestion> lstPart6) {
        this.lstPart6 = lstPart6;
    }

    public List<ObjQuestion> getLstPart7() {
        return lstPart7;
    }

    public void setLstPart7(List<ObjQuestion> lstPart7) {
        this.lstPart7 = lstPart7;
    }

    public List<ObjQuestion> getLstPart8() {
        return lstPart8;
    }

    public void setLstPart8(List<ObjQuestion> lstPart8) {
        this.lstPart8 = lstPart8;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public List<ObjQuestion> getLstPart1() {
        return lstPart1;
    }

    public String getText() {
        return text;
    }

    public int getImgResource() {
        return imgResource;
    }

    public ARC(String text, int imgResource) {
        this.text = text;
        this.imgResource = imgResource;
    }
}
