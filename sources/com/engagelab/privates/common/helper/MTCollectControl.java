package com.engagelab.privates.common.helper;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MTCollectControl {
    private JSONObject collectData = new JSONObject();

    public interface Type {
        public static final String GAID = "gaid";
    }

    private void set(String str, boolean z8) {
        try {
            this.collectData.put(str, z8);
        } catch (JSONException unused) {
        }
    }

    public void setAID(boolean z8) {
        set("aid", z8);
    }

    public void setGAID(boolean z8) {
        set("gaid", z8);
    }

    public String toString() {
        return this.collectData.toString();
    }
}
