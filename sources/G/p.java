package G;

import B0.C0298l;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class p extends w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public B f2145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PendingIntent f2146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PendingIntent f2147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PendingIntent f2148i;
    public boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f2149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f2150l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public IconCompat f2151m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CharSequence f2152n;

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class b {
        public static Notification.CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
            return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
        }

        public static Notification.CallStyle b(Person person, PendingIntent pendingIntent) {
            return Notification.CallStyle.forOngoingCall(person, pendingIntent);
        }

        public static Notification.CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
            return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
        }

        public static Notification.CallStyle d(Notification.CallStyle callStyle, int i9) {
            return callStyle.setAnswerButtonColorHint(i9);
        }

        public static Notification.CallStyle e(Notification.CallStyle callStyle, int i9) {
            return callStyle.setDeclineButtonColorHint(i9);
        }

        public static Notification.CallStyle f(Notification.CallStyle callStyle, boolean z8) {
            return callStyle.setIsVideo(z8);
        }

        public static Notification.CallStyle g(Notification.CallStyle callStyle, Icon icon) {
            return callStyle.setVerificationIcon(icon);
        }

        public static Notification.CallStyle h(Notification.CallStyle callStyle, CharSequence charSequence) {
            return callStyle.setVerificationText(charSequence);
        }
    }

    @Override // G.w
    public final void a(Bundle bundle) {
        super.a(bundle);
        bundle.putInt("android.callType", this.f2144e);
        bundle.putBoolean("android.callIsVideo", this.j);
        B b9 = this.f2145f;
        if (b9 != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                bundle.putParcelable("android.callPerson", a.b(B.a.b(b9)));
            } else {
                bundle.putParcelable("android.callPersonCompat", b9.b());
            }
        }
        IconCompat iconCompat = this.f2151m;
        if (iconCompat != null) {
            bundle.putParcelable("android.verificationIcon", iconCompat.h(this.f2178a.f2120a));
        }
        bundle.putCharSequence("android.verificationText", this.f2152n);
        bundle.putParcelable("android.answerIntent", this.f2146g);
        bundle.putParcelable("android.declineIntent", this.f2147h);
        bundle.putParcelable("android.hangUpIntent", this.f2148i);
        Integer num = this.f2149k;
        if (num != null) {
            bundle.putInt("android.answerColor", num.intValue());
        }
        Integer num2 = this.f2150l;
        if (num2 != null) {
            bundle.putInt("android.declineColor", num2.intValue());
        }
    }

    @Override // G.w
    public final void b(x xVar) {
        int i9 = Build.VERSION.SDK_INT;
        Notification.Builder builder = xVar.f2183b;
        String string = null;
        callStyleA = null;
        Notification.CallStyle callStyleA = null;
        if (i9 < 31) {
            B b9 = this.f2145f;
            builder.setContentTitle(b9 != null ? b9.f2052a : null);
            Bundle bundle = this.f2178a.f2142y;
            CharSequence charSequence = (bundle == null || !bundle.containsKey("android.text")) ? null : this.f2178a.f2142y.getCharSequence("android.text");
            if (charSequence == null) {
                int i10 = this.f2144e;
                if (i10 == 1) {
                    string = this.f2178a.f2120a.getResources().getString(R.string.call_notification_incoming_text);
                } else if (i10 == 2) {
                    string = this.f2178a.f2120a.getResources().getString(R.string.call_notification_ongoing_text);
                } else if (i10 == 3) {
                    string = this.f2178a.f2120a.getResources().getString(R.string.call_notification_screening_text);
                }
                charSequence = string;
            }
            builder.setContentText(charSequence);
            B b10 = this.f2145f;
            if (b10 != null) {
                IconCompat iconCompat = b10.f2053b;
                if (iconCompat != null) {
                    builder.setLargeIcon(iconCompat.h(this.f2178a.f2120a));
                }
                if (i9 >= 28) {
                    B b11 = this.f2145f;
                    b11.getClass();
                    a.a(builder, B.a.b(b11));
                } else {
                    builder.addPerson(this.f2145f.f2054c);
                }
            }
            builder.setCategory("call");
            return;
        }
        int i11 = this.f2144e;
        if (i11 == 1) {
            B b12 = this.f2145f;
            b12.getClass();
            callStyleA = b.a(B.a.b(b12), this.f2147h, this.f2146g);
        } else if (i11 == 2) {
            B b13 = this.f2145f;
            b13.getClass();
            callStyleA = b.b(B.a.b(b13), this.f2148i);
        } else if (i11 == 3) {
            B b14 = this.f2145f;
            b14.getClass();
            callStyleA = b.c(B.a.b(b14), this.f2148i, this.f2146g);
        } else if (Log.isLoggable("NotifCompat", 3)) {
            Log.d("NotifCompat", "Unrecognized call type in CallStyle: " + String.valueOf(this.f2144e));
        }
        if (callStyleA != null) {
            callStyleA.setBuilder(builder);
            Integer num = this.f2149k;
            if (num != null) {
                b.d(callStyleA, num.intValue());
            }
            Integer num2 = this.f2150l;
            if (num2 != null) {
                b.e(callStyleA, num2.intValue());
            }
            b.h(callStyleA, this.f2152n);
            IconCompat iconCompat2 = this.f2151m;
            if (iconCompat2 != null) {
                b.g(callStyleA, iconCompat2.h(this.f2178a.f2120a));
            }
            b.f(callStyleA, this.j);
        }
    }

    @Override // G.w
    public final String c() {
        return "androidx.core.app.NotificationCompat$CallStyle";
    }

    @Override // G.w
    public final void d(Bundle bundle) {
        super.d(bundle);
        this.f2144e = bundle.getInt("android.callType");
        this.j = bundle.getBoolean("android.callIsVideo");
        if (Build.VERSION.SDK_INT >= 28 && bundle.containsKey("android.callPerson")) {
            this.f2145f = B.a.a(C0298l.i(bundle.getParcelable("android.callPerson")));
        } else if (bundle.containsKey("android.callPersonCompat")) {
            this.f2145f = B.a(bundle.getBundle("android.callPersonCompat"));
        }
        if (bundle.containsKey("android.verificationIcon")) {
            this.f2151m = IconCompat.c((Icon) bundle.getParcelable("android.verificationIcon"));
        } else if (bundle.containsKey("android.verificationIconCompat")) {
            this.f2151m = IconCompat.b(bundle.getBundle("android.verificationIconCompat"));
        }
        this.f2152n = bundle.getCharSequence("android.verificationText");
        this.f2146g = (PendingIntent) bundle.getParcelable("android.answerIntent");
        this.f2147h = (PendingIntent) bundle.getParcelable("android.declineIntent");
        this.f2148i = (PendingIntent) bundle.getParcelable("android.hangUpIntent");
        this.f2149k = bundle.containsKey("android.answerColor") ? Integer.valueOf(bundle.getInt("android.answerColor")) : null;
        this.f2150l = bundle.containsKey("android.declineColor") ? Integer.valueOf(bundle.getInt("android.declineColor")) : null;
    }

    public final k e(int i9, int i10, Integer num, int i11, PendingIntent pendingIntent) {
        if (num == null) {
            num = Integer.valueOf(this.f2178a.f2120a.getColor(i11));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.f2178a.f2120a.getResources().getString(i10));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
        Context context = this.f2178a.f2120a;
        PorterDuff.Mode mode = IconCompat.f7071k;
        context.getClass();
        k kVarA = new k.a(IconCompat.e(context.getResources(), context.getPackageName(), i9), spannableStringBuilder, pendingIntent).a();
        kVarA.f2088a.putBoolean("key_action_priority", true);
        return kVarA;
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class a {
        public static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        public static Parcelable b(Person person) {
            return person;
        }
    }
}
