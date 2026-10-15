package com.starburst.sdk.core.device.bt.http;

import H2.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class HttpRequestBean {
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_DOWNLOAD = "FILEDOWNLOAD";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_JS_DELETE = "JS_DELETE";
    public static final String METHOD_JS_DOWNLOAD = "JS_FILEDOWNLOAD";
    public static final String METHOD_JS_GET = "JS_GET";
    public static final String METHOD_JS_HEAD = "JS_HEAD";
    public static final String METHOD_JS_OPTIONS = "JS_OPTIONS";
    public static final String METHOD_JS_PATCH = "JS_PATCH";
    public static final String METHOD_JS_POST = "JS_POST";
    public static final String METHOD_JS_PUT = "JS_PUT";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_PATCH = "PATCH";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    private String body;
    private int dataType;
    private byte[] datas;
    private String fileName;
    private String filePath;
    private String head;
    private int id;
    private String method;
    private String url;

    public String getBody() {
        return this.body;
    }

    public int getDataType() {
        return this.dataType;
    }

    public byte[] getDatas() {
        return this.datas;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getHead() {
        return this.head;
    }

    public int getId() {
        return this.id;
    }

    public String getMethod() {
        return this.method;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setDataType(int i9) {
        this.dataType = i9;
    }

    public void setDatas(byte[] bArr) {
        this.datas = bArr;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setHead(String str) {
        this.head = str;
    }

    public void setId(int i9) {
        this.id = i9;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HttpRequestBean{dataType=");
        sb.append(this.dataType);
        sb.append(", method='");
        sb.append(this.method);
        sb.append("', url='");
        sb.append(this.url);
        sb.append("', head='");
        sb.append(this.head);
        sb.append("', body='");
        sb.append(this.body);
        sb.append("', fileName='");
        sb.append(this.fileName);
        sb.append("', filePath='");
        sb.append(this.filePath);
        sb.append("', datas=");
        sb.append(Arrays.toString(this.datas));
        sb.append(", id=");
        return a.a(sb, this.id, '}');
    }
}
