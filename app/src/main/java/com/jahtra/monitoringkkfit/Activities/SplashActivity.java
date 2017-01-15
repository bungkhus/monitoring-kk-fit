package com.jahtra.monitoringkkfit.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jahtra.monitoringkkfit.Base.Base;
import com.jahtra.monitoringkkfit.Utils.PrefUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        PrefUtils.clear(this);
        new Base(this).goTo(this, LoginActivity.class);
        finish();
    }

}
