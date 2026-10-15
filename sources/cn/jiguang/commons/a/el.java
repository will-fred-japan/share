package cn.jiguang.commons.a;

import java.io.IOException;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: loaded from: classes.dex */
public final class el extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9967b;

    public el(long j, long j8) {
        super("Response body exceeds maximum allowed size (" + ((j8 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) + "MB). Actual: " + j + " bytes");
        this.f9966a = j;
        this.f9967b = j8;
    }
}
