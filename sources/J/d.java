package J;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ComplexColorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Shader f2607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f2608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2609c;

    public d(Shader shader, ColorStateList colorStateList, int i9) {
        this.f2607a = shader;
        this.f2608b = colorStateList;
        this.f2609c = i9;
    }

    public static d a(Resources resources, int i9, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        float f6;
        float f9;
        Shader.TileMode tileMode;
        Shader radialGradient;
        Shader.TileMode tileMode2;
        XmlResourceParser xml = resources.getXml(i9);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        if (!name.equals("gradient")) {
            if (name.equals("selector")) {
                ColorStateList colorStateListB = c.b(resources, xml, attributeSetAsAttributeSet, theme);
                return new d(null, colorStateListB, colorStateListB.getDefaultColor());
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        String name2 = xml.getName();
        if (!name2.equals("gradient")) {
            throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
        }
        TypedArray typedArrayD = k.d(resources, theme, attributeSetAsAttributeSet, F.a.f2014e);
        float f10 = !(xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startX") != null) ? 0.0f : typedArrayD.getFloat(8, 0.0f);
        float f11 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startY") != null ? typedArrayD.getFloat(9, 0.0f) : 0.0f;
        float f12 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endX") != null ? typedArrayD.getFloat(10, 0.0f) : 0.0f;
        float f13 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endY") != null ? typedArrayD.getFloat(11, 0.0f) : 0.0f;
        float f14 = !(xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerX") != null) ? 0.0f : typedArrayD.getFloat(3, 0.0f);
        float f15 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerY") != null ? typedArrayD.getFloat(4, 0.0f) : 0.0f;
        int i10 = !(xml.getAttributeValue("http://schemas.android.com/apk/res/android", "type") != null) ? 0 : typedArrayD.getInt(2, 0);
        int color = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startColor") != null ? typedArrayD.getColor(0, 0) : 0;
        boolean z8 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null;
        int color2 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null ? typedArrayD.getColor(7, 0) : 0;
        int color3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endColor") != null ? typedArrayD.getColor(1, 0) : 0;
        int i11 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "tileMode") != null ? typedArrayD.getInt(6, 0) : 0;
        float f16 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "gradientRadius") != null ? typedArrayD.getFloat(5, 0.0f) : 0.0f;
        typedArrayD.recycle();
        int depth = xml.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        float f17 = f16;
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next2 = xml.next();
            f6 = f11;
            if (next2 == 1) {
                f9 = f12;
                break;
            }
            int depth2 = xml.getDepth();
            f9 = f12;
            if (depth2 < depth && next2 == 3) {
                break;
            }
            if (next2 == 2 && depth2 <= depth && xml.getName().equals("item")) {
                TypedArray typedArrayD2 = k.d(resources, theme, attributeSetAsAttributeSet, F.a.f2015f);
                boolean zHasValue = typedArrayD2.hasValue(0);
                boolean zHasValue2 = typedArrayD2.hasValue(1);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xml.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color4 = typedArrayD2.getColor(0, 0);
                float f18 = typedArrayD2.getFloat(1, 0.0f);
                typedArrayD2.recycle();
                arrayList2.add(Integer.valueOf(color4));
                arrayList.add(Float.valueOf(f18));
            }
            f11 = f6;
            f12 = f9;
        }
        f fVar = arrayList2.size() > 0 ? new f(arrayList2, arrayList) : null;
        if (fVar == null) {
            fVar = z8 ? new f(color, color2, color3) : new f(color, color3);
        }
        if (i10 != 1) {
            if (i10 != 2) {
                if (i11 != 1) {
                    tileMode2 = i11 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
                } else {
                    tileMode2 = Shader.TileMode.REPEAT;
                }
                radialGradient = new LinearGradient(f10, f6, f9, f13, (int[]) fVar.f2621a, (float[]) fVar.f2622b, tileMode2);
            } else {
                radialGradient = new SweepGradient(f14, f15, (int[]) fVar.f2621a, (float[]) fVar.f2622b);
            }
        } else {
            if (f17 <= 0.0f) {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
            if (i11 != 1) {
                tileMode = i11 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
            } else {
                tileMode = Shader.TileMode.REPEAT;
            }
            radialGradient = new RadialGradient(f14, f15, f17, (int[]) fVar.f2621a, (float[]) fVar.f2622b, tileMode);
        }
        return new d(radialGradient, null, 0);
    }

    public final boolean b() {
        ColorStateList colorStateList;
        return this.f2607a == null && (colorStateList = this.f2608b) != null && colorStateList.isStateful();
    }
}
