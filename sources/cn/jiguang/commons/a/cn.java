package cn.jiguang.commons.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class cn extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ch f9822a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cn(ch chVar, Looper looper) {
        super(looper);
        this.f9822a = chVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ch.a(this.f9822a, message);
    }
}
