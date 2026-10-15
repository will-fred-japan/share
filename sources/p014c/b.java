package p014c;

import G.y;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.service.notification.StatusBarNotification;
import androidx.browser.trusted.TrustedWebActivityService;
import p056h5.C0598e;

/* JADX INFO: compiled from: ITrustedWebActivityService.java */
/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f8664s = "android$support$customtabs$trusted$ITrustedWebActivityService".replace('$', '.');

    /* JADX INFO: compiled from: ITrustedWebActivityService.java */
    public static abstract class a extends Binder implements b {
        @Override // android.os.Binder
        public final boolean onTransact(int i9, Parcel parcel, Parcel parcel2, int i10) {
            NotificationChannel notificationChannel;
            IInterface iInterfaceQueryLocalInterface;
            String str = b.f8664s;
            if (i9 >= 1 && i9 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i9 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            boolean z8 = false;
            Notification notificationBuild = null;
            switch (i9) {
                case 2:
                    Bundle bundle = (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                    TrustedWebActivityService.a aVar = (TrustedWebActivityService.a) this;
                    aVar.y();
                    C0598e.t(bundle, "android.support.customtabs.trusted.PLATFORM_TAG");
                    C0598e.t(bundle, "android.support.customtabs.trusted.PLATFORM_ID");
                    C0598e.t(bundle, "android.support.customtabs.trusted.NOTIFICATION");
                    C0598e.t(bundle, "android.support.customtabs.trusted.CHANNEL_NAME");
                    String string = bundle.getString("android.support.customtabs.trusted.PLATFORM_TAG");
                    int i11 = bundle.getInt("android.support.customtabs.trusted.PLATFORM_ID");
                    Notification notification = (Notification) bundle.getParcelable("android.support.customtabs.trusted.NOTIFICATION");
                    String string2 = bundle.getString("android.support.customtabs.trusted.CHANNEL_NAME");
                    TrustedWebActivityService trustedWebActivityService = TrustedWebActivityService.this;
                    if (trustedWebActivityService.f6743a == null) {
                        throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
                    }
                    if (new y(trustedWebActivityService).f2193b.areNotificationsEnabled()) {
                        String strA = TrustedWebActivityService.a(string2);
                        NotificationManager notificationManager = trustedWebActivityService.f6743a;
                        notificationManager.createNotificationChannel(new NotificationChannel(strA, string2, 3));
                        if (notificationManager.getNotificationChannel(strA).getImportance() != 0) {
                            Notification.Builder builderRecoverBuilder = Notification.Builder.recoverBuilder(trustedWebActivityService, notification);
                            builderRecoverBuilder.setChannelId(strA);
                            notificationBuild = builderRecoverBuilder.build();
                        }
                        NotificationChannel notificationChannel2 = trustedWebActivityService.f6743a.getNotificationChannel(strA);
                        if (notificationChannel2 == null || notificationChannel2.getImportance() != 0) {
                            trustedWebActivityService.f6743a.notify(string, i11, notificationBuild);
                            z8 = true;
                        }
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", z8);
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundle2.writeToParcel(parcel2, 1);
                    return true;
                case 3:
                    Bundle bundle3 = (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                    TrustedWebActivityService.a aVar2 = (TrustedWebActivityService.a) this;
                    aVar2.y();
                    C0598e.t(bundle3, "android.support.customtabs.trusted.PLATFORM_TAG");
                    C0598e.t(bundle3, "android.support.customtabs.trusted.PLATFORM_ID");
                    String string3 = bundle3.getString("android.support.customtabs.trusted.PLATFORM_TAG");
                    int i12 = bundle3.getInt("android.support.customtabs.trusted.PLATFORM_ID");
                    NotificationManager notificationManager2 = TrustedWebActivityService.this.f6743a;
                    if (notificationManager2 == null) {
                        throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
                    }
                    notificationManager2.cancel(string3, i12);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    TrustedWebActivityService.a aVar3 = (TrustedWebActivityService.a) this;
                    aVar3.y();
                    int iC = TrustedWebActivityService.this.c();
                    parcel2.writeNoException();
                    parcel2.writeInt(iC);
                    return true;
                case 5:
                    TrustedWebActivityService.a aVar4 = (TrustedWebActivityService.a) this;
                    aVar4.y();
                    NotificationManager notificationManager3 = TrustedWebActivityService.this.f6743a;
                    if (notificationManager3 == null) {
                        throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
                    }
                    StatusBarNotification[] activeNotifications = notificationManager3.getActiveNotifications();
                    Bundle bundle4 = new Bundle();
                    bundle4.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", activeNotifications);
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundle4.writeToParcel(parcel2, 1);
                    return true;
                case 6:
                    Bundle bundle5 = (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                    TrustedWebActivityService.a aVar5 = (TrustedWebActivityService.a) this;
                    aVar5.y();
                    C0598e.t(bundle5, "android.support.customtabs.trusted.CHANNEL_NAME");
                    String string4 = bundle5.getString("android.support.customtabs.trusted.CHANNEL_NAME");
                    TrustedWebActivityService trustedWebActivityService2 = TrustedWebActivityService.this;
                    if (trustedWebActivityService2.f6743a == null) {
                        throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
                    }
                    if (new y(trustedWebActivityService2).f2193b.areNotificationsEnabled() && ((notificationChannel = trustedWebActivityService2.f6743a.getNotificationChannel(TrustedWebActivityService.a(string4))) == null || notificationChannel.getImportance() != 0)) {
                        z8 = true;
                    }
                    Bundle bundle6 = new Bundle();
                    bundle6.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", z8);
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundle6.writeToParcel(parcel2, 1);
                    return true;
                case 7:
                    TrustedWebActivityService.a aVar6 = (TrustedWebActivityService.a) this;
                    aVar6.y();
                    TrustedWebActivityService trustedWebActivityService3 = TrustedWebActivityService.this;
                    int iC2 = trustedWebActivityService3.c();
                    Bundle bundle7 = new Bundle();
                    if (iC2 != -1) {
                        bundle7.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(trustedWebActivityService3.getResources(), iC2));
                    }
                    parcel2.writeNoException();
                    parcel2.writeInt(1);
                    bundle7.writeToParcel(parcel2, 1);
                    return true;
                case 8:
                default:
                    return super.onTransact(i9, parcel, parcel2, i10);
                case 9:
                    parcel.readString();
                    IBinder strongBinder = parcel.readStrongBinder();
                    ((TrustedWebActivityService.a) this).y();
                    if (strongBinder != null && (iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface(p014c.a.f8663r)) != null && (iInterfaceQueryLocalInterface instanceof p014c.a)) {
                    }
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}
