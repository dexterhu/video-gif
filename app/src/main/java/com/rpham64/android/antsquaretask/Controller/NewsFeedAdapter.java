package com.rpham64.android.antsquaretask.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rpham64.android.antsquaretask.Model.Post;
import com.rpham64.android.antsquaretask.R;
import com.rpham64.android.antsquaretask.UI.NewsFeedHolder;

import java.util.List;

/**
 * Helper adapter class that binds NewsFeedHolder to NewsFeedFragment's Recyclerview
 *
 * Created by Rudolf on 6/7/2016.
 */
public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedHolder> {

    private Context mContext;
    private List<Post> mPosts;

    public NewsFeedAdapter(Context context, List<Post> posts) {
        mContext = context;
        mPosts = posts;
    }

    @Override
    public NewsFeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);

        View view = inflater.inflate(R.layout.list_item_news_feed, parent, false);

        return new NewsFeedHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(NewsFeedHolder newsFeedHolder, int position) {

        Post post = mPosts.get(position);

        newsFeedHolder.bind(post);
    }

    @Override
    public int getItemCount() {
        return mPosts != null ? mPosts.size() : 0;
    }

    public void setPosts(List<Post> posts) {
        mPosts = posts;
    }
}