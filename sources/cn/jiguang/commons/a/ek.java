package cn.jiguang.commons.a;

import java.lang.ref.WeakReference;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
final class ek extends ThreadLocal<WeakReference<SecureRandom>> {
    @Override // java.lang.ThreadLocal
    public final /* synthetic */ WeakReference<SecureRandom> initialValue() {
        return new WeakReference<>(new SecureRandom());
    }
}
