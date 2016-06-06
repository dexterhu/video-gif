package com.rpham64.android.antsquaretask.Model;

/**
 * A single news feed entry containing store info and their
 * product's info
 *
 * Created by Rudolf on 6/4/2016.
 */
public class Post {

    private String mId;                     // Post ID
    private String mStoreName;
    private String mStoreCategory;
    private String mLogo;                   // Logo URL
    private String mProductName;
    private String mProductDescription;
    private String mImageUrl;               // Image URL

    public Post(String id, String storeName, String storeCategory, String logo, String productName, String productDescription, String imageUrl) {
        mId = id;
        mStoreName = storeName;
        mStoreCategory = storeCategory;
        mLogo = logo;
        mProductName = productName;
        mProductDescription = productDescription;
        mImageUrl = imageUrl;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getStoreName() {
        return mStoreName;
    }

    public void setStoreName(String storeName) {
        mStoreName = storeName;
    }

    public String getProductDescription() {
        return mProductDescription;
    }

    public void setProductDescription(String productDescription) {
        mProductDescription = productDescription;
    }

    public String getStoreCategory() {
        return mStoreCategory;
    }

    public void setStoreCategory(String storeCategory) {
        mStoreCategory = storeCategory;
    }

    public String getLogo() {
        return mLogo;
    }

    public void setLogo(String logo) {
        mLogo = logo;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String productName) {
        mProductName = productName;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
