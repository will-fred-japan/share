package com.starburst.sdk.core.feature;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TcFeatureConfig {
    private String description;
    private boolean enable;
    private String featureID;
    private List<String> languageList;

    public String getDescription() {
        return this.description;
    }

    public String getFeatureID() {
        return this.featureID;
    }

    public List<String> getLanguageList() {
        return this.languageList;
    }

    public boolean isEnable() {
        return this.enable;
    }
}
