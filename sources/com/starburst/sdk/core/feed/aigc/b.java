package com.starburst.sdk.core.feed.aigc;

import com.starburst.sdk.api.ITextToImageCallback;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextToImageManager f16409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f16410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ITextToImageCallback f16411d;

    public /* synthetic */ b(TextToImageManager textToImageManager, String str, ITextToImageCallback iTextToImageCallback, int i9) {
        this.f16408a = i9;
        this.f16409b = textToImageManager;
        this.f16410c = str;
        this.f16411d = iTextToImageCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16408a) {
            case 0:
                this.f16409b.lambda$queryByTaskId$2(this.f16410c, this.f16411d);
                break;
            default:
                this.f16409b.lambda$scheduleNextPolling$5(this.f16410c, this.f16411d);
                break;
        }
    }
}
