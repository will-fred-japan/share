package com.pichillilorenzo.flutter_inappwebview_android.print_job;

import com.huawei.hms.adapter.internal.CommonCode;
import com.pichillilorenzo.flutter_inappwebview_android.ISettings;
import com.pichillilorenzo.flutter_inappwebview_android.types.MediaSizeExt;
import com.pichillilorenzo.flutter_inappwebview_android.types.ResolutionExt;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PrintJobSettings implements ISettings<PrintJobController> {
    public static final String LOG_TAG = "PrintJobSettings";
    public Integer colorMode;
    public Integer duplexMode;
    public Boolean handledByClient = Boolean.FALSE;
    public String jobName;
    public MediaSizeExt mediaSize;
    public Integer orientation;
    public ResolutionExt resolution;

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public /* bridge */ /* synthetic */ ISettings<PrintJobController> parse(Map map) {
        return parse2((Map<String, Object>) map);
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("handledByClient", this.handledByClient);
        map.put("jobName", this.jobName);
        map.put("orientation", this.orientation);
        MediaSizeExt mediaSizeExt = this.mediaSize;
        map.put("mediaSize", mediaSizeExt != null ? mediaSizeExt.toMap() : null);
        map.put("colorMode", this.colorMode);
        map.put("duplexMode", this.duplexMode);
        ResolutionExt resolutionExt = this.resolution;
        map.put(CommonCode.MapKey.HAS_RESOLUTION, resolutionExt != null ? resolutionExt.toMap() : null);
        return map;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    public Map<String, Object> getRealSettings(PrintJobController printJobController) {
        return toMap();
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.ISettings
    /* JADX INFO: renamed from: parse, reason: avoid collision after fix types in other method */
    public ISettings<PrintJobController> parse2(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                key.getClass();
                switch (key) {
                    case "resolution":
                        this.resolution = ResolutionExt.fromMap((Map) value);
                        break;
                    case "duplexMode":
                        this.duplexMode = (Integer) value;
                        break;
                    case "orientation":
                        this.orientation = (Integer) value;
                        break;
                    case "jobName":
                        this.jobName = (String) value;
                        break;
                    case "handledByClient":
                        this.handledByClient = (Boolean) value;
                        break;
                    case "colorMode":
                        this.colorMode = (Integer) value;
                        break;
                    case "mediaSize":
                        this.mediaSize = MediaSizeExt.fromMap((Map) value);
                        break;
                }
            }
        }
        return this;
    }
}
