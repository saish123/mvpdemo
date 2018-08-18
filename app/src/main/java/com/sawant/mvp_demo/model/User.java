package com.sawant.mvp_demo.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by root on 8/18/18.
 */


public class User implements IUser {
    private String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public int isValidData() {
        //1. Check Email empty
        //2. Check email matcher patter
        //3. check password length
        int errorCode;
        boolean isEmailPatternMatched = Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
        boolean isPasswordValidLength = getPassword().length() > 6;

        if (TextUtils.isEmpty(getEmail())) {
            errorCode =AppConstants.EMAIL_EMPTY;
        }
        else if (!isEmailPatternMatched) {
            errorCode =AppConstants.EMAIL_PATTERN_INVALID;
        }
        else if(!isPasswordValidLength){
            errorCode = AppConstants.INVALID_PASSWORD_LENGTH;
        }
        else{
            errorCode = 0;
        }

        return errorCode;
    }
}
