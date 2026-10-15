package com.vivo.push.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ImageDownTask.java */
/* JADX INFO: loaded from: classes.dex */
public final class r extends AsyncTask<String, Void, List<Bitmap>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f16894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InsideNotificationItem f16895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f16896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f16897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16898e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private NotifyArriveCallbackByUser f16899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.vivo.push.h.z.a f16900g;

    public r(Context context, InsideNotificationItem insideNotificationItem, long j, boolean z8, com.vivo.push.h.ab abVar, NotifyArriveCallbackByUser notifyArriveCallbackByUser) {
        this.f16894a = context;
        this.f16895b = insideNotificationItem;
        this.f16896c = j;
        this.f16897d = z8;
        this.f16900g = abVar;
        this.f16899f = notifyArriveCallbackByUser;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        super.onPostExecute(list2);
        w.c("ImageDownTask", "onPostExecute");
        com.vivo.push.u.b(new s(this, list2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:49:0x008d A[EXC_TOP_SPLITTER, PHI: r5
  0x008d: PHI (r5v5 java.io.InputStream) = (r5v4 java.io.InputStream), (r5v6 java.io.InputStream) binds: [B:26:0x008b, B:31:0x0097] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Bitmap> doInBackground(String... strArr) throws Throwable {
        InputStream inputStream;
        Bitmap bitmapDecodeStream;
        this.f16898e = this.f16895b.getNotifyDisplayStatus();
        InputStream inputStream2 = null;
        if (!this.f16897d) {
            w.d("ImageDownTask", "bitmap is not display by forbid net");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < 2; i9++) {
            String str = strArr[i9];
            w.d("ImageDownTask", "imgUrl=" + str + " i=" + i9);
            if (!TextUtils.isEmpty(str)) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();
                    w.c("ImageDownTask", "code=".concat(String.valueOf(responseCode)));
                    if (responseCode == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            try {
                                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (MalformedURLException unused2) {
                            w.a("ImageDownTask", "MalformedURLException");
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception unused3) {
                                }
                            }
                            bitmapDecodeStream = null;
                        } catch (IOException unused4) {
                            w.a("ImageDownTask", "IOException");
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            bitmapDecodeStream = null;
                        }
                    } else {
                        inputStream = null;
                        bitmapDecodeStream = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                } catch (MalformedURLException unused6) {
                    inputStream = null;
                } catch (IOException unused7) {
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
                arrayList.add(bitmapDecodeStream);
            } else if (i9 == 0) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }
}
