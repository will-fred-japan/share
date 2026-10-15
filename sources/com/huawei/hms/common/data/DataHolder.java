package com.huawei.hms.common.data;

import W5.e;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;
    public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final Builder BUILDER = new DataHolderBuilderCreator(new String[0], null);

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String[] f14923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f14924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final HashMap<Object, Integer> f14926d;

        /* JADX WARN: Multi-variable type inference failed */
        public DataHolder build(int i9) {
            return new DataHolder(this, i9, (Bundle) null);
        }

        public Builder setDataForContentValuesHashMap(HashMap<String, Object> map) {
            int iIntValue;
            boolean z8;
            Object obj;
            Preconditions.checkNotNull(map, "contentValuesHashMap cannot be null");
            String str = this.f14925c;
            if (str == null || (obj = map.get(str)) == null) {
                iIntValue = 0;
                z8 = false;
            } else {
                Integer num = this.f14926d.get(obj);
                if (num != null) {
                    iIntValue = num.intValue();
                    z8 = true;
                } else {
                    this.f14926d.put(obj, Integer.valueOf(this.f14924b.size()));
                    iIntValue = 0;
                    z8 = false;
                }
            }
            if (!z8) {
                this.f14924b.add(map);
                return this;
            }
            this.f14924b.remove(iIntValue);
            this.f14924b.add(iIntValue, map);
            return this;
        }

        public Builder withRow(ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
            HashMap<String, Object> map = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            return setDataForContentValuesHashMap(map);
        }

        private Builder(String[] strArr, String str) {
            Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.f14923a = strArr;
            this.f14924b = new ArrayList<>();
            this.f14925c = str;
            this.f14926d = new HashMap<>();
        }

        public DataHolder build(int i9, Bundle bundle) {
            return new DataHolder(this, i9, bundle, -1);
        }

        public Builder(String[] strArr, String str, DataHolderBuilderCreator dataHolderBuilderCreator) {
            this(strArr, null);
        }
    }

    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null);
    }

    private void checkAvailable(String str, int i9) {
        String strL;
        Bundle bundle = this.columnsBundle;
        if (bundle == null || !bundle.containsKey(str)) {
            strL = e.l("cannot find column: ", str);
        } else if (isClosed()) {
            strL = "buffer has been closed";
        } else {
            strL = (i9 < 0 || i9 >= this.dataCount) ? e.i(i9, "row is out of index:") : "";
        }
        Preconditions.checkArgument(strL.isEmpty(), strL);
    }

    public static DataHolder empty(int i9) {
        return new DataHolder(BUILDER, i9, (Bundle) null);
    }

    private static CursorWindow[] getCursorWindows(HMSCursorWrapper hMSCursorWrapper) {
        int numRows;
        ArrayList arrayList = new ArrayList();
        try {
            int count = hMSCursorWrapper.getCount();
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                numRows = 0;
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
                arrayList.add(window);
                numRows = window.getNumRows();
            }
            arrayList.addAll(iterCursorWrapper(hMSCursorWrapper, numRows, count));
            CursorWindow[] cursorWindowArr = (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
            hMSCursorWrapper.close();
            return cursorWindowArr;
        } catch (Throwable th) {
            try {
                HMSLog.e(TAG, "fail to getCursorWindows: " + th.getMessage());
                return new CursorWindow[0];
            } finally {
                hMSCursorWrapper.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x006d A[Catch: RuntimeException -> 0x0098, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0098, blocks: (B:4:0x001c, B:6:0x0022, B:12:0x0048, B:13:0x0050, B:15:0x0057, B:18:0x0068, B:20:0x006d), top: B:31:0x001c }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00a3 A[LOOP:1: B:24:0x009d->B:26:0x00a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x006d, please report this as an issue */
    private static ArrayList<CursorWindow> iterCursorWindow(Builder builder, int i9, List list) {
        CursorWindow cursorWindow;
        Iterator<CursorWindow> it;
        boolean zPutValue;
        int i10;
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        CursorWindow cursorWindow2 = new CursorWindow((String) null);
        cursorWindow2.setNumColumns(builder.f14923a.length);
        arrayList.add(cursorWindow2);
        for (int i11 = 0; i11 < i9; i11++) {
            try {
                if (cursorWindow2.allocRow()) {
                    HashMap map = (HashMap) list.get(i11);
                    zPutValue = true;
                    while (i10 < builder.f14923a.length) {
                    }
                    if (!zPutValue) {
                        HMSLog.d(TAG, "fail to put data for row " + i11);
                        cursorWindow2.freeLastRow();
                        CursorWindow cursorWindow3 = new CursorWindow((String) null);
                        cursorWindow3.setStartPosition(i11);
                        cursorWindow3.setNumColumns(builder.f14923a.length);
                        arrayList.add(cursorWindow3);
                        break;
                        break;
                    }
                    continue;
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().close();
                    }
                    HMSLog.w(TAG, "iter CursorWindow failed, RuntimeException occured.");
                    cursorWindow2 = cursorWindow;
                } else {
                    HMSLog.d(TAG, "Failed to allocate a row");
                    cursorWindow = new CursorWindow((String) null);
                    try {
                        cursorWindow.setStartPosition(i11);
                        cursorWindow.setNumColumns(builder.f14923a.length);
                        if (!cursorWindow.allocRow()) {
                            HMSLog.e(TAG, "Failed to retry to allocate a row");
                            break;
                        }
                        arrayList.add(cursorWindow);
                        cursorWindow2 = cursorWindow;
                        HashMap map2 = (HashMap) list.get(i11);
                        zPutValue = true;
                        for (i10 = 0; i10 < builder.f14923a.length && (zPutValue = putValue(cursorWindow2, map2.get(builder.f14923a[i10]), i11, i10)); i10++) {
                        }
                        if (!zPutValue) {
                            HMSLog.d(TAG, "fail to put data for row " + i11);
                            cursorWindow2.freeLastRow();
                            CursorWindow cursorWindow4 = new CursorWindow((String) null);
                            cursorWindow4.setStartPosition(i11);
                            cursorWindow4.setNumColumns(builder.f14923a.length);
                            arrayList.add(cursorWindow4);
                            break;
                        }
                        continue;
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                            it.next().close();
                        }
                        HMSLog.w(TAG, "iter CursorWindow failed, RuntimeException occured.");
                        cursorWindow2 = cursorWindow;
                    } catch (RuntimeException unused) {
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                            it.next().close();
                        }
                        HMSLog.w(TAG, "iter CursorWindow failed, RuntimeException occured.");
                        cursorWindow2 = cursorWindow;
                    }
                }
            } catch (RuntimeException unused2) {
                cursorWindow = cursorWindow2;
            }
        }
        return arrayList;
    }

    private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper hMSCursorWrapper, int i9, int i10) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        while (i9 < i10 && hMSCursorWrapper.moveToPosition(i9)) {
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null) {
                window = new CursorWindow((String) null);
                window.setStartPosition(i9);
                hMSCursorWrapper.fillWindow(i9, window);
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow(null);
            }
            if (window.getNumRows() == 0) {
                break;
            }
            arrayList.add(window);
            i9 = window.getNumRows() + window.getStartPosition();
        }
        return arrayList;
    }

    private static boolean putValue(CursorWindow cursorWindow, Object obj, int i9, int i10) {
        if (obj == null) {
            return cursorWindow.putNull(i9, i10);
        }
        if (obj instanceof Boolean) {
            return cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1L : 0L, i9, i10);
        }
        if (obj instanceof Integer) {
            return cursorWindow.putLong(((Integer) obj).intValue(), i9, i10);
        }
        if (obj instanceof Long) {
            return cursorWindow.putLong(((Long) obj).longValue(), i9, i10);
        }
        if (obj instanceof Float) {
            return cursorWindow.putDouble(((Float) obj).floatValue(), i9, i10);
        }
        if (obj instanceof Double) {
            return cursorWindow.putDouble(((Double) obj).doubleValue(), i9, i10);
        }
        if (obj instanceof String) {
            return cursorWindow.putString((String) obj, i9, i10);
        }
        if (obj instanceof byte[]) {
            return cursorWindow.putBlob((byte[]) obj, i9, i10);
        }
        throw new IllegalArgumentException(e.k(obj, "unsupported type for column: "));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (!this.mClosed) {
                for (CursorWindow cursorWindow : this.cursorWindows) {
                    cursorWindow.close();
                }
                this.mClosed = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new Bundle();
        String[] strArr = this.columns;
        int i9 = 0;
        if (strArr == null || strArr.length == 0) {
            this.dataCount = 0;
            return;
        }
        int i10 = 0;
        while (true) {
            String[] strArr2 = this.columns;
            if (i10 >= strArr2.length) {
                break;
            }
            this.columnsBundle.putInt(strArr2[i10], i10);
            i10++;
        }
        CursorWindow[] cursorWindowArr = this.cursorWindows;
        if (cursorWindowArr == null || cursorWindowArr.length == 0) {
            this.dataCount = 0;
            return;
        }
        this.perCursorCounts = new int[cursorWindowArr.length];
        int startPosition = 0;
        while (true) {
            CursorWindow[] cursorWindowArr2 = this.cursorWindows;
            if (i9 >= cursorWindowArr2.length) {
                this.dataCount = startPosition;
                return;
            } else {
                this.perCursorCounts[i9] = startPosition;
                startPosition = cursorWindowArr2[i9].getStartPosition() + this.cursorWindows[i9].getNumRows();
                i9++;
            }
        }
    }

    public final void copyToBuffer(String str, int i9, int i10, CharArrayBuffer charArrayBuffer) {
        checkAvailable(str, i9);
        this.cursorWindows[i10].copyStringToBuffer(i9, this.columnsBundle.getInt(str), charArrayBuffer);
    }

    public final void finalize() throws Throwable {
        if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
            close();
        }
        super.finalize();
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final Object getValue(String str, int i9, int i10, String str2) {
        str2.getClass();
        switch (str2) {
            case "type_float":
                checkAvailable(str, i9);
                return Float.valueOf(this.cursorWindows[i10].getFloat(i9, this.columnsBundle.getInt(str)));
            case "type_boolean":
                checkAvailable(str, i9);
                return Boolean.valueOf(this.cursorWindows[i10].getLong(i9, this.columnsBundle.getInt(str)) == 1);
            case "type_int":
                checkAvailable(str, i9);
                return Integer.valueOf(this.cursorWindows[i10].getInt(i9, this.columnsBundle.getInt(str)));
            case "type_double":
                checkAvailable(str, i9);
                return Double.valueOf(this.cursorWindows[i10].getDouble(i9, this.columnsBundle.getInt(str)));
            case "type_long":
                checkAvailable(str, i9);
                return Long.valueOf(this.cursorWindows[i10].getLong(i9, this.columnsBundle.getInt(str)));
            case "type_string":
                checkAvailable(str, i9);
                return this.cursorWindows[i10].getString(i9, this.columnsBundle.getInt(str));
            case "type_byte_array":
                checkAvailable(str, i9);
                return this.cursorWindows[i10].getBlob(i9, this.columnsBundle.getInt(str));
            default:
                return null;
        }
    }

    public final int getWindowIndex(int i9) {
        int[] iArr;
        int i10 = 0;
        Preconditions.checkArgument(i9 >= 0 || i9 < this.dataCount, "rowIndex is out of index:" + i9);
        while (true) {
            iArr = this.perCursorCounts;
            if (i10 >= iArr.length) {
                break;
            }
            if (i9 < iArr[i10]) {
                i10--;
                break;
            }
            i10++;
        }
        return i10 == iArr.length ? i10 - 1 : i10;
    }

    public final boolean hasColumn(String str) {
        return this.columnsBundle.containsKey(str);
    }

    public final boolean hasNull(String str, int i9, int i10) {
        checkAvailable(str, i9);
        return this.cursorWindows[i10].getType(i9, this.columnsBundle.getInt(str)) == 0;
    }

    public final synchronized boolean isClosed() {
        return this.mClosed;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i9) {
        if (parcel == null) {
            return;
        }
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i9, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.version);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        if ((i9 & 1) != 0) {
            close();
        }
    }

    public DataHolder(int i9, String[] strArr, CursorWindow[] cursorWindowArr, int i10, Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = i9;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i10;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i9, Bundle bundle) {
        Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        Preconditions.checkNotNull(cursorWindowArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i9;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    private static CursorWindow[] getCursorWindows(Builder builder, int i9) {
        if (builder.f14923a.length != 0) {
            if (i9 < 0 || i9 >= builder.f14924b.size()) {
                i9 = builder.f14924b.size();
            }
            ArrayList<CursorWindow> arrayListIterCursorWindow = iterCursorWindow(builder, i9, builder.f14924b.subList(0, i9));
            return (CursorWindow[]) arrayListIterCursorWindow.toArray(new CursorWindow[arrayListIterCursorWindow.size()]);
        }
        return new CursorWindow[0];
    }

    private DataHolder(HMSCursorWrapper hMSCursorWrapper, int i9, Bundle bundle) {
        this(hMSCursorWrapper.getColumnNames(), getCursorWindows(hMSCursorWrapper), i9, bundle);
    }

    public DataHolder(Cursor cursor, int i9, Bundle bundle) {
        this(new HMSCursorWrapper(cursor), i9, bundle);
    }

    private DataHolder(Builder builder, int i9, Bundle bundle) {
        this(builder.f14923a, getCursorWindows(builder, -1), i9, (Bundle) null);
    }

    private DataHolder(Builder builder, int i9, Bundle bundle, int i10) {
        this(builder.f14923a, getCursorWindows(builder, -1), i9, bundle);
    }
}
