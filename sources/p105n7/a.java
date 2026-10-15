package p105n7;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Locale;
import p088l7.g;

/* JADX INFO: compiled from: LocalizationPlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f20617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f20618b;

    /* JADX INFO: renamed from: n7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LocalizationPlugin.java */
    public class C0237a {
        public C0237a() {
        }

        public final String a(String str, String str2) {
            a aVar = a.this;
            Context contextCreateConfigurationContext = aVar.f20618b;
            if (str2 != null) {
                Locale localeA = a.a(str2);
                Configuration configuration = new Configuration(aVar.f20618b.getResources().getConfiguration());
                configuration.setLocale(localeA);
                contextCreateConfigurationContext = aVar.f20618b.createConfigurationContext(configuration);
            }
            int identifier = contextCreateConfigurationContext.getResources().getIdentifier(str, "string", aVar.f20618b.getPackageName());
            if (identifier != 0) {
                return contextCreateConfigurationContext.getResources().getString(identifier);
            }
            return null;
        }
    }

    public a(Context context, g gVar) {
        C0237a c0237a = new C0237a();
        this.f20618b = context;
        this.f20617a = gVar;
        gVar.f20128b = c0237a;
    }

    public static Locale a(String str) {
        Locale.Builder builder = new Locale.Builder();
        String[] strArrSplit = str.replace('_', '-').split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        builder.setLanguage(strArrSplit[0]);
        int i9 = 1;
        if (strArrSplit.length > 1 && strArrSplit[1].length() == 4) {
            builder.setScript(strArrSplit[1]);
            i9 = 2;
        }
        if (strArrSplit.length > i9 && strArrSplit[i9].length() >= 2 && strArrSplit[i9].length() <= 3) {
            builder.setRegion(strArrSplit[i9]);
        }
        return builder.build();
    }

    public final void b(Configuration configuration) {
        ArrayList<Locale> arrayList = new ArrayList();
        LocaleList locales = configuration.getLocales();
        int size = locales.size();
        for (int i9 = 0; i9 < size; i9++) {
            arrayList.add(locales.get(i9));
        }
        g gVar = this.f20617a;
        gVar.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (Locale locale : arrayList) {
            locale.getLanguage();
            locale.getCountry();
            locale.getVariant();
            arrayList2.add(locale.getLanguage());
            arrayList2.add(locale.getCountry());
            arrayList2.add(locale.getScript());
            arrayList2.add(locale.getVariant());
        }
        gVar.f20127a.a("setLocale", arrayList2, null);
    }
}
