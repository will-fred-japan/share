package pl.droidsonroids.gif;

import com.engagelab.privates.common.constants.MTCommonConstants;

/* JADX INFO: compiled from: GifError.java */
/* JADX INFO: loaded from: classes2.dex */
public enum e {
    NO_ERROR(0, "No error"),
    OPEN_FAILED(101, "Failed to open given input"),
    /* JADX INFO: Fake field, exist only in values array */
    READ_FAILED(102, "Failed to read from given input"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_GIF_FILE(103, "Data is not in GIF format"),
    /* JADX INFO: Fake field, exist only in values array */
    NO_SCRN_DSCR(104, "No screen descriptor detected"),
    /* JADX INFO: Fake field, exist only in values array */
    NO_IMAG_DSCR(105, "No image descriptor detected"),
    /* JADX INFO: Fake field, exist only in values array */
    NO_COLOR_MAP(106, "Neither global nor local color map found"),
    /* JADX INFO: Fake field, exist only in values array */
    WRONG_RECORD(107, "Wrong record type detected"),
    /* JADX INFO: Fake field, exist only in values array */
    DATA_TOO_BIG(108, "Number of pixels bigger than width * height"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_ENOUGH_MEM(109, "Failed to allocate required memory"),
    /* JADX INFO: Fake field, exist only in values array */
    CLOSE_FAILED(110, "Failed to close given input"),
    /* JADX INFO: Fake field, exist only in values array */
    NOT_READABLE(111, "Given file was not opened for read"),
    /* JADX INFO: Fake field, exist only in values array */
    IMAGE_DEFECT(112, "Image is defective, decoding aborted"),
    /* JADX INFO: Fake field, exist only in values array */
    EOF_TOO_SOON(113, "Image EOF detected before image complete"),
    /* JADX INFO: Fake field, exist only in values array */
    NO_FRAMES(1000, "No frames found, at least one frame required"),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(1001, "Invalid screen size, dimensions must be positive"),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(1002, "Invalid image size, dimensions must be positive"),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(MTCommonConstants.MainWhat.ON_NETWORK_CONNECTED, "Image size exceeds screen size"),
    /* JADX INFO: Fake field, exist only in values array */
    REWIND_FAILED(1004, "Input source rewind failed, animation stopped"),
    /* JADX INFO: Fake field, exist only in values array */
    INVALID_BYTE_BUFFER(1005, "Invalid and/or indirect byte buffer specified"),
    UNKNOWN(-1, "Unknown error");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20867b;

    e(int i9, String str) {
        this.f20867b = i9;
        this.f20866a = str;
    }
}
