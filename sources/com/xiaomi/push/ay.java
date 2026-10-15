package com.xiaomi.push;

import android.net.NetworkInfo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkInfo f17069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ConcurrentHashMap<String, Object> f135a = new ConcurrentHashMap<>();

    public ay(NetworkInfo networkInfo) {
        this.f17069a = networkInfo;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    private <T> T a(String str) {
        Object objValueOf;
        if (!this.f135a.containsKey(str)) {
            synchronized (str) {
                try {
                    if (!this.f135a.contains(str)) {
                        switch (str) {
                            case "getType":
                                objValueOf = Integer.valueOf(this.f17069a.getType());
                                break;
                            case "getTypeName":
                                objValueOf = this.f17069a.getTypeName();
                                break;
                            case "getSubtype":
                                objValueOf = Integer.valueOf(this.f17069a.getSubtype());
                                break;
                            case "getSubtypeName":
                                objValueOf = this.f17069a.getSubtypeName();
                                break;
                            case "isConnected":
                                objValueOf = Boolean.valueOf(this.f17069a.isConnected());
                                break;
                            case "getState":
                                objValueOf = this.f17069a.getState();
                                break;
                            case "getDetailedState":
                                objValueOf = this.f17069a.getDetailedState();
                                break;
                            default:
                                objValueOf = null;
                                break;
                        }
                        if (objValueOf != null) {
                            this.f135a.put(str, objValueOf);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return (T) this.f135a.get(str);
    }

    public int b() {
        return ((Integer) a("getSubtype")).intValue();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m118b() {
        return (String) a("getSubtypeName");
    }

    public int a() {
        return ((Integer) a("getType")).intValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m116a() {
        return (String) a("getTypeName");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m117a() {
        return ((Boolean) a("isConnected")).booleanValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NetworkInfo.State m115a() {
        return (NetworkInfo.State) a("getState");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NetworkInfo.DetailedState m114a() {
        return (NetworkInfo.DetailedState) a("getDetailedState");
    }
}
