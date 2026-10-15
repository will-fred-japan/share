package cn.jiguang.commons.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public final class kq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f10376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantReadWriteLock f10377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f10378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReentrantReadWriteLock.WriteLock f10379d;

    private kq() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f10377b = reentrantReadWriteLock;
        this.f10378c = reentrantReadWriteLock.readLock();
        this.f10379d = reentrantReadWriteLock.writeLock();
        this.f10376a = jg.a().getSharedPreferences("app_prefs", 0);
    }

    public static kq a() {
        return kr.f10380a;
    }

    public final int b(String str, int i9) {
        this.f10378c.lock();
        try {
            return this.f10376a.getInt(ks.a(str), i9);
        } finally {
            this.f10378c.unlock();
        }
    }

    public final String c(String str, String str2) {
        this.f10378c.lock();
        try {
            String string = this.f10376a.getString(ks.a(str), str2);
            if (!TextUtils.equals(string, str2)) {
                string = ks.a(string);
            }
            return string;
        } finally {
            this.f10378c.unlock();
        }
    }

    public /* synthetic */ kq(byte b9) {
        this();
    }

    public final void a(String str) {
        this.f10379d.lock();
        try {
            this.f10376a.edit().remove(ks.a(str)).apply();
        } finally {
            this.f10379d.unlock();
        }
    }

    public final long b(String str, long j) {
        this.f10378c.lock();
        try {
            return this.f10376a.getLong(ks.a(str), j);
        } finally {
            this.f10378c.unlock();
        }
    }

    public final void a(String str, int i9) {
        this.f10379d.lock();
        try {
            this.f10376a.edit().putInt(ks.a(str), i9).apply();
        } finally {
            this.f10379d.unlock();
        }
    }

    public final void b(String str, String str2) {
        this.f10379d.lock();
        try {
            this.f10376a.edit().putString(ks.a(str), ks.a(str2)).commit();
        } finally {
            this.f10379d.unlock();
        }
    }

    public final void a(String str, long j) {
        this.f10379d.lock();
        try {
            this.f10376a.edit().putLong(ks.a(str), j).apply();
        } finally {
            this.f10379d.unlock();
        }
    }

    public final boolean b(String str) {
        this.f10378c.lock();
        try {
            return this.f10376a.contains(ks.a(str));
        } finally {
            this.f10378c.unlock();
        }
    }

    public final void a(String str, String str2) {
        this.f10379d.lock();
        try {
            this.f10376a.edit().putString(ks.a(str), ks.a(str2)).apply();
        } finally {
            this.f10379d.unlock();
        }
    }

    public final boolean b(String str, boolean z8) {
        this.f10378c.lock();
        try {
            return this.f10376a.getBoolean(ks.a(str), true);
        } finally {
            this.f10378c.unlock();
        }
    }

    public final void a(String str, boolean z8) {
        this.f10379d.lock();
        try {
            this.f10376a.edit().putBoolean(ks.a(str), z8).apply();
        } finally {
            this.f10379d.unlock();
        }
    }
}
