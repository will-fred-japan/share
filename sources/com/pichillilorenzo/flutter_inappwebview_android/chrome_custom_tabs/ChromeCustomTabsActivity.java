package com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs;

import W5.f;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.widget.RemoteViews;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.pichillilorenzo.flutter_inappwebview_android.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview_android.R;
import com.pichillilorenzo.flutter_inappwebview_android.types.AndroidResource;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomTabsActionButton;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomTabsMenuItem;
import com.pichillilorenzo.flutter_inappwebview_android.types.CustomTabsSecondaryToolbar;
import com.pichillilorenzo.flutter_inappwebview_android.types.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p130r.b;
import p130r.e;
import p130r.i;
import p130r.j;
import p130r.l;

/* JADX INFO: loaded from: classes.dex */
public class ChromeCustomTabsActivity extends Activity implements Disposable {
    public static final int CHROME_CUSTOM_TAB_REQUEST_CODE = 100;
    protected static final String LOG_TAG = "CustomTabsActivity";
    public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_chromesafaribrowser_";
    public static final int NO_HISTORY_CHROME_CUSTOM_TAB_REQUEST_CODE = 101;
    public CustomTabsActionButton actionButton;
    public e.c builder;
    public ChromeCustomTabsChannelDelegate channelDelegate;
    public j customTabsSession;
    public String id;
    public Map<String, String> initialHeaders;
    public List<String> initialOtherLikelyURLs;
    public String initialReferrer;
    public String initialUrl;
    public ChromeSafariBrowserManager manager;
    public CustomTabsSecondaryToolbar secondaryToolbar;
    public ChromeCustomTabsSettings customSettings = new ChromeCustomTabsSettings();
    public CustomTabActivityHelper customTabActivityHelper = new CustomTabActivityHelper();
    protected boolean onOpened = false;
    protected boolean onCompletedInitialLoad = false;
    protected boolean isBindSuccess = false;
    public List<CustomTabsMenuItem> menuItems = new ArrayList();

    private PendingIntent createPendingIntent(int i9) {
        Intent intent = new Intent(this, (Class<?>) ActionBroadcastReceiver.class);
        Bundle bundleJ = f.j(i9, ActionBroadcastReceiver.KEY_ACTION_ID);
        bundleJ.putString(ActionBroadcastReceiver.KEY_ACTION_VIEW_ID, this.id);
        ChromeSafariBrowserManager chromeSafariBrowserManager = this.manager;
        bundleJ.putString(ActionBroadcastReceiver.KEY_ACTION_MANAGER_ID, chromeSafariBrowserManager != null ? chromeSafariBrowserManager.id : null);
        intent.putExtras(bundleJ);
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(this, i9, intent, 167772160) : PendingIntent.getBroadcast(this, i9, intent, 134217728);
    }

