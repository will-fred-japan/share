package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes2.dex */
public class hk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static hk f17644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, Object> f556a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Object> f17645b = new ConcurrentHashMap();

    private hk() throws Throwable {
        m471a();
    }

    public static synchronized hk a() {
        try {
            if (f17644a == null) {
                f17644a = new hk();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f17644a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m471a() throws Throwable {
        InputStream inputStreamOpenStream;
        try {
            for (ClassLoader classLoader : m469a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    try {
                        inputStreamOpenStream = resources.nextElement().openStream();
                        try {
                            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            xmlPullParserNewPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            xmlPullParserNewPullParser.setInput(inputStreamOpenStream, "UTF-8");
                            int eventType = xmlPullParserNewPullParser.getEventType();
                            do {
                                if (eventType == 2) {
                                    if (xmlPullParserNewPullParser.getName().equals("iqProvider")) {
                                        xmlPullParserNewPullParser.next();
                                        xmlPullParserNewPullParser.next();
                                        String strNextText = xmlPullParserNewPullParser.nextText();
                                        xmlPullParserNewPullParser.next();
                                        xmlPullParserNewPullParser.next();
                                        String strNextText2 = xmlPullParserNewPullParser.nextText();
                                        xmlPullParserNewPullParser.next();
                                        xmlPullParserNewPullParser.next();
                                        String strNextText3 = xmlPullParserNewPullParser.nextText();
                                        String strA = a(strNextText, strNextText2);
                                        if (!this.f17645b.containsKey(strA)) {
                                            try {
                                                Class<?> cls = Class.forName(strNextText3);
                                                if (hi.class.isAssignableFrom(cls)) {
                                                    this.f17645b.put(strA, cls.newInstance());
                                                } else if (hb.class.isAssignableFrom(cls)) {
                                                    this.f17645b.put(strA, cls);
                                                }
                                            } catch (ClassNotFoundException e9) {
                                                e9.printStackTrace();
                                            }
                                        }
                                    } else if (xmlPullParserNewPullParser.getName().equals("extensionProvider")) {
                                        xmlPullParserNewPullParser.next();
                                        xmlPullParserNewPullParser.next();
                                        String strNextText4 = xmlPullParserNewPullParser.nextText();
                                        xmlPullParserNewPullParser.next();
                                        xmlPullParserNewPullParser.next();
                                        String strNextText5 = xmlPullParserNewPullParser.nextText();
                                        xmlPullParserNewPullParser.next();
                                        xmlPullParserNewPullParser.next();
                                        String strNextText6 = xmlPullParserNewPullParser.nextText();
                                        String strA2 = a(strNextText4, strNextText5);
                                        if (!this.f556a.containsKey(strA2)) {
                                            try {
                                                Class<?> cls2 = Class.forName(strNextText6);
                                                if (hj.class.isAssignableFrom(cls2)) {
                                                    this.f556a.put(strA2, cls2.newInstance());
                                                } else if (he.class.isAssignableFrom(cls2)) {
                                                    this.f556a.put(strA2, cls2);
                                                }
                                            } catch (ClassNotFoundException e10) {
                                                e10.printStackTrace();
                                            }
                                        }
                                    }
                                }
                                eventType = xmlPullParserNewPullParser.next();
                            } while (eventType != 1);
                            inputStreamOpenStream.close();
                        } catch (Throwable th) {
                            th = th;
                            try {
                                inputStreamOpenStream.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamOpenStream = null;
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Object m470a(String str, String str2) {
        return this.f556a.get(a(str, str2));
    }

    public void a(String str, String str2, Object obj) {
        if (!(obj instanceof hj) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f556a.put(a(str, str2), obj);
    }

    private String a(String str, String str2) {
        StringBuilder sbI = defpackage.f.i("<", str, "/>");
        if (str != null) {
            sbI.append("<");
            sbI.append(str2);
            sbI.append("/>");
        }
        return sbI.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private ClassLoader[] m469a() {
        ClassLoader[] classLoaderArr = {hk.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < 2; i9++) {
            ClassLoader classLoader = classLoaderArr[i9];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
