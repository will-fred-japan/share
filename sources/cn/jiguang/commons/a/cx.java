package cn.jiguang.commons.a;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.starburst.sdk.core.tts.EventType;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public final class cx implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f9848a = {67, 118, 101, 56, 121, 89, 72, 118, 102, 121, 99, 30, 67, 117, 103, 99, 117, 67, 69, 107, 126, 127, 114, 85, 14, 118, 105, 127, 117, 30, 105, 86, 73, 95, 85, 99, 69, 107, 126, 127, 114, 85};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f9849b = {122, 103, 123, Utf8.REPLACEMENT_BYTE, 88, 73, 113, 103, 120, 126, 66, 14, 122, EventType.ERROR, 121, EventType.ERROR, 84, 83, 124, 122, 96, 120, 83, 69, 55, 103, 119, 120, 84, 14, 80, 71, 87, 88, 116, 99, 120, EventType.ERROR, 122, 83, 81, 67, 114};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f9850c = {107, 121, 124, 30, 72, 112, 96, 121, 127, 95, 82, 55, 97, 114};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f9851d = {114, 95, 77, 55, 96, 127, 121, 95, 78, 118, 122, 56, 120, 84, 14, 81, 102, 89, 112, 121, 68, 74, 109, EventType.ERROR, 103, 89, 67, 124};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f9852e = {126, 81, 127, 112, 108, 73, 119, 92, 65, 126};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IBinder f9853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f9854g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CountDownLatch f9855h = new CountDownLatch(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9856i = jr.a(f9848a);

    public cx(IBinder iBinder) {
        this.f9853f = iBinder;
    }

    private da d() {
        try {
            IInterface iInterfaceQueryLocalInterface = this.f9853f.queryLocalInterface(this.f9856i);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof da)) ? new db(this.f9853f) : (da) iInterfaceQueryLocalInterface;
        } catch (Throwable th) {
            defpackage.f.n(th, new StringBuilder("get service interface err: "), "IDUtils");
            return null;
        }
    }

    public final String a(Context context) {
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(this.f9854g)) {
            return this.f9854g;
        }
        try {
            cy cyVar = new cy(this, true);
            da daVarD = d();
            if (daVarD == null) {
                ee.d("IDUtils", "get service interface failed");
                return "";
            }
            try {
                daVarD.a(cyVar);
                if (!this.f9855h.await(1L, TimeUnit.SECONDS)) {
                    ee.d("IDUtils", "wait callback timeout");
                }
            } catch (Throwable th) {
                ee.d("IDUtils", "call service method err: " + th.getMessage());
                return "";
            }
        } catch (Throwable th2) {
            defpackage.f.n(th2, new StringBuilder("get oaid err: "), "IDUtils");
        }
        String str = this.f9854g;
        return str != null ? str : "";
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }
}
