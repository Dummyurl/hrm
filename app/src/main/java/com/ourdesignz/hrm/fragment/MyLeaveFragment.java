package com.ourdesignz.hrm.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ourdesignz.hrm.R;
import com.ourdesignz.hrm.activity.HomeActivity;
import com.ourdesignz.hrm.adapter.LeaveListAdapter;
import com.ourdesignz.hrm.interfaces.Constant;
import com.ourdesignz.hrm.interfaces.RestClient;
import com.ourdesignz.hrm.model.LeaveListPOJO;
import com.ourdesignz.hrm.utilities.Utilitity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ourdesignz on 26/9/16.
 */
public class MyLeaveFragment extends Fragment implements Constant, Callback<LeaveListPOJO> {
    private static MyLeaveFragment mContext;
    private RecyclerView recycle_my_leaves;
    private ProgressBar progressBar;
    private LeaveListAdapter adapter;
    private TextView tv_leave_type_title;
    private TextView tv_date_title;
    private TextView tv_action_title;
    private MaterialDialog dialog;

    public MyLeaveFragment() {
        // Required empty public constructor
    }

    // ApplyForLeaveFragment Instance
    public static MyLeaveFragment getInstance() {
        return mContext;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = MyLeaveFragment.this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_my_leave, container, false);
        tv_leave_type_title = (TextView) rootView.findViewById(R.id.tv_leave_type_title);
        Utilitity.setTypeFace2(getActivity(), tv_leave_type_title);
        tv_date_title = (TextView) rootView.findViewById(R.id.tv_date_title);
        Utilitity.setTypeFace2(getActivity(), tv_date_title);
        tv_action_title = (TextView) rootView.findViewById(R.id.tv_action_title);
        Utilitity.setTypeFace2(getActivity(), tv_action_title);

        recycle_my_leaves = (RecyclerView) rootView.findViewById(R.id.recycle_my_leaves);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        recycle_my_leaves.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycle_my_leaves.addOnItemTouchListener(new
                MyLeaveFragment.RecyclerTouchListener(getActivity(),
                recycle_my_leaves, new MyLeaveFragment.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                if (Utilitity.isNetworkAvailable(getActivity())) {

                    showListDialog(position);

                } else {
                    Utilitity.showSnackBarError(getActivity(),
                            HomeActivity.getInstance().getCoordinateLayout(),
                            getResources().getString(R.string.no_internet_connection));

                }

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        // Inflate the layout for this fragment
        return rootView;
    }

    /* Show Dialog When Click Item On list view */
    private void showListDialog(int position) {
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), fontPath2);
        Typeface tf2 = Typeface.createFromAsset(getActivity().getAssets(), fontPath2);
        dialog = new MaterialDialog.Builder(getActivity())
                .content(getString(R.string.leave_type) + ":" + " " +
                        LeaveListAdapter.getInstance().getLeaveList()
                                .get(position).getLeaveType().getName() + "\n" +

                        getString(R.string.date_from) + ":" + " " +
                        Utilitity.formatDateFromStringnNew(LeaveListAdapter
                                .getInstance().getLeaveList().get(position)
                                .getUserApplyLeave().getDateFrom())
                        + "\n" +

                        getString(R.string.date_to) + ":" + " " +
                        Utilitity.formatDateFromStringnNew(
                                LeaveListAdapter.getInstance().getLeaveList().get(position)
                                        .getUserApplyLeave().getDateTo()) + "\n" +
                        getString(R.string.days) + ":" + " " +
                        LeaveListAdapter.getInstance().getLeaveList()
                                .get(position).getUserApplyLeave().getWorkingDays() + "\n" +
                        getString(R.string.status) + ":" + " " +
                        LeaveListAdapter.getInstance().getLeaveList()
                                .get(position).getLeaveStatus().getTitle() + "\n" +
                        getString(R.string.reason) + ":" + " " +
                        LeaveListAdapter.getInstance().getLeaveList()
                                .get(position).getUserApplyLeave().getReason())
                .typeface(tf2, tf)
                .negativeText(getString(R.string.close))
                .show();

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
        if (Utilitity.isNetworkAvailable(getActivity())) {

            myLeaveListRequest();

        } else {
            Utilitity.showSnackBarError(getActivity(),
                    HomeActivity.getInstance().getCoordinateLayout(),
                    getResources().getString(R.string.no_internet_connection));

        }

    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private MyLeaveFragment.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final MyLeaveFragment.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    /* Make Call For Leave List Request */
    public void myLeaveListRequest() {
        Utilitity.showProgressDialog(progressBar);
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT + Constant.APPENDED_PATH + Constant.LEAVE_LIST)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // prepare call in Retrofit 2.0
        RestClient restClientAPI = retrofit.create(RestClient.class);

        Call<LeaveListPOJO> call = restClientAPI.leaveListRequest(HomeActivity.getInstance().getUser().getId());

        //asynchronous call
        call.enqueue(this);
    }

    /* Response Call Back For Leave List Request */
    @Override
    public void onResponse(Call<LeaveListPOJO> call, Response<LeaveListPOJO> response) {
        LeaveListPOJO leaveListPojo = response.body();

        int code = response.code();
        if (code == RESPONSE_CODE) {

            Utilitity.dismissProgressDialog(progressBar);

            if (leaveListPojo.getStatus().equals(SUCCESS)) {

                Log.e("Response", "Success?? " + leaveListPojo.getStatus());
                setAdapter(leaveListPojo.getUserApplyLeaves());

            } else {
                Log.e("Response", "Success_error?? " + leaveListPojo.getStatus());
            }

        } else {

            Utilitity.dismissProgressDialog(progressBar);
            Log.e("ResponseD", "ResponseD?? " + leaveListPojo.getStatus());

        }
    }

    @Override
    public void onFailure(Call<LeaveListPOJO> call, Throwable t) {
        Utilitity.dismissProgressDialog(progressBar);
        Log.e("onFailure", "onFailure?? " + t.getMessage());
    }

    /* Set adapter For Leave List Fragment */
    private void setAdapter(List<LeaveListPOJO.UserApplyleaf> userApplyLeaves) {
        adapter = new LeaveListAdapter(getActivity(), userApplyLeaves);
        recycle_my_leaves.setAdapter(adapter);
    }

    /* Get Progress Bar */
    public ProgressBar getProgressBar() {
        return progressBar;
    }

    /* Get MaterialDialog */
    public MaterialDialog getDialog() {
        return dialog;
    }

}
