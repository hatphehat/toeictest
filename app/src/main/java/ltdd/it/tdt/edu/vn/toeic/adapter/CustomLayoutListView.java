package ltdd.it.tdt.edu.vn.toeic.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ltdd.it.tdt.edu.vn.toeic.activity.AtvListDeThi;
import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.object.DeThi;
import ltdd.it.tdt.edu.vn.toeic.object.Item;

/**
 * Created by hph on 4/8/2016.
 */
public class CustomLayoutListView extends ArrayAdapter implements View.OnClickListener {
    Context context;
    int resource;
    Item item[];
    public CustomLayoutListView(Context context, int resource, Item[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.item = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        View row = layoutInflater.inflate(resource, null);
        TextView textView = (TextView) row.findViewById(R.id.txtListView);
        ImageView imageView= (ImageView) row.findViewById(R.id.imgListView);
        textView.setText(item[position].getText());
        textView.setOnClickListener(this);
        imageView.setImageResource(item[position].getSrcImage());
        return row;
    }

    @Override
    public void onClick(View v) {

        Bundle bundle = new Bundle();
        ArrayList<DeThi> deThis = new ArrayList<>();
        deThis.add(new DeThi("A",R.drawable.ic_launcher));
        bundle.putSerializable("dethi",deThis);
        Intent intent = new Intent(context, AtvListDeThi.class);
        intent.putExtra("BundleDeThiPhotos",bundle);
        context.startActivity(intent);
    }
}
