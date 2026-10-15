package R;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: BidiFormatter.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f3893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f3894e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3895a;

    /* JADX INFO: renamed from: R.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BidiFormatter.java */
    public static class C0046a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final byte[] f3896e = new byte[1792];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f3897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f3899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public char f3900d;

        static {
            for (int i9 = 0; i9 < 1792; i9++) {
                f3896e[i9] = Character.getDirectionality(i9);
            }
        }

        public C0046a(CharSequence charSequence) {
            this.f3897a = charSequence;
            this.f3898b = charSequence.length();
        }

        public final byte a() {
            int i9 = this.f3899c - 1;
            CharSequence charSequence = this.f3897a;
            char cCharAt = charSequence.charAt(i9);
            this.f3900d = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(charSequence, this.f3899c);
                this.f3899c -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f3899c--;
            char c5 = this.f3900d;
            return c5 < 1792 ? f3896e[c5] : Character.getDirectionality(c5);
        }
    }

    static {
        c.C0047c c0047c = c.f3907c;
        f3891b = Character.toString((char) 8206);
        f3892c = Character.toString((char) 8207);
        f3893d = new a(false);
        f3894e = new a(true);
    }

    public a(boolean z8) {
        c.C0047c c0047c = c.f3905a;
        this.f3895a = z8;
    }

    public static int a(CharSequence charSequence) {
        byte directionality;
        C0046a c0046a = new C0046a(charSequence);
        c0046a.f3899c = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = c0046a.f3899c;
            if (i12 < c0046a.f3898b && i9 == 0) {
                CharSequence charSequence2 = c0046a.f3897a;
                char cCharAt = charSequence2.charAt(i12);
                c0046a.f3900d = cCharAt;
                if (Character.isHighSurrogate(cCharAt)) {
                    int iCodePointAt = Character.codePointAt(charSequence2, c0046a.f3899c);
                    c0046a.f3899c = Character.charCount(iCodePointAt) + c0046a.f3899c;
                    directionality = Character.getDirectionality(iCodePointAt);
                } else {
                    c0046a.f3899c++;
                    char c5 = c0046a.f3900d;
                    directionality = c5 < 1792 ? C0046a.f3896e[c5] : Character.getDirectionality(c5);
                }
                if (directionality != 0) {
                    if (directionality == 1 || directionality == 2) {
                        if (i11 == 0) {
                            return 1;
                        }
                    } else if (directionality != 9) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                i11++;
                                i10 = -1;
                                continue;
                            case 16:
                            case 17:
                                i11++;
                                i10 = 1;
                                continue;
                            case 18:
                                i11--;
                                i10 = 0;
                                continue;
                        }
                    }
                } else if (i11 == 0) {
                    return -1;
                }
                i9 = i11;
            }
        }
        if (i9 != 0) {
            if (i10 == 0) {
                while (c0046a.f3899c > 0) {
                    switch (c0046a.a()) {
                        case 14:
                        case 15:
                            if (i9 == i11) {
                                return -1;
                            }
                            i11--;
                            break;
                        case 16:
                        case 17:
                            if (i9 == i11) {
                                return 1;
                            }
                            i11--;
                            break;
                        case 18:
                            i11++;
                            break;
                        default:
                            break;
                    }
                }
            } else {
                return i10;
            }
        }
        return 0;
    }

    public static int b(CharSequence charSequence) {
        C0046a c0046a = new C0046a(charSequence);
        c0046a.f3899c = c0046a.f3898b;
        int i9 = 0;
        while (true) {
            int i10 = i9;
            while (c0046a.f3899c > 0) {
                byte bA = c0046a.a();
                if (bA == 0) {
                    if (i9 == 0) {
                        return -1;
                    }
                    if (i10 == 0) {
                    }
                } else if (bA == 1 || bA == 2) {
                    if (i9 == 0) {
                        return 1;
                    }
                    if (i10 == 0) {
                    }
                } else if (bA != 9) {
                    switch (bA) {
                        case 14:
                        case 15:
                            if (i10 == i9) {
                                return -1;
                            }
                            i9--;
                            break;
                        case 16:
                        case 17:
                            if (i10 == i9) {
                                return 1;
                            }
                            i9--;
                            break;
                        case 18:
                            i9++;
                            break;
                        default:
                            if (i10 != 0) {
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }
    }

    public static a c() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? f3894e : f3893d;
    }

    public final SpannableStringBuilder d(CharSequence charSequence) {
        String str;
        c.C0047c c0047c = c.f3907c;
        if (charSequence == null) {
            return null;
        }
        boolean zB = c0047c.b(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean zB2 = (zB ? c.f3906b : c.f3905a).b(charSequence, charSequence.length());
        String str2 = "";
        String str3 = f3892c;
        String str4 = f3891b;
        boolean z8 = this.f3895a;
        if (z8 || !(zB2 || a(charSequence) == 1)) {
            str = (!z8 || (zB2 && a(charSequence) != -1)) ? "" : str3;
        } else {
            str = str4;
        }
        spannableStringBuilder.append((CharSequence) str);
        if (zB != z8) {
            spannableStringBuilder.append(zB ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        boolean zB3 = (zB ? c.f3906b : c.f3905a).b(charSequence, charSequence.length());
        if (!z8 && (zB3 || b(charSequence) == 1)) {
            str2 = str4;
        } else if (z8 && (!zB3 || b(charSequence) == -1)) {
            str2 = str3;
        }
        spannableStringBuilder.append((CharSequence) str2);
        return spannableStringBuilder;
    }
}
