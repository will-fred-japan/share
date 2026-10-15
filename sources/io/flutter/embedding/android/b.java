package io.flutter.embedding.android;

import Z6.l;
import android.util.Log;
import android.view.KeyEvent;
import androidx.datastore.preferences.protobuf.C0524s;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: KeyEmbedderResponder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements c.InterfaceC0212c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p096m7.c f19383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Long, Long> f19384b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Long, d.e> f19385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c.a f19386d;

    public b(p096m7.c cVar) {
        HashMap<Long, d.e> map = new HashMap<>();
        this.f19385c = map;
        this.f19386d = new c.a();
        this.f19383a = cVar;
        d.a aVar = d.f19397a;
        d.e eVar = new d.e[]{new d.e()}[0];
        eVar.getClass();
        map.put(4294967556L, eVar);
    }

    /* JADX WARN: Code duplicated, block: B:137:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:138:0x02c9  */
    /* JADX WARN: Instruction removed from duplicated block: B:137:0x02ba, please report this as an issue */
    @Override // io.flutter.embedding.android.c.InterfaceC0212c
    public final void a(final KeyEvent keyEvent, c.b.a aVar) {
        Long lValueOf;
        long j;
        boolean z8;
        Long l8;
        String str;
        int i9;
        d.e eVar;
        int i10;
        char cCharValue;
        long j8;
        int i11;
        int i12;
        final long j9;
        long j10;
        b bVar = this;
        long j11 = 0;
        if (keyEvent.getScanCode() == 0 && keyEvent.getKeyCode() == 0) {
            j = 0;
        } else {
            long scanCode = keyEvent.getScanCode();
            if (scanCode == 0) {
                lValueOf = Long.valueOf((((long) keyEvent.getKeyCode()) & 4294967295L) | 73014444032L);
            } else {
                lValueOf = d.f19397a.get(Long.valueOf(scanCode));
                if (lValueOf == null) {
                    lValueOf = Long.valueOf((((long) keyEvent.getScanCode()) & 4294967295L) | 73014444032L);
                }
            }
            Long l9 = lValueOf;
            Long lValueOf2 = d.f19398b.get(Long.valueOf(keyEvent.getKeyCode()));
            if (lValueOf2 == null) {
                lValueOf2 = Long.valueOf((((long) keyEvent.getKeyCode()) & 4294967295L) | 73014444032L);
            }
            Long l10 = lValueOf2;
            ArrayList arrayList = new ArrayList();
            d.C0213d[] c0213dArr = d.f19399c;
            int length = c0213dArr.length;
            int i13 = 0;
            while (true) {
                HashMap<Long, Long> map = bVar.f19384b;
                int i14 = 2;
                if (i13 >= length) {
                    j = j11;
                    HashMap<Long, d.e> map2 = bVar.f19385c;
                    for (d.e eVar2 : map2.values()) {
                        int metaState = keyEvent.getMetaState();
                        eVar2.getClass();
                        boolean z9 = (metaState & 1048576) != 0;
                        if (4294967556L != l10.longValue() && eVar2.f19404a != z9) {
                            boolean zContainsKey = map.containsKey(458809L);
                            boolean z10 = !zContainsKey;
                            if (!zContainsKey) {
                                eVar2.f19404a = !eVar2.f19404a;
                            }
                            bVar.c(z10, 4294967556L, 458809L, keyEvent.getEventTime());
                            if (zContainsKey) {
                                eVar2.f19404a = !eVar2.f19404a;
                            }
                            c(zContainsKey, 4294967556L, 458809L, keyEvent.getEventTime());
                        }
                        bVar = this;
                    }
                    int action = keyEvent.getAction();
                    if (action == 0) {
                        z8 = true;
                    } else {
                        if (action != 1) {
                            bVar = this;
                            break;
                        }
                        z8 = false;
                    }
                    Long l11 = map.get(l9);
                    if (!z8) {
                        bVar = this;
                        l8 = l9;
                        if (l11 == null) {
                            break;
                        }
                        str = null;
                        i9 = 2;
                    } else {
                        if (l11 == null) {
                            i10 = 1;
                        } else {
                            if (keyEvent.getRepeatCount() > 0) {
                                i10 = 3;
                            } else {
                                bVar = this;
                                l8 = l9;
                                bVar.c(false, l11, l8, keyEvent.getEventTime());
                                i10 = 1;
                            }
                            cCharValue = bVar.f19386d.a(keyEvent.getUnicodeChar()).charValue();
                            if (cCharValue != 0) {
                                str = "" + cCharValue;
                            } else {
                                str = null;
                            }
                            i9 = i10;
                        }
                        bVar = this;
                        l8 = l9;
                        cCharValue = bVar.f19386d.a(keyEvent.getUnicodeChar()).charValue();
                        if (cCharValue != 0) {
                            str = "" + cCharValue;
                        } else {
                            str = null;
                        }
                        i9 = i10;
                    }
                    if (i9 != 3) {
                        bVar.d(l8, z8 ? l10 : null);
                    }
                    if (i9 == 1 && (eVar = map2.get(l10)) != null) {
                        eVar.f19404a = !eVar.f19404a;
                    }
                    l lVar = new l();
                    int source = keyEvent.getSource();
                    if (source == 513) {
                        lVar.f5594f = 2;
                    } else if (source == 1025) {
                        lVar.f5594f = 3;
                    } else if (source == 16777232) {
                        lVar.f5594f = 4;
                    } else if (source != 33554433) {
                        lVar.f5594f = 1;
                    } else {
                        lVar.f5594f = 5;
                    }
                    lVar.f5589a = keyEvent.getEventTime();
                    lVar.f5590b = i9;
                    lVar.f5592d = l10.longValue();
                    lVar.f5591c = l8.longValue();
                    lVar.f5595g = str;
                    lVar.f5593e = false;
                    bVar.b(lVar, aVar);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    return;
                }
                d.C0213d c0213d = c0213dArr[i13];
                boolean z11 = (keyEvent.getMetaState() & c0213d.f19402a) != 0;
                long jLongValue = l10.longValue();
                long jLongValue2 = l9.longValue();
                d.c[] cVarArr = c0213d.f19403b;
                boolean[] zArr = new boolean[2];
                long j12 = j11;
                Boolean[] boolArr = new Boolean[2];
                int i15 = 0;
                boolean z12 = false;
                while (i15 < i14) {
                    final d.c cVar = cVarArr[i15];
                    boolean[] zArr2 = zArr;
                    boolean zContainsKey2 = map.containsKey(Long.valueOf(cVar.f19400a));
                    zArr2[i15] = zContainsKey2;
                    Boolean[] boolArr2 = boolArr;
                    if (cVar.f19401b == jLongValue) {
                        boolean z13 = keyEvent.getRepeatCount() > 0;
                        int action2 = keyEvent.getAction();
                        if (action2 == 0) {
                            i12 = z13 ? 3 : 1;
                        } else {
                            if (action2 != 1) {
                                throw new AssertionError("Unexpected event type");
                            }
                            i12 = 2;
                        }
                        int iB = C0524s.b(i12);
                        if (iB != 0) {
                            if (iB != 1) {
                                i11 = 2;
                                if (iB != 2) {
                                    j10 = jLongValue2;
                                    i11 = 2;
                                } else {
                                    if (z11) {
                                        j9 = jLongValue2;
                                    } else {
                                        j9 = jLongValue2;
                                        arrayList.add(new Runnable() { // from class: Z6.o
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                io.flutter.embedding.android.b bVar2 = this.f5601a;
                                                bVar2.getClass();
                                                bVar2.c(false, Long.valueOf(cVar.f19401b), Long.valueOf(j9), keyEvent.getEventTime());
                                            }
                                        });
                                    }
                                    boolArr2[i15] = Boolean.valueOf(zArr2[i15]);
                                }
                            } else {
                                j10 = jLongValue2;
                                i11 = 2;
                                boolArr2[i15] = Boolean.valueOf(zArr2[i15]);
                            }
                            j8 = j10;
                        } else {
                            long j13 = jLongValue2;
                            cVarArr = cVarArr;
                            j9 = j13;
                            map = map;
                            i11 = 2;
                            i13 = i13;
                            boolArr2[i15] = Boolean.FALSE;
                            if (!z11) {
                                j8 = j9;
                                arrayList.add(new Runnable() { // from class: Z6.n
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        io.flutter.embedding.android.b bVar2 = this.f5597a;
                                        bVar2.getClass();
                                        bVar2.c(false, Long.valueOf(cVar.f19401b), Long.valueOf(j9), keyEvent.getEventTime());
                                    }
                                });
                            }
                            z12 = true;
                        }
                        j8 = j9;
                        z12 = true;
                    } else {
                        i13 = i13;
                        map = map;
                        j8 = jLongValue2;
                        i11 = 2;
                        cVarArr = cVarArr;
                        z12 = z12 || zContainsKey2;
                    }
                    i15++;
                    map = map;
                    i14 = i11;
                    cVarArr = cVarArr;
                    zArr = zArr2;
                    boolArr = boolArr2;
                    jLongValue2 = j8;
                    i13 = i13;
                }
                int i16 = i13;
                d.c[] cVarArr2 = cVarArr;
                boolean[] zArr3 = zArr;
                Boolean[] boolArr3 = boolArr;
                int i17 = i14;
                if (z11) {
                    for (int i18 = 0; i18 < i17; i18++) {
                        if (boolArr3[i18] == null) {
                            if (z12) {
                                boolArr3[i18] = Boolean.valueOf(zArr3[i18]);
                            } else {
                                boolArr3[i18] = Boolean.TRUE;
                                z12 = true;
                            }
                        }
                    }
                    if (!z12) {
                        boolArr3[0] = Boolean.TRUE;
                    }
                } else {
                    for (int i19 = 0; i19 < i17; i19++) {
                        if (boolArr3[i19] == null) {
                            boolArr3[i19] = Boolean.FALSE;
                        }
                    }
                }
                for (int i20 = 0; i20 < i17; i20++) {
                    if (zArr3[i20] != boolArr3[i20].booleanValue()) {
                        d.c cVar2 = cVarArr2[i20];
                        c(boolArr3[i20].booleanValue(), Long.valueOf(cVar2.f19401b), Long.valueOf(cVar2.f19400a), keyEvent.getEventTime());
                    }
                }
                bVar = this;
                i13 = i16 + 1;
                j11 = j12;
            }
        }
        bVar.c(true, Long.valueOf(j), Long.valueOf(j), 0L);
        aVar.a(true);
    }

    public final void b(l lVar, final c.b.a aVar) {
        long j;
        long j8;
        byte[] bytes = null;
        m7.c.b bVar = aVar == null ? null : new m7.c.b() { // from class: Z6.m
            @Override // m7.c.b
            public final void a(ByteBuffer byteBuffer) {
                Boolean boolValueOf = Boolean.FALSE;
                if (byteBuffer != null) {
                    byteBuffer.rewind();
                    if (byteBuffer.capacity() != 0) {
                        boolValueOf = Boolean.valueOf(byteBuffer.get() != 0);
                    }
                } else {
                    Log.w("KeyEmbedderResponder", "A null reply was received when sending a key event to the framework.");
                }
                aVar.a(boolValueOf.booleanValue());
            }
        };
        try {
            String str = lVar.f5595g;
            if (str != null) {
                bytes = str.getBytes("UTF-8");
            }
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(length + 56);
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocateDirect.putLong(length);
            byteBufferAllocateDirect.putLong(lVar.f5589a);
            int i9 = lVar.f5590b;
            if (i9 == 1) {
                j = 0;
            } else if (i9 == 2) {
                j = 1;
            } else {
                if (i9 != 3) {
                    throw null;
                }
                j = 2;
            }
            byteBufferAllocateDirect.putLong(j);
            byteBufferAllocateDirect.putLong(lVar.f5591c);
            byteBufferAllocateDirect.putLong(lVar.f5592d);
            byteBufferAllocateDirect.putLong(lVar.f5593e ? 1L : 0L);
            int i10 = lVar.f5594f;
            if (i10 == 1) {
                j8 = 0;
            } else if (i10 == 2) {
                j8 = 1;
            } else if (i10 == 3) {
                j8 = 2;
            } else if (i10 == 4) {
                j8 = 3;
            } else {
                if (i10 != 5) {
                    throw null;
                }
                j8 = 4;
            }
            byteBufferAllocateDirect.putLong(j8);
            if (bytes != null) {
                byteBufferAllocateDirect.put(bytes);
            }
            this.f19383a.a("flutter/keydata", byteBufferAllocateDirect, bVar);
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }

    public final void c(boolean z8, Long l8, Long l9, long j) {
        l lVar = new l();
        lVar.f5589a = j;
        lVar.f5590b = z8 ? 1 : 2;
        lVar.f5592d = l8.longValue();
        lVar.f5591c = l9.longValue();
        lVar.f5595g = null;
        lVar.f5593e = true;
        lVar.f5594f = 1;
        if (l9.longValue() != 0 && l8.longValue() != 0) {
            if (!z8) {
                l8 = null;
            }
            d(l9, l8);
        }
        b(lVar, null);
    }

    public final void d(Long l8, Long l9) {
        HashMap<Long, Long> map = this.f19384b;
        if (l9 != null) {
            if (map.put(l8, l9) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (map.remove(l8) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
