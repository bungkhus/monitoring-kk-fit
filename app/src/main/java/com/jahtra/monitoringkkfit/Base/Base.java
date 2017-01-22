package com.jahtra.monitoringkkfit.Base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.jahtra.monitoringkkfit.R;
import com.jahtra.monitoringkkfit.Utils.PrefUtils;

/**
 * Created by bungkhus on 1/15/17.
 */

public class Base {

    private Activity activity;

    public Base(Activity activity){
        this.activity = activity;
    }

    private ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(activity);
            mProgressDialog.setMessage(activity.getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void showOKAlertDialog(Context contect, String title, String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(contect);
        builder.setMessage(msg)
                .setTitle(title)
                .setPositiveButton(android.R.string.ok, null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public String getFromPref(Context context, String key) {
        return PrefUtils.getFromPrefs(context, key, "");
    }

    public void saveToPref(Context context, String key, String value) {
        PrefUtils.saveToPrefs(context, key, value);
    }

    public boolean isLogin() {
        return !getFromPref(activity, activity.getString(R.string.keyUsername)).equals("");
    }

    public void hideKeyboard() {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public int getHeightScreen() {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        return height;
    }

    public int getWidthScreen() {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        return width;
    }

    public int getNavigationBarHeight() {
        int navigationBarHeight = 0;
        int resourceId = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            navigationBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return navigationBarHeight;
    }

    public int getStatusBarHeight() {
        int statusBarHeight = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight;
    }

    public int getTitleBarHeight(Context context) {
        int actionBarHeight = 0;
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[] { android.R.attr.actionBarSize }
        );
        actionBarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();
        return actionBarHeight;
    }

    public void goTo(Context context, Class javaClass) {
        Intent i = new Intent(context, javaClass);
        activity.startActivity(i);
    }

    public int[] getMenuColors() {
        return activity.getResources().getIntArray(R.array.menuColors);
    }

    public int[] getMenuColorsDark() {
        return activity.getResources().getIntArray(R.array.menuColorsDark);
    }

    public void setActivityBackgroundColor(int viewId, int color) {
        View someView = activity.findViewById(viewId);
        someView.setBackgroundColor(color);
    }

    public void changeBarColor(Toolbar toolbar, TabLayout tabLayout, int colorIndex) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int color = getMenuColors()[colorIndex];
            window.setStatusBarColor(getMenuColorsDark()[colorIndex]);
            toolbar.setBackgroundColor(color);
            tabLayout.setBackgroundColor(color);
        }
    }
}
