package h4;

import android.content.Context;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.apm.insight.f;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {
    public static c v(StackTraceElement stackTraceElement, String str, String str2, String str3, String str4) {
        c cVar = new c();
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        cVar.e("exception", "event_type");
        cVar.e("core_exception_monitor", "log_type");
        cVar.e(Long.valueOf(System.currentTimeMillis()), "timestamp");
        cVar.e(Long.valueOf(System.currentTimeMillis()), "crash_time");
        cVar.e(className, "class_ref");
        cVar.e(methodName, "method");
        cVar.e(Integer.valueOf(lineNumber), "line_num");
        cVar.e(str, "stack");
        cVar.e(1, JThirdPlatFormInterface.EXCEPTION_TYPE);
        cVar.e(str4, "ensure_type");
        cVar.e(1, "is_core");
        cVar.e(str2, "message");
        Context context = f.f11853a;
        cVar.e(p144s4.a.h(), "process_name");
        cVar.e(str3, "crash_thread_name");
        return cVar;
    }
}
