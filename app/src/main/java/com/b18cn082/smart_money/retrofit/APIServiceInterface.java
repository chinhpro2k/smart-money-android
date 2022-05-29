package com.b18cn082.smart_money.retrofit;

import com.b18cn082.smart_money.model.Plan;
import com.b18cn082.smart_money.model.PlanCreateRequest;
import com.b18cn082.smart_money.model.PlanCreateResponse;
import com.b18cn082.smart_money.model.PlanResponse;
import com.b18cn082.smart_money.model.Question;
import com.b18cn082.smart_money.model.QuestionResponse;
import com.b18cn082.smart_money.model.RegisterResponse;
import com.b18cn082.smart_money.model.Spend;
import com.b18cn082.smart_money.model.SpendCreateRequest;
import com.b18cn082.smart_money.model.SpendCreateResponse;
import com.b18cn082.smart_money.model.SpendReportRequest;
import com.b18cn082.smart_money.model.SpendReportResponse;
import com.b18cn082.smart_money.model.User;
import com.b18cn082.smart_money.model.UserExpenseStatistic;
import com.b18cn082.smart_money.model.UserRegistation;
import com.b18cn082.smart_money.model.UserToLogin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIServiceInterface {

      @POST("members/register")
      Call<RegisterResponse> register(@Body User user);

      @POST("members/login")
      Call<User> login(@Body UserToLogin userToLogin);

      @POST("members/register")
      Call<User> register(@Body UserRegistation userRegistation);


      @GET("question")
      Call<QuestionResponse> getAllQuestions();

      @GET("plan")
      Call<PlanResponse> getAllPlan();

      @POST("plan/add")
      Call<PlanCreateResponse> createPlan(@Body PlanCreateRequest planCreateRequest);

      @POST("spend/add")
      Call<SpendCreateResponse> createSpend(@Body SpendCreateRequest spendCreateRequest);

      @POST("spend/report")
      Call<SpendReportResponse> getReport(@Body SpendReportRequest spendReportRequest);

}
