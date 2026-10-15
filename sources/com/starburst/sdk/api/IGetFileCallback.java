package com.starburst.sdk.api;

import com.starburst.sdk.resp.DeviceAudioFile;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface IGetFileCallback {
    public static final int TYPE_AUDIO_LEFT = 1;
    public static final int TYPE_AUDIO_RIGHT = 2;

    void onError(int i9);

    void onFileSend(int i9, ArrayList<DeviceAudioFile> arrayList);
}
