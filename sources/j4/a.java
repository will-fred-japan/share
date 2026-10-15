package j4;

import android.app.ApplicationExitInfo;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Date;
import okhttp3.internal.ws.RealWebSocket;
import p056h5.C0598e;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static String a(long j) {
        if (j == 0) {
            return "not obtained";
        }
        try {
            long j8 = j / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
            if (j8 < 1) {
                return "< 1MB";
            }
            if (j8 <= 30) {
                return "[1~30MB]";
            }
            if (j8 > 30 && j8 <= 60) {
                return "(30~100MB]";
            }
            if (j8 > 60 && j8 <= 100) {
                return "(60~100MB]";
            }
            if (j8 > 100 && j8 <= 200) {
                return "(100~150MB]";
            }
            if (j8 > 200 && j8 <= 300) {
                return "(200~300MB]";
            }
            if (j8 > 300 && j8 <= 400) {
                return "(300~400MB]";
            }
            if (j8 > 400 && j8 <= 500) {
                return "(400~500MB]";
            }
            if (j8 > 500 && j8 <= 600) {
                return "(500~600MB]";
            }
            if (j8 > 600 && j8 <= 700) {
                return "(600~700MB]";
            }
            if (j8 > 700 && j8 <= 800) {
                return "(700~800MB]";
            }
            if (j8 > 800 && j8 <= 900) {
                return "(800~900MB]";
            }
            if (j8 > 900 && j8 <= 1000) {
                return "(900~1000MB]";
            }
            if (j8 > 1000 && j8 <= 1500) {
                return "(1GB~1.5GB]";
            }
            if (j8 > 1500 && j8 <= 2000) {
                return "(1.5GB~2GB]";
            }
            if (j8 > 2000 && j8 <= 3000) {
                return "(2GB~3GB]";
            }
            if (j8 > 3000 && j8 <= 4000) {
                return "(3GB~4GB]";
            }
            if (j8 <= 4000 || j8 > 6000) {
                return (j8 <= 6000 || j8 > 8000) ? ">8G" : "(6GB~8GB]";
            }
            return "(4GB~6GB]";
        } catch (Throwable unused) {
            return "invalid";
        }
    }

    public static String b(ApplicationExitInfo applicationExitInfo) {
        return "ApplicationExitInfo\n\tProcess : " + applicationExitInfo.getProcessName() + "(" + applicationExitInfo.getPid() + ")\n\tTime : " + C0598e.h().format(new Date(applicationExitInfo.getTimestamp())) + "\n\tReason : " + applicationExitInfo.getReason() + " (" + c(applicationExitInfo.getReason()) + ")\n\tRSS = " + applicationExitInfo.getRss() + "\n\tPSS = " + applicationExitInfo.getPss() + "\n\tDescription : " + applicationExitInfo.getDescription() + "\n\tStatus = " + applicationExitInfo.getStatus() + "\n\tImportance = " + applicationExitInfo.getImportance();
    }

    public static String c(int i9) {
        switch (i9) {
            case 1:
                return "EXIT_SELF";
            case 2:
                return "SIGNALED";
            case 3:
                return "LOW_MEMORY";
            case 4:
                return "APP CRASH(EXCEPTION)";
            case 5:
                return "APP CRASH(NATIVE)";
            case 6:
                return "ANR";
            case 7:
                return "INITIALIZATION FAILURE";
            case 8:
                return "PERMISSION CHANGE";
            case 9:
                return "EXCESSIVE RESOURCE USAGE";
            case 10:
                return "USER REQUESTED";
            case 11:
                return "USER STOPPED";
            case 12:
                return "DEPENDENCY DIED";
            case 13:
                return "OTHER KILLS BY SYSTEM";
            case 14:
                return "FREEZER";
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static String d(int i9) {
        switch (i9) {
            case 1:
                return "WAIT FOR DEBUGGER";
            case 2:
                return "TOO MANY CACHED PROCS";
            case 3:
                return "TOO MANY EMPTY PROCS";
            case 4:
                return "TRIM EMPTY";
            case 5:
                return "LARGE CACHED";
            case 6:
                return "MEMORY PRESSURE";
            case 7:
                return "EXCESSIVE CPU USAGE";
            case 8:
                return "SYSTEM UPDATE_DONE";
            case 9:
                return "KILL ALL FG";
            case 10:
                return "KILL ALL BG EXCEPT";
            case 11:
                return "KILL UID";
            case 12:
                return "KILL PID";
            case 13:
                return "INVALID START";
            case 14:
                return "INVALID STATE";
            case 15:
                return "IMPERCEPTIBLE";
            case 16:
                return "REMOVE LRU";
            case 17:
                return "ISOLATED NOT NEEDED";
            case 18:
                return "CACHED IDLE FORCED APP STANDBY";
            case 19:
                return "FREEZER BINDER IOCTL";
            case 20:
                return "FREEZER BINDER TRANSACTION";
            case 21:
                return "FORCE STOP";
            case 22:
                return "REMOVE TASK";
            case 23:
                return "STOP APP";
            case 24:
                return "KILL BACKGROUND";
            case 25:
                return "PACKAGE UPDATE";
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static boolean e(int i9) {
        return i9 == 10 || i9 == 11;
    }
}
