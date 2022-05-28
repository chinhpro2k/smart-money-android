package com.b18cn082.smart_money.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.b18cn082.smart_money.LoginActivity;
import com.b18cn082.smart_money.MainActivity;
import com.b18cn082.smart_money.Manger;
import com.b18cn082.smart_money.R;
import com.b18cn082.smart_money.ShowSpendActivity;
import com.b18cn082.smart_money.model.User;

public class FragmentPersonal extends Fragment {
    private TextView email;
    private Button btnLogout,btnShowSpend;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email = view.findViewById(R.id.email);
        btnLogout =view.findViewById(R.id.btn_logout);
        btnShowSpend = view.findViewById(R.id.btn_show_spend);
        User userProfile=Manger.user;

        email.setText(userProfile.getEmail());
        btnLogout.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
        btnShowSpend.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), ShowSpendActivity.class);
            startActivity(intent);
        });
    }
}
