package com.pichillilorenzo.flutter_inappwebview_android.types;

import H2.a;
import android.print.PrintAttributes;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediaSizeExt {
    private int heightMils;
    private String id;
    private String label;
    private int widthMils;

    public MediaSizeExt(String str, String str2, int i9, int i10) {
        this.id = str;
        this.label = str2;
        this.widthMils = i9;
        this.heightMils = i10;
    }

    public static MediaSizeExt fromMap(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new MediaSizeExt((String) map.get("id"), (String) map.get("label"), ((Integer) map.get("widthMils")).intValue(), ((Integer) map.get("heightMils")).intValue());
    }

    public static MediaSizeExt fromMediaSize(PrintAttributes.MediaSize mediaSize) {
        if (mediaSize == null) {
            return null;
        }
        return new MediaSizeExt(mediaSize.getId(), null, mediaSize.getHeightMils(), mediaSize.getWidthMils());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MediaSizeExt mediaSizeExt = (MediaSizeExt) obj;
            if (this.widthMils != mediaSizeExt.widthMils || this.heightMils != mediaSizeExt.heightMils || !this.id.equals(mediaSizeExt.id)) {
                return false;
            }
            String str = this.label;
            String str2 = mediaSizeExt.label;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int getHeightMils() {
        return this.heightMils;
    }

    public String getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public int getWidthMils() {
        return this.widthMils;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.label;
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.widthMils) * 31) + this.heightMils;
    }

    public void setHeightMils(int i9) {
        this.heightMils = i9;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setWidthMils(int i9) {
        this.widthMils = i9;
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("id", this.id);
        map.put("label", this.label);
        map.put("heightMils", Integer.valueOf(this.heightMils));
        map.put("widthMils", Integer.valueOf(this.widthMils));
        return map;
    }

    public PrintAttributes.MediaSize toMediaSize() {
        return new PrintAttributes.MediaSize(this.id, "Custom", this.widthMils, this.heightMils);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediaSizeExt{id='");
        sb.append(this.id);
        sb.append("', label='");
        sb.append(this.label);
        sb.append("', widthMils=");
        sb.append(this.widthMils);
        sb.append(", heightMils=");
        return a.a(sb, this.heightMils, '}');
    }
}
