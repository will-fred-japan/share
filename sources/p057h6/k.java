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
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p049g6.n;

/* JADX INFO: compiled from: StorageCipherImplementationAES18.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cipher f19109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SecureRandom f19110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Key f19111d;

    public k(Context context, a aVar, n nVar) {
        String strC = nVar.c();
        this.f19108a = strC;
        SecureRandom secureRandom = new SecureRandom();
        this.f19110c = secureRandom;
        SharedPreferences sharedPreferences = context.getSharedPreferences(strC, 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        String string = sharedPreferences.getString("VGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", null);
        this.f19109b = Cipher.getInstance("AES/CBC/PKCS7Padding");
        if (string != null) {
            this.f19111d = aVar.c(Base64.decode(string, 0));
            return;
        }
        byte[] bArr = new byte[16];
        secureRandom.nextBytes(bArr);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f19111d = secretKeySpec;
        editorEdit.putString("VGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", Base64.encodeToString(aVar.a(secretKeySpec), 0));
        editorEdit.apply();
    }

    @Override // p057h6.h
    public final byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[16];
        this.f19110c.nextBytes(bArr2);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Key key = this.f19111d;
        Cipher cipher = this.f19109b;
        cipher.init(1, key, ivParameterSpec);
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        byte[] bArr3 = new byte[bArrDoFinal.length + 16];
        System.arraycopy(bArr2, 0, bArr3, 0, 16);
        System.arraycopy(bArrDoFinal, 0, bArr3, 16, bArrDoFinal.length);
        return bArr3;
    }

    @Override // p057h6.h
    public final void b(Context context) {
        context.getSharedPreferences(this.f19108a, 0).edit().remove("VGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK").apply();
    }

    @Override // p057h6.h
    public final byte[] c(byte[] bArr) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        int length = bArr.length - 16;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 16, bArr3, 0, length);
        Key key = this.f19111d;
        Cipher cipher = this.f19109b;
        cipher.init(2, key, ivParameterSpec);
        return cipher.doFinal(bArr3);
    }
}
