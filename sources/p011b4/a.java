package p011b4;

import android.app.ActivityManager;
import com.apm.insight.f;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static String a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        if (!f.f11871u) {
            return "|------------- processErrorStateInfo--------------|\ndisable anr info\n\"-----------------------end----------------------------\"";
        }
        StringBuilder sb = new StringBuilder("|------------- processErrorStateInfo--------------|\n");
        sb.append("condition: " + processErrorStateInfo.condition + "\n");
        sb.append("processName: " + processErrorStateInfo.processName + "\n");
        sb.append("pid: " + processErrorStateInfo.pid + "\n");
        sb.append("uid: " + processErrorStateInfo.uid + "\n");
        sb.append("tag: " + processErrorStateInfo.tag + "\n");
        sb.append("shortMsg : " + processErrorStateInfo.shortMsg + "\n");
        sb.append("longMsg : " + processErrorStateInfo.longMsg + "\n");
        sb.append("-----------------------end----------------------------");
        return sb.toString();
    }

    public static boolean b(ActivityManager.ProcessErrorStateInfo processErrorStateInfo, ActivityManager.ProcessErrorStateInfo processErrorStateInfo2) {
        return String.valueOf(processErrorStateInfo.condition).equals(String.valueOf(processErrorStateInfo2.condition)) && String.valueOf(processErrorStateInfo.processName).equals(String.valueOf(processErrorStateInfo2.processName)) && String.valueOf(processErrorStateInfo.pid).equals(String.valueOf(processErrorStateInfo2.pid)) && String.valueOf(processErrorStateInfo.uid).equals(String.valueOf(processErrorStateInfo2.uid)) && String.valueOf(processErrorStateInfo.tag).equals(String.valueOf(processErrorStateInfo2.tag)) && String.valueOf(processErrorStateInfo.shortMsg).equals(String.valueOf(processErrorStateInfo2.shortMsg)) && String.valueOf(processErrorStateInfo.longMsg).equals(String.valueOf(processErrorStateInfo2.longMsg));
    }
}
