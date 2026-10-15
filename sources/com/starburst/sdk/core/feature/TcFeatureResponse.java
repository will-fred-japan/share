package com.starburst.sdk.core.feature;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TcFeatureResponse {
    private List<TcFeatureConfig> featureList;
    private String tcID;
    private String tcName;

    public List<TcFeatureConfig> getFeatureList() {
        return this.featureList;
    }

    public String getTcID() {
        return this.tcID;
    }

    public String getTcName() {
        return this.tcName;
    }
}
