package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f18441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private File f1179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Runnable f1180a;

    public static void a(Context context, File file, final Runnable runnable) {
        new w(context, file) { // from class: com.xiaomi.push.w.1
            @Override // com.xiaomi.push.w
            public void a(Context context2) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }.run();
    }

    public abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        v vVarA = null;
        try {
            if (this.f1179a == null) {
                this.f1179a = new File(this.f18441a.getFilesDir(), "default_locker");
            }
            vVarA = v.a(this.f18441a, this.f1179a);
            Runnable runnable = this.f1180a;
            if (runnable != null) {
                runnable.run();
            }
            a(this.f18441a);
        } catch (IOException e9) {
            e9.printStackTrace();
        } finally {
            if (vVarA != null) {
                vVarA.a();
            }
        }
    }

    private w(Context context, File file) {
        this.f18441a = context;
        this.f1179a = file;
    }
}
