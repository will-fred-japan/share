package com.xiaomi.push;

import java.net.Socket;

/* JADX INFO: loaded from: classes2.dex */
public class fc extends ew {
    @Override // com.xiaomi.push.ew
    public void a(ew ewVar) {
    }

    @Override // com.xiaomi.push.ew
    public void b(ew ewVar) {
    }

    @Override // com.xiaomi.push.ew
    public void c(boolean z8) {
        if (z8 && m366a().m360a()) {
            a(new ex(), "mobileNetworkConnected");
        }
    }

    @Override // com.xiaomi.push.ew
    public void d() {
        if (m366a().m360a()) {
            a(new ex(), "startPing");
        }
    }

    @Override // com.xiaomi.push.ew
    public void a(Socket socket) {
        if (m366a().m360a()) {
            a(new ex(), "socketConnected");
        }
    }

    @Override // com.xiaomi.push.ew
    public void b(boolean z8) {
        if (z8 && m366a().m360a()) {
            a(new ex(), "configChange");
        }
    }

    @Override // com.xiaomi.push.ew
    public void d(boolean z8) {
        if (z8 || !m366a().m360a()) {
            return;
        }
        a(new ex(), "fallDownChange");
    }

    @Override // com.xiaomi.push.ew
    public void a(boolean z8) {
        if (z8 || !m366a().m360a()) {
            return;
        }
        a(new ex(), "superPowerModeChange");
    }

    @Override // com.xiaomi.push.ew
    /* JADX INFO: renamed from: a */
    public String mo367a() {
        return "UnAvailableState";
    }
}
