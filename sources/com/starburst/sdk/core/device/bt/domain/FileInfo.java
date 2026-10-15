package com.starburst.sdk.core.device.bt.domain;

/* JADX INFO: loaded from: classes.dex */
public class FileInfo {
    private String fileName;
    private long fileSize;
    private long lastModified;
    private String path;

    public FileInfo(String str, long j, String str2, long j8) {
        this.fileName = str;
        this.fileSize = j;
        this.path = str2;
        this.lastModified = j8;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public String getPath() {
        return this.path;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String toString() {
        return "FileInfo{fileName='" + this.fileName + "', path='" + this.path + "', fileSize=" + this.fileSize + ", lastModified=" + this.lastModified + '}';
    }
}
