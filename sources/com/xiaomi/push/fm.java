package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public class fm extends fj {
    public fm(Context context) {
        super(context, new fq() { // from class: com.xiaomi.push.fm.1
            @Override // com.xiaomi.push.fq
            public long a() {
                return 180000L;
            }

            @Override // com.xiaomi.push.fq
            /* JADX INFO: renamed from: b */
            public long mo795b() {
                return 180000L;
            }
        });
    }

    @Override // com.xiaomi.push.fj
    public void a(boolean z8, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (z8 || ((fj) this).f17421a == 0) {
            ((fj) this).f17421a = jElapsedRealtime + j;
        } else if (((fj) this).f17421a <= jElapsedRealtime) {
            ((fj) this).f17421a += j;
            if (((fj) this).f17421a < jElapsedRealtime) {
                ((fj) this).f17421a = jElapsedRealtime + j;
            }
        }
    }

    @Override // com.xiaomi.push.fj, com.xiaomi.push.fk.a
    /* JADX INFO: renamed from: b */
    public /* bridge */ /* synthetic */ void mo390b() {
        super.mo390b();
    }

    @Override // com.xiaomi.push.fj
    /* JADX INFO: renamed from: a */
    public Intent mo387a() {
        Intent intentMo387a = super.mo387a();
        intentMo387a.putExtra("FLAG_ALIGN_ALARM", true);
        intentMo387a.putExtra("ALARM_INTERVAL", 180000L);
        return intentMo387a;
    }
}
