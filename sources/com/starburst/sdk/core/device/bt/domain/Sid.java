package com.starburst.sdk.core.device.bt.domain;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Sid {
    public static final String CCM = "CCM";
    public static final String FGS = "FGS";
    public static final String FND = "FND";
    public static final String GTD = "GTD";
    public static final String TKN = "TKN";
    public static HashMap<String, String> map;

    static {
        HashMap<String, String> map2 = new HashMap<>();
        map = map2;
        map2.put(FGS, FGS);
        map.put(GTD, GTD);
        map.put(FND, FND);
        map.put(CCM, CCM);
    }
}
