package cn.jiguang.commons.a;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushCollectControl;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class bj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<Integer> f9730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashSet<Integer> f9731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap<Integer, Boolean> f9732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f9733g;

    private bj() {
        this.f9730d = new HashSet<>();
        this.f9731e = new HashSet<>();
        this.f9732f = new HashMap<>();
        this.f9733g = new AtomicInteger(0);
        this.f9727a = b();
        this.f9728b = g();
        this.f9729c = f();
        ee.a("SDKConfigManager", "init - isJP=" + this.f9727a + " isJO=" + this.f9728b + " isJV=" + this.f9729c);
        int[] iArr = {2000, 2001, 2002, 2003, INotificationPermissionCallback.CODE_FREQUENT, INotificationPermissionCallback.CODE_UNSUPPORT, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013};
        for (int i9 = 0; i9 < 14; i9++) {
            this.f9732f.put(Integer.valueOf(iArr[i9]), Boolean.valueOf(this.f9728b));
        }
        int[] iArr2 = {1000, 1001, MTCommonConstants.MainWhat.ON_NETWORK_CONNECTED, 1005, 1006, MTCommonConstants.MainWhat.ON_NETWORK_CHANGED, MTCommonConstants.MainWhat.ON_LIFECYCLE_CHANGED, JPushCollectControl.IMSI, 1012, MTCommonConstants.MainWhat.ON_ACTIVITY_PAUSED};
        for (int i10 = 0; i10 < 10; i10++) {
            this.f9732f.put(Integer.valueOf(iArr2[i10]), Boolean.valueOf(this.f9727a));
        }
        int[] iArr3 = {BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT, 3001, 3002, 3003, 3004, 3005, 3006, MTPushConstants.PlatformNode.CODE_UPLOAD_TOKEN_SUCCESS, MTPushConstants.PlatformNode.CODE_GET_TOKEN_SUCCESS, 3009, 3010, MTPushConstants.MainWhat.TAG_ADD, MTPushConstants.MainWhat.TAG_DELETE, MTPushConstants.MainWhat.TAG_UPDATE, MTPushConstants.MainWhat.TAG_QUERY, MTPushConstants.MainWhat.TAG_DELETE_ALL, MTPushConstants.MainWhat.TAG_QUERY_ALL, MTPushConstants.MainWhat.ALIAS_SET};
        for (int i11 = 0; i11 < 18; i11++) {
            this.f9732f.put(Integer.valueOf(iArr3[i11]), Boolean.valueOf(this.f9729c));
        }
    }

    public static bj a() {
        return bk.f9734a;
    }

    private boolean f() {
        if ((this.f9733g.get() & 64) != 0) {
            return this.f9729c;
        }
        this.f9733g.addAndGet(64);
        try {
            Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
            this.f9729c = true;
            return true;
        } catch (ClassNotFoundException unused) {
            this.f9729c = false;
            return false;
        }
    }

    private boolean g() {
        if ((this.f9733g.get() & OpusCodecConfig.APPLICATION_VOIP) != 0) {
            return this.f9728b;
        }
        this.f9733g.addAndGet(OpusCodecConfig.APPLICATION_VOIP);
        try {
            Class.forName("cn.jiguang.joperate.api.JOperateInterface");
            this.f9728b = true;
            return true;
        } catch (ClassNotFoundException unused) {
            this.f9728b = false;
            return false;
        }
    }

    public final boolean b() {
        if ((this.f9733g.get() & 1) != 0) {
            return this.f9727a;
        }
        this.f9733g.addAndGet(1);
        try {
            String str = JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX;
            this.f9727a = true;
            return true;
        } catch (ClassNotFoundException unused) {
            this.f9727a = false;
            return false;
        }
    }

    public final synchronized void c() {
        try {
            this.f9730d.clear();
            this.f9731e.clear();
            for (Map.Entry<Integer, Boolean> entry : this.f9732f.entrySet()) {
                if (entry.getValue().booleanValue()) {
                    this.f9730d.add(entry.getKey());
                }
            }
            ee.a("SDKConfigManager", "init default - mAllConfigDisable=" + this.f9731e);
            ee.a("SDKConfigManager", "init default -- mAllConfigEnable=" + this.f9730d);
        } catch (Throwable th) {
            ee.e("SDKConfigManager", "initDefaultConfig failed: " + th.getMessage());
        }
    }

    public final HashSet<Integer> d() {
        return this.f9730d;
    }

    public final HashSet<Integer> e() {
        return this.f9731e;
    }

    public /* synthetic */ bj(byte b9) {
        this();
    }

    public final boolean a(int i9) {
        Boolean bool = this.f9732f.get(Integer.valueOf(i9));
        return bool != null && bool.booleanValue();
    }

    public final synchronized boolean b(Integer num) {
        if (this.f9730d.contains(num)) {
            return false;
        }
        this.f9730d.add(num);
        return true;
    }

    public final synchronized boolean c(Integer num) {
        return this.f9731e.remove(num);
    }

    public final synchronized boolean d(Integer num) {
        if (this.f9731e.contains(num)) {
            return false;
        }
        this.f9731e.add(num);
        return true;
    }

    public final synchronized boolean a(Integer num) {
        return this.f9730d.remove(num);
    }
}
