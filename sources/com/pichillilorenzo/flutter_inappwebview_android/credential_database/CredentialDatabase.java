package com.pichillilorenzo.flutter_inappwebview_android.credential_database;

import android.content.Context;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLCredential;
import com.pichillilorenzo.flutter_inappwebview_android.types.URLProtectionSpace;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CredentialDatabase {
    public static final String DATABASE_NAME = "CredentialDatabase.db";
    public static final int DATABASE_VERSION = 2;
    static final String LOG_TAG = "CredentialDatabase";
    private static CredentialDatabase instance;
    public URLCredentialDao credentialDao;
    public CredentialDatabaseHelper db;
    public URLProtectionSpaceDao protectionSpaceDao;

    private CredentialDatabase() {
    }

    public static CredentialDatabase getInstance(Context context) {
        CredentialDatabase credentialDatabase = instance;
        if (credentialDatabase != null) {
            return credentialDatabase;
        }
        CredentialDatabaseHelper credentialDatabaseHelper = new CredentialDatabaseHelper(context);
        CredentialDatabase credentialDatabase2 = new CredentialDatabase(credentialDatabaseHelper, new URLProtectionSpaceDao(credentialDatabaseHelper), new URLCredentialDao(credentialDatabaseHelper));
        instance = credentialDatabase2;
        return credentialDatabase2;
    }

    public void clearAllAuthCredentials() {
        CredentialDatabaseHelper credentialDatabaseHelper = this.db;
        credentialDatabaseHelper.clearAllTables(credentialDatabaseHelper.getWritableDatabase());
    }

    public List<URLCredential> getHttpAuthCredentials(String str, String str2, String str3, Integer num) {
        ArrayList arrayList = new ArrayList();
        URLProtectionSpace uRLProtectionSpaceFind = this.protectionSpaceDao.find(str, str2, str3, num);
        return uRLProtectionSpaceFind != null ? this.credentialDao.getAllByProtectionSpaceId(uRLProtectionSpaceFind.getId()) : arrayList;
    }

    public void removeHttpAuthCredential(String str, String str2, String str3, Integer num, String str4, String str5) {
        URLProtectionSpace uRLProtectionSpaceFind = this.protectionSpaceDao.find(str, str2, str3, num);
        if (uRLProtectionSpaceFind != null) {
            this.credentialDao.delete(this.credentialDao.find(str4, str5, uRLProtectionSpaceFind.getId()));
        }
    }

    public void removeHttpAuthCredentials(String str, String str2, String str3, Integer num) {
        URLProtectionSpace uRLProtectionSpaceFind = this.protectionSpaceDao.find(str, str2, str3, num);
        if (uRLProtectionSpaceFind != null) {
            this.protectionSpaceDao.delete(uRLProtectionSpaceFind);
        }
    }

    public void setHttpAuthCredential(String str, String str2, String str3, Integer num, String str4, String str5) {
        boolean z8;
        URLProtectionSpace uRLProtectionSpaceFind = this.protectionSpaceDao.find(str, str2, str3, num);
        Long lValueOf = uRLProtectionSpaceFind == null ? Long.valueOf(this.protectionSpaceDao.insert(new URLProtectionSpace(null, str, str2, str3, num.intValue()))) : uRLProtectionSpaceFind.getId();
        URLCredential uRLCredentialFind = this.credentialDao.find(str4, str5, lValueOf);
        if (uRLCredentialFind == null) {
            URLCredential uRLCredential = new URLCredential(null, str4, str5, lValueOf);
            uRLCredential.setId(Long.valueOf(this.credentialDao.insert(uRLCredential)));
            return;
        }
        boolean z9 = true;
        if (uRLCredentialFind.getUsername().equals(str4)) {
            z8 = false;
        } else {
            uRLCredentialFind.setUsername(str4);
            z8 = true;
        }
        if (uRLCredentialFind.getPassword().equals(str5)) {
            z9 = z8;
        } else {
            uRLCredentialFind.setPassword(str5);
        }
        if (z9) {
            this.credentialDao.update(uRLCredentialFind);
        }
    }

    private CredentialDatabase(CredentialDatabaseHelper credentialDatabaseHelper, URLProtectionSpaceDao uRLProtectionSpaceDao, URLCredentialDao uRLCredentialDao) {
        this.db = credentialDatabaseHelper;
        this.protectionSpaceDao = uRLProtectionSpaceDao;
        this.credentialDao = uRLCredentialDao;
    }
}
