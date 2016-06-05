package com.rpham64.android.antsquaretask;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Rudolf on 6/3/2016.
 */
public class NewsFeedFragment extends Fragment {

    public static NewsFeedFragment newInstance() {

        Bundle args = new Bundle();

        NewsFeedFragment fragment = new NewsFeedFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
