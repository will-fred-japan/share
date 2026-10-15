package p063i3;

import A1.b;
import R1.c;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.LinkedList;
import p061i1.h;
import p061i1.k;

/* JADX INFO: compiled from: AbsLogDao.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends c> extends p055h3.a<T> implements p055h3.a.InterfaceC0207a<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19294f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19295g;

    public final synchronized int k(String str) {
        int iDelete = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            iDelete = this.f19027a.getContentResolver().delete(j(), "_id in ( " + str + " )", null);
        } catch (Exception unused) {
        }
        return iDelete;
    }

    public final synchronized int l(LinkedList linkedList) {
        if (b.d0(linkedList)) {
            return -1;
        }
        int iK = k(b.m(linkedList, Constants.ACCEPT_TIME_SEPARATOR_SP));
        this.f19294f -= (long) iK;
        return iK;
    }

    public final synchronized void m(ArrayList arrayList) {
        int i9;
        ArrayList arrayList2;
        ContentValues contentValuesE;
        try {
            if (b.d0(arrayList)) {
                return;
            }
            int size = arrayList.size();
            int i10 = ((size - 1) / 50) + 1;
            i9 = 0;
            while (i9 < i10) {
                int i11 = i9 * 50;
                int iMin = Math.min(i11 + 50, size);
                arrayList2 = new ArrayList(iMin - i11);
                while (i11 < iMin) {
                    c cVar = (c) arrayList.get(i11);
                    try {
                        contentValuesE = e(cVar);
                    } catch (Throwable th) {
                        k.a.f19265a.b("apm_AbsLogDao_" + cVar.f3973b + cVar.f3974c, th);
                        contentValuesE = null;
                    }
                    if (contentValuesE == null) {
                        arrayList.set(i11, null);
                    } else {
                        arrayList2.add(contentValuesE);
                        cVar.getClass();
                        arrayList.set(i11, null);
                    }
                    i11++;
                }
                synchronized (this) {
                    if (!b.d0(arrayList2)) {
                        int size2 = arrayList2.size();
                        int i12 = 0;
                        while (i12 < size2) {
                            ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>(8);
                            for (int i13 = 0; i13 < 50 && i12 < size2; i13++) {
                                ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(j());
                                builderNewInsert.withValues((ContentValues) arrayList2.get(i12));
                                arrayList3.add(builderNewInsert.build());
                                i12++;
                            }
                            try {
                                ContentProviderResult[] contentProviderResultArrApplyBatch = h.f19229a.getContentResolver().applyBatch(this.f19028b, arrayList3);
                                if (h.f19230b) {
                                    for (ContentProviderResult contentProviderResult : contentProviderResultArrApplyBatch) {
                                        Log.i("<monitor><store>", p199z2.b.f(new String[]{"insertBatch ret: ", contentProviderResult.uri.toString()}));
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            arrayList.clear();
            return;
        } catch (Throwable th2) {
            throw th2;
        }
        arrayList2.clear();
        i9++;
    }
}
