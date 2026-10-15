package cn.jiguang.commons.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.starburst.sdk.api.GuiControlConfig;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class jh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f10258a = {"vendor.display.foldable", "sys.foldphone.status"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f10259b = {"ro.vivo.device.type"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f10260c = {"ro.mi.os.flavor"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f10261d = {"ro.config.fold_disp"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f10262e = {"ro.boot.foldable_state"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f10263f = {"ro.vendor.foldable_state", "sys.foldable.state", "vendor.foldable.state", "ro.vendor.vivo.hardware.display.xdr:foldable"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f10264g = {"hw_sc.build.os.phonetype"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f10265h = {"ro.config.hw_fold_disp"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f10266i = {"dev.mnt.blk.data", "dev.mnt.blk.odm", "dev.mnt.blk.product", "dev.mnt.blk.vendor", "dev.mnt.blk.system_ext"};
    private static final String[] j = {"fold", "flip", "foldable", "duo", "mate x", "galaxy z", "galaxy fold", "galaxy flip", "pixel fold", "oppo find n", "xiaomi mix fold", "vivo x fold"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f10267k = {"sm-f", "sm-g"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f10268l = {"tab", "pad", "tablet", "mediapad", "sm-t", "lenovo tab"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f10269m = {"car", "auto", "automotive", "vehicle", "drive"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String[] f10270n = {"watch", "wear", "gear", "wrist", "smartwatch"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String[] f10271o = {"tv", "androidtv", "television", "settop", "stb", "settopbox", "leanback", "mi box", "nexus player"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String[] f10272p = {"vr", "virtualreality", "daydream", "oculus", "gearvr", "cardboard", "pico"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String[] f10273q = {"embedded", "industrial", "medical", "panel", "hmi", "kiosk"};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String[] f10274r = {"iot", "sbc", "rpi", "raspberry", "beaglebone", "orangepi", "nanopi"};

    private static String a(int i9) {
        switch (i9) {
            case 0:
                return GuiControlConfig.DEVICE_PHONE;
            case 1:
                return "tablet";
            case 2:
                return "watch";
            case 3:
                return "automotive";
            case 4:
                return "tv";
            case 5:
                return "appliance";
            case 6:
                return "desktop";
            case 7:
                return "vr";
            case 8:
                return "iot";
            case 9:
                return "embedded";
            default:
                return "unknown";
        }
    }

    private static String b() {
        String strB = bu.a().b(MTCommonConstants.MainWhat.ON_ACTIVITY_CREATED, false);
        return strB != null ? strB.toLowerCase() : "";
    }

    private static String c() {
        String strB = bu.a().b(1013, false);
        return !TextUtils.isEmpty(strB) ? strB : "";
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x0109 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x012a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0189 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00ca A[Catch: JSONException -> 0x003c, TRY_LEAVE, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e0 A[Catch: JSONException -> 0x003c, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0103 A[Catch: JSONException -> 0x003c, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0117 A[Catch: JSONException -> 0x003c, EDGE_INSN: B:52:0x0117->B:53:0x011a BREAK  A[LOOP:0: B:41:0x00f5->B:49:0x010b], TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x011c A[Catch: JSONException -> 0x003c, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0122 A[Catch: JSONException -> 0x003c, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0134 A[Catch: JSONException -> 0x003c, EDGE_INSN: B:60:0x0134->B:62:0x013b BREAK  A[LOOP:1: B:55:0x0120->B:61:0x0138], TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0138 A[Catch: JSONException -> 0x003c, LOOP:1: B:55:0x0120->B:61:0x0138, LOOP_END, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0144 A[Catch: JSONException -> 0x0148, TRY_LEAVE, TryCatch #2 {JSONException -> 0x0148, blocks: (B:64:0x013e, B:66:0x0144), top: B:107:0x013e }] */
    /* JADX WARN: Code duplicated, block: B:68:0x014a A[Catch: JSONException -> 0x003c, TRY_ENTER, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0155 A[Catch: JSONException -> 0x003c, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x015d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:74:0x015f A[Catch: JSONException -> 0x003c, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0169 A[Catch: JSONException -> 0x003c, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0172 A[Catch: JSONException -> 0x003c, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0178 A[Catch: JSONException -> 0x003c, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0182 A[Catch: JSONException -> 0x003c, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x018e A[Catch: JSONException -> 0x003c, TRY_LEAVE, TryCatch #3 {JSONException -> 0x003c, blocks: (B:3:0x000f, B:5:0x0033, B:9:0x0041, B:11:0x004b, B:12:0x005b, B:31:0x00ca, B:36:0x00da, B:38:0x00e0, B:39:0x00e5, B:44:0x00fb, B:46:0x0103, B:49:0x010b, B:50:0x010e, B:52:0x0117, B:54:0x011c, B:56:0x0122, B:58:0x012a, B:60:0x0134, B:61:0x0138, B:62:0x013b, B:68:0x014a, B:69:0x014f, B:71:0x0155, B:84:0x0189, B:74:0x015f, B:76:0x0169, B:78:0x0172, B:80:0x0178, B:82:0x0182, B:86:0x018e, B:98:0x01c2, B:30:0x00b5, B:88:0x0193, B:93:0x01b1, B:95:0x01bb, B:15:0x007c, B:17:0x0082, B:19:0x0092, B:21:0x009d, B:26:0x00a6, B:28:0x00af), top: B:109:0x000f, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:92:0x01af A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:95:0x01bb A[Catch: all -> 0x01c1, TRY_LEAVE, TryCatch #0 {all -> 0x01c1, blocks: (B:88:0x0193, B:93:0x01b1, B:95:0x01bb), top: B:103:0x0193, outer: #3 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:54:0x011c, please report this as an issue */
    private static JSONObject d() {
        String str;
        String lowerCase;
        String[] strArr;
        int i9;
        String[] strArr2;
        JSONObject jSONObject;
        int i10;
        boolean z8;
        int i11;
        String strA;
        int i12;
        String str2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("det", false);
            String strB = b();
            boolean zEquals = MTPushConstants.Manufacturer.VIVO.equals(strB);
            boolean zContains = strB.contains(MTPushConstants.Manufacturer.HUAWEI);
            boolean zContains2 = strB.contains("samsung");
            boolean zContains3 = strB.contains(MTPushConstants.Manufacturer.XIAOMI);
            Context contextA = jg.a();
            if (zEquals) {
                a(jSONObject2, f10259b, 2, "prop_foldable");
            }
            if (zContains3) {
                a(jSONObject2, f10260c, 7, "prop_xiaomi_fold");
            }
            if (zContains) {
                a(jSONObject2, f10264g, 5, "prop_foldphone");
                a(jSONObject2, f10265h, 6, "prop_fold_disp");
            }
            a(jSONObject2, f10258a, 1, "prop_1");
            a(jSONObject2, f10261d, 3, "prop_comma");
            a(jSONObject2, f10262e, 4, "prop_exists");
            if (contextA != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 31) {
                        String string = Settings.Global.getString(contextA.getContentResolver(), "device_folded");
                        if (TextUtils.isEmpty(string)) {
                            String strC = c();
                            str = Build.DEVICE;
                            if (TextUtils.isEmpty(str)) {
                                str = "";
                            }
                            if (!TextUtils.isEmpty(str)) {
                                jSONObject2.put("bd", str);
                            }
                            lowerCase = strC.toLowerCase();
                            String lowerCase2 = str.toLowerCase();
                            strArr = j;
                            int length = strArr.length;
                            i9 = 0;
                            while (true) {
                                int i13 = i9;
                                str2 = strArr[i13];
                                if (lowerCase.contains(str2)) {
                                }
                                jSONObject2.put("det", true);
                                if (jSONObject2.has("m")) {
                                    jSONObject2.put("m", "keyword");
                                    break;
                                }
                                break;
                                if (zContains2) {
                                    for (String str3 : f10267k) {
                                        if (lowerCase.startsWith(str3)) {
                                            jSONObject2.put("det", true);
                                            if (jSONObject2.has("m")) {
                                                jSONObject2.put("m", "keyword");
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                }
                                strArr2 = f10263f;
                                jSONObject = null;
                                if (jSONObject2.has("fp")) {
                                    jSONObject = jSONObject2.getJSONObject("fp");
                                }
                                if (jSONObject == null) {
                                    jSONObject = new JSONObject();
                                }
                                z8 = false;
                                for (String str4 : strArr2) {
                                    if (str4.contains(MTPushConstants.Manufacturer.VIVO)) {
                                        strA = ks.a(str4, "");
                                        if (!TextUtils.isEmpty(strA)) {
                                            jSONObject.put(str4, strA);
                                            if ("true".equals(strA)) {
                                                jSONObject2.put("det", true);
                                                if (!jSONObject2.has("m")) {
                                                    jSONObject2.put("m", "prop_true1");
                                                }
                                            } else {
                                                jSONObject2.put("det", true);
                                                if (!jSONObject2.has("m")) {
                                                    jSONObject2.put("m", "prop_true1");
                                                }
                                            }
                                            z8 = true;
                                        }
                                    } else {
                                        strA = ks.a(str4, "");
                                        if (!TextUtils.isEmpty(strA)) {
                                            jSONObject.put(str4, strA);
                                            if ("true".equals(strA)) {
                                                jSONObject2.put("det", true);
                                                if (!jSONObject2.has("m")) {
                                                    jSONObject2.put("m", "prop_true1");
                                                }
                                            } else {
                                                jSONObject2.put("det", true);
                                                if (!jSONObject2.has("m")) {
                                                    jSONObject2.put("m", "prop_true1");
                                                }
                                            }
                                            z8 = true;
                                        }
                                    }
                                }
                                if (z8) {
                                    jSONObject2.put("fp", jSONObject);
                                }
                                if (contextA != null) {
                                    i11 = contextA.getResources().getConfiguration().screenLayout & 15;
                                    boolean zHasSystemFeature = contextA.getPackageManager().hasSystemFeature("android.software.freeform_window_management");
                                    if (i11 != 3) {
                                        jSONObject2.put("det", true);
                                        if (!jSONObject2.has("m")) {
                                            jSONObject2.put("m", "multiwindow");
                                        }
                                    } else {
                                        jSONObject2.put("det", true);
                                        if (!jSONObject2.has("m")) {
                                            jSONObject2.put("m", "multiwindow");
                                        }
                                    }
                                }
                                i9 = i13 + 1;
                            }
                        } else {
                            jSONObject2.put("folded", string);
                            if ("1".equals(string) || "true".equals(string)) {
                                jSONObject2.put("det", true);
                                if (jSONObject2.has("m")) {
                                    String strC2 = c();
                                    str = Build.DEVICE;
                                    if (TextUtils.isEmpty(str)) {
                                        str = "";
                                    }
                                    if (!TextUtils.isEmpty(str)) {
                                        jSONObject2.put("bd", str);
                                    }
                                    lowerCase = strC2.toLowerCase();
                                    String lowerCase3 = str.toLowerCase();
                                    strArr = j;
                                    int length2 = strArr.length;
                                    i9 = 0;
                                    while (true) {
                                        int i14 = i9;
                                        str2 = strArr[i14];
                                        if (lowerCase.contains(str2)) {
                                        }
                                        jSONObject2.put("det", true);
                                        if (jSONObject2.has("m")) {
                                            break;
                                        }
                                        jSONObject2.put("m", "keyword");
                                        break;
                                        if (zContains2) {
                                            while (i12 < r7) {
                                                if (lowerCase.startsWith(str3)) {
                                                    jSONObject2.put("det", true);
                                                    if (jSONObject2.has("m")) {
                                                        break;
                                                    }
                                                    jSONObject2.put("m", "keyword");
                                                    break;
                                                }
                                            }
                                        }
                                        strArr2 = f10263f;
                                        jSONObject = null;
                                        if (jSONObject2.has("fp")) {
                                            jSONObject = jSONObject2.getJSONObject("fp");
                                        }
                                        if (jSONObject == null) {
                                            jSONObject = new JSONObject();
                                        }
                                        z8 = false;
                                        while (i10 < r7) {
                                            if (str4.contains(MTPushConstants.Manufacturer.VIVO)) {
                                                strA = ks.a(str4, "");
                                                if (!TextUtils.isEmpty(strA)) {
                                                    jSONObject.put(str4, strA);
                                                    if ("true".equals(strA)) {
                                                        jSONObject2.put("det", true);
                                                        if (!jSONObject2.has("m")) {
                                                            jSONObject2.put("m", "prop_true1");
                                                        }
                                                    } else {
                                                        jSONObject2.put("det", true);
                                                        if (!jSONObject2.has("m")) {
                                                            jSONObject2.put("m", "prop_true1");
                                                        }
                                                    }
                                                    z8 = true;
                                                }
                                            } else {
                                                strA = ks.a(str4, "");
                                                if (!TextUtils.isEmpty(strA)) {
                                                    jSONObject.put(str4, strA);
                                                    if ("true".equals(strA)) {
                                                        jSONObject2.put("det", true);
                                                        if (!jSONObject2.has("m")) {
                                                            jSONObject2.put("m", "prop_true1");
                                                        }
                                                    } else {
                                                        jSONObject2.put("det", true);
                                                        if (!jSONObject2.has("m")) {
                                                            jSONObject2.put("m", "prop_true1");
                                                        }
                                                    }
                                                    z8 = true;
                                                }
                                            }
                                        }
                                        if (z8) {
                                            jSONObject2.put("fp", jSONObject);
                                        }
                                        if (contextA != null) {
                                            i11 = contextA.getResources().getConfiguration().screenLayout & 15;
                                            boolean zHasSystemFeature2 = contextA.getPackageManager().hasSystemFeature("android.software.freeform_window_management");
                                            if (i11 != 3) {
                                                jSONObject2.put("det", true);
                                                if (!jSONObject2.has("m")) {
                                                    jSONObject2.put("m", "multiwindow");
                                                }
                                            } else {
                                                jSONObject2.put("det", true);
                                                if (!jSONObject2.has("m")) {
                                                    jSONObject2.put("m", "multiwindow");
                                                }
                                            }
                                        }
                                        i9 = i14 + 1;
                                    }
                                } else {
                                    jSONObject2.put("m", "settings");
                                    String strC3 = c();
                                    str = Build.DEVICE;
                                    if (TextUtils.isEmpty(str)) {
                                        str = "";
                                    }
                                    if (!TextUtils.isEmpty(str)) {
                                        jSONObject2.put("bd", str);
                                    }
                                    lowerCase = strC3.toLowerCase();
                                    String lowerCase4 = str.toLowerCase();
                                    strArr = j;
                                    int length3 = strArr.length;
                                    i9 = 0;
                                    while (i9 < length3) {
                                        int i15 = i9;
                                        str2 = strArr[i15];
                                        if (!lowerCase.contains(str2) || lowerCase4.contains(str2)) {
                                            jSONObject2.put("det", true);
                                            if (jSONObject2.has("m")) {
                                                break;
                                            }
                                            jSONObject2.put("m", "keyword");
                                            break;
                                        }
                                        i9 = i15 + 1;
                                    }
                                    if (zContains2) {
                                        while (i12 < r7) {
                                            if (lowerCase.startsWith(str3)) {
                                                jSONObject2.put("det", true);
                                                if (jSONObject2.has("m")) {
                                                    break;
                                                }
                                                jSONObject2.put("m", "keyword");
                                                break;
                                            }
                                        }
                                    }
                                    strArr2 = f10263f;
                                    jSONObject = null;
                                    try {
                                        if (jSONObject2.has("fp")) {
                                            jSONObject = jSONObject2.getJSONObject("fp");
                                        }
                                    } catch (JSONException unused) {
                                    }
                                    if (jSONObject == null) {
                                        jSONObject = new JSONObject();
                                    }
                                    z8 = false;
                                    while (i10 < r7) {
                                        if (str4.contains(MTPushConstants.Manufacturer.VIVO) || zEquals) {
                                            strA = ks.a(str4, "");
                                            if (!TextUtils.isEmpty(strA)) {
                                                jSONObject.put(str4, strA);
                                                if ("true".equals(strA) || "1".equals(strA)) {
                                                    jSONObject2.put("det", true);
                                                    if (!jSONObject2.has("m")) {
                                                        jSONObject2.put("m", "prop_true1");
                                                    }
                                                }
                                                z8 = true;
                                            }
                                        }
                                    }
                                    if (z8) {
                                        jSONObject2.put("fp", jSONObject);
                                    }
                                    if (contextA != null) {
                                        try {
                                            i11 = contextA.getResources().getConfiguration().screenLayout & 15;
                                            boolean zHasSystemFeature3 = contextA.getPackageManager().hasSystemFeature("android.software.freeform_window_management");
                                            if ((i11 != 3 || i11 == 4) && zHasSystemFeature3) {
                                                jSONObject2.put("det", true);
                                                if (!jSONObject2.has("m")) {
                                                    jSONObject2.put("m", "multiwindow");
                                                }
                                            }
                                        } catch (Throwable th) {
                                            ee.d("DeviceTypeUtils", "check screen config for foldable err: " + th.getMessage());
                                        }
                                    }
                                }
                            } else {
                                String strC4 = c();
                                str = Build.DEVICE;
                                if (TextUtils.isEmpty(str)) {
                                    str = "";
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    jSONObject2.put("bd", str);
                                }
                                lowerCase = strC4.toLowerCase();
                                String lowerCase5 = str.toLowerCase();
                                strArr = j;
                                int length4 = strArr.length;
                                i9 = 0;
                                while (true) {
                                    int i16 = i9;
                                    str2 = strArr[i16];
                                    if (lowerCase.contains(str2)) {
                                    }
                                    jSONObject2.put("det", true);
                                    if (jSONObject2.has("m")) {
                                        break;
                                    }
                                    jSONObject2.put("m", "keyword");
                                    break;
                                    if (zContains2) {
                                        while (i12 < r7) {
                                            if (lowerCase.startsWith(str3)) {
                                                jSONObject2.put("det", true);
                                                if (jSONObject2.has("m")) {
                                                    break;
                                                }
                                                jSONObject2.put("m", "keyword");
                                                break;
                                            }
                                        }
                                    }
                                    strArr2 = f10263f;
                                    jSONObject = null;
                                    if (jSONObject2.has("fp")) {
                                        jSONObject = jSONObject2.getJSONObject("fp");
                                    }
                                    if (jSONObject == null) {
                                        jSONObject = new JSONObject();
                                    }
                                    z8 = false;
                                    while (i10 < r7) {
                                        if (str4.contains(MTPushConstants.Manufacturer.VIVO)) {
                                            strA = ks.a(str4, "");
                                            if (!TextUtils.isEmpty(strA)) {
                                                jSONObject.put(str4, strA);
                                                if ("true".equals(strA)) {
                                                    jSONObject2.put("det", true);
                                                    if (!jSONObject2.has("m")) {
                                                        jSONObject2.put("m", "prop_true1");
                                                    }
                                                } else {
                                                    jSONObject2.put("det", true);
                                                    if (!jSONObject2.has("m")) {
                                                        jSONObject2.put("m", "prop_true1");
                                                    }
                                                }
                                                z8 = true;
                                            }
                                        } else {
                                            strA = ks.a(str4, "");
                                            if (!TextUtils.isEmpty(strA)) {
                                                jSONObject.put(str4, strA);
                                                if ("true".equals(strA)) {
                                                    jSONObject2.put("det", true);
                                                    if (!jSONObject2.has("m")) {
                                                        jSONObject2.put("m", "prop_true1");
                                                    }
                                                } else {
                                                    jSONObject2.put("det", true);
                                                    if (!jSONObject2.has("m")) {
                                                        jSONObject2.put("m", "prop_true1");
                                                    }
                                                }
                                                z8 = true;
                                            }
                                        }
                                    }
                                    if (z8) {
                                        jSONObject2.put("fp", jSONObject);
                                    }
                                    if (contextA != null) {
                                        i11 = contextA.getResources().getConfiguration().screenLayout & 15;
                                        boolean zHasSystemFeature4 = contextA.getPackageManager().hasSystemFeature("android.software.freeform_window_management");
                                        if (i11 != 3) {
                                            jSONObject2.put("det", true);
                                            if (!jSONObject2.has("m")) {
                                                jSONObject2.put("m", "multiwindow");
                                            }
                                        } else {
                                            jSONObject2.put("det", true);
                                            if (!jSONObject2.has("m")) {
                                                jSONObject2.put("m", "multiwindow");
                                            }
                                        }
                                    }
                                    i9 = i16 + 1;
                                }
                            }
                        }
                    } else {
                        String strC5 = c();
                        str = Build.DEVICE;
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            jSONObject2.put("bd", str);
                        }
                        lowerCase = strC5.toLowerCase();
                        String lowerCase6 = str.toLowerCase();
                        strArr = j;
                        int length5 = strArr.length;
                        i9 = 0;
                        while (true) {
                            int i17 = i9;
                            str2 = strArr[i17];
                            if (lowerCase.contains(str2)) {
                            }
                            jSONObject2.put("det", true);
                            if (jSONObject2.has("m")) {
                                break;
                            }
                            jSONObject2.put("m", "keyword");
                            break;
                            if (zContains2) {
                                while (i12 < r7) {
                                    if (lowerCase.startsWith(str3)) {
                                        jSONObject2.put("det", true);
                                        if (jSONObject2.has("m")) {
                                            break;
                                        }
                                        jSONObject2.put("m", "keyword");
                                        break;
                                    }
                                }
                            }
                            strArr2 = f10263f;
                            jSONObject = null;
                            if (jSONObject2.has("fp")) {
                                jSONObject = jSONObject2.getJSONObject("fp");
                            }
                            if (jSONObject == null) {
                                jSONObject = new JSONObject();
                            }
                            z8 = false;
                            while (i10 < r7) {
                                if (str4.contains(MTPushConstants.Manufacturer.VIVO)) {
                                    strA = ks.a(str4, "");
                                    if (!TextUtils.isEmpty(strA)) {
                                        jSONObject.put(str4, strA);
                                        if ("true".equals(strA)) {
                                            jSONObject2.put("det", true);
                                            if (!jSONObject2.has("m")) {
                                                jSONObject2.put("m", "prop_true1");
                                            }
                                        } else {
                                            jSONObject2.put("det", true);
                                            if (!jSONObject2.has("m")) {
                                                jSONObject2.put("m", "prop_true1");
                                            }
                                        }
                                        z8 = true;
                                    }
                                } else {
                                    strA = ks.a(str4, "");
                                    if (!TextUtils.isEmpty(strA)) {
                                        jSONObject.put(str4, strA);
                                        if ("true".equals(strA)) {
                                            jSONObject2.put("det", true);
                                            if (!jSONObject2.has("m")) {
                                                jSONObject2.put("m", "prop_true1");
                                            }
                                        } else {
                                            jSONObject2.put("det", true);
                                            if (!jSONObject2.has("m")) {
                                                jSONObject2.put("m", "prop_true1");
                                            }
                                        }
                                        z8 = true;
                                    }
                                }
                            }
                            if (z8) {
                                jSONObject2.put("fp", jSONObject);
                            }
                            if (contextA != null) {
                                i11 = contextA.getResources().getConfiguration().screenLayout & 15;
                                boolean zHasSystemFeature5 = contextA.getPackageManager().hasSystemFeature("android.software.freeform_window_management");
                                if (i11 != 3) {
                                    jSONObject2.put("det", true);
                                    if (!jSONObject2.has("m")) {
                                        jSONObject2.put("m", "multiwindow");
                                    }
                                } else {
                                    jSONObject2.put("det", true);
                                    if (!jSONObject2.has("m")) {
                                        jSONObject2.put("m", "multiwindow");
                                    }
                                }
                            }
                            i9 = i17 + 1;
                        }
                    }
                } catch (Throwable th2) {
                    ee.d("DeviceTypeUtils", "get device_folded setting err: " + th2.getMessage());
                }
            } else {
                String strC6 = c();
                str = Build.DEVICE;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("bd", str);
                }
                lowerCase = strC6.toLowerCase();
                String lowerCase7 = str.toLowerCase();
                strArr = j;
                int length6 = strArr.length;
                i9 = 0;
                while (true) {
                    int i18 = i9;
                    str2 = strArr[i18];
                    if (lowerCase.contains(str2)) {
                    }
                    jSONObject2.put("det", true);
                    if (jSONObject2.has("m")) {
                        break;
                    }
                    jSONObject2.put("m", "keyword");
                    break;
                    if (zContains2) {
                        while (i12 < r7) {
                            if (lowerCase.startsWith(str3)) {
                                jSONObject2.put("det", true);
                                if (jSONObject2.has("m")) {
                                    break;
                                }
                                jSONObject2.put("m", "keyword");
                                break;
                            }
                        }
                    }
                    strArr2 = f10263f;
                    jSONObject = null;
                    if (jSONObject2.has("fp")) {
                        jSONObject = jSONObject2.getJSONObject("fp");
                    }
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    z8 = false;
                    while (i10 < r7) {
                        if (str4.contains(MTPushConstants.Manufacturer.VIVO)) {
                            strA = ks.a(str4, "");
                            if (!TextUtils.isEmpty(strA)) {
                                jSONObject.put(str4, strA);
                                if ("true".equals(strA)) {
                                    jSONObject2.put("det", true);
                                    if (!jSONObject2.has("m")) {
                                        jSONObject2.put("m", "prop_true1");
                                    }
                                } else {
                                    jSONObject2.put("det", true);
                                    if (!jSONObject2.has("m")) {
                                        jSONObject2.put("m", "prop_true1");
                                    }
                                }
                                z8 = true;
                            }
                        } else {
                            strA = ks.a(str4, "");
                            if (!TextUtils.isEmpty(strA)) {
                                jSONObject.put(str4, strA);
                                if ("true".equals(strA)) {
                                    jSONObject2.put("det", true);
                                    if (!jSONObject2.has("m")) {
                                        jSONObject2.put("m", "prop_true1");
                                    }
                                } else {
                                    jSONObject2.put("det", true);
                                    if (!jSONObject2.has("m")) {
                                        jSONObject2.put("m", "prop_true1");
                                    }
                                }
                                z8 = true;
                            }
                        }
                    }
                    if (z8) {
                        jSONObject2.put("fp", jSONObject);
                    }
                    if (contextA != null) {
                        i11 = contextA.getResources().getConfiguration().screenLayout & 15;
                        boolean zHasSystemFeature6 = contextA.getPackageManager().hasSystemFeature("android.software.freeform_window_management");
                        if (i11 != 3) {
                            jSONObject2.put("det", true);
                            if (!jSONObject2.has("m")) {
                                jSONObject2.put("m", "multiwindow");
                            }
                        } else {
                            jSONObject2.put("det", true);
                            if (!jSONObject2.has("m")) {
                                jSONObject2.put("m", "multiwindow");
                            }
                        }
                    }
                    i9 = i18 + 1;
                }
            }
        } catch (JSONException e9) {
            ee.d("DeviceTypeUtils", "collect foldable raw data err: " + e9.getMessage());
        }
        return jSONObject2;
    }

    private static JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("p_det", false);
            jSONObject.put("t_det", false);
            for (String str : f10266i) {
                String strA = ks.a(str, "");
                if (!TextUtils.isEmpty(strA)) {
                    if (strA.startsWith("dm-") || strA.startsWith("sdc") || strA.startsWith("sda")) {
                        jSONObject.put("p_det", true);
                    }
                    if (strA.startsWith("mmcblk0p")) {
                        jSONObject.put("t_det", true);
                    }
                }
            }
        } catch (JSONException e9) {
            ee.d("DeviceTypeUtils", "collect storage raw data err: " + e9.getMessage());
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0051  */
    /* JADX WARN: Code duplicated, block: B:41:0x0088  */
    private static JSONObject f() {
        float fSqrt;
        int i9;
        JSONObject jSONObject = new JSONObject();
        try {
            Context contextA = jg.a();
            if (contextA != null) {
                Resources resources = contextA.getResources();
                Configuration configuration = resources.getConfiguration();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                int i10 = configuration.screenLayout & 15;
                jSONObject.put("size_m", i10);
                int i11 = configuration.smallestScreenWidthDp;
                jSONObject.put("sw_dp", i11);
                float f6 = displayMetrics.xdpi;
                if (f6 > 0.0f) {
                    float f9 = displayMetrics.ydpi;
                    if (f9 > 0.0f) {
                        float f10 = displayMetrics.widthPixels / f6;
                        float f11 = displayMetrics.heightPixels / f9;
                        fSqrt = (float) Math.sqrt((f11 * f11) + (f10 * f10));
                        jSONObject.put("diag", fSqrt);
                    } else {
                        fSqrt = 0.0f;
                    }
                } else {
                    fSqrt = 0.0f;
                }
                int i12 = 0;
                if (i11 >= 600) {
                    i9 = 1;
                } else {
                    i9 = i11 >= 480 ? 0 : -1;
                }
                if (i9 == -1 && fSqrt > 0.0f) {
                    if (fSqrt >= 7.0f) {
                        i9 = 1;
                    } else if (fSqrt >= 5.5f) {
                        i9 = 0;
                    }
                }
                if (i9 != -1) {
                    i12 = i9;
                } else if (i10 == 3 || i10 == 4) {
                    i12 = 1;
                } else if (i10 != 1 && i10 != 2) {
                    i12 = i9;
                }
                jSONObject.put("result", i12);
                return jSONObject;
            }
        } catch (JSONException e9) {
            ee.d("DeviceTypeUtils", "collect screen raw data err: " + e9.getMessage());
        }
        return jSONObject;
    }

    private static JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context contextA = jg.a();
            if (contextA == null) {
                return jSONObject;
            }
            PackageManager packageManager = contextA.getPackageManager();
            Resources resources = contextA.getResources();
            boolean zHasSystemFeature = packageManager.hasSystemFeature("android.hardware.telephony");
            boolean zA = a(resources.getConfiguration());
            boolean zA2 = a(packageManager, "android.hardware.type.automotive");
            boolean zA3 = a(packageManager, "android.hardware.type.watch");
            boolean zA4 = a(packageManager, "android.hardware.type.television");
            boolean zA5 = a(packageManager, "android.hardware.type.embedded");
            boolean zA6 = a(packageManager, "android.software.vr.mode");
            boolean zA7 = a(packageManager, "android.hardware.type.pc");
            boolean zA8 = a(packageManager, "android.hardware.vr.high_performance");
            jSONObject.put("tel", zHasSystemFeature);
            jSONObject.put("lg_s", zA);
            if (zA2) {
                jSONObject.put("auto", true);
            }
            if (zA3) {
                jSONObject.put("watch", true);
            }
            if (zA4) {
                jSONObject.put("tv", true);
            }
            if (zA6 || zA8) {
                jSONObject.put("vr", true);
            }
            if (zA7) {
                jSONObject.put("desk", true);
            }
            if (zA5) {
                jSONObject.put("emb", true);
            }
            if (zA2) {
                jSONObject.put("result", 3);
                return jSONObject;
            }
            if (zA3) {
                jSONObject.put("result", 2);
                return jSONObject;
            }
            if (!zA6 && !zA8) {
                if (zA4) {
                    jSONObject.put("result", 4);
                    return jSONObject;
                }
                if (zA5) {
                    jSONObject.put("result", 9);
                    return jSONObject;
                }
                if (zA7) {
                    jSONObject.put("result", 6);
                    return jSONObject;
                }
                if (zHasSystemFeature) {
                    if (!zA) {
                        jSONObject.put("result", 0);
                        return jSONObject;
                    }
                } else if (zA) {
                    jSONObject.put("result", 1);
                    return jSONObject;
                }
                jSONObject.put("result", -1);
                return jSONObject;
            }
            jSONObject.put("result", 7);
            return jSONObject;
        } catch (JSONException e9) {
            ee.d("DeviceTypeUtils", "collect system feature raw data err: " + e9.getMessage());
        }
    }

    private static JSONObject h() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            String strB = bu.a().b(MTCommonConstants.MainWhat.ON_ACTIVITY_STOPPED, false);
            if (TextUtils.isEmpty(strB)) {
                strB = "";
            }
            String strA = a(strB);
            String strA2 = a(c());
            String str2 = Build.DEVICE;
            if (str2 == null) {
                str2 = "";
            }
            String strA3 = a(str2);
            String str3 = Build.BOARD;
            String strA4 = a(str3 != null ? str3 : "");
            String strB2 = b();
            if (!TextUtils.isEmpty(strA4)) {
                jSONObject.put("b", strA4);
            }
            ee.a("DeviceTypeUtils", "build property check - product:" + strA + ", model:" + strA2 + ", device:" + strA3 + ", board:" + strA4 + ", manufacturer:" + strB2);
            if (!a(jSONObject, strA, strA2, strA3, strA4, f10269m, 3) && !a(jSONObject, strA, strA2, strA3, strA4, f10270n, 2) && !a(jSONObject, strA, strA2, strA3, strA4, f10271o, 4) && !a(jSONObject, strA, strA2, strA3, strA4, f10272p, 7) && !a(jSONObject, strA, strA2, strA3, strA4, f10273q, 9) && !a(jSONObject, strA, strA2, strA3, strA4, f10274r, 8) && !a(jSONObject, strA, strA2, strA3, strA4, f10268l, 1)) {
                if ((TextUtils.isEmpty(strA2) || !strA2.startsWith("sm-t")) && ((TextUtils.isEmpty(strB2) || !strB2.contains("lenovo") || TextUtils.isEmpty(strA2) || (!strA2.contains("tab") && !strA2.contains("yb"))) && ((TextUtils.isEmpty(strB2) || !strB2.contains(MTPushConstants.Manufacturer.HUAWEI) || TextUtils.isEmpty(strA2) || (!strA2.contains("m2") && !strA2.contains("m3") && !strA2.contains("m5") && !strA2.contains("m6"))) && (TextUtils.isEmpty(strB2) || !strB2.contains(MTPushConstants.Manufacturer.XIAOMI) || TextUtils.isEmpty(strA2) || !strA2.contains("pad"))))) {
                    if (!TextUtils.isEmpty(strB2) && strB2.contains(MTPushConstants.Manufacturer.XIAOMI) && !TextUtils.isEmpty(strA2) && strA2.matches("^[0-9]+.*")) {
                        ee.a("DeviceTypeUtils", "build property: xiaomi device with numeric model pattern, but cannot confirm without additional evidence");
                    }
                    Context contextA = jg.a();
                    if (contextA != null) {
                        try {
                            if (!contextA.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
                                str = "build property: no telephony feature, no result set";
                            } else {
                                if (!a(contextA.getResources().getConfiguration())) {
                                    jSONObject.put("result", 0);
                                    ee.a("DeviceTypeUtils", "build property detected as phone by telephony + small screen");
                                    return jSONObject;
                                }
                                str = "build property: has telephony but tablet size, no result set";
                            }
                            ee.a("DeviceTypeUtils", str);
                        } catch (Throwable th) {
                            ee.d("DeviceTypeUtils", "build property check telephony err: " + th.getMessage());
                        }
                    } else {
                        ee.a("DeviceTypeUtils", "build property: context is null, no result set");
                    }
                    if (!jSONObject.has("result")) {
                        ee.a("DeviceTypeUtils", "build property: no keywords matched, result unknown");
                    }
                }
                jSONObject.put("result", 1);
                ee.a("DeviceTypeUtils", "build property detected as tablet by known model");
                return jSONObject;
            }
        } catch (JSONException e9) {
            ee.d("DeviceTypeUtils", "collect build property raw data err: " + e9.getMessage());
        }
        return jSONObject;
    }

    private static JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            Context contextA = jg.a();
            if (contextA != null) {
                int i9 = contextA.getResources().getConfiguration().uiMode & 15;
                jSONObject.put("ui_t", i9);
                int i10 = 3;
                if (i9 != 3) {
                    i10 = 4;
                    if (i9 != 4) {
                        i10 = 5;
                        if (i9 != 5) {
                            if (i9 != 6) {
                                i10 = 7;
                                if (i9 != 7) {
                                    i10 = -1;
                                }
                            } else {
                                i10 = 2;
                            }
                        }
                    }
                }
                jSONObject.put("result", i10);
                return jSONObject;
            }
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("collect ui mode raw data err: "), "DeviceTypeUtils");
        }
        return jSONObject;
    }

    private static String a(String str) {
        return !TextUtils.isEmpty(str) ? str.toLowerCase() : "";
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x0083  */
    /* JADX WARN: Code duplicated, block: B:15:0x008a  */
    /* JADX WARN: Code duplicated, block: B:18:0x009e  */
    /* JADX WARN: Code duplicated, block: B:21:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:29:0x00c5 A[Catch: all -> 0x00cb, JSONException -> 0x00cd, TRY_LEAVE, TryCatch #1 {JSONException -> 0x00cd, blocks: (B:27:0x00bc, B:29:0x00c5), top: B:104:0x00bc, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0181  */
    /* JADX WARN: Code duplicated, block: B:51:0x0189  */
    /* JADX WARN: Code duplicated, block: B:53:0x018c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0193  */
    /* JADX WARN: Code duplicated, block: B:56:0x0196  */
    /* JADX WARN: Code duplicated, block: B:57:0x019d  */
    /* JADX WARN: Code duplicated, block: B:59:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x01bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:68:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:74:0x01de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:76:0x01e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:78:0x01f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:80:0x01fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0200  */
    /* JADX WARN: Code duplicated, block: B:82:0x0208 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x020a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0213  */
    /* JADX WARN: Code duplicated, block: B:86:0x0218  */
    /* JADX WARN: Code duplicated, block: B:87:0x0220 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x0222  */
    /* JADX WARN: Code duplicated, block: B:89:0x022a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x022c  */
    /* JADX WARN: Code duplicated, block: B:91:0x0234 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0236  */
    /* JADX WARN: Code duplicated, block: B:93:0x023e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0243  */
    /* JADX WARN: Code duplicated, block: B:97:0x024c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x024e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0256  */
    public static JSONObject a() {
        int iOptInt;
        boolean zOptBoolean;
        boolean zOptBoolean2;
        int iOptInt2;
        int iOptInt3;
        ji jiVar;
        ji jiVar2;
        Context contextA;
        String str;
        ee.a("DeviceTypeUtils", "start detect device type");
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectG = g();
        a(jSONObject, "sf", jSONObjectG);
        int iOptInt4 = jSONObjectG.optInt("result", -1);
        if (iOptInt4 != -1) {
            ee.a("DeviceTypeUtils", "detected by system feature: " + a(iOptInt4));
        }
        JSONObject jSONObjectD = d();
        a(jSONObject, "fold", jSONObjectD);
        boolean zOptBoolean3 = jSONObjectD.optBoolean("det", false);
        boolean zOptBoolean4 = jSONObjectD.optBoolean("mw_c", false);
        if (!zOptBoolean3) {
            str = zOptBoolean4 ? "detected foldable candidate (large screen + multiwindow)" : "detected as foldable phone";
            JSONObject jSONObjectH = h();
            a(jSONObject, "bp", jSONObjectH);
            iOptInt = jSONObjectH.optInt("result", -1);
            a("build property", iOptInt);
            JSONObject jSONObjectE = e();
            a(jSONObject, "stor", jSONObjectE);
            zOptBoolean = jSONObjectE.optBoolean("p_det", false);
            zOptBoolean2 = jSONObjectE.optBoolean("t_det", false);
            if (zOptBoolean) {
                ee.a("DeviceTypeUtils", "detected as phone by storage mount");
            }
            if (zOptBoolean2) {
                ee.a("DeviceTypeUtils", "detected as tablet by storage mount");
            }
            JSONObject jSONObjectF = f();
            a(jSONObject, "scr", jSONObjectF);
            iOptInt2 = jSONObjectF.optInt("result", -1);
            if (iOptInt2 == 0) {
                ee.a("DeviceTypeUtils", "detected as phone by screen size");
            }
            if (iOptInt2 == 1) {
                if (!zOptBoolean3 && iOptInt2 == 1 && (contextA = jg.a()) != null) {
                    try {
                        if (contextA.getPackageManager().hasSystemFeature("android.software.freeform_window_management")) {
                            try {
                                jSONObjectD.put("det", true);
                                if (!jSONObjectD.has("m")) {
                                    jSONObjectD.put("m", "multiwindow");
                                }
                            } catch (JSONException e9) {
                                ee.d("DeviceTypeUtils", "put foldable multiwindow data err: " + e9.getMessage());
                            }
                            ee.a("DeviceTypeUtils", "large screen with multiwindow support, detected as foldable phone");
                        }
                    } catch (Throwable th) {
                        ee.a("DeviceTypeUtils", "check multiwindow err: " + th.getMessage());
                    }
                }
                zOptBoolean3 = jSONObjectD.optBoolean("det", false);
                ee.a("DeviceTypeUtils", "detected as tablet by screen size");
            }
            JSONObject jSONObjectI = i();
            a(jSONObject, "ui", jSONObjectI);
            iOptInt3 = jSONObjectI.optInt("result", -1);
            a("ui mode", iOptInt3);
            if (iOptInt == 1 && iOptInt2 == -1) {
                ee.a("DeviceTypeUtils", "enhanced screen result by build property");
                iOptInt2 = 1;
            }
            ee.a("DeviceTypeUtils", "=== detection summary ===");
            ee.a("DeviceTypeUtils", "system_feature:" + iOptInt4 + ", foldable:" + zOptBoolean3 + ", build_property:" + iOptInt + ", phone_storage:" + zOptBoolean + ", tablet_storage:" + zOptBoolean2 + ", screen:" + iOptInt2 + ", ui_mode:" + iOptInt3);
            if (!zOptBoolean3 && zOptBoolean4 && iOptInt2 == 1) {
                ee.a("DeviceTypeUtils", "enhanced foldable detection: multiwindow candidate + tablet screen");
                zOptBoolean3 = true;
            }
            if (iOptInt4 == 3) {
                jiVar = new ji(3, 0, "system feature");
            } else if (iOptInt4 == 2) {
                jiVar = new ji(2, 1, "system feature");
            } else if (iOptInt4 == 7) {
                jiVar = new ji(7, 2, "system feature");
            } else if (iOptInt4 == 4) {
                jiVar = new ji(4, 3, "system feature");
            } else if (iOptInt4 == 6) {
                jiVar = new ji(6, 4, "system feature");
            } else if (iOptInt3 == 5) {
                jiVar = new ji(5, 6, "ui mode");
            } else if (zOptBoolean3) {
                jiVar = new ji(0, 7, "foldable");
            } else if (iOptInt4 == 0) {
                jiVar = new ji(0, 8, "system feature");
            } else if (iOptInt4 == 1) {
                jiVar = new ji(1, 9, "system feature");
            } else if (iOptInt == 7) {
                jiVar = new ji(7, 10, "build property");
            } else if (iOptInt == 8) {
                jiVar = new ji(8, 11, "build property");
            } else if (iOptInt == 9) {
                jiVar = new ji(9, 12, "build property");
            } else if (iOptInt == 1) {
                jiVar = new ji(1, 13, "build property");
            } else if (iOptInt == 0) {
                jiVar = new ji(0, 14, "build property");
            } else if (iOptInt2 == 0) {
                jiVar = new ji(0, 15, "screen size");
            } else if (iOptInt2 == 1) {
                jiVar = new ji(1, 16, "screen size");
            } else if (iOptInt3 == 0) {
                jiVar = new ji(0, 17, "ui mode");
            } else if (iOptInt3 == 1) {
                jiVar = new ji(1, 18, "ui mode");
            } else {
                if (zOptBoolean) {
                    jiVar2 = new ji(0, 19, "storage mount (weak)");
                } else if (zOptBoolean2) {
                    jiVar2 = new ji(1, 20, "storage mount (weak)");
                } else {
                    jiVar = new ji(-1, 21, "unknown");
                }
                jiVar = jiVar2;
            }
            ee.a("DeviceTypeUtils", "final result: " + a(jiVar.f10275a) + " (" + jiVar.f10277c + ")");
            return a(jiVar.f10275a, jiVar.f10276b, jSONObject);
        }
        ee.a("DeviceTypeUtils", str);
        JSONObject jSONObjectH2 = h();
        a(jSONObject, "bp", jSONObjectH2);
        iOptInt = jSONObjectH2.optInt("result", -1);
        a("build property", iOptInt);
        JSONObject jSONObjectE2 = e();
        a(jSONObject, "stor", jSONObjectE2);
        zOptBoolean = jSONObjectE2.optBoolean("p_det", false);
        zOptBoolean2 = jSONObjectE2.optBoolean("t_det", false);
        if (zOptBoolean) {
            ee.a("DeviceTypeUtils", "detected as phone by storage mount");
        }
        if (zOptBoolean2) {
            ee.a("DeviceTypeUtils", "detected as tablet by storage mount");
        }
        JSONObject jSONObjectF2 = f();
        a(jSONObject, "scr", jSONObjectF2);
        iOptInt2 = jSONObjectF2.optInt("result", -1);
        if (iOptInt2 == 0) {
            ee.a("DeviceTypeUtils", "detected as phone by screen size");
        }
        if (iOptInt2 == 1) {
            if (!zOptBoolean3) {
                if (contextA.getPackageManager().hasSystemFeature("android.software.freeform_window_management")) {
                    jSONObjectD.put("det", true);
                    if (!jSONObjectD.has("m")) {
                        jSONObjectD.put("m", "multiwindow");
                    }
                    ee.a("DeviceTypeUtils", "large screen with multiwindow support, detected as foldable phone");
                }
            }
            zOptBoolean3 = jSONObjectD.optBoolean("det", false);
            ee.a("DeviceTypeUtils", "detected as tablet by screen size");
        }
        JSONObject jSONObjectI2 = i();
        a(jSONObject, "ui", jSONObjectI2);
        iOptInt3 = jSONObjectI2.optInt("result", -1);
        a("ui mode", iOptInt3);
        if (iOptInt == 1) {
            ee.a("DeviceTypeUtils", "enhanced screen result by build property");
            iOptInt2 = 1;
        }
        ee.a("DeviceTypeUtils", "=== detection summary ===");
        ee.a("DeviceTypeUtils", "system_feature:" + iOptInt4 + ", foldable:" + zOptBoolean3 + ", build_property:" + iOptInt + ", phone_storage:" + zOptBoolean + ", tablet_storage:" + zOptBoolean2 + ", screen:" + iOptInt2 + ", ui_mode:" + iOptInt3);
        if (!zOptBoolean3) {
            ee.a("DeviceTypeUtils", "enhanced foldable detection: multiwindow candidate + tablet screen");
            zOptBoolean3 = true;
        }
        if (iOptInt4 == 3) {
            jiVar = new ji(3, 0, "system feature");
        } else if (iOptInt4 == 2) {
            jiVar = new ji(2, 1, "system feature");
        } else if (iOptInt4 == 7) {
            jiVar = new ji(7, 2, "system feature");
        } else if (iOptInt4 == 4) {
            jiVar = new ji(4, 3, "system feature");
        } else if (iOptInt4 == 6) {
            jiVar = new ji(6, 4, "system feature");
        } else if (iOptInt3 == 5) {
            jiVar = new ji(5, 6, "ui mode");
        } else if (zOptBoolean3) {
            jiVar = new ji(0, 7, "foldable");
        } else if (iOptInt4 == 0) {
            jiVar = new ji(0, 8, "system feature");
        } else if (iOptInt4 == 1) {
            jiVar = new ji(1, 9, "system feature");
        } else if (iOptInt == 7) {
            jiVar = new ji(7, 10, "build property");
        } else if (iOptInt == 8) {
            jiVar = new ji(8, 11, "build property");
        } else if (iOptInt == 9) {
            jiVar = new ji(9, 12, "build property");
        } else if (iOptInt == 1) {
            jiVar = new ji(1, 13, "build property");
        } else if (iOptInt == 0) {
            jiVar = new ji(0, 14, "build property");
        } else if (iOptInt2 == 0) {
            jiVar = new ji(0, 15, "screen size");
        } else if (iOptInt2 == 1) {
            jiVar = new ji(1, 16, "screen size");
        } else if (iOptInt3 == 0) {
            jiVar = new ji(0, 17, "ui mode");
        } else if (iOptInt3 == 1) {
            jiVar = new ji(1, 18, "ui mode");
        } else {
            if (zOptBoolean) {
                jiVar2 = new ji(0, 19, "storage mount (weak)");
            } else if (zOptBoolean2) {
                jiVar2 = new ji(1, 20, "storage mount (weak)");
            } else {
                jiVar = new ji(-1, 21, "unknown");
            }
            jiVar = jiVar2;
        }
        ee.a("DeviceTypeUtils", "final result: " + a(jiVar.f10275a) + " (" + jiVar.f10277c + ")");
        return a(jiVar.f10275a, jiVar.f10276b, jSONObject);
    }

    private static JSONObject a(int i9, int i10, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("result", i9);
            jSONObject2.put("resultDesc", i10);
            if (jSONObject.length() > 0) {
                jSONObject2.put("evidences", jSONObject);
                return jSONObject2;
            }
        } catch (JSONException e9) {
            ee.d("DeviceTypeUtils", "build json result err: " + e9.getMessage());
            try {
                jSONObject2.put("result", i9);
                jSONObject2.put("resultDesc", i10);
            } catch (JSONException e10) {
                ee.d("DeviceTypeUtils", "build basic json result err: " + e10.getMessage());
                return new JSONObject();
            }
        }
        return jSONObject2;
    }

    private static void a(String str, int i9) {
        if (i9 != -1) {
            ee.a("DeviceTypeUtils", "detected as " + a(i9) + " by " + str);
        }
    }

    private static void a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e9) {
            StringBuilder sbI = defpackage.f.i("put ", str, " data err: ");
            sbI.append(e9.getMessage());
            ee.d("DeviceTypeUtils", sbI.toString());
        }
    }

    private static void a(JSONObject jSONObject, String[] strArr, int i9, String str) throws JSONException {
        String str2;
        boolean zEquals;
        JSONObject jSONObject2 = null;
        try {
            if (jSONObject.has("fp")) {
                jSONObject2 = jSONObject.getJSONObject("fp");
            }
        } catch (JSONException unused) {
        }
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        boolean z8 = false;
        for (String str3 : strArr) {
            String strA = ks.a(str3, "");
            if (!TextUtils.isEmpty(strA)) {
                jSONObject2.put(str3, strA);
                switch (i9) {
                    case 1:
                        str2 = "1";
                        zEquals = str2.equals(strA);
                        break;
                    case 2:
                        str2 = "foldable";
                        zEquals = str2.equals(strA);
                        break;
                    case 3:
                        zEquals = strA.contains(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        break;
                    case 4:
                        zEquals = true;
                        break;
                    case 5:
                        zEquals = "foldphone".equals(strA.toLowerCase()) || strA.toLowerCase().contains("fold");
                        break;
                    case 6:
                        zEquals = strA.contains(Constants.ACCEPT_TIME_SEPARATOR_SP) && strA.matches(".*\\d+.*,.*\\d+.*");
                        break;
                    case 7:
                        zEquals = "fold".equals(strA);
                        break;
                    default:
                        zEquals = false;
                        break;
                }
                if (zEquals) {
                    jSONObject.put("det", true);
                    if (!jSONObject.has("m")) {
                        jSONObject.put("m", str);
                    }
                }
                z8 = true;
            }
        }
        if (z8) {
            jSONObject.put("fp", jSONObject2);
        }
    }

    private static boolean a(PackageManager packageManager, String str) {
        try {
            return packageManager.hasSystemFeature(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a(Configuration configuration) {
        try {
            return configuration.smallestScreenWidthDp >= 600;
        } catch (Throwable unused) {
        }
    }

    private static boolean a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : strArr) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(JSONObject jSONObject, String str, String str2, String str3, String str4, String[] strArr, int i9) {
        try {
            if (!a(str, strArr) && !a(str2, strArr) && !a(str3, strArr) && !a(str4, strArr)) {
                i9 = -1;
            }
            if (i9 == -1) {
                return false;
            }
            jSONObject.put("result", i9);
            return true;
        } catch (JSONException e9) {
            ee.d("DeviceTypeUtils", "detect keyword result err: " + e9.getMessage());
            return false;
        }
    }
}
