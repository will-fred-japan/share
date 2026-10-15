package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.util.TypedValue;
import android.widget.MediaController;
import com.alibaba.fastjson.asm.Opcodes;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: GifDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends Drawable implements Animatable, MediaController.MediaPlayerControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f20843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f20844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f20845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f20846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f20847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bitmap f20848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GifInfoHandle f20849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConcurrentLinkedQueue<pl.droidsonroids.gif.a> f20850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ColorStateList f20851i;
    public PorterDuffColorFilter j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f20852k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f20853l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final i f20854m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l f20855n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f20856o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ScheduledFuture<?> f20857p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f20858q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f20859r;

    /* JADX INFO: compiled from: GifDrawable.java */
    public class a extends m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f20860b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i9) {
            super(dVar);
            this.f20860b = i9;
        }

        @Override // pl.droidsonroids.gif.m
        public final void a() {
            d dVar = d.this;
            int i9 = this.f20860b;
            dVar.f20849g.t(dVar.f20848f, i9);
            this.f20873a.f20854m.sendEmptyMessageAtTime(-1, 0L);
        }
    }

    public d(Resources resources, int i9) {
        this(new GifInfoHandle(resources.openRawResourceFd(i9)));
        List<String> list = g.f20870a;
        TypedValue typedValue = new TypedValue();
        resources.getValue(i9, typedValue, true);
        int i10 = typedValue.density;
        if (i10 == 0) {
            i10 = Opcodes.IF_ICMPNE;
        } else if (i10 == 65535) {
            i10 = 0;
        }
        int i11 = resources.getDisplayMetrics().densityDpi;
        float f6 = (i10 <= 0 || i11 <= 0) ? 1.0f : i11 / i10;
        this.f20859r = (int) (this.f20849g.e() * f6);
        this.f20858q = (int) (this.f20849g.j() * f6);
    }

    public final boolean a() {
        return this.f20849g.l();
    }

    public final void b() {
        this.f20844b = false;
        this.f20854m.removeMessages(-1);
        this.f20849g.n();
        this.f20848f.recycle();
    }

    public final void c() {
        this.f20849g.u();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekBackward() {
        return this.f20849g.h() > 1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean canSeekForward() {
        return this.f20849g.h() > 1;
    }

    public final void d(long j) {
        i iVar = this.f20854m;
        if (this.f20853l) {
            this.f20845c = 0L;
            iVar.sendEmptyMessageAtTime(-1, 0L);
            return;
        }
        ScheduledFuture<?> scheduledFuture = this.f20857p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        iVar.removeMessages(-1);
        this.f20857p = this.f20843a.schedule(this.f20855n, Math.max(j, 0L), TimeUnit.MILLISECONDS);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z8;
        PorterDuffColorFilter porterDuffColorFilter = this.j;
        Paint paint = this.f20847e;
        if (porterDuffColorFilter == null || paint.getColorFilter() != null) {
            z8 = false;
        } else {
            paint.setColorFilter(this.j);
            z8 = true;
        }
        canvas.drawBitmap(this.f20848f, this.f20856o, this.f20846d, paint);
        if (z8) {
            paint.setColorFilter(null);
        }
    }

    public final PorterDuffColorFilter e(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f20847e.getAlpha();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f20847e.getColorFilter();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getCurrentPosition() {
        return this.f20849g.c();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final int getDuration() {
        return this.f20849g.d();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f20859r;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f20858q;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return (!this.f20849g.k() || this.f20847e.getAlpha() < 255) ? -2 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        super.invalidateSelf();
        if (this.f20853l && this.f20844b) {
            long j = this.f20845c;
            if (j != Long.MIN_VALUE) {
                long jMax = Math.max(0L, j - SystemClock.uptimeMillis());
                this.f20845c = Long.MIN_VALUE;
                this.f20843a.remove(this.f20855n);
                this.f20857p = this.f20843a.schedule(this.f20855n, jMax, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final boolean isPlaying() {
        return this.f20844b;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f20844b;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f20851i;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f20846d.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f20851i;
        if (colorStateList == null || (mode = this.f20852k) == null) {
            return false;
        }
        this.j = e(colorStateList, mode);
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void pause() {
        stop();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public final void seekTo(int i9) {
        if (i9 < 0) {
            throw new IllegalArgumentException("Position is not positive");
        }
        this.f20843a.execute(new a(this, i9));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        this.f20847e.setAlpha(i9);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f20847e.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z8) {
        this.f20847e.setDither(z8);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z8) {
        this.f20847e.setFilterBitmap(z8);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f20851i = colorStateList;
        this.j = e(colorStateList, this.f20852k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f20852k = mode;
        this.j = e(this.f20851i, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z8, boolean z9) {
        boolean visible = super.setVisible(z8, z9);
        if (!this.f20853l) {
            if (z8) {
                if (z9) {
                    this.f20843a.execute(new c(this, this));
                }
                if (visible) {
                    start();
                    return visible;
                }
            } else if (visible) {
                stop();
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable, android.widget.MediaController.MediaPlayerControl
    public final void start() {
        synchronized (this) {
            try {
                if (this.f20844b) {
                    return;
                }
                this.f20844b = true;
                d(this.f20849g.q());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        synchronized (this) {
            try {
                if (this.f20844b) {
                    this.f20844b = false;
                    ScheduledFuture<?> scheduledFuture = this.f20857p;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f20854m.removeMessages(-1);
                    this.f20849g.s();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        Locale locale = Locale.ENGLISH;
        GifInfoHandle gifInfoHandle = this.f20849g;
        int iJ = gifInfoHandle.j();
        int iE = gifInfoHandle.e();
        int iH = gifInfoHandle.h();
        int iG = gifInfoHandle.g();
        StringBuilder sbG = H2.a.g(iJ, iE, "GIF: size: ", "x", ", frames: ");
        sbG.append(iH);
        sbG.append(", error: ");
        sbG.append(iG);
        return sbG.toString();
    }

    public d(File file) {
        this(new GifInfoHandle(file.getPath()));
    }

    public d(ContentResolver contentResolver, Uri uri) throws IOException {
        GifInfoHandle gifInfoHandle;
        int i9 = GifInfoHandle.f20830b;
        if ("file".equals(uri.getScheme())) {
            gifInfoHandle = new GifInfoHandle(uri.getPath());
        } else {
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
            if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                gifInfoHandle = new GifInfoHandle(assetFileDescriptorOpenAssetFileDescriptor);
            } else {
                throw new IOException("Could not open AssetFileDescriptor for " + uri);
            }
        }
        this(gifInfoHandle);
    }

    public d(GifInfoHandle gifInfoHandle) {
        this.f20844b = true;
        this.f20845c = Long.MIN_VALUE;
        this.f20846d = new Rect();
        this.f20847e = new Paint(6);
        this.f20850h = new ConcurrentLinkedQueue<>();
        l lVar = new l(this);
        this.f20855n = lVar;
        this.f20853l = true;
        int i9 = f.f20868a;
        this.f20843a = f.a.f20869a;
        this.f20849g = gifInfoHandle;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(gifInfoHandle.j(), gifInfoHandle.e(), Bitmap.Config.ARGB_8888);
        this.f20848f = bitmapCreateBitmap;
        bitmapCreateBitmap.setHasAlpha(true ^ gifInfoHandle.k());
        this.f20856o = new Rect(0, 0, gifInfoHandle.j(), gifInfoHandle.e());
        this.f20854m = new i(this);
        lVar.a();
        this.f20858q = gifInfoHandle.j();
        this.f20859r = gifInfoHandle.e();
    }
}
