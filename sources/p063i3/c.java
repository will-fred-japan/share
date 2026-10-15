package p063i3;

import android.content.ContentValues;
import p055h3.a;

/* JADX INFO: compiled from: DefaultLogDao.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a<R1.c> {
    @Override // p055h3.a.InterfaceC0207a
    public final Object a(a.b bVar) {
        long jB = bVar.b("_id");
        String strC = bVar.c("type");
        long jB2 = bVar.b("version_id");
        String strC2 = bVar.c("data");
        String strC3 = bVar.c("type2");
        R1.c cVar = new R1.c(strC, jB, strC2, jB2);
        cVar.f3974c = strC3;
        return cVar;
    }

    @Override // p055h3.a
    public final ContentValues e(R1.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", cVar.f3973b);
        contentValues.put("type2", cVar.f3974c);
        contentValues.put("timestamp", (Long) 0L);
        contentValues.put("version_id", Long.valueOf(cVar.f3976e));
        contentValues.put("data", cVar.f3975d.toString());
        contentValues.put("is_sampled", (Integer) 0);
        return contentValues;
    }

    @Override // p055h3.a
    public final String[] h() {
        return new String[]{"_id", "type", "type2", "version_id", "data", "delete_flag"};
    }

    @Override // p055h3.a
    public final String i() {
        return "local_monitor_log";
    }
}
