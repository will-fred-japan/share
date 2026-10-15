package R0;

import android.app.Application;
import android.telephony.TelephonyManager;
import com.starburst.sdk.api.GuiControlConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SimCountryLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class q extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile String f3958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f3959f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Application f3960d;

    public q(Application application) {
        super(true, false);
        this.f3960d = application;
    }

    @Override // R0.c
    public final boolean a(JSONObject jSONObject) {
        try {
            if (f3958e == null && f3959f.compareAndSet(false, true)) {
                V0.m.a("SimCountryLoader do load sim country", null);
                try {
                    f3958e = ((TelephonyManager) this.f3960d.getSystemService(GuiControlConfig.DEVICE_PHONE)).getSimCountryIso();
                } catch (Throwable unused) {
                }
                if (f3958e == null) {
                    f3958e = "";
                }
            }
            g.b("sim_region", f3958e, jSONObject);
        } catch (Throwable unused2) {
        }
        return true;
    }
}
