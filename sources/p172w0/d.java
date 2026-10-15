package p172w0;

import J.g;
import J.k;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class d extends e implements Animatable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f21971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f21972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public D5.c f21973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<p172w0.c> f21974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f21975f;

    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable drawable) {
            d.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            d.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            d.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    public static class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f21977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AnimatorSet f21978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<Animator> f21979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public p155u.a<Animator, String> f21980d;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public d(Context context) {
        this.f21973d = null;
        this.f21974e = null;
        this.f21975f = new a();
        this.f21972c = context;
        this.f21971b = new b();
    }

    @Override // p172w0.e, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        b bVar = this.f21971b;
        bVar.f21977a.draw(canvas);
        if (bVar.f21978b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.getAlpha() : this.f21971b.f21977a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f21971b.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.getColorFilter() : this.f21971b.f21977a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f21982a != null) {
            return new c(this.f21982a.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f21971b.f21977a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f21971b.f21977a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.getOpacity() : this.f21971b.f21977a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        b bVar;
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            bVar = this.f21971b;
            if (eventType == 1 || (xmlPullParser.getDepth() < depth && eventType == 3)) {
                break;
            }
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayD = k.d(resources, theme, attributeSet, p172w0.a.f21967e);
                    int resourceId = typedArrayD.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f fVar = new f();
                        ThreadLocal<TypedValue> threadLocal = g.f2623a;
                        fVar.f21982a = resources.getDrawable(resourceId, theme);
                        new f.h(fVar.f21982a.getConstantState());
                        fVar.f21987f = false;
                        fVar.setCallback(this.f21975f);
                        f fVar2 = bVar.f21977a;
                        if (fVar2 != null) {
                            fVar2.setCallback(null);
                        }
                        bVar.f21977a = fVar;
                    }
                    typedArrayD.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, p172w0.a.f21968f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f21972c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, resourceId2);
                        animatorLoadAnimator.setTarget(bVar.f21977a.f21983b.f22030b.f22028o.get(string));
                        if (bVar.f21979c == null) {
                            bVar.f21979c = new ArrayList<>();
                            bVar.f21980d = new p155u.a<>();
                        }
                        bVar.f21979c.add(animatorLoadAnimator);
                        bVar.f21980d.put(animatorLoadAnimator, string);
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        if (bVar.f21978b == null) {
            bVar.f21978b = new AnimatorSet();
        }
        bVar.f21978b.playTogether(bVar.f21979c);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.isAutoMirrored() : this.f21971b.f21977a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f21982a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f21971b.f21978b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.isStateful() : this.f21971b.f21977a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f21971b.f21977a.setBounds(rect);
        }
    }

    @Override // p172w0.e, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i9) {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.setLevel(i9) : this.f21971b.f21977a.setLevel(i9);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f21982a;
        return drawable != null ? drawable.setState(iArr) : this.f21971b.f21977a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setAlpha(i9);
        } else {
            this.f21971b.f21977a.setAlpha(i9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z8) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setAutoMirrored(z8);
        } else {
            this.f21971b.f21977a.setAutoMirrored(z8);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f21971b.f21977a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i9) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setTint(i9);
        } else {
            this.f21971b.f21977a.setTint(i9);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        } else {
            this.f21971b.f21977a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            drawable.setTintMode(mode);
        } else {
            this.f21971b.f21977a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z8, boolean z9) {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            return drawable.setVisible(z8, z9);
        }
        this.f21971b.f21977a.setVisible(z8, z9);
        return super.setVisible(z8, z9);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        b bVar = this.f21971b;
        if (bVar.f21978b.isStarted()) {
            return;
        }
        bVar.f21978b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f21982a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f21971b.f21978b.end();
        }
    }

    /* JADX INFO: compiled from: AnimatedVectorDrawableCompat.java */
    public static class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f21981a;

        public c(Drawable.ConstantState constantState) {
            this.f21981a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.f21981a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.f21981a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            d dVar = new d();
            Drawable drawableNewDrawable = this.f21981a.newDrawable();
            dVar.f21982a = drawableNewDrawable;
            drawableNewDrawable.setCallback(dVar.f21975f);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            d dVar = new d();
            Drawable drawableNewDrawable = this.f21981a.newDrawable(resources);
            dVar.f21982a = drawableNewDrawable;
            drawableNewDrawable.setCallback(dVar.f21975f);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            d dVar = new d();
            Drawable drawableNewDrawable = this.f21981a.newDrawable(resources, theme);
            dVar.f21982a = drawableNewDrawable;
            drawableNewDrawable.setCallback(dVar.f21975f);
            return dVar;
        }
    }

    public d() {
        this(null);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
