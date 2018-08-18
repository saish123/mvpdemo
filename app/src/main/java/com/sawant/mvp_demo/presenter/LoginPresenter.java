package com.sawant.mvp_demo.presenter;

import com.sawant.mvp_demo.model.User;

/**
 * Created by root on 8/18/18.
 */

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {

        User user = new User(email, password);
        int loginCode = user.isValidData();

        switch (loginCode){
            case 0:
                loginView.onLoginResult("Login Success");
                break;
            case 1:
                loginView.onLoginError("Please enter Email id");
                break;

            case 2:
                loginView.onLoginError("Please enter valid Email id");
                break;

            case 3:
                loginView.onLoginError("Password length should be greater then six character");
                break;
            default:
                loginView.onLoginError("Invalid login credentials");
                break;

        }
    }
}
