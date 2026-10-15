package Z2;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* JADX INFO: compiled from: UrlUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e9) {
            throw new IllegalArgumentException(e9);
        }
    }

    public static String b(String str, Map<String, String> map) {
        if (!TextUtils.isDigitsOnly(str) && map != null && !map.isEmpty()) {
            if (str.indexOf("?") < 0) {
                str = str.concat("?");
            }
            if (str.endsWith("?")) {
                StringBuilder sbB = p171w.a.b(str);
                sbB.append(a(HianalyticsBaseData.SDK_VERSION));
                sbB.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sbB.append(a(String.valueOf(1)));
                str = sbB.toString();
            } else {
                StringBuilder sbC = p171w.a.c(str, ContainerUtils.FIELD_DELIMITER);
                sbC.append(a(HianalyticsBaseData.SDK_VERSION));
                sbC.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sbC.append(a(String.valueOf(1)));
                str = sbC.toString();
            }
            if (map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (map.get(entry.getKey()) != null) {
                        if (str.endsWith("?")) {
                            StringBuilder sbB2 = p171w.a.b(str);
                            sbB2.append(a(entry.getKey().toString()));
                            sbB2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sbB2.append(a(map.get(entry.getKey()).toString()));
                            str = sbB2.toString();
                        } else {
                            StringBuilder sbC2 = p171w.a.c(str, ContainerUtils.FIELD_DELIMITER);
                            sbC2.append(a(entry.getKey().toString()));
                            sbC2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                            sbC2.append(a(map.get(entry.getKey()).toString()));
                            str = sbC2.toString();
                        }
                    }
                }
            }
        }
        return str;
    }
}
