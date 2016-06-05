package com.rpham64.android.antsquaretask.Controller;

import android.support.v4.app.Fragment;

public class NewsFeedActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return NewsFeedFragment.newInstance();
    }
}
