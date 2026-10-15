package cn.jiguang.commons.a;

import android.util.SparseArray;
import cn.jpush.android.data.JPushCollectControl;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.heytap.msp.push.callback.INotificationPermissionCallback;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<Integer> f9720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f9721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Long> f9722c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Integer> f9723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseArray<List<Integer>> f9724e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Set<Integer> f9725f;

    static {
        SparseArray<Integer> sparseArray = new SparseArray<>(80);
        sparseArray.put(1001, 1);
        sparseArray.put(MTCommonConstants.MainWhat.ON_ACTIVITY_CREATED, 1);
        sparseArray.put(1013, 1);
        sparseArray.put(MTCommonConstants.MainWhat.ON_ACTIVITY_STOPPED, 1);
        sparseArray.put(1002, 1);
        sparseArray.put(MTCommonConstants.MainWhat.ON_ACTIVITY_PAUSED, 1);
        sparseArray.put(MTCommonConstants.MainWhat.ON_NETWORK_CHANGED, 1);
        sparseArray.put(2001, 1);
        sparseArray.put(MTCommonConstants.MainWhat.ON_FRAGMENT_RESUMED, 1);
        sparseArray.put(1026, 1);
        sparseArray.put(1020, 1);
        sparseArray.put(1036, 1);
        sparseArray.put(1009, 1);
        sparseArray.put(MTCommonConstants.MainWhat.ON_UPDATE_LOG_CACHE_CONFIG, 1);
        sparseArray.put(1900, 1);
        sparseArray.put(1901, 1);
        sparseArray.put(1030, 1);
        sparseArray.put(1031, 1);
        sparseArray.put(1032, 1);
        sparseArray.put(1029, 1);
        sparseArray.put(2500, 1);
        sparseArray.put(1027, 1);
        sparseArray.put(INotificationPermissionCallback.CODE_FREQUENT, 1);
        sparseArray.put(INotificationPermissionCallback.CODE_UNSUPPORT, 1);
        sparseArray.put(1012, 1);
        sparseArray.put(1022, 1);
        sparseArray.put(1005, 1);
        sparseArray.put(1040, 1);
        Integer numValueOf = Integer.valueOf(MTPushConstants.Message.CODE_CLICK_EVENT_MATCH);
        sparseArray.put(MTPushConstants.Message.CODE_CLICK_EVENT_MATCH, 2);
        sparseArray.put(1110, 2);
        sparseArray.put(JPushCollectControl.IMSI, 3);
        sparseArray.put(1605, 3);
        sparseArray.put(1608, 3);
        sparseArray.put(1601, 3);
        sparseArray.put(1610, 3);
        sparseArray.put(1508, 3);
        sparseArray.put(1611, 3);
        sparseArray.put(1602, 3);
        sparseArray.put(1604, 3);
        sparseArray.put(1603, 3);
        sparseArray.put(1606, 3);
        sparseArray.put(1609, 3);
        sparseArray.put(1607, 3);
        sparseArray.put(1800, 3);
        sparseArray.put(1503, 3);
        sparseArray.put(1507, 3);
        sparseArray.put(1506, 3);
        sparseArray.put(1509, 3);
        sparseArray.put(1102, 3);
        sparseArray.put(1615, 3);
        sparseArray.put(2800, 4);
        sparseArray.put(1502, 4);
        sparseArray.put(1505, 4);
        sparseArray.put(1501, 4);
        sparseArray.put(1504, 4);
        sparseArray.put(1114, 4);
        sparseArray.put(MTPushConstants.Message.CODE_MESSAGE_ARRIVED, 4);
        sparseArray.put(2201, 4);
        sparseArray.put(1109, 4);
        sparseArray.put(1101, 4);
        sparseArray.put(2801, 4);
        sparseArray.put(1035, 4);
        sparseArray.put(1037, 4);
        sparseArray.put(1105, 4);
        sparseArray.put(1039, 4);
        sparseArray.put(1113, 4);
        sparseArray.put(1034, 4);
        sparseArray.put(1033, 4);
        sparseArray.put(1200, 4);
        sparseArray.put(MTPushConstants.Message.CODE_MESSAGE_DELETED, 4);
        sparseArray.put(1612, 4);
        sparseArray.put(1614, 4);
        sparseArray.put(1613, 4);
        sparseArray.put(2100, 4);
        sparseArray.put(2300, 4);
        sparseArray.put(3100, 4);
        sparseArray.put(3101, 4);
        f9720a = sparseArray;
        SparseArray<List<Integer>> sparseArray2 = new SparseArray<>(4);
        sparseArray2.put(1, new ArrayList(30));
        sparseArray2.put(2, new ArrayList(5));
        sparseArray2.put(3, new ArrayList(25));
        sparseArray2.put(4, new ArrayList(30));
        int i9 = 0;
        while (true) {
            SparseArray<Integer> sparseArray3 = f9720a;
            if (i9 >= sparseArray3.size()) {
                f9724e = sparseArray2;
                HashMap map = new HashMap();
                map.put("JAppList", numValueOf);
                W5.e.p(1110, map, "JAppListFile", 1103, "JAppSDK");
                map.put("JAppMovement", 1101);
                map.put("JAppRunning", 1102);
                map.put("JAppProbe", 1106);
                W5.e.p(1104, map, "JAppActive", 1112, "JAppActiveFile");
                W5.e.p(BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT, map, "JDeviceIdMap", 1600, "JArp");
                W5.e.p(2700, map, "JDeviceMac", 1500, "JLocation");
                W5.e.p(1500, map, "JLocationv2", 1000, "JDevice");
                W5.e.p(1200, map, "JBattery", MTCommonConstants.MainWhat.ON_LIFECYCLE_CHANGED, "JDeviceIds");
                W5.e.p(2800, map, "JDeviceIp", 2900, "JDeviceScreen");
                W5.e.p(1300, map, "JAppPermission", 2400, "JBluetooth");
                f9721b = map;
                HashMap map2 = new HashMap();
                map2.put("JLocationv2", 30000L);
                f9722c = map2;
                f9723d = Arrays.asList(numValueOf, 1101, 1102, 1104, 1112);
                HashSet hashSet = new HashSet(20);
                hashSet.addAll(map.values());
                hashSet.add(2403);
                hashSet.add(2404);
                hashSet.add(2401);
                hashSet.add(2402);
                f9725f = hashSet;
                return;
            }
            sparseArray2.get(sparseArray3.valueAt(i9).intValue()).add(Integer.valueOf(sparseArray3.keyAt(i9)));
            i9++;
        }
    }

    public static int a() {
        return f9720a.size();
    }

    public static List<Integer> b(int i9) {
        List<Integer> list = f9724e.get(i9);
        return list != null ? list : new ArrayList();
    }

    public static boolean c(int i9) {
        return f9720a.indexOfKey(i9) >= 0 || f9725f.contains(Integer.valueOf(i9));
    }

    public static int a(int i9) {
        return f9720a.get(i9, 0).intValue();
    }
}
