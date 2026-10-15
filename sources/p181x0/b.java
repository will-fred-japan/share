package p181x0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
import p155u.a;

/* JADX INFO: compiled from: VersionedParcelParcel.java */
/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseIntArray f22266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Parcel f22267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f22268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f22269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f22270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22271i;
    public int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22272k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    @Override // p181x0.a
    public final b a() {
        Parcel parcel = this.f22267e;
        int iDataPosition = parcel.dataPosition();
        int i9 = this.j;
        if (i9 == this.f22268f) {
            i9 = this.f22269g;
        }
        return new b(parcel, iDataPosition, i9, A.a.j(new StringBuilder(), this.f22270h, "  "), this.f22263a, this.f22264b, this.f22265c);
    }

    @Override // p181x0.a
    public final boolean e() {
        return this.f22267e.readInt() != 0;
    }

    @Override // p181x0.a
    public final byte[] f() {
        Parcel parcel = this.f22267e;
        int i9 = parcel.readInt();
        if (i9 < 0) {
            return null;
        }
        byte[] bArr = new byte[i9];
        parcel.readByteArray(bArr);
        return bArr;
    }

    @Override // p181x0.a
    public final CharSequence g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f22267e);
    }

    @Override // p181x0.a
    public final boolean h(int i9) {
        while (this.j < this.f22269g) {
            int i10 = this.f22272k;
            if (i10 == i9) {
                return true;
            }
            if (String.valueOf(i10).compareTo(String.valueOf(i9)) > 0) {
                return false;
            }
            int i11 = this.j;
            Parcel parcel = this.f22267e;
            parcel.setDataPosition(i11);
            int i12 = parcel.readInt();
            this.f22272k = parcel.readInt();
            this.j += i12;
        }
        return this.f22272k == i9;
    }

    @Override // p181x0.a
    public final int i() {
        return this.f22267e.readInt();
    }

    @Override // p181x0.a
    public final <T extends Parcelable> T k() {
        return (T) this.f22267e.readParcelable(b.class.getClassLoader());
    }

    @Override // p181x0.a
    public final String l() {
        return this.f22267e.readString();
    }

    @Override // p181x0.a
    public final void n(int i9) {
        w();
        this.f22271i = i9;
        this.f22266d.put(i9, this.f22267e.dataPosition());
        r(0);
        r(i9);
    }

    @Override // p181x0.a
    public final void o(boolean z8) {
        this.f22267e.writeInt(z8 ? 1 : 0);
    }

    @Override // p181x0.a
    public final void p(byte[] bArr) {
        Parcel parcel = this.f22267e;
        if (bArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
    }

    @Override // p181x0.a
    public final void q(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f22267e, 0);
    }

    @Override // p181x0.a
    public final void r(int i9) {
        this.f22267e.writeInt(i9);
    }

    @Override // p181x0.a
    public final void t(Parcelable parcelable) {
        this.f22267e.writeParcelable(parcelable, 0);
    }

    @Override // p181x0.a
    public final void u(String str) {
        this.f22267e.writeString(str);
    }

    public final void w() {
        int i9 = this.f22271i;
        if (i9 >= 0) {
            int i10 = this.f22266d.get(i9);
            Parcel parcel = this.f22267e;
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i10);
            parcel.writeInt(iDataPosition - i10);
            parcel.setDataPosition(iDataPosition);
        }
    }

    public b(Parcel parcel, int i9, int i10, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f22266d = new SparseIntArray();
        this.f22271i = -1;
        this.f22272k = -1;
        this.f22267e = parcel;
        this.f22268f = i9;
        this.f22269g = i10;
        this.j = i9;
        this.f22270h = str;
    }
}
