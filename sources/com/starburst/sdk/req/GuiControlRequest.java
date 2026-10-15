package com.starburst.sdk.req;

import cn.jpush.android.local.JPushConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GuiControlRequest {
    public static final String IMAGE_TYPE_BASE64 = "base64";
    public static final String IMAGE_TYPE_HTTP = "http";
    public static final String TYPE_NEXT = "next";
    public static final String TYPE_RESET = "reset";
    public static final String TYPE_START = "start";

    @SerializedName("additionalInfo")
    private String additionalInfo;
    private String additionalInstruction;

    @SerializedName("appList")
    private List<GuiAppInfo> appList;

    @SerializedName("device")
    private String device;
    private transient String imageData;
    private transient String imageFormat;
    private transient String imageType;
    private String instruction;

    @SerializedName("maxRound")
    private Integer maxRound;
    private final transient Map<String, Object> parameters = new LinkedHashMap();

    @SerializedName("screenshotUrl")
    private String screenshotUrl;
    private String type;

    private void applyLegacyScreenshot(String str) {
        if (str == null) {
            return;
        }
        if (str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE)) {
            setImage(IMAGE_TYPE_HTTP, null, str);
            return;
        }
        if (!str.startsWith("data:image/")) {
            setImage(IMAGE_TYPE_BASE64, null, str);
            return;
        }
        int iIndexOf = str.indexOf(59, 11);
        int iIndexOf2 = str.indexOf(44);
        String strSubstring = iIndexOf > 11 ? str.substring(11, iIndexOf) : null;
        this.imageType = IMAGE_TYPE_BASE64;
        this.imageFormat = strSubstring;
        this.imageData = iIndexOf2 >= 0 ? str.substring(iIndexOf2 + 1) : str;
        this.screenshotUrl = str;
    }

    private String buildScreenshotUrl(String str, String str2, String str3) {
        if (str3 == null) {
            return null;
        }
        if (!IMAGE_TYPE_BASE64.equals(str) || str3.startsWith("data:image/")) {
            return str3;
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "jpeg";
        }
        return "data:image/" + str2 + ";base64," + str3;
    }

    public static GuiControlRequest create() {
        return new GuiControlRequest();
    }

    public static GuiControlRequest next(String str, String str2) {
        return next(str, str2, null);
    }

    public static GuiControlRequest nextWithImage(String str, String str2, String str3, String str4) {
        return nextWithImage(str, str2, str3, str4, null);
    }

    public static GuiControlRequest reset() {
        GuiControlRequest guiControlRequest = new GuiControlRequest();
        guiControlRequest.setType(TYPE_RESET);
        return guiControlRequest;
    }

    public static GuiControlRequest start(String str, String str2, List<GuiAppInfo> list) {
        GuiControlRequest guiControlRequestStartWithImage = startWithImage(str, IMAGE_TYPE_HTTP, null, str2, list);
        guiControlRequestStartWithImage.applyLegacyScreenshot(str2);
        return guiControlRequestStartWithImage;
    }

    public static GuiControlRequest startWithImage(String str, String str2, String str3, String str4, List<GuiAppInfo> list) {
        GuiControlRequest guiControlRequest = new GuiControlRequest();
        guiControlRequest.setType("start");
        guiControlRequest.setInstruction(str);
        guiControlRequest.setImage(str2, str3, str4);
        guiControlRequest.setAppList(list);
        return guiControlRequest;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public String getAdditionalInstruction() {
        return this.additionalInstruction;
    }

    public List<GuiAppInfo> getAppList() {
        return this.appList;
    }

    public String getDevice() {
        return this.device;
    }

    public String getImageData() {
        return this.imageData;
    }

    public String getImageFormat() {
        return this.imageFormat;
    }

    public String getImageType() {
        return this.imageType;
    }

    public String getInstruction() {
        return this.instruction;
    }

    public Integer getMaxRound() {
        return this.maxRound;
    }

    public Map<String, Object> getParameters() {
        return Collections.unmodifiableMap(this.parameters);
    }

    public String getScreenshotUrl() {
        return this.screenshotUrl;
    }

    public String getType() {
        return this.type;
    }

    public void removeParameter(String str) {
        if (str != null) {
            this.parameters.remove(str);
        }
    }

    public void setAdditionalInfo(String str) {
        this.additionalInfo = str;
    }

    public void setAdditionalInstruction(String str) {
        this.additionalInstruction = str;
    }

    public void setAppList(List<GuiAppInfo> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.appList = list;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setImage(String str, String str2, String str3) {
        this.imageType = str;
        if (IMAGE_TYPE_BASE64.equals(str) && (str2 == null || str2.length() == 0)) {
            str2 = "jpeg";
        }
        this.imageFormat = str2;
        this.imageData = str3;
        this.screenshotUrl = buildScreenshotUrl(str, str2, str3);
    }

    public void setImageData(String str) {
        this.imageData = str;
    }

    public void setImageFormat(String str) {
        this.imageFormat = str;
    }

    public void setImageType(String str) {
        this.imageType = str;
    }

    public void setInstruction(String str) {
        this.instruction = str;
    }

    public void setMaxRound(Integer num) {
        this.maxRound = num;
    }

    public void setParameter(String str, Object obj) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (obj == null) {
            this.parameters.remove(str);
        } else {
            this.parameters.put(str, obj);
        }
    }

    public void setScreenshotUrl(String str) {
        this.screenshotUrl = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public static GuiControlRequest next(String str, String str2, List<GuiAppInfo> list) {
        GuiControlRequest guiControlRequestNextWithImage = nextWithImage(IMAGE_TYPE_HTTP, null, str, str2, list);
        guiControlRequestNextWithImage.applyLegacyScreenshot(str);
        return guiControlRequestNextWithImage;
    }

    public static GuiControlRequest nextWithImage(String str, String str2, String str3, String str4, List<GuiAppInfo> list) {
        GuiControlRequest guiControlRequest = new GuiControlRequest();
        guiControlRequest.setType(TYPE_NEXT);
        guiControlRequest.setImage(str, str2, str3);
        guiControlRequest.setInstruction(str4);
        guiControlRequest.setAppList(list);
        return guiControlRequest;
    }
}
