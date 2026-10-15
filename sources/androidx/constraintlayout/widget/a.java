package androidx.constraintlayout.widget;

import C.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;

/* JADX INFO: compiled from: ConstraintAttribute.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EnumC0097a f6908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f6910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6913f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintAttribute.java */
    public static final class EnumC0097a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0097a f6914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0097a f6915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0097a f6916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final EnumC0097a f6917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EnumC0097a f6918e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final EnumC0097a f6919f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final EnumC0097a f6920g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ EnumC0097a[] f6921h;

        static {
            EnumC0097a enumC0097a = new EnumC0097a("INT_TYPE", 0);
            f6914a = enumC0097a;
            EnumC0097a enumC0097a2 = new EnumC0097a("FLOAT_TYPE", 1);
            f6915b = enumC0097a2;
            EnumC0097a enumC0097a3 = new EnumC0097a("COLOR_TYPE", 2);
            f6916c = enumC0097a3;
            EnumC0097a enumC0097a4 = new EnumC0097a("COLOR_DRAWABLE_TYPE", 3);
            f6917d = enumC0097a4;
            EnumC0097a enumC0097a5 = new EnumC0097a("STRING_TYPE", 4);
            f6918e = enumC0097a5;
            EnumC0097a enumC0097a6 = new EnumC0097a("BOOLEAN_TYPE", 5);
            f6919f = enumC0097a6;
            EnumC0097a enumC0097a7 = new EnumC0097a("DIMENSION_TYPE", 6);
            f6920g = enumC0097a7;
            f6921h = new EnumC0097a[]{enumC0097a, enumC0097a2, enumC0097a3, enumC0097a4, enumC0097a5, enumC0097a6, enumC0097a7};
        }

        public EnumC0097a() {
            throw null;
        }

        public static EnumC0097a valueOf(String str) {
            return (EnumC0097a) Enum.valueOf(EnumC0097a.class, str);
        }

        public static EnumC0097a[] values() {
            return (EnumC0097a[]) f6921h.clone();
        }
    }

    public a(a aVar, Object obj) {
        aVar.getClass();
        this.f6908a = aVar.f6908a;
        b(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        EnumC0097a enumC0097a;
        Object string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), d.f1780d);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string2 = null;
        Object objValueOf = null;
        EnumC0097a enumC0097a2 = null;
        for (int i9 = 0; i9 < indexCount; i9++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i9);
            if (index == 0) {
                string2 = typedArrayObtainStyledAttributes.getString(index);
                if (string2 != null && string2.length() > 0) {
                    string2 = Character.toUpperCase(string2.charAt(0)) + string2.substring(1);
                }
            } else if (index == 1) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                enumC0097a2 = EnumC0097a.f6919f;
            } else {
                if (index == 3) {
                    enumC0097a = EnumC0097a.f6916c;
                    string = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == 2) {
                    enumC0097a = EnumC0097a.f6917d;
                    string = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else {
                    EnumC0097a enumC0097a3 = EnumC0097a.f6920g;
                    if (index == 7) {
                        objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                    } else if (index == 4) {
                        objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                    } else if (index == 5) {
                        enumC0097a = EnumC0097a.f6915b;
                        string = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                    } else if (index == 6) {
                        enumC0097a = EnumC0097a.f6914a;
                        string = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                    } else if (index == 8) {
                        enumC0097a = EnumC0097a.f6918e;
                        string = typedArrayObtainStyledAttributes.getString(index);
                    }
                    enumC0097a2 = enumC0097a3;
                }
                Object obj = string;
                enumC0097a2 = enumC0097a;
                objValueOf = obj;
            }
        }
        if (string2 != null && objValueOf != null) {
            a aVar = new a();
            aVar.f6908a = enumC0097a2;
            aVar.b(objValueOf);
            map.put(string2, aVar);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b(Object obj) {
        switch (this.f6908a.ordinal()) {
            case 0:
                this.f6909b = ((Integer) obj).intValue();
                break;
            case 1:
                this.f6910c = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.f6913f = ((Integer) obj).intValue();
                break;
            case 4:
                this.f6911d = (String) obj;
                break;
            case 5:
                this.f6912e = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.f6910c = ((Float) obj).floatValue();
                break;
        }
    }
}
