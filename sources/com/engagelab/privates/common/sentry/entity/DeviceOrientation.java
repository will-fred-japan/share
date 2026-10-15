package com.engagelab.privates.common.sentry.entity;

/* JADX INFO: loaded from: classes.dex */
public class DeviceOrientation {

    public enum Orientation {
        LANDSCAPE,
        PORTRAIT
    }

    public static Orientation getOrientation(int i9) {
        if (i9 == 1) {
            return Orientation.PORTRAIT;
        }
        if (i9 != 2) {
            return null;
        }
        return Orientation.LANDSCAPE;
    }
}
