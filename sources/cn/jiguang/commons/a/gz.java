package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
public final class gz extends AbstractC0552a {
    private gz() {
    }

    public static gz b() {
        return hb.f10139a;
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final String a() {
        return "JBluetooth";
    }

    public /* synthetic */ gz(byte b9) {
        this();
    }

    @Override // cn.jiguang.commons.a.AbstractC0552a
    public final void a(boolean z8) {
        try {
            if (bq.a().a(2400, z8)) {
                jc.a().a(new ha(this), z8);
            }
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("ble err:"), "JBluetooth");
        }
    }
}
