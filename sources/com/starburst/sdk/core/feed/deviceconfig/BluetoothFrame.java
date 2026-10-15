package com.starburst.sdk.core.feed.deviceconfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothFrame {
    public int configCount;
    public List<ConfigItem> configItems = new ArrayList();
    public int dataType;

    public static class ConfigItem {
        public int length;
        public int type;
        public byte[] value;

        public ConfigItem(int i9, int i10, byte[] bArr) {
            this.type = i9;
            this.length = i10;
            this.value = bArr;
        }
    }

    public List<ConfigItem> getConfigItems() {
        return Collections.unmodifiableList(this.configItems);
    }
}
