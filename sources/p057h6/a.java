package p057h6;

import android.content.Context;
import java.security.Key;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: KeyCipher.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    byte[] a(Key key);

    Cipher b(Context context);

    Key c(byte[] bArr);

    void d();
}
