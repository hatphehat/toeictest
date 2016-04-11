package ltdd.it.tdt.edu.vn.toeic.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.adapter.CustomLayoutListView;
import ltdd.it.tdt.edu.vn.toeic.object.Item;


public class AtvLuyenThi extends AppCompatActivity {
    private final int SRC = R.drawable.photos;
    private final int LISTEN = 0;
    private final int READ = 1;
    private ListView lstListen;
    private ListView lstRead;
    private Item[][] items = new Item[2][];
    private CustomLayoutListView layoutRead;
    private CustomLayoutListView layoutListen;

    private void initItem() {
        items[LISTEN] = new Item[]{new Item(SRC, "Photos"),
                new Item(SRC, "Question - Response"),
                new Item(SRC, "Short Conversations"),
                new Item(SRC, "Short Talks")
        };
        items[READ] = new Item[]{new Item(SRC, "Incomplete Sentences"),
                new Item(SRC, "Text Completion"),
                new Item(SRC, "Short Conversations"),
                new Item(SRC, "Reading Comprehension")
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
}
