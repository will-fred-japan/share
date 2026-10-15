package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public class ImageToImageRequest {
    public static final String SCENE_EDIT_PICTURES = "edit_pictures";
    private int height;
    private String imageBase64Data;
    private String prompt;
    private String scene;
    private String userId;
    private int width;
    private int count = 1;
    private String pictureFormat = "png";

    public int getCount() {
        return this.count;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImageBase64Data() {
        return this.imageBase64Data;
    }

    public String getPictureFormat() {
        return this.pictureFormat;
    }

    public String getPrompt() {
        return this.prompt;
    }

    public String getScene() {
        return this.scene;
    }

    public String getUserId() {
        return this.userId;
    }

    public int getWidth() {
        return this.width;
    }

    public ImageToImageRequest setCount(int i9) {
        this.count = i9;
        return this;
    }

    public ImageToImageRequest setHeight(int i9) {
        this.height = i9;
        return this;
    }

    public ImageToImageRequest setImageBase64Data(String str) {
        this.imageBase64Data = str;
        return this;
    }

    public ImageToImageRequest setPictureFormat(String str) {
        this.pictureFormat = str;
        return this;
    }

    public ImageToImageRequest setPrompt(String str) {
        this.prompt = str;
        return this;
    }

    public ImageToImageRequest setScene(String str) {
        this.scene = str;
        return this;
    }

    public ImageToImageRequest setUserId(String str) {
        this.userId = str;
        return this;
    }

    public ImageToImageRequest setWidth(int i9) {
        this.width = i9;
        return this;
    }
}
