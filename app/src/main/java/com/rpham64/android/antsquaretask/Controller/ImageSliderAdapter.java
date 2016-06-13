package com.rpham64.android.antsquaretask.Controller;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Rudolf on 6/9/2016.
 */
public class ImageSliderAdapter extends RecyclerView.Adapter<ImageSliderViewHolder> {

    private List<String> mImageUrls;

    @Override
    public ImageSliderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ImageSliderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mImageUrls == null ? 0 : mImageUrls.size();
    }
}
