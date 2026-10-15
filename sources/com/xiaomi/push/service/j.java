package com.xiaomi.push.service;

import com.xiaomi.push.ha;
import com.xiaomi.push.hj;
import com.xiaomi.push.hk;
import com.xiaomi.push.hm;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class j implements hj {
    public void a() {
        hk.a().a("all", "xm:chat", this);
    }

    public ha b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return a(xmlPullParser);
        }
        return null;
    }

    public static ha a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String[] strArr;
        String[] strArr2;
        String strTrim;
        ArrayList arrayList;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i9 = 0; i9 < xmlPullParser.getAttributeCount(); i9++) {
                strArr3[i9] = xmlPullParser.getAttributeName(i9);
                strArr4[i9] = hm.b(xmlPullParser.getAttributeValue(i9));
            }
            strArr = strArr3;
            strTrim = null;
            arrayList = null;
            strArr2 = strArr4;
        } else {
            strArr = null;
            strArr2 = null;
            strTrim = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new ha(name, namespace, strArr, strArr2, strTrim, arrayList);
            }
            if (next == 4) {
                strTrim = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                ha haVarA = a(xmlPullParser);
                if (haVarA != null) {
                    arrayList.add(haVarA);
                }
            }
        }
    }
}
