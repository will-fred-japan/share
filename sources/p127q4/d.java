package p127q4;

import com.apm.insight.CrashType;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentLinkedQueue<d> f20961a = new ConcurrentLinkedQueue<>();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20962a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f20962a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20962a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20962a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void b(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<d> concurrentLinkedQueue = f20961a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        if (crashType == CrashType.LAUNCH) {
            ((JSONArray) jSONObject.opt("data")).optJSONObject(0);
        }
        jSONObject.optJSONObject("header");
        while (!f20961a.isEmpty()) {
            d dVarPoll = f20961a.poll();
            if (dVarPoll != null) {
                dVarPoll.a();
            }
        }
        f20961a = null;
    }

    public abstract void a();
}
