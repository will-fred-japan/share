package U0;

import android.accounts.AccountManager;
import android.app.Application;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AccountCacheHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f4593b = new ConcurrentHashMap<>();

    public a(Application application) {
        AccountManager.get(application);
    }

    @Override // U0.d
    public final void c(String str, String str2) {
        this.f4593b.put(str, str2);
    }

    @Override // U0.d
    public final String d(String str) {
        return this.f4593b.get(str);
    }
}
