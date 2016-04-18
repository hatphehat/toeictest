package ltdd.it.tdt.edu.vn.toeic.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.database.BundleConstant;
import ltdd.it.tdt.edu.vn.toeic.database.DatabaseHelper;
import ltdd.it.tdt.edu.vn.toeic.object.ARC;

public class AvtListDeThi extends  AppCompatActivity {
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
            Log.d("dethis", String.valueOf(deThis.size()));
        GridView gridView = (GridView) findViewById(R.id.gridViewDeThi);
        CustomLayoutGridDeThi customLayoutGridDeThi = new CustomLayoutGridDeThi(this, R.layout.custom_grid, deThis);
        gridView.setAdapter(customLayoutGridDeThi);
            Bundle bundle = new Bundle();
            mode = bundle.getInt(BundleConstant.MODE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public class CustomLayoutGridDeThi extends ArrayAdapter {
        Context context;
        int resource;
        ArrayList<ARC> items;
        public CustomLayoutGridDeThi(Context context, int resource, ArrayList<ARC> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resource = resource;
            this.items = objects;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View row = LayoutInflater.from(context).inflate(resource,null);
            ImageView imageView = (ImageView) row.findViewById(R.id.imgGridDeThi);
            TextView textView = (TextView) row.findViewById(R.id.txtGridDeThi);
            textView.setText(items.get(position).getName());
            imageView.setImageResource(items.get(position).getImgResource());
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (mode){
                        case ARC.PART_1:
                            Intent intent = new Intent(AvtListDeThi.this,Part1.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable(BundleConstant.PART_1, (Serializable) deThis.get(position).getLstPart1());
                            startActivity(intent);
                            break;case ARC.PART_2:
                            break;case ARC.PART_3:
                            break;case ARC.PART_4:
                            break;case ARC.PART_5:
                            break;case ARC.PART_6:
                            break;case ARC.PART_7:
                            break;
                    }
                }
            });
            return row;
        }
    }
}
