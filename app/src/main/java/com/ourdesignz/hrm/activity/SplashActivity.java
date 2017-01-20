package com.ourdesignz.hrm.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ourdesignz.hrm.R;
import com.ourdesignz.hrm.interfaces.Constant;
import com.ourdesignz.hrm.interfaces.RestClient;
import com.ourdesignz.hrm.model.OtpPOJO;
import com.ourdesignz.hrm.prefrence.Prefrence;
import com.ourdesignz.hrm.utilities.MarshMallowPermission;
import com.ourdesignz.hrm.utilities.Utilitity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends AppCompatActivity implements Constant , Callback<OtpPOJO> {

    private ImageView mKenBurns;
    private ImageView mLogo;
    private TextView welcomeText;
    MarshMallowPermission marshMallowPermission = new MarshMallowPermission(this);
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        Transparent Status Bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        //startService(new Intent(this, BackGroundService.class));

        setContentView(R.layout.activity_splash);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);
        mKenBurns = (ImageView) findViewById(R.id.ken_burns_images);
        mLogo = (ImageView) findViewById(R.id.logo);
        welcomeText = (TextView) findViewById(R.id.welcome_text);
        Utilitity.setTypeFace(this, welcomeText);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (marshMallowPermission.checkPermissionForAccessWifiState() == true
                    && marshMallowPermission.checkPermissionForInternet() == true
                    && marshMallowPermission.checkPermissionForREAD_PHONE_STATE() == true
                    && marshMallowPermission.checkPermissionForACCESS_NETWORK_STATE() == true
                    ) {

                setAnimation();

            } else {
                marshMallowPermission.commonPermissionForAppFirst();
            }

        } else {
            setAnimation();
        }

    }

    /**
     * Animation depends on category.
     */
    private void setAnimation() {
        animation2();
        animation3();
    }

    private void animation1() {
        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(mLogo, "scaleX", 5.0F, 1.0F);
        scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleXAnimation.setDuration(1200);
        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(mLogo, "scaleY", 5.0F, 1.0F);
        scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleYAnimation.setDuration(1200);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(mLogo, "alpha", 0.0F, 1.0F);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(1200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
        animatorSet.setStartDelay(500);
        animatorSet.start();
    }

    private void animation2() {
        mLogo.setAlpha(1.0F);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
        mLogo.startAnimation(anim);
    }

    private void animation3() {
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(welcomeText, "alpha", 0.0F, 1.0F);
        alphaAnimation.setStartDelay(1700);
        alphaAnimation.setDuration(500);
        alphaAnimation.start();

        if (Utilitity.isNetworkAvailable(getApplicationContext())) {

            if(Prefrence.getMobileNo(SplashActivity.this) != null &&
                    !Prefrence.getMobileNo(SplashActivity.this).equals("")){

                makeOTPCall(Prefrence.getMobileNo(SplashActivity.this));

            }else{

                startNextActivity();
            }

        } else {
            Utilitity.showSnackBarError(getApplicationContext(),
                    coordinatorLayout, getResources().getString(R.string.no_internet_connection));

        }

    }

    private void startNextActivity() {
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                Prefrence.setMobileNoVerified(SplashActivity.this, true);

                if (!Prefrence.getMobileNoVerified(SplashActivity.this)) {

                    Utilitity.passNextActivity(SplashActivity.this, OTPActivity.class);


                } else if (Prefrence.getUser(SplashActivity.this) != null &&
                        !Prefrence.getUser(SplashActivity.this).getId().equals("")) {

                    Utilitity.passNextActivity(SplashActivity.this, HomeActivity.class);

                } else {

                    Utilitity.passNextActivity(SplashActivity.this, LogInActivity.class);

                }

                finish();

            }
        }, SPLASH_TIME_OUT);
    }

    /* Make Request OTP Call for Mobile Number Verification */
    private void makeOTPCall(String number) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT + Constant.APPENDED_PATH
                        + Constant.VALIDATE_MOBILE + number + "/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        RestClient restClientAPI = retrofit.create(RestClient.class);

        Call<OtpPOJO> call = restClientAPI.otpRequest();

        //asynchronous call
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<OtpPOJO> call, Response<OtpPOJO> response) {
        OtpPOJO otppojo = response.body();

        int code = response.code();
        if (code == RESPONSE_CODE) {

            if (otppojo.getStatus().equals(SUCCESS)) {

                Prefrence.setMobileNoVerified(SplashActivity.this, true);
                Prefrence.setMobileNo(SplashActivity.this, Prefrence.getMobileNo(SplashActivity.this));
                startNextActivity();

            } else {
                Prefrence.setMobileNoVerified(SplashActivity.this, false);
                Prefrence.setMobileNo(SplashActivity.this, "");
                showDialog();
            }

            Log.e("Response", "Response?? " + otppojo.getMessage());

        } else {

            Prefrence.setMobileNoVerified(SplashActivity.this, false);
            Prefrence.setMobileNo(SplashActivity.this, "");
            Log.e("ResponseD", "ResponseD?? " + otppojo.getMessage());
            showDialog();

        }
    }

    @Override
    public void onFailure(Call<OtpPOJO> call, Throwable t) {
        Prefrence.setMobileNoVerified(SplashActivity.this, false);
        Prefrence.setMobileNo(SplashActivity.this, "");
        Log.e("onFailure", "onFailure?? " + t.getMessage());
    }

    /* Show Dialog When Click Item On list view */
    private void showDialog() {
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath2);
        Typeface tf2 = Typeface.createFromAsset(getAssets(), fontPath2);
        MaterialDialog dialog = new MaterialDialog.Builder(SplashActivity.this)
                .content(getString(R.string.left_company))
                .typeface(tf2, tf)
                .negativeText(getString(R.string.close))
                .show();

    }

    // Request Call Back Method To check permission is granted by user or not for MarshMallow...
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case COMMON_PERMISSION_REQUEST_CODE_FIRST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    setAnimation();

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    finish();
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


}
