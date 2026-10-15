package com.bytedance.memory.test;

import java.util.ArrayList;
import p027d5.a;

/* JADX INFO: loaded from: classes.dex */
public class OOMMaker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ArrayList<byte[]> f12132a = new ArrayList<>();

    public static void createOOM() {
        while (true) {
            f12132a.add(new byte[2097152]);
        }
    }

    public static void createReachTop(int i9) {
        while (a.e() < i9) {
            encreaseMem();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e9) {
                e9.printStackTrace();
            }
        }
    }

    public static void encreaseMem() {
        f12132a.add(new byte[15728640]);
    }
}
