package com.huawei.hms.framework.common.hianalytics;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class LinkedHashMapPack {
    private LinkedHashMap<String, String> map = new LinkedHashMap<>();

    public LinkedHashMap<String, String> getAll() {
        return this.map;
    }

    public LinkedHashMapPack put(String str, String str2) {
        if (str != null && str2 != null) {
            this.map.put(str, str2);
        }
        return this;
    }

    public LinkedHashMapPack putIfNotDefault(String str, long j, long j8) {
        return j == j8 ? this : put(str, j);
    }

    public LinkedHashMapPack put(String str, boolean z8) {
        if (str != null) {
            if (z8) {
                this.map.put(str, "1");
                return this;
            }
            this.map.put(str, "0");
        }
        return this;
    }

    public LinkedHashMapPack put(String str, long j) {
        if (str != null) {
            this.map.put(str, "" + j);
        }
        return this;
    }
}
