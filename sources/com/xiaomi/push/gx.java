package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class gx extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private hg f17568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private hh f532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Throwable f533a;

    public gx() {
        this.f17568a = null;
        this.f532a = null;
        this.f533a = null;
    }

    public Throwable a() {
        return this.f533a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        hg hgVar;
        hh hhVar;
        String message = super.getMessage();
        if (message != null || (hhVar = this.f532a) == null) {
            return (message != null || (hgVar = this.f17568a) == null) ? message : hgVar.toString();
        }
        return hhVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        hh hhVar = this.f532a;
        if (hhVar != null) {
            sb.append(hhVar);
        }
        hg hgVar = this.f17568a;
        if (hgVar != null) {
            sb.append(hgVar);
        }
        if (this.f533a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f533a);
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f533a != null) {
            printStream.println("Nested Exception: ");
            this.f533a.printStackTrace(printStream);
        }
    }

    public gx(String str) {
        super(str);
        this.f17568a = null;
        this.f532a = null;
        this.f533a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f533a != null) {
            printWriter.println("Nested Exception: ");
            this.f533a.printStackTrace(printWriter);
        }
    }

    public gx(Throwable th) {
        this.f17568a = null;
        this.f532a = null;
        this.f533a = th;
    }

    public gx(hg hgVar) {
        this.f532a = null;
        this.f533a = null;
        this.f17568a = hgVar;
    }

    public gx(String str, Throwable th) {
        super(str);
        this.f17568a = null;
        this.f532a = null;
        this.f533a = th;
    }
}
