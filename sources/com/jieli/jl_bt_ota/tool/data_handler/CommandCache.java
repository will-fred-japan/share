package com.jieli.jl_bt_ota.tool.data_handler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.util.CommonUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class CommandCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<String, CommandBase> f16263a = new HashMap<>();

    public static String getCacheCommandKey(BluetoothDevice bluetoothDevice, int i9, int i10) {
        return getCacheCommandKey(bluetoothDevice == null ? "00:00:00:00:00:00" : bluetoothDevice.getAddress(), i9, i10);
    }

    public CommandBase getCommand(BluetoothDevice bluetoothDevice, int i9, int i10) {
        return this.f16263a.get(getCacheCommandKey(bluetoothDevice, i9, i10));
    }

    public void putCommandBase(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
        if (commandBase != null) {
            if (commandBase.getType() == 2 || commandBase.getType() == 3) {
                this.f16263a.put(getCacheCommandKey(bluetoothDevice, commandBase.getId(), commandBase.getOpCodeSn()), commandBase);
            }
        }
    }

    public void release() {
        this.f16263a.clear();
    }

    public void removeCommandBase(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        if (basePacket != null) {
            removeCommandBase(bluetoothDevice, basePacket.getOpCode(), basePacket.getOpCodeSn());
        }
    }

    public void removeCommandBase(BluetoothDevice bluetoothDevice, int i9, int i10) {
        this.f16263a.remove(getCacheCommandKey(bluetoothDevice, i9, i10));
    }

    public static String getCacheCommandKey(String str, int i9, int i10) {
        return CommonUtil.formatString("%s-%s-%s", str, Integer.valueOf(i9), Integer.valueOf(i10));
    }
}
