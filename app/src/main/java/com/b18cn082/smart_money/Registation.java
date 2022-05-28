package com.b18cn082.smart_money;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.b18cn082.smart_money.model.User;
import com.b18cn082.smart_money.model.UserRegistation;
import com.b18cn082.smart_money.util.APIUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registation extends AppCompatActivity {
    private TextView loginBtn;
    private Button registerBtn;
    private EditText fistName, lastName, email, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);
        loginBtn = findViewById(R.id.login_tv);
        registerBtn = findViewById(R.id.registration_bt);
        fistName = findViewById(R.id.reg_first_name_et);
        lastName = findViewById(R.id.reg_last_name_et);
        email = findViewById(R.id.reg_email_et);
        password = findViewById(R.id.reg_password_et);

        loginBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Registation.this, LoginActivity.class);
            startActivity(intent);
        });

        registerBtn.setOnClickListener(view -> {
            APIUtils.getApiServiceInterface()
                    .register(new UserRegistation(fistName.getText().toString(),
                            lastName.getText().toString(),
                            email.getText().toString(),
                            password.getText().toString()))
                    .enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful() && response != null) {
                        Toast.makeText(Registation.this,"Dang ky thanh cong",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Registation.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    Toast.makeText(Registation.this,"Dang ky that bai",Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}
