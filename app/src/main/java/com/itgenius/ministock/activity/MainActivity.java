package com.itgenius.ministock.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itgenius.ministock.R;
import com.itgenius.ministock.fragment.nav.AccountFragment;
import com.itgenius.ministock.fragment.nav.HomeFragment;
import com.itgenius.ministock.fragment.nav.NotificationFragment;
import com.itgenius.ministock.fragment.nav.ReportFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;  // เรียกใช้ Toolbar
    BottomNavigationView bottomNavigation; // เรียกใช้เมนู bottomNavigation

    // การเรียกใช้ Fragment
    final Fragment homeFragment = new HomeFragment();
    final Fragment reportFragment = new ReportFragment();
    final Fragment notificationFragment = new NotificationFragment();
    final Fragment accountFragment = new AccountFragment();

    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = homeFragment; // Fragment ตัวแรกที่ทำงานตอนเปิดแอพ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ผูกตัวแปร toolbar ใน xml
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_title);

        // ผูกตัวแปร bottomNavigation ใน xml
        bottomNavigation = findViewById(R.id.bottom_navigation);

        // กำหนดเหตุการณ์กดเมนู bottomNavigation
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // การเรียกใช้ Fragment และปิดหน้า Fragment
        fm.beginTransaction().add(R.id.main_container, homeFragment, "1").commit();
        fm.beginTransaction().add(R.id.main_container, reportFragment, "2").hide(reportFragment).commit();
        fm.beginTransaction().add(R.id.main_container, notificationFragment, "3").hide(notificationFragment).commit();
        fm.beginTransaction().add(R.id.main_container, accountFragment, "4").hide(accountFragment).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch(item.getItemId()){
                case R.id.navhome:
                    fm.beginTransaction().hide(active).show(homeFragment).commit();
                    active = homeFragment;
                    getSupportActionBar().setTitle(R.string.nav_home);
                    return true;
                case R.id.navreport:
                    fm.beginTransaction().hide(active).show(reportFragment).commit();
                    active = reportFragment;
                    getSupportActionBar().setTitle(R.string.nav_report);
                    return true;
                case R.id.navnotification:
                    fm.beginTransaction().hide(active).show(notificationFragment).commit();
                    active = notificationFragment;
                    getSupportActionBar().setTitle(R.string.nav_notification);
                    return true;
                case R.id.navaccount:
                    fm.beginTransaction().hide(active).show(accountFragment).commit();
                    active = accountFragment;
                    getSupportActionBar().setTitle(R.string.nav_account);
                    return true;
            }
            return false;
        }
    };
}