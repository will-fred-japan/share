package cn.jpush.android.webview.bridge;

import A.f;
import W5.e;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f11757d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Activity> f11758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final cn.jpush.android.d.d f11759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11760c;

    public d(Context context, cn.jpush.android.d.d dVar) {
        this.f11760c = false;
        this.f11758a = new WeakReference<>((Activity) context);
        this.f11759b = dVar;
        this.f11760c = false;
    }

    private void a(String str) {
        long j;
        try {
            try {
                j = Long.parseLong(str);
            } catch (Exception unused) {
                Logger.e("WebViewHelper", "Invalid actionId from Web - " + str);
                j = 1100;
            }
            cn.jpush.android.helper.d.a(this.f11759b.f11320d, j, JPushConstants.mApplicationContext);
        } catch (Throwable unused2) {
        }
    }

    @JavascriptInterface
    public void click(String str, String str2, String str3) {
        StringBuilder sbJ = f.j("Web callback:click - actionId:", str, ", shouldClose:", str2, ", shouldCancelNotification:");
        sbJ.append(str3);
        Logger.d("WebViewHelper", sbJ.toString());
        try {
            a(str);
            boolean z8 = Boolean.parseBoolean(str2);
            if (Boolean.parseBoolean(str3)) {
                cn.jpush.android.x.b.c(JPushConstants.mApplicationContext, this.f11759b);
            }
            if (!z8 || this.f11758a.get() == null) {
                return;
            }
            this.f11758a.get().finish();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void close() {
        if (this.f11758a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:close");
            this.f11758a.get().finish();
        }
    }

    @JavascriptInterface
    public void download(String str) {
        if (this.f11758a.get() == null) {
            return;
        }
        e.r("Web callback:download - ", str, "WebViewHelper");
    }

    @JavascriptInterface
    public String getDevInfo() {
        return "";
    }

    @JavascriptInterface
    public String getNotificationInfo() {
        return "";
    }

    @JavascriptInterface
    public String getTplData() {
        if (this.f11759b == null) {
            Logger.w("WebViewHelper", "[getTplData] entity is null");
            return "";
        }
        Logger.d("WebViewHelper", "[getTplData] js get template data: " + this.f11759b.bm);
        return this.f11759b.bm;
    }

    @JavascriptInterface
    public String getTplExtraData() {
        return "";
    }

    @JavascriptInterface
    public void inAppClick(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Logger.d("WebViewHelper", "h5 click, actionType: " + jSONObject.optInt("actionType") + ", actionKey: " + jSONObject.optString(RemoteMessageConst.MessageBody.PARAM) + ", param: " + str);
            cn.jpush.android.o.a.a().d(JPushConstants.mApplicationContext, this.f11759b);
        } catch (Throwable th) {
            W5.f.r(th, new StringBuilder("h5 click failed, "), "WebViewHelper");
        }
    }

    @JavascriptInterface
    public void onLoadCallback(String str) {
        try {
            Logger.d("WebViewHelper", "onLoadCallback : " + str);
            if (this.f11760c) {
                Logger.d("WebViewHelper", "js callback already, param: " + str);
                return;
            }
            boolean z8 = true;
            this.f11760c = true;
            Context applicationContext = JPushConstants.mApplicationContext;
            if (applicationContext == null && this.f11758a.get() != null) {
                applicationContext = this.f11758a.get().getApplicationContext();
            }
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(HiAnalyticsConstant.HaKey.BI_KEY_RESULT);
            String strOptString = jSONObject.optString("msg");
            if (iOptInt != 0) {
                Logger.ww("WebViewHelper", "msg tpl load failed, code: " + iOptInt + ", errMsg: " + strOptString);
            }
            cn.jpush.android.o.a aVarA = cn.jpush.android.o.a.a();
            cn.jpush.android.d.d dVar = this.f11759b;
            if (iOptInt != 0) {
                z8 = false;
            }
            aVarA.a(applicationContext, dVar, z8);
        } catch (Throwable th) {
            W5.f.r(th, new StringBuilder("[onLoadCallback] parse param error. "), "WebViewHelper");
        }
    }

    @JavascriptInterface
    public void showTitleBar() {
        try {
            if (this.f11758a.get() == null || !(this.f11758a.get() instanceof PushActivity)) {
                return;
            }
            ((PushActivity) this.f11758a.get()).showTitleBar();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void showToast(String str) {
        if (this.f11758a.get() != null) {
            e.r("Web callback:showToast - ", str, "WebViewHelper");
            Toast.makeText(this.f11758a.get(), str, 1).show();
        }
    }

    @JavascriptInterface
    public void startActivityByIntent(String str, String str2) {
        Context context = JPushConstants.mApplicationContext;
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            intent.putExtra(JPushInterface.EXTRA_EXTRA, str2);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable unused) {
            Logger.ee("WebViewHelper", "Unhandle intent : " + str);
        }
    }

    @JavascriptInterface
    public void startActivityByName(String str, String str2) {
        e.r("activityName = ", str, "WebViewHelper");
        try {
            if (TextUtils.isEmpty(str)) {
                Logger.ee("WebViewHelper", "The activity name is null or empty, Give up..");
            }
            Context context = JPushConstants.mApplicationContext;
            if (context == null) {
                return;
            }
            try {
                Intent intent = new Intent(context, Class.forName(str));
                intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Exception unused) {
                Logger.ee("WebViewHelper", "The activity name is invalid, Give up..");
            }
        } catch (Throwable unused2) {
        }
    }

    @JavascriptInterface
    public void startMainActivity(String str) {
        Activity activity = this.f11758a.get();
        if (activity == null) {
            return;
        }
        try {
            activity.finish();
            cn.jpush.android.ad.b.b(activity, str);
        } catch (Exception unused) {
            Logger.ee("WebViewHelper", "startMainActivity failed");
        }
    }

    @JavascriptInterface
    public void startPushActivity(String str) {
        try {
            Logger.d("WebViewHelper", "[startPushActivity]:" + str + ",activity:" + this.f11758a.get());
            if (this.f11758a.get() == null || !(this.f11758a.get() instanceof PopWinActivity)) {
                return;
            }
            ((PopWinActivity) this.f11758a.get()).startPushActivity(str);
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void triggerNativeAction(String str) {
        this.f11758a.get();
    }

    @JavascriptInterface
    public void download(String str, String str2) {
        if (this.f11758a.get() == null) {
            return;
        }
        a(str);
        download(str2);
        cn.jpush.android.x.b.c(JPushConstants.mApplicationContext, this.f11759b);
        this.f11758a.get().finish();
    }

    @JavascriptInterface
    public void download(String str, String str2, String str3) {
        Logger.v("WebViewHelper", "msgType from web: " + str3);
        download(str, str2);
    }

    @JavascriptInterface
    public void executeMsgMessage(String str) {
    }

    @JavascriptInterface
    public void reportData(String str) {
    }

    @JavascriptInterface
    public void createShortcut(String str, String str2, String str3) {
    }
}
