package h8;

import android.media.AudioAttributes;
import android.media.SoundPool;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.B;
import y7.p;

/* JADX INFO: compiled from: SoundPoolPlayer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g8.b f19135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<AudioAttributes, m> f19136b;

    public k(g8.b ref) {
        kotlin.jvm.internal.k.e(ref, "ref");
        this.f19135a = ref;
        this.f19136b = new HashMap<>();
    }

    public final void a(g8.a aVar) {
        AudioAttributes audioAttributesA = aVar.a();
        HashMap<AudioAttributes, m> map = this.f19136b;
        if (map.containsKey(audioAttributesA)) {
            return;
        }
        SoundPool soundPoolBuild = new SoundPool.Builder().setAudioAttributes(audioAttributesA).setMaxStreams(32).build();
        this.f19135a.b("Create SoundPool with " + audioAttributesA);
        kotlin.jvm.internal.k.b(soundPoolBuild);
        final m mVar = new m(soundPoolBuild);
        soundPoolBuild.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: h8.j
            @Override // android.media.SoundPool.OnLoadCompleteListener
            public final void onLoadComplete(SoundPool soundPool, int i9, int i10) {
                k kVar = this.f19133a;
                m mVar2 = mVar;
                kVar.f19135a.b("Loaded " + i9);
                l lVar = mVar2.f19156b.get(Integer.valueOf(i9));
                i8.d dVar = lVar != null ? lVar.f19144h : null;
                if (dVar != null) {
                    Map<Integer, l> map2 = mVar2.f19156b;
                    Integer num = lVar.f19140d;
                    if (map2 instanceof L7.a) {
                        B.d(map2, "kotlin.collections.MutableMap");
                        throw null;
                    }
                    try {
                        map2.remove(num);
                        synchronized (mVar2.f19157c) {
                            try {
                                List<l> list = mVar2.f19157c.get(dVar);
                                if (list == null) {
                                    list = p.f22408a;
                                }
                                for (l lVar2 : list) {
                                    lVar2.f19137a.c("Marking " + lVar2 + " as loaded");
                                    lVar2.f19137a.h(true);
                                    n nVar = lVar2.f19137a;
                                    if (nVar.f19170n) {
                                        nVar.c("Delayed start of " + lVar2);
                                        lVar2.start();
                                    }
                                }
                                p188x7.k kVar2 = p188x7.k.f22364a;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } catch (ClassCastException e9) {
                        kotlin.jvm.internal.k.g(e9, B.class.getName());
                        throw e9;
                    }
                }
            }
        });
        map.put(audioAttributesA, mVar);
    }
}
