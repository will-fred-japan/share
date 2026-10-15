package com.engagelab.privates.common;

import android.content.Context;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.FileUtils;
import com.engagelab.privates.common.utils.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Queue<y0> f12175a;

    public static synchronized void a(Context context, String str, ArrayList<y0> arrayList) {
        MTCommonLog.d("MsgQueueUtils", "Action - saveObjects");
        if (context == null) {
            MTCommonLog.w("MsgQueueUtils", "unexcepted , context is null");
            return;
        }
        if (arrayList == null) {
            MTCommonLog.w("MsgQueueUtils", "mObjectList is null");
            return;
        }
        try {
            File appKeyFile = FileUtils.getAppKeyFile(context, str);
            JSONArray jSONArray = new JSONArray();
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                jSONArray.put(arrayList.get(i9).a());
            }
            FileUtils.save(appKeyFile.getAbsolutePath(), jSONArray.toString());
        } catch (Throwable th) {
            MTCommonLog.i("MsgQueueUtils", "save Objects  error:" + th.getMessage());
        }
    }

    public static synchronized void b(Context context, String str) {
        try {
            if (context == null) {
                MTCommonLog.w("MsgQueueUtils", "unexcepted , context is null");
                return;
            }
            File appKeyFile = FileUtils.getAppKeyFile(context, str);
            if (appKeyFile.exists()) {
                appKeyFile.delete();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized ArrayList<y0> a(Context context, String str) {
        FileInputStream fileInputStream = null;
        if (context == null) {
            MTCommonLog.w("MsgQueueUtils", "unexcepted , context is null");
            return null;
        }
        ArrayList<y0> arrayList = new ArrayList<>();
        try {
            File appKeyFile = FileUtils.getAppKeyFile(context, str);
            if (appKeyFile.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(appKeyFile);
                try {
                    JSONArray jSONArray = new JSONArray(new String(Utils.readAvailable(fileInputStream2)));
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        arrayList.add(y0.a(jSONArray.getJSONObject(i9), -1L));
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        MTCommonLog.w("MsgQueueUtils", "load objects error:" + th.getMessage());
                        b(context, str);
                        Utils.closeQuietly(fileInputStream);
                    } catch (Throwable th2) {
                        Utils.closeQuietly(fileInputStream);
                        throw th2;
                    }
                }
            }
            Utils.closeQuietly(fileInputStream);
        } catch (Throwable th3) {
            th = th3;
        }
        return arrayList;
    }

    public static boolean a(Context context, y0 y0Var) {
        if (f12175a == null) {
            f12175a = new ConcurrentLinkedQueue();
            try {
                ArrayList<y0> arrayListA = a(context, "msg_queue_v350_privates");
                if (arrayListA != null && !arrayListA.isEmpty()) {
                    Iterator<y0> it = arrayListA.iterator();
                    while (it.hasNext()) {
                        f12175a.offer(it.next());
                    }
                }
            } catch (Exception e9) {
                MTCommonLog.i("MsgQueueUtils", "init lastMsgQueue failed:" + e9.getMessage());
            }
        }
        if (context == null) {
            MTCommonLog.i("MsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (y0Var == null) {
            MTCommonLog.i("MsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (f12175a.contains(y0Var)) {
            MTCommonLog.e("MsgQueueUtils", "Duplicated msg. Give up processing - " + y0Var);
            return true;
        }
        if (f12175a.size() >= 200) {
            f12175a.poll();
        }
        f12175a.offer(y0Var);
        try {
            ArrayList<y0> arrayListA2 = a(context, "msg_queue_v350_privates");
            if (arrayListA2 == null) {
                arrayListA2 = new ArrayList<>();
            }
            if (arrayListA2.size() >= 50) {
                arrayListA2.remove(0);
            }
            arrayListA2.add(y0Var);
            a(context, "msg_queue_v350_privates", arrayListA2);
        } catch (Exception e10) {
            MTCommonLog.i("MsgQueueUtils", "msg save in sp failed:" + e10.getMessage());
        }
        return false;
    }
}
