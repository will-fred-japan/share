package com.starburst.sdk.core.device.bt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConnectedDeviceManager {
    private static volatile ConnectedDeviceManager instance;
    private final Object lock = new Object();
    private final List<BluetoothDeviceBean> deviceList = new ArrayList();

    private ConnectedDeviceManager() {
    }

    public static ConnectedDeviceManager getInstance() {
        if (instance == null) {
            synchronized (ConnectedDeviceManager.class) {
                try {
                    if (instance == null) {
                        instance = new ConnectedDeviceManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public void addDevice(BluetoothDeviceBean bluetoothDeviceBean) {
        BluetoothDeviceBean next;
        if (bluetoothDeviceBean == null) {
            return;
        }
        synchronized (this.lock) {
            try {
                String deviceId = bluetoothDeviceBean.getDeviceId();
                if (deviceId == null) {
                    next = null;
                    break;
                }
                Iterator<BluetoothDeviceBean> it = this.deviceList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next != null && deviceId.equals(next.getDeviceId())) {
                        break;
                    }
                }
                BluetoothDeviceBean bluetoothDeviceBean2 = next != null ? next : bluetoothDeviceBean;
                if (next != null) {
                    bluetoothDeviceBean2.setDeviceName(bluetoothDeviceBean.getDeviceName());
                    bluetoothDeviceBean2.setDeviceType(bluetoothDeviceBean.getDeviceType());
                } else {
                    this.deviceList.add(bluetoothDeviceBean2);
                }
                if (bluetoothDeviceBean2.getDeviceType() == null) {
                    bluetoothDeviceBean2.setDeviceType(BluetoothDeviceType.SLAVE);
                }
                if (bluetoothDeviceBean2.getDeviceType() == BluetoothDeviceType.MASTER) {
                    for (BluetoothDeviceBean bluetoothDeviceBean3 : this.deviceList) {
                        if (bluetoothDeviceBean3 != null && bluetoothDeviceBean3 != bluetoothDeviceBean2) {
                            bluetoothDeviceBean3.setDeviceType(BluetoothDeviceType.SLAVE);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getConnectedDeviceCount() {
        int size;
        synchronized (this.lock) {
            size = this.deviceList.size();
        }
        return size;
    }

    public List<BluetoothDeviceBean> getDeviceList() {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.deviceList);
        }
        return arrayList;
    }

    public BluetoothDeviceBean getMasterDevice() {
        synchronized (this.lock) {
            try {
                if (this.deviceList.isEmpty()) {
                    return null;
                }
                for (BluetoothDeviceBean bluetoothDeviceBean : this.deviceList) {
                    if (bluetoothDeviceBean.getDeviceType() == BluetoothDeviceType.MASTER) {
                        return bluetoothDeviceBean;
                    }
                }
                return this.deviceList.get(0);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public BluetoothDeviceBean getMobileDevice() {
        return new BluetoothDeviceBean("mobile device", BluetoothDeviceType.MASTER);
    }

    public List<BluetoothDeviceBean> getSlaveDevices() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.lock) {
            try {
                for (BluetoothDeviceBean bluetoothDeviceBean : this.deviceList) {
                    if (bluetoothDeviceBean.getDeviceType() == BluetoothDeviceType.SLAVE) {
                        arrayList.add(bluetoothDeviceBean);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public void removeDevice(BluetoothDeviceBean bluetoothDeviceBean) {
        synchronized (this.lock) {
            this.deviceList.remove(bluetoothDeviceBean);
        }
    }

    public BluetoothDeviceBean removeDeviceByDeviceId(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.lock) {
            for (int i9 = 0; i9 < this.deviceList.size(); i9++) {
                try {
                    BluetoothDeviceBean bluetoothDeviceBean = this.deviceList.get(i9);
                    if (bluetoothDeviceBean != null && str.equals(bluetoothDeviceBean.getDeviceId())) {
                        this.deviceList.remove(i9);
                        return bluetoothDeviceBean;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        }
    }

    public boolean setMasterDevice(BluetoothDeviceBean bluetoothDeviceBean) {
        if (bluetoothDeviceBean == null) {
            return false;
        }
        synchronized (this.lock) {
            try {
                for (BluetoothDeviceBean bluetoothDeviceBean2 : this.deviceList) {
                    if (bluetoothDeviceBean2 != bluetoothDeviceBean && (bluetoothDeviceBean2 == null || bluetoothDeviceBean.getDeviceId() == null || !bluetoothDeviceBean.getDeviceId().equals(bluetoothDeviceBean2.getDeviceId()))) {
                    }
                }
                this.deviceList.add(bluetoothDeviceBean);
            } catch (Throwable th) {
                throw th;
            }
        }
        return setMasterDeviceByDeviceId(bluetoothDeviceBean.getDeviceId());
    }

    public boolean setMasterDeviceByDeviceId(String str) {
        boolean z8 = false;
        if (str == null) {
            return false;
        }
        synchronized (this.lock) {
            try {
                for (BluetoothDeviceBean bluetoothDeviceBean : this.deviceList) {
                    if (bluetoothDeviceBean != null) {
                        if (str.equals(bluetoothDeviceBean.getDeviceId())) {
                            bluetoothDeviceBean.setDeviceType(BluetoothDeviceType.MASTER);
                            z8 = true;
                        } else {
                            bluetoothDeviceBean.setDeviceType(BluetoothDeviceType.SLAVE);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z8;
    }
}
