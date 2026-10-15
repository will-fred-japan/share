package com.pichillilorenzo.flutter_inappwebview_android.in_app_browser;

import android.view.Menu;
import android.widget.ProgressBar;
import androidx.appcompat.app.a;
import com.pichillilorenzo.flutter_inappwebview_android.ISettings;
import com.pichillilorenzo.flutter_inappwebview_android.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class InAppBrowserSettings implements ISettings<InAppBrowserActivity> {
    public static final String LOG_TAG = "InAppBrowserSettings";
    public Boolean allowGoBackWithBackButton;
    public Boolean closeOnCannotGoBack;
    public Boolean hidden;
    public Boolean hideDefaultMenuItems;
    public Boolean hideProgressBar;
    public Boolean hideTitleBar;
    public Boolean hideToolbarTop;
    public Boolean hideUrlBar;
    public Boolean shouldCloseOnBackButtonPressed;
    public String toolbarTopBackgroundColor;
    public String toolbarTopFixedTitle;

    public InAppBrowserSettings() {
        Boolean bool = Boolean.FALSE;
        this.hidden = bool;
        this.hideToolbarTop = bool;
        this.hideUrlBar = bool;
        this.hideProgressBar = bool;
        this.hideTitleBar = bool;
        Boolean bool2 = Boolean.TRUE;
        this.closeOnCannotGoBack = bool2;
        this.allowGoBackWithBackButton = bool2;
        this.shouldCloseOnBackButtonPressed = bool;
        this.hideDefaultMenuItems = bool;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public /* bridge */ /* synthetic */ ISettings<InAppBrowserActivity> parse(Map map) {
        return parse2((Map<String, Object>) map);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("hidden", this.hidden);
        map.put("hideToolbarTop", this.hideToolbarTop);
        map.put("toolbarTopBackgroundColor", this.toolbarTopBackgroundColor);
        map.put("toolbarTopFixedTitle", this.toolbarTopFixedTitle);
        map.put("hideUrlBar", this.hideUrlBar);
        map.put("hideTitleBar", this.hideTitleBar);
        map.put("closeOnCannotGoBack", this.closeOnCannotGoBack);
        map.put("hideProgressBar", this.hideProgressBar);
        map.put("allowGoBackWithBackButton", this.allowGoBackWithBackButton);
        map.put("shouldCloseOnBackButtonPressed", this.shouldCloseOnBackButtonPressed);
        map.put("hideDefaultMenuItems", this.hideDefaultMenuItems);
        return map;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> getRealSettings(InAppBrowserActivity inAppBrowserActivity) {
        Map<String, Object> map = toMap();
        map.put("hidden", Boolean.valueOf(inAppBrowserActivity.isHidden));
        a aVar = inAppBrowserActivity.actionBar;
        boolean z8 = true;
        map.put("hideToolbarTop", Boolean.valueOf(aVar == null || !aVar.h()));
        Menu menu = inAppBrowserActivity.menu;
        map.put("hideUrlBar", Boolean.valueOf(menu == null || !menu.findItem(R.id.menu_search).isVisible()));
        ProgressBar progressBar = inAppBrowserActivity.progressBar;
        if (progressBar != null && progressBar.getMax() != 0) {
            z8 = false;
        }
        map.put("hideProgressBar", Boolean.valueOf(z8));
        return map;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    /* JADX INFO: renamed from: parse, reason: avoid collision after fix types in other method */
    public ISettings<InAppBrowserActivity> parse2(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                key.getClass();
                switch (key) {
                    case "hideTitleBar":
                        this.hideTitleBar = (Boolean) value;
                        break;
                    case "hidden":
                        this.hidden = (Boolean) value;
                        break;
                    case "allowGoBackWithBackButton":
                        this.allowGoBackWithBackButton = (Boolean) value;
                        break;
                    case "hideToolbarTop":
                        this.hideToolbarTop = (Boolean) value;
                        break;
                    case "hideDefaultMenuItems":
                        this.hideDefaultMenuItems = (Boolean) value;
                        break;
                    case "toolbarTopFixedTitle":
                        this.toolbarTopFixedTitle = (String) value;
                        break;
                    case "hideProgressBar":
                        this.hideProgressBar = (Boolean) value;
                        break;
                    case "closeOnCannotGoBack":
                        this.closeOnCannotGoBack = (Boolean) value;
                        break;
                    case "hideUrlBar":
                        this.hideUrlBar = (Boolean) value;
                        break;
                    case "toolbarTopBackgroundColor":
                        this.toolbarTopBackgroundColor = (String) value;
                        break;
                    case "shouldCloseOnBackButtonPressed":
                        this.shouldCloseOnBackButtonPressed = (Boolean) value;
                        break;
                }
            }
        }
        return this;
    }
}
