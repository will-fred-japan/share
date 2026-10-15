package com.starburst.sdk.core.feed.deviceconfig;

import com.starburst.sdk.core.asr.cc;
import com.starburst.sdk.utils.j;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothConfigManager {
    private static final String TAG = "lishunBluetoothConfigParser";
    private static volatile BluetoothConfigManager instance;
    private final DeviceConfig mConfig = new DeviceConfig();

    private BluetoothConfigManager() {
    }

    public static BluetoothConfigManager getInstance() {
        if (instance == null) {
            synchronized (BluetoothConfigManager.class) {
                try {
                    if (instance == null) {
                        instance = new BluetoothConfigManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    private void parseField(int i9, int i10, byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        j.f(TAG, "size = " + dataInputStream.available());
        if (dataInputStream.available() >= i10) {
            processField(i9, i10, dataInputStream);
        } else {
            throw new IOException("Incomplete data for type: 0x" + Integer.toHexString(i9));
        }
    }

    private void parseSingleConfig(int i9, int i10, byte[] bArr) {
        try {
            parseField(i9, i10, bArr);
        } catch (Exception e9) {
            j.f(TAG, "解析配置类型 0x" + Integer.toHexString(i9) + " 失败" + e9);
        }
    }

    private void processField(int i9, int i10, DataInputStream dataInputStream) throws IOException {
        FieldProcessorRegistry.FieldProcessor processor = FieldProcessorRegistry.getProcessor(i9);
        cc.a56("processField", i9, TAG);
        if (processor != null) {
            processor.process(this.mConfig, dataInputStream, i10);
        } else {
            dataInputStream.skipBytes(i10);
        }
    }

    public DeviceConfig getConfig() {
        return this.mConfig;
    }

    public void parseDevConfig(byte[] bArr) throws IOException {
        BluetoothFrame bluetoothFrame = new BluetoothFrameParser().parse(bArr);
        j.f(TAG, "解析配置项数量: " + bluetoothFrame.configCount);
        for (BluetoothFrame.ConfigItem configItem : bluetoothFrame.getConfigItems()) {
            parseSingleConfig(configItem.type, configItem.length, configItem.value);
        }
        this.mConfig.printConfig();
    }
}
