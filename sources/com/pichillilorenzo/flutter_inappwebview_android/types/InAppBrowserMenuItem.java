package com.pichillilorenzo.flutter_inappwebview_android.types;

import A.a;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.pichillilorenzo.flutter_inappwebview_android.Util;
import defpackage.f;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class InAppBrowserMenuItem {
    private Object icon;
    private String iconColor;
    private int id;
    private Integer order;
    private boolean showAsAction;
    private String title;

    public InAppBrowserMenuItem(int i9, String str, Integer num, Object obj, String str2, boolean z8) {
        this.id = i9;
        this.title = str;
        this.order = num;
        this.icon = obj;
        this.iconColor = str2;
        this.showAsAction = z8;
    }

    public static InAppBrowserMenuItem fromMap(Map<String, Object> map) {
        Object obj;
        AndroidResource androidResourceFromMap = null;
        if (map == null) {
            return null;
        }
        int iIntValue = ((Integer) map.get("id")).intValue();
        String str = (String) map.get("title");
        Integer num = (Integer) map.get("order");
        Object obj2 = map.get(RemoteMessageConst.Notification.ICON);
        if (!(obj2 instanceof Map)) {
            if (obj2 instanceof byte[]) {
                obj = obj2;
            }
            return new InAppBrowserMenuItem(iIntValue, str, num, obj, (String) map.get("iconColor"), ((Boolean) Util.getOrDefault(map, "showAsAction", Boolean.FALSE)).booleanValue());
        }
        androidResourceFromMap = AndroidResource.fromMap((Map) map.get(RemoteMessageConst.Notification.ICON));
        obj = androidResourceFromMap;
        return new InAppBrowserMenuItem(iIntValue, str, num, obj, (String) map.get("iconColor"), ((Boolean) Util.getOrDefault(map, "showAsAction", Boolean.FALSE)).booleanValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InAppBrowserMenuItem inAppBrowserMenuItem = (InAppBrowserMenuItem) obj;
        if (this.id == inAppBrowserMenuItem.id && this.showAsAction == inAppBrowserMenuItem.showAsAction && this.title.equals(inAppBrowserMenuItem.title) && Objects.equals(this.order, inAppBrowserMenuItem.order) && Objects.equals(this.icon, inAppBrowserMenuItem.icon)) {
            return Objects.equals(this.iconColor, inAppBrowserMenuItem.iconColor);
        }
        return false;
    }

    public Object getIcon() {
        return this.icon;
    }

    public String getIconColor() {
        return this.iconColor;
    }

    public int getId() {
        return this.id;
    }

    public Integer getOrder() {
        return this.order;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iG = a.g(this.id * 31, 31, this.title);
        Integer num = this.order;
        int iHashCode = (iG + (num != null ? num.hashCode() : 0)) * 31;
        Object obj = this.icon;
        int iHashCode2 = (iHashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        String str = this.iconColor;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + (this.showAsAction ? 1 : 0);
    }

    public boolean isShowAsAction() {
        return this.showAsAction;
    }

    public void setIcon(Object obj) {
        this.icon = obj;
    }

    public void setIconColor(String str) {
        this.iconColor = str;
    }

    public void setId(int i9) {
        this.id = i9;
    }

    public void setOrder(Integer num) {
        this.order = num;
    }

    public void setShowAsAction(boolean z8) {
        this.showAsAction = z8;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InAppBrowserMenuItem{id=");
        sb.append(this.id);
        sb.append(", title='");
        sb.append(this.title);
        sb.append("', order=");
        sb.append(this.order);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", iconColor='");
        sb.append(this.iconColor);
        sb.append("', showAsAction=");
        return f.g(sb, this.showAsAction, '}');
    }
}
