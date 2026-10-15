package cn.jiguang.p;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.jiguang.q.f;

/* JADX INFO: loaded from: classes.dex */
public class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10687a;

    public a(Context context, Looper looper) {
        super(looper);
        this.f10687a = context;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            f.a().a(this.f10687a, message.what, message.obj);
        } catch (Throwable unused) {
        }
    }
}
