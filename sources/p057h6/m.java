package p057h6;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p049g6.n;

/* JADX INFO: compiled from: StorageCipherImplementationGCM.java */
/* JADX INFO: loaded from: classes.dex */
public final class m implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cipher f19117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SecureRandom f19118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Key f19119d;

    public m(Context context, a aVar, n nVar) {
        String strC = nVar.c();
        this.f19116a = strC;
        SecureRandom secureRandom = new SecureRandom();
        this.f19118c = secureRandom;
        SharedPreferences sharedPreferences = context.getSharedPreferences(strC, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String string = sharedPreferences.getString("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", null);
        boolean z8 = string == null && (string = sharedPreferences.getString("VGhpcyBpcyB0aGUga2V5IGZvcihBIHNlY3XyZZBzdG9yYWdlIEFFUyBLZXkK", null)) != null;
        this.f19117b = Cipher.getInstance("AES/GCM/NoPadding");
        if (string != null) {
            this.f19119d = aVar.c(Base64.decode(string, 0));
            if (z8) {
                editorEdit.putString("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", string).apply();
                return;
            }
            return;
        }
        byte[] bArr = new byte[16];
        secureRandom.nextBytes(bArr);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f19119d = secretKeySpec;
        editorEdit.putString("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", Base64.encodeToString(aVar.a(secretKeySpec), 0));
        editorEdit.apply();
    }

    @Override // p057h6.h
    public final byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[12];
        this.f19118c.nextBytes(bArr2);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr2);
        Cipher cipher = this.f19117b;
        cipher.init(1, this.f19119d, gCMParameterSpec);
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        byte[] bArr3 = new byte[bArrDoFinal.length + 12];
        System.arraycopy(bArr2, 0, bArr3, 0, 12);
        System.arraycopy(bArrDoFinal, 0, bArr3, 12, bArrDoFinal.length);
        return bArr3;
    }

    @Override // p057h6.h
    public final void b(Context context) {
        context.getSharedPreferences(this.f19116a, 0).edit().remove("AESVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK").apply();
    }

    @Override // p057h6.h
    public final byte[] c(byte[] bArr) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr2);
        int length = bArr.length - 12;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 12, bArr3, 0, length);
        Cipher cipher = this.f19117b;
        cipher.init(2, this.f19119d, gCMParameterSpec);
        return cipher.doFinal(bArr3);
    }
}
