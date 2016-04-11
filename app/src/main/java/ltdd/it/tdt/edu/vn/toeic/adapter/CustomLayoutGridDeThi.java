package ltdd.it.tdt.edu.vn.toeic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.object.DeThi;

/**
 * Created by hph on 4/9/2016.
 */
public class CustomLayoutGridDeThi extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<DeThi> items;
    public CustomLayoutGridDeThi(Context context, int resource, ArrayList<DeThi> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.items = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = LayoutInflater.from(context).inflate(resource,null);
        ImageView imageView = (ImageView) row.findViewById(R.id.imgGridDeThi);
        TextView textView = (TextView) row.findViewById(R.id.txtGridDeThi);
        textView.setText(items.get(position).getText());
        imageView.setImageResource(items.get(position).getImgResource());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        return row;
    }
}
