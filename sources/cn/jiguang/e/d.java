package cn.jiguang.e;

import cn.jiguang.aw.v;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;

/* JADX INFO: loaded from: classes.dex */
public class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f10491a = "cn.jpush.preferences.v2";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f10492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f10493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    T f10494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f10495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f10496f;

    public static class a {

        /* JADX INFO: renamed from: cn.jiguang.e.d$a$a, reason: collision with other inner class name */
        public static class C0130a {
            public static d<Long> a() {
                return new d("cn.jiguang.sdk.user.profile", "key_uid_e", 0L).aY().aZ();
            }

            public static d<Long> b() {
                return new d("cn.jiguang.sdk.user.profile", "key_uid", 0L).aY();
            }

            public static d<String> c() {
                return new d("cn.jiguang.sdk.user.profile", "key_rid_e", "").aY().aZ();
            }

            public static d<String> d() {
                return new d("cn.jiguang.sdk.user.profile", "key_rid", "").aY();
            }
        }
    }

    public d(String str, String str2, T t) {
        this.f10492b = str;
        this.f10493c = str2;
        if (t == null) {
            throw new IllegalArgumentException("default value can not be null");
        }
        this.f10494d = t;
    }

    public static d<Long> A() {
        return new d<>("cn.jpush.android.user.profile", "net_conn_req", 0L);
    }

    public static d<Long> B() {
        return new d<>("cn.jpush.android.user.profile", "net_conn_count", 0L);
    }

    public static d<Long> C() {
        return new d<>("cn.jpush.android.user.profile", "net_conn_res", 0L);
    }

    public static d<Long> D() {
        return new d<>("cn.jpush.android.user.profile", "net_day_time", 0L);
    }

    public static d<Long> E() {
        return new d("cn.jpush.android.user.profile", "tcp_boot_timestamp", 0L).aY();
    }

    public static d<Long> F() {
        return new d("cn.jpush.android.user.profile", "tcp_report_boot_timestamp", 0L).aY();
    }

    public static d<Long> G() {
        return new d("cn.jpush.android.user.profile", "tcp_time_report_time", 0L).aY();
    }

    public static d<Integer> H() {
        return new d("cn.jpush.android.user.cold_start_main", "cs_cnt", 0).aY();
    }

    public static d<Integer> I() {
        return new d("cn.jpush.android.user.cold_start", "sub_cs_cnt", 0).aY();
    }

    public static d<Integer> J() {
        return new d("cn.jpush.android.user.cold_start", "sub_cs_decr_cnt", 0).aY();
    }

    public static d<Long> K() {
        return new d("cn.jpush.android.user.cold_start", "main_start_id", 0L).aY();
    }

    public static d<Boolean> L() {
        return new d<>("cn.jiguang.sdk.user.profile", "tcp_login", Boolean.FALSE);
    }

    public static d<Boolean> M() {
        return new d<>("cn.jiguang.sdk.user.profile", "report_state", Boolean.FALSE);
    }

    public static d<Long> N() {
        return new d("cn.jiguang.sdk.user.profile", "key_uid_e", 0L).aY().aZ();
    }

    public static d<String> O() {
        return new d("cn.jiguang.sdk.user.profile", "key_rid_e", "").aY().aZ();
    }

    public static d<Long> P() {
        return new d("cn.jiguang.sdk.user.profile", "key_rid_time", 0L).aY();
    }

    public static d<String> Q() {
        return new d("cn.jiguang.sdk.user.profile", "key_ww", "").aY().aZ();
    }

    public static d<String> R() {
        return new d("cn.jiguang.sdk.user.profile", "key_pwd", "").aY();
    }

    public static d<Integer> S() {
        return new d("cn.jiguang.sdk.user.profile", "idc", -1).aY();
    }

    public static d<Long> T() {
        return new d<>("cn.jiguang.sdk.user.profile", "login_local_time", -1L);
    }

    public static d<Long> U() {
        return new d<>("cn.jiguang.sdk.user.profile", "login_server_time", -1L);
    }

    public static d<Long> V() {
        return new d<>("cn.jiguang.sdk.user.profile", "sync_auth", -1L);
    }

    public static d<String> W() {
        return new d("cn.jiguang.sdk.user.profile", "key_c", "").aY();
    }

    public static d<String> X() {
        return new d<>("cn.jiguang.sdk.reg_finger.profile", "reg_n_rule", "");
    }

    public static d<Integer> Y() {
        return new d<>("cn.jiguang.sdk.reg_finger.profile", "reg_new", 0);
    }

    public static d<Boolean> Z() {
        return new d<>("cn.jpush.android.user.profile", "exception_switch", Boolean.FALSE);
    }

    public static d<String> a() {
        return new d("cn.jpush.android.user.profile", "devcie_id_generated", "").aY();
    }

    public static d<Long> aA() {
        return new d<>("cn.jpush.preferences.v2.rid", "next_rid", -1L);
    }

    public static d<Integer> aB() {
        return new d<>("cn.jpush.preferences.v2.rid", "seq_id", -1);
    }

    public static d<String> aC() {
        return new d("cn.jiguang.sdk.address", "ips_in_last_good_sis", "").aZ();
    }

    public static d<String> aD() {
        return new d("cn.jiguang.sdk.address", "ssl_ips_in_last_good_sis", "").aZ();
    }

    public static d<Boolean> aE() {
        return new d<>("cn.jiguang.sdk.address", "udp_data_report", Boolean.FALSE);
    }

    public static d<Long> aF() {
        return new d<>("cn.jiguang.sdk.address", "sis_last_update", 0L);
    }

    public static d<Long> aG() {
        return new d<>("cn.jiguang.sdk.address", "last_sis_report_time", 0L);
    }

    public static d<String> aH() {
        return new d("cn.jiguang.sdk.address", "default_sis_ips", "").aZ();
    }

    public static d<String> aI() {
        return new d("cn.jiguang.sdk.address", "default_conn", "").aZ();
    }

    public static d<String> aJ() {
        return new d("cn.jiguang.sdk.address", "default_conn_srv", "").aZ();
    }

    public static d<String> aK() {
        return new d("cn.jiguang.sdk.address", "tcp_report", "").aY().aZ();
    }

    public static d<String> aL() {
        return new d<>("PrefsFile", "key", "");
    }

    public static d<Integer> aM() {
        return new d("internal_debug", "log_enable", 0).aY();
    }

    public static d<Integer> aN() {
        return new d("internal_debug", "cmd_print_log", 0).aY();
    }

    public static d<Long> aO() {
        return new d("internal_debug", "expire", 0L).aY();
    }

    public static d<Integer> aP() {
        return new d("internal_debug", "delay_upload", 0).aY();
    }

    public static d<Long> aQ() {
        return new d<>("internal_debug", "sentry_time", 0L);
    }

    public static d<Boolean> aR() {
        return new d<>("internal_debug", "sentry_sample_switch", Boolean.FALSE);
    }

    public static d<Boolean> aS() {
        return new d<>("internal_debug", "net_m_switch", Boolean.TRUE);
    }

    public static d<String> aT() {
        return new d<>("cn.jiguang.sdk.device", "di_ml", "");
    }

    public static d<String> aU() {
        return new d<>("cn.jiguang.sdk.device", "di_mft", "");
    }

    public static d<String> aV() {
        return new d<>("cn.jiguang.sdk.device", "di_rm", "");
    }

    public static d<String> aW() {
        return new d("cn.jiguang.sdk.device", "de_info", "").aZ();
    }

    public static d<String> aX() {
        return new d("cn.jiguang.sdk.device", "loc_info", "").aZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d<T> aY() {
        this.f10495e = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d<T> aZ() {
        this.f10496f = true;
        return this;
    }

    public static d<String> aa() {
        return new d<>("cn.jiguang.sdk.user.set.profile", "option_channel", "");
    }

    public static d<String> ab() {
        return new d<>("cn.jiguang.sdk.user.set.profile", "analytics_account_id", "");
    }

    public static d<Boolean> ac() {
        return new d<>("cn.jiguang.sdk.user.set.profile", "is_ups_register", Boolean.TRUE);
    }

    public static d<Long> ad() {
        return new d<>("Push_Page_Config", "css", 0L);
    }

    public static d<Long> ae() {
        return new d<>("Push_Page_Config", "cse", 0L);
    }

    public static d<Long> af() {
        return new d<>("Push_Page_Config", "last_pause", -1L);
    }

    public static d<String> ag() {
        return new d<>("Push_Page_Config", "session_id", "");
    }

    public static d<String> ah() {
        return new d("cn.jiguang.sdk.report", "report_urls", "").aZ();
    }

    public static d<String> ai() {
        return new d("cn.jiguang.sdk.report", "report_sis_urls", "").aZ();
    }

    public static d<Long> aj() {
        return new d<>("cn.jiguang.sdk.report", "last_update_report_urls", 0L);
    }

    public static d<Long> ak() {
        return new d<>("cn.jiguang.sdk.report", "report_urls_ttl_millis", 3600000L);
    }

    public static d<Integer> al() {
        return new d(f10491a, "sp_sdk_version", 0).aY();
    }

    public static d<String> am() {
        return new d(f10491a, HianalyticsBaseData.SDK_VERSION, "").aY();
    }

    public static d<Long> an() {
        return new d<>(f10491a, "first_init", 0L);
    }

    public static d<Long> ao() {
        return new d<>(f10491a, "exception_report_mill", 0L);
    }

    public static d<Long> ap() {
        return new d<>(f10491a, "lbs_delay", 0L);
    }

    public static d<Boolean> aq() {
        return new d<>(f10491a, "jcore_lbs_enable", Boolean.TRUE);
    }

    public static d<Boolean> ar() {
        return new d<>("cn.jpush.android.user.profile", "is_tcp_close", Boolean.FALSE);
    }

    public static d<Integer> as() {
        return new d("cn.jpush.android.user.profile", "jpush_register_code", -1).aY();
    }

    public static d<String> at() {
        return new d<>(f10491a, "device_config_appkey_n", "");
    }

    public static d<String> au() {
        return new d<>(f10491a, "device_config_appkey", "");
    }

    public static d<String> av() {
        return new d<>(f10491a, "i_new", "");
    }

    public static d<String> aw() {
        return new d<>(f10491a, "push_udid", "");
    }

    public static d<String> ax() {
        return new d<>(f10491a, "last_connection_type", "");
    }

    public static d<String> ay() {
        return new d(f10491a, "sis_report_history", "").aZ();
    }

    public static d<Boolean> az() {
        return new d("internal_debug", "cmd_export_log", Boolean.FALSE).aY();
    }

    public static d<String> b() {
        return new d("cn.jpush.android.user.profile", "devcie_id_generated_n", "").aY();
    }

    public static d<Boolean> c() {
        return new d<>("cn.jpush.android.user.profile", "anr_switch", Boolean.FALSE);
    }

    public static d<Boolean> d() {
        return new d("cn.jpush.android.user.profile", "notify_mssl_verify", Boolean.FALSE).aY();
    }

    public static d<String> e() {
        return new d("cn.jpush.android.user.profile", "cid_desc_data", "").aY();
    }

    public static d<Long> f() {
        return new d<>("cn.jpush.android.user.profile", "ex_report_time", 0L);
    }

    public static d<Long> g() {
        return new d<>("cn.jpush.android.user.profile", "net_data_report_time", 0L);
    }

    public static d<Boolean> h() {
        return new d<>("cn.jpush.android.user.profile", "enable_auto_wakeup", Boolean.TRUE);
    }

    public static d<Boolean> i() {
        return new d<>("cn.jpush.android.user.profile", "enable_ci", Boolean.FALSE);
    }

    public static d<Boolean> j() {
        return new d<>("cn.jpush.android.user.profile", "enable_dynamicload", Boolean.TRUE);
    }

    public static d<Boolean> k() {
        return new d<>("cn.jpush.android.user.profile", "enable_appterminate", Boolean.TRUE);
    }

    public static d<Boolean> l() {
        return new d<>("cn.jpush.android.user.profile", "re_k_e_v2", Boolean.TRUE);
    }

    public static d<Boolean> m() {
        return new d<>("cn.jpush.android.user.profile", "connect_tcp_key_encrypt", Boolean.FALSE);
    }

    public static d<Boolean> n() {
        return new d<>("cn.jpush.android.user.profile", "use_connect_tcp_ssl", Boolean.FALSE);
    }

    public static d<Boolean> o() {
        return new d<>("cn.jpush.android.user.profile", "use_report_tcp_time_switch", Boolean.TRUE);
    }

    public static d<Boolean> p() {
        return new d<>("cn.jpush.android.user.profile", "count_switch", Boolean.TRUE);
    }

    public static d<Boolean> q() {
        return new d<>("cn.jpush.android.user.profile", "android_tcpreport_switch", Boolean.TRUE);
    }

    public static d<Boolean> r() {
        return new d<>("cn.jpush.android.user.profile", "tcp_exception_report_switch", Boolean.FALSE);
    }

    public static d<Boolean> s() {
        return new d<>("cn.jpush.android.user.profile", "net_length_switch", Boolean.FALSE);
    }

    public static d<Long> t() {
        return new d<>("cn.jpush.android.user.profile", "net_count_threshold", Long.valueOf(cn.jiguang.am.c.f9315b));
    }

    public static d<Long> u() {
        return new d<>("cn.jpush.android.user.profile", "net_length_threshold", Long.valueOf(cn.jiguang.am.c.f9314a));
    }

    public static d<Long> v() {
        return new d<>("cn.jpush.android.user.profile", "net_conn_count_threshold", Long.valueOf(cn.jiguang.am.c.f9317d));
    }

    public static d<Long> w() {
        return new d<>("cn.jpush.android.user.profile", "net_conn_length_threshold", Long.valueOf(cn.jiguang.am.c.f9316c));
    }

    public static d<Long> x() {
        return new d<>("cn.jpush.android.user.profile", "net_req", 0L);
    }

    public static d<Long> y() {
        return new d<>("cn.jpush.android.user.profile", "net_count", 0L);
    }

    public static d<Long> z() {
        return new d<>("cn.jpush.android.user.profile", "net_res", 0L);
    }

    public static d<Long> c(String str) {
        return new d<>("cn.jiguang.sdk.address", W5.e.l("dns_last_update_", str), 0L);
    }

    public static d<String> d(String str) {
        return new d("cn.jiguang.sdk.address", W5.e.l("srv_", str), "").aZ();
    }

    public static d<Long> e(String str) {
        return new d<>("cn.jiguang.sdk.address", W5.e.l("srv_last_update_", str), 0L);
    }

    public static d<String> f(String str) {
        return new d("IpInfos", str, "").aZ();
    }

    public static d<String> g(String str) {
        return new d("IpInfos", v.d(str), "").aZ();
    }

    public static d<Integer> h(String str) {
        return new d<>("netinfo", str, 0);
    }

    public d<T> i(String str) {
        this.f10492b = str;
        return this;
    }

    public d<T> j(String str) {
        this.f10493c = str;
        return this;
    }

    public static d<String> b(String str) {
        return new d("cn.jiguang.sdk.address", W5.e.l("dns_", str), "").aZ();
    }

    public d<T> a(T t) {
        this.f10494d = t;
        return this;
    }

    public static d<String> a(String str) {
        return new d<>("cn.jpush.android.user.profile", W5.e.l("sdk_version_", str), "");
    }

    public static d<String> c(boolean z8) {
        return new d("cn.jiguang.sdk.address", "last_good_conn".concat(z8 ? "_V4" : "_V6"), "").aZ();
    }

    public static d<String> d(boolean z8) {
        return new d("cn.jiguang.sdk.address", z8 ? "default_https_report" : "default_http_report", "").aY().aZ();
    }

    public static d<String> b(boolean z8) {
        return new d("cn.jiguang.sdk.address", "last_good_sis_address".concat(z8 ? "_V4" : "_V6"), "").aZ();
    }

    public static d<String> a(boolean z8) {
        return new d("cn.jiguang.sdk.address", z8 ? "default_https_report" : "default_http_report", "").aY().aZ();
    }
}
