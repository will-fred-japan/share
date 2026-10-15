package J;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Base64;
import android.util.Xml;
import com.huawei.agconnect.exception.AGCServerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: FontResourcesParserCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public interface a {
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c[] f2610a;

        public b(c[] cVarArr) {
            this.f2610a = cVarArr;
        }
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f2614d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2615e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f2616f;

        public c(int i9, int i10, int i11, String str, String str2, boolean z8) {
            this.f2611a = str;
            this.f2612b = i9;
            this.f2613c = z8;
            this.f2614d = str2;
            this.f2615e = i10;
            this.f2616f = i11;
        }
    }

    /* JADX INFO: compiled from: FontResourcesParserCompat.java */
    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f2617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f2620d;

        public d(ArrayList arrayList, int i9, int i10, String str) {
            this.f2617a = arrayList;
            this.f2619c = i9;
            this.f2618b = i10;
            this.f2620d = str;
        }
    }

    public static a a(XmlResourceParser xmlResourceParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        int i9;
        do {
            next = xmlResourceParser.next();
            i9 = 2;
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (!xmlResourceParser.getName().equals("font-family")) {
            c(xmlResourceParser);
            return null;
        }
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), F.a.f2011b);
        int i10 = 0;
        String string = typedArrayObtainAttributes.getString(0);
        String string2 = typedArrayObtainAttributes.getString(5);
        String string3 = typedArrayObtainAttributes.getString(6);
        String string4 = typedArrayObtainAttributes.getString(2);
        int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
        int i11 = 3;
        int integer = typedArrayObtainAttributes.getInteger(3, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(4, 500);
        String string5 = typedArrayObtainAttributes.getString(7);
        typedArrayObtainAttributes.recycle();
        if (string == null || string2 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlResourceParser.next() != 3) {
                if (xmlResourceParser.getEventType() == 2) {
                    if (xmlResourceParser.getName().equals("font")) {
                        TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), F.a.f2012c);
                        int i12 = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(8) ? 8 : 1, AGCServerException.AUTHENTICATION_INVALID);
                        boolean z8 = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(6) ? 6 : 2, 0);
                        int i13 = typedArrayObtainAttributes2.hasValue(9) ? 9 : 3;
                        String string6 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(7) ? 7 : 4);
                        int i14 = typedArrayObtainAttributes2.getInt(i13, 0);
                        int i15 = typedArrayObtainAttributes2.hasValue(5) ? 5 : 0;
                        int resourceId2 = typedArrayObtainAttributes2.getResourceId(i15, 0);
                        String string7 = typedArrayObtainAttributes2.getString(i15);
                        typedArrayObtainAttributes2.recycle();
                        while (xmlResourceParser.next() != 3) {
                            c(xmlResourceParser);
                        }
                        arrayList.add(new c(i12, i14, resourceId2, string7, string6, z8));
                    } else {
                        c(xmlResourceParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((c[]) arrayList.toArray(new c[0]));
        }
        List<List<byte[]>> listB = b(resources, resourceId);
        ArrayList arrayList2 = new ArrayList();
        while (xmlResourceParser.next() != i11) {
            if (xmlResourceParser.getEventType() == i9) {
                if (xmlResourceParser.getName().equals("fallback")) {
                    TypedArray typedArrayObtainAttributes3 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), F.a.f2013d);
                    try {
                        String string8 = typedArrayObtainAttributes3.getString(i10);
                        String string9 = typedArrayObtainAttributes3.getString(1);
                        String string10 = typedArrayObtainAttributes3.getString(i9);
                        if (string8 == null) {
                            throw new XmlPullParserException("query attribute must be set in fallback element");
                        }
                        while (xmlResourceParser.next() != i11) {
                            c(xmlResourceParser);
                        }
                        Q.f fVar = new Q.f(string, string2, string8, listB, string9, string10);
                        typedArrayObtainAttributes3.recycle();
                        arrayList2.add(fVar);
                    } catch (Throwable th) {
                        if (typedArrayObtainAttributes3 == null) {
                            throw th;
                        }
                        try {
                            typedArrayObtainAttributes3.recycle();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } else {
                    c(xmlResourceParser);
                }
                integer2 = integer2;
                integer = integer;
                i9 = 2;
                i10 = 0;
                i11 = 3;
            }
        }
        int i16 = integer2;
        int i17 = integer;
        if (!arrayList2.isEmpty()) {
            return new d(arrayList2, i17, i16, string5);
        }
        if (string3 == null) {
            throw new IllegalArgumentException("The provider font XML requires query attribute or fallback children.");
        }
        arrayList2.add(new Q.f(string, string2, string3, listB, null, null));
        if (string4 != null) {
            arrayList2.add(new Q.f(string, string2, string4, listB, null, null));
        }
        return new d(arrayList2, i17, i16, string5);
    }

    public static List<List<byte[]>> b(Resources resources, int i9) {
        if (i9 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i9);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i10 = 0; i10 < typedArrayObtainTypedArray.length(); i10++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i10, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i9);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static void c(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int i9 = 1;
        while (i9 > 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i9++;
            } else if (next == 3) {
                i9--;
            }
        }
    }
}
