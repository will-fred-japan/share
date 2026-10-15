package p152t4;

import android.system.Os;
import android.system.OsConstants;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f21443a = -1;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static long f21444a = -1;

        public static long a() {
            if (m.f21443a == -1) {
                long jSysconf = f21444a;
                if (jSysconf <= 0) {
                    jSysconf = Os.sysconf(OsConstants._SC_CLK_TCK);
                    if (jSysconf <= 0) {
                        jSysconf = 100;
                    }
                    f21444a = jSysconf;
                }
                m.f21443a = 1000 / jSysconf;
            }
            return m.f21443a;
        }
    }
}
