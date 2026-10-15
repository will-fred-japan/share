package com.starburst.sdk.core.asr;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return CallTranslationTtsSender.lambda$start$0(runnable);
    }
}
