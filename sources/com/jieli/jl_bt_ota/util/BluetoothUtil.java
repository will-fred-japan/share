package com.jieli.jl_bt_ota.util;

import W5.e;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.engagelab.privates.common.monitor.tcp.TCPTimingCache;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f16321a = "BluetoothUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f16322b = "0123456789ABCDEF".toCharArray();

    private static boolean a(int i9, int i10) {
        return (i9 & i10) == i10;
    }

    public static byte[] addressCovertToByteArray(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(Constants.COLON_SEPARATOR)) {
            String strReplace = str.replace(Constants.COLON_SEPARATOR, "");
            int length = strReplace.length() / 2;
            byte[] bArr = new byte[length];
            if (length == 6) {
                for (int i9 = 0; i9 < length; i9++) {
                    int i10 = i9 * 2;
                    int i11 = i10 + 2;
                    if (i11 <= strReplace.length()) {
                        try {
                            bArr[i9] = (byte) Integer.valueOf(strReplace.substring(i10, i11), 16).intValue();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                            return null;
                        }
                    }
                }
                return bArr;
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean connectDeviceA2dp(Context context, BluetoothA2dp bluetoothA2dp, BluetoothDevice bluetoothDevice) {
        if (bluetoothA2dp != null && bluetoothDevice != null && CommonUtil.checkHasConnectPermission(context)) {
            try {
                Object objInvoke = bluetoothA2dp.getClass().getMethod(TCPTimingCache.P_CONNECT, BluetoothDevice.class).invoke(bluetoothA2dp, bluetoothDevice);
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                return false;
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean connectDeviceHfp(Context context, BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice) {
        if (bluetoothHeadset != null && bluetoothDevice != null && CommonUtil.checkHasConnectPermission(context)) {
            try {
                Method method = bluetoothHeadset.getClass().getMethod(TCPTimingCache.P_CONNECT, BluetoothDevice.class);
                method.setAccessible(true);
                Object objInvoke = method.invoke(bluetoothHeadset, bluetoothDevice);
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                return false;
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean createBond(Context context, BluetoothDevice bluetoothDevice, int i9) {
        if (!CommonUtil.checkHasConnectPermission(context)) {
            return false;
        }
        try {
            Method declaredMethod = BluetoothDevice.class.getDeclaredMethod("createBond", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(bluetoothDevice, Integer.valueOf(i9));
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Exception e9) {
            e9.printStackTrace();
            return false;
        }
    }

    public static boolean deviceEquals(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
        return (bluetoothDevice == null || bluetoothDevice2 == null || !bluetoothDevice.getAddress().equals(bluetoothDevice2.getAddress())) ? false : true;
    }

    public static boolean deviceHasProfile(BluetoothDevice bluetoothDevice, UUID uuid) {
        return deviceHasProfile(CommonUtil.getMainContext(), bluetoothDevice, uuid);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean disconnectDeviceA2dp(Context context, BluetoothA2dp bluetoothA2dp, BluetoothDevice bluetoothDevice) {
        if (bluetoothA2dp != null && bluetoothDevice != null && CommonUtil.checkHasConnectPermission(context)) {
            try {
                Method method = bluetoothA2dp.getClass().getMethod("disconnect", BluetoothDevice.class);
                method.setAccessible(true);
                Object objInvoke = method.invoke(bluetoothA2dp, bluetoothDevice);
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                return false;
            } catch (Exception e9) {
                JL_Log.e(f16321a, "disconnectDeviceA2dp", "have an exception : " + e9);
                e9.printStackTrace();
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean disconnectDeviceHfp(Context context, BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice) {
        if (bluetoothHeadset != null && bluetoothDevice != null && CommonUtil.checkHasConnectPermission(context)) {
            try {
                Method method = bluetoothHeadset.getClass().getMethod("disconnect", BluetoothDevice.class);
                method.setAccessible(true);
                Object objInvoke = method.invoke(bluetoothHeadset, bluetoothDevice);
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                return false;
            } catch (Exception e9) {
                JL_Log.e(f16321a, "disconnectFromHfp", "have an exception : " + e9);
                e9.printStackTrace();
            }
        }
        return false;
    }

    @SuppressLint({"DiscouragedPrivateApi", "MissingPermission"})
    public static int getBtAdapterConnectionState(Context context, BluetoothAdapter bluetoothAdapter) {
        if (CommonUtil.checkHasConnectPermission(context) && bluetoothAdapter != null) {
            try {
                Method declaredMethod = bluetoothAdapter.getClass().getDeclaredMethod("getConnectionState", null);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(bluetoothAdapter, null);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
                return -1;
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        return -1;
    }

    public static Method getDeclaredMethod() {
        return Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
    }

    @SuppressLint({"MissingPermission"})
    public static int getPriority(Context context, BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice) {
        if (bluetoothProfile != null && bluetoothDevice != null && CommonUtil.checkHasConnectPermission(context)) {
            try {
                Method method = (Method) getDeclaredMethod().invoke(bluetoothProfile.getClass(), "getPriority", new Class[]{BluetoothDevice.class});
                if (method == null) {
                    return 0;
                }
                Object objInvoke = method.invoke(bluetoothProfile, bluetoothDevice);
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
                return 0;
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        return 0;
    }

    public static BluetoothDevice getRemoteDevice(String str) {
        BluetoothAdapter defaultAdapter;
        if (!CHexConver.checkBluetoothAddress(str) || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
            return null;
        }
        try {
            return defaultAdapter.getRemoteDevice(str);
        } catch (Exception e9) {
            e9.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static List<BluetoothDevice> getSystemConnectedBtDeviceList(Context context) {
        if (!CommonUtil.checkHasConnectPermission(context)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            int btAdapterConnectionState = getBtAdapterConnectionState(context, defaultAdapter);
            if (btAdapterConnectionState == 2 || btAdapterConnectionState == 0) {
                for (BluetoothDevice bluetoothDevice : defaultAdapter.getBondedDevices()) {
                    if (isBTConnected(context, bluetoothDevice)) {
                        arrayList.add(bluetoothDevice);
                    }
                }
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static boolean hasBle(Context context) {
        return context != null && context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public static String hexDataCovetToAddress(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr != null && bArr.length == 6) {
            for (int i9 = 0; i9 < bArr.length; i9++) {
                char[] cArr = f16322b;
                sb.append(cArr[(bArr[i9] & 255) >> 4]);
                sb.append(cArr[bArr[i9] & 15]);
                if (i9 != bArr.length - 1) {
                    sb.append(Constants.COLON_SEPARATOR);
                }
            }
        }
        return sb.toString();
    }

    public static byte[] hexStringCovertToByteArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 * 2;
            int i11 = i10 + 2;
            if (i11 <= str.length()) {
                try {
                    bArr[i9] = (byte) Integer.valueOf(str.substring(i10, i11), 16).intValue();
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return null;
                }
            }
        }
        return bArr;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBTConnected(Context context, BluetoothDevice bluetoothDevice) {
        if (CommonUtil.checkHasConnectPermission(context) && bluetoothDevice != null) {
            try {
                Object objInvoke = bluetoothDevice.getClass().getDeclaredMethod("isConnected", null).invoke(bluetoothDevice, null);
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                return false;
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBluetoothEnable() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    @SuppressLint({"MissingPermission"})
    public static void printBleGattServices(Context context, BluetoothDevice bluetoothDevice, BluetoothGatt bluetoothGatt, int i9) {
        if (bluetoothDevice == null || bluetoothGatt == null || !CommonUtil.checkHasConnectPermission(context)) {
            return;
        }
        StringBuilder sb = new StringBuilder(CommonUtil.formatString("\n[[====\tBluetooth[%s], status[%d]\t====]]\n", printBtDeviceInfo(context, bluetoothDevice), Integer.valueOf(i9)));
        List<BluetoothGattService> services = bluetoothGatt.getServices();
        if (services != null) {
            sb.append(CommonUtil.formatString("[[====\tService Size: [%d]\t====]]\n", Integer.valueOf(services.size())));
            for (BluetoothGattService bluetoothGattService : services) {
                if (bluetoothGattService != null) {
                    sb.append(CommonUtil.formatString("[[====\tService: [%s]\t====]]\n", UuidUtil.read16BitUUID(bluetoothGattService.getUuid())));
                    List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                    if (characteristics != null) {
                        sb.append(CommonUtil.formatString("[[[[====\tCharacteristics Size: [%d]\t====]]]]\n", Integer.valueOf(characteristics.size())));
                        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                            if (bluetoothGattCharacteristic != null) {
                                sb.append(CommonUtil.formatString("[[[[====\tCharacteristic: [%s], %s\t====]]]]\n", UuidUtil.read16BitUUID(bluetoothGattCharacteristic.getUuid()), a(bluetoothGattCharacteristic.getProperties())));
                                List<BluetoothGattDescriptor> descriptors = bluetoothGattCharacteristic.getDescriptors();
                                if (descriptors != null) {
                                    sb.append(CommonUtil.formatString("[[[[[[====\tDescriptors Size: [%d]\t====]]]]]]\n", Integer.valueOf(descriptors.size())));
                                    for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                        if (bluetoothGattDescriptor != null) {
                                            sb.append(CommonUtil.formatString("[[[[[[====\tDescriptor: [%s], value : [%s]\t====]]]]]]\n", UuidUtil.read16BitUUID(bluetoothGattDescriptor.getUuid()), CHexConver.byte2HexStr(bluetoothGattDescriptor.getValue())));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        sb.append(CommonUtil.formatString("[[====\tBluetooth[%s] Services show End\t====]]", printBtDeviceInfo(context, bluetoothDevice)));
        JL_Log.d(f16321a, "printBleGattServices", sb.toString());
    }

    public static String printBoundState(int i9) {
        switch (i9) {
            case 10:
                return "BOND_NONE(10)";
            case 11:
                return "BOND_BONDING(11)";
            case 12:
                return "BOND_BONDED(12)";
            default:
                return f.b(i9, "UNKNOWN_BOUND_STATE(", ")");
        }
    }

    public static String printBtConnectionState(int i9) {
        if (i9 == 0) {
            return "STATE_DISCONNECTED(0)";
        }
        if (i9 == 1) {
            return "STATE_CONNECTING(1)";
        }
        if (i9 != 2) {
            return i9 != 3 ? f.b(i9, "UNKNOWN_STATE(", ")") : "STATE_DISCONNECTING(3)";
        }
        return "STATE_CONNECTED(2)";
    }

    @Deprecated
    public static String printBtDeviceInfo(BluetoothDevice bluetoothDevice) {
        return printBtDeviceInfo(CommonUtil.getMainContext(), bluetoothDevice);
    }

    public static String printTransport(int i9) {
        if (i9 == 0) {
            return "TRANSPORT_AUTO(0)";
        }
        if (i9 != 1) {
            return i9 != 2 ? e.i(i9, "UNKNOWN_TRANSPORT = ") : "TRANSPORT_LE(2)";
        }
        return "TRANSPORT_BREDR(1)";
    }

    public static boolean refreshBleDeviceCache(Context context, BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null && CommonUtil.checkHasConnectPermission(context)) {
            try {
                Method method = bluetoothGatt.getClass().getMethod("refresh", null);
                method.setAccessible(true);
                Object objInvoke = method.invoke(bluetoothGatt, null);
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                return false;
            } catch (Exception e9) {
                JL_Log.e(f16321a, "refreshBleDeviceCache", "Exception : " + e9);
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean removeBond(Context context, BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null && CommonUtil.checkHasConnectPermission(context)) {
            try {
                Object objInvoke = bluetoothDevice.getClass().getMethod("removeBond", null).invoke(bluetoothDevice, null);
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                return false;
            } catch (Exception e9) {
                e9.printStackTrace();
                JL_Log.e(f16321a, "removeBond", "Invoke removeBond : " + e9.getMessage());
            }
        }
        return false;
    }

    public static String reverseAddressString(String str) {
        if (!CHexConver.checkBluetoothAddress(str)) {
            return str;
        }
        if (str.contains(Constants.COLON_SEPARATOR)) {
            str = str.replaceAll(Constants.COLON_SEPARATOR, "");
        }
        byte[] bArrHexStringCovertToByteArray = hexStringCovertToByteArray(str);
        if (bArrHexStringCovertToByteArray == null) {
            return str;
        }
        byte[] bArr = new byte[6];
        int length = bArrHexStringCovertToByteArray.length - 1;
        int i9 = 0;
        while (true) {
            if (!(i9 < bArrHexStringCovertToByteArray.length) || !(length >= 0)) {
                return hexDataCovetToAddress(bArr);
            }
            bArr[i9] = bArrHexStringCovertToByteArray[length];
            i9++;
            length--;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean setPriority(Context context, BluetoothProfile bluetoothProfile, BluetoothDevice bluetoothDevice, int i9) {
        if (bluetoothProfile != null && bluetoothDevice != null && CommonUtil.checkHasConnectPermission(context)) {
            try {
                Method method = (Method) getDeclaredMethod().invoke(bluetoothProfile.getClass(), "setPriority", new Class[]{BluetoothDevice.class, Integer.TYPE});
                if (method == null) {
                    return false;
                }
                Object objInvoke = method.invoke(bluetoothProfile, bluetoothDevice, Integer.valueOf(i9));
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                return false;
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        return false;
    }

    private static String a(int i9) {
        StringBuilder sb = new StringBuilder();
        if (a(i9, 1)) {
            sb.append("BROADCAST");
        }
        if (a(i9, 2)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("READ");
        }
        if (a(i9, 4)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("WRITE NO RESPONSE");
        }
        if (a(i9, 8)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("WRITE");
        }
        if (a(i9, 16)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("NOTIFY");
        }
        if (a(i9, 32)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("INDICATE");
        }
        if (a(i9, 64)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("SIGNED WRITE");
        }
        if (a(i9, 128)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("EXTENDED PROPS");
        }
        return sb.toString();
    }

    @SuppressLint({"MissingPermission"})
    public static boolean deviceHasProfile(Context context, BluetoothDevice bluetoothDevice, UUID uuid) {
        ParcelUuid[] uuids;
        if (!isBluetoothEnable() || bluetoothDevice == null || uuid == null || TextUtils.isEmpty(uuid.toString()) || !CommonUtil.checkHasConnectPermission(context) || (uuids = bluetoothDevice.getUuids()) == null) {
            return false;
        }
        for (ParcelUuid parcelUuid : uuids) {
            if (parcelUuid != null && uuid.toString().equalsIgnoreCase(parcelUuid.toString())) {
                return true;
            }
        }
        return false;
    }

    public static String printBtDeviceInfo(Context context, BluetoothDevice bluetoothDevice) {
        return printBtDeviceInfo(context, bluetoothDevice, true);
    }

    @SuppressLint({"MissingPermission"})
    public static String printBtDeviceInfo(Context context, BluetoothDevice bluetoothDevice, boolean z8) {
        if (bluetoothDevice == null) {
            return "null";
        }
        if (z8) {
            if (!CommonUtil.checkHasConnectPermission(context)) {
                return bluetoothDevice.getAddress();
            }
            return "name : " + bluetoothDevice.getName() + ", type : " + bluetoothDevice.getType() + ", address : " + bluetoothDevice.getAddress();
        }
        return bluetoothDevice.getAddress();
    }

    public static boolean createBond(BluetoothDevice bluetoothDevice) {
        return createBond(CommonUtil.getMainContext(), bluetoothDevice);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean createBond(Context context, BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null || !CommonUtil.checkHasConnectPermission(context)) {
            return false;
        }
        return bluetoothDevice.createBond();
    }
}
