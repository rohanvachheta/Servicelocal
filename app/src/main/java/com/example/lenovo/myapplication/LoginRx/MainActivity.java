package com.example.lenovo.myapplication.LoginRx;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.lenovo.myapplication.LoginRx.fragments.LoginFragment;
import com.example.lenovo.myapplication.LoginRx.fragments.ResetPasswordDialog;
import com.example.lenovo.myapplication.R;


public class MainActivity extends AppCompatActivity implements ResetPasswordDialog.Listener {

    public static final String TAG = MainActivity.class.getSimpleName();

    private LoginFragment mLoginFragment;
    private ResetPasswordDialog mResetPasswordDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reg);

        if (savedInstanceState == null) {

            loadFragment();
        }
    }

    private void loadFragment(){

        if (mLoginFragment == null) {

            mLoginFragment = new LoginFragment();
        }
        getFragmentManager().beginTransaction().replace(R.id.fragmentFrame,mLoginFragment, LoginFragment.TAG).commit();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        String data = intent.getData().getLastPathSegment();
        Log.d(TAG, "onNewIntent: "+data);

        mResetPasswordDialog = (ResetPasswordDialog) getFragmentManager().findFragmentByTag(ResetPasswordDialog.TAG);

        if (mResetPasswordDialog != null)
            mResetPasswordDialog.setToken(data);
    }

    @Override
    public void onPasswordReset(String message) {

        showSnackBarMessage(message);
    }

    private void showSnackBarMessage(String message) {

        Snackbar.make(findViewById(R.id.activity_main),message,Snackbar.LENGTH_SHORT).show();

    }
}
