package com.b18cn082.smart_money.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.b18cn082.smart_money.PlanList;
import com.b18cn082.smart_money.R;
import com.b18cn082.smart_money.addapter.SuggestAdapter;
import com.b18cn082.smart_money.model.Plan;
import com.b18cn082.smart_money.model.PlanResponse;
import com.b18cn082.smart_money.model.Question;
import com.b18cn082.smart_money.model.QuestionResponse;
import com.b18cn082.smart_money.util.APIUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSuggest extends Fragment {
    private RecyclerView recyclerView;
    private SuggestAdapter suggestAdapter;
    private List<Plan> planList;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suggest,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewSuggest);
        suggestAdapter = new SuggestAdapter(new ArrayList<>());
        swipeRefreshLayout = view.findViewById(R.id.suggest_layout);
        suggestAdapter.setItemClickListener(question -> {
            //to do st when click btn select in adapter
            Toast.makeText(getActivity(),"Chọn thành công",Toast.LENGTH_LONG).show();
        });
        recyclerView.setAdapter(suggestAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));

        APIUtils.getApiServiceInterface().getAllPlan()
                .enqueue(new Callback<PlanResponse>() {
                    @Override
                    public void onResponse(Call<PlanResponse> call, Response<PlanResponse> response) {
                        if (response.isSuccessful() && response.body()!=null){
                            PlanResponse planResponse =response.body();
                            planList=planResponse.getListPlan();
                            PlanList.planList=planList;
                            suggestAdapter.setListPlan(planList);
                        }
                    }

                    @Override
                    public void onFailure(Call<PlanResponse> call, Throwable t) {

                    }
                });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                APIUtils.getApiServiceInterface().getAllPlan()
                        .enqueue(new Callback<PlanResponse>() {
                            @Override
                            public void onResponse(Call<PlanResponse> call, Response<PlanResponse> response) {
                                if (response.isSuccessful() && response.body()!=null){
                                    PlanResponse planResponse =response.body();
                                    planList=planResponse.getListPlan();
                                    PlanList.planList=planList;
                                    suggestAdapter.setListPlan(planList);
                                }
                            }

                            @Override
                            public void onFailure(Call<PlanResponse> call, Throwable t) {

                            }
                        });
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}
