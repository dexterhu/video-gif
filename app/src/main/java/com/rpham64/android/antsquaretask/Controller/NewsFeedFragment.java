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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.rpham64.android.antsquaretask.Model.AntsquareJSON;
import com.rpham64.android.antsquaretask.Model.Cards;
import com.rpham64.android.antsquaretask.Model.GsonRequest;
import com.rpham64.android.antsquaretask.Model.Post;
import com.rpham64.android.antsquaretask.R;

import java.util.ArrayList;
import java.util.List;

import im.ene.lab.toro.Toro;

/**
 * Main Fragment class
 */
public class NewsFeedFragment extends Fragment {

    private static final String TAG = "NewsFeedFragment";

    private RecyclerView mRecyclerView;

    private NewsFeedAdapter mNewsFeedAdapter;

    private List<Post> mPosts = new ArrayList<>();

    public static NewsFeedFragment newInstance() {
        return new NewsFeedFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        Toro.attach(getActivity());
    }

    @Override
    public void onDestroy() {
        Toro.detach(getActivity());
        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_news_feed, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_news_feed_recycler_view);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                getActivity(), LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        final String url = "http://core1.antsquare.com/v4/communities/search?lat=37.3338831&lon=-121.9086862&page=1&per_page=10";

        final GsonRequest gsonRequest = new GsonRequest(
                url,
                AntsquareJSON.class,
                null,
                createSuccessListener(),
                createErrorListener());

        requestQueue.add(gsonRequest);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                // Prints the current view's position to logcat
                int position = linearLayoutManager.findLastVisibleItemPosition();

                Log.i(TAG, "Position: " + position);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Toro.register(mRecyclerView);
        setupAdapter();
    }

    @Override
    public void onPause() {
        Toro.unregister(mRecyclerView);
        super.onPause();
    }

    private void setupAdapter() {
        mNewsFeedAdapter = new NewsFeedAdapter(getActivity(), mPosts);
        mRecyclerView.setAdapter(mNewsFeedAdapter);
    }

    private Response.Listener<AntsquareJSON> createSuccessListener() {
        return new Response.Listener<AntsquareJSON>() {
            @Override
            public void onResponse(AntsquareJSON response) {
                // Do whatever you want to do with response;
                // Like response.tags.getListing_count(); etc. etc.
                List<Cards> cards = response.getCards();

//                Log.i(TAG, "Number of cards: " + cards.size());

                for (int i = 0; i < cards.size(); ++i) {

                    Post post = new Post();

                    post.setId(cards.get(i).getId());
                    post.setStoreName(cards.get(i).getStore_name());
                    post.setStoreCategory(cards.get(i).getStore_category());
                    post.setLogo(cards.get(i).getLogo());
                    post.setProductName(cards.get(i).getName());
                    post.setProductDescription(cards.get(i).getDescription());
                    post.setImageUrls(cards.get(i).getImages());

                    mPosts.add(post);
                }

                // Key step: Set up adapter AFTER volley request for UI to display properly
                setupAdapter();
            }
        };
    }

    private Response.ErrorListener createErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Do whatever you want to do with error.getMessage();
                Log.i(TAG, "Error: " + error.getMessage());
            }
        };
    }
}
