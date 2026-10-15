package G;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class l extends w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IconCompat f2106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IconCompat f2107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2109h;

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class a {
        public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
            bigPictureStyle.bigPicture(icon);
        }

        public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
            bigPictureStyle.setContentDescription(charSequence);
        }

        public static void c(Notification.BigPictureStyle bigPictureStyle, boolean z8) {
            bigPictureStyle.showBigPictureWhenCollapsed(z8);
        }
    }

    public static IconCompat e(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        if (parcelable instanceof Icon) {
            return IconCompat.c((Icon) parcelable);
        }
        if (parcelable instanceof Bitmap) {
            return IconCompat.d((Bitmap) parcelable);
        }
        return null;
    }

    @Override // G.w
    public final void b(x xVar) {
        Bitmap bitmap;
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(xVar.f2183b).setBigContentTitle(this.f2179b);
        IconCompat iconCompat = this.f2106e;
        Context context = xVar.f2182a;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                a.a(bigContentTitle, iconCompat.h(context));
            } else {
                int iC = iconCompat.f7072a;
                if (iC == -1) {
                    iC = IconCompat.a.c(iconCompat.f7073b);
                }
                if (iC == 1) {
                    IconCompat iconCompat2 = this.f2106e;
                    int i9 = iconCompat2.f7072a;
                    if (i9 == -1) {
                        Object obj = iconCompat2.f7073b;
                        bitmap = obj instanceof Bitmap ? (Bitmap) obj : null;
                    } else if (i9 == 1) {
                        bitmap = (Bitmap) iconCompat2.f7073b;
                    } else {
                        if (i9 != 5) {
                            throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                        }
                        Bitmap bitmap2 = (Bitmap) iconCompat2.f7073b;
                        int iMin = (int) (Math.min(bitmap2.getWidth(), bitmap2.getHeight()) * 0.6666667f);
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        Paint paint = new Paint(3);
                        float f6 = iMin;
                        float f9 = 0.5f * f6;
                        float f10 = 0.9166667f * f9;
                        float f11 = 0.010416667f * f6;
                        paint.setColor(0);
                        paint.setShadowLayer(f11, 0.0f, f6 * 0.020833334f, 1023410176);
                        canvas.drawCircle(f9, f9, f10, paint);
                        paint.setShadowLayer(f11, 0.0f, 0.0f, 503316480);
                        canvas.drawCircle(f9, f9, f10, paint);
                        paint.clearShadowLayer();
                        paint.setColor(-16777216);
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
                        Matrix matrix = new Matrix();
                        matrix.setTranslate((-(bitmap2.getWidth() - iMin)) / 2.0f, (-(bitmap2.getHeight() - iMin)) / 2.0f);
                        bitmapShader.setLocalMatrix(matrix);
                        paint.setShader(bitmapShader);
                        canvas.drawCircle(f9, f9, f10, paint);
                        canvas.setBitmap(null);
                        bitmap = bitmapCreateBitmap;
                    }
                    bigContentTitle = bigContentTitle.bigPicture(bitmap);
                }
            }
        }
        if (this.f2108g) {
            IconCompat iconCompat3 = this.f2107f;
            if (iconCompat3 == null) {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            } else {
                bigContentTitle.bigLargeIcon(iconCompat3.h(context));
            }
        }
        if (this.f2181d) {
            bigContentTitle.setSummaryText(this.f2180c);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            a.c(bigContentTitle, this.f2109h);
            a.b(bigContentTitle, null);
        }
    }

    @Override // G.w
    public final String c() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }

    @Override // G.w
    public final void d(Bundle bundle) {
        super.d(bundle);
        if (bundle.containsKey("android.largeIcon.big")) {
            this.f2107f = e(bundle.getParcelable("android.largeIcon.big"));
            this.f2108g = true;
        }
        Parcelable parcelable = bundle.getParcelable("android.picture");
        this.f2106e = parcelable != null ? e(parcelable) : e(bundle.getParcelable("android.pictureIcon"));
        this.f2109h = bundle.getBoolean("android.showBigPictureWhenCollapsed");
    }
}
