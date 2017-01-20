package com.ourdesignz.hrm.prefrence;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.ourdesignz.hrm.interfaces.Constant;
import com.ourdesignz.hrm.model.LogInPOJO;

/**
 * Created by ourdesignz on 22/9/16.
 */
public class Prefrence implements Constant {

    static SharedPreferences sharedpreferences;
    static SharedPreferences.Editor editor;

    public static void setRememberMe(Context ctx, Boolean isRemind) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        editor.putBoolean(KEY_IS_REMEMBER, isRemind);
        editor.commit();
    }

    public static boolean getRememberMe(Context ctx) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        boolean isRemind = sharedpreferences.getBoolean(KEY_IS_REMEMBER, false);
        return isRemind;
    }

    public static void setRememberMeCredentials(Context ctx, String username, String password) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);
        editor.commit();
    }

    public static String getUserName(Context ctx) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        String userName = sharedpreferences.getString(KEY_USERNAME, null);
        return userName;
    }


    public static String getPassword(Context ctx) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        String password = sharedpreferences.getString(KEY_PASSWORD, null);
        return password;
    }

    public static void setUser(Context ctx, LogInPOJO.User user) {
        Gson gson = new Gson();
        String json_user = gson.toJson(user);
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        editor.putString(KEY_USER, json_user);
        editor.commit();
    }

    public static LogInPOJO.User getUser(Context ctx) {
        Gson gson = new Gson();
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        String json_user = sharedpreferences.getString(KEY_USER, null);
        LogInPOJO.User user = gson.fromJson(json_user, LogInPOJO.User.class);
        return user;
    }

    public static void setMobileNoVerified(Context ctx, Boolean isVerified) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        editor.putBoolean(KEY_MOBILE_VERIFIED, isVerified);
        editor.commit();
    }

    public static boolean getMobileNoVerified(Context ctx) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        boolean isRemind = sharedpreferences.getBoolean(KEY_MOBILE_VERIFIED, false);
        return isRemind;
    }

    public static void setMobileNo(Context ctx, String mobileNO) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        editor.putString(KEY_MOBILE_NUMBER, mobileNO);
        editor.commit();
    }

    public static String getMobileNo(Context ctx) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        String mobileNo = sharedpreferences.getString(KEY_MOBILE_NUMBER, null);
        return mobileNo;
    }

    public static void putOTP(Context ctx, String otp) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        editor.putString(KEY_OTP, otp);
        editor.commit();
    }

    public static String getOTP(Context ctx) {
        sharedpreferences = ctx.getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        String otp = sharedpreferences.getString(KEY_OTP, null);
        return otp;
    }


}
