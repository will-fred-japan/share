package com.starburst.sdk.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GuiControlConfig {
    public static final String DEVICE_PHONE = "phone";
    public static final String DEVICE_TABLET = "tablet";
    private String device;
    private final Map<String, Object> extraParams;
    private Integer maxRound;
    private boolean saveBase64RequestEnabled;

    public static class Builder {
        private final GuiControlConfig config = new GuiControlConfig();

        public GuiControlConfig build() {
            return new GuiControlConfig(this.config);
        }

        public Builder device(String str) {
            this.config.setDevice(str);
            return this;
        }

        public Builder extraParam(String str, Object obj) {
            this.config.putExtraParam(str, obj);
            return this;
        }

        public Builder maxRound(Integer num) {
            this.config.setMaxRound(num);
            return this;
        }

        public Builder saveBase64RequestEnabled(boolean z8) {
            this.config.setSaveBase64RequestEnabled(z8);
            return this;
        }
    }

    public GuiControlConfig() {
        this.extraParams = new HashMap();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static GuiControlConfig of(String str, Integer num) {
        return new GuiControlConfig(str, num);
    }

    public String getDevice() {
        return this.device;
    }

    public Map<String, Object> getExtraParams() {
        return Collections.unmodifiableMap(this.extraParams);
    }

    public Integer getMaxRound() {
        return this.maxRound;
    }

    public boolean isSaveBase64RequestEnabled() {
        return this.saveBase64RequestEnabled;
    }

    public void putExtraParam(String str, Object obj) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (obj == null) {
            this.extraParams.remove(str);
        } else {
            this.extraParams.put(str, obj);
        }
    }

    public void removeExtraParam(String str) {
        if (str != null) {
            this.extraParams.remove(str);
        }
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setMaxRound(Integer num) {
        this.maxRound = num;
    }

    public void setSaveBase64RequestEnabled(boolean z8) {
        this.saveBase64RequestEnabled = z8;
    }

    public GuiControlConfig(GuiControlConfig guiControlConfig) {
        HashMap map = new HashMap();
        this.extraParams = map;
        if (guiControlConfig == null) {
            return;
        }
        this.device = guiControlConfig.device;
        this.maxRound = guiControlConfig.maxRound;
        this.saveBase64RequestEnabled = guiControlConfig.saveBase64RequestEnabled;
        map.putAll(guiControlConfig.extraParams);
    }

    public GuiControlConfig(String str, Integer num) {
        this.extraParams = new HashMap();
        this.device = str;
        this.maxRound = num;
    }
}
