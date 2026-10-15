package cn.jiguang.al;

/* JADX INFO: loaded from: classes.dex */
public class b {

    public enum a {
        LANDSCAPE,
        PORTRAIT
    }

    public static a a(int i9) {
        if (i9 == 1) {
            return a.PORTRAIT;
        }
        if (i9 != 2) {
            return null;
        }
        return a.LANDSCAPE;
    }
}
