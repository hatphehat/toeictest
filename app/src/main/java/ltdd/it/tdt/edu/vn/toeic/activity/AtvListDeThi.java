package ltdd.it.tdt.edu.vn.toeic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.adapter.CustomLayoutGridDeThi;
import ltdd.it.tdt.edu.vn.toeic.object.DeThi;

public class AtvListDeThi extends  AppCompatActivity implements AdapterView.OnItemClickListener{
    ArrayList<DeThi> deThis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_de_thi);
        Intent callerIntent = getIntent();
        if(callerIntent != null) {
            Bundle bundle = callerIntent.getBundleExtra("BundleDeThiPhotos");
            if(bundle != null) {
                deThis = (ArrayList<DeThi>) bundle.getSerializable("dethi");
                if (deThis != null && !deThis.isEmpty()) {
                    GridView gridView = (GridView) findViewById(R.id.gridViewDeThi);
                    CustomLayoutGridDeThi customLayoutGridDeThi = new CustomLayoutGridDeThi(this, R.layout.custom_grid, deThis);
                    gridView.setAdapter(customLayoutGridDeThi);
                    gridView.setOnItemClickListener(this);
                }
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
