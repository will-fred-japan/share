package cn.jiguang.ad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f8985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private short f8986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private short f8987c;

    public h() {
        this.f8985a = new ArrayList(1);
        this.f8986b = (short) 0;
        this.f8987c = (short) 0;
    }

    private String a(Iterator it) {
        StringBuffer stringBuffer = new StringBuffer();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            stringBuffer.append("[");
            stringBuffer.append(iVar.c());
            stringBuffer.append("]");
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public g b() {
        return f().d();
    }

    public int c() {
        return f().f();
    }

    public int d() {
        return f().g();
    }

    public synchronized long e() {
        return f().h();
    }

    public synchronized i f() {
        if (this.f8985a.size() == 0) {
            throw new IllegalStateException("rrset is empty");
        }
        return (i) this.f8985a.get(0);
    }

    public String toString() {
        if (this.f8985a.size() == 0) {
            return "{empty}";
        }
        StringBuffer stringBuffer = new StringBuffer("{ ");
        stringBuffer.append(b() + " ");
        stringBuffer.append(e() + " ");
        stringBuffer.append(a(a(true, false)));
        if (this.f8986b > 0) {
            stringBuffer.append(" sigs: ");
            stringBuffer.append(a(a(false, false)));
        }
        stringBuffer.append(" }");
        return stringBuffer.toString();
    }

    public h(i iVar) {
        this();
        b(iVar);
    }

    private void b(i iVar) {
        if (this.f8986b == 0) {
            this.f8985a.add(iVar);
        } else {
            List list = this.f8985a;
            list.add(list.size() - this.f8986b, iVar);
        }
    }

    public synchronized Iterator a() {
        return a(true, true);
    }

    private synchronized Iterator a(boolean z8, boolean z9) {
        int i9;
        List listSubList;
        try {
            int size = this.f8985a.size();
            int i10 = z8 ? size - this.f8986b : this.f8986b;
            if (i10 == 0) {
                return Collections.EMPTY_LIST.iterator();
            }
            if (!z8) {
                i9 = size - this.f8986b;
            } else if (z9) {
                if (this.f8987c >= i10) {
                    this.f8987c = (short) 0;
                }
                i9 = this.f8987c;
                this.f8987c = (short) (i9 + 1);
            } else {
                i9 = 0;
            }
            ArrayList arrayList = new ArrayList(i10);
            if (z8) {
                arrayList.addAll(this.f8985a.subList(i9, i10));
                if (i9 != 0) {
                    listSubList = this.f8985a.subList(0, i9);
                }
                return arrayList.iterator();
            }
            listSubList = this.f8985a.subList(i9, size);
            arrayList.addAll(listSubList);
            return arrayList.iterator();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(i iVar) {
        if (this.f8985a.size() == 0) {
            b(iVar);
            return;
        }
        i iVarF = f();
        if (!iVar.a(iVarF)) {
            throw new IllegalArgumentException("record does not match rrset");
        }
        if (iVar.h() != iVarF.h()) {
            if (iVar.h() > iVarF.h()) {
                iVar = iVar.i();
                iVar.a(iVarF.h());
            } else {
                for (int i9 = 0; i9 < this.f8985a.size(); i9++) {
                    i iVarI = ((i) this.f8985a.get(i9)).i();
                    iVarI.a(iVar.h());
                    this.f8985a.set(i9, iVarI);
                }
            }
        }
        if (!this.f8985a.contains(iVar)) {
            b(iVar);
        }
    }
}
