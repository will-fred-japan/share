package com.engagelab.privates.common;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CountDownTimer f12249a;

    public interface b {
        void a();
    }

    public void a(b bVar, long j, long j8) {
        this.f12249a = new a(this, j, j8, bVar).start();
    }

    public void a() {
        CountDownTimer countDownTimer = this.f12249a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f12249a = null;
        }
    }

    public class a extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f12250a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i0 i0Var, long j, long j8, b bVar) {
            super(j, j8);
            this.f12250a = bVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            b bVar = this.f12250a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }
}
