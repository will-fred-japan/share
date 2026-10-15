package Q;

import java.util.Comparator;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = (byte[]) obj2;
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i9 = 0; i9 < bArr.length; i9++) {
            byte b9 = bArr[i9];
            byte b10 = bArr2[i9];
            if (b9 != b10) {
                return b9 - b10;
            }
        }
        return 0;
    }
}
