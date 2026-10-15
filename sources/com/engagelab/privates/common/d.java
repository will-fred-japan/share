package com.engagelab.privates.common;

import com.engagelab.privates.common.sentry.entity.SentryStackFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public List<SentryStackFrame> a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                SentryStackFrame sentryStackFrame = new SentryStackFrame();
                sentryStackFrame.setInApp(Boolean.valueOf(a(className)));
                sentryStackFrame.setModule(className);
                sentryStackFrame.setFunction(stackTraceElement.getMethodName());
                sentryStackFrame.setFilename(stackTraceElement.getFileName());
                if (stackTraceElement.getLineNumber() >= 0) {
                    sentryStackFrame.setLineno(Integer.valueOf(stackTraceElement.getLineNumber()));
                }
                sentryStackFrame.setNative(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                arrayList.add(sentryStackFrame);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public boolean a(String str) {
        return (str == null || str.isEmpty() || !str.contains("com.engagelab.privates")) ? false : true;
    }
}
