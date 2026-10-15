package com.dexterous.flutterlocalnotifications;

import com.dexterous.flutterlocalnotifications.models.NotificationDetails;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: ForegroundServiceStartParameter.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NotificationDetails f12158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Integer> f12160c;

    public b(NotificationDetails notificationDetails, int i9, ArrayList<Integer> arrayList) {
        this.f12158a = notificationDetails;
        this.f12159b = i9;
        this.f12160c = arrayList;
    }

    public final String toString() {
        return "ForegroundServiceStartParameter{notificationData=" + this.f12158a + ", startMode=" + this.f12159b + ", foregroundServiceTypes=" + this.f12160c + '}';
    }
}
