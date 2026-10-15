package com.starburst.sdk.core.feed.aigc;

import com.starburst.sdk.api.ITextToImageCallback;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextToImageManager f16405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ITextToImageCallback f16407d;

    public /* synthetic */ a(TextToImageManager textToImageManager, String str, ITextToImageCallback iTextToImageCallback, int i9) {
        this.f16404a = i9;
        this.f16405b = textToImageManager;
        this.f16406c = str;
        this.f16407d = iTextToImageCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16404a) {
            case 0:
                this.f16405b.lambda$startPolling$3(this.f16406c, this.f16407d);
                break;
            default:
                this.f16405b.lambda$scheduleNextPolling$4(this.f16406c, this.f16407d);
                break;
        }
    }
}
