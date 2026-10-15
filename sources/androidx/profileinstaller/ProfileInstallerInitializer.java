package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.appcompat.app.h;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements p140s0.b<a> {

    public static class a {
    }

    @Override // p140s0.b
    public final List<Class<? extends p140s0.b<?>>> a() {
        return Collections.EMPTY_LIST;
    }

    @Override // p140s0.b
    public final a b(Context context) {
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: p0.c
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                this.f20759a.getClass();
                (Build.VERSION.SDK_INT >= 28 ? Handler.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new h(applicationContext, 1), new Random().nextInt(Math.max(1000, 1)) + 5000);
            }
        });
        return new a();
    }
}
