package com.rpham64.android.antsquaretask.Controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.rpham64.android.antsquaretask.Model.AntsquareJSON;
import com.rpham64.android.antsquaretask.Model.GsonRequest;
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

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        final String url = "http://core1.antsquare.com/v4/communities/search?lat=37.3338831&lon=-121.9086862&page=1&per_page=10";

        final GsonRequest gsonRequest = new GsonRequest(
                url,
                AntsquareJSON.class,
                null,
                createSuccessListener(),
                createErrorListener());

        requestQueue.add(gsonRequest);

        return view;
    }

    public Response.Listener<AntsquareJSON> createSuccessListener() {
        return new Response.Listener<AntsquareJSON>() {
            @Override
            public void onResponse(AntsquareJSON response) {
                // Do whatever you want to do with response;
                // Like response.tags.getListing_count(); etc. etc.
                Log.i(TAG, "Length: ");

            }
        };
    }

    public Response.ErrorListener createErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Do whatever you want to do with error.getMessage();
                Log.i(TAG, "Error: " + error.getMessage());
            }
        };
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
            if (mPosts != null) {
                return mPosts.size();
            }
            return 0;
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
