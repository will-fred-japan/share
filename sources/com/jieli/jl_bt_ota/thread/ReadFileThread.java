package com.jieli.jl_bt_ota.thread;

import G6.b;
import N6.RunnableC0333d;
import android.os.Handler;
import android.os.Looper;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.model.OTAError;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.util.FileUtil;
import com.jieli.jl_bt_ota.util.JL_Log;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ReadFileThread extends Thread {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f16179d = "ReadFileThread";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IActionCallback<byte[]> f16181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f16182c;

    public ReadFileThread(String str, IActionCallback<byte[]> iActionCallback) {
        super(f16179d);
        this.f16182c = new Handler(Looper.getMainLooper());
        this.f16180a = str;
        this.f16181b = iActionCallback;
    }

    public void finalize() throws Throwable {
        super.finalize();
        this.f16182c.removeCallbacksAndMessages(null);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        ?? r8;
        Throwable th;
        FileInputStream fileInputStream;
        FileNotFoundException e9;
        String str = f16179d;
        JL_Log.d(str, str, "file path : " + this.f16180a);
        if (!FileUtil.checkFileExist(this.f16180a)) {
            b(OTAError.buildError(4097, "File path does not exist."));
            return;
        }
        ?? e10 = 0;
        e10 = 0;
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(this.f16180a);
                    try {
                        byte[] bArr = new byte[fileInputStream2.available()];
                        int i9 = fileInputStream2.read(bArr);
                        if (i9 >= 0) {
                            byte[] bArr2 = new byte[i9];
                            System.arraycopy(bArr, 0, bArr2, 0, i9);
                            b(bArr2);
                        } else {
                            b(OTAError.buildError(ErrorCode.SUB_ERR_DATA_NOT_FOUND));
                        }
                        fileInputStream2.close();
                    } catch (FileNotFoundException e11) {
                        e9 = e11;
                        fileInputStream = fileInputStream2;
                        try {
                            e9.printStackTrace();
                            BaseError baseErrorBuildError = OTAError.buildError(ErrorCode.SUB_ERR_FILE_NOT_FOUND);
                            b(baseErrorBuildError);
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                e10 = baseErrorBuildError;
                            }
                        } catch (Throwable th2) {
                            FileInputStream fileInputStream3 = fileInputStream;
                            th = th2;
                            e10 = fileInputStream3;
                            Throwable th3 = th;
                            r8 = e10;
                            th = th3;
                            if (r8 != 0) {
                                throw th;
                            }
                            try {
                                r8.close();
                                throw th;
                            } catch (IOException e12) {
                                e12.printStackTrace();
                                throw th;
                            }
                        }
                    } catch (IOException e13) {
                        e = e13;
                        e10 = fileInputStream2;
                        e.printStackTrace();
                        b(OTAError.buildError(ErrorCode.SUB_ERR_IO_EXCEPTION, e.getMessage()));
                        if (e10 != 0) {
                            e10.close();
                            e10 = e10;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        r8 = fileInputStream2;
                        if (r8 != 0) {
                            throw th;
                        }
                        r8.close();
                        throw th;
                    }
                } catch (IOException e14) {
                    e10 = e14;
                    e10.printStackTrace();
                }
            } catch (FileNotFoundException e15) {
                fileInputStream = null;
                e9 = e15;
            } catch (IOException e16) {
                e = e16;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(byte[] bArr) {
        IActionCallback<byte[]> iActionCallback = this.f16181b;
        if (iActionCallback != null) {
            iActionCallback.onSuccess(bArr);
        }
    }

    private void b(byte[] bArr) {
        this.f16182c.post(new b(10, this, bArr));
    }

    private void b(BaseError baseError) {
        if (baseError == null) {
            return;
        }
        this.f16182c.post(new RunnableC0333d(3, this, baseError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BaseError baseError) {
        IActionCallback<byte[]> iActionCallback = this.f16181b;
        if (iActionCallback != null) {
            iActionCallback.onError(baseError);
        }
    }
}
