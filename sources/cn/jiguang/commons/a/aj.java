package cn.jiguang.commons.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, aa> f9660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String[]> f9661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f9664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f9665f;

    public aj(ConcurrentHashMap<Integer, aa> concurrentHashMap, List<String[]> list, String str, String str2, String str3, int i9) {
        this.f9660a = new ConcurrentHashMap<>(concurrentHashMap);
        this.f9661b = new ArrayList(list);
        this.f9662c = str;
        this.f9663d = str2;
        this.f9664e = str3;
        this.f9665f = i9;
    }

    public final ConcurrentHashMap<Integer, aa> a() {
        return this.f9660a;
    }

    public final String b() {
        return this.f9664e;
    }

    public final int c() {
        return this.f9665f;
    }
}
