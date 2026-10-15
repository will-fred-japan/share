package com.starburst.sdk.core.feed.aigc;

import com.starburst.sdk.api.ITextToImageCallback;
import org.json.JSONObject;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextToImageManager f16413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f16414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ITextToImageCallback f16415d;

    public /* synthetic */ c(TextToImageManager textToImageManager, JSONObject jSONObject, ITextToImageCallback iTextToImageCallback, int i9) {
        this.f16412a = i9;
        this.f16413b = textToImageManager;
        this.f16414c = jSONObject;
        this.f16415d = iTextToImageCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16412a) {
            case 0:
                this.f16413b.lambda$startTextToImage$0(this.f16414c, this.f16415d);
                break;
            default:
                this.f16413b.lambda$startImageToImage$1(this.f16414c, this.f16415d);
                break;
        }
    }
}
