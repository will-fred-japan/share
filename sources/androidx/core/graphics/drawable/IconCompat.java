package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f7071k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f7073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f7074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Parcelable f7075d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorStateList f7078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f7079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f7080i;
    public String j;

    public static class a {
        public static int a(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return b.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e9) {
                Log.e("IconCompat", "Unable to get icon resource", e9);
                return 0;
            } catch (NoSuchMethodException e10) {
                Log.e("IconCompat", "Unable to get icon resource", e10);
                return 0;
            } catch (InvocationTargetException e11) {
                Log.e("IconCompat", "Unable to get icon resource", e11);
                return 0;
            }
        }

        public static String b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return b.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e9) {
                Log.e("IconCompat", "Unable to get icon package", e9);
                return null;
            } catch (NoSuchMethodException e10) {
                Log.e("IconCompat", "Unable to get icon package", e10);
                return null;
            } catch (InvocationTargetException e11) {
                Log.e("IconCompat", "Unable to get icon package", e11);
                return null;
            }
        }

        public static int c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return b.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e9) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e9);
                return -1;
            } catch (NoSuchMethodException e10) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e10);
                return -1;
            } catch (InvocationTargetException e11) {
                Log.e("IconCompat", "Unable to get icon type " + obj, e11);
                return -1;
            }
        }

        public static Uri d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return b.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e9) {
                Log.e("IconCompat", "Unable to get icon uri", e9);
                return null;
            } catch (NoSuchMethodException e10) {
                Log.e("IconCompat", "Unable to get icon uri", e10);
                return null;
            } catch (InvocationTargetException e11) {
                Log.e("IconCompat", "Unable to get icon uri", e11);
                return null;
            }
        }
    }

    public static class b {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    public static class c {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.f7072a = -1;
        this.f7074c = null;
        this.f7075d = null;
        this.f7076e = 0;
        this.f7077f = 0;
        this.f7078g = null;
        this.f7079h = f7071k;
        this.f7080i = null;
    }

    public static IconCompat b(Bundle bundle) {
        int i9 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i9);
        iconCompat.f7076e = bundle.getInt("int1");
        iconCompat.f7077f = bundle.getInt("int2");
        iconCompat.j = bundle.getString("string1");
        if (bundle.containsKey("tint_list")) {
            iconCompat.f7078g = (ColorStateList) bundle.getParcelable("tint_list");
        }
        if (bundle.containsKey("tint_mode")) {
            iconCompat.f7079h = PorterDuff.Mode.valueOf(bundle.getString("tint_mode"));
        }
        switch (i9) {
            case -1:
            case 1:
            case 5:
                iconCompat.f7073b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                Log.w("IconCompat", "Unknown type " + i9);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f7073b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f7073b = bundle.getByteArray("obj");
                return iconCompat;
        }
    }

    public static IconCompat c(Icon icon) {
        icon.getClass();
        int iC = a.c(icon);
        if (iC == 2) {
            return e(null, a.b(icon), a.a(icon));
        }
        if (iC == 4) {
            Uri uriD = a.d(icon);
            uriD.getClass();
            String string = uriD.toString();
            string.getClass();
            IconCompat iconCompat = new IconCompat(4);
            iconCompat.f7073b = string;
            return iconCompat;
        }
        if (iC != 6) {
            IconCompat iconCompat2 = new IconCompat(-1);
            iconCompat2.f7073b = icon;
            return iconCompat2;
        }
        Uri uriD2 = a.d(icon);
        uriD2.getClass();
        String string2 = uriD2.toString();
        string2.getClass();
        IconCompat iconCompat3 = new IconCompat(6);
        iconCompat3.f7073b = string2;
        return iconCompat3;
    }

    public static IconCompat d(Bitmap bitmap) {
        bitmap.getClass();
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f7073b = bitmap;
        return iconCompat;
    }

    public static IconCompat e(Resources resources, String str, int i9) {
        str.getClass();
        if (i9 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f7076e = i9;
        if (resources != null) {
            try {
                iconCompat.f7073b = resources.getResourceName(i9);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f7073b = str;
        }
        iconCompat.j = str;
        return iconCompat;
    }

    public final int f() {
        int i9 = this.f7072a;
        if (i9 == -1) {
            return a.a(this.f7073b);
        }
        if (i9 == 2) {
            return this.f7076e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final Uri g() {
        int i9 = this.f7072a;
        if (i9 == -1) {
            return a.d(this.f7073b);
        }
        if (i9 == 4 || i9 == 6) {
            return Uri.parse((String) this.f7073b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final Icon h(Context context) {
        Icon iconCreateWithBitmap;
        String strB;
        InputStream inputStreamOpenInputStream;
        switch (this.f7072a) {
            case -1:
                return (Icon) this.f7073b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) this.f7073b);
                break;
            case 2:
                int i9 = this.f7072a;
                if (i9 == -1) {
                    strB = a.b(this.f7073b);
                } else {
                    if (i9 != 2) {
                        throw new IllegalStateException("called getResPackage() on " + this);
                    }
                    String str = this.j;
                    strB = (str == null || TextUtils.isEmpty(str)) ? ((String) this.f7073b).split(Constants.COLON_SEPARATOR, -1)[0] : this.j;
                }
                iconCreateWithBitmap = Icon.createWithResource(strB, this.f7076e);
                break;
            case 3:
                iconCreateWithBitmap = Icon.createWithData((byte[]) this.f7073b, this.f7076e, this.f7077f);
                break;
            case 4:
                iconCreateWithBitmap = Icon.createWithContentUri((String) this.f7073b);
                break;
            case 5:
                iconCreateWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.f7073b);
                break;
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    iconCreateWithBitmap = c.a(g());
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + g());
                    }
                    Uri uriG = g();
                    String scheme = uriG.getScheme();
                    if ("content".equals(scheme) || "file".equals(scheme)) {
                        try {
                            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uriG);
                        } catch (Exception e9) {
                            Log.w("IconCompat", "Unable to load image from URI: " + uriG, e9);
                            inputStreamOpenInputStream = null;
                        }
                    } else {
                        try {
                            inputStreamOpenInputStream = new FileInputStream(new File((String) this.f7073b));
                        } catch (FileNotFoundException e10) {
                            Log.w("IconCompat", "Unable to load image from path: " + uriG, e10);
                            inputStreamOpenInputStream = null;
                        }
                    }
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + g());
                    }
                    iconCreateWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(inputStreamOpenInputStream));
                }
                break;
        }
        ColorStateList colorStateList = this.f7078g;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f7079h;
        if (mode != f7071k) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }

    public final String toString() {
        String str;
        if (this.f7072a == -1) {
            return String.valueOf(this.f7073b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f7072a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = GrsBaseInfo.CountryCodeSource.UNKNOWN;
                break;
        }
        sb.append(str);
        switch (this.f7072a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f7073b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f7073b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(f())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f7076e);
                if (this.f7077f != 0) {
                    sb.append(" off=");
                    sb.append(this.f7077f);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f7073b);
                break;
        }
        if (this.f7078g != null) {
            sb.append(" tint=");
            sb.append(this.f7078g);
        }
        if (this.f7079h != f7071k) {
            sb.append(" mode=");
            sb.append(this.f7079h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i9) {
        this.f7074c = null;
        this.f7075d = null;
        this.f7076e = 0;
        this.f7077f = 0;
        this.f7078g = null;
        this.f7079h = f7071k;
        this.f7080i = null;
        this.f7072a = i9;
    }
}
