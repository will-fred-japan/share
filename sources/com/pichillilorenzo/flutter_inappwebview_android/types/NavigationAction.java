package com.pichillilorenzo.flutter_inappwebview_android.types;

import defpackage.f;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NavigationAction {
    boolean hasGesture;
    boolean isForMainFrame;
    boolean isRedirect;
    URLRequest request;

    public NavigationAction(URLRequest uRLRequest, boolean z8, boolean z9, boolean z10) {
        this.request = uRLRequest;
        this.isForMainFrame = z8;
        this.hasGesture = z9;
        this.isRedirect = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NavigationAction navigationAction = (NavigationAction) obj;
        if (this.isForMainFrame == navigationAction.isForMainFrame && this.hasGesture == navigationAction.hasGesture && this.isRedirect == navigationAction.isRedirect) {
            return this.request.equals(navigationAction.request);
        }
        return false;
    }

    public URLRequest getRequest() {
        return this.request;
    }

    public int hashCode() {
        return (((((this.request.hashCode() * 31) + (this.isForMainFrame ? 1 : 0)) * 31) + (this.hasGesture ? 1 : 0)) * 31) + (this.isRedirect ? 1 : 0);
    }

    public boolean isForMainFrame() {
        return this.isForMainFrame;
    }

    public boolean isHasGesture() {
        return this.hasGesture;
    }

    public boolean isRedirect() {
        return this.isRedirect;
    }

    public void setForMainFrame(boolean z8) {
        this.isForMainFrame = z8;
    }

    public void setHasGesture(boolean z8) {
        this.hasGesture = z8;
    }

    public void setRedirect(boolean z8) {
        this.isRedirect = z8;
    }

    public void setRequest(URLRequest uRLRequest) {
        this.request = uRLRequest;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("request", this.request.toMap());
        map.put("isForMainFrame", Boolean.valueOf(this.isForMainFrame));
        map.put("hasGesture", Boolean.valueOf(this.hasGesture));
        map.put("isRedirect", Boolean.valueOf(this.isRedirect));
        map.put("navigationType", null);
        map.put("sourceFrame", null);
        map.put("targetFrame", null);
        map.put("shouldPerformDownload", null);
        return map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavigationAction{request=");
        sb.append(this.request);
        sb.append(", isForMainFrame=");
        sb.append(this.isForMainFrame);
        sb.append(", hasGesture=");
        sb.append(this.hasGesture);
        sb.append(", isRedirect=");
        return f.g(sb, this.isRedirect, '}');
    }
}
