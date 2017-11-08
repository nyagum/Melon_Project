package melon.project.com.melon_proj;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class SearchSongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_song);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar_search);
        toolbar.setTitle("검색");
        Log.e("toolbar",toolbar.getWidth()/2+"");
        toolbar.setTitleMarginStart(toolbar.getWidth()/2);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_withexitbutton, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemIndex=item.getItemId();
        if(itemIndex==R.id.action_exit){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
