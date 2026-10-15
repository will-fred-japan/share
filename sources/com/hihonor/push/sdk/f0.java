package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f14486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f14487b;

    public static void a(f0 f0Var, HonorPushCallback honorPushCallback, int i9, String str) {
        f0Var.f14487b.execute(new e0(f0Var, honorPushCallback, i9, str));
    }
}
