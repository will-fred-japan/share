package p057h6;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p049g6.n;

/* JADX INFO: compiled from: StorageCipherImplementationAES23.java */
/* JADX INFO: loaded from: classes.dex */
public final class l implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cipher f19113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SecureRandom f19114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SecretKeySpec f19115d;

    public l(Context context, Cipher cipher, n nVar) throws BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKeySpec;
        String strC = nVar.c();
        this.f19112a = strC;
        SecureRandom secureRandom = new SecureRandom();
        this.f19114c = secureRandom;
        cipher = cipher == null ? Cipher.getInstance("AES/GCM/NoPadding") : cipher;
        SharedPreferences sharedPreferences = context.getSharedPreferences(strC, 0);
        String string = sharedPreferences.getString("BVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", null);
        if (string != null) {
            secretKeySpec = new SecretKeySpec(cipher.doFinal(Base64.decode(string, 0)), "AES");
        } else {
            byte[] bArr = new byte[32];
            secureRandom.nextBytes(bArr);
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(bArr, "AES");
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("BVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK", Base64.encodeToString(bArrDoFinal, 0));
            editorEdit.apply();
            secretKeySpec = secretKeySpec2;
        }
        this.f19115d = secretKeySpec;
        this.f19113b = Cipher.getInstance("AES/GCM/NoPadding");
    }

    @Override // p057h6.h
    public final byte[] a(byte[] bArr) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[12];
        this.f19114c.nextBytes(bArr2);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr2);
        Cipher cipher = this.f19113b;
        cipher.init(1, this.f19115d, gCMParameterSpec);
        byte[] bArrDoFinal = cipher.doFinal(bArr);
        byte[] bArr3 = new byte[bArrDoFinal.length + 12];
        System.arraycopy(bArr2, 0, bArr3, 0, 12);
        System.arraycopy(bArrDoFinal, 0, bArr3, 12, bArrDoFinal.length);
        return bArr3;
    }

    @Override // p057h6.h
    public final void b(Context context) {
        context.getSharedPreferences(this.f19112a, 0).edit().remove("BVGhpcyBpcyB0aGUga2V5IGZvciBhIHNlY3VyZSBzdG9yYWdlIEFFUyBLZXkK").apply();
    }

    @Override // p057h6.h
    public final byte[] c(byte[] bArr) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        int length = bArr.length - 12;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 12, bArr3, 0, length);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr2);
        Cipher cipher = this.f19113b;
        cipher.init(2, this.f19115d, gCMParameterSpec);
        return cipher.doFinal(bArr3);
    }
}
