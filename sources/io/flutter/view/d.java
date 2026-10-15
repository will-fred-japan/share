package io.flutter.view;

import android.text.SpannableString;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: AccessibilityStringBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f19814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f19816d;

    /* JADX INFO: compiled from: AccessibilityStringBuilder.java */
    public static class a extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f19817d;
    }

    /* JADX INFO: compiled from: AccessibilityStringBuilder.java */
    public static class b extends c {
    }

    /* JADX INFO: compiled from: AccessibilityStringBuilder.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public EnumC0219d f19820c;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: io.flutter.view.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityStringBuilder.java */
    public static final class EnumC0219d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumC0219d[] f19821a = {new EnumC0219d("SPELLOUT", 0), new EnumC0219d("LOCALE", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        EnumC0219d EF5;

        public EnumC0219d() {
            throw null;
        }

        public static EnumC0219d valueOf(String str) {
            return (EnumC0219d) Enum.valueOf(EnumC0219d.class, str);
        }

        public static EnumC0219d[] values() {
            return (EnumC0219d[]) f19821a.clone();
        }
    }

    public final SpannableString a() {
        if (this.f19813a == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(this.f19813a);
        ArrayList<c> arrayList = this.f19814b;
        if (arrayList != null) {
            for (c cVar : arrayList) {
                int iOrdinal = cVar.f19820c.ordinal();
                if (iOrdinal == 0) {
                    spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), cVar.f19818a, cVar.f19819b, 0);
                } else if (iOrdinal == 1) {
                    spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((a) cVar).f19817d)), cVar.f19818a, cVar.f19819b, 0);
                }
            }
        }
        String str = this.f19816d;
        if (str != null && !str.isEmpty()) {
            spannableString.setSpan(new URLSpan(this.f19816d), 0, this.f19813a.length(), 0);
        }
        String str2 = this.f19815c;
        if (str2 != null && !str2.isEmpty()) {
            spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(this.f19815c)), 0, this.f19813a.length(), 0);
        }
        return spannableString;
    }
}
