package com.starburst.sdk.api;

import com.starburst.sdk.req.QuestionSolveScene;

/* JADX INFO: loaded from: classes.dex */
public interface IQuestionSolveManager {
    void answerQuestion(byte[] bArr, String str, IQuestionSolveCallback iQuestionSolveCallback);

    void correctHomework(byte[] bArr, IQuestionSolveCallback iQuestionSolveCallback);

    void locateQuestions(byte[] bArr, IQuestionSolveCallback iQuestionSolveCallback);

    void release();

    void resetSession();

    void solve(byte[] bArr, QuestionSolveScene questionSolveScene, String str, boolean z8, IQuestionSolveCallback iQuestionSolveCallback);

    void solveQuestion(byte[] bArr, String str, IQuestionSolveCallback iQuestionSolveCallback);
}
