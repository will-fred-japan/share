package com.huawei.hms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

/* JADX INFO: loaded from: classes.dex */
public class HMSCursorWrapper extends CursorWrapper implements CrossProcessCursor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractWindowedCursor f14992a;

    public HMSCursorWrapper(Cursor cursor) {
        super(cursor);
        if (cursor == null) {
            throw new IllegalArgumentException("cursor cannot be null");
        }
        if (!(cursor instanceof CursorWrapper)) {
            throw new IllegalArgumentException("cursor:" + cursor + " is not a subclass for CursorWrapper");
        }
        Cursor wrappedCursor = ((CursorWrapper) cursor).getWrappedCursor();
        if (wrappedCursor == null) {
            throw new IllegalArgumentException("getWrappedCursor cannot be null");
        }
        if (wrappedCursor instanceof AbstractWindowedCursor) {
            this.f14992a = (AbstractWindowedCursor) wrappedCursor;
            return;
        }
        throw new IllegalArgumentException("getWrappedCursor:" + wrappedCursor + " is not a subclass for CursorWrapper");
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i9, CursorWindow cursorWindow) {
        this.f14992a.fillWindow(i9, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return this.f14992a.getWindow();
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return this.f14992a;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i9, int i10) {
        return this.f14992a.onMove(i9, i10);
    }

    public void setWindow(CursorWindow cursorWindow) {
        this.f14992a.setWindow(cursorWindow);
    }
}
