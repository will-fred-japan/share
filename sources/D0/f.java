package D0;

import K7.l;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.k;
import p056h5.C0598e;
import y7.p;

/* JADX INFO: compiled from: SpecificationComputer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f<T> extends A0.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f1822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f1825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f1826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f1827g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(T value, String tag, String str, a logger, h verificationMode) {
        Collection collectionY;
        super(2);
        k.e(value, "value");
        k.e(tag, "tag");
        k.e(logger, "logger");
        k.e(verificationMode, "verificationMode");
        this.f1822b = value;
        this.f1823c = tag;
        this.f1824d = str;
        this.f1825e = logger;
        this.f1826f = verificationMode;
        String message = A0.h.e(value, str);
        k.e(message, "message");
        j jVar = new j(message);
        StackTraceElement[] stackTrace = jVar.getStackTrace();
        k.d(stackTrace, "stackTrace");
        int length = stackTrace.length - 2;
        length = length < 0 ? 0 : length;
        if (length < 0) {
            throw new IllegalArgumentException(defpackage.f.b(length, "Requested element count ", " is less than zero.").toString());
        }
        if (length == 0) {
            collectionY = p.f22408a;
        } else {
            int length2 = stackTrace.length;
            if (length >= length2) {
                collectionY = y7.g.o(stackTrace);
            } else if (length == 1) {
                collectionY = C0598e.y(stackTrace[length2 - 1]);
            } else {
                ArrayList arrayList = new ArrayList(length);
                for (int i9 = length2 - length; i9 < length2; i9++) {
                    arrayList.add(stackTrace[i9]);
                }
                collectionY = arrayList;
            }
        }
        jVar.setStackTrace((StackTraceElement[]) collectionY.toArray(new StackTraceElement[0]));
        this.f1827g = jVar;
    }

    @Override // A0.h
    public final T d() throws j {
        int iOrdinal = this.f1826f.ordinal();
        if (iOrdinal == 0) {
            throw this.f1827g;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return null;
            }
            throw new L4.b();
        }
        String message = A0.h.e(this.f1822b, this.f1824d);
        a aVar = this.f1825e;
        String tag = this.f1823c;
        aVar.getClass();
        k.e(tag, "tag");
        k.e(message, "message");
        Log.d(tag, message);
        return null;
    }

    @Override // A0.h
    public final A0.h u(String str, l<? super T, Boolean> condition) {
        k.e(condition, "condition");
        return this;
    }
}
