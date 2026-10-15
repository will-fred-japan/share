package com.heytap.mcssdk.b;

import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends BaseMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14222a = "&";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f14228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14229h = -2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f14230i;
    private String j;

    public String a() {
        return this.f14223b;
    }

    public String b() {
        return this.f14224c;
    }

    public String c() {
        return this.f14225d;
    }

    public String d() {
        return this.f14226e;
    }

    public int e() {
        return this.f14227f;
    }

    public String f() {
        return this.f14228g;
    }

    public int g() {
        return this.f14229h;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return MessageConstant.MessageType.MESSAGE_CALL_BACK;
    }

    public String h() {
        return this.j;
    }

    public String i() {
        return this.f14230i;
    }

    public String toString() {
        return "CallBackResult{, mRegisterID='" + this.f14225d + "', mSdkVersion='" + this.f14226e + "', mCommand=" + this.f14227f + "', mContent='" + this.f14228g + "', mAppPackage=" + this.f14230i + "', mResponseCode=" + this.f14229h + ", miniProgramPkg=" + this.j + '}';
    }

    public static <T> String a(List<T> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("&");
        }
        return sb.toString();
    }

    public void b(int i9) {
        this.f14229h = i9;
    }

    public void c(String str) {
        this.f14225d = str;
    }

    public void d(String str) {
        this.f14226e = str;
    }

    public void e(String str) {
        this.f14228g = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.f14230i = str;
    }

    public void a(int i9) {
        this.f14227f = i9;
    }

    public void b(String str) {
        this.f14224c = str;
    }

    public void a(String str) {
        this.f14223b = str;
    }
}
