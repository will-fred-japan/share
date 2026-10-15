package com.starburst.sdk.req;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public enum QuestionSolveScene {
    QUESTION_LOCATION("question_location"),
    SOLVE_QUESTION_TEXT("solve_question_text"),
    QUESTION_ANSWER("question_answer"),
    HOMEWORK_CORRECTION("homework_correction");

    private final String value;

    QuestionSolveScene(String str) {
        this.value = str;
    }

    public static QuestionSolveScene fromValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (QuestionSolveScene questionSolveScene : values()) {
            if (questionSolveScene.value.equals(str)) {
                return questionSolveScene;
            }
        }
        return null;
    }

    public static boolean isPhotoSolveScene(String str) {
        return fromValue(str) != null;
    }

    public String getValue() {
        return this.value;
    }
}
