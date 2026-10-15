package p043g;

import android.os.Parcelable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import p051h.a;

/* JADX INFO: compiled from: ActivityResultRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f extends b<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f18740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f18741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a<Object, Object> f18742c;

    public f(d dVar, String str, a<Object, Object> aVar) {
        this.f18740a = dVar;
        this.f18741b = str;
        this.f18742c = aVar;
    }

    public final void a(Object obj) {
        d dVar = this.f18740a;
        LinkedHashMap linkedHashMap = dVar.f18730b;
        String str = this.f18741b;
        Object obj2 = linkedHashMap.get(str);
        a<Object, Object> aVar = this.f18742c;
        if (obj2 == null) {
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + aVar + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
        int iIntValue = ((Number) obj2).intValue();
        ArrayList arrayList = dVar.f18732d;
        arrayList.add(str);
        try {
            dVar.b(iIntValue, aVar, (Parcelable) obj);
        } catch (Exception e9) {
            arrayList.remove(str);
            throw e9;
        }
    }
}
