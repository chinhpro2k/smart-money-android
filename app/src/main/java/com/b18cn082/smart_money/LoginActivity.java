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
import com.b18cn082.smart_money.model.UserToLogin;
import com.b18cn082.smart_money.util.APIUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText email;
    private EditText password;
    private TextView signup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.login_bt);
        email = findViewById(R.id.email_et);
        password = findViewById(R.id.password_et);
        signup = findViewById(R.id.signup_tv);

        signup.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, Registation.class);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(view -> {
            APIUtils.getApiServiceInterface().login(new UserToLogin(email.getText().toString(), password.getText().toString()))
                    .enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if(response.isSuccessful() && response!=null){
                                Manger.user = response.body();
                                Toast.makeText(LoginActivity.this,"Dang nhap thanh cong",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(LoginActivity.this,"Dang nhap khong thanh cong",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {

                        }
                    });
        });

    }
}
