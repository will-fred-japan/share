package T;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

/* JADX INFO: renamed from: T.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0416c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f4405a;

    /* JADX INFO: renamed from: T.c$a */
    /* JADX INFO: compiled from: ContentInfoCompat.java */
    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentInfo.Builder f4406a;

        public a(ClipData clipData, int i9) {
            this.f4406a = I6.a.g(clipData, i9);
        }

        @Override // T.C0416c.b
        public final C0416c a() {
            return new C0416c(new d(this.f4406a.build()));
        }

        @Override // T.C0416c.b
        public final void b(Uri uri) {
            this.f4406a.setLinkUri(uri);
        }

        @Override // T.C0416c.b
        public final void c(int i9) {
            this.f4406a.setFlags(i9);
        }

        @Override // T.C0416c.b
        public final void setExtras(Bundle bundle) {
            this.f4406a.setExtras(bundle);
        }
    }

    /* JADX INFO: renamed from: T.c$b */
    /* JADX INFO: compiled from: ContentInfoCompat.java */
    public interface b {
        C0416c a();

        void b(Uri uri);

        void c(int i9);

        void setExtras(Bundle bundle);
    }

    /* JADX INFO: renamed from: T.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContentInfoCompat.java */
    public static final class C0053c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ClipData f4407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Uri f4410d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bundle f4411e;

        @Override // T.C0416c.b
        public final C0416c a() {
            return new C0416c(new f(this));
        }

        @Override // T.C0416c.b
        public final void b(Uri uri) {
            this.f4410d = uri;
        }

        @Override // T.C0416c.b
        public final void c(int i9) {
            this.f4409c = i9;
        }

        @Override // T.C0416c.b
        public final void setExtras(Bundle bundle) {
            this.f4411e = bundle;
        }
    }

    /* JADX INFO: renamed from: T.c$d */
    /* JADX INFO: compiled from: ContentInfoCompat.java */
    public static final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContentInfo f4412a;

        public d(ContentInfo contentInfo) {
            contentInfo.getClass();
            this.f4412a = E5.f.g(contentInfo);
        }

        @Override // T.C0416c.e
        public final ClipData a() {
            return this.f4412a.getClip();
        }

        @Override // T.C0416c.e
        public final int b() {
            return this.f4412a.getFlags();
        }

        @Override // T.C0416c.e
        public final ContentInfo c() {
            return this.f4412a;
        }

        @Override // T.C0416c.e
        public final int d() {
            return this.f4412a.getSource();
        }

        public final String toString() {
            return "ContentInfoCompat{" + this.f4412a + "}";
        }
    }

    /* JADX INFO: renamed from: T.c$e */
    /* JADX INFO: compiled from: ContentInfoCompat.java */
    public interface e {
        ClipData a();

        int b();

        ContentInfo c();

        int d();
    }

    /* JADX INFO: renamed from: T.c$f */
    /* JADX INFO: compiled from: ContentInfoCompat.java */
    public static final class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ClipData f4413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Uri f4416d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f4417e;

        public f(C0053c c0053c) {
            ClipData clipData = c0053c.f4407a;
            clipData.getClass();
            this.f4413a = clipData;
            int i9 = c0053c.f4408b;
            if (i9 < 0) {
                Locale locale = Locale.US;
                throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
            }
            if (i9 > 5) {
                Locale locale2 = Locale.US;
                throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
            }
            this.f4414b = i9;
            int i10 = c0053c.f4409c;
            if ((i10 & 1) == i10) {
                this.f4415c = i10;
                this.f4416d = c0053c.f4410d;
                this.f4417e = c0053c.f4411e;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i10) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }

        @Override // T.C0416c.e
        public final ClipData a() {
            return this.f4413a;
        }

        @Override // T.C0416c.e
        public final int b() {
            return this.f4415c;
        }

        @Override // T.C0416c.e
        public final ContentInfo c() {
            return null;
        }

        @Override // T.C0416c.e
        public final int d() {
            return this.f4414b;
        }

        public final String toString() {
            String strValueOf;
            String str;
            StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
            sb.append(this.f4413a.getDescription());
            sb.append(", source=");
            int i9 = this.f4414b;
            if (i9 == 0) {
                strValueOf = "SOURCE_APP";
            } else if (i9 == 1) {
                strValueOf = "SOURCE_CLIPBOARD";
            } else if (i9 == 2) {
                strValueOf = "SOURCE_INPUT_METHOD";
            } else if (i9 == 3) {
                strValueOf = "SOURCE_DRAG_AND_DROP";
            } else if (i9 != 4) {
                strValueOf = i9 != 5 ? String.valueOf(i9) : "SOURCE_PROCESS_TEXT";
            } else {
                strValueOf = "SOURCE_AUTOFILL";
            }
            sb.append(strValueOf);
            sb.append(", flags=");
            int i10 = this.f4415c;
            sb.append((i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10));
            Uri uri = this.f4416d;
            if (uri == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + uri.toString().length() + ")";
            }
            sb.append(str);
            return A.a.j(sb, this.f4417e != null ? ", hasExtras" : "", "}");
        }
    }

    public C0416c(e eVar) {
        this.f4405a = eVar;
    }

    public final String toString() {
        return this.f4405a.toString();
    }
}
