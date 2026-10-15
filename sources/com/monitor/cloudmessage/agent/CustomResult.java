package com.monitor.cloudmessage.agent;

import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class CustomResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, String> f16370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f16371b;

    public CustomResult(HashMap<String, String> map, File file) {
        this.f16370a = map;
        this.f16371b = file;
    }

    public HashMap<String, String> getCustomInfo() {
        return this.f16370a;
    }

    public File getFile() {
        return this.f16371b;
    }
}
