package p070j3;

import R1.b;
import android.content.ContentValues;
import p061i1.h;

/* JADX INFO: compiled from: BatteryTmpLogDao.java */
/* JADX INFO: loaded from: classes.dex */
public final class a extends p055h3.a<b> implements p055h3.a.InterfaceC0207a<b> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f19853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f19854g = {"_id", "front", "type", "timestamp", "accumulation", "version_id", "source", "status", "scene", "process", "main_process", "sid"};

    @Override // p055h3.a.InterfaceC0207a
    public final b a(h3.a.b bVar) {
        int i9;
        long jB = bVar.b("_id");
        long jB2 = bVar.b("front");
        String strC = bVar.c("type");
        long jB3 = bVar.b("timestamp");
        long jB4 = bVar.b("accumulation");
        long jB5 = bVar.b("version_id");
        String strC2 = bVar.c("source");
        long jB6 = bVar.b("status");
        String strC3 = bVar.c("scene");
        try {
            i9 = bVar.f19032a.getInt(bVar.a("main_process"));
        } catch (Throwable unused) {
            i9 = -1;
        }
        String strC4 = bVar.c("process");
        boolean z8 = jB2 != 0;
        boolean z9 = jB6 != 0;
        b bVar2 = new b();
        bVar2.f3962b = z8;
        bVar2.f3963c = jB3;
        bVar2.f3964d = strC;
        bVar2.f3965e = z9;
        bVar2.f3966f = strC3;
        bVar2.f3967g = jB4;
        bVar2.f3968h = strC2;
        bVar2.j = strC4;
        bVar2.f3961a = jB;
        bVar2.f3969i = jB5;
        bVar2.f3970k = i9 == 1;
        bVar2.f3971l = bVar.c("sid");
        return bVar2;
    }

    @Override // p055h3.a
    public final String[] h() {
        return f19854g;
    }

    @Override // p055h3.a
    public final String i() {
        return "t_battery";
    }

    public final synchronized void k(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("front", Integer.valueOf(bVar.f3962b ? 1 : 0));
            contentValues.put("source", bVar.f3968h);
            contentValues.put("type", bVar.f3964d);
            contentValues.put("timestamp", Long.valueOf(bVar.f3963c));
            contentValues.put("accumulation", Long.valueOf(bVar.f3967g));
            contentValues.put("version_id", Long.valueOf(bVar.f3969i));
            contentValues.put("status", Integer.valueOf(bVar.f3965e ? 1 : 0));
            contentValues.put("scene", bVar.f3966f);
            contentValues.put("main_process", Integer.valueOf(bVar.f3970k ? 1 : 0));
            contentValues.put("process", bVar.j);
            contentValues.put("sid", bVar.f3971l);
            c(contentValues);
        } catch (Exception unused) {
        }
    }

    public final synchronized void l(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("delete_flag", (Integer) 1);
        try {
            h.f19229a.getContentResolver().update(j(), contentValues, "_id <= ? ", new String[]{String.valueOf(j)});
        } catch (Exception unused) {
        }
    }
}
