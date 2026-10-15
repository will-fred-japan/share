package I2;

import defpackage.f;

/* JADX INFO: compiled from: CpuConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2562d;

    public final String toString() {
        StringBuilder sb = new StringBuilder("CpuConfig{mFrontCollectInterval=");
        sb.append(this.f2559a);
        sb.append(", mBackCollectInterval=");
        sb.append(this.f2560b);
        sb.append(", mMonitorInterval=");
        sb.append(this.f2561c);
        sb.append(", mEnableUpload=");
        return f.g(sb, this.f2562d, '}');
    }
}
