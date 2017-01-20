package com.ourdesignz.hrm.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.gabrielsamojlo.keyboarddismisser.KeyboardDismisser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ourdesignz.hrm.R;
import com.ourdesignz.hrm.activity.HomeActivity;
import com.ourdesignz.hrm.interfaces.Constant;
import com.ourdesignz.hrm.interfaces.RestClient;
import com.ourdesignz.hrm.model.ApplyLeavePOJO;
import com.ourdesignz.hrm.model.ApplyLeavesRequestPOJO;
import com.ourdesignz.hrm.model.AvailableLeavesRequestPOJO;
import com.ourdesignz.hrm.utilities.Utilitity;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ourdesignz on 26/9/16.
 */
public class ApplyForLeaveFragment extends Fragment implements View.OnClickListener,
        Constant, AdapterView.OnItemSelectedListener,
        Callback<ApplyLeavePOJO>,
        DatePickerDialog.OnDateSetListener {

    private static ApplyForLeaveFragment mContext;
    private TextView edt_date_from;
    private TextView edt_date_to;

    private EditText edt_reason;

    private Spinner spnr_duration_type;
    private Spinner spnr_duration_type_second;
    private Spinner spnr_leave_type;

    private TextView tv_paid_leave_balance;
    private TextView tv_pending_leave_balance;
    private TextView tv_working_days_d;
    private TextView tv_unpaid_leaves_count;
    private TextView tv_leave_request_message;
    private TextView tv_leave_balance;

    private TextView tv_date_from;
    private TextView tv_working_days;
    private TextView tv_leave_type;
    private TextView tv_reason;

    private Button btn_reset;
    private Button btn_submit;

    private RelativeLayout relative_date_to;
    private RelativeLayout relative_duration_type;
    private ProgressBar progressBar;

    private ArrayAdapter<String> adapter_duration_type;
    private ArrayAdapter<String> adapter_duration_types_array_second;
    private ArrayAdapter<String> adapter_leave_types_array;

    private ImageView img_spnr_drop_down;

    private List<String> listOffSaturday;
    private List<String> listNationalHoliday;
    private List<String> leaveList;
    private List<String> durationTypeList;
    private List<String> durationTypeList2;

    private String month;
    private String day;
    private int DATE_PICKER_ID;

    private String leave_status_id = "2";
    private String duration_type = "";
    private String duration_type_two = "";
    private String number_of_days = "";
    private String leave_type_id = "";
    private String leave_balance = "";
    private String applied_leave_limit = "";
    private String leave = "";
    private String leave_type_id2 = "";
    private String holidays = "";
    private int listSize;

    public ApplyForLeaveFragment() {
        // Required empty public constructor
    }

    // ApplyForLeaveFragment Instance
    public static ApplyForLeaveFragment getInstance() {
        return mContext;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = ApplyForLeaveFragment.this;
        duration_type = getString(R.string.full_day_duration);
    }

    @Override
    public void onResume() {
        super.onResume();
         /* Hide KeyBoard When Touch Outside */
        KeyboardDismisser.useWith(this);
        DatePickerDialog dpd = (DatePickerDialog) getActivity()
                .getFragmentManager().findFragmentByTag("Datepickerdialog");
        if (dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_applyforleave, container, false);

        tv_leave_balance = (TextView) rootView.findViewById(R.id.tv_leave_balance);
        Utilitity.setTypeFace2(getActivity(), tv_leave_balance);
        tv_date_from = (TextView) rootView.findViewById(R.id.tv_date_from);
        Utilitity.setTypeFace2(getActivity(), tv_date_from);
        tv_working_days = (TextView) rootView.findViewById(R.id.tv_working_days);
        Utilitity.setTypeFace2(getActivity(), tv_working_days);
        tv_leave_type = (TextView) rootView.findViewById(R.id.tv_leave_type);
        Utilitity.setTypeFace2(getActivity(), tv_leave_type);
        tv_reason = (TextView) rootView.findViewById(R.id.tv_reason);
        Utilitity.setTypeFace2(getActivity(), tv_reason);

        edt_date_from = (TextView) rootView.findViewById(R.id.edt_date_from);
        Utilitity.setTypeFace(getActivity(), edt_date_from);
        edt_date_to = (TextView) rootView.findViewById(R.id.edt_date_to);
        Utilitity.setTypeFace(getActivity(), edt_date_to);
        edt_reason = (EditText) rootView.findViewById(R.id.edt_reason);
        Utilitity.setTypeFace(getActivity(), edt_reason);
        edt_reason.setEnabled(false);

        tv_paid_leave_balance = (TextView) rootView.findViewById(R.id.tv_paid_leave_balance);
        Utilitity.setTypeFace(getActivity(), tv_paid_leave_balance);
        tv_pending_leave_balance = (TextView) rootView.findViewById(R.id.tv_pending_leave_balance);
        Utilitity.setTypeFace(getActivity(), tv_pending_leave_balance);
        tv_pending_leave_balance.setVisibility(View.GONE);
        tv_working_days_d = (TextView) rootView.findViewById(R.id.tv_working_days_d);
        Utilitity.setTypeFace(getActivity(), tv_working_days_d);
        tv_unpaid_leaves_count = (TextView) rootView.findViewById(R.id.tv_unpaid_leaves_count);
        Utilitity.setTypeFace(getActivity(), tv_unpaid_leaves_count);
        tv_unpaid_leaves_count.setVisibility(View.GONE);
        tv_leave_request_message = (TextView) rootView.findViewById(R.id.tv_leave_request_message);
        Utilitity.setTypeFace(getActivity(), tv_leave_request_message);
        tv_leave_request_message.setVisibility(View.GONE);

        spnr_duration_type = (Spinner) rootView.findViewById(R.id.spnr_duration_type);
        spnr_duration_type.setOnItemSelectedListener(this);
        spnr_duration_type_second = (Spinner) rootView.findViewById(R.id.spnr_duration_type_second);
        spnr_duration_type_second.setVisibility(View.GONE);
        spnr_duration_type_second.setOnItemSelectedListener(new CustomOnItemSelectedListener());

        img_spnr_drop_down = (ImageView) rootView.findViewById(R.id.img_spnr_drop_down);
        img_spnr_drop_down.setVisibility(View.GONE);
        spnr_leave_type = (Spinner) rootView.findViewById(R.id.spnr_leave_type);
        spnr_leave_type.setEnabled(false);
        spnr_leave_type.setOnItemSelectedListener(new CustomOnItemSelectedListener2());

        btn_reset = (Button) rootView.findViewById(R.id.btn_reset);
        Utilitity.setTypeFace2(getActivity(), btn_reset);
        btn_reset.setOnClickListener(this);
        btn_reset.setEnabled(false);

        btn_submit = (Button) rootView.findViewById(R.id.btn_submit);
        Utilitity.setTypeFace2(getActivity(), btn_submit);
        btn_submit.setVisibility(View.GONE);
        btn_submit.setOnClickListener(this);

        relative_date_to = (RelativeLayout) rootView.findViewById(R.id.relative_date_to);
        relative_date_to.setVisibility(View.GONE);
        relative_duration_type = (RelativeLayout) rootView.findViewById(R.id.relative_duration_type);
        relative_duration_type.setVisibility(View.GONE);

        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        edt_date_from.setOnClickListener(this);
        edt_date_to.setOnClickListener(this);

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addValuesFromSpnrDurationType();
        addValuesFromSpnrDurationTypeSecond();
        addValuesFromSpnrLeaveType();

        if (Utilitity.isNetworkAvailable(getActivity())) {

            applyLeaveRequest();

        } else {
            Utilitity.showSnackBarError(getActivity(),
                    HomeActivity.getInstance().getCoordinateLayout(),
                    getResources().getString(R.string.no_internet_connection));

        }

    }

    /* Add Values From Spinner Duration Type */
    private void addValuesFromSpnrDurationType() {
        durationTypeList = new ArrayList<>(Arrays.asList(
                getResources().getStringArray(R.array.duration_types_array)));

        // Initializing an ArrayAdapter
        adapter_duration_type = new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_text, durationTypeList) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                Utilitity.setTypeFace(getActivity(), view);
                return view;
            }

            // Affects opened state of the spinner
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getDropDownView(position, convertView, parent);
                Utilitity.setTypeFace(getActivity(), view);
                return view;
            }
        };

        adapter_duration_type.setDropDownViewResource(R.layout.spinner_text);
        spnr_duration_type.setAdapter(adapter_duration_type);

    }

    /* Add Values From Spinner Duration Type Second */
    private void addValuesFromSpnrDurationTypeSecond() {
        durationTypeList2 = new ArrayList<>(Arrays.asList(
                getResources().getStringArray(R.array.duration_types_array_second)));

        // Initializing an ArrayAdapter
        adapter_duration_types_array_second = new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_text, durationTypeList2) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                Utilitity.setTypeFace(getActivity(), view);
                return view;
            }

            // Affects opened state of the spinner
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getDropDownView(position, convertView, parent);
                Utilitity.setTypeFace(getActivity(), view);
                return view;
            }
        };

        adapter_duration_types_array_second.setDropDownViewResource(R.layout.spinner_text);
        spnr_duration_type_second.setAdapter(adapter_duration_types_array_second);
    }

    /* Add Values From Spinner Leave Type */
    private void addValuesFromSpnrLeaveType() {

        leaveList = new ArrayList<>(Arrays.asList(
                getResources().getStringArray(R.array.leave_types_array)));
        notifyChangeForLeaveType(0, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.edt_date_from:

                Utilitity.hideSoftKeyboard(getActivity(), edt_date_from);
                showDatePicker(DATE_PICKER_ID_F);

                break;

            case R.id.edt_date_to:

                Utilitity.hideSoftKeyboard(getActivity(), edt_date_to);
                showDatePicker(DATE_PICKER_ID_S);

                break;

            case R.id.btn_reset:

                makeResetButtonCall();

                break;

            case R.id.btn_submit:

                if (Utilitity.isNetworkAvailable(getActivity())) {

                    if (edt_date_from.getText().length() == 0) {

                        Utilitity.showSnackBarError(getActivity(),
                                HomeActivity.getInstance().getCoordinateLayout(),
                                getString(R.string.select_date_from));

                    } else if (edt_date_to.getText().length() == 0) {

                        Utilitity.showSnackBarError(getActivity(),
                                HomeActivity.getInstance().getCoordinateLayout(),
                                getString(R.string.select_date_to));

                    } else if (spnr_leave_type.getSelectedItem().equals(getString(R.string.please_select_leave_type))) {

                        Utilitity.showSnackBarError(getActivity(),
                                HomeActivity.getInstance().getCoordinateLayout(),
                                getString(R.string.select_leave_type));

                    } else if (edt_reason.getText().length() == 0) {

                        Utilitity.showSnackBarError(getActivity(),
                                HomeActivity.getInstance().getCoordinateLayout(),
                                getString(R.string.select_reason));

                    } else {

                        number_of_days = Utilitity.getTotalNoOfDays(
                                edt_date_from.getText().toString(), edt_date_to.getText().toString());
                        holidays = String.valueOf(Utilitity.calculateDateDifference(
                                edt_date_from.getText().toString(), edt_date_to.getText().toString(), listNationalHoliday));

                    /* Submit Leave Request Call */
                        submitLeaveRequest(leave_status_id,
                                edt_date_from.getText().toString(),
                                edt_date_to.getText().toString(),
                                duration_type, duration_type_two, number_of_days,
                                holidays,
                                tv_working_days_d.getText().toString(),
                                leave_type_id, edt_reason.getText().toString(),
                                leave_balance, applied_leave_limit, leave, leave_type_id2);
                    }

                } else {
                    Utilitity.showSnackBarError(getActivity(),
                            HomeActivity.getInstance().getCoordinateLayout(),
                            getResources().getString(R.string.no_internet_connection));

                }
                break;

            default:
                break;
        }
    }

    /* Show Date Picker From Date To And Date From*/
    private void showDatePicker(int DATE_PICKER_ID) {

        this.DATE_PICKER_ID = DATE_PICKER_ID;

        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                ApplyForLeaveFragment.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        dpd.setCancelable(true);
        dpd.setThemeDark(false);
        dpd.vibrate(false);
        dpd.dismissOnPause(true);
        dpd.autoDismiss(true);

        if (DATE_PICKER_ID == DATE_PICKER_ID_F) {

            /* Hide Previous Dates */
            dpd.setMinDate(now.getInstance());

        } else if (DATE_PICKER_ID == DATE_PICKER_ID_S) {

            if (!edt_date_from.getText().toString().equals("")) {
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    cal.setTime(sdf.parse(edt_date_from.getText().toString()));

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                /* Hide Previous Dates */
                dpd.setMinDate(cal);

            }

        }

         /* Show Current Year Calender */
        Calendar cal_year = Calendar.getInstance();
        cal_year.set(Calendar.MONTH, Calendar.DECEMBER);
        cal_year.set(Calendar.DAY_OF_MONTH, 31);
        cal_year.setTimeInMillis(cal_year.getTimeInMillis());
        dpd.setMaxDate(cal_year);

        if (listOffSaturday != null && listOffSaturday.size() > 0) {

            Calendar[] dates = new Calendar[listOffSaturday.size()];

            for (int i = 0; i < listOffSaturday.size(); i++) {

                Calendar date = Calendar.getInstance();

                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                try {

                    date.setTime(sdf.parse(listOffSaturday.get(i))); // all done

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                dates[i] = date;
            }

            //HH converts hour in 24 hours format (0-23), day calculation
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

            Date d1 = null;
            Date d2 = null;

            Date d1_new = null;
            Date d2_new = null;

            try {
                d1 = format.parse(listOffSaturday.get(0));
                d2 = format.parse(listOffSaturday.get(listSize - 1));


                Calendar c1 = Calendar.getInstance();
                c1.setTime(d1);

                Calendar c2 = Calendar.getInstance();
                c2.setTime(d2);

                int sundays = 0;
                while (c2.after(c1)) {
                    if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        sundays++;
                    }
                    c1.add(Calendar.DATE, 1);
                }

                d1_new = format.parse(listOffSaturday.get(0));
                d2_new = format.parse(listOffSaturday.get(listSize - 1));

                Calendar c1_new = Calendar.getInstance();
                c1_new.setTime(d1_new);

                Calendar c2_new = Calendar.getInstance();
                c2_new.setTime(d2_new);

                Calendar[] dates_new = new Calendar[sundays];
                int i = 0;

                while (c2_new.after(c1_new)) {
                    Calendar date = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy",
                            Locale.ENGLISH);

                    if (c1_new.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        date.setTime(sdf.parse(c1_new.getTime().toString())); // all done
                        dates_new[i] = date;
                        i++;
                    }
                    c1_new.add(Calendar.DATE, 1);
                }

                int total_length = sundays + dates.length;

                Calendar[] dates_final = new Calendar[total_length];

                for (int j = 0; j < dates.length; j++) {
                    dates_final[j] = dates[j];
                }

                int def = dates.length;

                for (int k = 0; k < dates_new.length; k++) {
                    dates_final[def] = dates_new[k];
                    def++;
                }

                dpd.setDisabledDays(dates_final);


            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        if (item.equals(getString(R.string.full_day))) {
            spnr_duration_type_second.setVisibility(View.GONE);
            img_spnr_drop_down.setVisibility(View.GONE);
            tv_working_days_d.setText(getString(R.string.default_one));
            duration_type = getString(R.string.full_day_duration);
            duration_type_two = "";

            /* Available leave Request call */
            availableLeaveRequest("1",
                    tv_working_days_d.getText().toString().trim().replace(".00", ""),
                    edt_date_from.getText().toString().trim(),
                    edt_date_to.getText().toString().trim());

        } else {
            spnr_duration_type_second.setVisibility(View.VISIBLE);
            img_spnr_drop_down.setVisibility(View.VISIBLE);
            tv_working_days_d.setText(getString(R.string.default_zero_five));
            duration_type = getString(R.string.half_day_duration);
            duration_type_two = getString(R.string.am);

            /* Available leave Request call */
            availableLeaveRequest("1",
                    tv_working_days_d.getText().toString().trim().replace(".00", ""),
                    edt_date_from.getText().toString().trim(),
                    edt_date_to.getText().toString().trim());

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /* Reset page when hit reset button */
    public void makeResetButtonCall() {

        notifyChange();

        notifyChangeForLeaveType(0, 0);

        edt_date_from.setText("");
        edt_date_to.setText("");

        relative_date_to.setVisibility(View.GONE);
        relative_duration_type.setVisibility(View.GONE);

        edt_reason.setText("");
        edt_reason.setEnabled(false);

        spnr_leave_type.setEnabled(false);
        spnr_duration_type_second.setVisibility(View.GONE);
        img_spnr_drop_down.setVisibility(View.GONE);

        btn_submit.setVisibility(View.GONE);
        btn_reset.setEnabled(false);
        btn_reset.setBackgroundColor(Color.parseColor("#CCCCCC"));

        tv_unpaid_leaves_count.setVisibility(View.GONE);
        tv_leave_request_message.setVisibility(View.GONE);
        tv_working_days_d.setText("");

        leave_status_id = "2";
        duration_type = getString(R.string.full_day_duration);
        duration_type_two = "";
        number_of_days = "";
        leave_type_id = "";
        applied_leave_limit = "";
        leave = "";
        leave_type_id2 = "";
        holidays = "";

    }

    /* Make Request For Apply Leave */
    private void applyLeaveRequest() {
        Utilitity.showProgressDialog(progressBar);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT + Constant.APPENDED_PATH + Constant.APPLY_LEAVE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        RestClient restClientAPI = retrofit.create(RestClient.class);

        Call<ApplyLeavePOJO> call = restClientAPI.applyLeaveRequest(HomeActivity.getInstance()
                .getUser().getId());

        //asynchronous call
        call.enqueue(this);
    }

    /* Response Call Back For Apply Leave Request */
    @Override
    public void onResponse(Call<ApplyLeavePOJO> call, Response<ApplyLeavePOJO> response) {
        ApplyLeavePOJO applyLeavePojo = response.body();

        int code = response.code();
        if (code == RESPONSE_CODE) {

            Utilitity.dismissProgressDialog(progressBar);

            if (applyLeavePojo.getStatus().equals(SUCCESS)) {
                Log.e("Response", "Success?? " + applyLeavePojo.getStatus());

                if (applyLeavePojo.getWebserviceArray().getOffSaturdayArray() != null) {
                    listOffSaturday = applyLeavePojo.getWebserviceArray().getOffSaturdayArray();
                    listSize = listOffSaturday.size();
                }

                if (applyLeavePojo.getWebserviceArray().getNationalHolidaysArray() != null) {
                    listNationalHoliday = applyLeavePojo.getWebserviceArray().getNationalHolidaysArray();
                    for (int i = 0; i < listNationalHoliday.size(); i++) {
                        listOffSaturday.add(listNationalHoliday.get(i));
                    }
                }

                if (applyLeavePojo.getWebserviceArray() != null &&
                        applyLeavePojo.getWebserviceArray().getTotalAvailableLeaves() != null
                        && applyLeavePojo.getWebserviceArray().getTotalAvailableLeaves()
                        .getUserAssignLeave() != null
                        && String.valueOf(applyLeavePojo.getWebserviceArray().getTotalAvailableLeaves()
                        .getUserAssignLeave().getBalance()) != null &&
                        !applyLeavePojo.getWebserviceArray().getTotalAvailableLeaves()
                                .getUserAssignLeave().getId().equals("0")) {

                    tv_paid_leave_balance.setText(getString(R.string.paid_leave_balance)
                            + " " + String.valueOf(applyLeavePojo.getWebserviceArray().getTotalAvailableLeaves()
                            .getUserAssignLeave().getBalance()));

                    leave_balance = String.valueOf(applyLeavePojo.getWebserviceArray().getTotalAvailableLeaves()
                            .getUserAssignLeave().getBalance());

                } else {
                    tv_paid_leave_balance.setText(getString(R.string.paid_leave_balance)
                            + " " + "0");

                    leave_balance = "0";
                }

                if (applyLeavePojo.getWebserviceArray() != null &&
                        applyLeavePojo.getWebserviceArray().getTotalPaidPendingLeaves() != null &&
                        applyLeavePojo.getWebserviceArray().getTotalPaidPendingLeaves()
                                .getUserApplyLeave() != null &&
                        applyLeavePojo.getWebserviceArray().getTotalPaidPendingLeaves()
                                .getUserApplyLeave().getPaidWorkingDays() != null &&
                        !applyLeavePojo.getWebserviceArray().getTotalPaidPendingLeaves()
                                .getUserApplyLeave().getPaidWorkingDays().equals("")) {

                    tv_pending_leave_balance.setVisibility(View.VISIBLE);
                    tv_pending_leave_balance.setText(getString(R.string.pending_paid_leaves)
                            + " " + applyLeavePojo.getWebserviceArray().getTotalPaidPendingLeaves()
                            .getUserApplyLeave().getPaidWorkingDays());
                } else {
                    tv_pending_leave_balance.setVisibility(View.GONE);
                }

            } else {
                Log.e("Response", "Success?? " + applyLeavePojo.getStatus());
            }

        } else {

            Utilitity.dismissProgressDialog(progressBar);
            Log.e("ResponseD", "ResponseD?? " + applyLeavePojo.getStatus());

        }
    }

    @Override
    public void onFailure(Call<ApplyLeavePOJO> call, Throwable t) {
        Utilitity.dismissProgressDialog(progressBar);
        Log.e("onFailure", "onFailure?? " + t.getMessage());
    }

    /* Get Off Saturday List */
    public List<String> getOffSaturdayList() {
        return listOffSaturday;
    }

    /* Get national holidays List */
    public List<String> getNationalHolidaysList() {
        return listNationalHoliday;
    }


    /* Get textView for Working days Count */
    public TextView tv_working_days_d() {
        return tv_working_days_d;
    }

    /* Get textView for unpaid leave Count */
    public TextView tv_unpaid_leaves_count() {
        tv_unpaid_leaves_count.setVisibility(View.VISIBLE);
        return tv_unpaid_leaves_count;
    }

    /* Get textView for unpaid leave message */
    public TextView tv_leave_request_message() {
        tv_leave_request_message.setVisibility(View.VISIBLE);
        return tv_leave_request_message;
    }

    /* Notify Data Set Changed */
    public void notifyChange() {
        adapter_duration_type.notifyDataSetChanged();
        spnr_duration_type.setAdapter(adapter_duration_type);
        adapter_duration_types_array_second.notifyDataSetChanged();
        spnr_duration_type_second.setAdapter(adapter_duration_types_array_second);
    }

    /* Notify Data Set Changed For Leave Type*/
    public void notifyChangeForLeaveType(final int pos1, final int pos2) {

        // Initializing an ArrayAdapter
        adapter_leave_types_array = new ArrayAdapter<String>(
                getActivity(), R.layout.spinner_text, leaveList) {

            @Override
            public boolean isEnabled(int position) {
                if (position == pos1) {
                    // Disable the second item from Spinner
                    return false;

                } else if (position == pos2) {
                    // Disable the second item from Spinner
                    return false;

                } else {
                    return true;
                }
            }

            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                Utilitity.setTypeFace(getActivity(), view);
                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                Utilitity.setTypeFace(getActivity(), tv);
                if (position == pos1) {

                    // Set the disable item text color
                    tv.setTextColor(Color.GRAY);

                } else if (position == pos2) {

                    // Set the disable item text color
                    tv.setTextColor(Color.GRAY);

                } else {
                    tv.setTextColor(Color.parseColor("#383838"));
                }
                return view;
            }
        };

        adapter_leave_types_array.setDropDownViewResource(R.layout.spinner_text);
        spnr_leave_type.setAdapter(adapter_leave_types_array);
    }

    /* Date Set Call Back */
    @Override
    public void onDateSet(DatePickerDialog view, int yy, int mm, int dd) {

        if ((mm + 1 < 10)) {
            month = getString(R.string.default_zero_single) + String.valueOf(mm + 1);
        } else {
            month = String.valueOf(mm + 1);
        }

        if (dd < 10) {
            day = getString(R.string.default_zero_single) + String.valueOf(dd);
        } else {
            day = String.valueOf(dd);
        }

        if (listOffSaturday != null) {

            if (listOffSaturday.
                    contains(String.valueOf((month) + "/" + day + "/" + yy))) {

                Utilitity.showSnackBarError(getActivity(), HomeActivity.getInstance()
                                .getCoordinateLayout(),
                        getString(R.string.off_saturday));

            } else if (Utilitity.checkSunday(String.valueOf((day) + "-" + month + "-" + yy))) {

                Utilitity.showSnackBarError(getActivity(), HomeActivity.getInstance()
                                .getCoordinateLayout(),
                        getString(R.string.valid_date));

            } else {
                populateSetDate(yy, mm + 1, dd);
            }

        }

        notifyChange();
    }

    /* Method For populate date set */
    public void populateSetDate(int year, int month, int day) {

        if (DATE_PICKER_ID == DATE_PICKER_ID_F) {

            if (Utilitity.compareDates(day + "-" + month + "-" + year)) {

                edt_date_from.setText(day + "-" + month + "-" + year);
                //edt_date_from.setSelection(edt_date_from.getText().length());
                relative_date_to.setVisibility(View.VISIBLE);
                spnr_leave_type.setEnabled(true);
                //edt_reason.setEnabled(true);
                btn_reset.setEnabled(true);
                btn_reset.setBackgroundColor(Color.parseColor("#16a086"));

                if (edt_date_to.getText().toString() != null && !edt_date_to.getText()
                        .toString().equals("")) {

                    if (Utilitity.compareOwnDates(edt_date_from.getText().toString(),
                            edt_date_to.getText().toString())) {
                        edt_date_to.setText(edt_date_from.getText().toString());
                    }

                    if (edt_date_from.getText().toString().equals(edt_date_to.getText()
                            .toString())) {

                        relative_duration_type.setVisibility(View.VISIBLE);

                    } else {

                        relative_duration_type.setVisibility(View.GONE);

                    }

                }


            } else {

                Utilitity.showSnackBarError(getActivity(), HomeActivity.getInstance()
                                .getCoordinateLayout(),
                        getString(R.string.valid_date));
            }


        } else if (DATE_PICKER_ID == DATE_PICKER_ID_S) {

            if (Utilitity.compareDates(day + "-" + month + "-" + year)) {
                edt_date_to.setText(day + "-" + month + "-" + year);
                //edt_date_to.setSelection(edt_date_to.getText().length());
                edt_reason.setEnabled(true);
                btn_submit.setVisibility(View.VISIBLE);
                tv_unpaid_leaves_count.setVisibility(View.GONE);
                tv_leave_request_message.setVisibility(View.GONE);

                if (Utilitity.compareOwnDates(edt_date_from.getText().toString(),
                        edt_date_to.getText().toString())) {
                    edt_date_to.setText(edt_date_from.getText().toString());
                }

                if (edt_date_from.getText().toString().equals(edt_date_to.getText().toString())) {

                    relative_duration_type.setVisibility(View.VISIBLE);

                } else {

                    relative_duration_type.setVisibility(View.GONE);

                }

            } else {

                Utilitity.showSnackBarError(getActivity(), HomeActivity.getInstance()
                                .getCoordinateLayout(),
                        getString(R.string.valid_date));
            }
        }


        /* Calculate Date Difference */
        if (edt_date_to.getText().toString() != null && !edt_date_to.getText().toString().equals("")
                && edt_date_from.getText().toString() != null
                && !edt_date_from.getText().toString().equals("")) {

            tv_working_days_d.setText
                    (String.valueOf(Utilitity.calculateDateDifference
                            (edt_date_from.getText().toString(), edt_date_to.getText().toString()))
                            + getActivity().getString(R.string.default_zero));

            /* Available Leave Request Call */
            Utilitity.showProgressDialog(progressBar);
            availableLeaveRequest("1",
                    tv_working_days_d.getText().toString().trim().replace(".00", ""),
                    edt_date_from.getText().toString().trim(),
                    edt_date_to.getText().toString().trim());


        }
    }

    /* Custom Item Selected Listener For Spinner Type Two */
    public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String item = parent.getItemAtPosition(pos).toString();
            if (item.equals(getString(R.string.morning))) {
                duration_type_two = getString(R.string.am);
            } else if (item.equals(getString(R.string.afternoon))) {
                duration_type_two = getString(R.string.pm);
            } else {
                duration_type_two = "";
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }

    /* Custom Item Selected Listener For Spinner Leave Type */
    public class CustomOnItemSelectedListener2 implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String item = parent.getItemAtPosition(pos).toString();
            if (item.equals(getString(R.string.paid_leave))) {

                leave_type_id = getString(R.string.paid_status);

            } else if (item.equals(getString(R.string.unpaid_leave))) {

                leave_type_id = getString(R.string.unpaid_status);

            } else if (item.equals(getString(R.string.paid_unpaid_leave))) {

                leave_type_id = getString(R.string.paid_unpaid_status);

            } else {

                leave_type_id = "";
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }

    /* Make Rest Client Call For Getting Available Leave Request */
    private void availableLeaveRequest(String id, String dateDiff, String dateFrom, String dateTo) {

        Utilitity.showProgressDialog(progressBar);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT + Constant.APPENDED_PATH + Constant.AVAILABLE_LEAVES)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        RestClient restClientAPI = retrofit.create(RestClient.class);

        Call<AvailableLeavesRequestPOJO> call = restClientAPI.availableLeavesRequest(HomeActivity.getInstance()
                .getUser().getId(), id, dateDiff, dateFrom, dateTo);

        Callback<AvailableLeavesRequestPOJO> callback = new Callback<AvailableLeavesRequestPOJO>() {
            @Override
            public void onResponse(Call<AvailableLeavesRequestPOJO> call, Response<AvailableLeavesRequestPOJO> response) {
                AvailableLeavesRequestPOJO availableLeavesRequestPOJO = response.body();

                int code = response.code();
                if (code == RESPONSE_CODE) {

                    Utilitity.dismissProgressDialog(progressBar);

                    if (availableLeavesRequestPOJO.getStatus().equals(TRUE)) {

                        if (availableLeavesRequestPOJO.getClassName().equals(SUCCESS)) {

                            tv_unpaid_leaves_count.setVisibility(View.VISIBLE);
                            tv_unpaid_leaves_count.setText(
                                    getString(R.string.total_paid_leave)
                                            + " " + availableLeavesRequestPOJO.getTotalPaidLeavesBalance()
                                            + "\n" +
                                            getString(R.string.paid_leaves)
                                            + " " +
                                            tv_working_days_d.getText().toString());

                            tv_leave_request_message.setVisibility(View.GONE);
                            notifyChangeForLeaveType(2, 3);


                        } else {

                            if (availableLeavesRequestPOJO.getPaidLeaves().equals("")) {

                                tv_unpaid_leaves_count.setVisibility(View.VISIBLE);
                                tv_unpaid_leaves_count.setText(
                                        getString(R.string.unpaid_leaves)
                                                + " " +
                                                availableLeavesRequestPOJO.getUnpaidLeaves());

                                tv_leave_request_message.setVisibility(View.VISIBLE);
                                tv_leave_request_message.setText(availableLeavesRequestPOJO.getMessage()
                                        .replace("don&#039;t", getString(R.string.dont)));
                                notifyChangeForLeaveType(1, 3);

                            } else {
                                tv_unpaid_leaves_count.setVisibility(View.VISIBLE);
                                tv_unpaid_leaves_count.setText(
                                        getString(R.string.total_paid_leave)
                                                + " " + availableLeavesRequestPOJO.getLeave()
                                                + "\n" +
                                                getString(R.string.paid_leaves)
                                                + " " +
                                                availableLeavesRequestPOJO.getPaidLeaves()
                                                + "\n" +
                                                getString(R.string.unpaid_leaves)
                                                + " " +
                                                availableLeavesRequestPOJO.getUnpaidLeaves());

                                tv_leave_request_message.setVisibility(View.VISIBLE);
                                tv_leave_request_message.setText(availableLeavesRequestPOJO.getMessage()
                                        .replace("don&#039;t", getString(R.string.dont)));
                                notifyChangeForLeaveType(1, 2);
                            }

                        }

                        if (availableLeavesRequestPOJO.getAppliedLeaveLimit() != null && !availableLeavesRequestPOJO.getAppliedLeaveLimit().equals("")) {
                            applied_leave_limit = availableLeavesRequestPOJO.getAppliedLeaveLimit();
                        } else {
                            applied_leave_limit = "";
                        }

                        if (availableLeavesRequestPOJO.getLeave() != null && !availableLeavesRequestPOJO.getLeave().equals("")) {
                            leave = availableLeavesRequestPOJO.getLeave();
                        } else {
                            leave = "";
                        }

                        if (availableLeavesRequestPOJO.getLeaveTypeId() != null && !availableLeavesRequestPOJO.getLeaveTypeId().equals("")) {
                            leave_type_id2 = availableLeavesRequestPOJO.getLeaveTypeId();
                        } else {
                            leave_type_id2 = "";
                        }


                    } else {
                        Log.e("Response_RESD", "Success?? " + availableLeavesRequestPOJO.getStatus());
                    }

                } else {

                    Utilitity.dismissProgressDialog(progressBar);
                    Log.e("ResponseD", "ResponseD?? " + availableLeavesRequestPOJO.getStatus());

                }
            }

            @Override
            public void onFailure(Call<AvailableLeavesRequestPOJO> call, Throwable t) {
                Utilitity.dismissProgressDialog(progressBar);
                Log.e("onFailure", "onFailure?? " + t.getMessage());
            }
        };

        //asynchronous call
        call.enqueue(callback);
    }

    /* Make Rest Client Call For Submit Leave Request */
    private void submitLeaveRequest(String leave_status_id, String dateFrom, String dateTo,
                                    String duration_type, String half_day, String number_of_days,
                                    String holidays, String working_days, String leave_type_id, String reason,
                                    String leave_balance, String applied_leave_limit,
                                    String leave, String leave_type_id2) {

        Utilitity.showProgressDialog(progressBar);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT + Constant.APPENDED_PATH + Constant.APPLY_LEAVE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        RestClient restClientAPI = retrofit.create(RestClient.class);

        Call<ApplyLeavesRequestPOJO> call = restClientAPI.submitRequest(HomeActivity.getInstance()
                        .getUser().getId(), leave_status_id, dateFrom, dateTo,
                duration_type, half_day, number_of_days, holidays, working_days, leave_type_id, reason,
                leave_balance, applied_leave_limit, leave, leave_type_id2, HomeActivity.getInstance()
                        .getUser().getId());

        Callback<ApplyLeavesRequestPOJO> callback = new Callback<ApplyLeavesRequestPOJO>() {
            @Override
            public void onResponse(Call<ApplyLeavesRequestPOJO> call, Response<ApplyLeavesRequestPOJO> response) {
                ApplyLeavesRequestPOJO applyLeavesRequestPOJO = response.body();
                int code = response.code();
                if (code == RESPONSE_CODE) {

                    Utilitity.dismissProgressDialog(progressBar);

                    if (applyLeavesRequestPOJO.getStatus().equals(SUCCESS)) {

                        Log.e("Response", "Success?? " + applyLeavesRequestPOJO.getStatus());
                        Utilitity.showSnackBarWithCallBack(getActivity(),
                                HomeActivity.getInstance().getCoordinateLayout(),
                                applyLeavesRequestPOJO.getMessage());

                    } else {
                        Log.e("Response", "Success?? " + applyLeavesRequestPOJO.getStatus());
                        Utilitity.showSnackBarError(getActivity(),
                                HomeActivity.getInstance().getCoordinateLayout(),
                                applyLeavesRequestPOJO.getMessage());
                    }

                } else {

                    Utilitity.dismissProgressDialog(progressBar);
                    Log.e("ResponseD", "ResponseD?? " + applyLeavesRequestPOJO.getStatus());

                }
            }

            @Override
            public void onFailure(Call<ApplyLeavesRequestPOJO> call, Throwable t) {
                Utilitity.dismissProgressDialog(progressBar);
                Log.e("onFailure", "onFailure?? " + t.getMessage());
            }
        };

        //asynchronous call
        call.enqueue(callback);
    }
}
