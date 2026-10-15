package com.xiaomi.mipush.sdk;

import com.xiaomi.push.service.module.PushChannelRegion;

/* JADX INFO: loaded from: classes.dex */
public class PushConfiguration {
    private boolean mGeoEnable;
    private boolean mOpenCOSPush;
    private boolean mOpenFCMPush;
    private boolean mOpenFTOSPush;
    private boolean mOpenHmsPush;
    private PushChannelRegion mRegion;

    public static class PushConfigurationBuilder {
        private boolean mGeoEnable;
        private boolean mOpenCOSPush;
        private boolean mOpenFCMPush;
        private boolean mOpenFTOSPush;
        private boolean mOpenHmsPush;
        private PushChannelRegion mRegion;

        public PushConfiguration build() {
            return new PushConfiguration(this);
        }

        public PushConfigurationBuilder openCOSPush(boolean z8) {
            this.mOpenCOSPush = z8;
            return this;
        }

        public PushConfigurationBuilder openFCMPush(boolean z8) {
            this.mOpenFCMPush = z8;
            return this;
        }

        public PushConfigurationBuilder openFTOSPush(boolean z8) {
            this.mOpenFTOSPush = z8;
            return this;
        }

        public PushConfigurationBuilder openHmsPush(boolean z8) {
            this.mOpenHmsPush = z8;
            return this;
        }

        public PushConfigurationBuilder region(PushChannelRegion pushChannelRegion) {
            this.mRegion = pushChannelRegion;
            return this;
        }
    }

    public boolean getOpenCOSPush() {
        return this.mOpenCOSPush;
    }

    public boolean getOpenFCMPush() {
        return this.mOpenFCMPush;
    }

    public boolean getOpenFTOSPush() {
        return this.mOpenFTOSPush;
    }

    public boolean getOpenHmsPush() {
        return this.mOpenHmsPush;
    }

    public PushChannelRegion getRegion() {
        return this.mRegion;
    }

    public void setOpenCOSPush(boolean z8) {
        this.mOpenCOSPush = z8;
    }

    public void setOpenFCMPush(boolean z8) {
        this.mOpenFCMPush = z8;
    }

    public void setOpenFTOSPush(boolean z8) {
        this.mOpenFTOSPush = z8;
    }

    public void setOpenHmsPush(boolean z8) {
        this.mOpenHmsPush = z8;
    }

    public void setRegion(PushChannelRegion pushChannelRegion) {
        this.mRegion = pushChannelRegion;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PushConfiguration{Region:");
        PushChannelRegion pushChannelRegion = this.mRegion;
        if (pushChannelRegion == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append(pushChannelRegion.name());
        }
        stringBuffer.append(",mOpenHmsPush:" + this.mOpenHmsPush);
        stringBuffer.append(",mOpenFCMPush:" + this.mOpenFCMPush);
        stringBuffer.append(",mOpenCOSPush:" + this.mOpenCOSPush);
        stringBuffer.append(",mOpenFTOSPush:" + this.mOpenFTOSPush);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public PushConfiguration() {
        this.mRegion = PushChannelRegion.China;
        this.mOpenHmsPush = false;
        this.mOpenFCMPush = false;
        this.mOpenCOSPush = false;
        this.mOpenFTOSPush = false;
    }

    private PushConfiguration(PushConfigurationBuilder pushConfigurationBuilder) {
        this.mRegion = pushConfigurationBuilder.mRegion == null ? PushChannelRegion.China : pushConfigurationBuilder.mRegion;
        this.mOpenHmsPush = pushConfigurationBuilder.mOpenHmsPush;
        this.mOpenFCMPush = pushConfigurationBuilder.mOpenFCMPush;
        this.mOpenCOSPush = pushConfigurationBuilder.mOpenCOSPush;
        this.mOpenFTOSPush = pushConfigurationBuilder.mOpenFTOSPush;
    }
}
