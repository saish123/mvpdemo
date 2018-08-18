package com.sawant.mvp_demo.presenter;

/**
 * Created by root on 8/18/18.
 */

public interface ILoginView {
    void onLoginResult(String message);
    void onLoginError(String message);
}
