package p088l7;

import java.util.Locale;
import p096m7.b;
import p096m7.t;

/* JADX INFO: compiled from: LifecycleChannel.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f20118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f20119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b<String> f20121d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: LifecycleChannel.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f20123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f20124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f20125d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a[] f20126e;

        static {
            a aVar = new a("DETACHED", 0);
            f20122a = aVar;
            a aVar2 = new a("RESUMED", 1);
            f20123b = aVar2;
            a aVar3 = new a("INACTIVE", 2);
            f20124c = aVar3;
            a aVar4 = new a("HIDDEN", 3);
            a aVar5 = new a("PAUSED", 4);
            f20125d = aVar5;
            f20126e = new a[]{aVar, aVar2, aVar3, aVar4, aVar5};
        }

        public a() {
            throw null;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f20126e.clone();
        }
    }

    public f(p013b7.a aVar) {
        b<String> bVar = new b<>(aVar, "flutter/lifecycle", t.f20513b, null);
        this.f20118a = null;
        this.f20119b = null;
        this.f20120c = true;
        this.f20121d = bVar;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x002d  */
    public final void a(a aVar, boolean z8) {
        a aVar2;
        a aVar3 = this.f20118a;
        if (aVar3 == aVar && z8 == this.f20120c) {
            return;
        }
        if (aVar == null && aVar3 == null) {
            this.f20120c = z8;
            return;
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            aVar2 = aVar;
        } else if (iOrdinal == 1) {
            aVar2 = z8 ? a.f20123b : a.f20124c;
        } else if (iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4) {
            aVar2 = aVar;
        } else {
            aVar2 = null;
        }
        this.f20118a = aVar;
        this.f20120c = z8;
        if (aVar2 == this.f20119b) {
            return;
        }
        this.f20121d.a("AppLifecycleState." + aVar2.name().toLowerCase(Locale.ROOT), null);
        this.f20119b = aVar2;
    }
}
