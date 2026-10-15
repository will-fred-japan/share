package p018c3;

import android.os.Process;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: CommonProcUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static long a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                String[] strArrSplit = line.split(" ");
                long j = Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[14]);
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                return j;
            } catch (Throwable unused2) {
                if (bufferedReader == null) {
                    return -1L;
                }
                try {
                    bufferedReader.close();
                    return -1L;
                } catch (Throwable unused3) {
                    return -1L;
                }
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }
}
