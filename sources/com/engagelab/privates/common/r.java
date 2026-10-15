package com.engagelab.privates.common;

import android.content.Context;
import android.text.TextUtils;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.monitor.tcp.TCPTimeManager;
import com.xiaomi.mipush.sdk.Constants;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes.dex */
public class r extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DatagramSocket f12354b;

    @Override // com.engagelab.privates.common.o
    public String a() {
        return "UdpSisClient";
    }

    @Override // com.engagelab.privates.common.o
    public byte[] a(Context context, byte[] bArr, int i9, String str, int i10) {
        try {
            if (TextUtils.isEmpty(str) || i10 <= 0) {
                return null;
            }
            this.f12354b = new DatagramSocket();
            MTCommonLog.d("UdpSisClient", "udp connect " + str + Constants.COLON_SEPARATOR + i10);
            long jStart = TCPTimeManager.start(context, 2);
            try {
                InetAddress byName = InetAddress.getByName(str);
                TCPTimeManager.endSucc(context, 2, jStart);
                if (bArr == null) {
                    return null;
                }
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, byName, i10);
                this.f12354b.setSoTimeout(i9);
                this.f12354b.send(datagramPacket);
                byte[] bArr2 = new byte[1024];
                this.f12354b.receive(new DatagramPacket(bArr2, 1024));
                return bArr2;
            } catch (Throwable unused) {
                TCPTimeManager.endFail(context, 2, jStart, -1);
                return null;
            }
        } catch (Throwable th) {
            MTCommonLog.d("UdpSisClient", "udp connect failed " + th.getMessage());
            return null;
        }
    }

    @Override // com.engagelab.privates.common.o
    public void a(Context context) {
        if (this.f12354b != null) {
            MTCommonLog.d("UdpSisClient", "udp disconnect");
            this.f12354b.close();
        }
    }
}
