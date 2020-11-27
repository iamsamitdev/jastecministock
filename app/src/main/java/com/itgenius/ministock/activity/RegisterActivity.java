package com.itgenius.ministock.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.itgenius.ministock.R;

public class RegisterActivity extends AppCompatActivity {

    TextView btnSignin;
    EditText userid, username, password, firstname, lastname;
    RadioGroup userType;
    Button btnRegister;
    int typeID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSignin = findViewById(R.id.linkSignIn);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent ไปหน้า Register
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        userid = findViewById(R.id.userid);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        userType = findViewById(R.id.userType);

        btnRegister = findViewById(R.id.btnRegister);

        userType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.general:
                        typeID = 1;
                        break;
                    case R.id.premium:
                        typeID = 2;
                        break;
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // การ Validate ค่าว่างในฟอร์ม
                if(TextUtils.isEmpty(userid.getText())) {
                    userid.setError("กรุณาป้อนรหัสพนักงานก่อน");
                }else if(TextUtils.isEmpty(username.getText())) {
                    username.setError("กรุณาป้อนชื่อผู้ใช้ก่อน");
                }else if(TextUtils.isEmpty(password.getText())) {
                    password.setError("กรุณาป้อนรหัสผ่านก่อน");
                }else if(TextUtils.isEmpty(firstname.getText())) {
                    firstname.setError("กรุณาป้อนชื่อก่อน");
                }else if(TextUtils.isEmpty(lastname.getText())) {
                    lastname.setError("กรุณาป้อนนามสกุลก่อน");
                }else if(typeID == 0){
                   Toast.makeText(RegisterActivity.this, "กรุณาเลือกประเภทของผู้ใช้ก่อน", Toast.LENGTH_SHORT ).show();
                }else{
                    System.out.println(userid.getText());
                    System.out.println(username.getText());
                    System.out.println(password.getText());
                    System.out.println(firstname.getText());
                    System.out.println(lastname.getText());
                    System.out.println(typeID);
                }
            }
        });

    }
}