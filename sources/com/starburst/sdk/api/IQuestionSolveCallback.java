package com.starburst.sdk.api;

import com.starburst.sdk.resp.QuestionSolveResult;

/* JADX INFO: loaded from: classes.dex */
public interface IQuestionSolveCallback {
    void onError(int i9, String str);

    void onImageChatResponse(int i9, QuestionSolveResult questionSolveResult);

    default void onOpen() {
    }

    default void onCompleted(int i9) {
    }

    default void onResponseText(int i9, boolean z8, String str) {
    }
}
