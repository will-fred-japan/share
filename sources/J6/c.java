package J6;

import android.content.Context;
import android.util.Log;
import com.bytedance.starburst.vad.StarburstVad;
import com.google.gson.Gson;
import com.starburst.sdk.api.VadConfig;
import com.starburst.sdk.common.okhttp.OkHttpUtils;
import com.starburst.sdk.common.okhttp.log.LoggerInterceptor;
import com.starburst.sdk.core.AiAgentSdk;
import com.starburst.sdk.core.asr.AsrBtDataManager;
import com.starburst.sdk.core.asr.HttpRequestManager;
import com.starburst.sdk.core.auth.AuthApiImpl;
import com.starburst.sdk.core.auth.AuthInfoManager;
import com.starburst.sdk.core.device.bt.BleMsgManager;
import com.starburst.sdk.core.feature.FeatureIds;
import com.starburst.sdk.core.feature.TcFeatureManager;
import com.starburst.sdk.core.feed.a2dp.SecondA2dpManager;
import com.starburst.sdk.core.feed.bt.AsrToAigcBtDataManager;
import com.starburst.sdk.core.feed.ws.AsrWsRequestFeed;
import com.starburst.sdk.core.image.BaseImageConverter;
import com.starburst.sdk.core.image.DefaultImageConverter;
import com.starburst.sdk.core.network.NetworkConstants;
import com.starburst.sdk.core.ntp.NtpTimeSync;
import com.starburst.sdk.core.opus.BaseOpusEncoder;
import com.starburst.sdk.core.recorder.BaseAudioRecorder;
import com.starburst.sdk.core.recorder.StarburstAudioRecorder;
import com.starburst.sdk.core.voicechat.VoiceChatBtDataManager;
import com.starburst.sdk.utils.h;
import com.starburst.sdk.utils.j;
import com.starburst.sdk.utils.k;
import defpackage.f;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static c f2728h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f2730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseOpusEncoder f2731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DefaultImageConverter f2732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecondA2dpManager f2733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile VadConfig f2734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f2735g = new k();

    public static c f() {
        if (f2728h == null) {
            synchronized (c.class) {
                try {
                    if (f2728h == null) {
                        f2728h = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f2728h;
    }

    public static void l(HashMap map) {
        j.f("StarBurstSdk", "startDebugWithConfig ==> " + new Gson().toJson(map));
        k.f16469a = map;
    }

    public final void a() {
        if (this.f2729a == null) {
            return;
        }
        VadConfig vadConfig = this.f2734f == null ? new VadConfig() : new VadConfig(this.f2734f);
        BaseAudioRecorder baseAudioRecorderB = b();
        if (baseAudioRecorderB != null) {
            baseAudioRecorderB.setVadDetectionConfig(vadConfig.silenceThreshold, vadConfig.energyThreshold, vadConfig.minSpeechMs, vadConfig.silenceDetectMs, vadConfig.resetSilenceMs, vadConfig.endSilenceMs, vadConfig.longSpeechEndSilenceMs);
        }
    }

    public final BaseAudioRecorder b() {
        try {
            if (!TcFeatureManager.getInstance().checkFeature(FeatureIds.FEATURE_CUSTOM_AUDIO).isAllowed()) {
                return StarburstAudioRecorder.getInstance(this.f2729a);
            }
        } catch (Throwable unused) {
        }
        return StarburstAudioRecorder.getInstance(this.f2729a);
    }

    public final b c() {
        Context context = this.f2729a;
        b bVar = b.f2694o;
        bVar.f2696a = context;
        return bVar;
    }

    public final boolean d() {
        this.f2735g.getClass();
        return k.f16472d;
    }

    public final BaseImageConverter e() {
        j.f("StarBurstSdk", "getImageConverter ==> " + this.f2732d);
        if (this.f2732d == null) {
            j.f("StarBurstSdk", "getImageConverter ==> default, Please setImageConverter first");
            this.f2732d = new DefaultImageConverter();
        }
        return this.f2732d;
    }

    public final Context g() {
        if (this.f2729a == null) {
            Log.e("StarBurstSdk", "SDK not initialized, call init() first.");
        }
        return this.f2729a;
    }

    public final void h(Context context, String str, boolean z8) {
        j.f(b.f2695p, f.d(b.f2693n.incrementAndGet(), "SDK init generation="));
        this.f2729a = context;
        String str2 = AuthApiImpl.appId;
        if (str2 != null && !str2.equals(str)) {
            AuthInfoManager.clearAuthInfo(context);
        }
        AuthApiImpl.appId = str;
        j.d(z8, z8);
        NetworkConstants.setCustomDomainEnabled(z8);
        j.f("StarBurstSdk", "init " + z8 + ", SDK Version: 6.3.3-2026101208");
        NtpTimeSync.syncTime();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpUtils.initClient(builder.connectTimeout(10000L, timeUnit).readTimeout(10000L, timeUnit).writeTimeout(60000L, timeUnit).addInterceptor(new LoggerInterceptor("StarBurstSdk", true)).build());
        h.a().f16450a = context;
        AsrWsRequestFeed.getInstance().init(context);
        AiAgentSdk.getInstance().init(context, z8, z8);
        AsrBtDataManager.getInstance().init();
        AsrToAigcBtDataManager.getInstance().init();
        HttpRequestManager.getInstance().init(context);
        VoiceChatBtDataManager.getInstance().init();
        this.f2730b = false;
        try {
            int i9 = StarburstVad.SAMPLE_RATE;
            a();
            this.f2730b = true;
            j.m("StarBurstSdk", "Starburst VAD library ready");
        } catch (Throwable th) {
            j.m("StarBurstSdk", "Starburst VAD library unavailable: " + th.getMessage());
        }
    }

    public final void i(boolean z8) {
        this.f2735g.getClass();
        k.f16473e = z8;
    }

    public final void j(boolean z8) {
        this.f2735g.getClass();
        k.f16474f = z8;
    }

    public final void k(boolean z8) {
        j.f("StarBurstSdk", "setEnableTextSync ==> " + z8);
        this.f2735g.getClass();
        k.f16472d = z8;
        BleMsgManager.getInstance();
        BleMsgManager.FEATURE_IS_SYNC_TEXT = z8;
    }
}
