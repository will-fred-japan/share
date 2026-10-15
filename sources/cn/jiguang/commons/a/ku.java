package cn.jiguang.commons.a;

import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ku {
    private static long a(List<ad> list, String str) {
        long j = 0;
        if (list != null && !list.isEmpty()) {
            for (ad adVar : list) {
                try {
                    if (!TextUtils.isEmpty(adVar.f9618d) && adVar.f9618d.contains(str)) {
                        long j8 = adVar.f9621g;
                        if (j8 > j) {
                            j = j8;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return j;
    }

    public static HashMap<String, v> a() {
        HashMap<String, v> map = new HashMap<>();
        try {
            List listC = bu.a().c(MTPushConstants.Message.CODE_CLICK_EVENT_MATCH, false);
            if (listC != null) {
                listC.isEmpty();
            }
        } catch (Throwable unused) {
        }
        return map;
    }
}
