package cn.jpush.android.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.p;
import cn.jpush.android.helper.Logger;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Queue<a> f11348a;

    public static synchronized void a(Context context, String str) {
        try {
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
                return;
            }
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                Logger.w("MsgQueueUtils", "can't get files dir");
                return;
            }
            File file = new File(filesDir, str);
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized ArrayList<a> b(Context context, String str) {
        if (context == null) {
            Logger.w("MsgQueueUtils", "unexcepted , context is null");
            return null;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            File file = new File(context.getFilesDir(), str);
            if (file.exists()) {
                String strC = cn.jpush.android.ad.d.c(file);
                if (!TextUtils.isEmpty(strC)) {
                    JSONArray jSONArray = new JSONArray(strC);
                    for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                        arrayList.add(a.a(jSONArray.getJSONObject(i9)));
                    }
                }
            }
        } catch (Throwable th) {
            try {
                Logger.w("MsgQueueUtils", "load objects error:" + th.getMessage());
                a(context, str);
            } catch (Throwable th2) {
                p.a((Closeable) null);
                throw th2;
            }
        }
        p.a((Closeable) null);
        return arrayList;
    }

    private static synchronized void a(Context context, String str, ArrayList<a> arrayList) {
        Logger.v("MsgQueueUtils", "Action - saveObjects");
        if (context == null) {
            Logger.w("MsgQueueUtils", "unexcepted , context is null");
            return;
        }
        if (arrayList == null) {
            Logger.w("MsgQueueUtils", "mObjectList is null");
            return;
        }
        try {
            File file = new File(context.getFilesDir(), str);
            JSONArray jSONArray = new JSONArray();
            for (int i9 = 0; i9 < arrayList.size(); i9++) {
                jSONArray.put(arrayList.get(i9).a());
            }
            cn.jpush.android.ad.d.a(file.getAbsolutePath(), jSONArray.toString());
        } catch (Throwable th) {
            Logger.ww("MsgQueueUtils", "save Objects  error:" + th.getMessage());
        }
    }

    public static boolean a(Context context, a aVar) {
        if (f11348a == null) {
            f11348a = new ConcurrentLinkedQueue();
            try {
                ArrayList<a> arrayListB = b(context, "msg_queue_v350");
                if (arrayListB != null && !arrayListB.isEmpty()) {
                    Iterator<a> it = arrayListB.iterator();
                    while (it.hasNext()) {
                        f11348a.offer(it.next());
                    }
                }
            } catch (Exception e9) {
                Logger.ww("MsgQueueUtils", "init lastMsgQueue failed:" + e9.getMessage());
            }
        }
        if (context == null) {
            Logger.ww("MsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (aVar == null) {
            Logger.ww("MsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (f11348a.contains(aVar)) {
            Logger.e("MsgQueueUtils", "Duplicated msg. Give up processing - " + aVar);
            return true;
        }
        if (f11348a.size() >= 200) {
            f11348a.poll();
        }
        f11348a.offer(aVar);
        try {
            ArrayList<a> arrayListB2 = b(context, "msg_queue_v350");
            if (arrayListB2 == null) {
                arrayListB2 = new ArrayList<>();
            }
            if (arrayListB2.size() >= 50) {
                arrayListB2.remove(0);
            }
            arrayListB2.add(aVar);
            a(context, "msg_queue_v350", arrayListB2);
        } catch (Exception e10) {
            Logger.ww("MsgQueueUtils", "msg save in sp failed:" + e10.getMessage());
        }
        return false;
    }
}
