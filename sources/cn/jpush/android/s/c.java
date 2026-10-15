package cn.jpush.android.s;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownTimer f11550a;

    public interface a {
        void a();
    }

    public void a() {
        CountDownTimer countDownTimer = this.f11550a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f11550a = null;
        }
    }

    public void a(final a aVar, long j, long j8) {
        this.f11550a = new CountDownTimer(j, j8) { // from class: cn.jpush.android.s.c.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j9) {
            }
        }.start();
    }
}
