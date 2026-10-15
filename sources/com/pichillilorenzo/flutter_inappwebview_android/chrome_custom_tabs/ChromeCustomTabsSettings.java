package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import android.content.Intent;
import com.pichillilorenzo.flutter_inappwebview_android.ISettings;
import com.pichillilorenzo.flutter_inappwebview_android.types.AndroidResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p139s.b;

/* JADX INFO: loaded from: classes.dex */
public class ChromeCustomTabsSettings implements ISettings<ChromeCustomTabsActivity> {
    static final String LOG_TAG = "ChromeCustomTabsSettings";

    @Deprecated
    public Boolean addDefaultShareMenuItem;
    public List<String> additionalTrustedOrigins;
    public Boolean alwaysUseBrowserUI;
    public b displayMode;
    public Boolean enableUrlBarHiding;
    public List<AndroidResource> exitAnimations;
    public Boolean instantAppsEnabled;
    public Boolean isSingleInstance;
    public Boolean isTrustedWebActivity;
    public Boolean keepAliveEnabled;
    public String navigationBarColor;
    public String navigationBarDividerColor;
    public Boolean noHistory;
    public String packageName;
    public Integer screenOrientation;
    public String secondaryToolbarColor;
    public Integer shareState = 0;
    public Boolean showTitle = Boolean.TRUE;
    public List<AndroidResource> startAnimations;
    public String toolbarBackgroundColor;

    public ChromeCustomTabsSettings() {
        Boolean bool = Boolean.FALSE;
        this.enableUrlBarHiding = bool;
        this.instantAppsEnabled = bool;
        this.keepAliveEnabled = bool;
        this.isSingleInstance = bool;
        this.noHistory = bool;
        this.isTrustedWebActivity = bool;
        this.additionalTrustedOrigins = new ArrayList();
        this.displayMode = null;
        this.screenOrientation = 0;
        this.startAnimations = new ArrayList();
        this.exitAnimations = new ArrayList();
        this.alwaysUseBrowserUI = bool;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public /* bridge */ /* synthetic */ ISettings<ChromeCustomTabsActivity> parse(Map map) {
        return parse2((Map<String, Object>) map);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("addDefaultShareMenuItem", this.addDefaultShareMenuItem);
        map.put("showTitle", this.showTitle);
        map.put("toolbarBackgroundColor", this.toolbarBackgroundColor);
        map.put("navigationBarColor", this.navigationBarColor);
        map.put("navigationBarDividerColor", this.navigationBarDividerColor);
        map.put("secondaryToolbarColor", this.secondaryToolbarColor);
        map.put("enableUrlBarHiding", this.enableUrlBarHiding);
        map.put("instantAppsEnabled", this.instantAppsEnabled);
        map.put("packageName", this.packageName);
        map.put("keepAliveEnabled", this.keepAliveEnabled);
        map.put("isSingleInstance", this.isSingleInstance);
        map.put("noHistory", this.noHistory);
        map.put("isTrustedWebActivity", this.isTrustedWebActivity);
        map.put("additionalTrustedOrigins", this.additionalTrustedOrigins);
        map.put("screenOrientation", this.screenOrientation);
        map.put("alwaysUseBrowserUI", this.alwaysUseBrowserUI);
        return map;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> getRealSettings(ChromeCustomTabsActivity chromeCustomTabsActivity) {
        Intent intent;
        Map<String, Object> map = toMap();
        if (chromeCustomTabsActivity != null && (intent = chromeCustomTabsActivity.getIntent()) != null) {
            map.put("packageName", intent.getPackage());
            map.put("keepAliveEnabled", Boolean.valueOf(intent.hasExtra("android.support.customtabs.extra.KEEP_ALIVE")));
        }
        return map;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    /* JADX INFO: renamed from: parse, reason: avoid collision after fix types in other method */
    public ISettings<ChromeCustomTabsActivity> parse2(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                key.getClass();
                switch (key) {
                    case "addDefaultShareMenuItem":
                        this.addDefaultShareMenuItem = (Boolean) value;
                        break;
                    case "startAnimations":
                        for (Map map2 : (List) value) {
                            if (AndroidResource.fromMap(map2) != null) {
                                this.startAnimations.add(AndroidResource.fromMap(map2));
                            }
                        }
                        break;
                    case "showTitle":
                        this.showTitle = (Boolean) value;
                        break;
                    case "shareState":
                        this.shareState = (Integer) value;
                        break;
                    case "isSingleInstance":
                        this.isSingleInstance = (Boolean) value;
                        break;
                    case "navigationBarColor":
                        this.navigationBarColor = (String) value;
                        break;
                    case "navigationBarDividerColor":
                        this.navigationBarDividerColor = (String) value;
                        break;
                    case "toolbarBackgroundColor":
                        this.toolbarBackgroundColor = (String) value;
                        break;
                    case "enableUrlBarHiding":
                        this.enableUrlBarHiding = (Boolean) value;
                        break;
                    case "screenOrientation":
                        this.screenOrientation = (Integer) value;
                        break;
                    case "exitAnimations":
                        for (Map map3 : (List) value) {
                            if (AndroidResource.fromMap(map3) != null) {
                                this.exitAnimations.add(AndroidResource.fromMap(map3));
                            }
                        }
                        break;
                    case "secondaryToolbarColor":
                        this.secondaryToolbarColor = (String) value;
                        break;
                    case "isTrustedWebActivity":
                        this.isTrustedWebActivity = (Boolean) value;
                        break;
                    case "instantAppsEnabled":
                        this.instantAppsEnabled = (Boolean) value;
                        break;
                    case "packageName":
                        this.packageName = (String) value;
                        break;
                    case "noHistory":
                        this.noHistory = (Boolean) value;
                        break;
                    case "additionalTrustedOrigins":
                        this.additionalTrustedOrigins = (List) value;
                        break;
                    case "alwaysUseBrowserUI":
                        this.alwaysUseBrowserUI = (Boolean) value;
                        break;
                    case "displayMode":
                        Map map4 = (Map) value;
                        String str = (String) map4.get("type");
                        if (str != null) {
                            if (str.equals("IMMERSIVE_MODE")) {
                                this.displayMode = new b.C0253b(((Boolean) map4.get("isSticky")).booleanValue(), ((Integer) map4.get("displayCutoutMode")).intValue());
                            } else if (str.equals("DEFAULT_MODE")) {
                                this.displayMode = new b.a();
                            }
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "keepAliveEnabled":
                        this.keepAliveEnabled = (Boolean) value;
                        break;
                }
            }
        }
        return this;
    }
}
