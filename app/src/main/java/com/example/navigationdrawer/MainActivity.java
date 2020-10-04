package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        navigationView=findViewById(R.id.navigation);
        drawer=findViewById(R.id.drawer);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                switch (item.getItemId()){
                    case R.id.myaccount:
                        Toast.makeText(MainActivity.this, "Myaccount", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.wishlist:
                        Toast.makeText(MainActivity.this, "This is your wishlist", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.lfr:
                        Toast.makeText(MainActivity.this, "Are u looking for a mate", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.about:
                        Toast.makeText(MainActivity.this, "About US", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(MainActivity.this, "Opneing settings", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });


        View view = navigationView.getHeaderView(0);
        TextView email = view.findViewById(R.id.Email);
        TextView name = view.findViewById(R.id.Name);

         email.setText("abz123@gmail.com");
         name.setText("abz xyz");


    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
}