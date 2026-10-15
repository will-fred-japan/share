package J;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import cn.ikaile.ruoshui.client.R;
import java.io.IOException;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ColorStateListInflaterCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f2606a = new ThreadLocal<>();

    public static ColorStateList a(Resources resources, XmlResourceParser xmlResourceParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlResourceParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0092  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r36v0, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.content.res.TypedArray] */
    public static ColorStateList b(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int color;
        float f6;
        int iA;
        TypedValue typedValue;
        resources = resources;
        attributeSet = attributeSet;
        theme = theme;
        String name = xmlResourceParser.getName();
        if (!name.equals("selector")) {
            throw new XmlPullParserException(xmlResourceParser.getPositionDescription() + ": invalid color state list tag " + name);
        }
        ?? r8 = 1;
        int depth2 = xmlResourceParser.getDepth() + 1;
        Object[] objArr = new int[20][];
        int[] iArr = new int[20];
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == r8 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlResourceParser.getName().equals("item")) {
                int[] iArr2 = F.a.f2010a;
                ?? ObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr2) : theme.obtainStyledAttributes(attributeSet, iArr2, i9, i9);
                int resourceId = ObtainAttributes.getResourceId(i9, -1);
                if (resourceId == -1) {
                    color = ObtainAttributes.getColor(i9, -65281);
                } else {
                    ThreadLocal<TypedValue> threadLocal = f2606a;
                    TypedValue typedValue2 = threadLocal.get();
                    if (typedValue2 == null) {
                        typedValue = new TypedValue();
                        threadLocal.set(typedValue);
                    } else {
                        typedValue = typedValue2;
                    }
                    resources.getValue(resourceId, typedValue, r8);
                    int i11 = typedValue.type;
                    if (i11 < 28 || i11 > 31) {
                        try {
                            color = a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                        } catch (Exception unused) {
                            color = ObtainAttributes.getColor(i9, -65281);
                        }
                    } else {
                        color = ObtainAttributes.getColor(i9, -65281);
                    }
                }
                if (ObtainAttributes.hasValue(r8)) {
                    f6 = ObtainAttributes.getFloat(r8, 1.0f);
                } else {
                    f6 = ObtainAttributes.hasValue(3) ? ObtainAttributes.getFloat(3, 1.0f) : 1.0f;
                }
                ?? r16 = r8;
                float f9 = (Build.VERSION.SDK_INT < 31 || !ObtainAttributes.hasValue(2)) ? ObtainAttributes.getFloat(4, -1.0f) : ObtainAttributes.getFloat(2, -1.0f);
                ObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i12 = i9;
                int i13 = i12;
                while (i12 < attributeCount) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i12);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha && attributeNameResource != R.attr.lStar) {
                        int i14 = i13 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i12, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i13] = attributeNameResource;
                        i13 = i14;
                    }
                    i12++;
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr3, i13);
                float f10 = 100.0f;
                boolean z8 = (f9 < 0.0f || f9 > 100.0f) ? false : r16 == true ? 1 : 0;
                if (f6 != 1.0f || z8) {
                    int iN = p027d5.a.n((int) ((Color.alpha(color) * f6) + 0.5f), 0, 255);
                    if (z8) {
                        a aVarA = a.a(color);
                        l lVar = l.f2636k;
                        float f11 = aVarA.f2597b;
                        if (f11 >= 1.0d && Math.round(f9) > 0.0d && Math.round(f9) < 100.0d) {
                            float f12 = aVarA.f2596a;
                            float fMin = f12 < 0.0f ? 0.0f : Math.min(360.0f, f12);
                            float f13 = 0.0f;
                            float f14 = f11;
                            boolean z9 = r16 == true ? 1 : 0;
                            a aVar = null;
                            while (true) {
                                if (Math.abs(f13 - f11) < 0.4f) {
                                    iArrTrimStateSet = iArrTrimStateSet;
                                    depth2 = depth2;
                                    if (aVar != null) {
                                        iA = aVar.c(lVar);
                                        break;
                                    }
                                    iA = b.a(f9);
                                    break;
                                }
                                float f15 = 1000.0f;
                                float f16 = f10;
                                float f17 = 0.0f;
                                float f18 = 1000.0f;
                                a aVar2 = null;
                                while (true) {
                                    if (Math.abs(f17 - f16) <= 0.01f) {
                                        iArrTrimStateSet = iArrTrimStateSet;
                                        depth2 = depth2;
                                        f10 = f10;
                                        break;
                                    }
                                    f10 = f10;
                                    float f19 = ((f16 - f17) / 2.0f) + f17;
                                    iArrTrimStateSet = iArrTrimStateSet;
                                    int iC = a.b(f19, f14, fMin).c(l.f2636k);
                                    float fB = b.b(Color.red(iC));
                                    float fB2 = b.b(Color.green(iC));
                                    float fB3 = b.b(Color.blue(iC));
                                    float[] fArr = b.f2605d[r16 == true ? 1 : 0];
                                    float f20 = ((fB3 * fArr[2]) + ((fB2 * fArr[r16 == true ? 1 : 0]) + (fB * fArr[0]))) / f10;
                                    float fCbrt = f20 <= 0.008856452f ? f20 * 903.2963f : (((float) Math.cbrt(f20)) * 116.0f) - 16.0f;
                                    float fAbs = Math.abs(f9 - fCbrt);
                                    if (fAbs < 0.2f) {
                                        a aVarA2 = a.a(iC);
                                        a aVarB = a.b(aVarA2.f2598c, aVarA2.f2597b, fMin);
                                        float f21 = aVarA2.f2599d - aVarB.f2599d;
                                        float f22 = aVarA2.f2600e - aVarB.f2600e;
                                        float f23 = aVarA2.f2601f - aVarB.f2601f;
                                        depth2 = depth2;
                                        float fPow = (float) (Math.pow(Math.sqrt((f23 * f23) + (f22 * f22) + (f21 * f21)), 0.63d) * 1.41d);
                                        if (fPow <= 1.0f) {
                                            f18 = fPow;
                                            f15 = fAbs;
                                            aVar2 = aVarA2;
                                        }
                                    } else {
                                        depth2 = depth2;
                                    }
                                    if (f15 == 0.0f && f18 == 0.0f) {
                                        break;
                                    }
                                    if (fCbrt < f9) {
                                        f17 = f19;
                                    } else {
                                        f16 = f19;
                                    }
                                    f10 = f10;
                                    iArrTrimStateSet = iArrTrimStateSet;
                                    depth2 = depth2;
                                }
                                a aVar3 = aVar2;
                                if (!z9) {
                                    if (aVar3 == null) {
                                        f11 = f14;
                                    } else {
                                        aVar = aVar3;
                                        f13 = f14;
                                    }
                                    f14 = ((f11 - f13) / 2.0f) + f13;
                                } else {
                                    if (aVar3 != null) {
                                        iA = aVar3.c(lVar);
                                        break;
                                    }
                                    f14 = ((f11 - f13) / 2.0f) + f13;
                                    z9 = false;
                                }
                            }
                        } else {
                            iArrTrimStateSet = iArrTrimStateSet;
                            depth2 = depth2;
                            iA = b.a(f9);
                        }
                        color = iA;
                    } else {
                        iArrTrimStateSet = iArrTrimStateSet;
                        depth2 = depth2;
                    }
                    color = (16777215 & color) | (iN << 24);
                } else {
                    iArrTrimStateSet = iArrTrimStateSet;
                    depth2 = depth2;
                }
                int i15 = i10 + 1;
                if (i15 > iArr.length) {
                    int[] iArr4 = new int[i10 <= 4 ? 8 : i10 * 2];
                    System.arraycopy(iArr, 0, iArr4, 0, i10);
                    iArr = iArr4;
                }
                iArr[i10] = color;
                if (i15 > objArr.length) {
                    Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i10 > 4 ? i10 * 2 : 8);
                    System.arraycopy(objArr, 0, objArr2, 0, i10);
                    objArr = objArr2;
                }
                objArr[i10] = iArrTrimStateSet;
                objArr = (int[][]) objArr;
                i10 = i15;
                r8 = r16 == true ? 1 : 0;
                depth2 = depth2;
                i9 = 0;
            } else {
                int i16 = depth2;
                r8 = r8 == true ? 1 : 0;
                depth2 = i16;
                i9 = 0;
            }
        }
        int[] iArr5 = new int[i10];
        int[][] iArr6 = new int[i10][];
        System.arraycopy(iArr, 0, iArr5, 0, i10);
        System.arraycopy(objArr, 0, iArr6, 0, i10);
        return new ColorStateList(iArr6, iArr5);
    }
}
