package com.b18cn082.smart_money;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.b18cn082.smart_money.addapter.MyViewPagerAdapter;
import com.b18cn082.smart_money.fragment.FragmentCreatePlan;
import com.b18cn082.smart_money.fragment.FragmentPersonal;
import com.b18cn082.smart_money.fragment.FragmentReport;
import com.b18cn082.smart_money.fragment.FragmentSuggest;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent);
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.menu_suggest:
                        viewPager2.setCurrentItem(0, false);
                        break;
                    case R.id.menu_report:
                        viewPager2.setCurrentItem(1, false);
                        break;
                    case R.id.menu_create_plan:
                        viewPager2.setCurrentItem(2, false);
                        break;
                    case R.id.menu_personal:
                        viewPager2.setCurrentItem(3, false);
                        break;
                }
                return true;
            }
        });
        //change bottom nav bar when user slide screen
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_suggest).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.menu_report).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_create_plan).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.menu_personal).setChecked(true);
                        break;
                }
            }
        });


        // set up view pager 2
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        FragmentSuggest fragmentSuggest = new FragmentSuggest();
        FragmentReport fragmentReport = new FragmentReport();
        FragmentCreatePlan fragmentCreatePlan = new FragmentCreatePlan();
        FragmentPersonal fragmentPersonal = new FragmentPersonal();

        myViewPagerAdapter.addFragment(fragmentSuggest);
        myViewPagerAdapter.addFragment(fragmentReport);
        myViewPagerAdapter.addFragment(fragmentCreatePlan);
        myViewPagerAdapter.addFragment(fragmentPersonal);

        viewPager2.setAdapter(myViewPagerAdapter);
    }

    private void initView() {

        bottomNavigationView = findViewById(R.id.bottom_nav_bar);
        viewPager2 = findViewById(R.id.view_pager2_fragment_container);
        floatingActionButton = findViewById(R.id.floating_action_button);
    }

}