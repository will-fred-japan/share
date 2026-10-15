package V0;

import android.content.Context;

/* JADX INFO: compiled from: PrivateAgreement.java */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f4816b = new a(0);

    /* JADX INFO: compiled from: PrivateAgreement.java */
    public static class a extends V0.a {
        @Override // V0.a
        public final Object a(Object[] objArr) {
            return ((Context) objArr[0]).getSharedPreferences("ug_install_settings_pref", 0);
        }
    }
}
