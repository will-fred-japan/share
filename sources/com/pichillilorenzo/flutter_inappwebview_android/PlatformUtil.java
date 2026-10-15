package com.pichillilorenzo.flutter_inappwebview_android;

import android.os.Build;
import com.huawei.hms.framework.common.BundleUtil;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import p096m7.j;
import p096m7.l;

/* JADX INFO: loaded from: classes.dex */
public class PlatformUtil extends ChannelDelegateImpl {
    protected static final String LOG_TAG = "PlatformUtil";
    public static final String METHOD_CHANNEL_NAME = "com.pichillilorenzo/flutter_inappwebview_platformutil";
    public InAppWebViewFlutterPlugin plugin;

    public PlatformUtil(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(new l(inAppWebViewFlutterPlugin.messenger, METHOD_CHANNEL_NAME));
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public static String formatDate(long j, String str, Locale locale, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(new Date(j));
    }

    public static Locale getLocaleFromString(String str) {
        if (str == null) {
            return Locale.US;
        }
        String[] strArrSplit = str.split(BundleUtil.UNDERLINE_TAG);
        return new Locale(strArrSplit[0], strArrSplit.length > 1 ? strArrSplit[1] : "", strArrSplit.length > 2 ? strArrSplit[2] : "");
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.plugin = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, m7.l.c
    public void onMethodCall(j jVar, l.d dVar) {
        String str = jVar.f20496a;
        str.getClass();
        if (!str.equals("formatDate")) {
            if (str.equals("getSystemVersion")) {
                dVar.success(String.valueOf(Build.VERSION.SDK_INT));
                return;
            } else {
                dVar.notImplemented();
                return;
            }
        }
        long jLongValue = ((Long) jVar.a("date")).longValue();
        String str2 = (String) jVar.a("format");
        Locale localeFromString = getLocaleFromString((String) jVar.a("locale"));
        String str3 = (String) jVar.a("timezone");
        if (str3 == null) {
            str3 = "UTC";
        }
        dVar.success(formatDate(jLongValue, str2, localeFromString, TimeZone.getTimeZone(str3)));
    }
}
