package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: renamed from: androidx.appcompat.widget.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatDrawableManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0495g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f6610b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C0495g f6611c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public B f6612a;

    /* JADX INFO: renamed from: androidx.appcompat.widget.g$a */
    /* JADX INFO: compiled from: AppCompatDrawableManager.java */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f6613a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f6614b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f6615c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f6616d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f6617e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int[] f6618f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        public static boolean a(int[] iArr, int i9) {
            for (int i10 : iArr) {
                if (i10 == i9) {
                    return true;
                }
            }
            return false;
        }

        public static ColorStateList b(Context context, int i9) {
            int iC = F.c(context, R.attr.colorControlHighlight);
            int iB = F.b(context, R.attr.colorButtonNormal);
            int[] iArr = F.f6408b;
            int[] iArr2 = F.f6410d;
            int iC2 = K.a.c(iC, i9);
            return new ColorStateList(new int[][]{iArr, iArr2, F.f6409c, F.f6412f}, new int[]{iB, iC2, K.a.c(iC, i9), i9});
        }

        public static LayerDrawable c(B b9, Context context, int i9) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i9);
            Drawable drawableC = b9.c(context, R.drawable.abc_star_black_48dp);
            Drawable drawableC2 = b9.c(context, R.drawable.abc_star_half_black_48dp);
            if ((drawableC instanceof BitmapDrawable) && drawableC.getIntrinsicWidth() == dimensionPixelSize && drawableC.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableC;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableC.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableC.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableC2 instanceof BitmapDrawable) && drawableC2.getIntrinsicWidth() == dimensionPixelSize && drawableC2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableC2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableC2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableC2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        public static void e(Drawable drawable, int i9, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = C0495g.f6610b;
            }
            drawableMutate.setColorFilter(C0495g.c(i9, mode));
        }

        public final ColorStateList d(Context context, int i9) {
            if (i9 == R.drawable.abc_edit_text_material) {
                return I.a.b(context, R.color.abc_tint_edittext);
            }
            if (i9 == R.drawable.abc_switch_track_mtrl_alpha) {
                return I.a.b(context, R.color.abc_tint_switch_track);
            }
            if (i9 != R.drawable.abc_switch_thumb_material) {
                if (i9 == R.drawable.abc_btn_default_mtrl_shape) {
                    return b(context, F.c(context, R.attr.colorButtonNormal));
                }
                if (i9 == R.drawable.abc_btn_borderless_material) {
                    return b(context, 0);
                }
                if (i9 == R.drawable.abc_btn_colored_material) {
                    return b(context, F.c(context, R.attr.colorAccent));
                }
                if (i9 == R.drawable.abc_spinner_mtrl_am_alpha || i9 == R.drawable.abc_spinner_textfield_background_material) {
                    return I.a.b(context, R.color.abc_tint_spinner);
                }
                if (a(this.f6614b, i9)) {
                    return F.d(context, R.attr.colorControlNormal);
                }
                if (a(this.f6617e, i9)) {
                    return I.a.b(context, R.color.abc_tint_default);
                }
                if (a(this.f6618f, i9)) {
                    return I.a.b(context, R.color.abc_tint_btn_checkable);
                }
                if (i9 == R.drawable.abc_seekbar_thumb_material) {
                    return I.a.b(context, R.color.abc_tint_seek_thumb);
                }
                return null;
            }
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListD = F.d(context, R.attr.colorSwitchThumbNormal);
            if (colorStateListD == null || !colorStateListD.isStateful()) {
                iArr[0] = F.f6408b;
                iArr2[0] = F.b(context, R.attr.colorSwitchThumbNormal);
                iArr[1] = F.f6411e;
                iArr2[1] = F.c(context, R.attr.colorControlActivated);
                iArr[2] = F.f6412f;
                iArr2[2] = F.c(context, R.attr.colorSwitchThumbNormal);
            } else {
                int[] iArr3 = F.f6408b;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
                iArr[1] = F.f6411e;
                iArr2[1] = F.c(context, R.attr.colorControlActivated);
                iArr[2] = F.f6412f;
                iArr2[2] = colorStateListD.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }
    }

    public static synchronized C0495g a() {
        try {
            if (f6611c == null) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6611c;
    }

    public static synchronized PorterDuffColorFilter c(int i9, PorterDuff.Mode mode) {
        return B.e(i9, mode);
    }

    public static synchronized void d() {
        if (f6611c == null) {
            C0495g c0495g = new C0495g();
            f6611c = c0495g;
            c0495g.f6612a = B.b();
            B b9 = f6611c.f6612a;
            a aVar = new a();
            synchronized (b9) {
                b9.f6381e = aVar;
            }
        }
    }

    public static void e(Drawable drawable, I i9, int[] iArr) {
        PorterDuff.Mode mode = B.f6374f;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z8 = i9.f6418d;
        if (!z8 && !i9.f6417c) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterE = null;
        ColorStateList colorStateList = z8 ? i9.f6415a : null;
        PorterDuff.Mode mode2 = i9.f6417c ? i9.f6416b : B.f6374f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterE = B.e(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterE);
    }

    public final synchronized Drawable b(Context context, int i9) {
        return this.f6612a.c(context, i9);
    }
}
