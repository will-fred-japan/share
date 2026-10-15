package B0;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: WebViewFeatureInternal.java */
/* JADX INFO: loaded from: classes.dex */
public final class O {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final F.b f1625A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final F.a f1626B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final AbstractC0287a.h f1627C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final a f1628D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final AbstractC0287a.d f1629E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final AbstractC0287a.d f1630F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final AbstractC0287a.h f1631G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final AbstractC0287a.d f1632H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final AbstractC0287a.d f1633I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final AbstractC0287a.d f1634J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final AbstractC0287a.d f1635K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final AbstractC0287a.d f1636L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final AbstractC0287a.d f1637M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final AbstractC0287a.d f1638N;
    public static final AbstractC0287a.d O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC0287a.b f1639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC0287a.e f1640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC0287a.c f1641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC0287a.f f1642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AbstractC0287a.f f1643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC0287a.f f1644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AbstractC0287a.f f1645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AbstractC0287a.c f1646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AbstractC0287a.c f1647i;
    public static final AbstractC0287a.c j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AbstractC0287a.c f1648k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AbstractC0287a.c f1649l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AbstractC0287a.c f1650m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AbstractC0287a.b f1651n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AbstractC0287a.b f1652o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AbstractC0287a.f f1653p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AbstractC0287a.f f1654q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AbstractC0287a.f f1655r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AbstractC0287a.b f1656s;
    public static final AbstractC0287a.b t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final AbstractC0287a.d f1657u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final AbstractC0287a.b f1658v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final AbstractC0287a.b f1659w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final AbstractC0287a.b f1660x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final AbstractC0287a.h f1661y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final AbstractC0287a.g f1662z;

    /* JADX INFO: compiled from: WebViewFeatureInternal.java */
    public class a extends AbstractC0287a.i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Pattern f1663d;

        public a() {
            super("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
            this.f1663d = Pattern.compile("\\A\\d+");
        }

        @Override // B0.AbstractC0287a
        public final boolean c() {
            boolean zC = super.c();
            if (!zC || Build.VERSION.SDK_INT >= 29) {
                return zC;
            }
            Uri uri = A0.p.f1389a;
            PackageInfo packageInfoA = C0291e.a();
            if (packageInfoA == null) {
                return false;
            }
            Matcher matcher = this.f1663d.matcher(packageInfoA.versionName);
            return matcher.find() && Integer.parseInt(packageInfoA.versionName.substring(matcher.start(), matcher.end())) >= 105;
        }
    }

    /* JADX INFO: compiled from: WebViewFeatureInternal.java */
    public class b extends AbstractC0287a.d {
        @Override // B0.AbstractC0287a
        public final boolean c() {
            if (!super.c() || !p027d5.a.s("MULTI_PROCESS")) {
                return false;
            }
            Uri uri = A0.p.f1389a;
            if (O.f1630F.c()) {
                return P.b.f1665a.getStatics().isMultiProcessEnabled();
            }
            throw O.a();
        }
    }

    static {
        new AbstractC0287a.b("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");
        f1639a = new AbstractC0287a.b("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");
        f1640b = new AbstractC0287a.e("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");
        f1641c = new AbstractC0287a.c("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");
        f1642d = new AbstractC0287a.f("START_SAFE_BROWSING", "START_SAFE_BROWSING");
        new AbstractC0287a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");
        new AbstractC0287a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");
        f1643e = new AbstractC0287a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");
        f1644f = new AbstractC0287a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");
        f1645g = new AbstractC0287a.f("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");
        f1646h = new AbstractC0287a.c("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");
        f1647i = new AbstractC0287a.c("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");
        j = new AbstractC0287a.c("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");
        f1648k = new AbstractC0287a.c("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");
        f1649l = new AbstractC0287a.c("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");
        new AbstractC0287a.c("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");
        new AbstractC0287a.b("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");
        new AbstractC0287a.b("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");
        new AbstractC0287a.c("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");
        new AbstractC0287a.f("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");
        f1650m = new AbstractC0287a.c("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");
        f1651n = new AbstractC0287a.b("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");
        f1652o = new AbstractC0287a.b("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");
        f1653p = new AbstractC0287a.f("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");
        f1654q = new AbstractC0287a.f("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");
        f1655r = new AbstractC0287a.f("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
        f1656s = new AbstractC0287a.b("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
        t = new AbstractC0287a.b("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
        f1657u = new AbstractC0287a.d("WEB_MESSAGE_ARRAY_BUFFER", "WEB_MESSAGE_ARRAY_BUFFER");
        f1658v = new AbstractC0287a.b("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
        f1659w = new AbstractC0287a.b("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
        f1660x = new AbstractC0287a.b("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
        new AbstractC0287a.b("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
        new AbstractC0287a.e("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
        new AbstractC0287a.e("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
        new AbstractC0287a.h("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
        f1661y = new AbstractC0287a.h("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
        f1662z = new AbstractC0287a.g("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
        f1625A = new F.b("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");
        f1626B = new F.a("STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS", "STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH");
        f1627C = new AbstractC0287a.h("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
        f1628D = new a();
        f1629E = new AbstractC0287a.d("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
        f1630F = new AbstractC0287a.d("MULTI_PROCESS", "MULTI_PROCESS_QUERY");
        f1631G = new AbstractC0287a.h("FORCE_DARK", "FORCE_DARK");
        f1632H = new AbstractC0287a.d("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
        f1633I = new AbstractC0287a.d("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
        f1634J = new AbstractC0287a.d("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
        f1635K = new AbstractC0287a.d("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
        f1636L = new AbstractC0287a.d("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
        f1637M = new AbstractC0287a.d("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");
        f1638N = new AbstractC0287a.d("GET_COOKIE_INFO", "GET_COOKIE_INFO");
        O = new AbstractC0287a.d("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");
        new AbstractC0287a.d("USER_AGENT_METADATA", "USER_AGENT_METADATA");
        new b("MULTI_PROFILE", "MULTI_PROFILE");
        new AbstractC0287a.d("ATTRIBUTION_REGISTRATION_BEHAVIOR", "ATTRIBUTION_BEHAVIOR");
        new AbstractC0287a.d("WEBVIEW_MEDIA_INTEGRITY_API_STATUS", "WEBVIEW_INTEGRITY_API_STATUS");
        new AbstractC0287a.d("MUTE_AUDIO", "MUTE_AUDIO");
    }

    public static UnsupportedOperationException a() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }
}
