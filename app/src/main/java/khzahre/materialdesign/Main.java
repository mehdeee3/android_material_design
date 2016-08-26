package khzahre.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by mehdi_j on 8/3/2016.
 */
public class Main extends ActionBarActivity implements View.OnClickListener{
    private Toolbar tb ;
    private Button btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        Drawer drawer = (Drawer) getSupportFragmentManager().findFragmentById(R.id.drawer);
        drawer.setUp(R.id.drawer ,(DrawerLayout)findViewById(R.id.drawer_layout), tb);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6 = (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(this);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_page_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.alter:
                Toast.makeText(this , "alternative option selected",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.setting:
                startActivity(new Intent(this, subActivity.class));
                break;

        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                startActivity(new Intent(this, FixedTabs.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, ScrollableTabs.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, IconTextTabs.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, OnlyIcons.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this, Custom_tab.class));
                break;
            case R.id.button6:
                startActivity(new Intent(this, CardView.class));
                break;



        }
    }
}
