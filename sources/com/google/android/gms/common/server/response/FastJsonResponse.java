package com.google.android.gms.common.server.response;

import S4.C0375f;
import S4.C0376g;
import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p011b4.h;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FastJsonResponse {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.3.0 */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final a CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f12581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f12582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f12583e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f12584f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f12585g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Class f12586h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f12587i;
        public zan j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final StringToIntConverter f12588k;

        public Field(int i9, int i10, boolean z8, int i11, boolean z9, String str, int i12, String str2, zaa zaaVar) {
            this.f12579a = i9;
            this.f12580b = i10;
            this.f12581c = z8;
            this.f12582d = i11;
            this.f12583e = z9;
            this.f12584f = str;
            this.f12585g = i12;
            if (str2 == null) {
                this.f12586h = null;
                this.f12587i = null;
            } else {
                this.f12586h = SafeParcelResponse.class;
                this.f12587i = str2;
            }
            if (zaaVar == null) {
                this.f12588k = null;
                return;
            }
            StringToIntConverter stringToIntConverter = zaaVar.f12575b;
            if (stringToIntConverter == null) {
                throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
            }
            this.f12588k = stringToIntConverter;
        }

        public final String toString() {
            C0375f.a aVar = new C0375f.a(this);
            aVar.a(Integer.valueOf(this.f12579a), "versionCode");
            aVar.a(Integer.valueOf(this.f12580b), "typeIn");
            aVar.a(Boolean.valueOf(this.f12581c), "typeInArray");
            aVar.a(Integer.valueOf(this.f12582d), "typeOut");
            aVar.a(Boolean.valueOf(this.f12583e), "typeOutArray");
            aVar.a(this.f12584f, "outputFieldName");
            aVar.a(Integer.valueOf(this.f12585g), "safeParcelFieldId");
            String str = this.f12587i;
            if (str == null) {
                str = null;
            }
            aVar.a(str, "concreteTypeName");
            Class cls = this.f12586h;
            if (cls != null) {
                aVar.a(cls.getCanonicalName(), "concreteType.class");
            }
            if (this.f12588k != null) {
                aVar.a(StringToIntConverter.class.getCanonicalName(), "converterName");
            }
            return aVar.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            int iU = p199z2.b.U(parcel, 20293);
            p199z2.b.W(parcel, 1, 4);
            parcel.writeInt(this.f12579a);
            p199z2.b.W(parcel, 2, 4);
            parcel.writeInt(this.f12580b);
            p199z2.b.W(parcel, 3, 4);
            parcel.writeInt(this.f12581c ? 1 : 0);
            p199z2.b.W(parcel, 4, 4);
            parcel.writeInt(this.f12582d);
            p199z2.b.W(parcel, 5, 4);
            parcel.writeInt(this.f12583e ? 1 : 0);
            p199z2.b.Q(parcel, 6, this.f12584f);
            p199z2.b.W(parcel, 7, 4);
            parcel.writeInt(this.f12585g);
            String str = this.f12587i;
            if (str == null) {
                str = null;
            }
            p199z2.b.Q(parcel, 8, str);
            StringToIntConverter stringToIntConverter = this.f12588k;
            p199z2.b.P(parcel, 9, stringToIntConverter != null ? new zaa(stringToIntConverter) : null, i9);
            p199z2.b.V(parcel, iU);
        }
    }

    public static final Object j(Field field, Object obj) {
        StringToIntConverter stringToIntConverter = field.f12588k;
        if (stringToIntConverter != null) {
            obj = (String) stringToIntConverter.f12573c.get(((Integer) obj).intValue());
            if (obj == null && stringToIntConverter.f12572b.containsKey("gms_unknown")) {
                return "gms_unknown";
            }
        }
        return obj;
    }

    public static final void k(StringBuilder sb, Field field, Object obj) {
        int i9 = field.f12580b;
        if (i9 == 11) {
            Class cls = field.f12586h;
            C0376g.e(cls);
            sb.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i9 != 7) {
                sb.append(obj);
                return;
            }
            sb.append("\"");
            sb.append(b5.b.a((String) obj));
            sb.append("\"");
        }
    }

    public abstract Map<String, Field<?, ?>> a();

    public final Object b(Field field) {
        if (field.f12586h == null) {
            return c();
        }
        Object objC = c();
        String str = field.f12584f;
        if (objC != null) {
            throw new IllegalStateException("Concrete field shouldn't be value object: " + str);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e9) {
            throw new RuntimeException(e9);
        }
    }

    public abstract Object c();

    public final boolean d(Field field) {
        if (field.f12582d != 11) {
            return e();
        }
        if (field.f12583e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public abstract boolean e();

    public String toString() {
        Map<String, Field<?, ?>> mapA = a();
        StringBuilder sb = new StringBuilder(100);
        for (String str : mapA.keySet()) {
            Field<?, ?> field = mapA.get(str);
            if (d(field)) {
                Object objJ = j(field, b(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append("\"");
                sb.append(str);
                sb.append("\":");
                if (objJ != null) {
                    switch (field.f12582d) {
                        case 8:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objJ, 0));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(Base64.encodeToString((byte[]) objJ, 10));
                            sb.append("\"");
                            break;
                        case 10:
                            h.H(sb, (HashMap) objJ);
                            break;
                        default:
                            if (field.f12581c) {
                                ArrayList arrayList = (ArrayList) objJ;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i9 = 0; i9 < size; i9++) {
                                    if (i9 > 0) {
                                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                    }
                                    Object obj = arrayList.get(i9);
                                    if (obj != null) {
                                        k(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                            } else {
                                k(sb, field, objJ);
                            }
                            break;
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
