package com.b18cn082.smart_money;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.b18cn082.smart_money.addapter.ShowSpendAdapter;
import com.b18cn082.smart_money.model.PlanResponse;
import com.b18cn082.smart_money.model.Spend;
import com.b18cn082.smart_money.model.SpendReportRequest;
import com.b18cn082.smart_money.model.SpendReportResponse;
import com.b18cn082.smart_money.util.APIUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowSpendActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnCancel;
    private ShowSpendAdapter showSpendAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_spend);
        btnCancel = findViewById(R.id.btnCancelSpend);
        showSpendAdapter = new ShowSpendAdapter(new ArrayList<>());
        recyclerView = findViewById(R.id.recyclerViewSpend);
        recyclerView.setAdapter(showSpendAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(ShowSpendActivity.this,1));
        btnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(ShowSpendActivity.this, MainActivity.class);
            startActivity(intent);
        });
        APIUtils.getApiServiceInterface().getReport(new SpendReportRequest(Manger.user.getId())).enqueue(new Callback<SpendReportResponse>() {
            @Override
            public void onResponse(Call<SpendReportResponse> call, Response<SpendReportResponse> response) {
                if (response.isSuccessful() && response.body()!=null){
                    SpendReportResponse spendReportResponse = response.body();
                    showSpendAdapter.setListSpend(spendReportResponse.getListSpend());
                }
            }

            @Override
            public void onFailure(Call<SpendReportResponse> call, Throwable t) {

            }
        });
    }
}
