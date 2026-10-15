package com.starburst.sdk.core.device.bt.http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.starburst.sdk.common.utils.ByteTools;
import com.starburst.sdk.core.AiAgentSdk;
import com.starburst.sdk.utils.j;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HttpUtil {
    private static String downLoadPath = AiAgentSdk.getInstance().getSdkPath() + "alibtsdk/download/";
    private static OnDownloadProgress onDownloadProgress;

    public interface OnDownloadProgress {
        void onProgressChange(int i9);
    }

    public static void CallHttp(final int i9, final HttpRequestBean httpRequestBean, final Handler handler) {
        new Thread(new Runnable() { // from class: com.starburst.sdk.core.device.bt.http.HttpUtil.1
            @Override // java.lang.Runnable
            public void run() {
                String strByteArrToHex;
                String streamToString = "";
                int responseCode = -1;
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(httpRequestBean.getUrl()).openConnection();
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setRequestMethod(httpRequestBean.getMethod());
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    if (!TextUtils.isEmpty(httpRequestBean.getHead())) {
                        JSONObject jSONObject = new JSONObject(httpRequestBean.getHead());
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            httpURLConnection.setRequestProperty(next, jSONObject.getString(next));
                        }
                    }
                    httpURLConnection.setReadTimeout(30000);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (!TextUtils.isEmpty(httpRequestBean.getBody())) {
                        outputStream.write(httpRequestBean.getBody().getBytes());
                    }
                    responseCode = httpURLConnection.getResponseCode();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    streamToString = HttpUtil.readStreamToString(inputStream);
                    j.f("HttpUtil", "请求返回--value：" + streamToString);
                    inputStream.close();
                    outputStream.close();
                } catch (MalformedURLException e9) {
                    j.w("HttpUtil", "请求失败--MalformedURLException--" + e9.getMessage());
                    e9.printStackTrace();
                    responseCode = -1009;
                } catch (IOException e10) {
                    j.w("HttpUtil", "请求失败--IOException--" + e10.getMessage());
                    e10.printStackTrace();
                } catch (JSONException e11) {
                    j.w("HttpUtil", "JSON解析失败--" + e11.getMessage());
                    e11.printStackTrace();
                    responseCode = -1007;
                }
                j.f("HttpUtil", "responseCode--" + responseCode);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(ByteTools.byteArrToHex(ByteTools.little_intToByte(responseCode, 4)));
                if (responseCode == 200) {
                    byte[] bytes = streamToString.getBytes();
                    stringBuffer.append(ByteTools.byteArrToHex(ByteTools.little_intToByte(bytes.length, 2)));
                    strByteArrToHex = ByteTools.byteArrToHex(bytes);
                } else {
                    strByteArrToHex = "00";
                }
                stringBuffer.append(strByteArrToHex);
                j.w("HttpUtil", "请求结果--responseCode-" + responseCode + "--data--" + streamToString);
                Message messageObtain = Message.obtain();
                messageObtain.what = i9;
                messageObtain.obj = stringBuffer.toString();
                messageObtain.arg1 = httpRequestBean.getId();
                messageObtain.arg2 = httpRequestBean.getDataType();
                handler.sendMessage(messageObtain);
            }
        }).start();
    }

    public static void DoDownLoad(final int i9, final HttpRequestBean httpRequestBean, final Handler handler) {
        new Thread(new Runnable() { // from class: com.starburst.sdk.core.device.bt.http.HttpUtil.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                int i10;
                File file = new File(HttpUtil.downLoadPath);
                if (!file.exists()) {
                    boolean zMkdirs = file.mkdirs();
                    StringBuilder sb = new StringBuilder("文件创建");
                    sb.append(zMkdirs ? "成功" : "失败");
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb.append(HttpUtil.downLoadPath);
                    j.w("HttpUtil", sb.toString());
                }
                if (HttpUtil.onDownloadProgress != null) {
                    HttpUtil.onDownloadProgress.onProgressChange(0);
                }
                int iLastIndexOf = httpRequestBean.getUrl().lastIndexOf("/");
                String fileName = httpRequestBean.getFileName();
                if (TextUtils.isEmpty(fileName)) {
                    fileName = httpRequestBean.getUrl().substring(iLastIndexOf + 1, httpRequestBean.getUrl().length());
                } else if (fileName.endsWith("bin") && i9 == 1004) {
                    fileName = fileName.replace("bin", "jpg");
                }
                String str = HttpUtil.downLoadPath + fileName;
                if (i9 == 1004) {
                    HttpUtil.downLoadPath += "js_download/";
                    str = HttpUtil.downLoadPath + fileName;
                }
                File file2 = new File(HttpUtil.downLoadPath);
                if (!file2.exists()) {
                    boolean zMkdirs2 = file2.mkdirs();
                    StringBuilder sb2 = new StringBuilder("文件创建");
                    sb2.append(zMkdirs2 ? "成功" : "失败");
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    sb2.append(HttpUtil.downLoadPath);
                    j.w("HttpUtil", sb2.toString());
                }
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(httpRequestBean.getUrl()).openConnection();
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    int contentLength = httpURLConnection.getContentLength();
                    j.w("HttpUtil", "---下载中---lenth--" + contentLength);
                    FileOutputStream fileOutputStream = new FileOutputStream(str);
                    byte[] bArr = new byte[contentLength];
                    int i11 = 0;
                    while (true) {
                        int i12 = inputStream.read(bArr);
                        if (i12 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i12);
                        i11 += i12;
                        int i13 = (int) ((i11 / contentLength) * 100.0f);
                        if (i13 % 10 == 0) {
                            j.w("HttpUtil", "---下载进度---" + i13);
                        }
                        if (HttpUtil.onDownloadProgress != null) {
                            HttpUtil.onDownloadProgress.onProgressChange(i13);
                        }
                    }
                    j.w("HttpUtil", "---下载完成---" + str);
                    inputStream.close();
                    fileOutputStream.close();
                    fileOutputStream.flush();
                    if (i9 == 1004) {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(new FileInputStream(new File(str)));
                        str = HttpUtil.downLoadPath + httpRequestBean.getFileName();
                        j.w("HttpUtil", "存储地址--" + str);
                        BmpUtil.getInstance().saveRGB565(bitmapDecodeStream, str);
                    }
                    i10 = 3001;
                } catch (IOException e9) {
                    j.w("HttpUtil", "文件读取异常--" + e9.getMessage());
                    e9.printStackTrace();
                    i10 = -3000;
                }
                StringBuffer stringBuffer = new StringBuffer(ByteTools.byteArrToHex(ByteTools.int2Bytes(httpRequestBean.getDataType(), 1)));
                if (i10 == 3001) {
                    stringBuffer.append(ByteTools.byteArrToHex(httpRequestBean.getUrl().getBytes()));
                    stringBuffer.append("00");
                    stringBuffer.append(ByteTools.byteArrToHex(str.getBytes()));
                } else {
                    stringBuffer.append(ByteTools.byteArrToHex(ByteTools.little_intToByte(i10, 4)));
                    stringBuffer.append("00");
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = i9;
                Bundle bundle = new Bundle();
                bundle.putString("reqAck", stringBuffer.toString());
                messageObtain.obj = str + "&&&" + httpRequestBean.getFilePath();
                messageObtain.arg1 = httpRequestBean.getId();
                messageObtain.arg2 = i10;
                messageObtain.setData(bundle);
                handler.sendMessage(messageObtain);
            }
        }).start();
    }

    public static void downloadFile(final String str, final String str2, final String str3) {
        new Thread(new Runnable() { // from class: com.starburst.sdk.core.device.bt.http.HttpUtil.3
            @Override // java.lang.Runnable
            public void run() {
                if (HttpUtil.onDownloadProgress != null) {
                    HttpUtil.onDownloadProgress.onProgressChange(0);
                }
                String str4 = str2;
                File file = new File(str4);
                if (!file.exists()) {
                    file.mkdirs();
                }
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    int contentLength = httpURLConnection.getContentLength();
                    j.w("HttpUtil", "---下载中---lenth--" + contentLength);
                    FileOutputStream fileOutputStream = new FileOutputStream(str4 + str3);
                    byte[] bArr = new byte[contentLength];
                    int i9 = 0;
                    while (true) {
                        int i10 = inputStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i10);
                        i9 += i10;
                        int i11 = (int) ((i9 / contentLength) * 100.0f);
                        if (i11 % 10 == 0) {
                            j.w("HttpUtil", "---下载进度---" + i11);
                        }
                        if (i11 < 100 && HttpUtil.onDownloadProgress != null) {
                            HttpUtil.onDownloadProgress.onProgressChange(i11);
                        }
                    }
                    if (HttpUtil.onDownloadProgress != null) {
                        HttpUtil.onDownloadProgress.onProgressChange(100);
                    }
                    j.w("HttpUtil", "---下载完成---" + str4);
                    inputStream.close();
                    fileOutputStream.close();
                    fileOutputStream.flush();
                } catch (IOException e9) {
                    if (HttpUtil.onDownloadProgress != null) {
                        HttpUtil.onDownloadProgress.onProgressChange(-1);
                    }
                    j.w("HttpUtil", "文件读取异常--" + e9.getMessage());
                    e9.printStackTrace();
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String readStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i9 = inputStream.read(bArr);
            if (i9 == -1) {
                String string = byteArrayOutputStream.toString();
                inputStream.close();
                byteArrayOutputStream.close();
                return string;
            }
            byteArrayOutputStream.write(bArr, 0, i9);
        }
    }

    public static void setOnDownloadProgress(OnDownloadProgress onDownloadProgress2) {
        onDownloadProgress = onDownloadProgress2;
    }
}
