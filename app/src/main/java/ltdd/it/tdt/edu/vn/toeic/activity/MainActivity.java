package ltdd.it.tdt.edu.vn.toeic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import ltdd.it.tdt.edu.vn.toeic.R;
import ltdd.it.tdt.edu.vn.toeic.object.MCQ;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnDeThi;
    private Button btnLuyenThi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLuyenThi = (Button) findViewById(R.id.btnLuyenThi);
        btnDeThi = (Button) findViewById(R.id.btnDeThi);
        btnDeThi.setOnClickListener(this);
        btnLuyenThi.setOnClickListener(this);
        MCQ mcq = new MCQ();
        savedInstanceState.putSerializable("MCQ",mcq);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.equals(btnLuyenThi)) {
            intent = new Intent(MainActivity.this, AtvLuyenThi.class);
            startActivity(intent);
        }
        if(v.equals(btnDeThi)){
            intent = new Intent(MainActivity.this,AvtListDeThi.class);
            startActivity(intent);
        }
    }
}
