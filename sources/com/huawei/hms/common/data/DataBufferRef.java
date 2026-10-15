package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class DataBufferRef {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14922a;
    protected final DataHolder mDataHolder;
    protected int mDataRow;

    public DataBufferRef(DataHolder dataHolder, int i9) {
        Preconditions.checkNotNull(dataHolder, "dataHolder cannot be null");
        this.mDataHolder = dataHolder;
        getWindowIndex(i9);
    }

    public void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.copyToBuffer(str, this.mDataRow, this.f14922a, charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (dataBufferRef.mDataRow == this.mDataRow && dataBufferRef.f14922a == this.f14922a && dataBufferRef.mDataHolder == this.mDataHolder) {
                return true;
            }
        }
        return false;
    }

    public boolean getBoolean(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f14922a, DataHolder.TYPE_BOOLEAN);
        if (value != null) {
            return ((Boolean) value).booleanValue();
        }
        return false;
    }

    public byte[] getByteArray(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f14922a, DataHolder.TYPE_BYTE_ARRAY);
        if (value != null) {
            return (byte[]) value;
        }
        return null;
    }

    public int getDataRow() {
        return this.mDataRow;
    }

    public double getDouble(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f14922a, DataHolder.TYPE_DOUBLE);
        if (value != null) {
            return ((Double) value).doubleValue();
        }
        return -1.0d;
    }

    public float getFloat(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f14922a, DataHolder.TYPE_FLOAT);
        if (value != null) {
            return ((Float) value).floatValue();
        }
        return -1.0f;
    }

    public int getInteger(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f14922a, DataHolder.TYPE_INT);
        if (value != null) {
            return ((Integer) value).intValue();
        }
        return -1;
    }

    public long getLong(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f14922a, DataHolder.TYPE_LONG);
        if (value != null) {
            return ((Long) value).longValue();
        }
        return -1L;
    }

    public String getString(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f14922a, DataHolder.TYPE_STRING);
        return value != null ? (String) value : "";
    }

    public final void getWindowIndex(int i9) {
        Preconditions.checkArgument(i9 >= 0 && i9 < this.mDataHolder.getCount(), "rowNum is out of index");
        this.mDataRow = i9;
        this.f14922a = this.mDataHolder.getWindowIndex(i9);
    }

    public boolean hasColumn(String str) {
        return this.mDataHolder.hasColumn(str);
    }

    public boolean hasNull(String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.f14922a);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.f14922a), this.mDataHolder);
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    public Uri parseUri(String str) {
        String str2 = (String) this.mDataHolder.getValue(str, this.mDataRow, this.f14922a, DataHolder.TYPE_STRING);
        if (str2 == null) {
            return null;
        }
        return Uri.parse(str2);
    }
}
