package G;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TaskStackBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class G implements Iterable<Intent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Intent> f2065a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.appcompat.app.f f2066b;

    /* JADX INFO: compiled from: TaskStackBuilder.java */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    public G(androidx.appcompat.app.f fVar) {
        this.f2066b = fVar;
    }

    @Override // java.lang.Iterable
    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.f2065a.iterator();
    }
}
