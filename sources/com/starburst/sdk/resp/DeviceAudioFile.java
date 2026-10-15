package com.starburst.sdk.resp;

/* JADX INFO: loaded from: classes.dex */
public class DeviceAudioFile {
    private int fileChannel;
    private byte[] fileId;
    private String fileName;
    private int fileSize;
    private int fileType;

    public DeviceAudioFile(String str, int i9) {
        this.fileName = str;
        this.fileSize = i9;
    }

    public int getFileChannel() {
        return this.fileChannel;
    }

    public byte[] getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public int getFileType() {
        return this.fileType;
    }

    public void setFileChannel(int i9) {
        this.fileChannel = i9;
    }

    public void setFileId(byte[] bArr) {
        this.fileId = bArr;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(int i9) {
        this.fileSize = i9;
    }

    public void setFileType(int i9) {
        this.fileType = i9;
    }
}
