package com.starburst.sdk.api;

import com.starburst.sdk.resp.GuiControlResponse;

/* JADX INFO: loaded from: classes.dex */
public interface IGuiControlCallback {
    void onClosed(int i9, String str);

    void onError(int i9, String str);

    void onOpen();

    void onResponse(GuiControlResponse guiControlResponse);
}
