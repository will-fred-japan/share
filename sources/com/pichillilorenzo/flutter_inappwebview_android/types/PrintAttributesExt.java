package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.print.PrintAttributes;
import com.huawei.hms.adapter.internal.CommonCode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PrintAttributesExt {
    private int colorMode;
    private Integer duplex;
    private MarginsExt margins;
    private MediaSizeExt mediaSize;
    private Integer orientation;
    private ResolutionExt resolution;

    public static PrintAttributesExt fromPrintAttributes(PrintAttributes printAttributes) {
        if (printAttributes == null) {
            return null;
        }
        PrintAttributesExt printAttributesExt = new PrintAttributesExt();
        printAttributesExt.colorMode = printAttributes.getColorMode();
        printAttributesExt.duplex = Integer.valueOf(printAttributes.getDuplexMode());
        PrintAttributes.MediaSize mediaSize = printAttributes.getMediaSize();
        if (mediaSize != null) {
            printAttributesExt.mediaSize = MediaSizeExt.fromMediaSize(mediaSize);
            printAttributesExt.orientation = Integer.valueOf(!mediaSize.isPortrait() ? 1 : 0);
        }
        printAttributesExt.resolution = ResolutionExt.fromResolution(printAttributes.getResolution());
        printAttributesExt.margins = MarginsExt.fromMargins(printAttributes.getMinMargins());
        return printAttributesExt;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("colorMode", Integer.valueOf(this.colorMode));
        map.put("duplex", this.duplex);
        map.put("orientation", this.orientation);
        MediaSizeExt mediaSizeExt = this.mediaSize;
        map.put("mediaSize", mediaSizeExt != null ? mediaSizeExt.toMap() : null);
        ResolutionExt resolutionExt = this.resolution;
        map.put(CommonCode.MapKey.HAS_RESOLUTION, resolutionExt != null ? resolutionExt.toMap() : null);
        MarginsExt marginsExt = this.margins;
        map.put("margins", marginsExt != null ? marginsExt.toMap() : null);
        return map;
    }
}
