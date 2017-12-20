package com.ylj.com.myqzone.presenter;

import java.util.List;

/**
 * Created by pc on 2017/12/5.
 */

public interface MainContract {
    interface Presenter{
        void getDatas(String username,String password);
    }
    interface View{
        void showLoading();
        void dismissLoading();
        void showNoData();
        void showNoMore();
        void updateListUI(List itemList);
        void showOnFailure();
    }
}
