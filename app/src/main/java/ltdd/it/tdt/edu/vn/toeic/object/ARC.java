package ltdd.it.tdt.edu.vn.toeic.object;

import java.io.Serializable;
import java.util.List;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

/**
 * Created by hph on 4/9/2016.
 */
public class ARC implements Serializable {
    public static final int NUM_PART = 8;
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
    @ForeignCollectionField(foreignFieldName = "part1")
    private ForeignCollection<ObjQuestion> lstPart1;
    @ForeignCollectionField(foreignFieldName = "part2")
    private ForeignCollection<ObjQuestion> lstPart2;
    @ForeignCollectionField(foreignFieldName = "part3")
    private ForeignCollection<ObjQuestion> lstPart3;
    @ForeignCollectionField(foreignFieldName = "part4")
    private ForeignCollection<ObjQuestion> lstPart4;
    @ForeignCollectionField(foreignFieldName = "part5")
    private ForeignCollection<ObjQuestion> lstPart5;
    @ForeignCollectionField(foreignFieldName = "part6")
    private ForeignCollection<ObjQuestion> lstPart6;
    @ForeignCollectionField(foreignFieldName = "part7")
    private ForeignCollection<ObjQuestion> lstPart7;
    @ForeignCollectionField(foreignFieldName = "part8")
    private ForeignCollection<ObjQuestion> lstPart8;
    @DatabaseField
    private String name;
    private int imgResource;

    public ARC() {
    }

    public int getId() {
        return id;
    }

    public ForeignCollection<ObjQuestion> getLstPart1() {
        return lstPart1;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
