package com.b18cn082.smart_money.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.b18cn082.smart_money.PlanList;
import com.b18cn082.smart_money.R;
import com.b18cn082.smart_money.addapter.SuggestAdapter;
import com.b18cn082.smart_money.model.Plan;
import com.b18cn082.smart_money.model.PlanCreateRequest;
import com.b18cn082.smart_money.model.PlanCreateResponse;
import com.b18cn082.smart_money.util.APIUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCreatePlan extends Fragment {
    private TextView title, description;
    private Button btnSave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_plan, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.ed_name_plan);
        description = view.findViewById(R.id.ed_description);
        btnSave = view.findViewById(R.id.btn_save);
        System.out.println(PlanList.planList.toString());
        btnSave.setOnClickListener(view1 -> {
            APIUtils.getApiServiceInterface().createPlan(new PlanCreateRequest(title.getText().toString(), description.getText().toString()))
                    .enqueue(new Callback<PlanCreateResponse>() {
                        @Override
                        public void onResponse(Call<PlanCreateResponse> call, Response<PlanCreateResponse> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                PlanCreateResponse planCreateResponse = response.body();
                                List<Plan> planList = PlanList.planList;

                                Plan plan = new Plan(planCreateResponse.getPlan().getId(),
                                        planCreateResponse.getPlan().getTitle(),
                                        planCreateResponse.getPlan().getDescription(),
                                        planCreateResponse.getPlan().getV());
                                Toast.makeText(getActivity(), planCreateResponse.getPlan().getTitle(), Toast.LENGTH_LONG).show();
                                planList.add(plan);
                                PlanList.planList = planList;
                                Toast.makeText(getActivity(), planCreateResponse.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<PlanCreateResponse> call, Throwable t) {

                        }
                    });
        });

    }
}