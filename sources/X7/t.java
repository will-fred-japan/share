package X7;

import com.huawei.hms.framework.common.BundleUtil;

/* JADX INFO: compiled from: StackTraceRecovery.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5170a = 0;

    static {
        Object objA;
        Object objA2;
        Exception exc = new Exception();
        String simpleName = p000a.a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), BundleUtil.UNDERLINE_TAG, stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objA = D7.a.class.getCanonicalName();
        } catch (Throwable th) {
            objA = p188x7.g.a(th);
        }
        if (p188x7.f.a(objA) != null) {
            objA = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objA2 = t.class.getCanonicalName();
        } catch (Throwable th2) {
            objA2 = p188x7.g.a(th2);
        }
        if (p188x7.f.a(objA2) != null) {
            objA2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
