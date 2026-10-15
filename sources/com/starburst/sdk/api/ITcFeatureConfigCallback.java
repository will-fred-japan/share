package com.starburst.sdk.api;

import com.starburst.sdk.core.feature.TcFeatureConfig;
import com.starburst.sdk.core.feature.TcFeatureResponse;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ITcFeatureConfigCallback {
    void onError(int i9, String str);

    void onSuccess(String str, String str2, List<TcFeatureConfig> list, TcFeatureResponse tcFeatureResponse);
}
