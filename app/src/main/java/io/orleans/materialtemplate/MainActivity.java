package io.orleans.materialtemplate;

import android.content.res.Configuration;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    FloatingActionButton fabBtn;
	CoordinatorLayout rootLayout;
	Toolbar toolbar;
	NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInstances();
    }

    private void initInstances() {
	    toolbar = (Toolbar) findViewById(R.id.toolbar);
	    setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.hello_world, R.string.hello_world);
        drawerLayout.setDrawerListener(drawerToggle);

	    rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	    navigation = (NavigationView) findViewById(R.id.navigation);
	    navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
		    @Override
		    public boolean onNavigationItemSelected (MenuItem menuItem) {
			    int id = menuItem.getItemId();
			    switch (id) {
				    case R.id.navItem1:
					    break;
				    case R.id.navItem2:
					    break;
				    case R.id.navItem3:
					    break;
			    }
			    return false;
		    }
	    });

	    fabBtn = (FloatingActionButton) findViewById(R.id.fabBtn);
	    fabBtn.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick (View v) {
			    Snackbar.make(rootLayout, "Hello. I am Snackbar!", Snackbar.LENGTH_SHORT)
					    .setAction("Done", new View.OnClickListener() {
						    @Override
						    public void onClick(View v) {
//							    ((Snackbar) v).dismiss();
						    }
					    })
					    .show();
		    }
	    });
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
