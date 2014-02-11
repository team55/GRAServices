package ru.team55.gra.rating;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;

/*
* Фрагмент навигации
*
* тут сосредоточена основная логика вызова процедур
* */



@Fullscreen
@EActivity(R.layout.activity_main)
public class main extends ActionBarActivity
        implements NavigationFragment.NavigationDrawerCallbacks {

    public static final String TAG = main.class.getSimpleName();

    private NavigationFragment mNavigationDrawerFragment;

    private CharSequence lastTitle;
    private CharSequence lastSubTitle;


    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lastTitle = getTitle();
    }

    @AfterViews
    void setupUi(){

        mNavigationDrawerFragment = (NavigationFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, drawerLayout);
    }





    @Override
    public void onNavigationDrawerItemSelected(navigationPages requestedPage) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = null;
        if(requestedPage==navigationPages.Main) fragment = new RegisterFragment_();

        if(requestedPage==navigationPages.Login)    fragment = new LoginFragment_();
        if(requestedPage==navigationPages.Register) fragment = new RegisterFragment_();

        if(fragment!=null)
            fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(lastTitle);
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                lastTitle = getString(R.string.title_section1);
                break;
            case 2:
                lastTitle = getString(R.string.title_section2);
                break;
            case 3:
                lastTitle = getString(R.string.title_section3);
                break;
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawerLayout is not showing. Otherwise, let the drawerLayout
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
