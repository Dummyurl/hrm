package com.ourdesignz.hrm.interfaces;

import com.ourdesignz.hrm.model.ApplyLeavePOJO;
import com.ourdesignz.hrm.model.ApplyLeavesRequestPOJO;
import com.ourdesignz.hrm.model.AvailableLeavesRequestPOJO;
import com.ourdesignz.hrm.model.DeleteLeavePOJO;
import com.ourdesignz.hrm.model.HomePOJO;
import com.ourdesignz.hrm.model.LeaveListPOJO;
import com.ourdesignz.hrm.model.LogInPOJO;
import com.ourdesignz.hrm.model.LogOutPOJO;
import com.ourdesignz.hrm.model.OtpPOJO;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ourdesignz on 22/9/16.
 */
public interface RestClient {

    @FormUrlEncoded
    @POST("./")
    Call<LogInPOJO> logInRequest(@Field("data[User][username]") String username,
                                 @Field("data[User][password]") String password);

    @GET("./")
    Call<LogOutPOJO> logOutRequest(@Query("user_id") String user_id);

    @GET("./")
    Call<HomePOJO> loadHomeRequest(@Query("user_id") String user_id);

    @GET("./")
    Call<OtpPOJO> otpRequest();

    @GET("./")
    Call<ApplyLeavePOJO> applyLeaveRequest(@Query("user_id") String user_id);

    @GET("./")
    Call<LeaveListPOJO> leaveListRequest(@Query("user_id") String user_id);

    @FormUrlEncoded
    @POST("./")
    Call<AvailableLeavesRequestPOJO> availableLeavesRequest(@Field("user_id") String user_id,
                                                            @Field("data[id]") String id,
                                                            @Field("data[leaveApplied]") String leaveApplied,
                                                            @Field("data[userApplyLeaveDateFrom]") String dateFrom,
                                                            @Field("data[userApplyLeaveDateTo]") String dateTo);


    @FormUrlEncoded
    @POST("./")
    Call<ApplyLeavesRequestPOJO> submitRequest(@Field("data[UserApplyLeave][user_id]") String user_id,
                                     @Field("data[UserApplyLeave][leave_status_id]") String leave_status_id,
                                     @Field("data[UserApplyLeave][date_from]") String date_from,
                                     @Field("data[UserApplyLeave][date_to]") String date_to,
                                     @Field("data[UserApplyLeave][duration_type]") String duration_type,
                                     @Field("data[UserApplyLeave][half_day]") String half_day,
                                     @Field("data[UserApplyLeave][number_of_days]") String number_of_days,
                                     @Field("data[UserApplyLeave][holidays]") String holidays,
                                     @Field("data[UserApplyLeave][working_days]") String working_days,
                                     @Field("data[UserApplyLeave][leave_type_id]") String leave_type_id,
                                     @Field("data[UserApplyLeave][reason]") String reason,
                                     @Field("data[UserApplyLeave][leave_balance]") String leave_balance,
                                     @Field("data[applied_leave_limit]") String applied_leave_limit,
                                     @Field("data[leave]") String leave,
                                     @Field("data[leave_type_id]") String leave_type_id2,
                                     @Field("data[user_id]") String user_id2);

    @GET("./")
    Call<DeleteLeavePOJO> deleteLeave(@Query("user_id") String user_id);
}
