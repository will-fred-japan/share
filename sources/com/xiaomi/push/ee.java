package com.xiaomi.push;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ee {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f308a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f309b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f17295d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f17296e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f17292a = 0;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        private boolean f310c = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f17293b = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f17297f = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private List<String> f307a = Collections.EMPTY_LIST;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f17294c = -1;

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public boolean m262b() {
            return this.f310c;
        }

        public int c() {
            return this.f17292a;
        }

        public int d() {
            return this.f17293b;
        }

        /* JADX INFO: renamed from: e, reason: collision with other method in class */
        public boolean m265e() {
            return this.f17297f;
        }

        public boolean f() {
            return this.f17296e;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m261a() {
            return this.f308a;
        }

        public a b(int i9) {
            this.f17295d = true;
            this.f17293b = i9;
            return this;
        }

        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public boolean m263c() {
            return this.f309b;
        }

        /* JADX INFO: renamed from: d, reason: collision with other method in class */
        public boolean m264d() {
            return this.f17295d;
        }

        public int e() {
            return this.f307a.size();
        }

        public a a(int i9) {
            this.f308a = true;
            this.f17292a = i9;
            return this;
        }

        public a b(boolean z8) {
            this.f17296e = true;
            this.f17297f = z8;
            return this;
        }

        public a a(boolean z8) {
            this.f309b = true;
            this.f310c = z8;
            return this;
        }

        @Override // com.xiaomi.push.f
        public int b() {
            int iA = 0;
            int iB = m261a() ? d.b(1, c()) : 0;
            if (m263c()) {
                iB += d.a(2, m262b());
            }
            if (m264d()) {
                iB += d.a(3, d());
            }
            if (f()) {
                iB += d.a(4, m265e());
            }
            Iterator<String> it = m260a().iterator();
            while (it.hasNext()) {
                iA += d.a(it.next());
            }
            int size = m260a().size() + iB + iA;
            this.f17294c = size;
            return size;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public List<String> m260a() {
            return this.f307a;
        }

        public a a(String str) {
            str.getClass();
            if (this.f307a.isEmpty()) {
                this.f307a = new ArrayList();
            }
            this.f307a.add(str);
            return this;
        }

        @Override // com.xiaomi.push.f
        public void a(d dVar) throws IOException {
            if (m261a()) {
                dVar.m214b(1, c());
            }
            if (m263c()) {
                dVar.m206a(2, m262b());
            }
            if (m264d()) {
                dVar.m201a(3, d());
            }
            if (f()) {
                dVar.m206a(4, m265e());
            }
            Iterator<String> it = m260a().iterator();
            while (it.hasNext()) {
                dVar.m205a(5, it.next());
            }
        }

        public static a b(c cVar) {
            return new a().a(cVar);
        }

        @Override // com.xiaomi.push.f
        public int a() {
            if (this.f17294c < 0) {
                b();
            }
            return this.f17294c;
        }

        @Override // com.xiaomi.push.f
        public a a(c cVar) throws e {
            while (true) {
                int iM139a = cVar.m139a();
                if (iM139a == 0) {
                    break;
                }
                if (iM139a == 8) {
                    a(cVar.c());
                } else if (iM139a == 16) {
                    a(cVar.m145a());
                } else if (iM139a == 24) {
                    b(cVar.m148b());
                } else if (iM139a == 32) {
                    b(cVar.m145a());
                } else if (iM139a != 42) {
                    if (!a(cVar, iM139a)) {
                        break;
                    }
                } else {
                    a(cVar.m142a());
                }
            }
            return this;
        }

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }
    }
}
