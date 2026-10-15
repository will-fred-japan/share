package androidx.profileinstaller;

import N6.x;
import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;
import p114p0.e;

/* JADX INFO: compiled from: DeviceProfileWriter.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f7892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.InterfaceC0109c f7893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f7894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f7895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f7896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7897f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p114p0.a[] f7898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f7899h;

    public b(AssetManager assetManager, Executor executor, c.InterfaceC0109c interfaceC0109c, String str, File file) {
        byte[] bArr;
        this.f7892a = executor;
        this.f7893b = interfaceC0109c;
        this.f7896e = str;
        this.f7895d = file;
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 31) {
            switch (i9) {
                case 26:
                    bArr = e.f20766d;
                    break;
                case 27:
                    bArr = e.f20765c;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = e.f20764b;
                    break;
                default:
                    bArr = null;
                    break;
            }
        } else {
            bArr = e.f20763a;
        }
        this.f7894c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e9) {
            String message = e9.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f7893b.b();
            return null;
        }
    }

    public final void b(int i9, Serializable serializable) {
        this.f7892a.execute(new x(this, i9, serializable));
    }
}
