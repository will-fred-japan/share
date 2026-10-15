package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0568g extends AbstractC0569h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14066a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0569h f14068c;

    public C0568g(AbstractC0569h abstractC0569h) {
        this.f14068c = abstractC0569h;
        this.f14067b = abstractC0569h.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f14066a < this.f14067b;
    }
}
