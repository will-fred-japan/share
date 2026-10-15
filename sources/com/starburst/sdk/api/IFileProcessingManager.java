package com.starburst.sdk.api;

import com.starburst.sdk.req.LanguageType;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface IFileProcessingManager {
    void addQueryTaskId(String str);

    void cancelQueryTaskId(String str);

    void createFileAsrTask(File file, LanguageType languageType, boolean z8, boolean z9, int i9, String str, String str2, IFileTaskCreatedCallback iFileTaskCreatedCallback);

    void createTextSummaryTask(String str, LanguageType languageType, IFileTaskCreatedCallback iFileTaskCreatedCallback);

    void removeAllQueryTask();

    void setTaskProcessStatusListener(ITaskProcessStatusListener iTaskProcessStatusListener);
}
