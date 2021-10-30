package com.example.myapplication02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication02.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private EditText etPasswordCheck;
    private EditText etName;
    private EditText etNum;
    private EditText etAdd;
    private Button btnJoin;
    private Button btnDoubleCheck;

    @Override
    protected void onCreate(Bundle savedlnstanceState) {
        super.onCreate(savedlnstanceState);
        setContentView(R.layout.activity_regist);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordCheck = (EditText) findViewById(R.id.etPasswordCheck);
        etName = (EditText) findViewById(R.id.etName);
        etAdd = (EditText) findViewById(R.id.etAdd);
        etNum = (EditText) findViewById(R.id.etNum);
        btnJoin = (Button) findViewById(R.id.btnJoin);
        btnDoubleCheck = (Button) findViewById(R.id.btnDoubleCheck);

        etPasswordCheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = etPassword.getText().toString();
                String check = etPasswordCheck.getText().toString();



                if(password.equals(check)) {
                    etPassword.setBackgroundColor(Color.GREEN);
                    etPasswordCheck.setBackgroundColor(Color.GREEN);
                } else {
                    etPassword.setBackgroundColor(Color.RED);
                    etPasswordCheck.setBackgroundColor(Color.RED);
                }

            }



            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etEmail.getText().toString().length() == 0) {
                    Toast.makeText(RegistActivity.this, "Email을 입력하세요!", Toast.LENGTH_SHORT).show();
                    etEmail.requestFocus();
                    return;

                }


                if(etPassword.getText().toString().length() == 0) {
                    Toast.makeText(RegistActivity.this, "비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    etPassword.requestFocus();
                    return;
                }


                if(etPasswordCheck.getText().toString().equals(etPasswordCheck.getText().toString())) {
                    Toast.makeText(RegistActivity.this, "비밀번호 확인을 입력하세요!", Toast.LENGTH_SHORT).show();
                    etPasswordCheck.requestFocus();
                    return;
                }

                Intent result = new Intent();
                result.putExtra("email", etEmail.getText().toString());

                setResult(RESULT_OK, result);
                finish();

                if(etName.getText().toString().length() == 0) {
                    Toast.makeText(RegistActivity.this, "Name을 입력하세요!", Toast.LENGTH_SHORT).show();
                    etName.requestFocus();
                    return;

                }

                if(etNum.getText().toString().length() == 0) {
                    Toast.makeText(RegistActivity.this, "핸드폰 번호를 입력하세요!", Toast.LENGTH_SHORT).show();
                    etNum.requestFocus();
                    return;

                }

                if(etAdd.getText().toString().length() == 0) {
                    Toast.makeText(RegistActivity.this, "주소를 입력하세요!", Toast.LENGTH_SHORT).show();
                    etAdd.requestFocus();
                    return;

                }

            }
        });

        Toast.makeText(getApplicationContext(), etName.getText().toString() + "님 회원가입을 축하드립니다.",Toast.LENGTH_SHORT).show();

        btnDoubleCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}

