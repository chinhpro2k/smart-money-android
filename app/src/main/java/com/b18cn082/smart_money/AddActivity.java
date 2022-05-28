package com.b18cn082.smart_money;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.b18cn082.smart_money.model.SpendCreateRequest;
import com.b18cn082.smart_money.model.SpendCreateResponse;
import com.b18cn082.smart_money.util.APIUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {
    private Button btnCancel;
    private Spinner sp;
    private EditText edTitle,edPrice;
    private Button btnUpdate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();

        btnCancel.setOnClickListener(view -> {
            Intent intent = new Intent(AddActivity.this, MainActivity.class);
            startActivity(intent);
        });

        btnUpdate.setOnClickListener(view -> {
            APIUtils.getApiServiceInterface().createSpend(new SpendCreateRequest(edTitle.getText().toString(),
                    edPrice.getText().toString(),
                    sp.getSelectedItem().toString(),
                    Manger.user.getId())).enqueue(new Callback<SpendCreateResponse>() {
                @Override
                public void onResponse(Call<SpendCreateResponse> call, Response<SpendCreateResponse> response) {
                    if (response.isSuccessful() && response.body()!=null){
                        SpendCreateResponse spendCreateResponse =response.body();
                        Toast.makeText(AddActivity.this,spendCreateResponse.getMessage(),Toast.LENGTH_LONG).show();
                        edTitle.setText("");
                        edPrice.setText("");

                    }
                }

                @Override
                public void onFailure(Call<SpendCreateResponse> call, Throwable t) {

                }
            });
        });
    }
    private void initView() {
        sp=findViewById(R.id.spinner_category);
        edTitle = findViewById(R.id.edTitle);
        edPrice = findViewById(R.id.edPrice);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnCancel = findViewById(R.id.btnCancel);
        sp.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,
                getResources().getStringArray(R.array.category)));
    }
}
