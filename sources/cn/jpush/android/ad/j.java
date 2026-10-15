package cn.jpush.android.ad;

import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f11168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f11169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f11170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f11171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f11172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f11173f;

    static {
        Pattern patternCompile = Pattern.compile("((aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(biz|b[abdefghijmnorstvwyz])|(cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(edu|e[cegrstu])|f[ijkmor]|(gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(info|int|i[delmnoqrst])|(jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(name|net|n[acefgilopruz])|(org|om)|(pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-80akhbyknj4f|xn\\-\\-9t4b11yi5a|xn\\-\\-deba0ad|xn\\-\\-g6w251d|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-zckzah)|y[etu]|z[amw])");
        f11168a = patternCompile;
        f11169b = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-80akhbyknj4f|xn\\-\\-9t4b11yi5a|xn\\-\\-deba0ad|xn\\-\\-g6w251d|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-zckzah)|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        Pattern patternCompile2 = Pattern.compile("((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))");
        f11170c = patternCompile2;
        f11171d = Pattern.compile("(((([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef][a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef\\-]*)*[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]\\.)+" + patternCompile + ")|" + patternCompile2 + ")");
        f11172e = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
        f11173f = Pattern.compile("(\\+[0-9]+[\\- \\.]*)?(\\([0-9]+\\)[\\- \\.]*)?([0-9][0-9\\- \\.][0-9\\- \\.]+[0-9])");
    }

    public static int a(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            if (set.size() > 1000) {
                return JPushInterface.ErrorCode.TOO_MANY_TAGS;
            }
            for (String str : set) {
                if (str == null) {
                    return JPushInterface.ErrorCode.INVALID_TAGS;
                }
                if (str.getBytes().length > 40) {
                    return JPushInterface.ErrorCode.TOO_LONG_TAGS;
                }
                if (!Pattern.compile("^[一-龥0-9a-zA-Z_!@#$&*+=.|]+$").matcher(str).matches()) {
                    return JPushInterface.ErrorCode.INVALID_TAGS;
                }
            }
        }
        return 0;
    }

    public static int b(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            if (str.getBytes().length > 40) {
                return JPushInterface.ErrorCode.TOO_LONG_ALIAS;
            }
            if (!Pattern.compile("^[一-龥0-9a-zA-Z_!@#$&*+=.|]+$").matcher(str).matches()) {
                return JPushInterface.ErrorCode.INVALID_ALIAS;
            }
        }
        return 0;
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str) || Pattern.compile("^[+0-9][-0-9]{1,}$").matcher(str).matches()) {
            return 0;
        }
        return JPushInterface.ErrorCode.ERROR_CODE_INVALID_MOBILENUMBER;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile("^[一-龥0-9a-zA-Z_!@#$&*+=.|]{0,40}$").matcher(str).matches();
    }
}
