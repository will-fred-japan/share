package com.starburst.sdk.resp;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class QuestionSolveResult {
    public static final int CONTENT_TYPE_IMAGE = 1;
    public static final int CONTENT_TYPE_TEXT = 0;
    private String content;
    private int contentType;
    private int imageHeight;
    private long imageSize;
    private int imageWidth;
    private List<QuestionInfo> questionList;
    private String scene;

    public String getContent() {
        return this.content;
    }

    public int getContentType() {
        return this.contentType;
    }

    public int getImageHeight() {
        return this.imageHeight;
    }

    public long getImageSize() {
        return this.imageSize;
    }

    public int getImageWidth() {
        return this.imageWidth;
    }

    public List<QuestionInfo> getQuestionList() {
        return this.questionList;
    }

    public String getScene() {
        return this.scene;
    }

    public boolean isImageContent() {
        return this.contentType == 1;
    }
}
