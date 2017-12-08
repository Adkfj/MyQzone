package com.ylj.com.myqzone.presenter;

/**
 * Created by pc on 2017/12/6.
 */

public interface LoginContrct {
    interface Presenter{
        void login(String user,String password);
    }
    interface View{
        void success();
        void faild();
    }
}
