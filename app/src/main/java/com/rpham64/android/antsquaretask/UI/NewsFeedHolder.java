package com.rpham64.android.antsquaretask.UI;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.rpham64.android.antsquaretask.Model.Post;
import com.rpham64.android.antsquaretask.R;
import com.rpham64.android.antsquaretask.activity.ConversationActivity;
import com.squareup.picasso.Picasso;

import im.ene.lab.toro.ToroVideoViewHolder;
import im.ene.lab.toro.widget.ToroVideoView;
import pl.droidsonroids.gif.GifImageView;

/**
 * Helper ViewHolder class for handling cardviews
 *
 * Created by Rudolf on 6/7/2016.
 */
public class NewsFeedHolder extends ToroVideoViewHolder {

    private Context mContext;

    private Post mPost;

    private RecyclerView mRecyclerViewImages;

    private ImageView mLogo;
    private TextView mStoreName;
    private TextView mStoreCategory;

    private TextView mProductName;
    private TextView mProductDescription;
    private GifImageView mProductImage;
    private ToroVideoView mProductVideo;

    private ImageButton mVideoCallButton;

    public NewsFeedHolder(Context context, View itemView) {
        super(itemView);

        mContext = context;

        mRecyclerViewImages =
                (RecyclerView) itemView.findViewById(R.id.row_images_slider_recycler_view);

        mLogo = (ImageView) itemView.findViewById(R.id.logo);
        mStoreName = (TextView) itemView.findViewById(R.id.store_name);
        mStoreCategory = (TextView) itemView.findViewById(R.id.store_category);

        mProductName = (TextView) itemView.findViewById(R.id.product_name);
        mProductDescription = (TextView) itemView.findViewById(R.id.product_description);
        mProductImage = (GifImageView) itemView.findViewById(R.id.product_image);
        mProductVideo = (ToroVideoView) itemView.findViewById(R.id.product_video);

        mVideoCallButton = (ImageButton) itemView.findViewById(R.id.video_call_button);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying()) {
                    pause();
                } else {
                    start();
                }
            }
        });

        mVideoCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Pause video, if playing
                pause();

                Intent intent = new Intent(mContext, ConversationActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public void bind(@Nullable Object object) {
        mPost = (Post) object;

        // Logo
        Picasso.with(mContext)
                .load(mPost.getLogo())
                .into(mLogo);

        // Store Name & Category
        mStoreName.setText(mPost.getStoreName());
        mStoreCategory.setText(mPost.getStoreCategory());

        // Product Name & Category
        mProductName.setText(mPost.getProductName());
        mProductDescription.setText(mPost.getProductDescription());

/*        // Images Slider

        LinearLayoutManager imageSlider =
                new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);

        mRecyclerViewImages.setLayoutManager(imageSlider);
        mRecyclerViewImages.setHasFixedSize(true);

        RecyclerView.Adapter imageSliderAdapter = new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                
            }

            @Override
            public int getItemCount() {
                return mPost.getImageUrls() == null ? mPost.getImageUrls().size() : 0;
            }
        };*/

        // Product Image/Gif/Video
        if (mPost.getImageUrls().size() != 0) {

            final String firstImageUrl = mPost.getImageUrls().get(0);

            if (firstImageUrl.endsWith(".mp4")) {

                // Video
                mProductImage.setVisibility(View.INVISIBLE);
                mProductVideo.setVisibility(View.VISIBLE);

                mProductVideo.setVideoPath(firstImageUrl);
                mProductVideo.start();

            } else {

                mProductImage.setVisibility(View.VISIBLE);
                mProductVideo.setVisibility(View.INVISIBLE);

                if (firstImageUrl.endsWith(".gif")) {

                    // Gif
                    Ion.with(mProductImage)
                            .load(firstImageUrl);

                } else {

                    // Image
                    Picasso.with(mContext)
                            .load(firstImageUrl)
                            .into(mProductImage);

                }
            }

        }
    }

    @Override
    protected ToroVideoView findVideoView(View itemView) {
        return (ToroVideoView) itemView.findViewById(R.id.product_video);
    }

    @Nullable
    @Override
    public String getVideoId() {
        return "Video's id and order: " + getAdapterPosition();
    }
}