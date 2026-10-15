package androidx.recyclerview.widget;

import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.recyclerview.widget.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AdapterHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0549a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f8200d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S.c f8197a = new S.c(30);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<C0110a> f8198b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<C0110a> f8199c = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p f8201e = new p(this);

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdapterHelper.java */
    public static class C0110a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8203b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8204c;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj == null || C0110a.class != obj.getClass()) {
                    return false;
                }
                C0110a c0110a = (C0110a) obj;
                int i9 = this.f8202a;
                if (i9 != c0110a.f8202a) {
                    return false;
                }
                if (i9 != 8 || Math.abs(this.f8204c - this.f8203b) != 1 || this.f8204c != c0110a.f8203b || this.f8203b != c0110a.f8204c) {
                    return this.f8204c == c0110a.f8204c && this.f8203b == c0110a.f8203b;
                }
            }
            return true;
        }

        public final int hashCode() {
            return (((this.f8202a * 31) + this.f8203b) * 31) + this.f8204c;
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i9 = this.f8202a;
            if (i9 == 1) {
                str = "add";
            } else if (i9 == 2) {
                str = "rm";
            } else if (i9 != 4) {
                str = i9 != 8 ? "??" : "mv";
            } else {
                str = "up";
            }
            sb.append(str);
            sb.append(",s:");
            sb.append(this.f8203b);
            sb.append("c:");
            return A.f.i(sb, this.f8204c, ",p:null]");
        }
    }

    public C0549a(w wVar) {
        this.f8200d = wVar;
    }

    public final boolean a(int i9) {
        ArrayList<C0110a> arrayList = this.f8199c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            C0110a c0110a = arrayList.get(i10);
            int i11 = c0110a.f8202a;
            if (i11 != 8) {
                if (i11 == 1) {
                    int i12 = c0110a.f8203b;
                    int i13 = c0110a.f8204c + i12;
                    while (i12 < i13) {
                        if (e(i12, i10 + 1) == i9) {
                            return true;
                        }
                        i12++;
                    }
                } else {
                    continue;
                }
            } else {
                if (e(c0110a.f8204c, i10 + 1) == i9) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void b() {
        ArrayList<C0110a> arrayList = this.f8199c;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            this.f8200d.a(arrayList.get(i9));
        }
        i(arrayList);
        ArrayList<C0110a> arrayList2 = this.f8198b;
        int size2 = arrayList2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            C0110a c0110a = arrayList2.get(i10);
            int i11 = c0110a.f8202a;
            w wVar = this.f8200d;
            if (i11 == 1) {
                wVar.a(c0110a);
                wVar.d(c0110a.f8203b, c0110a.f8204c);
            } else if (i11 == 2) {
                wVar.a(c0110a);
                int i12 = c0110a.f8203b;
                int i13 = c0110a.f8204c;
                RecyclerView recyclerView = wVar.f8332a;
                recyclerView.O(i12, i13, true);
                recyclerView.f8022q0 = true;
                recyclerView.f8016n0.f8110c += i13;
            } else if (i11 == 4) {
                wVar.a(c0110a);
                wVar.c(c0110a.f8203b, c0110a.f8204c);
            } else if (i11 == 8) {
                wVar.a(c0110a);
                wVar.e(c0110a.f8203b, c0110a.f8204c);
            }
        }
        i(arrayList2);
    }

    public final void c(C0110a c0110a) {
        int i9;
        S.c cVar;
        int i10 = c0110a.f8202a;
        if (i10 == 1 || i10 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iJ = j(c0110a.f8203b, i10);
        int i11 = c0110a.f8203b;
        int i12 = c0110a.f8202a;
        if (i12 == 2) {
            i9 = 0;
        } else {
            if (i12 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + c0110a);
            }
            i9 = 1;
        }
        int i13 = 1;
        int i14 = 1;
        while (true) {
            int i15 = c0110a.f8204c;
            cVar = this.f8197a;
            if (i13 >= i15) {
                break;
            }
            int iJ2 = j((i9 * i13) + c0110a.f8203b, c0110a.f8202a);
            int i16 = c0110a.f8202a;
            if (i16 == 2 ? iJ2 != iJ : !(i16 == 4 && iJ2 == iJ + 1)) {
                C0110a c0110aG = g(i16, iJ, i14);
                d(c0110aG, i11);
                cVar.f(c0110aG);
                if (c0110a.f8202a == 4) {
                    i11 += i14;
                }
                i14 = 1;
                iJ = iJ2;
            } else {
                i14++;
            }
            i13++;
        }
        cVar.f(c0110a);
        if (i14 > 0) {
            C0110a c0110aG2 = g(c0110a.f8202a, iJ, i14);
            d(c0110aG2, i11);
            cVar.f(c0110aG2);
        }
    }

    public final void d(C0110a c0110a, int i9) {
        w wVar = this.f8200d;
        wVar.a(c0110a);
        int i10 = c0110a.f8202a;
        if (i10 != 2) {
            if (i10 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            wVar.c(i9, c0110a.f8204c);
        } else {
            int i11 = c0110a.f8204c;
            RecyclerView recyclerView = wVar.f8332a;
            recyclerView.O(i9, i11, true);
            recyclerView.f8022q0 = true;
            recyclerView.f8016n0.f8110c += i11;
        }
    }

    public final int e(int i9, int i10) {
        ArrayList<C0110a> arrayList = this.f8199c;
        int size = arrayList.size();
        while (i10 < size) {
            C0110a c0110a = arrayList.get(i10);
            int i11 = c0110a.f8202a;
            if (i11 == 8) {
                int i12 = c0110a.f8203b;
                if (i12 == i9) {
                    i9 = c0110a.f8204c;
                } else {
                    if (i12 < i9) {
                        i9--;
                    }
                    if (c0110a.f8204c <= i9) {
                        i9++;
                    }
                }
            } else {
                int i13 = c0110a.f8203b;
                if (i13 > i9) {
                    continue;
                } else if (i11 == 2) {
                    int i14 = c0110a.f8204c;
                    if (i9 < i13 + i14) {
                        return -1;
                    }
                    i9 -= i14;
                } else if (i11 == 1) {
                    i9 += c0110a.f8204c;
                }
            }
            i10++;
        }
        return i9;
    }

    public final boolean f() {
        return this.f8198b.size() > 0;
    }

    public final C0110a g(int i9, int i10, int i11) {
        C0110a c0110a = (C0110a) this.f8197a.d();
        if (c0110a != null) {
            c0110a.f8202a = i9;
            c0110a.f8203b = i10;
            c0110a.f8204c = i11;
            return c0110a;
        }
        C0110a c0110a2 = new C0110a();
        c0110a2.f8202a = i9;
        c0110a2.f8203b = i10;
        c0110a2.f8204c = i11;
        return c0110a2;
    }

    public final void h(C0110a c0110a) {
        this.f8199c.add(c0110a);
        int i9 = c0110a.f8202a;
        w wVar = this.f8200d;
        if (i9 == 1) {
            wVar.d(c0110a.f8203b, c0110a.f8204c);
            return;
        }
        if (i9 == 2) {
            int i10 = c0110a.f8203b;
            int i11 = c0110a.f8204c;
            RecyclerView recyclerView = wVar.f8332a;
            recyclerView.O(i10, i11, false);
            recyclerView.f8022q0 = true;
            return;
        }
        if (i9 == 4) {
            wVar.c(c0110a.f8203b, c0110a.f8204c);
        } else if (i9 == 8) {
            wVar.e(c0110a.f8203b, c0110a.f8204c);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + c0110a);
        }
    }

    public final void i(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            C0110a c0110a = (C0110a) arrayList.get(i9);
            c0110a.getClass();
            this.f8197a.f(c0110a);
        }
        arrayList.clear();
    }

    public final int j(int i9, int i10) {
        int i11;
        int i12;
        ArrayList<C0110a> arrayList = this.f8199c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C0110a c0110a = arrayList.get(size);
            int i13 = c0110a.f8202a;
            if (i13 == 8) {
                int i14 = c0110a.f8203b;
                int i15 = c0110a.f8204c;
                if (i14 < i15) {
                    i12 = i14;
                    i11 = i15;
                } else {
                    i11 = i14;
                    i12 = i15;
                }
                if (i9 < i12 || i9 > i11) {
                    if (i9 < i14) {
                        if (i10 == 1) {
                            c0110a.f8203b = i14 + 1;
                            c0110a.f8204c = i15 + 1;
                        } else if (i10 == 2) {
                            c0110a.f8203b = i14 - 1;
                            c0110a.f8204c = i15 - 1;
                        }
                    }
                } else if (i12 == i14) {
                    if (i10 == 1) {
                        c0110a.f8204c = i15 + 1;
                    } else if (i10 == 2) {
                        c0110a.f8204c = i15 - 1;
                    }
                    i9++;
                } else {
                    if (i10 == 1) {
                        c0110a.f8203b = i14 + 1;
                    } else if (i10 == 2) {
                        c0110a.f8203b = i14 - 1;
                    }
                    i9--;
                }
            } else {
                int i16 = c0110a.f8203b;
                if (i16 <= i9) {
                    if (i13 == 1) {
                        i9 -= c0110a.f8204c;
                    } else if (i13 == 2) {
                        i9 += c0110a.f8204c;
                    }
                } else if (i10 == 1) {
                    c0110a.f8203b = i16 + 1;
                } else if (i10 == 2) {
                    c0110a.f8203b = i16 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            C0110a c0110a2 = arrayList.get(size2);
            int i17 = c0110a2.f8202a;
            S.c cVar = this.f8197a;
            if (i17 == 8) {
                int i18 = c0110a2.f8204c;
                if (i18 == c0110a2.f8203b || i18 < 0) {
                    arrayList.remove(size2);
                    cVar.f(c0110a2);
                }
            } else if (c0110a2.f8204c <= 0) {
                arrayList.remove(size2);
                cVar.f(c0110a2);
            }
        }
        return i9;
    }
}
