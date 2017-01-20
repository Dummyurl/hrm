package com.ourdesignz.hrm.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ourdesignz.hrm.R;
import com.ourdesignz.hrm.activity.HomeActivity;
import com.ourdesignz.hrm.fragment.MyLeaveFragment;
import com.ourdesignz.hrm.interfaces.Constant;
import com.ourdesignz.hrm.interfaces.RestClient;
import com.ourdesignz.hrm.model.DeleteLeavePOJO;
import com.ourdesignz.hrm.model.LeaveListPOJO;
import com.ourdesignz.hrm.utilities.Utilitity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ourdesignz on 30/9/16.
 */

public class LeaveListAdapter extends RecyclerView.Adapter<LeaveListAdapter.MyViewHolder> implements
        Constant, Callback<DeleteLeavePOJO> {
    private static LeaveListAdapter mContext;
    private List<LeaveListPOJO.UserApplyleaf> userApplyLeaves;
    private LayoutInflater inflater;
    private Context context;
    private int pos;

    /* LeaveListAdapter Instance */
    public static LeaveListAdapter getInstance() {
        return mContext;
    }

    public LeaveListAdapter(Context context, List<LeaveListPOJO.UserApplyleaf> userApplyLeaves) {
        mContext = LeaveListAdapter.this;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.userApplyLeaves = userApplyLeaves;
    }

    public void delete(int position) {
        userApplyLeaves.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    @Override
    public LeaveListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.leaves_list_items, parent, false);
        LeaveListAdapter.MyViewHolder holder = new LeaveListAdapter.MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(LeaveListAdapter.MyViewHolder holder, final int position) {
        holder.tv_leave_type.setText(userApplyLeaves.get(position).getLeaveType().getName());
        holder.tv_date.setText(Utilitity.formatDateFromStringnNew(userApplyLeaves.get(position)
                .getUserApplyLeave().getDateFrom())
                + " "
                + context.getResources().getString(R.string.to)
                + " "
                + Utilitity.formatDateFromStringnNew(userApplyLeaves.get(position)
                .getUserApplyLeave().getDateTo()));

        if (userApplyLeaves.get(position).getLeaveStatus().getTitle() != null
                && userApplyLeaves.get(position).getLeaveStatus().getTitle().equals(PENDING)) {

            holder.btn_action.setText(context.getString(R.string.cancel));
            holder.btn_action.setBackgroundColor(Color.parseColor("#BD362F"));

        } else if (userApplyLeaves.get(position).getLeaveStatus().getTitle() != null
                && userApplyLeaves.get(position).getLeaveStatus().getTitle().equals(APPROVED)) {

            holder.btn_action.setText(context.getString(R.string.approved));
            holder.btn_action.setBackgroundColor(Color.parseColor("#34A853"));

        } else if (userApplyLeaves.get(position).getLeaveStatus().getTitle() != null
                && userApplyLeaves.get(position).getLeaveStatus().getTitle().equals(REJECTED)) {

            holder.btn_action.setText(context.getString(R.string.rejected));
            holder.btn_action.setBackgroundColor(Color.parseColor("#D3D3D3"));

        }

        holder.btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MyLeaveFragment.getInstance().getDialog().isShowing()) {
                    MyLeaveFragment.getInstance().getDialog().dismiss();
                }

                if (userApplyLeaves.get(position).getLeaveStatus().getTitle() != null
                        && userApplyLeaves.get(position).getLeaveStatus().getTitle().equals(PENDING)) {

                    try {
                        pos = position;
                        showListDialog(position);
                    } catch (Exception e) {
                        Log.e("e", "e?" + e.getMessage());
                    }
                }


            }
        });
    }

    /* Show Dialog For Indicate User For This Leave Or Not*/
    private void showListDialog(final int position) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        Typeface tf2 = Typeface.createFromAsset(context.getAssets(), fontPath2);
        MaterialDialog.Builder builder = new MaterialDialog.Builder(context)
                .content(context.getString(R.string.sure))
                .typeface(tf2, tf)
                .positiveText(context.getString(R.string.yes))
                .negativeText(context.getString(R.string.no));

        builder.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                /* Delete Leave Request Call */
                deleteLeaveRequest(userApplyLeaves.get(position).getUserApplyLeave().getId());

            }
        })

                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                });

        MaterialDialog dialog = builder.build();
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return userApplyLeaves.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_leave_type;
        TextView tv_date;
        TextView tv_days;
        TextView tv_status;
        TextView tv_reason;
        Button btn_action;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_leave_type = (TextView) itemView.findViewById(R.id.tv_leave_type);
            Utilitity.setTypeFace(context, tv_leave_type);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            Utilitity.setTypeFace(context, tv_date);
            tv_days = (TextView) itemView.findViewById(R.id.tv_days);
            Utilitity.setTypeFace(context, tv_days);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);
            Utilitity.setTypeFace(context, tv_status);
            tv_reason = (TextView) itemView.findViewById(R.id.tv_reason);
            Utilitity.setTypeFace(context, tv_reason);
            btn_action = (Button) itemView.findViewById(R.id.btn_action);
            Utilitity.setTypeFace(context, btn_action);

        }
    }

    /* Make Call For Delete Leave Request */
    private void deleteLeaveRequest(String id) {
        Utilitity.showProgressDialog(MyLeaveFragment.getInstance().getProgressBar());

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.ROOT + Constant.APPENDED_PATH + Constant.LEAVE_DELETE + id + Constant.DEFAULT_VALUE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        // prepare call in Retrofit 2.0
        RestClient restClientAPI = retrofit.create(RestClient.class);

        Call<DeleteLeavePOJO> call = restClientAPI.deleteLeave(HomeActivity.getInstance().getUser().getId());

        //asynchronous call
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<DeleteLeavePOJO> call, Response<DeleteLeavePOJO> response) {
        DeleteLeavePOJO deleteLeavePojo = response.body();

        int code = response.code();
        if (code == RESPONSE_CODE) {

            Utilitity.dismissProgressDialog(MyLeaveFragment.getInstance().getProgressBar());


            if (deleteLeavePojo.getStatus().equals(SUCCESS)) {

                delete(pos);
                Log.e("Response", "Success?? " + deleteLeavePojo.getStatus());
                Utilitity.showSnackBar(context,
                        HomeActivity.getInstance().getCoordinateLayout(),
                        deleteLeavePojo.getMessage());

            } else {
                Log.e("Response", "Success?? " + deleteLeavePojo.getStatus());
                Utilitity.showSnackBarError(context,
                        HomeActivity.getInstance().getCoordinateLayout(),
                        deleteLeavePojo.getMessage());
            }

        } else {

            Utilitity.dismissProgressDialog(MyLeaveFragment.getInstance().getProgressBar());
            Log.e("ResponseD", "ResponseD?? ");

        }
    }

    @Override
    public void onFailure(Call<DeleteLeavePOJO> call, Throwable t) {
        Utilitity.dismissProgressDialog(MyLeaveFragment.getInstance().getProgressBar());
        Log.e("onFailure", "onFailure?? " + t.getMessage());
    }

    /* Get User Apply Leave List */
    public List<LeaveListPOJO.UserApplyleaf> getLeaveList() {
        return userApplyLeaves;
    }

}
