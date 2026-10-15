package com.google.android.material.chip;

import E5.c;
import E5.d;
import H5.p;
import T.G;
import T.L;
import U.f;
import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.google.android.material.internal.h;
import com.google.android.material.internal.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.WeakHashMap;
import p056h5.C0598e;
import p142s2.j;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements com.google.android.material.chip.a.InterfaceC0157a, p, Checkable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Rect f13158w = new Rect();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int[] f13159x = {R.attr.state_selected};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f13160y = {R.attr.state_checkable};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.google.android.material.chip.a f13161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InsetDrawable f13162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RippleDrawable f13163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View.OnClickListener f13164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f13165i;
    public boolean j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13166k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13167l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13168m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13169n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13170o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13171p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CharSequence f13172q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f13173r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f13174s;
    public final Rect t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RectF f13175u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f13176v;

    public class b extends Y.a {
        public b(Chip chip) {
            super(chip);
        }

        @Override // Y.a
        public final void l(ArrayList arrayList) {
            com.google.android.material.chip.a aVar;
            arrayList.add(0);
            Rect rect = Chip.f13158w;
            Chip chip = Chip.this;
            if (!chip.d() || (aVar = chip.f13161e) == null || !aVar.f13204L || chip.f13164h == null) {
                return;
            }
            arrayList.add(1);
        }

        @Override // Y.a
        public final void o(int i9, f fVar) {
            AccessibilityNodeInfo accessibilityNodeInfo = fVar.f4577a;
            if (i9 != 1) {
                accessibilityNodeInfo.setContentDescription("");
                accessibilityNodeInfo.setBoundsInParent(Chip.f13158w);
                return;
            }
            Chip chip = Chip.this;
            CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = chip.getText();
                accessibilityNodeInfo.setContentDescription(chip.getContext().getString(cn.ikaile.ruoshui.client.R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
            fVar.b(f.a.f4579e);
            accessibilityNodeInfo.setEnabled(chip.isEnabled());
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int resourceId3;
        super(K5.a.a(context, attributeSet, cn.ikaile.ruoshui.client.R.attr.chipStyle, cn.ikaile.ruoshui.client.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, cn.ikaile.ruoshui.client.R.attr.chipStyle);
        this.t = new Rect();
        this.f13175u = new RectF();
        this.f13176v = new a(this);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        com.google.android.material.chip.a aVar = new com.google.android.material.chip.a(context2, attributeSet);
        int[] iArr = p103n5.a.f20593e;
        TypedArray typedArrayD = h.d(aVar.f13227q0, attributeSet, iArr, cn.ikaile.ruoshui.client.R.attr.chipStyle, cn.ikaile.ruoshui.client.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        aVar.f13212Q0 = typedArrayD.hasValue(37);
        Context context3 = aVar.f13227q0;
        ColorStateList colorStateListA = c.a(context3, typedArrayD, 24);
        if (aVar.f13235y != colorStateListA) {
            aVar.f13235y = colorStateListA;
            aVar.onStateChange(aVar.getState());
        }
        ColorStateList colorStateListA2 = c.a(context3, typedArrayD, 11);
        if (aVar.f13237z != colorStateListA2) {
            aVar.f13237z = colorStateListA2;
            aVar.onStateChange(aVar.getState());
        }
        float dimension = typedArrayD.getDimension(19, 0.0f);
        if (aVar.f13183A != dimension) {
            aVar.f13183A = dimension;
            aVar.invalidateSelf();
            aVar.v();
        }
        if (typedArrayD.hasValue(12)) {
            aVar.B(typedArrayD.getDimension(12, 0.0f));
        }
        aVar.G(c.a(context3, typedArrayD, 22));
        aVar.H(typedArrayD.getDimension(23, 0.0f));
        aVar.Q(c.a(context3, typedArrayD, 36));
        String text = typedArrayD.getText(5);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(aVar.f13193F, text);
        com.google.android.material.internal.f fVar = aVar.f13233w0;
        if (!zEquals) {
            aVar.f13193F = text;
            fVar.f13540e = true;
            aVar.invalidateSelf();
            aVar.v();
        }
        d dVar = (!typedArrayD.hasValue(0) || (resourceId3 = typedArrayD.getResourceId(0, 0)) == 0) ? null : new d(context3, resourceId3);
        dVar.f1999k = typedArrayD.getDimension(1, dVar.f1999k);
        fVar.c(dVar, context3);
        int i9 = typedArrayD.getInt(3, 0);
        if (i9 == 1) {
            aVar.f13207N0 = TextUtils.TruncateAt.START;
        } else if (i9 == 2) {
            aVar.f13207N0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i9 == 3) {
            aVar.f13207N0 = TextUtils.TruncateAt.END;
        }
        aVar.F(typedArrayD.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            aVar.F(typedArrayD.getBoolean(15, false));
        }
        aVar.C(c.c(context3, typedArrayD, 14));
        if (typedArrayD.hasValue(17)) {
            aVar.E(c.a(context3, typedArrayD, 17));
        }
        aVar.D(typedArrayD.getDimension(16, -1.0f));
        aVar.N(typedArrayD.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            aVar.N(typedArrayD.getBoolean(26, false));
        }
        aVar.I(c.c(context3, typedArrayD, 25));
        aVar.M(c.a(context3, typedArrayD, 30));
        aVar.K(typedArrayD.getDimension(28, 0.0f));
        aVar.x(typedArrayD.getBoolean(6, false));
        aVar.A(typedArrayD.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            aVar.A(typedArrayD.getBoolean(8, false));
        }
        aVar.y(c.c(context3, typedArrayD, 7));
        if (typedArrayD.hasValue(9)) {
            aVar.z(c.a(context3, typedArrayD, 9));
        }
        aVar.f13217V = (!typedArrayD.hasValue(39) || (resourceId2 = typedArrayD.getResourceId(39, 0)) == 0) ? null : p110o5.b.a(context3, resourceId2);
        aVar.f13218W = (!typedArrayD.hasValue(33) || (resourceId = typedArrayD.getResourceId(33, 0)) == 0) ? null : p110o5.b.a(context3, resourceId);
        float dimension2 = typedArrayD.getDimension(21, 0.0f);
        if (aVar.f13219X != dimension2) {
            aVar.f13219X = dimension2;
            aVar.invalidateSelf();
            aVar.v();
        }
        aVar.P(typedArrayD.getDimension(35, 0.0f));
        aVar.O(typedArrayD.getDimension(34, 0.0f));
        float dimension3 = typedArrayD.getDimension(41, 0.0f);
        if (aVar.f13222l0 != dimension3) {
            aVar.f13222l0 = dimension3;
            aVar.invalidateSelf();
            aVar.v();
        }
        float dimension4 = typedArrayD.getDimension(40, 0.0f);
        if (aVar.f13223m0 != dimension4) {
            aVar.f13223m0 = dimension4;
            aVar.invalidateSelf();
            aVar.v();
        }
        aVar.L(typedArrayD.getDimension(29, 0.0f));
        aVar.J(typedArrayD.getDimension(27, 0.0f));
        float dimension5 = typedArrayD.getDimension(13, 0.0f);
        if (aVar.f13226p0 != dimension5) {
            aVar.f13226p0 = dimension5;
            aVar.invalidateSelf();
            aVar.v();
        }
        aVar.f13210P0 = typedArrayD.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayD.recycle();
        h.a(context2, attributeSet, cn.ikaile.ruoshui.client.R.attr.chipStyle, cn.ikaile.ruoshui.client.R.style.Widget_MaterialComponents_Chip_Action);
        h.b(context2, attributeSet, iArr, cn.ikaile.ruoshui.client.R.attr.chipStyle, cn.ikaile.ruoshui.client.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, cn.ikaile.ruoshui.client.R.attr.chipStyle, cn.ikaile.ruoshui.client.R.style.Widget_MaterialComponents_Chip_Action);
        this.f13169n = typedArrayObtainStyledAttributes.getBoolean(32, false);
        this.f13171p = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (float) Math.ceil(l.a(getContext(), 48))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(aVar);
        aVar.j(getElevation());
        h.a(context2, attributeSet, cn.ikaile.ruoshui.client.R.attr.chipStyle, cn.ikaile.ruoshui.client.R.style.Widget_MaterialComponents_Chip_Action);
        h.b(context2, attributeSet, iArr, cn.ikaile.ruoshui.client.R.attr.chipStyle, cn.ikaile.ruoshui.client.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, cn.ikaile.ruoshui.client.R.attr.chipStyle, cn.ikaile.ruoshui.client.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.f13173r = new b(this);
        e();
        if (!zHasValue) {
            setOutlineProvider(new p153t5.b(this));
        }
        setChecked(this.j);
        setText(aVar.f13193F);
        setEllipsize(aVar.f13207N0);
        h();
        if (!this.f13161e.f13208O0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        g();
        if (this.f13169n) {
            setMinHeight(this.f13171p);
        }
        this.f13170o = getLayoutDirection();
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: t5.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z8) {
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f21476a.f13165i;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z8);
                }
            }
        });
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.f13175u;
        rectF.setEmpty();
        if (d() && this.f13164h != null) {
            com.google.android.material.chip.a aVar = this.f13161e;
            Rect bounds = aVar.getBounds();
            rectF.setEmpty();
            if (aVar.T()) {
                float f6 = aVar.f13226p0 + aVar.f13225o0 + aVar.f13209P + aVar.f13224n0 + aVar.f13223m0;
                if (aVar.getLayoutDirection() == 0) {
                    float f9 = bounds.right;
                    rectF.right = f9;
                    rectF.left = f9 - f6;
                } else {
                    float f10 = bounds.left;
                    rectF.left = f10;
                    rectF.right = f10 + f6;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i9 = (int) closeIconTouchBounds.left;
        int i10 = (int) closeIconTouchBounds.top;
        int i11 = (int) closeIconTouchBounds.right;
        int i12 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.t;
        rect.set(i9, i10, i11, i12);
        return rect;
    }

    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13233w0.f13542g;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z8) {
        if (this.f13167l != z8) {
            this.f13167l = z8;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z8) {
        if (this.f13166k != z8) {
            this.f13166k = z8;
            refreshDrawableState();
        }
    }

    @Override // com.google.android.material.chip.a.InterfaceC0157a
    public final void a() {
        c(this.f13171p);
        requestLayout();
        invalidateOutline();
    }

    public final void c(int i9) {
        this.f13171p = i9;
        if (!this.f13169n) {
            InsetDrawable insetDrawable = this.f13162f;
            if (insetDrawable == null) {
                int[] iArr = F5.a.f2040a;
                f();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f13162f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr2 = F5.a.f2040a;
                    f();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i9 - ((int) this.f13161e.f13183A));
        int iMax2 = Math.max(0, i9 - this.f13161e.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.f13162f;
            if (insetDrawable2 == null) {
                int[] iArr3 = F5.a.f2040a;
                f();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f13162f = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr4 = F5.a.f2040a;
                    f();
                    return;
                }
                return;
            }
        }
        int i10 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i11 = iMax > 0 ? iMax / 2 : 0;
        if (this.f13162f != null) {
            Rect rect = new Rect();
            this.f13162f.getPadding(rect);
            if (rect.top == i11 && rect.bottom == i11 && rect.left == i10 && rect.right == i10) {
                int[] iArr5 = F5.a.f2040a;
                f();
                return;
            }
        }
        if (getMinHeight() != i9) {
            setMinHeight(i9);
        }
        if (getMinWidth() != i9) {
            setMinWidth(i9);
        }
        this.f13162f = new InsetDrawable((Drawable) this.f13161e, i10, i11, i10, i11);
        int[] iArr6 = F5.a.f2040a;
        f();
    }

    public final boolean d() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null) {
            return false;
        }
        Object objB = aVar.f13205M;
        if (objB == null) {
            objB = null;
        } else if (objB instanceof L.a) {
            objB = ((L.a) objB).b();
        }
        return objB != null;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073 A[RETURN] */
    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i9;
        if (!this.f13174s) {
            return super.dispatchHoverEvent(motionEvent);
        }
        b bVar = this.f13173r;
        AccessibilityManager accessibilityManager = bVar.f5189h;
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                float x8 = motionEvent.getX();
                float y8 = motionEvent.getY();
                Chip chip = Chip.this;
                int i10 = (chip.d() && chip.getCloseIconTouchBounds().contains(x8, y8)) ? 1 : 0;
                int i11 = bVar.f5193m;
                if (i11 != i10) {
                    bVar.f5193m = i10;
                    bVar.q(i10, 128);
                    bVar.q(i11, 256);
                }
                if (i10 == Integer.MIN_VALUE) {
                    if (!super.dispatchHoverEvent(motionEvent)) {
                        return false;
                    }
                }
            } else if (action == 10 && (i9 = bVar.f5193m) != Integer.MIN_VALUE) {
                if (i9 != Integer.MIN_VALUE) {
                    bVar.f5193m = Integer.MIN_VALUE;
                    bVar.q(i9, 256);
                }
            } else if (!super.dispatchHoverEvent(motionEvent)) {
                return false;
            }
        } else if (!super.dispatchHoverEvent(motionEvent)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:46:0x0080  */
    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i9;
        Chip chip;
        View.OnClickListener onClickListener;
        if (!this.f13174s) {
            return super.dispatchKeyEvent(keyEvent);
        }
        b bVar = this.f13173r;
        bVar.getClass();
        boolean zM = false;
        int i10 = 0;
        zM = false;
        zM = false;
        zM = false;
        zM = false;
        zM = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i11 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i11 = 33;
                                } else if (keyCode == 21) {
                                    i11 = 17;
                                } else if (keyCode != 22) {
                                    i11 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z8 = false;
                                while (i10 < repeatCount && bVar.m(i11, null)) {
                                    i10++;
                                    z8 = true;
                                }
                                zM = z8;
                            }
                            break;
                        case 23:
                            if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                                i9 = bVar.f5192l;
                                if (i9 != Integer.MIN_VALUE) {
                                    chip = Chip.this;
                                    if (i9 == 0) {
                                        chip.performClick();
                                    } else if (i9 == 1) {
                                        chip.playSoundEffect(0);
                                        onClickListener = chip.f13164h;
                                        if (onClickListener != null) {
                                            onClickListener.onClick(chip);
                                        }
                                        if (chip.f13174s) {
                                            chip.f13173r.q(1, 1);
                                        }
                                    }
                                }
                                zM = true;
                            }
                            break;
                    }
                } else if (keyEvent.hasNoModifiers()) {
                    i9 = bVar.f5192l;
                    if (i9 != Integer.MIN_VALUE) {
                        chip = Chip.this;
                        if (i9 == 0) {
                            chip.performClick();
                        } else if (i9 == 1) {
                            chip.playSoundEffect(0);
                            onClickListener = chip.f13164h;
                            if (onClickListener != null) {
                                onClickListener.onClick(chip);
                            }
                            if (chip.f13174s) {
                                chip.f13173r.q(1, 1);
                            }
                        }
                    }
                    zM = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                zM = bVar.m(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                zM = bVar.m(1, null);
            }
        }
        if (!zM || bVar.f5192l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i9;
        int i10;
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f13161e;
        boolean zW = false;
        if (aVar != null && com.google.android.material.chip.a.u(aVar.f13205M)) {
            com.google.android.material.chip.a aVar2 = this.f13161e;
            ?? IsEnabled = isEnabled();
            if (this.f13168m) {
                i9 = IsEnabled;
                i9 = IsEnabled + 1;
            }
            i9 = IsEnabled;
            int i11 = i9;
            if (this.f13167l) {
                i11 = i9 + 1;
            }
            int i12 = i11;
            if (this.f13166k) {
                i12 = i11 + 1;
            }
            int i13 = i12;
            if (isChecked()) {
                i13 = i12 + 1;
            }
            int[] iArr = new int[i13];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i10 = 1;
            } else {
                i10 = 0;
            }
            if (this.f13168m) {
                iArr[i10] = 16842908;
                i10++;
            }
            if (this.f13167l) {
                iArr[i10] = 16843623;
                i10++;
            }
            if (this.f13166k) {
                iArr[i10] = 16842919;
                i10++;
            }
            if (isChecked()) {
                iArr[i10] = 16842913;
            }
            if (!Arrays.equals(aVar2.f13203K0, iArr)) {
                aVar2.f13203K0 = iArr;
                if (aVar2.T()) {
                    zW = aVar2.w(aVar2.getState(), iArr);
                }
            }
        }
        if (zW) {
            invalidate();
        }
    }

    public final void e() {
        com.google.android.material.chip.a aVar;
        if (!d() || (aVar = this.f13161e) == null || !aVar.f13204L || this.f13164h == null) {
            G.m(this, null);
            this.f13174s = false;
        } else {
            G.m(this, this.f13173r);
            this.f13174s = true;
        }
    }

    public final void f() {
        this.f13163g = new RippleDrawable(F5.a.c(this.f13161e.f13191E), getBackgroundDrawable(), null);
        this.f13161e.getClass();
        RippleDrawable rippleDrawable = this.f13163g;
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        setBackground(rippleDrawable);
        g();
    }

    public final void g() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f13161e) == null) {
            return;
        }
        int iR = (int) (aVar.r() + aVar.f13226p0 + aVar.f13223m0);
        com.google.android.material.chip.a aVar2 = this.f13161e;
        int iQ = (int) (aVar2.q() + aVar2.f13219X + aVar2.f13222l0);
        if (this.f13162f != null) {
            Rect rect = new Rect();
            this.f13162f.getPadding(rect);
            iQ += rect.left;
            iR += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        setPaddingRelative(iQ, paddingTop, iR, paddingBottom);
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f13172q)) {
            return this.f13172q;
        }
        com.google.android.material.chip.a aVar = this.f13161e;
        if (!(aVar != null && aVar.f13213R)) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        if (!(parent instanceof ChipGroup)) {
            return "android.widget.Button";
        }
        ((ChipGroup) parent).getClass();
        throw null;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f13162f;
        return insetDrawable == null ? this.f13161e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13215T;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13216U;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13237z;
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.s());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f13161e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13226p0;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null || (drawable = aVar.f13196H) == 0) {
            return null;
        }
        return drawable instanceof L.a ? ((L.a) drawable).b() : drawable;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13200J;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13198I;
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13183A;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13219X;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13187C;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13189D;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getCloseIcon() {
        Drawable drawable;
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null || (drawable = aVar.f13205M) == 0) {
            return null;
        }
        return drawable instanceof L.a ? ((L.a) drawable).b() : drawable;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13211Q;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13225o0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13209P;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13224n0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.O;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13207N0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f13174s) {
            b bVar = this.f13173r;
            if (bVar.f5192l == 1 || bVar.f5191k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public p110o5.b getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13218W;
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13221Z;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13220Y;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13191E;
        }
        return null;
    }

    public H5.l getShapeAppearanceModel() {
        return this.f13161e.f2420a.f2442a;
    }

    public p110o5.b getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13217V;
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13223m0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            return aVar.f13222l0;
        }
        return 0.0f;
    }

    public final void h() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.f13176v);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.y(this, this.f13161e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i9 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f13159x);
        }
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null && aVar.f13213R) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f13160y);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z8, int i9, Rect rect) {
        super.onFocusChanged(z8, i9, rect);
        if (this.f13174s) {
            b bVar = this.f13173r;
            int i10 = bVar.f5192l;
            if (i10 != Integer.MIN_VALUE) {
                bVar.j(i10);
            }
            if (z8) {
                bVar.m(i9, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i9;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        com.google.android.material.chip.a aVar = this.f13161e;
        int i10 = 0;
        accessibilityNodeInfo.setCheckable(aVar != null && aVar.f13213R);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (!chipGroup.f13446c) {
                i9 = -1;
                break;
            }
            i9 = 0;
            while (true) {
                if (i10 >= chipGroup.getChildCount()) {
                    i9 = -1;
                    break;
                }
                View childAt = chipGroup.getChildAt(i10);
                if ((childAt instanceof Chip) && chipGroup.getChildAt(i10).getVisibility() == 0) {
                    if (((Chip) childAt) == this) {
                        break;
                    } else {
                        i9++;
                    }
                }
                i10++;
            }
            Object tag = getTag(cn.ikaile.ruoshui.client.R.id.row_index_key);
            accessibilityNodeInfo.setCollectionItemInfo(f.g.a(tag instanceof Integer ? ((Integer) tag).intValue() : -1, 1, i9, 1, isChecked()).f4590a);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i9) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i9);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public final void onRtlPropertiesChanged(int i9) {
        super.onRtlPropertiesChanged(i9);
        if (this.f13170o != i9) {
            this.f13170o = i9;
            g();
        }
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z8;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                    }
                } else if (this.f13166k) {
                    if (!zContains) {
                        setCloseIconPressed(false);
                    }
                    z8 = true;
                }
                z8 = false;
            } else {
                if (this.f13166k) {
                    playSoundEffect(0);
                    View.OnClickListener onClickListener = this.f13164h;
                    if (onClickListener != null) {
                        onClickListener.onClick(this);
                    }
                    if (this.f13174s) {
                        this.f13173r.q(1, 1);
                    }
                    z8 = true;
                }
                setCloseIconPressed(false);
            }
            z8 = false;
            setCloseIconPressed(false);
        } else if (zContains) {
            setCloseIconPressed(true);
            z8 = true;
        } else {
            z8 = false;
        }
        return z8 || super.onTouchEvent(motionEvent);
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f13172q = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f13163g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i9) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f13163g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i9) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z8) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.x(z8);
        }
    }

    public void setCheckableResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.x(aVar.f13227q0.getResources().getBoolean(i9));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z8) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null) {
            this.j = z8;
        } else if (aVar.f13213R) {
            super.setChecked(z8);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.y(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z8) {
        setCheckedIconVisible(z8);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i9) {
        setCheckedIconVisible(i9);
    }

    public void setCheckedIconResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.y(C0598e.v(aVar.f13227q0, i9));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.z(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.z(I.a.b(aVar.f13227q0, i9));
        }
    }

    public void setCheckedIconVisible(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.A(aVar.f13227q0.getResources().getBoolean(i9));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null || aVar.f13237z == colorStateList) {
            return;
        }
        aVar.f13237z = colorStateList;
        aVar.onStateChange(aVar.getState());
    }

    public void setChipBackgroundColorResource(int i9) {
        ColorStateList colorStateListB;
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null || aVar.f13237z == (colorStateListB = I.a.b(aVar.f13227q0, i9))) {
            return;
        }
        aVar.f13237z = colorStateListB;
        aVar.onStateChange(aVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.B(f6);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.B(aVar.f13227q0.getResources().getDimension(i9));
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f13161e;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.M0 = new WeakReference<>(null);
            }
            this.f13161e = aVar;
            aVar.f13208O0 = false;
            aVar.M0 = new WeakReference<>(this);
            c(this.f13171p);
        }
    }

    public void setChipEndPadding(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null || aVar.f13226p0 == f6) {
            return;
        }
        aVar.f13226p0 = f6;
        aVar.invalidateSelf();
        aVar.v();
    }

    public void setChipEndPaddingResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            float dimension = aVar.f13227q0.getResources().getDimension(i9);
            if (aVar.f13226p0 != dimension) {
                aVar.f13226p0 = dimension;
                aVar.invalidateSelf();
                aVar.v();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.C(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z8) {
        setChipIconVisible(z8);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i9) {
        setChipIconVisible(i9);
    }

    public void setChipIconResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.C(C0598e.v(aVar.f13227q0, i9));
        }
    }

    public void setChipIconSize(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.D(f6);
        }
    }

    public void setChipIconSizeResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.D(aVar.f13227q0.getResources().getDimension(i9));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.E(colorStateList);
        }
    }

    public void setChipIconTintResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.E(I.a.b(aVar.f13227q0, i9));
        }
    }

    public void setChipIconVisible(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.F(aVar.f13227q0.getResources().getBoolean(i9));
        }
    }

    public void setChipMinHeight(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null || aVar.f13183A == f6) {
            return;
        }
        aVar.f13183A = f6;
        aVar.invalidateSelf();
        aVar.v();
    }

    public void setChipMinHeightResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            float dimension = aVar.f13227q0.getResources().getDimension(i9);
            if (aVar.f13183A != dimension) {
                aVar.f13183A = dimension;
                aVar.invalidateSelf();
                aVar.v();
            }
        }
    }

    public void setChipStartPadding(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null || aVar.f13219X == f6) {
            return;
        }
        aVar.f13219X = f6;
        aVar.invalidateSelf();
        aVar.v();
    }

    public void setChipStartPaddingResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            float dimension = aVar.f13227q0.getResources().getDimension(i9);
            if (aVar.f13219X != dimension) {
                aVar.f13219X = dimension;
                aVar.invalidateSelf();
                aVar.v();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.G(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.G(I.a.b(aVar.f13227q0, i9));
        }
    }

    public void setChipStrokeWidth(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.H(f6);
        }
    }

    public void setChipStrokeWidthResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.H(aVar.f13227q0.getResources().getDimension(i9));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i9) {
        setText(getResources().getString(i9));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.I(drawable);
        }
        e();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null || aVar.f13211Q == charSequence) {
            return;
        }
        R.a aVarC = R.a.c();
        aVarC.getClass();
        R.c.C0047c c0047c = R.c.f3905a;
        aVar.f13211Q = aVarC.d(charSequence);
        aVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z8) {
        setCloseIconVisible(z8);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i9) {
        setCloseIconVisible(i9);
    }

    public void setCloseIconEndPadding(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.J(f6);
        }
    }

    public void setCloseIconEndPaddingResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.J(aVar.f13227q0.getResources().getDimension(i9));
        }
    }

    public void setCloseIconResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.I(C0598e.v(aVar.f13227q0, i9));
        }
        e();
    }

    public void setCloseIconSize(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.K(f6);
        }
    }

    public void setCloseIconSizeResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.K(aVar.f13227q0.getResources().getDimension(i9));
        }
    }

    public void setCloseIconStartPadding(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.L(f6);
        }
    }

    public void setCloseIconStartPaddingResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.L(aVar.f13227q0.getResources().getDimension(i9));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.M(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.M(I.a.b(aVar.f13227q0, i9));
        }
    }

    public void setCloseIconVisible(int i9) {
        setCloseIconVisible(getResources().getBoolean(i9));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i9, int i10, int i11, int i12) {
        if (i9 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i11 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i9, i10, i11, i12);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i9, int i10, int i11, int i12) {
        if (i9 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i11 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i9, i10, i11, i12);
    }

    @Override // android.view.View
    public void setElevation(float f6) {
        super.setElevation(f6);
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.j(f6);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f13161e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.f13207N0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z8) {
        this.f13169n = z8;
        c(this.f13171p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i9) {
        if (i9 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i9);
        }
    }

    public void setHideMotionSpec(p110o5.b bVar) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.f13218W = bVar;
        }
    }

    public void setHideMotionSpecResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.f13218W = p110o5.b.a(aVar.f13227q0, i9);
        }
    }

    public void setIconEndPadding(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.O(f6);
        }
    }

    public void setIconEndPaddingResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.O(aVar.f13227q0.getResources().getDimension(i9));
        }
    }

    public void setIconStartPadding(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.P(f6);
        }
    }

    public void setIconStartPaddingResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.P(aVar.f13227q0.getResources().getDimension(i9));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i9) {
        if (this.f13161e == null) {
            return;
        }
        super.setLayoutDirection(i9);
    }

    @Override // android.widget.TextView
    public void setLines(int i9) {
        if (i9 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i9);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i9) {
        if (i9 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i9);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i9) {
        super.setMaxWidth(i9);
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.f13210P0 = i9;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i9) {
        if (i9 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i9);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f13165i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f13164h = onClickListener;
        e();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.Q(colorStateList);
        }
        this.f13161e.getClass();
        f();
    }

    public void setRippleColorResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.Q(I.a.b(aVar.f13227q0, i9));
            this.f13161e.getClass();
            f();
        }
    }

    @Override // H5.p
    public void setShapeAppearanceModel(H5.l lVar) {
        this.f13161e.setShapeAppearanceModel(lVar);
    }

    public void setShowMotionSpec(p110o5.b bVar) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.f13217V = bVar;
        }
    }

    public void setShowMotionSpecResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.f13217V = p110o5.b.a(aVar.f13227q0, i9);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z8) {
        if (!z8) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z8);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.f13208O0 ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f13161e;
        if (aVar2 == null || TextUtils.equals(aVar2.f13193F, charSequence)) {
            return;
        }
        aVar2.f13193F = charSequence;
        aVar2.f13233w0.f13540e = true;
        aVar2.invalidateSelf();
        aVar2.v();
    }

    public void setTextAppearance(d dVar) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.f13233w0.c(dVar, aVar.f13227q0);
        }
        h();
    }

    public void setTextAppearanceResource(int i9) {
        setTextAppearance(getContext(), i9);
    }

    public void setTextEndPadding(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null || aVar.f13223m0 == f6) {
            return;
        }
        aVar.f13223m0 = f6;
        aVar.invalidateSelf();
        aVar.v();
    }

    public void setTextEndPaddingResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            float dimension = aVar.f13227q0.getResources().getDimension(i9);
            if (aVar.f13223m0 != dimension) {
                aVar.f13223m0 = dimension;
                aVar.invalidateSelf();
                aVar.v();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i9, float f6) {
        super.setTextSize(i9, f6);
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            float fApplyDimension = TypedValue.applyDimension(i9, f6, getResources().getDisplayMetrics());
            com.google.android.material.internal.f fVar = aVar.f13233w0;
            d dVar = fVar.f13542g;
            if (dVar != null) {
                dVar.f1999k = fApplyDimension;
                fVar.f13536a.setTextSize(fApplyDimension);
                aVar.a();
            }
        }
        h();
    }

    public void setTextStartPadding(float f6) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar == null || aVar.f13222l0 == f6) {
            return;
        }
        aVar.f13222l0 = f6;
        aVar.invalidateSelf();
        aVar.v();
    }

    public void setTextStartPaddingResource(int i9) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            float dimension = aVar.f13227q0.getResources().getDimension(i9);
            if (aVar.f13222l0 != dimension) {
                aVar.f13222l0 = dimension;
                aVar.invalidateSelf();
                aVar.v();
            }
        }
    }

    public void setCloseIconVisible(boolean z8) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.N(z8);
        }
        e();
    }

    public void setCheckedIconVisible(boolean z8) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.A(z8);
        }
    }

    public void setChipIconVisible(boolean z8) {
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            aVar.F(z8);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            Context context2 = aVar.f13227q0;
            aVar.f13233w0.c(new d(context2, i9), context2);
        }
        h();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i9) {
        super.setTextAppearance(i9);
        com.google.android.material.chip.a aVar = this.f13161e;
        if (aVar != null) {
            Context context = aVar.f13227q0;
            aVar.f13233w0.c(new d(context, i9), context);
        }
        h();
    }

    public class a extends A0.h {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Chip f13177b;

        public a(Chip chip) {
            super(3);
            this.f13177b = chip;
        }

        @Override // A0.h
        public final void s(Typeface typeface, boolean z8) {
            Chip chip = this.f13177b;
            com.google.android.material.chip.a aVar = chip.f13161e;
            chip.setText(aVar.f13208O0 ? aVar.f13193F : chip.getText());
            chip.requestLayout();
            chip.invalidate();
        }

        @Override // A0.h
        public final void r(int i9) {
        }
    }

    public void setInternalOnCheckedChangeListener(com.google.android.material.internal.d<Chip> dVar) {
    }
}
