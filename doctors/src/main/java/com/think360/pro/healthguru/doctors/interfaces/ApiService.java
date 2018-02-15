package com.think360.pro.healthguru.doctors.interfaces;


import com.think360.pro.healthguru.doctors.model.CountryResponse;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * Created by think360 on 18/04/17.
 */

public interface ApiService {
   @POST("getcountry")
   Call<CountryResponse> getCountries();
   /* @FormUrlEncoded
    @POST("login")
    Call<User> loginUser(@Field("email") String name, @Field("password") String password, @Field("device_id") String device_id, @Field("device_type") String device_type);

    @FormUrlEncoded
    @POST("forget_password")
    Call<ForgetPasswordResponse> forgetPassword(@Field("mobile") String name);

    @FormUrlEncoded
    @POST("verify_otp")
    Call<VerifyOtpResponse> verifyOtp(@Field("id") String driver_id, @Field("otp") String name);

    @FormUrlEncoded
    @POST("resend_otp")
    Call<ResendOtpResponse> resendOtp(@Field("id") String driver_id);

    @POST("getcountry")
    Call<CountryResponse> getCountries();

    @FormUrlEncoded
    @POST("getState")
    Call<StateResponse> getStates(@Field("country_id") String country_id, @Field("state_id") String state_id);

    @FormUrlEncoded
    @POST("getState")
    Call<CityResponse> getCity(@Field("country_id") String country_id, @Field("state_id") String state_id);

    @FormUrlEncoded
    @POST("addavailability")
    Call<AvailabilityResponse> addAvailability(@Field("driver_id") int driver_id, @Field("start_date") String start_date, @Field("from_time") String from_time, @Field("to_time") String to_time, @Field("country_id") String country_id, @Field("state_id") String state_id, @Field("city_id") String city_id, @Field("zones") String zones);


    @FormUrlEncoded
    @POST("availablity_edit")
    Call<AvailabilityResponse> addAvailabilityEdit(@Field("driver_id") int driver_id, @Field("id") String id, @Field("start_date") String start_date, @Field("from_time") String from_time, @Field("to_time") String to_time, @Field("country_id") String country_id, @Field("state_id") String state_id, @Field("city_id") String city_id, @Field("zones") String zones);


    @FormUrlEncoded
    @POST("getavalibility")
    Call<GetAvaliabilityResponse> getAvailability(@Field("driver_id") int driver_id);

    @FormUrlEncoded
    @POST("avalibilityapprove")
    Call<ApprovedScheduleRespponse> getAvailabilityApproved(@Field("driver_id") int id);

    @FormUrlEncoded
    @POST("avalibilitynonapprove")
    Call<ApprovedNonResponse> getAvailabilityNonApproved(@Field("driver_id") int id);

    @FormUrlEncoded
    @POST("getnon_approvedavalibality")
    Call<NonApprovedTripDetail> getNonApproveAvailDetail(@Field("id") String id);

    @FormUrlEncoded
    @POST("userlogout")
    Call<LogoutResponse> logoutDriver(@Field("id") int id);

    @FormUrlEncoded
    @POST("acceptReject_sos")
    Call<AcceptRejectSosResponse> acceptRejectSos(@Field("driver_id") int driver_id, @Field("sos_id") String sos_id, @Field("status") int status);

    @POST("get_sosall")
    Call<AllSoSResponse> getAllSoS();

    @FormUrlEncoded
    @POST("avail_list")
    Call<Example> getavailDetail(@Field("driver_id") String driver_id, @Field("schedule_id") String schedule_id);
    @FormUrlEncoded
    @POST("sos_details")
    Call<SoSDetailResponse> getSoSDetail(@Field("sos_id") String sos_id);
    @FormUrlEncoded
    @POST("completeschdule")
    Call<CompletedScheduleResponse> getCompleteSchdule(@Field("driver_id") int driver_id);

    @FormUrlEncoded
    @POST("schdule_details")
    Call<ScheduleDetailResponse> getSchduleDetails(@Field("schdule_id") String schdule_id);


    @FormUrlEncoded
    @POST("driver_trip")
    Call<TripFinishStartResponse> tripStart(@Field("driver_id") int driver_id, @Field("start_trip") String start_trip, @Field("avail_id") String avail_id);

    @FormUrlEncoded
    @POST("driver_tripFinish")
    Call<TripFinishStartResponse> tripFinish(@Field("driver_id") int driver_id, @Field("end_trip") String start_trip, @Field("avail_id") String avail_id, @Field("tripid") String tripid);


    @FormUrlEncoded
    @POST("contact_operator")
    Call<TripFinishStartResponse> contactToOperator(@Field("driver_id") int driver_id, @Field("schdule_id") String schdule_id, @Field("message") String message, @Field("Subject") String Subject);

    @FormUrlEncoded
    @POST("pending_schdule")
    Call<PedningScheduleResponse> getPendingSchedule(@Field("driver_id") int driver_id);

    @FormUrlEncoded
    @POST("driver_history")
    Call<UserProfileResponse> getDriverProfile(@Field("id") int id);


    @FormUrlEncoded
    @POST("sos_count")
    Call<SosCountResponse> getSosCount(@Field("driver_id") int id);

    @FormUrlEncoded
    @POST("readsoscount")
    Call<Sosread> readSos(@Field("driver_id") int id);

    @Multipart
    @POST("driveredit")
    Call<UserProfileResponse> editDriverProfile(@Part("id") RequestBody userid, @Part("driver_name") RequestBody name, @Part("password") RequestBody password, @Part MultipartBody.Part file);


    @FormUrlEncoded
    @POST("change_password")
    Call<ChangePasswordResponse> changePassword(@Field("driver_id") String driver_id, @Field("current_password") String current_password, @Field("new_password") String new_password);

    // for RXJava
    @FormUrlEncoded
    @POST("workerprofile/")
    Observable<WorkHistory> getWorkHistory(@Field("id") int password);

*/

}
