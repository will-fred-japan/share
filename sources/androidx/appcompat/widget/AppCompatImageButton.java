package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import cn.ikaile.ruoshui.client.R;
import p056h5.C0598e;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0492d f6326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0497i f6327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6328c;

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0492d c0492d = this.f6326a;
        if (c0492d != null) {
            c0492d.a();
        }
        C0497i c0497i = this.f6327b;
        if (c0497i != null) {
            c0497i.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0492d c0492d = this.f6326a;
        if (c0492d != null) {
            return c0492d.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0492d c0492d = this.f6326a;
        if (c0492d != null) {
            return c0492d.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        I i9;
        C0497i c0497i = this.f6327b;
        if (c0497i == null || (i9 = c0497i.f6622b) == null) {
            return null;
        }
        return i9.f6415a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        I i9;
        C0497i c0497i = this.f6327b;
        if (c0497i == null || (i9 = c0497i.f6622b) == null) {
            return null;
        }
        return i9.f6416b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(this.f6327b.f6621a.getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0492d c0492d = this.f6326a;
        if (c0492d != null) {
            c0492d.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        C0492d c0492d = this.f6326a;
        if (c0492d != null) {
            c0492d.f(i9);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0497i c0497i = this.f6327b;
        if (c0497i != null) {
            c0497i.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0497i c0497i = this.f6327b;
        if (c0497i != null && drawable != null && !this.f6328c) {
            c0497i.f6623c = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (c0497i != null) {
            c0497i.a();
            if (this.f6328c) {
                return;
            }
            ImageView imageView = c0497i.f6621a;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(c0497i.f6623c);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i9) {
        super.setImageLevel(i9);
        this.f6328c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i9) {
        C0497i c0497i = this.f6327b;
        ImageView imageView = c0497i.f6621a;
        if (i9 != 0) {
            Drawable drawableV = C0598e.v(imageView.getContext(), i9);
            if (drawableV != null) {
                u.a(drawableV);
            }
            imageView.setImageDrawable(drawableV);
        } else {
            imageView.setImageDrawable(null);
        }
        c0497i.a();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0497i c0497i = this.f6327b;
        if (c0497i != null) {
            c0497i.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0492d c0492d = this.f6326a;
        if (c0492d != null) {
            c0492d.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0492d c0492d = this.f6326a;
        if (c0492d != null) {
            c0492d.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0497i c0497i = this.f6327b;
        if (c0497i != null) {
            if (c0497i.f6622b == null) {
                c0497i.f6622b = new I();
            }
            I i9 = c0497i.f6622b;
            i9.f6415a = colorStateList;
            i9.f6418d = true;
            c0497i.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0497i c0497i = this.f6327b;
        if (c0497i != null) {
            if (c0497i.f6622b == null) {
                c0497i.f6622b = new I();
            }
            I i9 = c0497i.f6622b;
            i9.f6416b = mode;
            i9.f6417c = true;
            c0497i.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        H.a(context);
        this.f6328c = false;
        F.a(getContext(), this);
        C0492d c0492d = new C0492d(this);
        this.f6326a = c0492d;
        c0492d.d(attributeSet, i9);
        C0497i c0497i = new C0497i(this);
        this.f6327b = c0497i;
        c0497i.b(attributeSet, i9);
    }
}
