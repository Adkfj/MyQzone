package com.ylj.com.myqzone.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ylj.com.myqzone.R;
import com.ylj.com.myqzone.app.MyQzoneApplication;
import com.ylj.com.myqzone.dagger.components.DaggerMainComponent;
import com.ylj.com.myqzone.dagger.modules.MainModule;
import com.ylj.com.myqzone.presenter.MainContract;
import com.ylj.com.myqzone.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MainContract.View{

    @Inject
    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        findViewById(R.id.tv).setOnClickListener(this);
    }

    private void initView() {
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .netComponent(
                        MyQzoneApplication.getInstance().getNetComponent())
                .build().inject(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,PresonActivity.class);
        startActivity(intent);

        presenter.getDatas("test","efa7e3b5e07b38a19085ee2d04b247a9");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showNoData() {

    }

    @Override
    public void showNoMore() {

    }

    @Override
    public void updateListUI(List itemList) {

    }

    @Override
    public void showOnFailure() {

    }
}
