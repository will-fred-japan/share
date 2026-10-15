package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
class fl extends fj {
    public fl(final Context context) {
        super(context, new fq() { // from class: com.xiaomi.push.fl.1
            @Override // com.xiaomi.push.fq
            public long a() {
                return com.xiaomi.push.service.p.a(context).m808a();
            }

            @Override // com.xiaomi.push.fq
            /* JADX INFO: renamed from: b */
            public long mo795b() {
                return com.xiaomi.push.service.p.a(context).b();
            }
        });
    }
}
