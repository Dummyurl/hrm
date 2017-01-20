package com.ourdesignz.hrm.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.gabrielsamojlo.keyboarddismisser.KeyboardDismisser;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ourdesignz.hrm.R;
import com.ourdesignz.hrm.fragment.ApplyForLeaveFragment;
import com.ourdesignz.hrm.fragment.FragmentDrawer;
import com.ourdesignz.hrm.fragment.HomeFragment;
import com.ourdesignz.hrm.fragment.MyLeaveFragment;
import com.ourdesignz.hrm.interfaces.Constant;
import com.ourdesignz.hrm.interfaces.GetDays;
import com.ourdesignz.hrm.interfaces.RestClient;
import com.ourdesignz.hrm.model.LogInPOJO;
import com.ourdesignz.hrm.model.LogOutPOJO;
import com.ourdesignz.hrm.prefrence.Prefrence;
import com.ourdesignz.hrm.utilities.Utilitity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ourdesignz on 22/9/16.
 */
public class HomeActivity extends AppCompatActivity implements Constant,
        FragmentDrawer.FragmentDrawerListener, Callback<LogOutPOJO>, GetDays {

    private static String TAG = HomeActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private CoordinatorLayout coordinatorLayout;
    private ProgressBar progressBar;
    private LogInPOJO.User user;
    private static HomeActivity mContext;
    private boolean isLoadFirstTime = false;
    private String days = "";

    // HomeActivity Instance
    public static HomeActivity getInstance() {
        return mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Hide KeyBoard When Touch Outside */
        KeyboardDismisser.useWith(this);

        mContext = HomeActivity.this;

        /* Get User Information */
        user = Prefrence.getUser(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        drawerFragment = (FragmentDrawer) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        drawerFragment.setUserInformation(user);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        // display the first navigation drawer view on app launch
        displayView(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            if (Utilitity.isNetworkAvailable(getApplicationContext())) {

                TapTargetView.showFor(this,                 // `this` is an Activity
                        TapTarget.forView(findViewById(R.id.action_logout),
                                Utilitity.setTypeFace(this, getString(R.string.logout)),
                                Utilitity.setTypeFace(this, getString(R.string.logout_from_here)))
                                // All options below are optional
                                .outerCircleColor(R.color.colorAccent)
                                .targetCircleColor(R.color.colorwhite)
                                .textColor(R.color.colorwhite)
                                .dimColor(R.color.colorAccent)
                                .drawShadow(false)
                                .cancelable(true)
                                .tintTarget(false)
                                .icon(getResources().getDrawable(R.drawable.hrm_logout)),

                        new TapTargetView.Listener() {
                            @Override
                            public void onTargetClick(TapTargetView view) {
                                super.onTargetClick(view);
                                logOut();
                            }
                        });


            } else {
                Utilitity.showSnackBarError(getApplicationContext(),
                        coordinatorLayout, getResources().getString(R.string.no_internet_connection));

            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    public void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.nav_item_home);
                break;
            case 1:
                fragment = new ApplyForLeaveFragment();
                title = getString(R.string.nav_item_apply_for_leave);
                break;
            case 2:
                fragment = new MyLeaveFragment();
                title = getString(R.string.nav_item_my_leaves);
                break;
//            case 3:
//                fragment = new ProjectFeedbackFragment();
//                title = getString(R.string.nav_item_project_feedback);
//                break;
//            case 4:
//                fragment = new EOTMFragment();
//                title = getString(R.string.nav_item_eotm);
//                break;
//            case 5:
//                fragment = new SalarySlipFragment();
//                title = getString(R.string.nav_item_salary_slips);
//                break;
//            case 6:
//                fragment = new SendMessageFragment();
//                title = getString(R.string.nav_item_send_message);
//                break;
//            case 7:
//                fragment = new ProjectFeedbackFragment();
//                title = getString(R.string.nav_item_project_feedback);
//                break;
//            case 8:
//                fragment = new ProjectFeedbackFragment();
//                title = getString(R.string.nav_item_project_feedback);
//                break;
//            case 9:
//                fragment = new ProjectFeedbackFragment();
//                title = getString(R.string.nav_item_project_feedback);
//                break;
//            case 10:
//                fragment = new ProjectFeedbackFragment();
//                title = getString(R.string.nav_item_project_feedback);
//                break;
//            case 11:
//                fragment = new ProjectFeedbackFragment();
//                title = getString(R.string.nav_item_project_feedback);
//                break;
//            case 12:
//                fragment = new ProjectFeedbackFragment();
//                title = getString(R.string.nav_item_project_feedback);
//                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
            // set the toolbar title
            getSupportActionBar().setTitle(title);

        }
    }


    /* Log Out Call */
    private void logOut() {
        Utilitity.showProgressDialog(progressBar);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT + Constant.APPENDED_PATH + Constant.LOGOUT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        RestClient restClientAPI = retrofit.create(RestClient.class);

        Call<LogOutPOJO> call = restClientAPI.logOutRequest(user.getId());

        //asynchronous call
        call.enqueue(this);

    }

    /* LogOut Response */
    @Override
    public void onResponse(Call<LogOutPOJO> call, Response<LogOutPOJO> response) {
        LogOutPOJO logOut = response.body();

        int code = response.code();
        if (code == RESPONSE_CODE) {

            Utilitity.dismissProgressDialog(progressBar);

            if (logOut.getStatus().equals(SUCCESS)) {
                Utilitity.showSnackBar(HomeActivity.this, coordinatorLayout,
                        String.valueOf(logOut.getMessage()));
                Prefrence.setUser(this, null);
                Utilitity.passNextActivity(HomeActivity.this, LogInActivity.class);
                finish();

            }else{
                Utilitity.showSnackBarError(HomeActivity.this, coordinatorLayout,
                        String.valueOf(logOut.getMessage()));
            }
        } else {

            Utilitity.showSnackBarError(HomeActivity.this, coordinatorLayout,
                    String.valueOf(logOut.getMessage()));

        }
    }

    @Override
    public void onFailure(Call<LogOutPOJO> call, Throwable t) {
        Utilitity.dismissProgressDialog(progressBar);
        Log.e("onFailure", "onFailure?? " + t.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /* Get Coordinate Layout */
    public CoordinatorLayout getCoordinateLayout() {
        return coordinatorLayout;
    }

    /* Set User Information */
    public LogInPOJO.User getUser() {
        return user;
    }

    /* Set isLoad First Time */
    public void setIsLoadFirstTime(boolean isLoadFirstTime) {
        this.isLoadFirstTime = isLoadFirstTime;
    }

    public boolean getIsLoadFirstTime() {
        return isLoadFirstTime;
    }


    /* Set Selected Working Days Count But It is Not Used Now*/
    @Override
    public void callbackDays(String days) {
        this.days = days;
        //ApplyForLeaveFragment.getInstance().tv_working_days_d().setText(days);
    }

    //Keyboard hide
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        View view = getCurrentFocus();
        boolean ret = super.dispatchTouchEvent(event);

        if (view instanceof EditText) {
            View w = getCurrentFocus();
            int scrcoords[] = new int[2];
            w.getLocationOnScreen(scrcoords);
            float x = event.getRawX() + w.getLeft() - scrcoords[0];
            float y = event.getRawY() + w.getTop() - scrcoords[1];

            if (event.getAction() == MotionEvent.ACTION_UP
                    && (x < w.getLeft() || x >= w.getRight() || y < w.getTop() || y > w
                    .getBottom())) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getCurrentFocus()
                        .getWindowToken(), 0);
            }
        }
        return ret;
    }

    @Override
    public void onBackPressed() {
        if (drawerFragment.getDrawerLayout().isDrawerOpen(GravityCompat.START)) {
            drawerFragment.getDrawerLayout().closeDrawers();
            return;
        }
        super.onBackPressed();

    }

}
