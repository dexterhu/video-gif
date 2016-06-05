package com.rpham64.android.antsquaretask.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rpham64.android.antsquaretask.Model.Post;
import com.rpham64.android.antsquaretask.R;

import java.util.List;

/**
 * Created by Rudolf on 6/3/2016.
 */
public class NewsFeedFragment extends Fragment {

    private static final String TAG = "NewsFeedFragment";

    private RecyclerView mRecyclerView;

    private List<Post> mPosts;

    public static NewsFeedFragment newInstance() {
        return new NewsFeedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news_feed, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_news_feed_recycler_view);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        NewsFeedAdapter newsFeedAdapter = new NewsFeedAdapter(mPosts);
        mRecyclerView.setAdapter(newsFeedAdapter);

        return view;
    }

    private class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedHolder> {

        private List<Post> mPosts;

        public NewsFeedAdapter(List<Post> posts) {
            mPosts = posts;
        }

        @Override
        public NewsFeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater
                    .from(getActivity())
                    .inflate(R.layout.list_item_news_feed, parent, false);

            NewsFeedHolder newsFeedHolder = new NewsFeedHolder(view);

            return newsFeedHolder;
        }

        @Override
        public void onBindViewHolder(NewsFeedHolder newsFeedHolder, int position) {

            Post post = mPosts.get(position);

            newsFeedHolder.bindPost(post);
        }

        @Override
        public int getItemCount() {
            return mPosts.size();
        }
    }

    private class NewsFeedHolder extends RecyclerView.ViewHolder {

        private Post mPost;

        private ImageView mLogo;
        private TextView mStoreName;
        private TextView mStoreCategory;

        private TextView mProductName;
        private TextView mProductDescription;
        private ImageView mProductImage;

        public NewsFeedHolder(View itemView) {
            super(itemView);

            mLogo = (ImageView) itemView.findViewById(R.id.logo);
            mStoreName = (TextView) itemView.findViewById(R.id.store_name);
            mStoreCategory = (TextView) itemView.findViewById(R.id.store_category);

            mProductName = (TextView) itemView.findViewById(R.id.product_name);
            mProductDescription = (TextView) itemView.findViewById(R.id.product_description);
            mProductImage = (ImageView) itemView.findViewById(R.id.product_image);
        }

        public void bindPost(Post post) {
            mPost = post;

            mStoreName.setText(post.getStoreName());
            mStoreCategory.setText(post.getStoreCategory());

            mProductName.setText(post.getProductName());
            mProductDescription.setText(post.getProductDescription());

            // TODO: Add Logo and ProductImage via picasso
        }
    }
}
