package ltdd.it.tdt.edu.vn.toeic.object;

/**
 * Created by hph on 4/9/2016.
 */
public class DeThi {
    private String text;
    private int imgResource;

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
