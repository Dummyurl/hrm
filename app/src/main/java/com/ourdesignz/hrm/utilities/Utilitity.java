package com.ourdesignz.hrm.utilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;
import com.ourdesignz.hrm.R;
import com.ourdesignz.hrm.activity.HomeActivity;
import com.ourdesignz.hrm.fragment.ApplyForLeaveFragment;
import com.ourdesignz.hrm.interfaces.Constant;
import com.ourdesignz.hrm.model.LogInPOJO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by ourdesignz on 22/9/16.
 */
public class Utilitity implements Constant {

    /* Check Internet Available Or Not */
    public static boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager =
                ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }

    /* Show SnackBar */
    public static void showSnackBar(Context ctx, View view, String message) {
        TSnackbar snackbar = TSnackbar.make(view, message, TSnackbar.LENGTH_SHORT);
        snackbar.setActionTextColor(Color.WHITE);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(ContextCompat.getColor(ctx, R.color.colorwhite));
        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary));
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        snackbar.show();
    }

    /* Show SnackBar */
    public static void showSnackBarError(Context ctx, View view, String message) {
        TSnackbar snackbar = TSnackbar.make(view, message, TSnackbar.LENGTH_SHORT);
        snackbar.setActionTextColor(Color.WHITE);
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(ContextCompat.getColor(ctx, R.color.colorwhite));
        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(ctx, R.color.btn_cancel_color));
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        snackbar.show();
    }

    /* Show SnackBar */
    public static void showSnackBarWithCallBack(Context ctx, View view, String message) {
        TSnackbar snackbar = TSnackbar.make(view, message, TSnackbar.LENGTH_SHORT);
        View views = snackbar.getView();
        views.setBackgroundColor(ContextCompat.getColor(ctx, R.color.colorwhite));
        TextView tv = (TextView) views.findViewById(android.support.design.R.id.snackbar_text);
        Utilitity.setTypeFace(ctx, tv);
        tv.setTextColor(ContextCompat.getColor(ctx, R.color.colorPrimary));
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        snackbar.setCallback(new TSnackbar.Callback() {

            @Override
            public void onDismissed(TSnackbar snackbar, int event) {
                HomeActivity.getInstance().displayView(2);
            }

            @Override
            public void onShown(TSnackbar snackbar) {
            }
        });
        snackbar.show();
    }

    /* Pass Next Activity Intent */
    public static void passNextActivity(final Context ctx, final Class to) {
        Intent i = new Intent(ctx, to);
        ctx.startActivity(i);
    }

    /* Pass Next Activity Intent With LogInPoJo User*/
    public static void passNextActivity(final Context ctx, final Class to, LogInPOJO.User user) {
        Intent i = new Intent(ctx, to);
        i.putExtra("USER", (Serializable) user);
        ctx.startActivity(i);
    }

    /* Show Progress Dialog */
    public static void showProgressDialog(ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
    }

    /* Dismiss Progress Dialog */
    public static void dismissProgressDialog(ProgressBar progressBar) {
        progressBar.setVisibility(View.GONE);

    }

    /* Format Date From String */
    public static String formatDateFromString(String inputDate) {

        Date parsed = null;
        String outputDate = "";
        String inputFormat = "yyyy-MM-dd hh:mm:ss";
        String outputFormat = "MMMM dd, yyyy hh:mm";

        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, java.util.Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, java.util.Locale.getDefault());

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
            Log.e("ParseException", "ParseException??" + e.getMessage());
        }

        return outputDate;

    }

    /* Format Date From String */
    public static String formatDateFromStringnNew(String inputDate) {

        Date parsed = null;
        String outputDate = "";
        String inputFormat = "yyyy-MM-dd";
        String outputFormat = "dd MMMM yyyy";

        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, java.util.Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, java.util.Locale.getDefault());

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
            Log.e("ParseException", "ParseException??" + e.getMessage());
        }

        return outputDate;

    }

    /* Compare Two Dates With Current Date */
    public static boolean compareDates(String endDate) {

        SimpleDateFormat dfDate = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        boolean b = false;

        try {
            if (dfDate.parse(currentDate).before(dfDate.parse(endDate))) {

                b = true;  // If start date is before end date.

            } else if (dfDate.parse(currentDate).equals(dfDate.parse(endDate))) {

                b = true;  // If two dates are equal.

            } else {

                b = false; // If start date is after the end date.

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return b;
    }

    /* Compare Two Own dates */
    public static boolean compareOwnDates(String date_from, String date_to) {
        SimpleDateFormat dfDate = new SimpleDateFormat("dd-MM-yyyy");

        boolean b = false;

        try {
            if (dfDate.parse(date_from).after(dfDate.parse(date_to))) {

                b = true;  // If start date is before end date.

            } else {

                b = false; // If start date is after the end date.

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return b;
    }

    /* Get Mobile Device ID */
    public static String getDeviceId(Context ctx) {
        String android_id = Settings.Secure.getString(ctx.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return android_id;
    }

    /* Get Mobile Number */
    public static String getMobileNumber(Context ctx) {
        TelephonyManager telephonyManager = (TelephonyManager)
                ctx.getSystemService(ctx.TELEPHONY_SERVICE);
        String strMobileNumber = telephonyManager.getLine1Number();
        return strMobileNumber;
    }

    /* Get Random Number */
    public static String getRandomNumber() {
        String random_number = String.valueOf((int) (Math.random() * 9000) + 1000);
        return random_number;
    }

    /**
     * Hides the soft keyboard
     */
    public static void hideSoftKeyboard(Context ctx, View view) {
        InputMethodManager imm = (InputMethodManager)
                ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * Shows the soft keyboard
     */
    public static void showSoftKeyboard(Context ctx, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)
                ctx.getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

    /* Show date Difference */
    public static long calculateDateDifference(String dateStart, String dateStop) {
        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date d1 = null;
        Date d2 = null;
        long diffDays = 0;

        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;

            diffDays = diff / (24 * 60 * 60 * 1000);


            Calendar c1 = Calendar.getInstance();
            c1.setTime(d1);

            Calendar c2 = Calendar.getInstance();
            c2.setTime(d2);

            int sundays = 0;
            int saturday = 0;

            while (c2.after(c1)) {

                if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {

                    SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
                    String formatted = format1.format(c1.getTime());
                    if (ApplyForLeaveFragment.getInstance().getOffSaturdayList() != null) {
                        if (ApplyForLeaveFragment.getInstance().getOffSaturdayList()
                                .contains(String.valueOf(formatted))) {
                            saturday++;
                        }
                    }

                }

                if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    sundays++;
                }

                c1.add(Calendar.DATE, 1);
            }


            int countSS = saturday + sundays;
            diffDays = (diffDays + 1) - countSS;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return diffDays;
    }

    /* Date Difference With holidays list */
    public static int calculateDateDifference(String dateFrom, String dateTo,
                                              List<String> listHolidays) {
        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date d1 = null;
        Date d2 = null;
        int count = 0;

        try {
            d1 = format.parse(dateFrom);
            d2 = format.parse(dateTo);

            Calendar c1 = Calendar.getInstance();
            c1.setTime(d1);

            Calendar c2 = Calendar.getInstance();
            c2.setTime(d2);

            while (c2.after(c1)) {

                SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
                String formatted = format1.format(c1.getTime());
                if (listHolidays != null) {
                    if (listHolidays.contains(String.valueOf(formatted))) {
                        count++;
                    }
                }

                c1.add(Calendar.DATE, 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    /* Get Total No Of Days */
    public static String getTotalNoOfDays(String dateFrom, String dateTo) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
        String inputString1 = dateFrom;
        String inputString2 = dateTo;
        String days = "";

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            long diff3 = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
            days = String.valueOf(diff3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }


    /* Check Sunday */
    public static boolean checkSunday(String date) {
        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date d1 = null;
        boolean isSunday = false;
        try {

            d1 = format.parse(date);

            Calendar c1 = Calendar.getInstance();
            c1.setTime(d1);

            if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                isSunday = true;
            } else {
                isSunday = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSunday;
    }

    /* Check Selected date is in Current Week*/
    public static boolean isDateInCurrentWeek(String date_str) {
        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try {
            date = format.parse(date_str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar currentCalendar = Calendar.getInstance();
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(date);
        int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
        int targetYear = targetCalendar.get(Calendar.YEAR);
        return week == targetWeek && year == targetYear;
    }

    public static String getResponseBody(Response<ResponseBody> results) {

        //Try to get response body
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();

        reader = new BufferedReader(new InputStreamReader(results.body().byteStream()));

        String line;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = sb.toString();
        return result;
    }

    // Set Font TypeFace
    public static void setTypeFace(Context ctx, TextView tv) {
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), fontPath);
        tv.setTypeface(tf);
    }

    public static void setTypeFace2(Context ctx, TextView tv) {
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), fontPath2);
        tv.setTypeface(tf);
    }

    public static void setTypeFace(Context ctx, Button btn) {
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), fontPath);
        btn.setTypeface(tf);
    }

    public static void setTypeFace2(Context ctx, Button btn) {
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), fontPath2);
        btn.setTypeface(tf);
    }

    public static void setTypeFace(Context ctx, EditText edt) {
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), fontPath);
        edt.setTypeface(tf);
    }

    public static void setTypeFace2(Context ctx, EditText edt) {
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), fontPath2);
        edt.setTypeface(tf);
    }

    public static String setTypeFace(Context ctx, String text) {
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), fontPath);
        SpannableString mNewTitle = new SpannableString(text);
        mNewTitle.setSpan(new CustomTypefaceSpan("", tf), 0, mNewTitle.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return mNewTitle.toString();
    }

    public static String setTypeFace2(Context ctx, String text) {
        Typeface tf = Typeface.createFromAsset(ctx.getAssets(), fontPath);
        SpannableString mNewTitle = new SpannableString(text);
        mNewTitle.setSpan(new CustomTypefaceSpan("", tf), 0, mNewTitle.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return mNewTitle.toString();
    }

    public static String makeTextBold(String text) {
        SpannableStringBuilder sb = new SpannableStringBuilder(text);
        StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD); // Span to make text bold
        int start = text.indexOf(text);
        int end = start + text.length();
        //final StyleSpan iss = new StyleSpan(android.graphics.Typeface.ITALIC); //Span to make text italic
        sb.setSpan(bss, start, end, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make first 4 characters Bold
        //sb.setSpan(iss, 4, 6, Spannable.SPAN_INCLUSIVE_INCLUSIVE); // make last 2 characters Italic
        return sb.toString();
    }

}

