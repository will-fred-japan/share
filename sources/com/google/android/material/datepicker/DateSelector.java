package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    static void A(final EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        View.OnFocusChangeListener onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.google.android.material.datepicker.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z8) {
                for (EditText editText : editTextArr) {
                    if (editText.hasFocus()) {
                        return;
                    }
                }
                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(InputMethodManager.class);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        };
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(onFocusChangeListener);
        }
        EditText editText2 = editTextArr[0];
        editText2.postDelayed(new D6.a(11, editText2), 100L);
    }

    String f(Context context);

    String g(Context context);

    int h(Context context);

    ArrayList u();

    boolean v();

    View w(LayoutInflater layoutInflater, ViewGroup viewGroup, CalendarConstraints calendarConstraints, u.a aVar);

    ArrayList x();

    S y();

    void z(long j);
}
