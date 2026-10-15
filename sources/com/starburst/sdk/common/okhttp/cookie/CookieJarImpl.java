package com.starburst.sdk.common.okhttp.cookie;

import com.starburst.sdk.common.okhttp.cookie.store.CookieStore;
import com.starburst.sdk.common.okhttp.utils.Exceptions;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class CookieJarImpl implements CookieJar {
    private CookieStore cookieStore;

    public CookieJarImpl(CookieStore cookieStore) {
        if (cookieStore == null) {
            Exceptions.illegalArgument("cookieStore can not be null.", new Object[0]);
        }
        this.cookieStore = cookieStore;
    }

    public CookieStore getCookieStore() {
        return this.cookieStore;
    }

    @Override // okhttp3.CookieJar
    public synchronized List<Cookie> loadForRequest(HttpUrl httpUrl) {
        return this.cookieStore.get(httpUrl);
    }

    @Override // okhttp3.CookieJar
    public synchronized void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        this.cookieStore.add(httpUrl, list);
    }
}
