package cn.jpush.android.cache;

import W5.e;

/* JADX INFO: loaded from: classes.dex */
public class Key<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f11267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f11268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    T f11269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f11270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f11271e;

    private Key(String str, String str2, T t) {
        this.f11267a = str;
        this.f11268b = str2;
        if (t == null) {
            throw new IllegalArgumentException("default value can not be null");
        }
        this.f11269c = t;
    }

    public static Key<Boolean> AllowRunningProcess() {
        return new Key("cn.jpush.config", "AllowRunningProcess", Boolean.FALSE).a();
    }

    public static Key<Integer> BadgeCurNum() {
        return new Key("cn.jpush.config", "badgeCurNum", 0).a();
    }

    public static Key<Long> BlackPagesInternalTime() {
        return new Key("cn.jpush.config", "BInternalTime", 21600L).a();
    }

    public static Key<Long> BlackPagesLastReqTime() {
        return new Key("cn.jpush.config", "BLastReqTime", 0L).a();
    }

    public static Key<String> FCM_ClearFlag() {
        return new Key("cn.jpush.config", "fcm_clear_flag", "").a();
    }

    public static Key<Boolean> IgnoreLocalAllowRPConfig() {
        return new Key("cn.jpush.config", "IgnoreLocalAllowRPConfig", Boolean.FALSE).a();
    }

    public static Key<Integer> IsNotificationEnabledLastTime() {
        return new Key("cn.jpush.config", "isNotificationEnabledLastTime", -1).a();
    }

    public static Key<String> JAppKey(String str) {
        return new Key("cn.jpush.config", e.u(str, "j_key"), "").b();
    }

    public static Key<String> LastAniConfigPath() {
        return new Key("cn.jpush.config", "LastAniConfigPath", "").a();
    }

    public static Key<Long> LastAniConfigReqTime() {
        return new Key("cn.jpush.config", "LastAniConfigReqTime", 0L).a();
    }

    public static Key<Long> LastReportApiStatisticTime() {
        return new Key("cn.jpush.config", "LastReportApiStatisticTime", 0L).a();
    }

    public static Key<String> LocalAniConfigSign() {
        return new Key("cn.jpush.config", "LocalAniConfigSign", "").a();
    }

    public static Key<Integer> LocalAniConfigVersion() {
        return new Key("cn.jpush.config", "LocalAniConfigVersion", 0).a();
    }

    public static Key<String> MAppId(String str) {
        return new Key("cn.jpush.config", e.u(str, "m_id"), "").b();
    }

    public static Key<String> MAppKey(String str) {
        return new Key("cn.jpush.config", e.u(str, "m_key"), "").b();
    }

    public static Key<String> MAppSecret(String str) {
        return new Key("cn.jpush.config", e.u(str, "m_scrt"), "").b();
    }

    public static Key<String> NotiCancel() {
        return new Key("cn.jpush.config", "NotiCancel", "").a();
    }

    public static Key<String> NotiSchedule() {
        return new Key("cn.jpush.config", "NotiSchedule", "").a();
    }

    public static Key<String> NotiShow() {
        return new Key("cn.jpush.config", "NotiShow", "").a();
    }

    public static Key<Long> PushStatusSyncTime() {
        return new Key("cn.jpush.config", "PushStatusSyncTime", 0L).a();
    }

    public static Key<Integer> PushVerCode() {
        return new Key("cn.jpush.config", "versionCode", 0).a();
    }

    public static Key<String> SvrAniConfigSign() {
        return new Key("cn.jpush.config", "SvrAniConfigSign", "").a();
    }

    public static Key<String> ThirdPush_ClearFlag() {
        return new Key("cn.jpush.config", "third_push_clear_flag", "").a();
    }

    public static Key<String> ThirdPush_RegID(byte b9) {
        return new Key("cn.jpush.config", e.i(b9, "pluginPlatformRegid_v2"), "").a();
    }

    public static Key<Boolean> ThirdPush_RegUpload(byte b9) {
        return new Key("cn.jpush.config", e.i(b9, "pluginPlatformRegidupload"), Boolean.FALSE).a();
    }

    public static Key<Boolean> UPSRegister() {
        return new Key<>("cn.jpush.config", "upsRegister", Boolean.TRUE);
    }

    public static Key<Integer> VoipStatus(byte b9) {
        return new Key("cn.jpush.config", e.i(b9, "voip_status_"), 0).a();
    }

    private Key<T> a() {
        this.f11270d = true;
        return this;
    }

    private Key<T> b() {
        this.f11271e = true;
        return this;
    }

    public static Key<Boolean> isEnableUA() {
        return new Key("cn.jpush.config", "IsEnableUA", Boolean.TRUE).a();
    }

    public static Key<Integer> registerType() {
        return new Key("cn.jpush.config", "r_type", 0).a();
    }

    public Key<T> file(String str) {
        this.f11267a = str;
        return this;
    }

    public Key<T> name(String str) {
        this.f11268b = str;
        return this;
    }

    public Key<T> set(T t) {
        this.f11269c = t;
        return this;
    }
}
