package melon.project.com.melon_proj.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import melon.project.com.melon_proj.R;
import melon.project.com.melon_proj.adapter.ChartAdapter;
import melon.project.com.melon_proj.adapter.RecentMusicAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("Melon");
//        toolbar.setTitleTextColor(Color.GREEN);

        setSupportActionBar(toolbar);

        // Drawer Layout
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        // Navigation View
        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // 최신음악 RecyclerView
        RecyclerView recent_music_recycler_view = findViewById(R.id.recent_music_recycler_view);
        RecentMusicAdapter rmAdapter = new RecentMusicAdapter();
        recent_music_recycler_view.setAdapter(rmAdapter);
        recent_music_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        // 차트 RecyclerView
        RecyclerView chart_recycler_view = findViewById(R.id.chart_recycler_view);
        ChartAdapter cAdapter = new ChartAdapter();
        chart_recycler_view.setAdapter(cAdapter);
        chart_recycler_view.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            //TODO Activity 전환
            case R.id.nav_home:
                break;
            case R.id.nav_recenct:
                break;
            case R.id.nav_chart:
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            //added by B
            Intent intent=new Intent(MainActivity.this, SearchSongActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void songDetailPage(View view) {
        Intent intent = new Intent(MainActivity.this, SongDetailActivity.class);
        startActivity(intent);
    }
}