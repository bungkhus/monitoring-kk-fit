package com.jahtra.monitoringkkfit.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.percent.PercentLayoutHelper;
import android.support.percent.PercentRelativeLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.jahtra.monitoringkkfit.Base.BaseActivity;
import com.jahtra.monitoringkkfit.Models.User;
import com.jahtra.monitoringkkfit.R;

public class LoginActivity extends BaseActivity {

    private TextView tvSignupInvoker;
    private LinearLayout llSignup;
    private TextView tvSigninInvoker;
    private LinearLayout llSignin;
    private Button btnSignup;
    private Button btnSignin;
    private TextInputEditText etKodeDosen;
    private TextInputEditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String access = getFromPref(this, getString(R.string.keyAccess));
        if (!access.equals("")) {
            cekLogin(access);
        }
        setupView();
        setupActionListener();
    }

    private void cekLogin(String access) {
        if (isLogin()) {
            switch (access.toLowerCase()){
                case "dosen":
                    goTo(DosenMainActivity.class);
                    break;
            }
        }
    }

    private void goTo(Class javaClass) {
        Intent i = new Intent(this, javaClass);
        startActivity(i);
        finish();
    }

    private void signIn() {
        final String username = etKodeDosen.getText().toString();
        final String password = etPassword.getText().toString();

        hideKeyboard();

        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            showOKAlertDialog(LoginActivity.this, "Login Failed", "Please make sure you enter all credentials!");
        } else {
            showProgressDialog();
            firebaseDatabase().child("users").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    //Getting the data from snapshot
                    if (dataSnapshot.child(username).exists()) {
                        if (dataSnapshot.child(username).child("password").getValue().toString().equals(password)) {
                            User user = dataSnapshot.child(username).getValue(User.class);
                            saveToPref(LoginActivity.this, getString(R.string.keyUsername), user.getKodeDosen());
                            saveToPref(LoginActivity.this, getString(R.string.keyAccess), user.getAccess());
                            goTo(DosenMainActivity.class);
                        } else {
                            showOKAlertDialog(LoginActivity.this, "Login Failed", "Uh oh!\nWrong password.");
                        }
                    } else {
                        showOKAlertDialog(LoginActivity.this, "Login Failed", "Uh oh!\nCode lecturers '"+username+"' not found.");
                    }
                    hideProgressDialog();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("databaseError", databaseError.getMessage());
                }
            });
        }
    }

    private void setupView() {
        etKodeDosen = (TextInputEditText) findViewById(R.id.etKodeDosen);
        etPassword = (TextInputEditText) findViewById(R.id.etPassword);

        tvSignupInvoker = (TextView) findViewById(R.id.tvSignupInvoker);
        tvSigninInvoker = (TextView) findViewById(R.id.tvSigninInvoker);

        btnSignup= (Button) findViewById(R.id.btnSignup);
        btnSignin= (Button) findViewById(R.id.btnSignin);

        llSignup = (LinearLayout) findViewById(R.id.llSignup);
        llSignin = (LinearLayout) findViewById(R.id.llSignin);
    }

    private void setupActionListener() {
        tvSignupInvoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSignupForm();
            }
        });

        tvSigninInvoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSigninForm();
            }
        });
        showSigninForm();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_right_to_left);
                btnSignup.startAnimation(clockwise);
                hideKeyboard();
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                switch (actionId) {

                    case EditorInfo.IME_ACTION_DONE:
                        signIn();
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void showSignupForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) llSignin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.15f;
        llSignin.requestLayout();


        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) llSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.85f;
        llSignup.requestLayout();

        tvSignupInvoker.setVisibility(View.GONE);
        tvSigninInvoker.setVisibility(View.VISIBLE);
        Animation translate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_right_to_left);
        llSignup.startAnimation(translate);

        Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_right_to_left);
        btnSignup.startAnimation(clockwise);

        hideKeyboard();
    }

    private void showSigninForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) llSignin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.85f;
        llSignin.requestLayout();


        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) llSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.15f;
        llSignup.requestLayout();

        Animation translate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_left_to_right);
        llSignin.startAnimation(translate);

        tvSignupInvoker.setVisibility(View.VISIBLE);
        tvSigninInvoker.setVisibility(View.GONE);
        Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_left_to_right);
        btnSignin.startAnimation(clockwise);
    }
}
