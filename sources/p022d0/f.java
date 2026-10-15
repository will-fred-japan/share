package p022d0;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: EmojiExclusions.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    @SuppressLint({"BanUncheckedReflection"})
    public static Set<int[]> a() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", new Class[0]).invoke(null, new Object[0]);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set<int[]> set = (Set) objInvoke;
            Iterator<int[]> it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }
}
