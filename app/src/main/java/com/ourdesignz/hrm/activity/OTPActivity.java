package com.ourdesignz.hrm.activity;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gabrielsamojlo.keyboarddismisser.KeyboardDismisser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ourdesignz.hrm.R;
import com.ourdesignz.hrm.interfaces.Constant;
import com.ourdesignz.hrm.interfaces.RestClient;
import com.ourdesignz.hrm.model.OtpPOJO;
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
public class OTPActivity extends AppCompatActivity implements View.OnClickListener, Constant,
        Callback<OtpPOJO> , TextWatcher {

    private Toolbar toolbar;
    private EditText edt_mobile;
    private TextInputLayout input_layout_mobile;
    private Button btn_submit;
    private CoordinatorLayout coordinatorLayout;
    private ProgressBar progressBar;
    private TextView title_otp;
    private boolean isNumberVerifiedCheck = false;
    private Notification notification;
    private NotificationManager mNotificationManager;
    private String mobileNo;


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

        setContentView(R.layout.activity_otp);

        /* Hide KeyBoard When Touch Outside */
        KeyboardDismisser.useWith(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        input_layout_mobile = (TextInputLayout) findViewById(R.id.input_layout_mobile);
        input_layout_mobile.setHint(getString(R.string.mobile));
        edt_mobile = (EditText) findViewById(R.id.edt_mobile);
        Utilitity.setTypeFace(this, edt_mobile);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
        Utilitity.setTypeFace2(this, btn_submit);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        title_otp = (TextView) findViewById(R.id.title_otp);
        Utilitity.setTypeFace(this, title_otp);
        addTextChangeListener();

    }

    /**
     * Functionality to add text change listener
     */
    private void addTextChangeListener() {
        edt_mobile.addTextChangedListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                if (Utilitity.isNetworkAvailable(getApplicationContext())) {

                    if (isNumberVerifiedCheck) {
                        if (edt_mobile.getText().toString().equals(Prefrence.getOTP(this))) {

                            if (mNotificationManager != null) {
                                notificationCancel();
                            }

                            Prefrence.setMobileNoVerified(OTPActivity.this, true);
                            Prefrence.setMobileNo(OTPActivity.this, mobileNo);
                            Prefrence.putOTP(this, "");

                            Utilitity.passNextActivity(OTPActivity.this, LogInActivity.class);
                            finish();

                        } else {
                            Utilitity.showSnackBarError(OTPActivity.this,
                                    coordinatorLayout, getString(R.string.wrong_otp));

                        }
                    } else {

                        if (edt_mobile.getText().toString().trim().length() == 10) {

                            showDialog(edt_mobile.getText().toString());

                        } else {

                            Utilitity.showSnackBarError(OTPActivity.this,
                                    coordinatorLayout, getString(R.string.correct_no_msg));

                        }
                    }

                } else {
                    Utilitity.showSnackBarError(getApplicationContext(),
                            coordinatorLayout, getResources().getString(R.string.no_internet_connection));

                }

                break;

            default:
                break;
        }
    }

    /* Show Dialog For Verified Number Check Message */
    private void showDialog(final String number) {
        final Dialog dialog = new Dialog(OTPActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.otp_alert);
        TextView msg = (TextView) dialog.findViewById(R.id.confirm_msg);
        Utilitity.setTypeFace(this, msg);
        msg.setText(getString(R.string.is_no) + " " + number
                + " " + getString(R.string.correct));
        Button btn_yes = (Button) dialog.findViewById(R.id.dialog_yes);
        Utilitity.setTypeFace2(this, btn_yes);
        Button btn_no = (Button) dialog.findViewById(R.id.dialog_no);
        Utilitity.setTypeFace2(this, btn_no);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                makeOTPCall(number);

            }
        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /* Make Request OTP Call for Mobile Number Verification */
    private void makeOTPCall(String number) {
        Utilitity.showProgressDialog(progressBar);
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

            Utilitity.dismissProgressDialog(progressBar);

            if (otppojo.getStatus().equals(SUCCESS)) {

                isNumberVerifiedCheck = true;
                generateOTPNotification();

            } else {
                isNumberVerifiedCheck = false;
                Prefrence.setMobileNoVerified(OTPActivity.this, false);
                Prefrence.setMobileNo(OTPActivity.this, "");
                Utilitity.showSnackBar(OTPActivity.this, coordinatorLayout,
                        String.valueOf(otppojo.getMessage()));
            }

            Log.e("Response", "Response?? " + otppojo.getMessage());

        } else {

            isNumberVerifiedCheck = false;
            Prefrence.setMobileNoVerified(OTPActivity.this, false);
            Prefrence.setMobileNo(OTPActivity.this, "");
            Log.e("ResponseD", "ResponseD?? " + otppojo.getMessage());
            Utilitity.showSnackBarError(OTPActivity.this, coordinatorLayout,
                    String.valueOf(otppojo.getMessage()));

        }
    }

    @Override
    public void onFailure(Call<OtpPOJO> call, Throwable t) {
        Prefrence.setMobileNoVerified(OTPActivity.this, false);
        Prefrence.setMobileNo(OTPActivity.this, "");
        Utilitity.dismissProgressDialog(progressBar);
        Log.e("onFailure", "onFailure?? " + t.getMessage());
    }

    /* Generate Notification For OTP */
    private void generateOTPNotification() {
        btn_submit.setText(getString(R.string.otp));
        btn_submit.setVisibility(View.INVISIBLE);
        title_otp.setText(getString(R.string.enter_otp));
        input_layout_mobile.setHint(getString(R.string.otp));

        /* Generate And Put Random OTP */
        Prefrence.putOTP(this, Utilitity.getRandomNumber());

        mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent myIntent = new Intent(this, OTPActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP |
                Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Creates the PendingIntent
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                NOTIFY_ME_ID, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Instantiate a Builder object.
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder)
                new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.hrm_logo)
                .setContentTitle(getString(R.string.otp_is))
                .setContentText(Prefrence.getOTP(this))
                .setPriority(Notification.PRIORITY_HIGH)
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

            mBuilder.build().flags |= Notification.FLAG_AUTO_CANCEL;
            mBuilder.setContentIntent(contentIntent);
            mNotificationManager.notify(NOTIFY_ME_ID, mBuilder.build());

        } else {

            notification = mBuilder.getNotification();
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            mNotificationManager.notify(NOTIFY_ME_ID, notification);
        }


        mobileNo =  edt_mobile.getText().toString();
        edt_mobile.setEnabled(false);
        edt_mobile.setText("");

        Utilitity.showProgressDialog(progressBar);

        startNextActivity();
    }

    // You Cancel Notification ForceFully With This...
    public void notificationCancel() {
        mNotificationManager.cancel(NOTIFY_ME_ID);
    }

    private void startNextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Utilitity.dismissProgressDialog(progressBar);

                if (mNotificationManager != null) {
                    notificationCancel();
                }

                edt_mobile.setText("");
                edt_mobile.setText(Prefrence.getOTP(OTPActivity.this));
                Prefrence.setMobileNoVerified(OTPActivity.this, true);
                Prefrence.setMobileNo(OTPActivity.this, mobileNo);
                Prefrence.putOTP(OTPActivity.this, "");

                Utilitity.passNextActivity(OTPActivity.this, LogInActivity.class);

                finish();

            }
        }, OTP_TIME_OUT);
    }


    /* Text Watcher */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (edt_mobile.getText().length() > 0) {
            btn_submit.setBackgroundColor(Color.parseColor("#16a086"));
            btn_submit.setEnabled(true);
        } else {
            btn_submit.setEnabled(false);
            btn_submit.setBackgroundColor(Color.parseColor("#CCCCCC"));
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

}


