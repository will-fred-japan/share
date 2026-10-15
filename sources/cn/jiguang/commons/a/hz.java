package cn.jiguang.commons.a;

import android.telephony.CellInfo;
import android.text.TextUtils;
import com.jieli.jl_bt_ota.constant.BluetoothConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class hz {
    private hz() {
    }

    public static List<z> a(boolean z8) {
        ey eyVarB;
        int iValueOf;
        z zVarA;
        ee.a("JLocationCell", "collect:cmd=" + z8);
        ArrayList arrayList = new ArrayList();
        try {
            List<CellInfo> listC = bu.a().c(1501, z8);
            StringBuilder sb = new StringBuilder("ret:");
            sb.append(listC == null ? 0 : listC.size());
            ee.a("JLocationCell", sb.toString());
            if (listC != null && !listC.isEmpty()) {
                String strB = bu.a().b(1506, z8);
                String strB2 = bu.a().b(1507, z8);
                ee.a("JLocationCell", "opr:" + strB);
                for (CellInfo cellInfo : listC) {
                    if (cellInfo != null && (zVarA = je.a(cellInfo)) != null) {
                        if (TextUtils.equals(zVarA.f10451e, strB)) {
                            zVarA.f10452f = strB2;
                        }
                        arrayList.add(zVarA);
                    }
                }
                if (arrayList.isEmpty()) {
                    eyVarB = ey.b();
                    iValueOf = 3001;
                } else {
                    eyVarB = ey.b();
                    iValueOf = Integer.valueOf(BluetoothConstant.DEFAULT_SEND_CMD_TIMEOUT);
                }
                eyVarB.d(iValueOf);
                return arrayList;
            }
            ee.d("JLocationCell", "no cell");
            ey.b().d((Object) 3001);
            return null;
        } catch (Throwable th) {
            ee.e("JLocationCell", "err:" + th.getMessage());
            ey.b().d((Object) 3002);
            return null;
        }
    }

    public /* synthetic */ hz(byte b9) {
        this();
    }
}
