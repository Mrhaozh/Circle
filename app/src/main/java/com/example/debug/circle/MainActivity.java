package com.example.debug.circle;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.debug.circle.customcommentlist.CommentAdapter;
import com.example.debug.circle.customcommentlist.CommentItem;
import com.example.debug.circle.customcommentlist.CommentListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView
        .OnNavigationItemSelectedListener {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private CommentListView commentListView;
    private List<CommentItem> list;
    private CommentAdapter commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R
                .string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //设置navigationview的menu监听 navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void initdata() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new CommentItem("ace", "0", "你好", i + "", "zz", "1"));
        }
    }

    private void initview() {
        commentListView = findViewById(R.id.commentlist);
        commentAdapter = new CommentAdapter(this, list);
        commentListView.setAdapter(commentAdapter);
        commentListView.setOnItemClickListener(new CommentListView.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "zz", Toast.LENGTH_SHORT).show();
            }
        });
        commentListView.setOnItemLongClickListener(new CommentListView.onItemLongClickListener() {
            @Override
            public void onItemLongClick(int position) {
                Toast.makeText(MainActivity.this, "zzzz", Toast.LENGTH_SHORT).show();
            }
        });
        commentAdapter.notifyDataSetChanged();
    }
}