    private void prepareCustomTabs() {
        e.c cVar = this.builder;
        if (cVar == null) {
            return;
        }
        ChromeCustomTabsSettings chromeCustomTabsSettings = this.customSettings;
        Boolean bool = chromeCustomTabsSettings.addDefaultShareMenuItem;
        if (bool != null) {
            cVar.b(bool.booleanValue() ? 1 : 2);
        } else {
            cVar.b(chromeCustomTabsSettings.shareState.intValue());
        }
        String str = this.customSettings.toolbarBackgroundColor;
        Integer numValueOf = null;
        Integer numValueOf2 = (str == null || str.isEmpty()) ? null : Integer.valueOf(Color.parseColor(this.customSettings.toolbarBackgroundColor) | (-16777216));
        String str2 = this.customSettings.navigationBarColor;
        Integer numValueOf3 = (str2 == null || str2.isEmpty()) ? null : Integer.valueOf((-16777216) | Color.parseColor(this.customSettings.navigationBarColor));
        String str3 = this.customSettings.navigationBarDividerColor;
        Integer numValueOf4 = (str3 == null || str3.isEmpty()) ? null : Integer.valueOf(Color.parseColor(this.customSettings.navigationBarDividerColor));
        String str4 = this.customSettings.secondaryToolbarColor;
        if (str4 != null && !str4.isEmpty()) {
            numValueOf = Integer.valueOf(Color.parseColor(this.customSettings.secondaryToolbarColor));
        }
        e.c cVar2 = this.builder;
        cVar2.getClass();
        Bundle bundle = new Bundle();
        if (numValueOf2 != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", numValueOf2.intValue());
        }
        if (numValueOf != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", numValueOf.intValue());
        }
        if (numValueOf3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", numValueOf3.intValue());
        }
        if (numValueOf4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", numValueOf4.intValue());
        }
        cVar2.f21076e = bundle;
        this.builder.f21072a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", this.customSettings.showTitle.booleanValue() ? 1 : 0);
        this.builder.f21072a.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", this.customSettings.enableUrlBarHiding.booleanValue());
        this.builder.f21078g = this.customSettings.instantAppsEnabled.booleanValue();
        if (this.customSettings.startAnimations.size() == 2) {
            e.c cVar3 = this.builder;
            int identifier = this.customSettings.startAnimations.get(0).getIdentifier(this);
            int identifier2 = this.customSettings.startAnimations.get(1).getIdentifier(this);
            cVar3.getClass();
            cVar3.f21075d = ActivityOptions.makeCustomAnimation(this, identifier, identifier2);
        }
        if (this.customSettings.exitAnimations.size() == 2) {
            e.c cVar4 = this.builder;
            int identifier3 = this.customSettings.exitAnimations.get(0).getIdentifier(this);
            int identifier4 = this.customSettings.exitAnimations.get(1).getIdentifier(this);
            cVar4.getClass();
            cVar4.f21072a.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", ActivityOptions.makeCustomAnimation(this, identifier3, identifier4).toBundle());
        }
        for (CustomTabsMenuItem customTabsMenuItem : this.menuItems) {
            e.c cVar5 = this.builder;
            String label = customTabsMenuItem.getLabel();
            PendingIntent pendingIntentCreatePendingIntent = createPendingIntent(customTabsMenuItem.getId());
            if (cVar5.f21074c == null) {
                cVar5.f21074c = new ArrayList<>();
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("android.support.customtabs.customaction.MENU_ITEM_TITLE", label);
            bundle2.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", pendingIntentCreatePendingIntent);
            cVar5.f21074c.add(bundle2);
        }
        CustomTabsActionButton customTabsActionButton = this.actionButton;
        if (customTabsActionButton != null) {
            byte[] icon = customTabsActionButton.getIcon();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inMutable = true;
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(icon, 0, icon.length, options);
            e.c cVar6 = this.builder;
            String description = this.actionButton.getDescription();
            PendingIntent pendingIntentCreatePendingIntent2 = createPendingIntent(this.actionButton.getId());
            boolean zIsShouldTint = this.actionButton.isShouldTint();
            cVar6.getClass();
            Bundle bundle3 = new Bundle();
            bundle3.putInt("android.support.customtabs.customaction.ID", 0);
            bundle3.putParcelable("android.support.customtabs.customaction.ICON", bitmapDecodeByteArray);
            bundle3.putString("android.support.customtabs.customaction.DESCRIPTION", description);
            bundle3.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", pendingIntentCreatePendingIntent2);
            Intent intent = cVar6.f21072a;
            intent.putExtra("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle3);
            intent.putExtra("android.support.customtabs.extra.TINT_ACTION_BUTTON", zIsShouldTint);
        }
        CustomTabsSecondaryToolbar customTabsSecondaryToolbar = this.secondaryToolbar;
        if (customTabsSecondaryToolbar != null) {
            AndroidResource layout = customTabsSecondaryToolbar.getLayout();
            RemoteViews remoteViews = new RemoteViews(layout.getDefPackage(), layout.getIdentifier(this));
            int[] iArr = new int[this.secondaryToolbar.getClickableIDs().size()];
            int size = this.secondaryToolbar.getClickableIDs().size();
            for (int i9 = 0; i9 < size; i9++) {
                iArr[i9] = this.secondaryToolbar.getClickableIDs().get(i9).getIdentifier(this);
            }
            e.c cVar7 = this.builder;
            PendingIntent secondaryToolbarOnClickPendingIntent = getSecondaryToolbarOnClickPendingIntent();
            Intent intent2 = cVar7.f21072a;
            intent2.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS", remoteViews);
            intent2.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS", iArr);
            intent2.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT", secondaryToolbarOnClickPendingIntent);
        }
    }

    private void prepareCustomTabsIntent(e eVar) {
        String str = this.customSettings.packageName;
        if (str != null) {
            eVar.f21070a.setPackage(str);
        } else {
            eVar.f21070a.setPackage(CustomTabsHelper.getPackageNameToUse(this));
        }
        if (this.customSettings.keepAliveEnabled.booleanValue()) {
            CustomTabsHelper.addKeepAliveExtra(this, eVar.f21070a);
        }
        if (this.customSettings.alwaysUseBrowserUI.booleanValue()) {
            Intent intent = eVar.f21070a;
            if (intent == null) {
                intent = new Intent("android.intent.action.VIEW");
            }
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        }
    }

    public void close() {
        onStop();
        onDestroy();
        this.customTabsSession = null;
        finish();
        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = this.channelDelegate;
        if (chromeCustomTabsChannelDelegate != null) {
            chromeCustomTabsChannelDelegate.onClosed();
        }
    }

    public void customTabsConnected() {
        String str;
        j session = this.customTabActivityHelper.getSession();
        this.customTabsSession = session;
        if (session != null) {
            try {
                Bundle bundle = new Bundle();
                j jVar = this.customTabsSession;
                try {
                    if (jVar.f21086b.h(jVar.f21087c, jVar.a(bundle))) {
                        j jVar2 = this.customTabsSession;
                        l lVar = new l() { // from class: com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ChromeCustomTabsActivity.3
                            @Override // p130r.l
                            public void onGreatestScrollPercentageIncreased(int i9, Bundle bundle2) {
                                ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                                if (chromeCustomTabsChannelDelegate != null) {
                                    chromeCustomTabsChannelDelegate.onGreatestScrollPercentageIncreased(i9);
                                }
                            }

                            @Override // p130r.l
                            public void onSessionEnded(boolean z8, Bundle bundle2) {
                                ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                                if (chromeCustomTabsChannelDelegate != null) {
                                    chromeCustomTabsChannelDelegate.onSessionEnded(z8);
                                }
                            }

                            @Override // p130r.l
                            public void onVerticalScrollEvent(boolean z8, Bundle bundle2) {
                                ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                                if (chromeCustomTabsChannelDelegate != null) {
                                    chromeCustomTabsChannelDelegate.onVerticalScrollEvent(z8);
                                }
                            }
                        };
                        try {
                            jVar2.f21086b.M(jVar2.f21087c, new i(lVar), jVar2.a(bundle));
                        } catch (SecurityException e9) {
                            throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e9);
                        }
                    }
                } catch (SecurityException e10) {
                    throw new UnsupportedOperationException("This method isn't supported by the Custom Tabs implementation.", e10);
                }
            } catch (Throwable th) {
                Log.d(LOG_TAG, "Custom Tabs Engagement Signals API not supported", th);
            }
        }
        if (!this.isBindSuccess || (str = this.initialUrl) == null) {
            return;
        }
        launchUrl(str, this.initialHeaders, this.initialReferrer, this.initialOtherLikelyURLs);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        onStop();
        onDestroy();
        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = this.channelDelegate;
        if (chromeCustomTabsChannelDelegate != null) {
            chromeCustomTabsChannelDelegate.dispose();
            this.channelDelegate = null;
        }
        ChromeSafariBrowserManager chromeSafariBrowserManager = this.manager;
        if (chromeSafariBrowserManager != null && chromeSafariBrowserManager.browsers.containsKey(this.id)) {
            this.manager.browsers.put(this.id, null);
        }
        this.manager = null;
    }

    public PendingIntent getSecondaryToolbarOnClickPendingIntent() {
        Intent intent = new Intent(this, (Class<?>) ActionBroadcastReceiver.class);
        Bundle bundle = new Bundle();
        bundle.putString(ActionBroadcastReceiver.KEY_ACTION_VIEW_ID, this.id);
        ChromeSafariBrowserManager chromeSafariBrowserManager = this.manager;
        bundle.putString(ActionBroadcastReceiver.KEY_ACTION_MANAGER_ID, chromeSafariBrowserManager != null ? chromeSafariBrowserManager.id : null);
        intent.putExtras(bundle);
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(this, 0, intent, 167772160) : PendingIntent.getBroadcast(this, 0, intent, 134217728);
    }

    public void launchUrl(String str, Map<String, String> map, String str2, List<String> list) {
        launchUrlWithSession(this.customTabsSession, str, map, str2, list);
    }

    public void launchUrlWithSession(j jVar, String str, Map<String, String> map, String str2, List<String> list) {
        mayLaunchUrl(str, list);
        this.builder = new e.c(jVar);
        prepareCustomTabs();
        e eVarA = this.builder.a();
        prepareCustomTabsIntent(eVarA);
        CustomTabActivityHelper.openCustomTab(this, eVarA, Uri.parse(str), map, str2 != null ? Uri.parse(str2) : null, 100);
    }

    public boolean mayLaunchUrl(String str, List<String> list) {
        Uri uri = str != null ? Uri.parse(str) : null;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Bundle bundle = new Bundle();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                bundle.putString("android.support.customtabs.otherurls.URL", it.next());
            }
        }
        return this.customTabActivityHelper.mayLaunchUrl(uri, null, arrayList);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i9, int i10, Intent intent) {
        if (i9 == 100) {
            close();
            dispose();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        NoHistoryCustomTabsActivityCallbacks noHistoryCustomTabsActivityCallbacks;
        super.onCreate(bundle);
        setContentView(R.layout.chrome_custom_tabs_layout);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.id = extras.getString("id");
        ChromeSafariBrowserManager chromeSafariBrowserManager = ChromeSafariBrowserManager.shared.get(extras.getString("managerId"));
        this.manager = chromeSafariBrowserManager;
        if (chromeSafariBrowserManager == null || (inAppWebViewFlutterPlugin = chromeSafariBrowserManager.plugin) == null || inAppWebViewFlutterPlugin.messenger == null) {
            return;
        }
        chromeSafariBrowserManager.browsers.put(this.id, this);
        this.channelDelegate = new ChromeCustomTabsChannelDelegate(this, new p096m7.l(this.manager.plugin.messenger, METHOD_CHANNEL_NAME_PREFIX + this.id));
        this.initialUrl = extras.getString(RemoteMessageConst.Notification.URL);
        this.initialHeaders = (Map) extras.getSerializable("headers");
        this.initialReferrer = extras.getString("referrer");
        this.initialOtherLikelyURLs = extras.getStringArrayList("otherLikelyURLs");
        ChromeCustomTabsSettings chromeCustomTabsSettings = new ChromeCustomTabsSettings();
        this.customSettings = chromeCustomTabsSettings;
        chromeCustomTabsSettings.parse2((Map<String, Object>) extras.getSerializable("settings"));
        this.actionButton = CustomTabsActionButton.fromMap((Map) extras.getSerializable("actionButton"));
        this.secondaryToolbar = CustomTabsSecondaryToolbar.fromMap((Map) extras.getSerializable("secondaryToolbar"));
        Iterator it = ((List) extras.getSerializable("menuItemList")).iterator();
        while (it.hasNext()) {
            this.menuItems.add(CustomTabsMenuItem.fromMap((Map) it.next()));
        }
        if (this.customSettings.noHistory.booleanValue() && (noHistoryCustomTabsActivityCallbacks = this.manager.plugin.noHistoryCustomTabsActivityCallbacks) != null) {
            Map<String, String> map = noHistoryCustomTabsActivityCallbacks.noHistoryBrowserIDs;
            String str = this.id;
            map.put(str, str);
        }
        this.customTabActivityHelper.setConnectionCallback(new CustomTabActivityHelper.ConnectionCallback() { // from class: com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ChromeCustomTabsActivity.1
            @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.CustomTabActivityHelper.ConnectionCallback
            public void onCustomTabsConnected() {
                ChromeCustomTabsActivity.this.customTabsConnected();
                ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                if (chromeCustomTabsChannelDelegate != null) {
                    chromeCustomTabsChannelDelegate.onServiceConnected();
                }
            }

            @Override // com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.CustomTabActivityHelper.ConnectionCallback
            public void onCustomTabsDisconnected() {
                this.close();
                ChromeCustomTabsActivity.this.dispose();
            }
        });
        this.customTabActivityHelper.setCustomTabsCallback(new b() { // from class: com.pichillilorenzo.flutter_inappwebview_android.chrome_custom_tabs.ChromeCustomTabsActivity.2
            @Override // p130r.b
            public void onMessageChannelReady(Bundle bundle2) {
                ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                if (chromeCustomTabsChannelDelegate != null) {
                    chromeCustomTabsChannelDelegate.onMessageChannelReady();
                }
            }

            @Override // p130r.b
            public void onNavigationEvent(int i9, Bundle bundle2) {
                if (i9 == 5) {
                    ChromeCustomTabsActivity chromeCustomTabsActivity = ChromeCustomTabsActivity.this;
                    if (!chromeCustomTabsActivity.onOpened) {
                        chromeCustomTabsActivity.onOpened = true;
                        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = chromeCustomTabsActivity.channelDelegate;
                        if (chromeCustomTabsChannelDelegate != null) {
                            chromeCustomTabsChannelDelegate.onOpened();
                        }
                    }
                }
                if (i9 == 2) {
                    ChromeCustomTabsActivity chromeCustomTabsActivity2 = ChromeCustomTabsActivity.this;
                    if (!chromeCustomTabsActivity2.onCompletedInitialLoad) {
                        chromeCustomTabsActivity2.onCompletedInitialLoad = true;
                        ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate2 = chromeCustomTabsActivity2.channelDelegate;
                        if (chromeCustomTabsChannelDelegate2 != null) {
                            chromeCustomTabsChannelDelegate2.onCompletedInitialLoad();
                        }
                    }
                }
                ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate3 = ChromeCustomTabsActivity.this.channelDelegate;
                if (chromeCustomTabsChannelDelegate3 != null) {
                    chromeCustomTabsChannelDelegate3.onNavigationEvent(i9);
                }
            }

            @Override // p130r.b
            public void onPostMessage(String str2, Bundle bundle2) {
                ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                if (chromeCustomTabsChannelDelegate != null) {
                    chromeCustomTabsChannelDelegate.onPostMessage(str2);
                }
            }

            @Override // p130r.b
            public void onRelationshipValidationResult(int i9, Uri uri, boolean z8, Bundle bundle2) {
                ChromeCustomTabsChannelDelegate chromeCustomTabsChannelDelegate = ChromeCustomTabsActivity.this.channelDelegate;
                if (chromeCustomTabsChannelDelegate != null) {
                    chromeCustomTabsChannelDelegate.onRelationshipValidationResult(i9, uri, z8);
                }
            }

            @Override // p130r.b
            public void extraCallback(String str2, Bundle bundle2) {
            }
        });
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onStart() {
        String str;
        super.onStart();
        boolean zBindCustomTabsService = this.customTabActivityHelper.bindCustomTabsService(this);
        this.isBindSuccess = zBindCustomTabsService;
        if (zBindCustomTabsService || (str = this.initialUrl) == null) {
            return;
        }
        launchUrlWithSession(null, str, this.initialHeaders, this.initialReferrer, this.initialOtherLikelyURLs);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.customTabActivityHelper.unbindCustomTabsService(this);
        this.isBindSuccess = false;
    }

    public void updateActionButton(byte[] bArr, String str) {
        if (this.customTabsSession == null || this.actionButton == null) {
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        j jVar = this.customTabsSession;
        jVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.customtabs.customaction.ICON", bitmapDecodeByteArray);
        bundle.putString("android.support.customtabs.customaction.DESCRIPTION", str);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle);
        try {
            jVar.f21086b.n(jVar.f21087c, bundle2);
        } catch (RemoteException unused) {
        }
        this.actionButton.setIcon(bArr);
        this.actionButton.setDescription(str);
    }

    public void updateSecondaryToolbar(CustomTabsSecondaryToolbar customTabsSecondaryToolbar) {
        if (this.customTabsSession == null) {
            return;
        }
        AndroidResource layout = customTabsSecondaryToolbar.getLayout();
        RemoteViews remoteViews = new RemoteViews(layout.getDefPackage(), layout.getIdentifier(this));
        int[] iArr = new int[customTabsSecondaryToolbar.getClickableIDs().size()];
        int size = customTabsSecondaryToolbar.getClickableIDs().size();
        for (int i9 = 0; i9 < size; i9++) {
            iArr[i9] = customTabsSecondaryToolbar.getClickableIDs().get(i9).getIdentifier(this);
        }
        j jVar = this.customTabsSession;
        PendingIntent secondaryToolbarOnClickPendingIntent = getSecondaryToolbarOnClickPendingIntent();
        jVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("android.support.customtabs.extra.EXTRA_REMOTEVIEWS", remoteViews);
        bundle.putIntArray("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS", iArr);
        bundle.putParcelable("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT", secondaryToolbarOnClickPendingIntent);
        try {
            jVar.f21086b.n(jVar.f21087c, bundle);
        } catch (RemoteException unused) {
        }
        this.secondaryToolbar = customTabsSecondaryToolbar;
    }
}
