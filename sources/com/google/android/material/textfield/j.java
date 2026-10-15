package com.google.android.material.textfield;

import T.G;
import T.L;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.K;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p056h5.C0598e;

/* JADX INFO: compiled from: EndCompoundLayout.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public final class j extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextInputLayout f13868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f13869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CheckableImageButton f13870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorStateList f13871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f13872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f13873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CheckableImageButton f13874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f13875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13876i;
    public final LinkedHashSet<TextInputLayout.g> j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f13877k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f13878l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13879m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ImageView.ScaleType f13880n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnLongClickListener f13881o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CharSequence f13882p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AppCompatTextView f13883q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f13884r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public EditText f13885s;
    public final AccessibilityManager t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public R3.e f13886u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f13887v;

    /* JADX INFO: compiled from: EndCompoundLayout.java */
    public class a extends com.google.android.material.internal.g {
        public a() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            j.this.b().a();
        }

        @Override // com.google.android.material.internal.g, android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
            j.this.b().b();
        }
    }

    /* JADX INFO: compiled from: EndCompoundLayout.java */
    public class b implements TextInputLayout.f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public final void a(TextInputLayout textInputLayout) {
            j jVar = j.this;
            if (jVar.f13885s == textInputLayout.getEditText()) {
                return;
            }
            EditText editText = jVar.f13885s;
            a aVar = jVar.f13887v;
            if (editText != null) {
                editText.removeTextChangedListener(aVar);
                if (jVar.f13885s.getOnFocusChangeListener() == jVar.b().e()) {
                    jVar.f13885s.setOnFocusChangeListener(null);
                }
            }
            EditText editText2 = textInputLayout.getEditText();
            jVar.f13885s = editText2;
            if (editText2 != null) {
                editText2.addTextChangedListener(aVar);
            }
            jVar.b().m(jVar.f13885s);
            jVar.j(jVar.b());
        }
    }

    /* JADX INFO: compiled from: EndCompoundLayout.java */
    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            AccessibilityManager accessibilityManager;
            j jVar = j.this;
            if (jVar.f13886u == null || (accessibilityManager = jVar.t) == null) {
                return;
            }
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            if (jVar.isAttachedToWindow()) {
                accessibilityManager.addTouchExplorationStateChangeListener(new U.b(jVar.f13886u));
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            AccessibilityManager accessibilityManager;
            j jVar = j.this;
            R3.e eVar = jVar.f13886u;
            if (eVar == null || (accessibilityManager = jVar.t) == null) {
                return;
            }
            accessibilityManager.removeTouchExplorationStateChangeListener(new U.b(eVar));
        }
    }

    /* JADX INFO: compiled from: EndCompoundLayout.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray<k> f13891a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j f13892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f13893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f13894d;

        public d(j jVar, K k7) {
            this.f13892b = jVar;
            TypedArray typedArray = k7.f6420b;
            this.f13893c = typedArray.getResourceId(28, 0);
            this.f13894d = typedArray.getResourceId(52, 0);
        }
    }

    public j(TextInputLayout textInputLayout, K k7) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f13876i = 0;
        this.j = new LinkedHashSet<>();
        this.f13887v = new a();
        b bVar = new b();
        this.t = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f13868a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f13869b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.f13870c = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.f13874g = checkableImageButtonA2;
        this.f13875h = new d(this, k7);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f13883q = appCompatTextView;
        TypedArray typedArray = k7.f6420b;
        if (typedArray.hasValue(38)) {
            this.f13871d = E5.c.b(getContext(), k7, 38);
        }
        if (typedArray.hasValue(39)) {
            this.f13872e = com.google.android.material.internal.l.d(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(k7.b(37));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        checkableImageButtonA.setImportantForAccessibility(2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setFocusable(false);
        if (!typedArray.hasValue(53)) {
            if (typedArray.hasValue(32)) {
                this.f13877k = E5.c.b(getContext(), k7, 32);
            }
            if (typedArray.hasValue(33)) {
                this.f13878l = com.google.android.material.internal.l.d(typedArray.getInt(33, -1), null);
            }
        }
        if (typedArray.hasValue(30)) {
            g(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && checkableImageButtonA2.getContentDescription() != (text = typedArray.getText(27))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(53)) {
            if (typedArray.hasValue(54)) {
                this.f13877k = E5.c.b(getContext(), k7, 54);
            }
            if (typedArray.hasValue(55)) {
                this.f13878l = com.google.android.material.internal.l.d(typedArray.getInt(55, -1), null);
            }
            g(typedArray.getBoolean(53, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(51);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f13879m) {
            this.f13879m = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType scaleTypeB = l.b(typedArray.getInt(31, -1));
            this.f13880n = scaleTypeB;
            checkableImageButtonA2.setScaleType(scaleTypeB);
            checkableImageButtonA.setScaleType(scaleTypeB);
        }
        appCompatTextView.setVisibility(8);
        appCompatTextView.setId(R.id.textinput_suffix_text);
        appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        appCompatTextView.setAccessibilityLiveRegion(1);
        appCompatTextView.setTextAppearance(typedArray.getResourceId(72, 0));
        if (typedArray.hasValue(73)) {
            appCompatTextView.setTextColor(k7.a(73));
        }
        CharSequence text3 = typedArray.getText(71);
        this.f13882p = TextUtils.isEmpty(text3) ? null : text3;
        appCompatTextView.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.f13811p0.add(bVar);
        if (textInputLayout.f13795d != null) {
            bVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new c());
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i9) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i9);
        if (E5.c.d(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final k b() {
        k dVar;
        int i9 = this.f13876i;
        d dVar2 = this.f13875h;
        SparseArray<k> sparseArray = dVar2.f13891a;
        k kVar = sparseArray.get(i9);
        if (kVar != null) {
            return kVar;
        }
        j jVar = dVar2.f13892b;
        if (i9 == -1) {
            dVar = new com.google.android.material.textfield.d(jVar);
        } else if (i9 == 0) {
            dVar = new p(jVar);
        } else if (i9 == 1) {
            dVar = new r(jVar, dVar2.f13894d);
        } else if (i9 == 2) {
            dVar = new com.google.android.material.textfield.c(jVar);
        } else {
            if (i9 != 3) {
                throw new IllegalArgumentException(W5.e.i(i9, "Invalid end icon mode: "));
            }
            dVar = new i(jVar);
        }
        sparseArray.append(i9, dVar);
        return dVar;
    }

    public final int c() {
        int marginStart;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.f13874g;
            marginStart = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            marginStart = 0;
        }
        WeakHashMap<View, L> weakHashMap = G.f4313a;
        return this.f13883q.getPaddingEnd() + getPaddingEnd() + marginStart;
    }

    public final boolean d() {
        return this.f13869b.getVisibility() == 0 && this.f13874g.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f13870c.getVisibility() == 0;
    }

    public final void f(boolean z8) {
        boolean z9;
        boolean zIsActivated;
        boolean z10;
        k kVarB = b();
        boolean zK = kVarB.k();
        CheckableImageButton checkableImageButton = this.f13874g;
        boolean z11 = true;
        if (!zK || (z10 = checkableImageButton.f13440d) == kVarB.l()) {
            z9 = false;
        } else {
            checkableImageButton.setChecked(!z10);
            z9 = true;
        }
        if (!(kVarB instanceof i) || (zIsActivated = checkableImageButton.isActivated()) == kVarB.j()) {
            z11 = z9;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z8 || z11) {
            l.c(this.f13868a, checkableImageButton, this.f13877k);
        }
    }

    public final void g(int i9) {
        if (this.f13876i == i9) {
            return;
        }
        k kVarB = b();
        R3.e eVar = this.f13886u;
        AccessibilityManager accessibilityManager = this.t;
        if (eVar != null && accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(new U.b(eVar));
        }
        this.f13886u = null;
        kVarB.s();
        this.f13876i = i9;
        Iterator<TextInputLayout.g> it = this.j.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        h(i9 != 0);
        k kVarB2 = b();
        int iD = this.f13875h.f13893c;
        if (iD == 0) {
            iD = kVarB2.d();
        }
        Drawable drawableV = iD != 0 ? C0598e.v(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.f13874g;
        checkableImageButton.setImageDrawable(drawableV);
        TextInputLayout textInputLayout = this.f13868a;
        if (drawableV != null) {
            l.a(textInputLayout, checkableImageButton, this.f13877k, this.f13878l);
            l.c(textInputLayout, checkableImageButton, this.f13877k);
        }
        int iC = kVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(kVarB2.k());
        if (!kVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i9);
        }
        kVarB2.r();
        R3.e eVarH = kVarB2.h();
        this.f13886u = eVarH;
        if (eVarH != null && accessibilityManager != null) {
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            if (isAttachedToWindow()) {
                accessibilityManager.addTouchExplorationStateChangeListener(new U.b(this.f13886u));
            }
        }
        View.OnClickListener onClickListenerF = kVarB2.f();
        View.OnLongClickListener onLongClickListener = this.f13881o;
        checkableImageButton.setOnClickListener(onClickListenerF);
        l.d(checkableImageButton, onLongClickListener);
        EditText editText = this.f13885s;
        if (editText != null) {
            kVarB2.m(editText);
            j(kVarB2);
        }
        l.a(textInputLayout, checkableImageButton, this.f13877k, this.f13878l);
        f(true);
    }

    public final void h(boolean z8) {
        if (d() != z8) {
            this.f13874g.setVisibility(z8 ? 0 : 8);
            k();
            m();
            this.f13868a.q();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f13870c;
        checkableImageButton.setImageDrawable(drawable);
        l();
        l.a(this.f13868a, checkableImageButton, this.f13871d, this.f13872e);
    }

    public final void j(k kVar) {
        if (this.f13885s == null) {
            return;
        }
        if (kVar.e() != null) {
            this.f13885s.setOnFocusChangeListener(kVar.e());
        }
        if (kVar.g() != null) {
            this.f13874g.setOnFocusChangeListener(kVar.g());
        }
    }

    public final void k() {
        this.f13869b.setVisibility((this.f13874g.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || ((this.f13882p == null || this.f13884r) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f13870c;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f13868a;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.j.f13916q && textInputLayout.m()) ? 0 : 8);
        k();
        m();
        if (this.f13876i != 0) {
            return;
        }
        textInputLayout.q();
    }

    public final void m() {
        int paddingEnd;
        TextInputLayout textInputLayout = this.f13868a;
        if (textInputLayout.f13795d == null) {
            return;
        }
        if (d() || e()) {
            paddingEnd = 0;
        } else {
            EditText editText = textInputLayout.f13795d;
            WeakHashMap<View, L> weakHashMap = G.f4313a;
            paddingEnd = editText.getPaddingEnd();
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = textInputLayout.f13795d.getPaddingTop();
        int paddingBottom = textInputLayout.f13795d.getPaddingBottom();
        WeakHashMap<View, L> weakHashMap2 = G.f4313a;
        this.f13883q.setPaddingRelative(dimensionPixelSize, paddingTop, paddingEnd, paddingBottom);
    }

    public final void n() {
        AppCompatTextView appCompatTextView = this.f13883q;
        int visibility = appCompatTextView.getVisibility();
        int i9 = (this.f13882p == null || this.f13884r) ? 8 : 0;
        if (visibility != i9) {
            b().p(i9 == 0);
        }
        k();
        appCompatTextView.setVisibility(i9);
        this.f13868a.q();
    }
}
