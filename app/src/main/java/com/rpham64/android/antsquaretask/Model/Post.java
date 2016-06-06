package com.rpham64.android.antsquaretask.Model;

import java.util.List;

/**
 * A single news feed entry containing store info and their
 * product's info
 *
 * Created by Rudolf on 6/4/2016.
 */
public class Post {

    private Integer mId;                     // Post ID
    private String mStoreName;
    private String mStoreCategory;
    private String mLogo;                   // Logo URL
    private String mProductName;
    private String mProductDescription;
    private List<String> mImageUrls;               // Image URLs

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
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

    public List<String> getImageUrls() {
        return mImageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        mImageUrls = imageUrls;
    }
}
