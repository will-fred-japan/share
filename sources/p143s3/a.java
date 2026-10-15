package p143s3;

import W5.e;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: HeapDump.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f21203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f21206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f21207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f21208f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f21209g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f21210h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f21211i;

    /* JADX INFO: renamed from: s3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: HeapDump.java */
    public static final class C0254a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f21214c;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f21219h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f21220i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public File f21213b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f21212a = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f21215d = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f21216e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f21217f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f21218g = 0;
    }

    public a(C0254a c0254a) {
        this.f21204b = c0254a.f21212a;
        this.f21205c = c0254a.f21219h;
        this.f21206d = c0254a.f21220i;
        this.f21203a = c0254a.f21213b;
        this.f21207e = c0254a.f21215d;
        this.f21208f = c0254a.f21216e;
        this.f21209g = c0254a.f21214c;
        this.f21210h = c0254a.f21217f;
        this.f21211i = c0254a.f21218g;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" heapDumpFilePath ");
        File file = this.f21203a;
        sb.append(file.getPath());
        sb.append("\n heapDumpFileSize ");
        sb.append(file.length());
        sb.append("\n referenceName ");
        sb.append(this.f21207e);
        sb.append("\n isDebug ");
        sb.append(this.f21204b);
        sb.append("\n currentTime ");
        sb.append(this.f21205c);
        sb.append("\n sidTime ");
        sb.append(this.f21206d);
        sb.append("\n watchDurationMs ");
        sb.append(this.f21208f);
        sb.append("ms\n gcDurationMs ");
        sb.append(this.f21210h);
        sb.append("ms\n shrinkFilePath ");
        sb.append(this.f21209g);
        sb.append("\n heapDumpDurationMs ");
        return e.m(sb, this.f21211i, "ms\n");
    }
}
