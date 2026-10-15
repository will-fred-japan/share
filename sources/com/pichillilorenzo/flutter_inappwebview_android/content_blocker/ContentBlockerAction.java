package com.pichillilorenzo.flutter_inappwebview_android.content_blocker;

import A.a;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ContentBlockerAction {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private String selector;
    private ContentBlockerActionType type;

    public ContentBlockerAction(ContentBlockerActionType contentBlockerActionType, String str) {
        this.type = contentBlockerActionType;
        contentBlockerActionType.equals(ContentBlockerActionType.CSS_DISPLAY_NONE);
        this.selector = str;
    }

    public static ContentBlockerAction fromMap(Map<String, Object> map) {
        return new ContentBlockerAction(ContentBlockerActionType.fromValue((String) map.get("type")), (String) map.get("selector"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ContentBlockerAction contentBlockerAction = (ContentBlockerAction) obj;
            if (this.type != contentBlockerAction.type) {
                return false;
            }
            String str = this.selector;
            String str2 = contentBlockerAction.selector;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public String getSelector() {
        return this.selector;
    }

    public ContentBlockerActionType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.selector;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public void setSelector(String str) {
        this.selector = str;
    }

    public void setType(ContentBlockerActionType contentBlockerActionType) {
        this.type = contentBlockerActionType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ContentBlockerAction{type=");
        sb.append(this.type);
        sb.append(", selector='");
        return a.j(sb, this.selector, "'}");
    }
}
