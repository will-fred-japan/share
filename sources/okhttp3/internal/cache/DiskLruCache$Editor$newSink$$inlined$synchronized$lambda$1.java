package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.jvm.internal.l;
import p188x7.k;

/* JADX INFO: compiled from: DiskLruCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 extends l implements K7.l<IOException, k> {
    final /* synthetic */ int $index$inlined;
    final /* synthetic */ DiskLruCache.Editor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(DiskLruCache.Editor editor, int i9) {
        super(1);
        this.this$0 = editor;
        this.$index$inlined = i9;
    }

    @Override // K7.l
    public /* bridge */ /* synthetic */ k invoke(IOException iOException) {
        invoke2(iOException);
        return k.f22364a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IOException it) {
        kotlin.jvm.internal.k.e(it, "it");
        synchronized (this.this$0.this$0) {
            this.this$0.detach$okhttp();
            k kVar = k.f22364a;
        }
    }
}
