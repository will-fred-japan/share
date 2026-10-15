package cn.jpush.android.api;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.ad.b;
import cn.jpush.android.ad.h;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.webview.bridge.HostJsScope;
import cn.jpush.android.webview.bridge.a;
import com.starburst.sdk.req.GuiControlRequest;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class SystemAlertHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11211a = 400;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f11212b = 600;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ImageButton f11213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WindowManager f11214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static WebView f11215e;

    private static DisplayMetrics a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            return null;
        }
        Logger.d("SystemAlertHelper", "width : " + displayMetrics.widthPixels);
        Logger.d("SystemAlertHelper", "height : " + displayMetrics.heightPixels);
        Logger.d("SystemAlertHelper", "density : " + displayMetrics.density);
        Logger.d("SystemAlertHelper", "densityDpi : " + displayMetrics.densityDpi);
        Logger.d("SystemAlertHelper", "xdpi : " + displayMetrics.xdpi);
        Logger.d("SystemAlertHelper", "ydpi : " + displayMetrics.ydpi);
        return displayMetrics;
    }

    public static void close() {
        WindowManager windowManager = f11214d;
        if (windowManager == null) {
            return;
        }
        try {
            WebView webView = f11215e;
            if (webView != null) {
                windowManager.removeView(webView);
            }
            ImageButton imageButton = f11213c;
            if (imageButton != null) {
                f11214d.removeView(imageButton);
            }
            f11214d = null;
            f11215e = null;
            f11213c = null;
        } catch (Throwable unused) {
            f11214d = null;
            f11215e = null;
            f11213c = null;
        }
    }

    public static Bitmap getImageFromAssetsFile(Context context, String str) {
        Bitmap bitmapDecodeStream = null;
        try {
            InputStream inputStreamOpen = context.getResources().getAssets().open(str);
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
            inputStreamOpen.close();
            return bitmapDecodeStream;
        } catch (IOException unused) {
            return bitmapDecodeStream;
        }
    }

    public static int getWindowHeight() {
        return f11212b;
    }

    public static int getWindowWidth() {
        return f11211a;
    }

    public static void startActivityByName(WebView webView, String str, String str2) {
        Context appContext;
        Logger.d("SystemAlertHelper", "action --- startActivityByName--------activityName : " + str + "----- params : " + str2);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("SystemAlertHelper", "The activity name is null or empty, Give up..");
        }
        if (webView == null || (appContext = JPushConstants.getAppContext(webView.getContext())) == null) {
            return;
        }
        try {
            Intent intent = new Intent(webView.getContext(), Class.forName(str));
            intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
            intent.setFlags(268435456);
            appContext.startActivity(intent);
            close();
        } catch (Exception unused) {
            Logger.ee("SystemAlertHelper", "The activity name is invalid, Give up..");
        }
    }

    public static void systemAlert() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, WindowManager windowManager, WebView webView, ImageButton imageButton) {
        int i9;
        int i10;
        DisplayMetrics displayMetricsA = a(context);
        if (displayMetricsA != null) {
            int i11 = (displayMetricsA.widthPixels * 3) / 4;
            f11211a = i11;
            int i12 = displayMetricsA.heightPixels / 2;
            f11212b = i12;
            i9 = i11 / 2;
            i10 = -(i12 / 2);
        } else {
            i9 = 200;
            i10 = -300;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.gravity = 17;
        layoutParams.type = 2003;
        layoutParams.flags |= 552;
        layoutParams.width = f11211a;
        layoutParams.height = f11212b;
        layoutParams.x = -1;
        layoutParams.y = -1;
        windowManager.addView(webView, layoutParams);
        imageButton.setBackgroundColor(context.getResources().getColor(R.color.transparent));
        imageButton.setImageDrawable(context.getResources().getDrawable(context.getResources().getIdentifier("jpush_close", "drawable", context.getPackageName())));
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.y = i10;
        layoutParams.x = i9;
        windowManager.addView(imageButton, layoutParams);
    }

    public static void systemAlert(final Context context, final d dVar) {
        new Handler(Looper.getMainLooper()).post(new h("SystemAlertHelper#systemAlert") { // from class: cn.jpush.android.api.SystemAlertHelper.1
            @Override // cn.jpush.android.ad.h
            @SuppressLint({"NewApi"})
            public void a() {
                String str = dVar.aa;
                if (TextUtils.isEmpty(str)) {
                    Logger.e("SystemAlertHelper", " not Rich Notification");
                    return;
                }
                WindowManager unused = SystemAlertHelper.f11214d = (WindowManager) context.getSystemService("window");
                WebView unused2 = SystemAlertHelper.f11215e = new WebView(context);
                ImageButton unused3 = SystemAlertHelper.f11213c = new ImageButton(context);
                SystemAlertHelper.b(context, SystemAlertHelper.f11214d, SystemAlertHelper.f11215e, SystemAlertHelper.f11213c);
                SystemAlertHelper.f11215e.setHorizontalScrollBarEnabled(false);
                SystemAlertHelper.f11215e.setVerticalScrollBarEnabled(false);
                SystemAlertHelper.f11215e.setScrollbarFadingEnabled(true);
                SystemAlertHelper.f11215e.setScrollBarStyle(33554432);
                b.c(SystemAlertHelper.f11215e.getSettings());
                b.a(SystemAlertHelper.f11215e);
                SystemAlertHelper.f11215e.setWebChromeClient(new a("JPushWeb", HostJsScope.class, null, null));
                SystemAlertHelper.f11215e.setWebViewClient(new cn.jpush.android.ui.a(dVar, context));
                if (!TextUtils.isEmpty(str) && str.startsWith(GuiControlRequest.IMAGE_TYPE_HTTP)) {
                    SystemAlertHelper.f11215e.loadUrl(str);
                }
                SystemAlertHelper.f11213c.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.api.SystemAlertHelper.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SystemAlertHelper.close();
                    }
                });
            }
        });
    }
}
