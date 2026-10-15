package com.vivo.push.model;

import android.graphics.Bitmap;
import com.vivo.push.i;
import com.vivo.push.util.d;
import com.vivo.push.util.p;
import com.vivo.push.util.w;

/* JADX INFO: loaded from: classes.dex */
public class RemoteNotificationContent {
    private static final String TAG = "RemoteNotificationConte";
    private Bitmap mImage;
    private boolean mIsShowNotification = true;
    private String mTitle = "";
    private String mBody = "";
    private int mBadgeOperateType = -1;
    private int mBadgeNum = -1;
    private int mClickType = -1;
    private String mClickUrl = "";

    public int getBadgeNum() {
        return this.mBadgeNum;
    }

    public int getBadgeOperateType() {
        return this.mBadgeOperateType;
    }

    public String getBody() {
        return this.mBody;
    }

    public int getClickType() {
        return this.mClickType;
    }

    public String getClickUrl() {
        return this.mClickUrl;
    }

    public Bitmap getImage() {
        return this.mImage;
    }

    public boolean getIsShowNotification() {
        return this.mIsShowNotification;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setBadgeNum(int i9) {
        this.mBadgeNum = i9;
    }

    public void setBadgeOperateType(int i9) {
        this.mBadgeOperateType = i9;
    }

    public void setBody(String str) {
        this.mBody = str;
    }

    public void setClickType(int i9) {
        this.mClickType = i9;
    }

    public void setClickUrl(String str) {
        this.mClickUrl = str;
    }

    public int setImage(Bitmap bitmap) {
        if (bitmap == null) {
            w.c(TAG, "setImage bitmap is null");
            return -1;
        }
        p pVarB = i.a().b();
        if (!d.a(bitmap, pVarB != null ? pVarB.g() : 49152)) {
            w.c(TAG, "size is invalid, set failed");
            return -1;
        }
        this.mImage = bitmap;
        w.c(TAG, "setImage bitmap size is valid");
        return 0;
    }

    public void setIsShowNotification(boolean z8) {
        this.mIsShowNotification = z8;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RemoteNotificationContent{mIsShowNotification=");
        sb.append(this.mIsShowNotification);
        sb.append(", mTitle='");
        sb.append(this.mTitle);
        sb.append("', mBody='");
        sb.append(this.mBody);
        sb.append("', mImage=");
        sb.append(this.mImage);
        sb.append(", mBadgeOperateType=");
        sb.append(this.mBadgeOperateType);
        sb.append(", mBadgeNum=");
        sb.append(this.mBadgeNum);
        sb.append(", mClickType=");
        sb.append(this.mClickType);
        sb.append(", mClickUrl='");
        return A.a.j(sb, this.mClickUrl, "'}");
    }
}
