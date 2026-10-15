package com.huawei.hms.core.aidl;

import W5.e;
import W5.f;
import android.os.Bundle;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MessageCodecV2 extends MessageCodec {
    @Override // com.huawei.hms.core.aidl.MessageCodec
    public List<Object> readList(Type type, Bundle bundle) throws InstantiationException {
        int i9 = bundle.getInt("_list_size_");
        ArrayList arrayList = new ArrayList(i9);
        for (int i10 = 0; i10 < i9; i10++) {
            Object obj = bundle.get("_list_item_" + i10);
            if (obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Serializable)) {
                arrayList.add(obj);
            } else if (obj instanceof Bundle) {
                Bundle bundle2 = (Bundle) obj;
                int i11 = bundle2.getInt("_val_type_", -1);
                if (i11 == 1) {
                    throw new InstantiationException("Nested List can not be supported");
                }
                if (i11 != 0) {
                    throw new InstantiationException("Unknown type can not be supported");
                }
                arrayList.add(decode(bundle2, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else {
                continue;
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.core.aidl.MessageCodec
    public void writeList(String str, List list, Bundle bundle) {
        Bundle bundleJ = f.j(1, "_val_type_");
        bundleJ.putInt("_list_size_", list.size());
        for (int i9 = 0; i9 < list.size(); i9++) {
            writeValue(e.i(i9, "_list_item_"), list.get(i9), bundleJ);
        }
        bundle.putBundle(str, bundleJ);
    }
}
