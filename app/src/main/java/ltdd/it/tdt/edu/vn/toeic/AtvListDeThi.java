package ltdd.it.tdt.edu.vn.toeic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

import ltdd.it.tdt.edu.vn.toeic.adapter.CustomLayoutGridDeThi;
import ltdd.it.tdt.edu.vn.toeic.object.DeThi;

public class AtvListDeThi extends AppCompatActivity {
    ArrayList<DeThi> deThis = new ArrayList<>();

    private void initDeThi() {
        for (int i = 1; i < 10; i++)
            deThis.add(new DeThi("Đề " + i, R.drawable.ic_launcher));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_de_thi);
        initDeThi();
        GridView gridView = (GridView) findViewById(R.id.gridViewDeThi);
        CustomLayoutGridDeThi customLayoutGridDeThi = new CustomLayoutGridDeThi(this, R.layout.custom_grid, deThis);
        gridView.setAdapter(customLayoutGridDeThi);
    }
}
