package B0;

import android.webkit.ServiceWorkerClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

/* JADX INFO: renamed from: B0.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FrameworkServiceWorkerClient.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0308w extends ServiceWorkerClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A0.f f1683a;

    public C0308w(A0.f fVar) {
        this.f1683a = fVar;
    }

    @Override // android.webkit.ServiceWorkerClient
    public final WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
        return this.f1683a.shouldInterceptRequest(webResourceRequest);
    }
}
