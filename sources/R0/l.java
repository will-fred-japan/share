package R0;

import android.annotation.SuppressLint;
import android.app.Application;
import org.json.JSONObject;

/* JADX INFO: compiled from: NewUserModeLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class l extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Application f3953d;

    @Override // R0.c
    @SuppressLint({"MissingPermission"})
    public final boolean a(JSONObject jSONObject) {
        try {
            i.a(this.f3953d);
            if (!V0.m.f4822b) {
                return true;
            }
            V0.m.a("new user mode = false", null);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
