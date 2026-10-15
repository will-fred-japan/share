package com.starburst.sdk.common.okhttp.cookie.store;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import okhttp3.Cookie;

/* JADX INFO: loaded from: classes.dex */
public class SerializableHttpCookie implements Serializable {
    private static final long serialVersionUID = 6374381323722046732L;
    private transient Cookie clientCookie;
    private final transient Cookie cookie;

    public SerializableHttpCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        String str = (String) objectInputStream.readObject();
        String str2 = (String) objectInputStream.readObject();
        long j = objectInputStream.readLong();
        String str3 = (String) objectInputStream.readObject();
        String str4 = (String) objectInputStream.readObject();
        boolean z8 = objectInputStream.readBoolean();
        boolean z9 = objectInputStream.readBoolean();
        boolean z10 = objectInputStream.readBoolean();
        objectInputStream.readBoolean();
        Cookie.Builder builderExpiresAt = new Cookie.Builder().name(str).value(str2).expiresAt(j);
        Cookie.Builder builderPath = (z10 ? builderExpiresAt.hostOnlyDomain(str3) : builderExpiresAt.domain(str3)).path(str4);
        if (z8) {
            builderPath = builderPath.secure();
        }
        if (z9) {
            builderPath = builderPath.httpOnly();
        }
        this.clientCookie = builderPath.build();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.cookie.name());
        objectOutputStream.writeObject(this.cookie.value());
        objectOutputStream.writeLong(this.cookie.expiresAt());
        objectOutputStream.writeObject(this.cookie.domain());
        objectOutputStream.writeObject(this.cookie.path());
        objectOutputStream.writeBoolean(this.cookie.secure());
        objectOutputStream.writeBoolean(this.cookie.httpOnly());
        objectOutputStream.writeBoolean(this.cookie.hostOnly());
        objectOutputStream.writeBoolean(this.cookie.persistent());
    }

    public Cookie getCookie() {
        Cookie cookie = this.cookie;
        Cookie cookie2 = this.clientCookie;
        return cookie2 != null ? cookie2 : cookie;
    }
}
