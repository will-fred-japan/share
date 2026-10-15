package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SystemManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SystemManager f14783a = new SystemManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f14784b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SystemNotifier f14785c = new a();

    private SystemManager() {
    }

    public static SystemManager getInstance() {
        return f14783a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f14785c;
    }

    public void notifyNoticeResult(int i9) {
        f14785c.notifyNoticeObservers(i9);
    }

    public void notifyResolutionResult(Intent intent, String str) {
        f14785c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i9) {
        f14785c.notifyObservers(i9);
    }

    public class a implements SystemNotifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<SystemObserver> f14786a = new ArrayList();

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int i9) {
            synchronized (SystemManager.f14784b) {
                try {
                    Iterator<SystemObserver> it = this.f14786a.iterator();
                    while (it.hasNext()) {
                        if (it.next().onNoticeResult(i9)) {
                            it.remove();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.f14784b) {
                try {
                    Iterator<SystemObserver> it = this.f14786a.iterator();
                    while (it.hasNext()) {
                        if (it.next().onSolutionResult(intent, str)) {
                            it.remove();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver == null || this.f14786a.contains(systemObserver)) {
                return;
            }
            synchronized (SystemManager.f14784b) {
                this.f14786a.add(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.f14784b) {
                this.f14786a.remove(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i9) {
            synchronized (SystemManager.f14784b) {
                try {
                    Iterator<SystemObserver> it = this.f14786a.iterator();
                    while (it.hasNext()) {
                        if (it.next().onUpdateResult(i9)) {
                            it.remove();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
