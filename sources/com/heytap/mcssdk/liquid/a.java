package com.heytap.mcssdk.liquid;

import com.heytap.msp.push.callback.ILiquidTaskQueryCallback;
import com.heytap.msp.push.callback.IPackageAuthCallbackListener;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DownloadRequest f14340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<DownloadRequest> f14341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ILiquidTaskQueryCallback f14342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IPackageAuthCallbackListener f14344f;

    /* JADX INFO: renamed from: com.heytap.mcssdk.liquid.a$a, reason: collision with other inner class name */
    public @interface InterfaceC0160a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f14345a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f14346b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f14347c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f14348d = 4;
    }

    public a(int i9, DownloadRequest downloadRequest) {
        this.f14339a = i9;
        this.f14340b = downloadRequest;
    }

    public int a() {
        return this.f14339a;
    }

    public DownloadRequest b() {
        return this.f14340b;
    }

    public ILiquidTaskQueryCallback c() {
        return this.f14342d;
    }

    public List<DownloadRequest> d() {
        return this.f14341c;
    }

    public String e() {
        return this.f14343e;
    }

    public IPackageAuthCallbackListener f() {
        return this.f14344f;
    }

    public a(int i9, ILiquidTaskQueryCallback iLiquidTaskQueryCallback) {
        this.f14339a = i9;
        this.f14342d = iLiquidTaskQueryCallback;
    }

    public void a(int i9) {
        this.f14339a = i9;
    }

    public a(int i9, String str, IPackageAuthCallbackListener iPackageAuthCallbackListener) {
        this.f14339a = i9;
        this.f14343e = str;
        this.f14344f = iPackageAuthCallbackListener;
    }

    public void a(DownloadRequest downloadRequest) {
        this.f14340b = downloadRequest;
    }

    public a(int i9, List<DownloadRequest> list) {
        this.f14339a = i9;
        this.f14341c = list;
    }

    public void a(ILiquidTaskQueryCallback iLiquidTaskQueryCallback) {
        this.f14342d = iLiquidTaskQueryCallback;
    }

    public void a(IPackageAuthCallbackListener iPackageAuthCallbackListener) {
        this.f14344f = iPackageAuthCallbackListener;
    }

    public void a(String str) {
        this.f14343e = str;
    }

    public void a(List<DownloadRequest> list) {
        this.f14341c = list;
    }
}
