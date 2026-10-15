package com.huawei.secure.android.common.ssl.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class c extends AsyncTask<Context, Integer, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15922a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f15923b = 432000000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f15924c = "lastCheckTime";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f15925d = false;

    @SuppressLint({"NewApi"})
    public static void a() {
        if (b()) {
            e.c(f15922a, "checkUpgradeBks, execute check task");
            new c().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, ContextUtil.getInstance());
        }
    }

    private static boolean b() {
        if (f15925d) {
            return false;
        }
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            e.e(f15922a, "checkUpgradeBks, context is null");
            return false;
        }
        f15925d = true;
        long jA = g.a(f15924c, 0L, contextUtil);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jA > f15923b) {
            g.b(f15924c, jCurrentTimeMillis, contextUtil);
            return true;
        }
        e.c(f15922a, "checkUpgradeBks, ignore");
        return false;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        e.a(f15922a, "onPreExecute");
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Context... contextArr) {
        InputStream bksFromTss;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            bksFromTss = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e9) {
            e.b(f15922a, "doInBackground: exception : " + e9.getMessage());
            bksFromTss = null;
        }
        defpackage.f.j(jCurrentTimeMillis, new StringBuilder("doInBackground: get bks from hms tss cost : "), " ms", f15922a);
        if (bksFromTss != null) {
            d.a(bksFromTss);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            e.c(f15922a, "onPostExecute: upate done");
        } else {
            e.b(f15922a, "onPostExecute: upate failed");
        }
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
        e.c(f15922a, "onProgressUpdate");
    }
}
