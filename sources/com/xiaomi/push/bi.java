package com.xiaomi.push;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public class bi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<a> f17081a = new LinkedList<>();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final bi f17082a = new bi();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f144a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f145a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f146a;

        public a(int i9, Object obj) {
            this.f144a = i9;
            this.f145a = obj;
        }
    }

    public static bi a() {
        return a.f17082a;
    }

    public synchronized void a(Object obj) {
        this.f17081a.add(new a(0, obj));
        m122a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private void m122a() {
        if (this.f17081a.size() > 100) {
            this.f17081a.removeFirst();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized int m123a() {
        return this.f17081a.size();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized LinkedList<a> m124a() {
        LinkedList<a> linkedList;
        linkedList = this.f17081a;
        this.f17081a = new LinkedList<>();
        return linkedList;
    }
}
