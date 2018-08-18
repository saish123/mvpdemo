package com.sawant.mvp_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sawant.mvp_demo.presenter.ILoginPresenter;
import com.sawant.mvp_demo.presenter.ILoginView;
import com.sawant.mvp_demo.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements ILoginView {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        loginPresenter = new LoginPresenter(this);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(editTextEmail.getText().toString(),editTextPassword.getText().toString());
            }
        });
    }

    @Override
    public void onLoginResult(String message) {
        if (message!=null && !TextUtils.isEmpty(message)){

            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLoginError(String message) {
        if (message!=null && !TextUtils.isEmpty(message)){

            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
