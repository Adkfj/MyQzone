package com.ylj.com.myqzone.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;


import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.ylj.com.myqzone.R;
import com.ylj.com.myqzone.app.MyQzoneApplication;
import com.ylj.com.myqzone.dagger.components.DaggerLoginComponent;
import com.ylj.com.myqzone.dagger.modules.LoginModule;
import com.ylj.com.myqzone.presenter.LoginContrct;
import com.ylj.com.myqzone.presenter.LoginPresenter;
import com.ylj.com.myqzone.util.Utils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginContrct.View{

    @BindView(R.id.login_progress)
    ProgressBar mProgressView;
    @BindView(R.id.account)
    EditText mAccount;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.sign_button)
    Button mLogin;
    @BindView(R.id.register_button)
    Button mRegister;
    @Inject
    LoginPresenter presenter;
    private static final int REQUEST_READ_CONTACTS = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
        populateAutoComplete();
        mProgressView = findViewById(R.id.login_progress);
    }

    private void initView() {
     DaggerLoginComponent.builder().loginModule(new LoginModule(this)).netComponent(MyQzoneApplication.getInstance().getNetComponent()).build().inject(this);
    }

    private void populateAutoComplete() {
        if (!mayRequestContacts()) {
            return;
        }
    }

    private boolean mayRequestContacts() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
            Snackbar.make(mAccount, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
                        }
                    });
        } else {
            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
        }
        return false;
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                populateAutoComplete();
            }
        }
    }


    @OnClick({R.id.sign_button,R.id.register_button})
    void onClick(View view){
       if (view.getId() == R.id.sign_button){
          String accountStr = mAccount.getText().toString().trim();
          String passwordStr = mPassword.getText().toString().trim();

           presenter.login(accountStr, Utils.md5(accountStr+passwordStr+"pycircle"));
       }
       if (view.getId() == R.id.register_button){
           Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
           startActivity(intent);
       }
    }
    @Override
    public void success() {

    }

    @Override
    public void faild() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

