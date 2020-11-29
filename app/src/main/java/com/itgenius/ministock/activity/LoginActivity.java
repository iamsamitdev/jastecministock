package com.itgenius.ministock.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.itgenius.ministock.R;
import com.itgenius.ministock.api.RestAPI;
import com.itgenius.ministock.api.RetrofitServer;
import com.itgenius.ministock.model.UsersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView btnSignup;
    Button btnGetUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignup = findViewById(R.id.linkSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent ไปหน้า Register
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnGetUser = findViewById(R.id.btnGetUser);
        btnGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RestAPI api = RetrofitServer.getClient().create(RestAPI.class);
                Call<List<UsersResponse>> getuser = api.getUsers();
                getuser.enqueue(new Callback<List<UsersResponse>>() {
                    @Override
                    public void onResponse(Call<List<UsersResponse>> call, Response<List<UsersResponse>> response) {
//                        System.out.println(response.body());
                        Log.d("Data = ", new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<List<UsersResponse>> call, Throwable t) {
                        System.out.println(t.getStackTrace());
                        Toast.makeText(LoginActivity.this, "มีข้อผิดพลาด ดึงข้อมูลไม่สำเร็จ", Toast.LENGTH_SHORT ).show();
                    }
                });
            }
        });

    }
}