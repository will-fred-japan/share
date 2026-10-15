package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f18108a = Integer.MAX_VALUE;

    public static void a(jp jpVar, byte b9) {
        a(jpVar, b9, f18108a);
    }

    public static void a(jp jpVar, byte b9, int i9) throws jj {
        if (i9 <= 0) {
            throw new jj("Maximum skip depth exceeded");
        }
        int i10 = 0;
        switch (b9) {
            case 2:
                jpVar.mo643a();
                return;
            case 3:
                jpVar.a();
                return;
            case 4:
                jpVar.mo630a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jpVar.mo640a();
                return;
            case 8:
                jpVar.mo631a();
                return;
            case 10:
                jpVar.mo632a();
                return;
            case 11:
                jpVar.mo639a();
                return;
            case 12:
                jpVar.mo637a();
                while (true) {
                    byte b10 = jpVar.mo633a().f18102a;
                    if (b10 == 0) {
                        jpVar.f();
                        return;
                    } else {
                        a(jpVar, b10, i9 - 1);
                        jpVar.g();
                    }
                }
                break;
            case 13:
                jo joVarMo635a = jpVar.mo635a();
                while (i10 < joVarMo635a.f918a) {
                    int i11 = i9 - 1;
                    a(jpVar, joVarMo635a.f18104a, i11);
                    a(jpVar, joVarMo635a.f18105b, i11);
                    i10++;
                }
                jpVar.h();
                return;
            case 14:
                jt jtVarMo636a = jpVar.mo636a();
                while (i10 < jtVarMo636a.f919a) {
                    a(jpVar, jtVarMo636a.f18109a, i9 - 1);
                    i10++;
                }
                jpVar.j();
                return;
            case 15:
                jn jnVarMo634a = jpVar.mo634a();
                while (i10 < jnVarMo634a.f917a) {
                    a(jpVar, jnVarMo634a.f18103a, i9 - 1);
                    i10++;
                }
                jpVar.i();
                return;
        }
    }
}
