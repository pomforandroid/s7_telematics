package com.skankhunt.s7_telematics.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.skankhunt.s7_telematics.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {

    private EditText edtAccount;
    private EditText edtPassword;
    private Button btnLogin;
    private LoginPresenter mPresent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        initViews();
        initParams();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresent.start();
    }

    private void initParams() {
        mPresent = new LoginPresenter(this);
    }

    private void initViews(){
        edtAccount = (EditText)findViewById(R.id.edt_account);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }


    @Override
    public void loginError(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(LoginActivity.this, "登陆成功，我就不跳转了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getAccount() {
        return edtAccount.getText().toString();
    }

    @Override
    public String getPassword() {
        return edtPassword.getText().toString();
    }

    @Override
    public void setPresenter(LoginContract.Present presenter) {

    }

    @Override
    public void onClick(View v) {
        mPresent.login();
    }
}
