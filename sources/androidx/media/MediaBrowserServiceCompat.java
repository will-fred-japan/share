package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f7796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f7797b = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f7798c = new b("android.media.session.MediaController", -1, -1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<b> f7799d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p155u.a<IBinder, b> f7800e = new p155u.a<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f7801f;

    public static final class a {
    }

    public class b implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f7804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final i f7805d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final HashMap<String, List<S.b<IBinder, Bundle>>> f7806e = new HashMap<>();

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b bVar = b.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.f7800e.remove(bVar.f7805d.f7820a.getBinder());
            }
        }

        public b(String str, int i9, int i10, i iVar) {
            this.f7802a = str;
            this.f7803b = i9;
            this.f7804c = i10;
            if (str == null) {
                throw new NullPointerException("package shouldn't be null");
            }
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            if (Build.VERSION.SDK_INT >= 28) {
                p029d7.b.f(i9, i10, str);
            }
            this.f7805d = iVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f7801f.post(new a());
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f7809a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f7810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Messenger f7811c;

        public class a extends MediaBrowserService {
            public a(Context context) {
                attachBaseContext(context);
            }

            @Override // android.service.media.MediaBrowserService
            public final MediaBrowserService.BrowserRoot onGetRoot(String str, int i9, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
                c cVar = c.this;
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                int i10 = -1;
                if (bundle2 != null && bundle2.getInt("extra_client_version", 0) != 0) {
                    bundle2.remove("extra_client_version");
                    cVar.f7811c = new Messenger(mediaBrowserServiceCompat.f7801f);
                    Bundle bundleJ = W5.f.j(2, "extra_service_version");
                    bundleJ.putBinder("extra_messenger", cVar.f7811c.getBinder());
                    cVar.f7809a.add(bundleJ);
                    i10 = bundle2.getInt("extra_calling_pid", -1);
                    bundle2.remove("extra_calling_pid");
                }
                MediaBrowserServiceCompat.this.new b(str, i10, i9, null);
                mediaBrowserServiceCompat.a();
                return null;
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
                c cVar = c.this;
                cVar.getClass();
                MediaBrowserServiceCompat.this.b();
            }
        }

        public c() {
        }
    }

    public class d extends c {

        public class a extends c.a {
            public a(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
                g gVar = new g(result);
                b bVar = MediaBrowserServiceCompat.this.f7798c;
                gVar.f7818a.sendResult(null);
            }
        }

        public d() {
            super();
        }
    }

    public class e extends d {

        public class a extends d.a {
            public a(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public final void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
                MediaSessionCompat.a(bundle);
                MediaBrowserServiceCompat.this.b();
            }
        }

        public e() {
            super();
        }
    }

    public class f extends e {
    }

    public static class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaBrowserService.Result f7818a;

        public g(MediaBrowserService.Result result) {
            this.f7818a = result;
        }
    }

    public class h {
        public h() {
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Messenger f7820a;

        public i(Messenger messenger) {
            this.f7820a = messenger;
        }
    }

    public static final class j extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaBrowserServiceCompat f7821a;

        public final void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            MediaBrowserServiceCompat mediaBrowserServiceCompat = this.f7821a;
            if (mediaBrowserServiceCompat == null) {
                removeCallbacksAndMessages(null);
                return;
            }
            Bundle data = message.getData();
            int i9 = message.what;
            h hVar = mediaBrowserServiceCompat.f7797b;
            switch (i9) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    String string = data.getString("data_package_name");
                    int i10 = data.getInt("data_calling_pid");
                    int i11 = data.getInt("data_calling_uid");
                    i iVar = new i(message.replyTo);
                    MediaBrowserServiceCompat mediaBrowserServiceCompat2 = MediaBrowserServiceCompat.this;
                    if (string != null) {
                        String[] packagesForUid = mediaBrowserServiceCompat2.getPackageManager().getPackagesForUid(i11);
                        int length = packagesForUid.length;
                        int i12 = 0;
                        while (i12 < length) {
                            if (packagesForUid[i12].equals(string)) {
                                mediaBrowserServiceCompat2.f7801f.a(new androidx.media.a(i10, i11, bundle, hVar, iVar, string));
                                return;
                            } else {
                                i12++;
                                iVar = iVar;
                            }
                        }
                    }
                    throw new IllegalArgumentException("Package/uid mismatch: uid=" + i11 + " package=" + string);
                case 2:
                    i iVar2 = new i(message.replyTo);
                    MediaBrowserServiceCompat.this.f7801f.a(new androidx.media.b(hVar, iVar2));
                    return;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    String string2 = data.getString("data_media_item_id");
                    IBinder binder = data.getBinder("data_callback_token");
                    i iVar3 = new i(message.replyTo);
                    MediaBrowserServiceCompat.this.f7801f.a(new androidx.media.c(hVar, iVar3, string2, binder, bundle2));
                    return;
                case 4:
                    String string3 = data.getString("data_media_item_id");
                    IBinder binder2 = data.getBinder("data_callback_token");
                    i iVar4 = new i(message.replyTo);
                    MediaBrowserServiceCompat.this.f7801f.a(new androidx.media.d(hVar, iVar4, string3, binder2));
                    return;
                case 5:
                    String string4 = data.getString("data_media_item_id");
                    ResultReceiver resultReceiver = (ResultReceiver) data.getParcelable("data_result_receiver");
                    i iVar5 = new i(message.replyTo);
                    hVar.getClass();
                    if (TextUtils.isEmpty(string4) || resultReceiver == null) {
                        return;
                    }
                    MediaBrowserServiceCompat.this.f7801f.a(new androidx.media.e(hVar, iVar5, string4, resultReceiver));
                    return;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle3);
                    i iVar6 = new i(message.replyTo);
                    String string5 = data.getString("data_package_name");
                    int i13 = data.getInt("data_calling_pid");
                    int i14 = data.getInt("data_calling_uid");
                    MediaBrowserServiceCompat.this.f7801f.a(new androidx.media.f(i14, i13, bundle3, hVar, iVar6, string5));
                    return;
                case 7:
                    i iVar7 = new i(message.replyTo);
                    MediaBrowserServiceCompat.this.f7801f.a(new androidx.media.g(hVar, iVar7));
                    return;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.a(bundle4);
                    String string6 = data.getString("data_search_query");
                    ResultReceiver resultReceiver2 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    i iVar8 = new i(message.replyTo);
                    hVar.getClass();
                    if (TextUtils.isEmpty(string6) || resultReceiver2 == null) {
                        return;
                    }
                    MediaBrowserServiceCompat.this.f7801f.a(new androidx.media.h(hVar, iVar8, string6, bundle4, resultReceiver2));
                    return;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.a(bundle5);
                    String string7 = data.getString("data_custom_action");
                    ResultReceiver resultReceiver3 = (ResultReceiver) data.getParcelable("data_result_receiver");
                    i iVar9 = new i(message.replyTo);
                    hVar.getClass();
                    if (TextUtils.isEmpty(string7) || resultReceiver3 == null) {
                        return;
                    }
                    MediaBrowserServiceCompat.this.f7801f.a(new androidx.media.i(hVar, iVar9, string7, bundle5, resultReceiver3));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    return;
            }
        }

        @Override // android.os.Handler
        public final boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid > 0) {
                data.putInt("data_calling_pid", callingPid);
            } else if (!data.containsKey("data_calling_pid")) {
                data.putInt("data_calling_pid", -1);
            }
            return super.sendMessageAtTime(message, j);
        }
    }

    static {
        Log.isLoggable("MBServiceCompat", 3);
    }

    public MediaBrowserServiceCompat() {
        j jVar = new j();
        jVar.f7821a = this;
        this.f7801f = jVar;
    }

    public abstract a a();

    public abstract void b();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f7796a.f7810b.onBind(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            this.f7796a = new f();
        } else {
            this.f7796a = new e();
        }
        e eVar = this.f7796a;
        eVar.getClass();
        e.a aVar = eVar.new a(MediaBrowserServiceCompat.this);
        eVar.f7810b = aVar;
        aVar.onCreate();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f7801f.f7821a = null;
    }

    @Override // android.app.Service
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
