package S4;

import android.accounts.Account;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: S4.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0371b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Account f4173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f4174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f4175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f4177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p079k5.a f4178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f4179g;

    /* JADX INFO: renamed from: S4.b$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Account f4180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public p155u.b f4181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f4182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f4183d;
    }

    public C0371b(Account account, Set set, String str, String str2) {
        p079k5.a aVar = p079k5.a.f19972a;
        this.f4173a = account;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f4174b = setUnmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.f4176d = str;
        this.f4177e = str2;
        this.f4178f = aVar;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((C0381l) it.next()).getClass();
            hashSet.addAll(null);
        }
        this.f4175c = Collections.unmodifiableSet(hashSet);
    }
}
