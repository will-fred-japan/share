package com.starburst.sdk.core.feed.deviceconfig;

import com.starburst.sdk.business.b89;
import com.starburst.sdk.common.utils.ByteTools;
import com.starburst.sdk.core.asr.cc;
import com.starburst.sdk.utils.j;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothFrameParser {
    private static final String TAG = "lishunBluetoothFrameParser";

    public BluetoothFrame parse(byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        BluetoothFrame bluetoothFrame = new BluetoothFrame();
        bluetoothFrame.dataType = dataInputStream.readUnsignedByte();
        j.f(TAG, "Data Type: 0x" + Integer.toHexString(bluetoothFrame.dataType));
        bluetoothFrame.configCount = dataInputStream.readUnsignedByte();
        b89.a56(new StringBuilder("Config Count: "), bluetoothFrame.configCount, TAG);
        for (int i9 = 0; i9 < bluetoothFrame.configCount; i9++) {
            int unsignedByte = dataInputStream.readUnsignedByte();
            j.f(TAG, "Config Item Type: 0x" + Integer.toHexString(unsignedByte));
            int unsignedByte2 = dataInputStream.readUnsignedByte();
            cc.a56("Config Item Length: ", unsignedByte2, TAG);
            byte[] bArr2 = new byte[unsignedByte2];
            dataInputStream.readFully(bArr2);
            j.f(TAG, "Processing -> " + ByteTools.byteArrToHex(bArr2));
            bluetoothFrame.configItems.add(new BluetoothFrame.ConfigItem(unsignedByte, unsignedByte2, bArr2));
        }
        return bluetoothFrame;
    }
}
