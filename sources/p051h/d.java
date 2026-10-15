package p051h;

import I.a;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import p188x7.e;
import y7.g;
import y7.i;
import y7.q;
import y7.t;
import y7.u;

/* JADX INFO: compiled from: ActivityResultContracts.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a<String[], Map<String, Boolean>> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p051h.a
    public final Intent a(Context context, Parcelable parcelable) {
        String[] input = (String[]) parcelable;
        k.e(input, "input");
        Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
        k.d(intentPutExtra, "putExtra(...)");
        return intentPutExtra;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p051h.a
    public final a.C0205a b(Context context, Parcelable parcelable) {
        String[] input = (String[]) parcelable;
        k.e(input, "input");
        if (input.length == 0) {
            return new a.C0205a(q.f22409a);
        }
        for (String str : input) {
            if (a.a(context, str) != 0) {
                return null;
            }
        }
        int iA = t.A(input.length);
        if (iA < 16) {
            iA = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA);
        for (String str2 : input) {
            linkedHashMap.put(str2, Boolean.TRUE);
        }
        return new a.C0205a(linkedHashMap);
    }

    @Override // p051h.a
    public final Map<String, Boolean> c(int i9, Intent intent) {
        q qVar = q.f22409a;
        if (i9 == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra != null && stringArrayExtra != null) {
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i10 : intArrayExtra) {
                    arrayList.add(Boolean.valueOf(i10 == 0));
                }
                ArrayList arrayListK = g.k(stringArrayExtra);
                Iterator it = arrayListK.iterator();
                Iterator it2 = arrayList.iterator();
                ArrayList arrayList2 = new ArrayList(Math.min(i.E(arrayListK), i.E(arrayList)));
                while (it.hasNext() && it2.hasNext()) {
                    arrayList2.add(new e(it.next(), it2.next()));
                }
                return u.H(arrayList2);
            }
        }
        return qVar;
    }
}
