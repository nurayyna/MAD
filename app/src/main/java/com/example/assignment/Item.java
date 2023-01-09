package com.example.assignment;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String mText;
    private int mImageId;

    public Item(String text, int imageId) {
        mText = text;
        mImageId = imageId;
    }

    public String getText() {
        return mText;
    }

    public int getImageId() {
        return mImageId;
    }


}
