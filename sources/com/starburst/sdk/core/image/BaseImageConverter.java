package com.starburst.sdk.core.image;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseImageConverter implements IImageConverter {
    public boolean checkParameters(String str, String str2, String str3, ImageConvertCallback imageConvertCallback) {
        int i9;
        String str4;
        if (str2 == null || str2.isEmpty()) {
            i9 = 1001;
            str4 = "输入文件路径为空";
        } else {
            if (str3 != null && !str3.isEmpty()) {
                return true;
            }
            i9 = 1002;
            str4 = "输出文件路径为空";
        }
        imageConvertCallback.onFailure(str, i9, str4);
        return false;
    }

    @Override // com.starburst.sdk.core.image.IImageConverter
    public void convert(String str, String str2, String str3, ImageConvertConfig imageConvertConfig, ImageConvertCallback imageConvertCallback) {
    }
}
