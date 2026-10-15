package R0;

import android.app.Application;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.agconnect.exception.AGCServerException;
import com.huawei.hms.adapter.internal.CommonCode;
import com.starburst.sdk.core.feed.FeedManager;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DisplayLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class j extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Application f3950d;

    public j(Application application) {
        super(true, false);
        this.f3950d = application;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    @Override // R0.c
    public final boolean a(JSONObject jSONObject) throws JSONException {
        String str;
        int i9;
        Application application = this.f3950d;
        int i10 = application.getResources().getDisplayMetrics().densityDpi;
        switch (i10) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case FeedManager.FILE_TYPE_INT_FEED_LOCAL_STATE_JSON /* 260 */:
            case 280:
            case 300:
            case 320:
                str = "xhdpi";
                break;
            case 340:
            case 360:
            case AGCServerException.AUTHENTICATION_INVALID /* 400 */:
            case 420:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case 560:
            case 640:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i10);
        jSONObject.put("display_density", str);
        WindowManager windowManager = (WindowManager) application.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int defaultDisplay = windowManager.getDefaultDisplay();
        try {
            try {
                if (defaultDisplay == 0) {
                    DisplayMetrics displayMetrics2 = application.getResources().getDisplayMetrics();
                    if (displayMetrics2 != null) {
                        int i11 = displayMetrics2.widthPixels;
                        i9 = displayMetrics2.heightPixels;
                        defaultDisplay = i11;
                    } else {
                        i9 = 0;
                        defaultDisplay = 0;
                    }
                    int[] iArr = {defaultDisplay, i9};
                    jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, iArr[1] + "x" + iArr[0]);
                    return true;
                }
                defaultDisplay.getRealMetrics(displayMetrics);
                int i12 = displayMetrics.widthPixels;
                i9 = displayMetrics.heightPixels;
                defaultDisplay = i12;
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                i9 = 0;
            }
        } catch (Throwable th2) {
            th = th2;
            defaultDisplay = 0;
            th.printStackTrace();
            i9 = 0;
        }
        int[] iArr2 = {defaultDisplay, i9};
        jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, iArr2[1] + "x" + iArr2[0]);
        return true;
    }
}
