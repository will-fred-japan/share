package com.starburst.sdk.core.ntp;

import L6.a;
import com.starburst.sdk.business.a56;
import com.starburst.sdk.utils.j;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NtpTimeSync {
    private static final String TAG = "NtpTimeSync";
    private static final int TIMEOUT = 500;
    private static final List<String> NTP_SERVERS = Arrays.asList("ntp.ntsc.ac.cn", "ntp.aliyun.com", "ntp.tencent.com", "ntp.sjtu.edu.cn", "cn.ntp.org.cn");
    private static long timeOffset = 0;

    public static long getAdjustedTime() {
        if (timeOffset == 0) {
            j.f(TAG, "Time offset is 0. NTP sync might have failed. Using system time.");
        }
        return System.currentTimeMillis() + timeOffset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x0137  */
    public static /* synthetic */ void lambda$syncTime$0() throws Throwable {
        Throwable th;
        for (String str : NTP_SERVERS) {
            a56.a56("Trying to connect to NTP server: ", str, TAG);
            DatagramSocket datagramSocket = null;
            try {
                InetAddress byName = InetAddress.getByName(str);
                DatagramSocket datagramSocket2 = new DatagramSocket();
                try {
                    datagramSocket2.setSoTimeout(500);
                    byte[] bArr = new byte[48];
                    bArr[0] = 27;
                    DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
                    DatagramPacket datagramPacket2 = new DatagramPacket(new byte[48], 48);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    datagramSocket2.send(datagramPacket);
                    datagramSocket2.receive(datagramPacket2);
                    System.currentTimeMillis();
                    byte[] data = datagramPacket2.getData();
                    byte b9 = data[16];
                    byte b10 = data[17];
                    byte b11 = data[18];
                    byte b12 = data[19];
                    byte b13 = data[32];
                    byte b14 = data[33];
                    byte b15 = data[34];
                    byte b16 = data[35];
                    long j = (((((long) (data[43] & 255)) | (((((long) (data[40] & 255)) << 24) | (((long) (data[41] & 255)) << 16)) | (((long) (data[42] & 255)) << 8))) - 2208988800L) * 1000) - jCurrentTimeMillis;
                    if (Math.abs(j) < 10000) {
                        timeOffset = 0L;
                        j.f(TAG, "Time offset is within 10 seconds. Setting offset to 0.");
                    } else {
                        timeOffset = j;
                    }
                    j.f(TAG, "Successfully synced time with server: " + str + ". Time offset: " + timeOffset + " ms");
                    datagramSocket2.close();
                    return;
                } catch (SocketTimeoutException unused) {
                    datagramSocket = datagramSocket2;
                    j.x(TAG, "Connection to NTP server " + str + " timed out after 500 ms.");
                    if (datagramSocket != null) {
                        datagramSocket.close();
                    }
                } catch (IOException e9) {
                    e = e9;
                    datagramSocket = datagramSocket2;
                    try {
                        j.x(TAG, "Failed to connect to NTP server: " + str + ". Error: " + e.getMessage());
                        if (datagramSocket != null) {
                            datagramSocket.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        datagramSocket2 = datagramSocket;
                        if (datagramSocket2 != null) {
                            datagramSocket2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (datagramSocket2 != null) {
                        datagramSocket2.close();
                    }
                    throw th;
                }
            } catch (SocketTimeoutException unused2) {
            } catch (IOException e10) {
                e = e10;
            }
        }
    }

    public static void syncTime() {
        new Thread(new a()).start();
    }
}
