package androidx.appcompat.widget;

import T.C0416c;
import T.InterfaceC0433u;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import cn.ikaile.ruoshui.client.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements InterfaceC0433u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0492d f6319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0504p f6320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0503o f6321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.core.widget.e f6322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final J.f f6323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f6324f;

    public class a {
        public a() {
        }
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private a getSuperCaller() {
        if (this.f6324f == null) {
            this.f6324f = new a();
        }
        return this.f6324f;
    }

    @Override // T.InterfaceC0433u
    public final C0416c a(C0416c c0416c) {
        return this.f6322d.a(this, c0416c);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0492d c0492d = this.f6319a;
        if (c0492d != null) {
            c0492d.a();
        }
        C0504p c0504p = this.f6320b;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.d.f(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0492d c0492d = this.f6319a;
        if (c0492d != null) {
            return c0492d.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0492d c0492d = this.f6319a;
        if (c0492d != null) {
            return c0492d.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f6320b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f6320b.e();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C0503o c0503o;
        if (Build.VERSION.SDK_INT >= 28 || (c0503o = this.f6321c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = c0503o.f6635b;
        return textClassifier == null ? C0503o.a.a(c0503o.f6634a) : textClassifier;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrG;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f6320b.getClass();
        C0504p.h(editorInfo, inputConnectionOnCreateInputConnection, this);
        A1.b.k1(editorInfo, inputConnectionOnCreateInputConnection, this);
        if (inputConnectionOnCreateInputConnection != null && Build.VERSION.SDK_INT <= 30 && (strArrG = T.G.g(this)) != null) {
            editorInfo.contentMimeTypes = strArrG;
            inputConnectionOnCreateInputConnection = new V.b(inputConnectionOnCreateInputConnection, new R3.e(2, this));
        }
        return this.f6323e.j(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 30 || i9 >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean zA = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && T.G.g(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                zA = C0500l.a(dragEvent, this, activity);
            }
        }
        if (zA) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i9) {
        C0416c.C0053c c0053c;
        C0416c.b bVar;
        int i10;
        C0416c.a aVar;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31 || T.G.g(this) == null || !(i9 == 16908322 || i9 == 16908337)) {
            return super.onTextContextMenuItem(i9);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i11 >= 31) {
                aVar = new C0416c.a(primaryClip, 1);
            } else {
                c0053c = new C0416c.C0053c();
                c0053c.f4407a = primaryClip;
                c0053c.f4408b = 1;
            }
            if (i9 == 16908322) {
                bVar = c0053c;
                bVar = aVar;
                i10 = 0;
            } else {
                bVar = c0053c;
                bVar = aVar;
                i10 = 1;
            }
            bVar.c(i10);
            T.G.i(this, bVar.a());
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0492d c0492d = this.f6319a;
        if (c0492d != null) {
            c0492d.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        C0492d c0492d = this.f6319a;
        if (c0492d != null) {
            c0492d.f(i9);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.f6320b;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0504p c0504p = this.f6320b;
        if (c0504p != null) {
            c0504p.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.d.g(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z8) {
        this.f6323e.k(z8);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f6323e.h(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0492d c0492d = this.f6319a;
        if (c0492d != null) {
            c0492d.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0492d c0492d = this.f6319a;
        if (c0492d != null) {
            c0492d.i(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C0504p c0504p = this.f6320b;
        c0504p.l(colorStateList);
        c0504p.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C0504p c0504p = this.f6320b;
        c0504p.m(mode);
        c0504p.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        C0504p c0504p = this.f6320b;
        if (c0504p != null) {
            c0504p.g(context, i9);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        C0503o c0503o;
        if (Build.VERSION.SDK_INT >= 28 || (c0503o = this.f6321c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c0503o.f6635b = textClassifier;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatEditText(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, R.attr.editTextStyle);
        H.a(context);
        F.a(getContext(), this);
        C0492d c0492d = new C0492d(this);
        this.f6319a = c0492d;
        c0492d.d(attributeSet, R.attr.editTextStyle);
        C0504p c0504p = new C0504p(this);
        this.f6320b = c0504p;
        c0504p.f(attributeSet, R.attr.editTextStyle);
        c0504p.b();
        C0503o c0503o = new C0503o();
        c0503o.f6634a = this;
        this.f6321c = c0503o;
        this.f6322d = new androidx.core.widget.e();
        J.f fVar = new J.f(this);
        this.f6323e = fVar;
        fVar.i(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean zIsFocusable = super.isFocusable();
        boolean zIsClickable = super.isClickable();
        boolean zIsLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener keyListenerH = fVar.h(keyListener);
        if (keyListenerH == keyListener) {
            return;
        }
        super.setKeyListener(keyListenerH);
        super.setRawInputType(inputType);
        super.setFocusable(zIsFocusable);
        super.setClickable(zIsClickable);
        super.setLongClickable(zIsLongClickable);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
