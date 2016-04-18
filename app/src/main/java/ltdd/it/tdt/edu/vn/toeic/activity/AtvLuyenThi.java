package ltdd.it.tdt.edu.vn.toeic.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.util.List;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.database.BundleConstant;
import ltdd.it.tdt.edu.vn.toeic.database.DatabaseHelper;
import ltdd.it.tdt.edu.vn.toeic.object.ARC;


public class AtvLuyenThi extends AppCompatActivity {
    private final int SRC = R.drawable.photos;
    public static final int LISTEN = 0;
    public static final int READ = 1;

    private ListView lstListen = null;
    private ListView lstRead = null;

    private Item[][] items = new Item[2][];
    private List<ARC> lstARC = null;

    private CustomLayoutListView layoutRead;
    private CustomLayoutListView layoutListen;

    private DatabaseHelper databaseHelper = null;
    private DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this,DatabaseHelper.class);
        }
        return databaseHelper;
    }

    private void initItem() {
        items[LISTEN] = new Item[]{
                new Item(SRC, "Photos"),
                new Item(SRC, "Question - Response"),
                new Item(SRC, "Short Conversations"),
                new Item(SRC, "Short Talks")
        };
        items[READ] = new Item[]{
                new Item(SRC, "Incomplete Sentences",Item.READING),
                new Item(SRC, "Text Completion",Item.READING),
                new Item(SRC, "Short Conversations",Item.READING),
                new Item(SRC, "Reading Comprehension",Item.READING)
        };
    }

    private void initCustomLayout() {
        layoutListen = new CustomLayoutListView(this, R.layout.custom_list, items[LISTEN]);
        layoutRead = new CustomLayoutListView(this, R.layout.custom_list, items[READ]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_thi);
        initItem();
        initCustomLayout();

        lstListen = (ListView) findViewById(R.id.lstListen);
        lstRead = (ListView) findViewById(R.id.lstRead);
        if (layoutListen != null)
            lstListen.setAdapter(layoutListen);
        if (layoutRead != null)
            lstRead.setAdapter(layoutRead);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_de_thi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

		/*
		 * You'll need this in your class to release the helper when done.
		 */
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }

    class CustomLayoutListView extends ArrayAdapter {
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            View row = layoutInflater.inflate(resource, null);
            TextView textView = (TextView) row.findViewById(R.id.txtListView);
            ImageView imageView= (ImageView) row.findViewById(R.id.imgListView);
            textView.setText(item[position].getText());
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(item[0].type == Item.LISTEN)
                    switch (position){
                        case 0:
                            Intent intent = new Intent(AtvLuyenThi.this,AvtListDeThi.class);
                            intent.putExtra(BundleConstant.MODE,ARC.PART_1);
                            startActivity(intent);
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    if(item[0].type == Item.READING)
                        switch (position){
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                }
            });
            imageView.setImageResource(item[position].getSrcImage());
            return row;
        }

    }
    class Item {
        public static final int LISTEN = 0;
        public static final int READING = 1;
        private String text;
        private int srcImage;
        private int type;
        public Item(int srcImage, String text) {
            this.srcImage = srcImage;
            this.text = text;
            this.type = LISTEN;
        }
        public Item(int srcImage, String text,int type) {
            this.srcImage = srcImage;
            this.text = text;
            this.type = type;
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
}


