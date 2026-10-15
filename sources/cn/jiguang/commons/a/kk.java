package cn.jiguang.commons.a;

/* JADX INFO: loaded from: classes.dex */
public final class kk {
    public static Object a(Object obj, String str, Object[] objArr, Class[] clsArr) throws Exception {
        if (obj == null) {
            throw new Exception("owner can not be null");
        }
        if ((objArr != null ? objArr.length : 0) == (clsArr != null ? clsArr.length : 0)) {
            return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        }
        throw new Exception("argClasses' size is not equal to args' size");
    }
}
