package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface ITextToImageManager {
    void cancelTextToImage(String str);

    void queryByTaskId(String str, ITextToImageCallback iTextToImageCallback);

    void startImageToImage(ImageToImageRequest imageToImageRequest, ITextToImageCallback iTextToImageCallback);

    void startTextToImage(String str, int i9, int i10, int i11, ITextToImageCallback iTextToImageCallback);
}
