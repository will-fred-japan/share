package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: DrawableUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f6667a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f6668b = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Rect f6669c = new Rect();

    /* JADX INFO: compiled from: DrawableUtils.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f6670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f6671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Field f6672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Field f6673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Field f6674e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Field f6675f;

        /* JADX WARN: Code duplicated, block: B:25:0x004d  */
        /* JADX WARN: Code duplicated, block: B:26:0x005a  */
        static {
            Method method;
            Field field;
            Field field2;
            Field field3;
            Field field4;
            boolean z8;
            try {
                Class<?> cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", new Class[0]);
                try {
                    field = cls.getField("left");
                    try {
                        field2 = cls.getField("top");
                        try {
                            field3 = cls.getField("right");
                            try {
                                field4 = cls.getField("bottom");
                                z8 = true;
                            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused) {
                                field4 = null;
                                z8 = false;
                            }
                        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused2) {
                            field3 = null;
                        }
                    } catch (ClassNotFoundException unused3) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z8 = false;
                        if (z8) {
                            f6671b = method;
                            f6672c = field;
                            f6673d = field2;
                            f6674e = field3;
                            f6675f = field4;
                            f6670a = true;
                            return;
                        }
                        f6671b = null;
                        f6672c = null;
                        f6673d = null;
                        f6674e = null;
                        f6675f = null;
                        f6670a = false;
                    } catch (NoSuchFieldException unused4) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z8 = false;
                        if (z8) {
                            f6671b = method;
                            f6672c = field;
                            f6673d = field2;
                            f6674e = field3;
                            f6675f = field4;
                            f6670a = true;
                            return;
                        }
                        f6671b = null;
                        f6672c = null;
                        f6673d = null;
                        f6674e = null;
                        f6675f = null;
                        f6670a = false;
                    } catch (NoSuchMethodException unused5) {
                        field2 = null;
                        field3 = field2;
                        field4 = null;
                        z8 = false;
                        if (z8) {
                            f6671b = method;
                            f6672c = field;
                            f6673d = field2;
                            f6674e = field3;
                            f6675f = field4;
                            f6670a = true;
                            return;
                        }
                        f6671b = null;
                        f6672c = null;
                        f6673d = null;
                        f6674e = null;
                        f6675f = null;
                        f6670a = false;
                    }
                } catch (ClassNotFoundException unused6) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z8 = false;
                    if (z8) {
                        f6671b = method;
                        f6672c = field;
                        f6673d = field2;
                        f6674e = field3;
                        f6675f = field4;
                        f6670a = true;
                        return;
                    }
                    f6671b = null;
                    f6672c = null;
                    f6673d = null;
                    f6674e = null;
                    f6675f = null;
                    f6670a = false;
                } catch (NoSuchFieldException unused7) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z8 = false;
                    if (z8) {
                        f6671b = method;
                        f6672c = field;
                        f6673d = field2;
                        f6674e = field3;
                        f6675f = field4;
                        f6670a = true;
                        return;
                    }
                    f6671b = null;
                    f6672c = null;
                    f6673d = null;
                    f6674e = null;
                    f6675f = null;
                    f6670a = false;
                } catch (NoSuchMethodException unused8) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z8 = false;
                    if (z8) {
                        f6671b = method;
                        f6672c = field;
                        f6673d = field2;
                        f6674e = field3;
                        f6675f = field4;
                        f6670a = true;
                        return;
                    }
                    f6671b = null;
                    f6672c = null;
                    f6673d = null;
                    f6674e = null;
                    f6675f = null;
                    f6670a = false;
                }
            } catch (ClassNotFoundException unused9) {
                method = null;
                field = null;
            } catch (NoSuchFieldException unused10) {
                method = null;
                field = null;
            } catch (NoSuchMethodException unused11) {
                method = null;
                field = null;
            }
            if (z8) {
                f6671b = method;
                f6672c = field;
                f6673d = field2;
                f6674e = field3;
                f6675f = field4;
                f6670a = true;
                return;
            }
            f6671b = null;
            f6672c = null;
            f6673d = null;
            f6674e = null;
            f6675f = null;
            f6670a = false;
        }
    }

    /* JADX INFO: compiled from: DrawableUtils.java */
    public static class b {
        public static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 29 || i9 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f6667a);
        } else {
            drawable.setState(f6668b);
        }
        drawable.setState(state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Rect b(Drawable drawable) {
        Object objB;
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 29) {
            Insets insetsA = b.a(drawable);
            return new Rect(insetsA.left, insetsA.top, insetsA.right, insetsA.bottom);
        }
        if (drawable instanceof L.a) {
            objB = drawable;
            objB = ((L.a) drawable).b();
        }
        if (i9 >= 29) {
            boolean z8 = a.f6670a;
        } else if (a.f6670a) {
            try {
                Object objInvoke = a.f6671b.invoke(objB, new Object[0]);
                if (objInvoke != null) {
                    return new Rect(a.f6672c.getInt(objInvoke), a.f6673d.getInt(objInvoke), a.f6674e.getInt(objInvoke), a.f6675f.getInt(objInvoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return f6669c;
    }

    public static PorterDuff.Mode c(int i9, PorterDuff.Mode mode) {
        if (i9 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i9 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i9 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i9) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
