package io.flutter.plugin.platform;

import T.C0437y;
import T.X;
import T.Y;
import T.Z;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import androidx.datastore.preferences.protobuf.C0524s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: PlatformPlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z6.e f19598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p088l7.j f19599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Z6.e f19600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l7.j.c f19601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19602e;

    /* JADX INFO: compiled from: PlatformPlugin.java */
    public class a {
        public a() {
        }

        public final CharSequence a(l7.j.b bVar) {
            Z6.e eVar = c.this.f19598a;
            ClipboardManager clipboardManager = (ClipboardManager) eVar.getSystemService("clipboard");
            CharSequence charSequence = null;
            if (clipboardManager.hasPrimaryClip()) {
                try {
                    try {
                        ClipData primaryClip = clipboardManager.getPrimaryClip();
                        if (primaryClip != null) {
                            if (bVar != null) {
                                if (bVar == l7.j.b.f20136a) {
                                }
                            }
                            ClipData.Item itemAt = primaryClip.getItemAt(0);
                            CharSequence text = itemAt.getText();
                            if (text != null) {
                                return text;
                            }
                            try {
                                Uri uri = itemAt.getUri();
                                if (uri == null) {
                                    Log.w("PlatformPlugin", "Clipboard item contained no textual content nor a URI to retrieve it from.");
                                    return null;
                                }
                                String scheme = uri.getScheme();
                                if (!scheme.equals("content")) {
                                    Log.w("PlatformPlugin", "Clipboard item contains a Uri with scheme '" + scheme + "'that is unhandled.");
                                    return null;
                                }
                                AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor = eVar.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null);
                                CharSequence charSequenceCoerceToText = itemAt.coerceToText(eVar);
                                if (assetFileDescriptorOpenTypedAssetFileDescriptor == null) {
                                    return charSequenceCoerceToText;
                                }
                                try {
                                    assetFileDescriptorOpenTypedAssetFileDescriptor.close();
                                    return charSequenceCoerceToText;
                                } catch (IOException e9) {
                                    charSequence = charSequenceCoerceToText;
                                    e = e9;
                                    Log.w("PlatformPlugin", "Failed to close AssetFileDescriptor while trying to read text from URI.", e);
                                    return charSequence;
                                }
                            } catch (IOException e10) {
                                e = e10;
                                charSequence = text;
                            }
                        }
                    } catch (IOException e11) {
                        e = e11;
                    }
                } catch (FileNotFoundException unused) {
                    Log.w("PlatformPlugin", "Clipboard text was unable to be received from content URI.");
                    return charSequence;
                } catch (SecurityException e12) {
                    Log.w("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e12);
                    return charSequence;
                }
            }
            return null;
        }

        public final void b(ArrayList arrayList) {
            c cVar = c.this;
            cVar.getClass();
            int i9 = arrayList.isEmpty() ? 5894 : 1798;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                int iOrdinal = ((l7.j.d) arrayList.get(i10)).ordinal();
                if (iOrdinal == 0) {
                    i9 &= -5;
                } else if (iOrdinal == 1) {
                    i9 &= -515;
                }
            }
            cVar.f19602e = i9;
            cVar.b();
        }

        public final void c(int i9) {
            View decorView = c.this.f19598a.getWindow().getDecorView();
            switch (C0524s.b(i9)) {
                case 0:
                    decorView.performHapticFeedback(0);
                    break;
                case 1:
                    decorView.performHapticFeedback(1);
                    break;
                case 2:
                    decorView.performHapticFeedback(3);
                    break;
                case 3:
                    decorView.performHapticFeedback(6);
                    break;
                case 4:
                    decorView.performHapticFeedback(4);
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT >= 30) {
                        decorView.performHapticFeedback(16);
                    }
                    break;
                case 6:
                    if (Build.VERSION.SDK_INT >= 30) {
                        decorView.performHapticFeedback(3);
                    }
                    break;
                case 7:
                    if (Build.VERSION.SDK_INT >= 30) {
                        decorView.performHapticFeedback(17);
                    }
                    break;
            }
        }
    }

    public c(Z6.e eVar, p088l7.j jVar, Z6.e eVar2) {
        a aVar = new a();
        this.f19598a = eVar;
        this.f19599b = jVar;
        jVar.f20134b = aVar;
        this.f19600c = eVar2;
        this.f19602e = 1280;
    }

    @Deprecated
    public final void a(l7.j.c cVar) {
        p027d5.a x8;
        Window window = this.f19598a.getWindow();
        C0437y c0437y = new C0437y(window.getDecorView());
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 35) {
            Z z8 = new Z(window.getInsetsController(), c0437y);
            z8.j = window;
            x8 = z8;
        } else if (i9 >= 30) {
            Y y8 = new Y(window.getInsetsController(), c0437y);
            y8.j = window;
            x8 = y8;
        } else {
            x8 = new X(window, c0437y);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(201326592);
        }
        int i11 = cVar.f20139b;
        if (i11 != 0) {
            int iB = C0524s.b(i11);
            if (iB == 0) {
                x8.y(false);
            } else if (iB == 1) {
                x8.y(true);
            }
        }
        Integer num = cVar.f20138a;
        if (num != null) {
            window.setStatusBarColor(num.intValue());
        }
        Boolean bool = cVar.f20140c;
        if (bool != null && i10 >= 29) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        int i12 = cVar.f20142e;
        if (i12 != 0) {
            int iB2 = C0524s.b(i12);
            if (iB2 == 0) {
                x8.x(false);
            } else if (iB2 == 1) {
                x8.x(true);
            }
        }
        Integer num2 = cVar.f20141d;
        if (num2 != null) {
            window.setNavigationBarColor(num2.intValue());
        }
        Integer num3 = cVar.f20143f;
        if (num3 != null && i10 >= 28) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = cVar.f20144g;
        if (bool2 != null && i10 >= 29) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.f19601d = cVar;
    }

    public final void b() {
        this.f19598a.getWindow().getDecorView().setSystemUiVisibility(this.f19602e);
        l7.j.c cVar = this.f19601d;
        if (cVar != null) {
            a(cVar);
        }
    }
}
