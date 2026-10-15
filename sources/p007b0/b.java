package p007b0;

import K7.a;
import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: PreferenceDataStoreDelegate.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b extends l implements a<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f8479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f8480b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, c cVar) {
        super(0);
        this.f8479a = context;
        this.f8480b = cVar;
    }

    @Override // K7.a
    public final File invoke() {
        Context context = this.f8479a;
        this.f8480b.getClass();
        String fileName = "FlutterSharedPreferences".concat(".preferences_pb");
        k.e(fileName, "fileName");
        return new File(context.getApplicationContext().getFilesDir(), "datastore/".concat(fileName));
    }
}
