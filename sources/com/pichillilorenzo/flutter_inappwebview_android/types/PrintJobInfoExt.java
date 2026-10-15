package com.pichillilorenzo.flutter_inappwebview_android.types;

import android.print.PrintJobInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PrintJobInfoExt {
    private PrintAttributesExt attributes;
    private int copies;
    private long creationTime;
    private String label;
    private Integer numberOfPages;
    private String printerId;
    private int state;

    public static PrintJobInfoExt fromPrintJobInfo(PrintJobInfo printJobInfo) {
        if (printJobInfo == null) {
            return null;
        }
        PrintJobInfoExt printJobInfoExt = new PrintJobInfoExt();
        printJobInfoExt.state = printJobInfo.getState();
        printJobInfoExt.copies = printJobInfo.getCopies();
        printJobInfoExt.numberOfPages = printJobInfo.getPages() != null ? Integer.valueOf(printJobInfo.getPages().length) : null;
        printJobInfoExt.creationTime = printJobInfo.getCreationTime();
        printJobInfoExt.label = printJobInfo.getLabel();
        printJobInfoExt.printerId = printJobInfo.getPrinterId() != null ? printJobInfo.getPrinterId().getLocalId() : null;
        printJobInfoExt.attributes = PrintAttributesExt.fromPrintAttributes(printJobInfo.getAttributes());
        return printJobInfoExt;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("state", Integer.valueOf(this.state));
        map.put("copies", Integer.valueOf(this.copies));
        map.put("numberOfPages", this.numberOfPages);
        map.put("creationTime", Long.valueOf(this.creationTime));
        map.put("label", this.label);
        HashMap map2 = new HashMap();
        map2.put("id", this.printerId);
        map.put("printer", map2);
        PrintAttributesExt printAttributesExt = this.attributes;
        map.put("attributes", printAttributesExt != null ? printAttributesExt.toMap() : null);
        return map;
    }
}
