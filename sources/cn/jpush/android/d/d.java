package cn.jpush.android.d;

import W5.f;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.ad.p;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.WakedResultReceiver;
import com.alibaba.fastjson.asm.Opcodes;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.mipush.sdk.Constants;
import java.io.LineNumberReader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements Serializable {
    private static HashMap<String, String> bZ = new HashMap<>();
    private static Map<String, String> ca = new HashMap();
    private static HashMap<String, String> cb = new HashMap<>();
    private static final long serialVersionUID = 8407025843324043625L;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f11292A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public String f11293B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public String f11294C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public String f11295D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f11296E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int f11297F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public String f11298G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public String f11299H;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public String f11302K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public String f11303L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public String f11304M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public String f11305N;
    public String O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public String f11306P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public int f11307Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public String f11308R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public String f11309S;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public int f11311U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public String f11312V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public String f11313W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public int f11314X;
    public int aA;
    public String aa;
    public String ab;
    public String ac;
    public int ad;
    public int af;
    public Integer ak;
    public String al;
    public long am;
    public String an;
    public boolean ao;
    public boolean ap;
    public long aq;
    public String at;
    public String au;
    public String av;
    public String aw;
    public String ax;
    public String ay;
    public int az;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f11318b;
    public String bB;
    public int bE;
    public int bF;
    public int bG;
    public String bK;
    public int bN;
    public int bO;
    public long bP;
    public long bQ;
    public long bR;
    public long bS;
    public String bT;
    public String bU;
    public String bV;
    public JSONObject bW;
    public JSONObject bX;
    public JSONArray bY;
    public String bi;
    public int bu;
    public int bv;
    public boolean bw;
    public boolean bx;
    public String by;
    public String bz;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11325i;
    public int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11326k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11327l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f11329n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f11330o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f11331p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f11332q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f11333r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f11334s;
    public boolean t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f11335u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f11336v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f11337w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public JSONArray f11338x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f11339y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f11340z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11317a = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f11328m = 0;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f11300I = -1;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f11301J = "";

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f11310T = 0;

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    public boolean f11315Y = false;

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    public boolean f11316Z = false;
    public int ae = 0;
    public ArrayList<String> ag = new ArrayList<>();
    public String ah = "";
    public String ai = "";
    public byte aj = 0;
    public double ar = 200.0d;
    public double as = 200.0d;
    public String aB = "";
    public String aC = "";
    public String aD = "";
    public String aE = "";
    public String aF = "";
    public int aG = 1;
    public int aH = 2;
    public int aI = 0;
    public int aJ = 0;
    public int aK = 0;
    public int aL = 0;
    public int aM = 1;
    public int aN = 0;
    public String aO = "";
    public int aP = 0;
    public long aQ = 0;
    public int aR = 0;
    public int aS = 0;
    public int aT = 0;
    public int aU = 1;
    public int aV = 1;
    public String aW = "#FFFFFFFF";
    public String aX = "#FF000000";
    public String aY = "#FF000000";
    public int aZ = 14;
    public int ba = 14;
    public int bb = 9;
    public int bc = 5;
    public float bd = 1.0f;
    public float be = 1.0f;
    public String bf = "";
    public int bg = 2;
    public int bh = 2;
    public String bj = "";
    public String bk = "";
    public float bl = 0.6f;
    public String bm = "";
    public String bn = "";
    public ArrayList<String> bo = new ArrayList<>();
    public int bp = 0;
    public int bq = Opcodes.GETFIELD;
    public int br = 0;
    public int bs = 0;
    public String bt = "";
    public String bA = "";
    public String bC = "";
    public ArrayList<Float> bD = new ArrayList<>();
    public int bH = 0;
    public int bI = 0;
    public float bJ = -1.0f;
    public int bL = 1;
    public int bM = 1;

    public static class a implements Serializable {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte f11342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11343c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11344d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f11345e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f11346f;

        public static a a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return a(new JSONObject(str));
            } catch (Throwable unused) {
                return null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CustomButton{msgId='");
            sb.append(this.f11341a);
            sb.append("', platform=");
            sb.append((int) this.f11342b);
            sb.append(", name='");
            sb.append(this.f11343c);
            sb.append("', actionType=");
            sb.append(this.f11344d);
            sb.append(", action='");
            sb.append(this.f11345e);
            sb.append("', data='");
            return A.a.j(sb, this.f11346f, "'}");
        }

        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.f11341a = jSONObject.optString("msg_id", "");
            aVar.f11342b = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE, 0);
            aVar.f11343c = jSONObject.optString(MTCommonConstants.Network.KEY_NAME, "");
            aVar.f11344d = jSONObject.optInt("action_type", 0);
            aVar.f11345e = jSONObject.optString("action", "");
            aVar.f11346f = jSONObject.optString("data", "");
            return aVar;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg_id", this.f11341a);
                jSONObject.put(JThirdPlatFormInterface.KEY_ROM_TYPE, (int) this.f11342b);
                jSONObject.put(MTCommonConstants.Network.KEY_NAME, this.f11343c);
                jSONObject.put("action_type", this.f11344d);
                jSONObject.put("action", this.f11345e);
                jSONObject.put("data", this.f11346f);
                return jSONObject;
            } catch (Exception e9) {
                Logger.e("PushEntity", "CustomButton toJSON error: " + e9.getMessage());
                return jSONObject;
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Map<String, String> f11347a;

        static {
            HashMap map = new HashMap();
            f11347a = map;
            map.put("google", "fc");
            map.put(MTPushConstants.Manufacturer.HUAWEI, "hw");
            map.put(MTPushConstants.Manufacturer.HONOR, "hn");
            map.put(MTPushConstants.Manufacturer.MEIZU, "mz");
            map.put(MTPushConstants.Manufacturer.VIVO, "vi");
            map.put(MTPushConstants.Manufacturer.OPPO, "op");
            map.put(MTPushConstants.Manufacturer.REALME, "op");
            map.put(MTPushConstants.Manufacturer.ONEPLUS, "op");
            map.put(MTPushConstants.Manufacturer.XIAOMI, "xm");
            map.put(MTPushConstants.Manufacturer.BLACKSHARK, "xm");
        }

        public static int a(JSONObject jSONObject) {
            int iB;
            int iOptInt = jSONObject.optInt("n_priority", 0);
            int iC = c(jSONObject);
            return (-1 != iC && iOptInt > (iB = cn.jpush.android.x.a.b(iC))) ? iB : iOptInt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int c(JSONObject jSONObject) {
            String str;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("n_importance");
            if (jSONObjectOptJSONObject == null || (str = Build.MANUFACTURER) == null) {
                return -1;
            }
            String str2 = f11347a.get(str.toLowerCase());
            if (str2 != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt(str2, -1);
                Logger.d("PushEntity", "im_v:" + iOptInt);
                return iOptInt;
            }
            return -1;
        }
    }

    private static int b(int i9) {
        String strValueOf = String.valueOf(i9);
        if (strValueOf.startsWith("1")) {
            return 2;
        }
        if (strValueOf.startsWith(WakedResultReceiver.WAKE_TYPE_KEY)) {
            return 3;
        }
        return strValueOf.startsWith("3") ? 4 : -1;
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(str));
                String line = lineNumberReader.readLine();
                String line2 = lineNumberReader.readLine();
                if (line == null) {
                    Logger.e("PushEntity", "NO appId");
                    return null;
                }
                if (line2 == null) {
                    Logger.e("PushEntity", "NO senderId");
                    return null;
                }
                int length = line.length() + line2.length();
                int i9 = length + 2;
                if (str.length() <= length + 3) {
                    Logger.d("PushEntity", "No msgContent");
                    return null;
                }
                String strOptString = new JSONObject(str.substring(i9)).optString("_j_data_", "");
                Logger.d("PushEntity", "get jdata from push msg:" + strOptString);
                return strOptString;
            } catch (Throwable th) {
                Logger.d("PushEntity", "get jdata from push msg error:" + th.getMessage());
            }
        }
        return null;
    }

    public cn.jpush.android.d.a a() {
        return new cn.jpush.android.d.a(this);
    }

    public String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgType", this.f11317a);
            jSONObject.put("appId", this.f11318b);
            jSONObject.put("senderId", this.f11319c);
            jSONObject.put("messageId", this.f11320d);
            jSONObject.put("_j_data_", this.f11323g);
            jSONObject.put("notificationId", this.f11321e);
            jSONObject.put("messageType", this.f11322f);
            jSONObject.put("overrideMessageId", this.f11324h);
            jSONObject.put("messageVersion", this.j);
            jSONObject.put("notificationOnly", this.f11326k);
            jSONObject.put("notificationBuilderId", this.f11327l);
            jSONObject.put("notificationType", this.f11328m);
            jSONObject.put("message", this.f11330o);
            jSONObject.put("originalMessage", this.f11325i);
            jSONObject.put("contentType", this.f11331p);
            jSONObject.put("title", this.f11332q);
            jSONObject.put("extras", this.f11333r);
            jSONObject.put("type", this.f11334s);
            jSONObject.put("isFullScreen", this.t);
            jSONObject.put("notificationRemoveMode", this.f11335u);
            jSONObject.put("notificationTitle", this.f11337w);
            jSONObject.put("notificationBgColor", this.f11336v);
            jSONObject.put("notificationTargetEvent", this.f11338x);
            jSONObject.put("notificationAppName", this.f11339y);
            jSONObject.put("notificationContent", this.f11340z);
            jSONObject.put("notificationStyle", this.f11292A);
            jSONObject.put("notificationBigText", this.f11293B);
            jSONObject.put("notificationBigPicPath", this.f11294C);
            jSONObject.put("notificationInbox", this.f11295D);
            jSONObject.put("notificationPriority", this.f11296E);
            jSONObject.put("notificationImportance", this.f11297F);
            jSONObject.put("notificationCategory", this.f11298G);
            jSONObject.put("notificationExtra", this.f11299H);
            jSONObject.put("notificationAlertType", this.f11300I);
            jSONObject.put("notificationChannelId", this.f11301J);
            jSONObject.put("displayForeground", this.f11302K);
            jSONObject.put("source", this.f11303L);
            jSONObject.put("smallIcon", this.f11304M);
            jSONObject.put("largeIcon", this.f11305N);
            jSONObject.put("normalSmallIcon", this.O);
            jSONObject.put("deeplink", this.f11306P);
            jSONObject.put("failedAction", this.f11307Q);
            jSONObject.put("failedLink", this.f11308R);
            jSONObject.put("targetPkgName", this.f11309S);
            jSONObject.put("deeplinkBuilderId", this.f11311U);
            jSONObject.put("isRichPush", this.f11316Z);
            jSONObject.put("showUrl", this.aa);
            jSONObject.put("showTitle", this.ab);
            jSONObject.put("_webPagePath", this.ac);
            jSONObject.put("jumpMode", this.ad);
            jSONObject.put("richType", this.ae);
            jSONObject.put("showMode", this.af);
            jSONObject.put("showResourceList", p.a(this.ag, Constants.ACCEPT_TIME_SEPARATOR_SP));
            jSONObject.put("fromNum", this.ah);
            jSONObject.put("toNum", this.ai);
            jSONObject.put("platform", (int) this.aj);
            jSONObject.put("badgeAddNum", this.ak);
            jSONObject.put("geofenceid", this.al);
            jSONObject.put("radius", this.am);
            jSONObject.put("status", this.an);
            jSONObject.put("repeat", this.ao);
            jSONObject.put("hasShow", this.ap);
            jSONObject.put("expiration", this.aq);
            jSONObject.put(MTPushConstants.Geofence.KEY_LONGITUDE, this.ar);
            jSONObject.put(MTPushConstants.Geofence.KEY_LATITUDE, this.as);
            jSONObject.put("lastGeoStatus", this.at);
            jSONObject.put("developerArg0", this.au);
            jSONObject.put(RemoteMessageConst.Notification.SOUND, this.av);
            jSONObject.put("showBeginTime", this.aw);
            jSONObject.put("showEndTime", this.ax);
            jSONObject.put("isWmDeepLink", this.f11315Y);
            jSONObject.put("wxAppId", this.f11312V);
            jSONObject.put("miniOriginid", this.f11313W);
            jSONObject.put("miniType", this.f11314X);
            jSONObject.put("inAppMsgContent", this.aD);
            jSONObject.put("inAppIntent", this.aC);
            jSONObject.put("inAppMsgTitle", this.aE);
            jSONObject.put("inAppMsgContentBody", this.aF);
            jSONObject.put("target", this.bT);
            jSONObject.put("clickAction", this.bV);
            jSONObject.put("extras", this.f11333r);
            jSONObject.put("inAppMsgType", this.aG);
            jSONObject.put("inAppMsgShowType", this.aH);
            jSONObject.put("inAppMsgShowPos", this.aI);
            jSONObject.put("inAppMsgShowAniAction", this.aJ);
            jSONObject.put("inSupportNotifyAni", this.br);
            jSONObject.put("inSupportVibration", this.bs);
            jSONObject.put("inAppIcon", this.bt);
            jSONObject.put("inAppMsgDismissAniAction", this.aK);
            jSONObject.put("inAppMsgShowBackground", this.aL);
            jSONObject.put("inAppMsgAllowIntercept", this.aM);
            jSONObject.put("inAppMsgFilterMsg", this.aN);
            jSONObject.put("inAppMsgPicPath", this.aO);
            jSONObject.put("inAppMsgCountLmt", this.aP);
            jSONObject.put("inAppMsgGap", this.aQ);
            jSONObject.put("inAppMsgToUser", this.aR);
            jSONObject.put("inAppMsgDelayDisplayTime", this.aS);
            jSONObject.put("inAppMsgPageDelayDisplayTime", this.aT);
            jSONObject.put("inAppMsgReportPageName", this.aU);
            jSONObject.put("inAppUseSysAlert", this.aV);
            jSONObject.put("inAppMsgBackgroundColor", this.aW);
            jSONObject.put("inAppMsgTitleColor", this.aX);
            jSONObject.put("inAppMsgContentColor", this.aY);
            jSONObject.put("inAppMsgTitleSize", this.aZ);
            jSONObject.put("inAppMsgContentSize", this.ba);
            jSONObject.put("inAppMsgCircularSize", this.bb);
            jSONObject.put("inAppMsgShowTime", this.bc);
            jSONObject.put("inAppMsgShowElapseTime", this.bd);
            jSONObject.put("inAppMsgDismissElapseTime", this.be);
            jSONObject.put("inAppWebPageUrl", this.bf);
            jSONObject.put("inAppProtocolVer", this.bg);
            jSONObject.put("inAppSSPGap", this.bq);
            jSONObject.put("inAppCheckIntent", this.bh);
            jSONObject.put("inAppTplContent", this.bi);
            jSONObject.put("inAppTplId", this.bj);
            jSONObject.put("inAppTplUrl", this.bk);
            jSONObject.put("inAppMarginY", this.bl);
            jSONObject.put("inAppTplData", this.bm);
            jSONObject.put("inAppIntentActions", this.bn);
            jSONObject.put("inAppShowResList", p.a(this.bo, Constants.ACCEPT_TIME_SEPARATOR_SP));
            jSONObject.put("inAppType", this.bu);
            jSONObject.put("expired", this.bQ);
            jSONObject.put("notifyInAppCacheNumb", this.az);
            jSONObject.put("notifyInAppMsgType", this.aA);
            jSONObject.put("inAppPriority", this.bv);
            jSONObject.put("inAppIsDisplayDirect", this.bw);
            jSONObject.put("inAppFixed", this.bx);
            jSONObject.put("inAppBlackConf", this.by);
            jSONObject.put("inAppAnimatorConf", this.bz);
            jSONObject.put("inAppAdPosition", this.bA);
            jSONObject.put("inAppFragment", this.bB);
            jSONObject.put("inAppAdPosId", this.bC);
            jSONObject.put("inAppCoordinateType", this.bE);
            jSONObject.put("inAppWinWidth", this.bF);
            jSONObject.put("inAppWinHeight", this.bG);
            JSONArray jSONArray = new JSONArray();
            Iterator<Float> it = this.bD.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().floatValue());
            }
            jSONObject.put("inAppShowCoordinate", jSONArray);
            jSONObject.put("inAppPosMsgCountLmt", this.bH);
            jSONObject.put("inAppPosMsgGap", this.bI);
            jSONObject.put("inAppSizeRatio", this.bJ);
            jSONObject.put("sequenceId", this.aB);
            jSONObject.put("unionADExtras", this.bK);
            jSONObject.put("swipeDismiss", this.bL);
            jSONObject.put("adSspSvrVer", this.bM);
            jSONObject.put("inAppMsgStyle", this.bN);
            jSONObject.put("inAppMsgStyleGap", this.bO);
            jSONObject.put("customButtons", this.bY);
            jSONObject.put("target", this.bT);
            jSONObject.put("msgTime", this.bP);
            jSONObject.put("delay", this.bR);
            jSONObject.put(MTPushConstants.Geofence.KEY_INTERVAL, this.bS);
            jSONObject.put("inAppPriority", this.bv);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String toString() {
        return "PushEntity{appId='" + this.f11318b + "', senderId='" + this.f11319c + "', messageId='" + this.f11320d + "', jData='" + this.f11323g + "', notificationId=" + this.f11321e + ", messageType=" + this.f11322f + ", overrideMessageId='" + this.f11324h + "', originalMessage='" + this.f11325i + "', messageVersion=" + this.j + ", notificationOnly=" + this.f11326k + ", notificationBuilderId=" + this.f11327l + ", notificationType=" + this.f11328m + ", message='" + this.f11330o + "', contentType='" + this.f11331p + "', title='" + this.f11332q + "', extras='" + this.f11333r + "', type=" + this.f11334s + ", isFullScreen=" + this.t + ", notificationRemoveMode=" + this.f11335u + ", notificationTitle='" + this.f11337w + "', notificationBgColor='" + this.f11336v + "', notificationAppName='" + this.f11339y + "', notificationContent='" + this.f11340z + "', notificationStyle=" + this.f11292A + ", notificationBigText='" + this.f11293B + "', notificationBigPicPath='" + this.f11294C + "', notificationInbox='" + this.f11295D + "', notificationPriority=" + this.f11296E + ", notificationImportance=" + this.f11297F + ", notificationCategory='" + this.f11298G + "', notificationExtra='" + this.f11299H + "', notificationAlertType=" + this.f11300I + ", notificationChannelId='" + this.f11301J + "', displayForeground='" + this.f11302K + "', source='" + this.f11303L + "', smallIcon='" + this.f11304M + "', largeIcon='" + this.f11305N + "', normalSmallIcon='" + this.O + "', deeplink='" + this.f11306P + "', failedAction=" + this.f11307Q + ", failedLink='" + this.f11308R + "', targetPkgName='" + this.f11309S + "', deeplinkBuilderId=" + this.f11311U + ", isRichPush=" + this.f11316Z + ", showUrl='" + this.aa + "', showTitle='" + this.ab + "', _webPagePath='" + this.ac + "', jumpMode=" + this.ad + ", richType=" + this.ae + ", showMode=" + this.af + ", showResourceList=" + this.ag + ", fromNum='" + this.ah + "', toNum='" + this.ai + "', platform=" + ((int) this.aj) + ", badgeAddNum=" + this.ak + ", geofenceid='" + this.al + "', radius=" + this.am + ", status='" + this.an + "', repeat=" + this.ao + ", hasShow=" + this.ap + ", expiration=" + this.aq + ", longitude=" + this.ar + ", latitude=" + this.as + ", lastGeoStatus='" + this.at + "', developerArg0='" + this.au + "', sound='" + this.av + "', showBeginTime='" + this.aw + "', showEndTime='" + this.ax + "', inAppMsgContent='" + this.aD + "', inAppIntent='" + this.aC + ", inAppWebPageUrl = '" + this.bf + "', inAppProtocolVer = '" + this.bg + "', inAppSSPGap = '" + this.bq + "', inAppCheckIntent = '" + this.bh + "', inAppTplContent = '" + this.bi + "', inAppTplId = '" + this.bj + "', inAppTplUrl = '" + this.bk + "', inAppMarginY  = '" + this.bl + "', inAppTplData = '" + this.bm + "', inAppIntentActions = '" + this.bn + "', inAppType= '" + this.bu + "', notifyInAppEndTime= '" + this.ay + "', notifyInAppEndTime= '" + this.az + "', notifyInAppMsgType= '" + this.aA + "', inAppPriority= '" + this.bv + "', msgTime= '" + this.bP + "', inAppIsDisplayDirect= '" + this.bw + "', inAppFixed= '" + this.bx + "', inAppBlackConf= '" + this.by + "', inAppAnimatorConf= '" + this.bz + "', inAppAdPosition= '" + this.bA + "', inAppAdPosId= '" + this.bC + "', inAppFragment= '" + this.bB + "', inAppShowCoordinate= '" + this.bD + "', inAppCoordinateType= '" + this.bE + "', inAppWinWidth= '" + this.bF + "', inAppWinHeight= '" + this.bG + "', sequenceId= '" + this.aB + "', swipeDismiss= '" + this.bL + "', customButtons= '" + this.bY + "'}";
    }

    public static d a(Context context, d dVar) {
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(dVar.f11325i).optJSONObject("inapp");
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            dVar.a(context);
            dVar.aE = dVar.f11337w;
            dVar.aF = dVar.f11340z;
            dVar.aS = jSONObjectOptJSONObject.optInt("inapp_delay_display_time", 10) * 1000;
            dVar.bk = jSONObjectOptJSONObject.optString("inapp_h5_tpl_url", "");
            dVar.bv = 1;
            dVar.bw = jSONObjectOptJSONObject.optInt("inapp_display_direct", 0) == 1;
            dVar.aI = jSONObjectOptJSONObject.optInt("inapp_show_pos", 0);
            dVar.bc = jSONObjectOptJSONObject.optInt("inapp_show_threshold_time", 5);
            String str = dVar.f11305N;
            if (!TextUtils.isEmpty(str)) {
                dVar.bo.add(str);
            }
            dVar.bP = System.currentTimeMillis();
            dVar.bQ = cn.jpush.android.ad.c.b(jSONObjectOptJSONObject.optString("inapp_end_time", ""));
            dVar.az = jSONObjectOptJSONObject.optInt("inapp_max_cache_numb", 10);
            dVar.aR = jSONObjectOptJSONObject.optInt("inapp_msg_to_user", 1);
            dVar.bu = 40;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("in_title", dVar.aE);
            jSONObject.put("in_body_content", dVar.aF);
            jSONObject.put("in_pic_path1", str);
            dVar.bm = jSONObject.toString();
            return dVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(String str) {
        HashMap<String, String> map = bZ;
        return map != null ? map.get(str) : "";
    }

    public NotificationMessage b() {
        NotificationMessage notificationMessage = new NotificationMessage();
        notificationMessage.appkey = this.f11319c;
        notificationMessage.msgId = this.f11320d;
        notificationMessage.notificationAlertType = this.f11300I;
        notificationMessage.notificationBigPicPath = this.f11294C;
        notificationMessage.notificationBigText = this.f11293B;
        notificationMessage.notificationBuilderId = this.f11327l;
        notificationMessage.notificationCategory = this.f11298G;
        notificationMessage.notificationContent = this.f11340z;
        notificationMessage.notificationExtras = this.f11299H;
        notificationMessage.notificationId = this.f11321e;
        notificationMessage.notificationInbox = this.f11295D;
        notificationMessage.notificationLargeIcon = this.f11305N;
        notificationMessage.notificationPriority = this.f11296E;
        notificationMessage.notificationImportance = this.f11297F;
        notificationMessage.notificationSmallIcon = this.f11304M;
        notificationMessage.notificationStyle = this.f11292A;
        notificationMessage.notificationTitle = this.f11337w;
        notificationMessage.notificationTargetEvent = this.f11338x;
        notificationMessage.appId = this.f11318b;
        notificationMessage.notificationType = this.f11328m;
        notificationMessage.developerArg0 = this.au;
        notificationMessage.notificationChannelId = this.f11301J;
        notificationMessage.isRichPush = this.f11316Z;
        notificationMessage.richType = this.ae;
        notificationMessage._webPagePath = this.ac;
        notificationMessage.showResourceList = this.ag;
        notificationMessage.platform = this.aj;
        try {
            notificationMessage.deeplink = this.f11306P;
            notificationMessage.failedAction = this.f11307Q;
            notificationMessage.failedLink = this.f11308R;
            notificationMessage.targetPkgName = this.f11309S;
            notificationMessage.displayForeground = this.f11302K;
            notificationMessage.sspWxAppId = this.f11312V;
            notificationMessage.sspWmOriginId = this.f11313W;
            notificationMessage.sspWmType = this.f11314X;
            notificationMessage.isWmDeepLink = this.f11315Y;
            notificationMessage.inAppMsgTitle = this.aE;
            notificationMessage.inAppMsgContentBody = this.aF;
            notificationMessage.inAppMsgType = this.aG;
            notificationMessage.inAppMsgShowType = this.aH;
            notificationMessage.inAppMsgShowPos = this.aI;
            notificationMessage.inAppShowTarget = this.bT;
            notificationMessage.inAppExtras = this.f11333r;
            notificationMessage.inAppClickAction = this.bV;
            if (JPushConstants.SDK_VERSION_CODE >= 408) {
                notificationMessage.notificationNormalSmallIcon = this.O;
            }
        } catch (Throwable th) {
            f.r(th, new StringBuilder("pushEntry toNotificationMessage error"), "PushEntity");
        }
        try {
            if (JPushConstants.SDK_VERSION_CODE > 590) {
                notificationMessage.customButtons = this.bY;
            }
        } catch (Throwable unused) {
        }
        return notificationMessage;
    }

    public static d a(Context context, String str, String str2) {
        byte b9;
        String str3;
        byte b10;
        d dVar = new d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("_jmsgid_");
            dVar.f11320d = strOptString;
            if (strOptString.isEmpty()) {
                dVar.f11320d = jSONObject.optString("msg_id");
            }
            dVar.f11323g = a(dVar.f11320d, jSONObject);
            dVar.aj = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
            int iOptInt = jSONObject.optInt("show_type", -1);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("m_content");
            if (jSONObjectOptJSONObject != null) {
                dVar.f11340z = jSONObjectOptJSONObject.optString("n_content");
                dVar.f11337w = jSONObjectOptJSONObject.optString("n_title");
                dVar.f11336v = jSONObjectOptJSONObject.optString("n_bg_color");
                dVar.f11299H = jSONObjectOptJSONObject.optString("n_extras");
                dVar.f11301J = jSONObjectOptJSONObject.optString("n_channel_id");
                dVar.f11302K = jSONObjectOptJSONObject.optString("n_display_foreground");
                dVar.f11300I = jSONObjectOptJSONObject.optInt("n_alert_type");
                dVar.f11296E = b.a(jSONObjectOptJSONObject);
                dVar.f11297F = b.c(jSONObjectOptJSONObject);
                dVar.f11302K = jSONObjectOptJSONObject.optString("n_display_foreground");
                dVar.av = jSONObjectOptJSONObject.optString("n_sound");
                dVar.f11335u = jSONObjectOptJSONObject.optInt("n_flag", 1);
                dVar.f11338x = jSONObjectOptJSONObject.optJSONArray("n_target_event");
                dVar.bY = jSONObjectOptJSONObject.optJSONArray("custom_buttons");
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("rich_content");
                if (jSONObjectOptJSONObject2 != null) {
                    dVar.f11316Z = true;
                    dVar.a(jSONObjectOptJSONObject2);
                    dVar.j = 3;
                } else {
                    dVar.j = 4;
                    dVar.ae = -1;
                }
            } else {
                dVar.f11340z = jSONObject.optString("n_content");
                dVar.f11337w = jSONObject.optString("n_title");
                dVar.f11336v = jSONObject.optString("n_bg_color");
                dVar.f11338x = jSONObject.optJSONArray("n_target_event");
                dVar.f11299H = jSONObject.optString("n_extras");
                dVar.f11301J = jSONObject.optString("n_channel_id");
                dVar.f11302K = jSONObject.optString("n_display_foreground");
                dVar.f11300I = jSONObject.optInt("n_alert_type");
                dVar.f11296E = b.a(jSONObject);
                dVar.f11297F = b.c(jSONObject);
                dVar.f11302K = jSONObject.optString("n_display_foreground");
                dVar.aj = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
                dVar.f11324h = jSONObject.optString("override_msg_id");
                dVar.av = jSONObject.optString("n_sound");
                dVar.bY = jSONObject.optJSONArray("custom_buttons");
            }
            if (iOptInt != -1) {
                dVar.j = iOptInt;
            }
            b9 = 0;
            try {
                dVar.f11334s = 0;
                dVar.t = true;
                dVar.f11318b = context.getPackageName();
                return dVar;
            } catch (Throwable th) {
                th = th;
                Logger.e("PushEntity", "parseContent error:" + th);
                if (TextUtils.isEmpty(dVar.f11320d)) {
                    str3 = "NO MSGID";
                    b10 = b9;
                } else {
                    str3 = dVar.f11320d;
                    b10 = dVar.aj;
                }
                cn.jpush.android.helper.d.a(str3, str2, b10, 996L, context);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            b9 = 0;
        }
    }

    public static d a(d dVar) {
        try {
            JSONObject jSONObject = new JSONObject(dVar.f11325i);
            int i9 = jSONObject.getInt("type");
            if (!a(i9)) {
                Logger.ke("PushEntity", "parseInApp not support type=" + i9);
                return null;
            }
            if (jSONObject.has("target")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("target");
                if (jSONArrayOptJSONArray.length() > 0) {
                    dVar.bT = jSONArrayOptJSONArray.optString(0);
                }
            }
            dVar.bP = System.currentTimeMillis();
            dVar.bR = jSONObject.getInt("delay");
            dVar.bQ = Long.parseLong(jSONObject.getString("expired"));
            dVar.bS = jSONObject.getInt(MTPushConstants.Geofence.KEY_INTERVAL);
            dVar.bv = b(i9);
            dVar.bu = i9;
            dVar.f11333r = jSONObject.optString("extras");
            dVar.f11338x = jSONObject.optJSONArray("target_event");
            if (jSONObject.has("banner")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("banner");
                if (10 == i9) {
                    dVar.bW = jSONObject2.getJSONObject("title");
                    dVar.bX = jSONObject2.getJSONObject("content");
                    dVar.aE = dVar.bW.optString("text");
                    dVar.aF = dVar.bX.optString("text");
                }
                if (11 == i9) {
                    String string = jSONObject.getString("image");
                    if (TextUtils.isEmpty(string)) {
                        Logger.ke("PushEntity", "parseInApp image value is null");
                        return null;
                    }
                    dVar.bU = string;
                }
                if (jSONObject2 != null && jSONObject2.has("duration")) {
                    dVar.bc = jSONObject2.getInt("duration") / 1000;
                }
                if (jSONObject2 != null && jSONObject2.has("location")) {
                    dVar.aI = jSONObject2.getInt("location");
                }
            }
            if (jSONObject.has("full")) {
                String string2 = jSONObject.getString("image");
                if (TextUtils.isEmpty(string2)) {
                    Logger.ke("PushEntity", "parseInApp image value is null");
                    return null;
                }
                dVar.bU = string2;
                JSONObject jSONObject3 = jSONObject.getJSONObject("full");
                if (jSONObject3 != null && jSONObject3.has("duration")) {
                    dVar.bc = jSONObject3.getInt("duration") / 1000;
                }
            }
            if (jSONObject.has("interstitial")) {
                if (21 == i9) {
                    String string3 = jSONObject.getString("image");
                    if (TextUtils.isEmpty(string3)) {
                        Logger.ke("PushEntity", "parseInApp image value is null");
                        return null;
                    }
                    dVar.bU = string3;
                }
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interstitial");
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("title");
                if (jSONObjectOptJSONObject2 != null) {
                    dVar.aE = jSONObjectOptJSONObject2.optString("text");
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("content");
                if (jSONObjectOptJSONObject3 != null) {
                    dVar.aF = jSONObjectOptJSONObject3.optString("text");
                }
            }
            return dVar;
        } catch (Throwable th) {
            Logger.ke("PushEntity", "parseInApp Throwable=" + th);
            return null;
        }
    }

    public static d a(String str, String str2, String str3, long j) {
        d dVar = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar2 = new d();
            try {
                String strOptString = jSONObject.optString("msg_id", "");
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = jSONObject.optString("ad_id", "");
                }
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = jSONObject.optString("_jmsgid_", "");
                }
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = j + "";
                }
                Logger.d("PushEntity", "preParseOriginalMsgMessage msgId = " + strOptString);
                dVar2.f11320d = strOptString;
                dVar2.f11318b = str2;
                dVar2.f11319c = str3;
                dVar2.f11323g = a(strOptString, jSONObject);
                String strOptString2 = jSONObject.optString("sequence_id", "");
                dVar2.aB = strOptString2;
                b(strOptString, strOptString2);
                boolean z8 = true;
                if (jSONObject.optInt("n_only", 0) != 1) {
                    z8 = false;
                }
                int iOptInt = z8 ? jSONObject.optInt("n_builder_id", 0) : 0;
                dVar2.f11326k = z8;
                dVar2.f11327l = iOptInt;
                dVar2.f11325i = str;
                dVar2.j = jSONObject.optInt("show_type", 3);
                dVar2.aj = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
                dVar2.f11328m = jSONObject.optInt("notificaion_type", 0);
                dVar2.f11324h = jSONObject.optString("override_msg_id", "");
                dVar2.f11330o = jSONObject.optString("message", "");
                dVar2.f11331p = jSONObject.optString("content_type", "");
                dVar2.f11332q = jSONObject.optString("title", "");
                dVar2.f11333r = jSONObject.optString("extras", "");
                return dVar2;
            } catch (Throwable th) {
                th = th;
                dVar = dVar2;
                f.r(th, new StringBuilder("processMessage failed:"), "PushEntity");
                return dVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static d b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.f11317a = jSONObject.optInt("msgType", -1);
            dVar.f11318b = jSONObject.optString("appId");
            dVar.f11319c = jSONObject.optString("senderId");
            String strOptString = jSONObject.optString("messageId");
            dVar.f11320d = strOptString;
            dVar.f11323g = a(strOptString, jSONObject);
            dVar.f11321e = jSONObject.optInt("notificationId");
            dVar.f11322f = jSONObject.optInt("messageType");
            dVar.f11324h = jSONObject.optString("overrideMessageId");
            dVar.f11325i = jSONObject.optString("originalMessage");
            dVar.j = jSONObject.optInt("messageVersion");
            dVar.f11326k = jSONObject.optBoolean("notificationOnly");
            dVar.f11327l = jSONObject.optInt("notificationBuilderId");
            dVar.f11328m = jSONObject.optInt("notificationType");
            dVar.f11330o = jSONObject.optString("message");
            dVar.f11331p = jSONObject.optString("contentType");
            dVar.f11332q = jSONObject.optString("title");
            dVar.f11333r = jSONObject.optString("extras");
            dVar.f11334s = jSONObject.optInt("type");
            dVar.t = jSONObject.optBoolean("isFullScreen");
            dVar.f11335u = jSONObject.optInt("notificationRemoveMode");
            dVar.f11337w = jSONObject.optString("notificationTitle");
            dVar.f11336v = jSONObject.optString("notificationBgColor");
            dVar.f11338x = jSONObject.optJSONArray("notificationTargetEvent");
            dVar.f11339y = jSONObject.optString("notificationAppName");
            dVar.f11340z = jSONObject.optString("notificationContent");
            dVar.f11292A = jSONObject.optInt("notificationStyle");
            dVar.f11293B = jSONObject.optString("notificationBigText");
            dVar.f11294C = jSONObject.optString("notificationBigPicPath");
            dVar.f11295D = jSONObject.optString("notificationInbox");
            dVar.f11296E = jSONObject.optInt("notificationPriority");
            dVar.f11297F = jSONObject.optInt("notificationImportance");
            dVar.f11298G = jSONObject.optString("notificationCategory");
            dVar.f11299H = jSONObject.optString("notificationExtra");
            dVar.f11300I = jSONObject.optInt("notificationAlertType");
            dVar.f11301J = jSONObject.optString("notificationChannelId");
            dVar.f11302K = jSONObject.optString("displayForeground");
            dVar.f11303L = jSONObject.optString("source");
            dVar.f11304M = jSONObject.optString("smallIcon");
            dVar.f11305N = jSONObject.optString("largeIcon");
            dVar.O = jSONObject.optString("normalSmallIcon");
            dVar.f11306P = jSONObject.optString("deeplink");
            dVar.f11307Q = jSONObject.optInt("failedAction");
            dVar.f11308R = jSONObject.optString("failedLink");
            dVar.f11309S = jSONObject.optString("targetPkgName");
            dVar.f11311U = jSONObject.optInt("deeplinkBuilderId");
            dVar.f11316Z = jSONObject.optBoolean("isRichPush");
            dVar.aa = jSONObject.optString("showUrl");
            dVar.ab = jSONObject.optString("showTitle");
            dVar.ac = jSONObject.optString("_webPagePath");
            dVar.ad = jSONObject.optInt("jumpMode");
            dVar.ae = jSONObject.optInt("richType");
            dVar.af = jSONObject.optInt("showMode");
            try {
                String strOptString2 = jSONObject.optString("showResourceList");
                if (!TextUtils.isEmpty(strOptString2)) {
                    dVar.ag = new ArrayList<>(Arrays.asList(strOptString2.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                }
            } catch (Throwable th) {
                Logger.e("PushEntity", "showResourceList e:" + th);
            }
            dVar.ah = jSONObject.optString("fromNum");
            dVar.ai = jSONObject.optString("toNum");
            dVar.aj = (byte) jSONObject.optInt("platform");
            if (jSONObject.has("badgeAddNum")) {
                dVar.ak = Integer.valueOf(jSONObject.optInt("badgeAddNum"));
            }
            dVar.al = jSONObject.optString("geofenceid");
            dVar.am = jSONObject.optLong("radius");
            dVar.an = jSONObject.optString("status");
            dVar.ao = jSONObject.optBoolean("repeat");
            dVar.ap = jSONObject.optBoolean("hasShow");
            dVar.aq = jSONObject.optLong("expiration");
            dVar.ar = jSONObject.optDouble(MTPushConstants.Geofence.KEY_LONGITUDE);
            dVar.as = jSONObject.optDouble(MTPushConstants.Geofence.KEY_LATITUDE);
            dVar.at = jSONObject.optString("lastGeoStatus");
            dVar.au = jSONObject.optString("developerArg0");
            dVar.av = jSONObject.optString(RemoteMessageConst.Notification.SOUND);
            dVar.aw = jSONObject.optString("showBeginTime");
            dVar.ax = jSONObject.optString("showEndTime");
            dVar.f11315Y = jSONObject.optBoolean("isWmDeepLink");
            dVar.f11312V = jSONObject.optString("wxAppId");
            dVar.f11313W = jSONObject.optString("miniOriginid");
            dVar.f11314X = jSONObject.optInt("miniType");
            dVar.aD = jSONObject.optString("inAppMsgContent");
            dVar.aC = jSONObject.optString("inAppIntent");
            dVar.aE = jSONObject.optString("inAppMsgTitle");
            dVar.aF = jSONObject.optString("inAppMsgContentBody");
            dVar.bT = jSONObject.optString("target");
            dVar.bV = jSONObject.optString("clickAction");
            dVar.f11333r = jSONObject.optString("extras");
            dVar.aG = jSONObject.optInt("inAppMsgType");
            dVar.aH = jSONObject.optInt("inAppMsgShowType");
            dVar.aI = jSONObject.optInt("inAppMsgShowPos");
            dVar.aJ = jSONObject.optInt("inAppMsgShowAniAction");
            dVar.br = jSONObject.optInt("inSupportNotifyAni");
            dVar.bs = jSONObject.optInt("inSupportVibration");
            dVar.bt = jSONObject.optString("inAppIcon");
            dVar.aK = jSONObject.optInt("inAppMsgDismissAniAction");
            dVar.aL = jSONObject.optInt("inAppMsgShowBackground");
            dVar.aM = jSONObject.optInt("inAppMsgAllowIntercept");
            dVar.aN = jSONObject.optInt("inAppMsgFilterMsg");
            dVar.aO = jSONObject.optString("inAppMsgPicPath");
            dVar.aP = jSONObject.optInt("inAppMsgCountLmt");
            dVar.aQ = jSONObject.optInt("inAppMsgGap");
            dVar.aR = jSONObject.optInt("inAppMsgToUser");
            dVar.aS = jSONObject.optInt("inAppMsgDelayDisplayTime");
            dVar.aT = jSONObject.optInt("inAppMsgPageDelayDisplayTime");
            dVar.aU = jSONObject.optInt("inAppMsgReportPageName");
            dVar.aV = jSONObject.optInt("inAppUseSysAlert");
            dVar.aW = jSONObject.optString("inAppMsgBackgroundColor");
            dVar.aX = jSONObject.optString("inAppMsgTitleColor");
            dVar.aY = jSONObject.optString("inAppMsgContentColor");
            dVar.aZ = jSONObject.optInt("inAppMsgTitleSize");
            dVar.ba = jSONObject.optInt("inAppMsgContentSize");
            dVar.bb = jSONObject.optInt("inAppMsgCircularSize");
            dVar.bc = jSONObject.optInt("inAppMsgShowTime");
            dVar.bd = (float) jSONObject.optDouble("inAppMsgShowElapseTime");
            dVar.be = (float) jSONObject.optDouble("inAppMsgDismissElapseTime");
            dVar.bf = jSONObject.optString("inAppWebPageUrl");
            dVar.bg = jSONObject.optInt("inAppProtocolVer");
            dVar.bq = jSONObject.optInt("inAppSSPGap");
            dVar.bh = jSONObject.optInt("inAppCheckIntent");
            dVar.bi = jSONObject.optString("inAppTplContent");
            dVar.bj = jSONObject.optString("inAppTplId");
            dVar.bk = jSONObject.optString("inAppTplUrl");
            dVar.bl = (float) jSONObject.optDouble("inAppMarginY");
            dVar.bm = jSONObject.optString("inAppTplData");
            dVar.bn = jSONObject.optString("inAppIntentActions");
            dVar.bu = jSONObject.optInt("inAppType");
            dVar.bQ = jSONObject.optLong("expired");
            dVar.az = jSONObject.optInt("notifyInAppCacheNumb");
            dVar.aA = jSONObject.optInt("notifyInAppMsgType");
            dVar.bv = jSONObject.optInt("inAppPriority");
            dVar.bw = jSONObject.optBoolean("inAppIsDisplayDirect");
            dVar.by = jSONObject.optString("inAppBlackConf");
            dVar.bz = jSONObject.optString("inAppAnimatorConf");
            dVar.bA = jSONObject.optString("inAppAdPosition");
            dVar.bB = jSONObject.optString("inAppFragment");
            dVar.bC = jSONObject.optString("inAppAdPosId");
            dVar.bE = jSONObject.optInt("inAppCoordinateType");
            dVar.bF = jSONObject.optInt("inAppWinWidth");
            dVar.bG = jSONObject.optInt("inAppWinHeight");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("inAppShowCoordinate");
            dVar.bD = new ArrayList<>();
            if (jSONArrayOptJSONArray != null) {
                for (int i9 = 0; i9 < jSONArrayOptJSONArray.length(); i9++) {
                    dVar.bD.add(Float.valueOf((float) jSONArrayOptJSONArray.getDouble(i9)));
                }
            }
            dVar.bH = jSONObject.optInt("inAppPosMsgCountLmt");
            dVar.bI = jSONObject.optInt("inAppPosMsgGap");
            dVar.bJ = (float) jSONObject.optDouble("inAppSizeRatio");
            dVar.aB = jSONObject.optString("sequenceId");
            dVar.bx = jSONObject.optBoolean("inAppFixed");
            try {
                String strOptString3 = jSONObject.optString("inAppShowResList");
                if (!TextUtils.isEmpty(strOptString3)) {
                    dVar.bo = new ArrayList<>(Arrays.asList(strOptString3.split(Constants.ACCEPT_TIME_SEPARATOR_SP)));
                }
            } catch (Throwable th2) {
                Logger.e("PushEntity", "inAppShowResList e:" + th2);
            }
            dVar.bK = jSONObject.optString("unionADExtras");
            dVar.bL = jSONObject.optInt("swipeDismiss");
            dVar.bM = jSONObject.optInt("adSspSvrVer");
            dVar.bN = jSONObject.optInt("inAppMsgStyle");
            dVar.bO = jSONObject.optInt("inAppMsgStyleGap");
            dVar.bY = jSONObject.optJSONArray("customButtons");
            dVar.bT = jSONObject.optString("target");
            dVar.bP = jSONObject.optLong("msgTime");
            dVar.bR = jSONObject.optInt("delay");
            dVar.bS = jSONObject.optInt(MTPushConstants.Geofence.KEY_INTERVAL);
            return dVar;
        } catch (Throwable th3) {
            defpackage.f.o("parseJSONString e:", "PushEntity", th3);
            return null;
        }
    }

    public static String a(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                String strOptString = jSONObject.optString("_j_data_", "");
                Logger.d("PushEntity", "parse jdata:" + strOptString);
                a(str, strOptString);
                return strOptString;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject(this.f11325i);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("m_content");
            int iOptInt = jSONObjectOptJSONObject.optInt("ad_t", 0);
            this.f11334s = iOptInt;
            if (iOptInt != 0) {
                return;
            }
            this.t = jSONObjectOptJSONObject.optInt("full_screen", 0) >= 1;
            this.f11335u = jSONObjectOptJSONObject.optInt("n_flag", 1);
            this.f11337w = jSONObjectOptJSONObject.optString("n_title", "");
            this.f11336v = jSONObjectOptJSONObject.optString("n_bg_color", "");
            this.f11339y = jSONObjectOptJSONObject.optString("n_app_name", "");
            this.f11340z = jSONObjectOptJSONObject.optString("n_content", "");
            this.f11292A = jSONObjectOptJSONObject.optInt("n_style", 0);
            this.f11293B = jSONObjectOptJSONObject.optString("n_big_text", "");
            this.f11294C = jSONObjectOptJSONObject.optString("n_big_pic_path", "");
            this.f11295D = jSONObjectOptJSONObject.optString("n_inbox", "");
            this.f11299H = jSONObjectOptJSONObject.optString("n_extras", "");
            this.f11296E = b.a(jSONObjectOptJSONObject);
            this.f11297F = b.c(jSONObjectOptJSONObject);
            this.f11298G = jSONObjectOptJSONObject.optString("n_category", "");
            this.f11300I = jSONObjectOptJSONObject.optInt("n_alert_type", -1);
            this.f11301J = jSONObjectOptJSONObject.optString("n_channel_id");
            this.f11302K = jSONObjectOptJSONObject.optString("n_display_foreground");
            this.f11304M = jSONObjectOptJSONObject.optString("n_small_icon", "");
            this.f11305N = jSONObjectOptJSONObject.optString("n_large_icon", "");
            this.f11303L = jSONObjectOptJSONObject.optString("n_source", "");
            this.O = jSONObjectOptJSONObject.optString("n_small_icon_uri", "");
            this.aC = jSONObjectOptJSONObject.optString("n_intent");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("n_intent");
            if (jSONObjectOptJSONObject2 != null) {
                this.f11306P = jSONObjectOptJSONObject2.optString("n_url", "");
                this.f11307Q = jSONObjectOptJSONObject2.optInt("n_fail_handle_type", 0);
                this.f11308R = jSONObjectOptJSONObject2.optString("n_fail_handle_url", "");
                this.f11309S = jSONObjectOptJSONObject2.optString("n_package_name", "");
                this.f11311U = jSONObjectOptJSONObject2.optInt("n_builder_id", 0);
                this.f11312V = jSONObjectOptJSONObject2.optString("wx_app_id", "");
                this.f11313W = jSONObjectOptJSONObject2.optString("mini_originid", "");
                this.f11314X = jSONObjectOptJSONObject2.optInt("mini_type", 0);
            }
            if (TextUtils.isEmpty(this.f11337w)) {
                Logger.dd("PushEntity", "Not found notificaiton title for developer mode. Use the application name.");
                this.f11337w = cn.jpush.android.ad.b.b(context);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("ad_content");
            if (!jSONObjectOptJSONObject.isNull("ad_content") && jSONObjectOptJSONObject3 != null) {
                a(jSONObjectOptJSONObject3);
            }
            if (jSONObjectOptJSONObject.has("n_badge_add_num")) {
                this.ak = Integer.valueOf(jSONObjectOptJSONObject.optInt("n_badge_add_num"));
            } else {
                this.ak = null;
            }
            this.av = jSONObjectOptJSONObject.optString("n_sound");
            this.aw = jSONObjectOptJSONObject.optString("n_show_begin_time");
            this.ax = jSONObjectOptJSONObject.optString("n_show_end_time");
            this.f11338x = jSONObjectOptJSONObject.optJSONArray("n_target_event");
            this.bY = jSONObject.optJSONArray("custom_buttons");
        } catch (Throwable th) {
            f.q(th, new StringBuilder("parse notification failed:"), "PushEntity");
        }
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        ca.put(str, str2);
    }

    public void a(String str) {
        this.bV = str;
    }

    public static void a(String str, String str2) {
        if (bZ == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        bZ.put(str, str2);
    }

    private void a(JSONObject jSONObject) {
        this.f11316Z = true;
        this.aa = jSONObject.optString("e_url", "").trim();
        this.ab = jSONObject.optString("e_title", "").trim();
        if (!TextUtils.isEmpty(this.aa) && !cn.jpush.android.ad.b.c(this.aa)) {
            this.aa = JPushConstants.HTTPS_PRE + this.aa;
            Logger.i("PushEntity", "Add http to non-prefix url: " + this.aa);
        }
        this.ae = jSONObject.optInt("e_rich_type", 0);
        this.ad = jSONObject.optInt("e_jump_mode", 0);
        this.af = jSONObject.optInt("e_show", 0);
        int i9 = this.ae;
        if (3 == i9 || 2 == i9 || 1 == i9) {
            this.ag = p.a(jSONObject.optJSONArray("e_eres"));
        }
        this.ah = jSONObject.optString("from_num", "");
        this.ai = jSONObject.optString("to_num", "");
    }

    private static boolean a(int i9) {
        return 10 == i9 || 11 == i9 || 20 == i9 || 21 == i9 || 31 == i9 || 30 == i9;
    }
}
