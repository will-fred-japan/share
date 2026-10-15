package p126q3;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import p061i1.h;
import p108o3.a;

/* JADX INFO: compiled from: DumpFileProvider.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile b f20909h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f20910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f20911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f20912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f20913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f20914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final File f20915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f20916g;

    public b(Context context) {
        String str = a.c().f20687f;
        if (TextUtils.isEmpty(str)) {
            this.f20916g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName();
        } else {
            this.f20916g = new File(str).getAbsolutePath();
        }
        String strC = h.c();
        if (strC != null) {
            this.f20914e = new File(A.a.j(new StringBuilder(), this.f20916g, "/memorywidgets"), strC);
            this.f20915f = new File(A.a.j(new StringBuilder(), this.f20916g, "/memory"), strC);
        } else {
            this.f20914e = new File(A.a.j(new StringBuilder(), this.f20916g, "/memorywidgets"), context.getPackageName());
            this.f20915f = new File(A.a.j(new StringBuilder(), this.f20916g, "/memory"), context.getPackageName());
        }
        if (!this.f20914e.exists()) {
            this.f20914e.mkdirs();
        }
        if (!this.f20915f.exists()) {
            this.f20915f.mkdirs();
        }
        File file = new File(this.f20914e, "cache");
        this.f20912c = file;
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f20910a = new File(this.f20914e, "festival.jpg");
        this.f20911b = new File(this.f20914e, "festival.jpg.heap");
        File file2 = new File(this.f20914e, "shrink");
        this.f20913d = file2;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            p027d5.a.h(new File(this.f20916g, "memorywidget"));
        } catch (Exception unused) {
        }
    }

    public static b a() {
        if (f20909h == null) {
            synchronized (b.class) {
                try {
                    if (f20909h == null) {
                        a aVarC = a.c();
                        A1.b.M(aVarC.f20682a, "You must call init() first before using !!!");
                        f20909h = new b(aVarC.f20682a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f20909h;
    }

    public final boolean b() {
        return new File(this.f20914e, "festival.jpg.heap").exists();
    }
}
