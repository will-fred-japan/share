package S;

import com.huawei.hms.push.constant.RemoteMessageConst;

/* JADX INFO: compiled from: TimeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f4092a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static char[] f4093b = new char[24];

    public static void a(long j, StringBuilder sb) {
        synchronized (f4092a) {
            sb.append(f4093b, 0, b(j));
        }
    }

    public static int b(long j) {
        char c5;
        int i9;
        int i10;
        int i11;
        if (f4093b.length < 0) {
            f4093b = new char[0];
        }
        char[] cArr = f4093b;
        if (j == 0) {
            cArr[0] = '0';
            return 1;
        }
        if (j > 0) {
            c5 = '+';
        } else {
            j = -j;
            c5 = '-';
        }
        int i12 = (int) (j % 1000);
        int iFloor = (int) Math.floor(j / 1000);
        if (iFloor > 86400) {
            i9 = iFloor / RemoteMessageConst.DEFAULT_TTL;
            iFloor -= RemoteMessageConst.DEFAULT_TTL * i9;
        } else {
            i9 = 0;
        }
        if (iFloor > 3600) {
            i10 = iFloor / 3600;
            iFloor -= i10 * 3600;
        } else {
            i10 = 0;
        }
        if (iFloor > 60) {
            int i13 = iFloor / 60;
            iFloor -= i13 * 60;
            i11 = i13;
        } else {
            i11 = 0;
        }
        cArr[0] = c5;
        int iC = c(cArr, i9, 'd', 1, false, 0);
        int iC2 = c(cArr, i10, 'h', iC, iC != 1, 0);
        int iC3 = c(cArr, i11, 'm', iC2, iC2 != 1, 0);
        int iC4 = c(cArr, i12, 'm', c(cArr, iFloor, 's', iC3, iC3 != 1, 0), true, 0);
        cArr[iC4] = 's';
        return iC4 + 1;
    }

    public static int c(char[] cArr, int i9, char c5, int i10, boolean z8, int i11) {
        int i12;
        if (!z8 && i9 <= 0) {
            return i10;
        }
        if ((!z8 || i11 < 3) && i9 <= 99) {
            i12 = i10;
        } else {
            int i13 = i9 / 100;
            cArr[i10] = (char) (i13 + 48);
            i12 = i10 + 1;
            i9 -= i13 * 100;
        }
        if ((z8 && i11 >= 2) || i9 > 9 || i10 != i12) {
            int i14 = i9 / 10;
            cArr[i12] = (char) (i14 + 48);
            i12++;
            i9 -= i14 * 10;
        }
        cArr[i12] = (char) (i9 + 48);
        cArr[i12 + 1] = c5;
        return i12 + 2;
    }
}
