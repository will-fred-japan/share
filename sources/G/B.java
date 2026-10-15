package G;

import android.app.Person;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Objects;

/* JADX INFO: compiled from: Person.java */
/* JADX INFO: loaded from: classes.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f2052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IconCompat f2053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2057f;

    /* JADX INFO: compiled from: Person.java */
    public static class a {
        public static B a(Person person) {
            CharSequence name = person.getName();
            IconCompat iconCompatC = person.getIcon() != null ? IconCompat.c(person.getIcon()) : null;
            String uri = person.getUri();
            String key = person.getKey();
            boolean zIsBot = person.isBot();
            boolean zIsImportant = person.isImportant();
            B b9 = new B();
            b9.f2052a = name;
            b9.f2053b = iconCompatC;
            b9.f2054c = uri;
            b9.f2055d = key;
            b9.f2056e = zIsBot;
            b9.f2057f = zIsImportant;
            return b9;
        }

        public static Person b(B b9) {
            Person.Builder name = new Person.Builder().setName(b9.f2052a);
            IconCompat iconCompat = b9.f2053b;
            return name.setIcon(iconCompat != null ? iconCompat.h(null) : null).setUri(b9.f2054c).setKey(b9.f2055d).setBot(b9.f2056e).setImportant(b9.f2057f).build();
        }
    }

    public static B a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(RemoteMessageConst.Notification.ICON);
        CharSequence charSequence = bundle.getCharSequence(MTCommonConstants.Network.KEY_NAME);
        IconCompat iconCompatB = bundle2 != null ? IconCompat.b(bundle2) : null;
        String string = bundle.getString("uri");
        String string2 = bundle.getString("key");
        boolean z8 = bundle.getBoolean("isBot");
        boolean z9 = bundle.getBoolean("isImportant");
        B b9 = new B();
        b9.f2052a = charSequence;
        b9.f2053b = iconCompatB;
        b9.f2054c = string;
        b9.f2055d = string2;
        b9.f2056e = z8;
        b9.f2057f = z9;
        return b9;
    }

    public final Bundle b() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putCharSequence(MTCommonConstants.Network.KEY_NAME, this.f2052a);
        IconCompat iconCompat = this.f2053b;
        if (iconCompat != null) {
            iconCompat.getClass();
            bundle = new Bundle();
            switch (iconCompat.f7072a) {
                case -1:
                    bundle.putParcelable("obj", (Parcelable) iconCompat.f7073b);
                    break;
                case 0:
                default:
                    throw new IllegalArgumentException("Invalid icon");
                case 1:
                case 5:
                    bundle.putParcelable("obj", (Bitmap) iconCompat.f7073b);
                    break;
                case 2:
                case 4:
                case 6:
                    bundle.putString("obj", (String) iconCompat.f7073b);
                    break;
                case 3:
                    bundle.putByteArray("obj", (byte[]) iconCompat.f7073b);
                    break;
            }
            bundle.putInt("type", iconCompat.f7072a);
            bundle.putInt("int1", iconCompat.f7076e);
            bundle.putInt("int2", iconCompat.f7077f);
            bundle.putString("string1", iconCompat.j);
            ColorStateList colorStateList = iconCompat.f7078g;
            if (colorStateList != null) {
                bundle.putParcelable("tint_list", colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f7079h;
            if (mode != IconCompat.f7071k) {
                bundle.putString("tint_mode", mode.name());
            }
        } else {
            bundle = null;
        }
        bundle2.putBundle(RemoteMessageConst.Notification.ICON, bundle);
        bundle2.putString("uri", this.f2054c);
        bundle2.putString("key", this.f2055d);
        bundle2.putBoolean("isBot", this.f2056e);
        bundle2.putBoolean("isImportant", this.f2057f);
        return bundle2;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof B)) {
            return false;
        }
        B b9 = (B) obj;
        String str = this.f2055d;
        String str2 = b9.f2055d;
        if (str == null && str2 == null) {
            return Objects.equals(Objects.toString(this.f2052a), Objects.toString(b9.f2052a)) && Objects.equals(this.f2054c, b9.f2054c) && Boolean.valueOf(this.f2056e).equals(Boolean.valueOf(b9.f2056e)) && Boolean.valueOf(this.f2057f).equals(Boolean.valueOf(b9.f2057f));
        }
        return Objects.equals(str, str2);
    }

    public final int hashCode() {
        String str = this.f2055d;
        if (str != null) {
            return str.hashCode();
        }
        return Objects.hash(this.f2052a, this.f2054c, Boolean.valueOf(this.f2056e), Boolean.valueOf(this.f2057f));
    }
}
