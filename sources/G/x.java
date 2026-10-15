package G;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import cn.ikaile.ruoshui.client.R;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: NotificationCompatBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Notification.Builder f2183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f2184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f2185d = new Bundle();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2186e;

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    public static class a {
        public static void a(Notification.Builder builder, Person person) {
            builder.addPerson(person);
        }

        public static void b(Notification.Action.Builder builder, int i9) {
            builder.setSemanticAction(i9);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    public static class b {
        public static void a(Notification.Builder builder, boolean z8) {
            builder.setAllowSystemGeneratedContextualActions(z8);
        }

        public static void b(Notification.Builder builder) {
            builder.setBubbleMetadata(null);
        }

        public static void c(Notification.Action.Builder builder, boolean z8) {
            builder.setContextual(z8);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    public static class c {
        public static void a(Notification.Action.Builder builder) {
            builder.setAuthenticationRequired(false);
        }
    }

    /* JADX INFO: compiled from: NotificationCompatBuilder.java */
    public static final class d {
        public static void a(Notification.Builder builder) {
            builder.setShortCriticalText(null);
        }
    }

    public x(n nVar) {
        ArrayList<B> arrayList;
        Bundle[] bundleArr;
        ArrayList<String> arrayList2;
        k kVarE;
        int i9;
        this.f2184c = nVar;
        Context context = nVar.f2120a;
        this.f2182a = context;
        Notification.Builder builder = new Notification.Builder(context, nVar.f2112B);
        this.f2183b = builder;
        Notification notification = nVar.f2117G;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(nVar.f2124e).setContentText(nVar.f2125f).setContentInfo(null).setContentIntent(nVar.f2126g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(nVar.f2127h, (notification.flags & 128) != 0).setNumber(nVar.j).setProgress(nVar.f2134p, nVar.f2135q, nVar.f2136r);
        IconCompat iconCompat = nVar.f2128i;
        builder.setLargeIcon(iconCompat == null ? null : iconCompat.h(context));
        builder.setSubText(nVar.f2133o).setUsesChronometer(nVar.f2131m).setPriority(nVar.f2129k);
        w wVar = nVar.f2132n;
        if (wVar instanceof p) {
            p pVar = (p) wVar;
            PendingIntent pendingIntent = pVar.f2147h;
            k kVarE2 = pendingIntent == null ? pVar.e(R.drawable.ic_call_decline, R.string.call_notification_hang_up_action, pVar.f2150l, R.color.call_notification_decline_color, pVar.f2148i) : pVar.e(R.drawable.ic_call_decline, R.string.call_notification_decline_action, pVar.f2150l, R.color.call_notification_decline_color, pendingIntent);
            PendingIntent pendingIntent2 = pVar.f2146g;
            if (pendingIntent2 == null) {
                kVarE = null;
            } else {
                boolean z8 = pVar.j;
                kVarE = pVar.e(z8 ? R.drawable.ic_call_answer_video : R.drawable.ic_call_answer, z8 ? R.string.call_notification_answer_video_action : R.string.call_notification_answer_action, pVar.f2149k, R.color.call_notification_answer_color, pendingIntent2);
            }
            ArrayList arrayList3 = new ArrayList(3);
            arrayList3.add(kVarE2);
            ArrayList<k> arrayList4 = pVar.f2178a.f2121b;
            if (arrayList4 != null) {
                i9 = 2;
                for (k kVar : arrayList4) {
                    if (kVar.f2094g) {
                        arrayList3.add(kVar);
                    } else if (!kVar.f2088a.getBoolean("key_action_priority")) {
                        arrayList3.add(kVar);
                        i9--;
                    }
                    if (kVarE != null && i9 == 1) {
                        arrayList3.add(kVarE);
                        i9--;
                    }
                }
            } else {
                i9 = 2;
            }
            if (kVarE != null && i9 >= 1) {
                arrayList3.add(kVarE);
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                a((k) it.next());
            }
        } else {
            Iterator<k> it2 = nVar.f2121b.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
        }
        Bundle bundle = nVar.f2142y;
        if (bundle != null) {
            this.f2185d.putAll(bundle);
        }
        this.f2183b.setShowWhen(nVar.f2130l);
        this.f2183b.setLocalOnly(nVar.f2138u);
        this.f2183b.setGroup(nVar.f2137s);
        this.f2183b.setSortKey(null);
        this.f2183b.setGroupSummary(nVar.t);
        this.f2186e = nVar.f2115E;
        this.f2183b.setCategory(nVar.f2141x);
        this.f2183b.setColor(nVar.f2143z);
        this.f2183b.setVisibility(nVar.f2111A);
        this.f2183b.setPublicVersion(null);
        this.f2183b.setSound(notification.sound, notification.audioAttributes);
        int i10 = Build.VERSION.SDK_INT;
        ArrayList<String> arrayList5 = nVar.f2119I;
        ArrayList<B> arrayList6 = nVar.f2122c;
        if (i10 < 28) {
            if (arrayList6 == null) {
                arrayList2 = null;
            } else {
                arrayList2 = new ArrayList<>(arrayList6.size());
                for (B b9 : arrayList6) {
                    String str = b9.f2054c;
                    if (str == null) {
                        CharSequence charSequence = b9.f2052a;
                        str = charSequence != null ? "name:" + ((Object) charSequence) : "";
                    }
                    arrayList2.add(str);
                }
            }
            if (arrayList2 != null) {
                if (arrayList5 == null) {
                    arrayList5 = arrayList2;
                } else {
                    p155u.b bVar = new p155u.b(arrayList5.size() + arrayList2.size());
                    bVar.addAll(arrayList2);
                    bVar.addAll(arrayList5);
                    arrayList5 = new ArrayList<>(bVar);
                }
            }
        }
        if (arrayList5 != null && !arrayList5.isEmpty()) {
            Iterator<String> it3 = arrayList5.iterator();
            while (it3.hasNext()) {
                this.f2183b.addPerson(it3.next());
            }
        }
        ArrayList<k> arrayList7 = nVar.f2123d;
        if (arrayList7.size() > 0) {
            if (nVar.f2142y == null) {
                nVar.f2142y = new Bundle();
            }
            Bundle bundle2 = nVar.f2142y.getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            int i11 = 0;
            while (i11 < arrayList7.size()) {
                String string = Integer.toString(i11);
                k kVar2 = arrayList7.get(i11);
                Bundle bundle5 = new Bundle();
                IconCompat iconCompatA = kVar2.a();
                bundle5.putInt(RemoteMessageConst.Notification.ICON, iconCompatA != null ? iconCompatA.f() : 0);
                bundle5.putCharSequence("title", kVar2.f2096i);
                bundle5.putParcelable("actionIntent", kVar2.j);
                Bundle bundle6 = kVar2.f2088a;
                Bundle bundle7 = bundle6 != null ? new Bundle(bundle6) : new Bundle();
                bundle7.putBoolean("android.support.allowGeneratedReplies", kVar2.f2091d);
                bundle5.putBundle("extras", bundle7);
                D[] dArr = kVar2.f2090c;
                if (dArr == null) {
                    bundleArr = null;
                } else {
                    Bundle[] bundleArr2 = new Bundle[dArr.length];
                    int i12 = 0;
                    while (i12 < dArr.length) {
                        D d9 = dArr[i12];
                        int i13 = i12;
                        Bundle bundle8 = new Bundle();
                        d9.getClass();
                        D[] dArr2 = dArr;
                        Bundle[] bundleArr3 = bundleArr2;
                        bundle8.putString("resultKey", "FlutterLocalNotificationsPluginInputResult");
                        bundle8.putCharSequence("label", d9.f2059a);
                        bundle8.putCharSequenceArray("choices", d9.f2060b);
                        bundle8.putBoolean("allowFreeFormInput", d9.f2061c);
                        bundle8.putBundle("extras", d9.f2062d);
                        HashSet hashSet = d9.f2063e;
                        if (!hashSet.isEmpty()) {
                            ArrayList<String> arrayList8 = new ArrayList<>(hashSet.size());
                            Iterator it4 = hashSet.iterator();
                            while (it4.hasNext()) {
                                arrayList8.add((String) it4.next());
                            }
                            bundle8.putStringArrayList("allowedDataTypes", arrayList8);
                        }
                        bundleArr3[i13] = bundle8;
                        i12 = i13 + 1;
                        dArr = dArr2;
                        bundleArr2 = bundleArr3;
                    }
                    bundleArr = bundleArr2;
                }
                bundle5.putParcelableArray("remoteInputs", bundleArr);
                bundle5.putBoolean("showsUserInterface", kVar2.f2092e);
                bundle5.putInt("semanticAction", kVar2.f2093f);
                bundle4.putBundle(string, bundle5);
                i11++;
                arrayList7 = arrayList7;
                arrayList6 = arrayList6;
            }
            arrayList = arrayList6;
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            if (nVar.f2142y == null) {
                nVar.f2142y = new Bundle();
            }
            nVar.f2142y.putBundle("android.car.EXTENSIONS", bundle2);
            this.f2185d.putBundle("android.car.EXTENSIONS", bundle3);
        } else {
            arrayList = arrayList6;
        }
        int i14 = Build.VERSION.SDK_INT;
        this.f2183b.setExtras(nVar.f2142y);
        this.f2183b.setRemoteInputHistory(null);
        this.f2183b.setBadgeIconType(0);
        this.f2183b.setSettingsText(null);
        this.f2183b.setShortcutId(nVar.f2113C);
        this.f2183b.setTimeoutAfter(nVar.f2114D);
        this.f2183b.setGroupAlertBehavior(nVar.f2115E);
        if (nVar.f2140w) {
            this.f2183b.setColorized(nVar.f2139v);
        }
        if (!TextUtils.isEmpty(nVar.f2112B)) {
            this.f2183b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        if (i14 >= 28) {
            for (B b10 : arrayList) {
                Notification.Builder builder2 = this.f2183b;
                b10.getClass();
                a.a(builder2, B.a.b(b10));
            }
        }
        int i15 = Build.VERSION.SDK_INT;
        if (i15 >= 29) {
            b.a(this.f2183b, nVar.f2116F);
            b.b(this.f2183b);
        }
        if (i15 >= 36) {
            d.a(this.f2183b);
        }
        if (nVar.f2118H) {
            if (this.f2184c.t) {
                this.f2186e = 2;
            } else {
                this.f2186e = 1;
            }
            this.f2183b.setVibrate(null);
            this.f2183b.setSound(null);
            int i16 = notification.defaults & (-4);
            notification.defaults = i16;
            this.f2183b.setDefaults(i16);
            if (TextUtils.isEmpty(this.f2184c.f2137s)) {
                this.f2183b.setGroup("silent");
            }
            this.f2183b.setGroupAlertBehavior(this.f2186e);
        }
    }

    public final void a(k kVar) {
        IconCompat iconCompatA = kVar.a();
        Notification.Action.Builder builder = new Notification.Action.Builder(iconCompatA != null ? iconCompatA.h(null) : null, kVar.f2096i, kVar.j);
        D[] dArr = kVar.f2090c;
        if (dArr != null) {
            RemoteInput[] remoteInputArr = new RemoteInput[dArr.length];
            for (int i9 = 0; i9 < dArr.length; i9++) {
                D d9 = dArr[i9];
                d9.getClass();
                RemoteInput.Builder builderAddExtras = new RemoteInput.Builder("FlutterLocalNotificationsPluginInputResult").setLabel(d9.f2059a).setChoices(d9.f2060b).setAllowFreeFormInput(d9.f2061c).addExtras(d9.f2062d);
                Iterator it = d9.f2063e.iterator();
                while (it.hasNext()) {
                    builderAddExtras.setAllowDataType((String) it.next(), true);
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    D.a.a(builderAddExtras);
                }
                remoteInputArr[i9] = builderAddExtras.build();
            }
            for (RemoteInput remoteInput : remoteInputArr) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = kVar.f2088a;
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        boolean z8 = kVar.f2091d;
        bundle2.putBoolean("android.support.allowGeneratedReplies", z8);
        int i10 = Build.VERSION.SDK_INT;
        builder.setAllowGeneratedReplies(z8);
        int i11 = kVar.f2093f;
        bundle2.putInt("android.support.action.semanticAction", i11);
        if (i10 >= 28) {
            a.b(builder, i11);
        }
        if (i10 >= 29) {
            b.c(builder, kVar.f2094g);
        }
        if (i10 >= 31) {
            c.a(builder);
        }
        bundle2.putBoolean("android.support.action.showsUserInterface", kVar.f2092e);
        builder.addExtras(bundle2);
        this.f2183b.addAction(builder.build());
    }
}
