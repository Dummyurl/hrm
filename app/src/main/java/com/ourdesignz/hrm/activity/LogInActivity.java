package com.ourdesignz.hrm.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.transition.Explode;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gabrielsamojlo.keyboarddismisser.KeyboardDismisser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ourdesignz.hrm.R;
import com.ourdesignz.hrm.interfaces.Constant;
import com.ourdesignz.hrm.interfaces.RestClient;
import com.ourdesignz.hrm.model.LogInPOJO;
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
public class LogInActivity extends AppCompatActivity implements Constant, View.OnClickListener,
        Callback<LogInPOJO> {

    private Toolbar toolbar;
    private EditText inputName, inputPassword;
    private TextInputLayout inputLayoutName, inputLayoutPassword;
    private Button btnSignUp;
    private CoordinatorLayout coordinatorLayout;
    private CheckBox checkBox;
    private ProgressBar progressBar;
    private TextView tv_remember_me;

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

        setContentView(R.layout.activity_login);

        /* Hide KeyBoard When Touch Outside */
        KeyboardDismisser.useWith(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        tv_remember_me = (TextView) findViewById(R.id.tv_remember_me);
        Utilitity.setTypeFace(this, tv_remember_me);
        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_username);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputName = (EditText) findViewById(R.id.edt_username);
        Utilitity.setTypeFace(this, inputName);
        inputPassword = (EditText) findViewById(R.id.edt_password);
        Utilitity.setTypeFace(this, inputPassword);
        btnSignUp = (Button) findViewById(R.id.btn_signUp);
        Utilitity.setTypeFace2(this, btnSignUp);
        btnSignUp.setOnClickListener(this);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        /* Set Remember Me */
        if (Prefrence.getRememberMe(this)) {
            checkBox.setChecked(true);
            inputName.setText(Prefrence.getUserName(this));
            inputPassword.setText(Prefrence.getPassword(this));

        } else {
            checkBox.setChecked(false);
            Prefrence.setRememberMeCredentials(this, "", "");
        }

    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

        makeRestClientCallForLogIn();

    }

    /* Make Rest Client Call For LogIn */
    private void makeRestClientCallForLogIn() {
        Utilitity.showProgressDialog(progressBar);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT + Constant.APPENDED_PATH + Constant.LOGIN)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        RestClient restClientAPI = retrofit.create(RestClient.class);

        Call<LogInPOJO> call = restClientAPI.logInRequest(inputName.getText().toString(),
                inputPassword.getText().toString());

        //asynchronous call
        call.enqueue(this);
    }

    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }


    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signUp:
                if (Utilitity.isNetworkAvailable(LogInActivity.this)) {

                    submitForm();

                } else {
                    Utilitity.showSnackBarError(LogInActivity.this, coordinatorLayout,
                            getResources().getString(R.string.no_internet_connection));

                }
                break;

            default:
                break;
        }
    }

    /* Text Watcher */
    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (inputName.getText().length() > 0
                    && inputPassword.getText().length() > 0) {
                btnSignUp.setBackgroundColor(Color.parseColor("#16a086"));
                btnSignUp.setEnabled(true);
            } else {
                btnSignUp.setEnabled(false);
                btnSignUp.setBackgroundColor(Color.parseColor("#CCCCCC"));
            }

        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.edt_username:
                    validateName();
                    break;

                case R.id.edt_password:
                    validatePassword();
                    break;
            }
        }
    }

    /* Get Response From LogIn */
    @Override
    public void onResponse(Call<LogInPOJO> call, Response<LogInPOJO> response) {

        LogInPOJO logIn = response.body();

        int code = response.code();
        if (code == RESPONSE_CODE) {

            Utilitity.dismissProgressDialog(progressBar);
            Prefrence.setRememberMe(this, checkBox.isChecked());

            if (logIn.getStatus().equals(SUCCESS)) {

                if (Prefrence.getRememberMe(this)) {

                    Prefrence.setRememberMeCredentials(this, inputName.getText().toString(),
                            inputPassword.getText().toString());

                } else {
                    Prefrence.setRememberMeCredentials(this, "", "");

                }

                /* Set User Data in Prefrence */
                Prefrence.setUser(this, logIn.getUser());

                Utilitity.showSnackBar(LogInActivity.this, coordinatorLayout,
                        String.valueOf(logIn.getMessage()));
                Utilitity.passNextActivity(LogInActivity.this, HomeActivity.class);
                finish();

            } else {
                Utilitity.showSnackBarError(LogInActivity.this, coordinatorLayout,
                        String.valueOf(logIn.getMessage()));

            }

            Log.e("Response", "Response?? " + logIn.getMessage());

        } else {

            Log.e("ResponseD", "ResponseD?? " + logIn.getMessage());
            Utilitity.showSnackBarError(LogInActivity.this, coordinatorLayout,
                    String.valueOf(logIn.getMessage()));

        }
    }

    @Override
    public void onFailure(Call<LogInPOJO> call, Throwable t) {
        Utilitity.dismissProgressDialog(progressBar);
        Log.e("onFailure", "onFailure?? " + t.getMessage());

    }

}
