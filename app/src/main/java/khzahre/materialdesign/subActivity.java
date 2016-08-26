package khzahre.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by mehdi_j on 8/3/2016.
 */
public class subActivity extends ActionBarActivity {
    private Toolbar tb ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity);


        tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_page_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.alter:
                Toast.makeText(this, "alternative option selected",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.setting:
                startActivity(new Intent(this, subActivity.class));
                System.out.println("click method is handle!");
                break;
            case android.R.id.home:
                System.out.println("click method is handle!");
                NavUtils.navigateUpFromSameTask(this);

        }
        return true;
    }

}
