package com.example.nevigationdrawer;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nevigationdrawer.databinding.ActivityMainBinding;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "floating action button", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            }
        });

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                Toast.makeText(MainActivity.this, "Log Out", Toast.LENGTH_SHORT).show();
                break;

            case R.id.share:
                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings:
                Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                ProfileFragment profileFragment=new ProfileFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contentid,profileFragment);
                transaction.commit();
                break;

            case R.id.message:
                Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();
               MessageFragment messageFragment=new MessageFragment();
               FragmentTransaction transaction1=getSupportFragmentManager().beginTransaction();
               transaction1.replace(R.id.contentid,messageFragment);
               transaction1.commit();
                break;

            case R.id.inbox:
                Toast.makeText(MainActivity.this, "Inbox", Toast.LENGTH_SHORT).show();
               InboxFragment inboxFragment=new InboxFragment();
               FragmentTransaction transaction2=getSupportFragmentManager().beginTransaction();
               transaction2.replace(R.id.contentid,inboxFragment);
               transaction2.commit();
                break;
        }
        DrawerLayout layout=findViewById(R.id.drawer_layout);
        layout.closeDrawer(GravityCompat.START);
        return true;
    }

}
