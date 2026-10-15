package cn.jiguang.commons.a;

import com.engagelab.privates.core.constants.MTCoreConstants;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TimeZone f9683a = TimeZone.getTimeZone("Asia/Shanghai");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f9684b = {1, 2, 3, 4, 6, 8, 12, 24};

    private at() {
    }

    private static int a(String str) {
        try {
            return Math.max(kq.a().b(str, 0), 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private au b(int i9, JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                ee.a("CmdColCtrl", "c=" + i9 + ", env=null");
                return null;
            }
            if (jSONObject.optInt(MTCoreConstants.Protocol.KEY_CMD, -1) != i9) {
                ee.a("CmdColCtrl", "cm: exp=" + i9 + ", act=" + jSONObject.optInt(MTCoreConstants.Protocol.KEY_CMD, -1));
                return null;
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("content");
            if (jSONObjectOptJSONObject != null) {
                return c(i9, jSONObjectOptJSONObject);
            }
            ee.a("CmdColCtrl", "c=" + i9 + ", ct=null");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static au c(int i9, JSONObject jSONObject) {
        try {
            int iOptInt = jSONObject.optInt("col_delay_times", -1);
            int iOptInt2 = jSONObject.optInt("hour_on", -1);
            int iOptInt3 = jSONObject.optInt("hour_times", -1);
            au auVar = new au(i9, iOptInt, iOptInt2, iOptInt3);
            if (b(auVar)) {
                return auVar;
            }
            ee.a("CmdColCtrl", "c=" + i9 + ", fi: cs=" + iOptInt + ", ph=" + iOptInt2 + ", ms=" + iOptInt3);
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public /* synthetic */ at(byte b9) {
        this();
    }

    private static long a(long j, int i9) {
        try {
            Calendar calendar = Calendar.getInstance(f9683a);
            calendar.setTimeInMillis(j);
            int i10 = calendar.get(11);
            calendar.set(11, i10 - (i10 % i9));
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public final synchronized void b() {
        try {
            int iA = a("cmd_collect_cold_start_count");
            if (iA >= Integer.MAX_VALUE) {
                ee.a("CmdColCtrl", "ecs=max");
                return;
            }
            int i9 = iA + 1;
            kq.a().a("cmd_collect_cold_start_count", i9);
            ee.a("CmdColCtrl", "ecs=" + i9);
        } catch (Throwable unused) {
        }
    }

    public static at a() {
        return av.f9689a;
    }

    private static boolean b(int i9) {
        try {
            for (int i10 : f9684b) {
                if (i10 == i9) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean a(int i9) {
        return i9 == 4 || i9 == 5 || i9 == 88;
    }

    private static boolean b(au auVar) {
        if (auVar != null) {
            try {
                if (a(auVar.f9685a) && auVar.f9686b >= 0 && b(auVar.f9687c) && auVar.f9688d > 0) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final synchronized boolean a(int i9, JSONObject jSONObject) {
        try {
            if (!a(i9)) {
                return true;
            }
            ee.a("CmdColCtrl", "ck c=" + i9);
            au auVarB = b(i9, jSONObject);
            if (auVarB != null) {
                return a(auVarB);
            }
            ee.a("CmdColCtrl", "c=" + i9 + ", cfg=inv");
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private synchronized boolean a(au auVar) {
        if (auVar != null) {
            try {
                if (b(auVar)) {
                    ee.a("CmdColCtrl", "c=" + auVar.f9685a + ", cs=" + auVar.f9686b + ", ph=" + auVar.f9687c + ", ms=" + auVar.f9688d);
                    int iA = a("cmd_collect_cold_start_count");
                    if (iA < auVar.f9686b) {
                        ee.a("CmdColCtrl", "c=" + auVar.f9685a + ", cb: cur=" + iA + ", req=" + auVar.f9686b);
                        return false;
                    }
                    long jA = a(System.currentTimeMillis(), auVar.f9687c);
                    if (jA == -1) {
                        ee.a("CmdColCtrl", "c=" + auVar.f9685a + ", ps=inv");
                        return false;
                    }
                    kq kqVarA = kq.a();
                    String str = "cmd_collect_period_start_" + auVar.f9685a;
                    String str2 = "cmd_collect_period_count_" + auVar.f9685a;
                    int iMax = kqVarA.b(str, -1L) == jA ? Math.max(kqVarA.b(str2, 0), 0) : 0;
                    if (iMax >= auVar.f9688d) {
                        ee.a("CmdColCtrl", "c=" + auVar.f9685a + ", qb: ps=" + jA + ", use=" + iMax + ", max=" + auVar.f9688d);
                        return false;
                    }
                    int i9 = iMax + 1;
                    kqVarA.a(str, jA);
                    kqVarA.a(str2, i9);
                    ee.a("CmdColCtrl", "c=" + auVar.f9685a + ", ok: ps=" + jA + ", use=" + i9 + "/" + auVar.f9688d);
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        ee.a("CmdColCtrl", "cfg=inv");
        return false;
    }
}
