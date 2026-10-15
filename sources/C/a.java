package C;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintLayoutStates.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f1762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1763b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1764c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<C0008a> f1765d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArray<androidx.constraintlayout.widget.b> f1766e = new SparseArray<>();

    /* JADX INFO: renamed from: C.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConstraintLayoutStates.java */
    public static class C0008a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<b> f1768b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1769c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.constraintlayout.widget.b f1770d;

        public C0008a(Context context, XmlResourceParser xmlResourceParser) {
            this.f1769c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), d.f1785i);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == 0) {
                    this.f1767a = typedArrayObtainStyledAttributes.getResourceId(index, this.f1767a);
                } else if (index == 1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1769c);
                    this.f1769c = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        this.f1770d = bVar;
                        bVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: ConstraintLayoutStates.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f1771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f1772b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f1773c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f1774d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1775e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final androidx.constraintlayout.widget.b f1776f;

        public b(Context context, XmlResourceParser xmlResourceParser) {
            this.f1771a = Float.NaN;
            this.f1772b = Float.NaN;
            this.f1773c = Float.NaN;
            this.f1774d = Float.NaN;
            this.f1775e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), d.f1786k);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == 0) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1775e);
                    this.f1775e = resourceId;
                    String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                    context.getResources().getResourceName(resourceId);
                    if ("layout".equals(resourceTypeName)) {
                        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                        this.f1776f = bVar;
                        bVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                    }
                } else if (index == 1) {
                    this.f1774d = typedArrayObtainStyledAttributes.getDimension(index, this.f1774d);
                } else if (index == 2) {
                    this.f1772b = typedArrayObtainStyledAttributes.getDimension(index, this.f1772b);
                } else if (index == 3) {
                    this.f1773c = typedArrayObtainStyledAttributes.getDimension(index, this.f1773c);
                } else if (index == 4) {
                    this.f1771a = typedArrayObtainStyledAttributes.getDimension(index, this.f1771a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public final boolean a(float f6, float f9) {
            float f10 = this.f1771a;
            if (!Float.isNaN(f10) && f6 < f10) {
                return false;
            }
            float f11 = this.f1772b;
            if (!Float.isNaN(f11) && f9 < f11) {
                return false;
            }
            float f12 = this.f1773c;
            if (!Float.isNaN(f12) && f6 > f12) {
                return false;
            }
            float f13 = this.f1774d;
            return Float.isNaN(f13) || f9 <= f13;
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0075  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public a(Context context, ConstraintLayout constraintLayout, int i9) {
        byte b9;
        this.f1762a = constraintLayout;
        XmlResourceParser xml = context.getResources().getXml(i9);
        try {
            C0008a c0008a = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                b9 = 4;
                            } else {
                                b9 = -1;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                b9 = 2;
                            } else {
                                b9 = -1;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                b9 = 1;
                            } else {
                                b9 = -1;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                b9 = 0;
                            } else {
                                b9 = -1;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b9 = 3;
                            } else {
                                b9 = -1;
                            }
                            break;
                        default:
                            b9 = -1;
                            break;
                    }
                    if (b9 != 0 && b9 != 1) {
                        if (b9 == 2) {
                            c0008a = new C0008a(context, xml);
                            this.f1765d.put(c0008a.f1767a, c0008a);
                        } else if (b9 == 3) {
                            b bVar = new b(context, xml);
                            if (c0008a != null) {
                                c0008a.f1768b.add(bVar);
                            }
                        } else if (b9 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            a(context, xml);
                        }
                    }
                }
            }
        } catch (IOException e9) {
            e9.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00ed  */
    public final void a(Context context, XmlResourceParser xmlResourceParser) {
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        int attributeCount = xmlResourceParser.getAttributeCount();
        for (int i9 = 0; i9 < attributeCount; i9++) {
            if ("id".equals(xmlResourceParser.getAttributeName(i9))) {
                String attributeValue = xmlResourceParser.getAttributeValue(i9);
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                try {
                    int eventType = xmlResourceParser.getEventType();
                    androidx.constraintlayout.widget.b.a aVarD = null;
                    while (eventType != 1) {
                        if (eventType == 0) {
                            xmlResourceParser.getName();
                        } else if (eventType == 2) {
                            switch (xmlResourceParser.getName()) {
                                case "Constraint":
                                    aVarD = androidx.constraintlayout.widget.b.d(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                case "Guideline":
                                    aVarD = androidx.constraintlayout.widget.b.d(context, Xml.asAttributeSet(xmlResourceParser));
                                    aVarD.f6930d.f6959a = true;
                                    break;
                                case "Barrier":
                                    aVarD = androidx.constraintlayout.widget.b.d(context, Xml.asAttributeSet(xmlResourceParser));
                                    aVarD.f6930d.f6963c0 = 1;
                                    break;
                                case "PropertySet":
                                    if (aVarD == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                    aVarD.f6928b.a(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                    break;
                                case "Transform":
                                    if (aVarD == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                    aVarD.f6931e.a(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                    break;
                                case "Layout":
                                    if (aVarD == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                    aVarD.f6930d.a(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                    break;
                                case "Motion":
                                    if (aVarD == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                    aVarD.f6929c.a(context, Xml.asAttributeSet(xmlResourceParser));
                                    break;
                                    break;
                                case "CustomAttribute":
                                    if (aVarD == null) {
                                        throw new RuntimeException("XML parser error must be within a Constraint " + xmlResourceParser.getLineNumber());
                                    }
                                    androidx.constraintlayout.widget.a.a(context, xmlResourceParser, aVarD.f6932f);
                                    break;
                                    break;
                            }
                        } else if (eventType != 3) {
                            continue;
                        } else {
                            String name = xmlResourceParser.getName();
                            if ("ConstraintSet".equals(name)) {
                                this.f1766e.put(identifier, bVar);
                                return;
                            } else if (name.equalsIgnoreCase("Constraint")) {
                                bVar.f6926c.put(Integer.valueOf(aVarD.f6927a), aVarD);
                                aVarD = null;
                            }
                        }
                        eventType = xmlResourceParser.next();
                    }
                } catch (IOException e9) {
                    e9.printStackTrace();
                } catch (XmlPullParserException e10) {
                    e10.printStackTrace();
                }
                this.f1766e.put(identifier, bVar);
                return;
            }
        }
    }
}
