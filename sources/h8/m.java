package h8;

import android.media.SoundPool;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SoundPoolPlayer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SoundPool f19155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, l> f19156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<i8.d, List<l>> f19157c;

    public m(SoundPool soundPool) {
        this.f19155a = soundPool;
        Map<Integer, l> mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        kotlin.jvm.internal.k.d(mapSynchronizedMap, "synchronizedMap(...)");
        this.f19156b = mapSynchronizedMap;
        Map<i8.d, List<l>> mapSynchronizedMap2 = Collections.synchronizedMap(new LinkedHashMap());
        kotlin.jvm.internal.k.d(mapSynchronizedMap2, "synchronizedMap(...)");
        this.f19157c = mapSynchronizedMap2;
    }
}
