package p152t4;

import N1.g;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.apm.insight.f;
import com.xiaomi.clientreport.data.Config;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import p056h5.C0598e;
import p144s4.d;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f21445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f21446b;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f21448b;

        public a(String str, String str2) {
            this.f21447a = str;
            this.f21448b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                File fileE = n.e();
                if (fileE != null) {
                    d.h(fileE, n.f21446b + ' ' + this.f21447a + ' ' + this.f21448b + ' ' + System.currentTimeMillis() + '\n', true);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21449a;

        public b(String str) {
            String[] strArrSplit = str.split("\\s+");
            if (strArrSplit.length != 3) {
                int i9 = com.apm.insight.b.f11841a;
                p027d5.a.k("NPTH_CATCH", new RuntimeException("err ProcessTrack line:".concat(str)));
                return;
            }
            String str2 = strArrSplit[0];
            this.f21449a = strArrSplit[1];
            try {
                Long.parseLong(strArrSplit[2]);
            } catch (Throwable th) {
                int i10 = com.apm.insight.b.f11841a;
                p027d5.a.k("NPTH_CATCH", new RuntimeException("err ProcessTrack line:".concat(str), th));
            }
        }
    }

    public static File a(long j) {
        return new File(C0598e.w(f.f11853a), "apminsight/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
    }

    public static File b(long j, String str) {
        if (str == null) {
            return null;
        }
        return new File(C0598e.w(f.f11853a), "apminsight/ProcessTrack/" + (j / 86400000) + '/' + str.replace(':', '_') + ".txt");
    }

    public static HashMap c(long j) throws Throwable {
        File file = new File(C0598e.w(f.f11853a), "apminsight/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
        String[] list = file.list();
        HashMap map = new HashMap();
        if (list != null) {
            for (String str : list) {
                File file2 = new File(file, str);
                long length = file2.length();
                try {
                    JSONArray jSONArrayE = d.e(file2, length > Config.DEFAULT_MAX_FILE_LENGTH ? length - 524288 : 0L);
                    for (int length2 = jSONArrayE.length() - 1; length2 >= 0; length2--) {
                        String strOptString = jSONArrayE.optString(length2);
                        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("anr_trace")) {
                            map.put(str.replace('_', ':').replace(".txt", ""), new b(strOptString));
                            break;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
        return map;
    }

    public static void d(String str, String str2) {
        if (f.f11868q == 0) {
            return;
        }
        l.a().a(new a(str, str2));
    }

    public static File e() {
        if (f21445a == null) {
            Context context = f.f11853a;
            String strH = p144s4.a.h();
            if (strH == null) {
                return null;
            }
            f21446b = String.valueOf(Process.myPid());
            long jCurrentTimeMillis = System.currentTimeMillis();
            f21445a = new File(C0598e.w(f.f11853a), "apminsight/ProcessTrack/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % 86400000)) / 86400000) + '/' + strH.replace(':', '_') + ".txt");
            l.a().b(new g(5), 15000L);
        }
        return f21445a;
    }
}
