package com.innerworkindia.jobseeker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

public class ContactUs extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private AppBarLayout appBarLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private static final String SHARED_PREF_NAME="jobseeker";
    private static final String KEY_EMAIL="email";
    private static final String KEY_UID="userid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);


        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Contact Us");
        navigationView=findViewById(R.id.navigation_view);
        drawerLayout=findViewById(R.id.drawer);


        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        editor=sharedPreferences.edit();

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        View head=navigationView.getHeaderView(0);
        TextView n1=head.findViewById(R.id.header_name);
        TextView e1=head.findViewById(R.id.header_email);
        ImageView i1=head.findViewById(R.id.header_logo);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ContactUs.this,Profile.class));
            }
        });

        String a=sharedPreferences.getString(KEY_EMAIL,"abc@example.com");
        String b=sharedPreferences.getString(KEY_UID,"Hello World");
        n1.setText(b);
        e1.setText(a);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.internships:
                        startActivity(new Intent(ContactUs.this,HomeActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.contactus:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.applied:
                        startActivity(new Intent(ContactUs.this, Applied.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.profile:
                        startActivity(new Intent(ContactUs.this, Profile.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.aboutus:
                        startActivity(new Intent(ContactUs.this,AboutUs.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.logout:
                        editor.clear();
                        startActivity(new Intent(ContactUs.this,LoginActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}