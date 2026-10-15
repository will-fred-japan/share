package com.starburst.sdk.common.okhttp.callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public abstract class BitmapCallback extends Callback<Bitmap> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.starburst.sdk.common.okhttp.callback.Callback
    public Bitmap parseNetworkResponse(Response response, int i9) {
        return BitmapFactory.decodeStream(response.body().byteStream());
    }
}
