package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import androidx.customview.view.AbsSavedState;
import cn.ikaile.ruoshui.client.R;
import com.alibaba.fastjson.asm.Opcodes;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements p089m.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final e f6467v;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f6468p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6469q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public X.a f6470r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CharSequence f6471s;
    public int t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SearchableInfo f6472u;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6473c;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i9) {
                return new SavedState[i9];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6473c = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f6473c + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            super.writeToParcel(parcel, i9);
            parcel.writeValue(Boolean.valueOf(this.f6473c));
        }
    }

    public static class a {
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        public static void b(SearchAutoComplete searchAutoComplete, int i9) {
            searchAutoComplete.setInputMethodMode(i9);
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f6479a;

        public static void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    static {
        e eVar = null;
        if (Build.VERSION.SDK_INT < 29) {
            e eVar2 = new e();
            eVar2.f6479a = null;
            e.a();
            try {
                AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]).setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]).setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                eVar2.f6479a = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            eVar = eVar2;
        }
        f6467v = eVar;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        super.clearFocus();
        throw null;
    }

    @Override // p089m.b
    public final void e() {
        throw null;
    }

    public int getImeOptions() {
        throw null;
    }

    public int getInputType() {
        throw null;
    }

    public int getMaxWidth() {
        return this.t;
    }

    public CharSequence getQuery() {
        throw null;
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f6471s;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f6472u;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return null;
        }
        return getContext().getText(this.f6472u.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return 0;
    }

    public int getSuggestionRowLayout() {
        return 0;
    }

    public X.a getSuggestionsAdapter() {
        return this.f6470r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(null);
        post(null);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        if (z8) {
            throw null;
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11;
        if (this.f6469q) {
            super.onMeasure(i9, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        if (mode == Integer.MIN_VALUE) {
            int i12 = this.t;
            size = i12 > 0 ? Math.min(i12, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.t;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i11 = this.t) > 0) {
            size = Math.min(i11, size);
        }
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f7147a);
        this.f6469q = savedState.f6473c;
        throw null;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6473c = this.f6469q;
        return savedState;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z8) {
        super.onWindowFocusChanged(z8);
        post(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i9, Rect rect) {
        return false;
    }

    public void setIconified(boolean z8) {
        if (z8) {
            throw null;
        }
        this.f6469q = false;
        throw null;
    }

    public void setIconifiedByDefault(boolean z8) {
        if (this.f6468p == z8) {
            return;
        }
        this.f6468p = z8;
        this.f6469q = z8;
        throw null;
    }

    public void setImeOptions(int i9) {
        throw null;
    }

    public void setInputType(int i9) {
        throw null;
    }

    public void setMaxWidth(int i9) {
        this.t = i9;
        requestLayout();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f6471s = charSequence;
        getQueryHint();
        throw null;
    }

    public void setQueryRefinementEnabled(boolean z8) {
        X.a aVar = this.f6470r;
        if (aVar instanceof E) {
            ((E) aVar).f6401e = z8 ? 2 : 1;
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f6472u = searchableInfo;
        if (searchableInfo != null) {
            searchableInfo.getSuggestThreshold();
            throw null;
        }
        if (searchableInfo != null && searchableInfo.getVoiceSearchEnabled() && !this.f6472u.getVoiceSearchLaunchWebSearch()) {
            this.f6472u.getVoiceSearchLaunchRecognizer();
        }
        this.f6469q = this.f6469q;
        throw null;
    }

    public void setSubmitButtonEnabled(boolean z8) {
        this.f6469q = this.f6469q;
        throw null;
    }

    public void setSuggestionsAdapter(X.a aVar) {
        this.f6470r = aVar;
        throw null;
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6474e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SearchView f6475f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f6476g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a f6477h;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                if (searchAutoComplete.f6476g) {
                    ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                    searchAutoComplete.f6476g = false;
                }
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, 0);
            this.f6477h = new a();
            this.f6474e = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i9 = configuration.screenWidthDp;
            int i10 = configuration.screenHeightDp;
            if (i9 >= 960 && i10 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i9 < 600) {
                return (i9 < 640 || i10 < 480) ? Opcodes.IF_ICMPNE : Opcodes.CHECKCAST;
            }
            return Opcodes.CHECKCAST;
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.f6474e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f6476g) {
                a aVar = this.f6477h;
                removeCallbacks(aVar);
                post(aVar);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z8, int i9, Rect rect) {
            super.onFocusChanged(z8, i9, rect);
            SearchView searchView = this.f6475f;
            searchView.f6469q = searchView.f6469q;
            throw null;
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i9, KeyEvent keyEvent) {
            if (i9 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f6475f.clearFocus();
                        throw null;
                    }
                }
            }
            return super.onKeyPreIme(i9, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z8) {
            super.onWindowFocusChanged(z8);
            if (z8 && this.f6475f.hasFocus() && getVisibility() == 0) {
                this.f6476g = true;
                Context context = getContext();
                e eVar = SearchView.f6467v;
                if (context.getResources().getConfiguration().orientation == 2) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        a.b(this, 1);
                        if (enoughToFilter()) {
                            showDropDown();
                            return;
                        }
                        return;
                    }
                    e eVar2 = SearchView.f6467v;
                    eVar2.getClass();
                    e.a();
                    Method method = eVar2.f6479a;
                    if (method != null) {
                        try {
                            method.invoke(this, Boolean.TRUE);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }

        public void setImeVisibility(boolean z8) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            a aVar = this.f6477h;
            if (!z8) {
                this.f6476g = false;
                removeCallbacks(aVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f6476g = true;
                    return;
                }
                this.f6476g = false;
                removeCallbacks(aVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f6475f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i9) {
            super.setThreshold(i9);
            this.f6474e = i9;
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }
    }

    @Override // p089m.b
    public final void c() {
    }

    public void setAppSearchData(Bundle bundle) {
    }

    public void setOnCloseListener(b bVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
    }

    public void setOnQueryTextListener(c cVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
    }

    public void setOnSuggestionListener(d dVar) {
    }
}
