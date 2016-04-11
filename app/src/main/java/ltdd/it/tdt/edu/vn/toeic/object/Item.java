package ltdd.it.tdt.edu.vn.toeic.object;

/**
 * Created by hph on 4/9/2016.
 */
public class Item {
    private String text;
    private int srcImage;
    public Item(int srcImage, String text) {
        this.srcImage = srcImage;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(int srcImage) {
        this.srcImage = srcImage;
    }
}
