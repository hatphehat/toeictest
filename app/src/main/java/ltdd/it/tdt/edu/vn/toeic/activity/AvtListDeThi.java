package ltdd.it.tdt.edu.vn.toeic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.adapter.CustomLayoutGridDeThi;
import ltdd.it.tdt.edu.vn.toeic.database.BundleConstant;
import ltdd.it.tdt.edu.vn.toeic.database.DatabaseHelper;
import ltdd.it.tdt.edu.vn.toeic.object.ARC;

public class AvtListDeThi extends  AppCompatActivity implements AdapterView.OnItemClickListener{
    ArrayList<ARC> deThis;
    int mode = -1;
    private DatabaseHelper databaseHelper = null;
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this,DatabaseHelper.class);
        }
        return databaseHelper;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_de_thi);
        try {
            List<ARC> arcList =  getHelper().getArcDAO().queryForAll();
            deThis = (ArrayList<ARC>) arcList;

        GridView gridView = (GridView) findViewById(R.id.gridViewDeThi);
        CustomLayoutGridDeThi customLayoutGridDeThi = new CustomLayoutGridDeThi(this, R.layout.custom_grid, deThis);
        gridView.setAdapter(customLayoutGridDeThi);
        gridView.setOnItemClickListener(this);
        Intent callerIntent = getIntent();
        if(callerIntent != null) {
            mode = callerIntent.getIntExtra(BundleConstant.MODE,0);
            Log.d("mode", String.valueOf(mode));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
switch (mode){
    case ARC.PART_1:
        Intent intent = new Intent(AvtListDeThi.this,Part1.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(BundleConstant.PART_1, (Serializable) deThis.get(position).getLstPart1());
        intent.putExtras(bundle);
        break;case ARC.PART_2:
        break;case ARC.PART_3:
        break;case ARC.PART_4:
        break;case ARC.PART_5:
        break;case ARC.PART_6:
        break;case ARC.PART_7:
        break;
}
    }
}
