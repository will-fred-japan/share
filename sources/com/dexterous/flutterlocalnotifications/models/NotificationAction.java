package com.dexterous.flutterlocalnotifications.models;

import android.graphics.Color;
import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class NotificationAction implements Serializable {
    private static final String ALLOW_GENERATED_REPLIES = "allowGeneratedReplies";
    private static final String CANCEL_NOTIFICATION = "cancelNotification";
    private static final String CONTEXTUAL = "contextual";
    private static final String ICON = "icon";
    private static final String ICON_SOURCE = "iconBitmapSource";
    private static final String ID = "id";
    private static final String INPUTS = "inputs";
    private static final String INVISIBLE = "invisible";
    private static final String SEMANTIC_ACTION = "semanticAction";
    private static final String SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String TITLE = "title";
    private static final String TITLE_COLOR_ALPHA = "titleColorAlpha";
    private static final String TITLE_COLOR_BLUE = "titleColorBlue";
    private static final String TITLE_COLOR_GREEN = "titleColorGreen";
    private static final String TITLE_COLOR_RED = "titleColorRed";
    public final List<a> actionInputs = new ArrayList();
    public final Boolean allowGeneratedReplies;
    public final Boolean cancelNotification;
    public final Boolean contextual;
    public final String icon;
    public final IconSource iconSource;
    public final String id;
    public final Boolean invisible;
    public final Integer semanticAction;
    public final Boolean showsUserInterface;
    public final String title;
    public final Integer titleColor;

    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f12161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Boolean f12162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f12163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f12164d;

        public a(List<String> list, Boolean bool, String str, List<String> list2) {
            this.f12161a = list;
            this.f12162b = bool;
            this.f12163c = str;
            this.f12164d = list2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                List<String> list = aVar.f12161a;
                List<String> list2 = this.f12161a;
                if (list2 == null ? list != null : !list2.equals(list)) {
                    return false;
                }
                Boolean bool = aVar.f12162b;
                Boolean bool2 = this.f12162b;
                if (bool2 == null ? bool != null : !bool2.equals(bool)) {
                    return false;
                }
                String str = aVar.f12163c;
                String str2 = this.f12163c;
                if (str2 == null ? str != null : !str2.equals(str)) {
                    return false;
                }
                List<String> list3 = aVar.f12164d;
                List<String> list4 = this.f12164d;
                if (list4 != null) {
                    return list4.equals(list3);
                }
                if (list3 == null) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            List<String> list = this.f12161a;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Boolean bool = this.f12162b;
            int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
            String str = this.f12163c;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            List<String> list2 = this.f12164d;
            return iHashCode3 + (list2 != null ? list2.hashCode() : 0);
        }
    }

    public NotificationAction(Map<String, Object> map) {
        List<Map> list;
        this.id = (String) map.get("id");
        this.cancelNotification = (Boolean) map.get(CANCEL_NOTIFICATION);
        this.title = (String) map.get("title");
        Integer num = (Integer) map.get(TITLE_COLOR_ALPHA);
        Integer num2 = (Integer) map.get(TITLE_COLOR_RED);
        Integer num3 = (Integer) map.get(TITLE_COLOR_GREEN);
        Integer num4 = (Integer) map.get(TITLE_COLOR_BLUE);
        if (num == null || num2 == null || num3 == null || num4 == null) {
            this.titleColor = null;
        } else {
            this.titleColor = Integer.valueOf(Color.argb(num.intValue(), num2.intValue(), num3.intValue(), num4.intValue()));
        }
        this.icon = (String) map.get("icon");
        this.contextual = (Boolean) map.get(CONTEXTUAL);
        this.showsUserInterface = (Boolean) map.get(SHOWS_USER_INTERFACE);
        this.allowGeneratedReplies = (Boolean) map.get(ALLOW_GENERATED_REPLIES);
        this.semanticAction = (Integer) map.get(SEMANTIC_ACTION);
        this.invisible = (Boolean) map.get(INVISIBLE);
        Integer num5 = (Integer) map.get(ICON_SOURCE);
        if (num5 != null) {
            this.iconSource = IconSource.values()[num5.intValue()];
        } else {
            this.iconSource = null;
        }
        if (map.get(INPUTS) == null || (list = (List) map.get(INPUTS)) == null) {
            return;
        }
        for (Map map2 : list) {
            this.actionInputs.add(new a(castList(String.class, (Collection) map2.get("choices")), (Boolean) map2.get("allowFreeFormInput"), (String) map2.get("label"), castList(String.class, (Collection) map2.get("allowedMimeTypes"))));
        }
    }

    public static <T> List<T> castList(Class<? extends T> cls, Collection<?> collection) {
        if (collection == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(cls.cast(it.next()));
            } catch (ClassCastException unused) {
            }
        }
        return arrayList;
    }
}
