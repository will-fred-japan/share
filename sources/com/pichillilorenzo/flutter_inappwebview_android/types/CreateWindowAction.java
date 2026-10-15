package com.pichillilorenzo.flutter_inappwebview_android.types;

import defpackage.f;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CreateWindowAction extends NavigationAction {
    boolean isDialog;
    int windowId;

    public CreateWindowAction(URLRequest uRLRequest, boolean z8, boolean z9, boolean z10, int i9, boolean z11) {
        super(uRLRequest, z8, z9, z10);
        this.windowId = i9;
        this.isDialog = z11;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.NavigationAction
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        CreateWindowAction createWindowAction = (CreateWindowAction) obj;
        return this.windowId == createWindowAction.windowId && this.isDialog == createWindowAction.isDialog;
    }

    public int getWindowId() {
        return this.windowId;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.NavigationAction
    public int hashCode() {
        return (((super.hashCode() * 31) + this.windowId) * 31) + (this.isDialog ? 1 : 0);
    }

    public boolean isDialog() {
        return this.isDialog;
    }

    public void setDialog(boolean z8) {
        this.isDialog = z8;
    }

    public void setWindowId(int i9) {
        this.windowId = i9;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.NavigationAction
    public Map<String, Object> toMap() {
        Map<String, Object> map = super.toMap();
        map.put("windowId", Integer.valueOf(this.windowId));
        map.put("isDialog", Boolean.valueOf(this.isDialog));
        map.put("windowFeatures", null);
        return map;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.NavigationAction
    public String toString() {
        StringBuilder sb = new StringBuilder("CreateWindowAction{windowId=");
        sb.append(this.windowId);
        sb.append(", isDialog=");
        sb.append(this.isDialog);
        sb.append(", request=");
        sb.append(this.request);
        sb.append(", isForMainFrame=");
        sb.append(this.isForMainFrame);
        sb.append(", hasGesture=");
        sb.append(this.hasGesture);
        sb.append(", isRedirect=");
        return f.g(sb, this.isRedirect, '}');
    }
}
